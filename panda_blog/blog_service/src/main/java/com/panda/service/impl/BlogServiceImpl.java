package com.panda.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.panda.EsConstant;
import com.panda.SortUtil;
import com.panda.common.util.EsUtil;
import com.panda.common.util.FebsConstant;
import com.panda.dao.BlogMapper;
import com.panda.dao.BlogTagsMapper;
import com.panda.pojo.QueryRequest;
import com.panda.pojo.blog.Blog;
import com.panda.pojo.blog.BlogTags;
import com.panda.pojo.blog.User;
import com.panda.service.BlogService;
import com.panda.vo.BlogVo;
import com.panda.vo.EsEntity;
import com.panda.vo.SearchvVo;
import com.panda.vo.es.BlogES;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @Auther: wl
 * @Date: 2019/5/15 15:58
 * @Description: 由于服务器内存2G，开启es占用内存过高，因此注释掉新增、修改、删除es，有需要可以打开。
 */
@Service
@Transactional
public class BlogServiceImpl extends ServiceImpl<BlogMapper, Blog> implements BlogService {

    @Autowired
    private BlogMapper blogMapper;

    @Autowired
    private EsUtil esUtil;

    @Autowired
    private BlogTagsMapper blogTagsMapper;

    @Override
    public int deleteByPrimaryKey(Integer id) {
        // esUtil.deleteByQuery("blog",new TermQueryBuilder("id", id));
        return blogMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(BlogVo record) {

        //修改
        if (record.getId() != null) {
            record.setUpdateTime(new Date());
            int count = blogMapper.updateByPrimaryKey(record);
            if (count <= 0) {
                return 0;
            }
            blogTagsMapper.deleteByBlogId(record.getId());
            if (record.getTags().size() > 0) {
                for (int i = 0; i < record.getTags().size(); i++) {
                    BlogTags blogTags = new BlogTags();
                    blogTags.setBlog_id(record.getId());
                    blogTags.setTag_id(record.getTags().get(i));
                    blogTagsMapper.insert(blogTags);
                }

            }
            //  esUtil.insertOrUpdateOne(EsConstant.BOOKMARK_INDEX,
            //      new EsEntity(record.getId(),new BlogES(record)));
            return 1;
            //新增
        } else {
            record.setCreateTime(new Date());
            record.setUpdateTime(new Date());
            int count = blogMapper.insert(record);
            if (count <= 0) {
                return 0;
            }

            if (record.getTags().size() > 0) {
                for (int i = 0; i < record.getTags().size(); i++) {
                    BlogTags blogTags = new BlogTags();
                    blogTags.setBlog_id(record.getId());
                    blogTags.setTag_id(record.getTags().get(i));
                    blogTagsMapper.insert(blogTags);
                }

            }
            //   esUtil.insertOrUpdateOne(EsConstant.BOOKMARK_INDEX,
            //           new EsEntity(record.getId(),new BlogES(record)));
            return 1;
        }


    }

    @Override
    public BlogVo selectByPrimaryKey(Integer id) {
        Blog blog = blogMapper.selectByPrimaryKey(id);
        BlogVo blogVo = convertBlogToVO(blog);

        //当上一篇或下一篇不存在时，设定id为-1000
        Blog noBlog = new Blog();
        noBlog.setId(-1000);
        noBlog.setTitle("");
        //上一篇 前端显示为倒叙
        Blog last = blogMapper.getNext(id);
        if (null != last) {
            blogVo.setLast(last);
        } else {
            blogVo.setLast(noBlog);
        }
        //下一篇
        Blog next = blogMapper.getLast(id);
        if (null != next) {
            blogVo.setNext(next);
        } else {
            blogVo.setNext(noBlog);
        }
        return blogVo;
    }

    @Override
    public IPage<Blog> selectAll(SearchvVo search, QueryRequest request) {
        Page<User> page = new Page<>();
        SortUtil.handlePageSort(request, page, null, FebsConstant.ORDER_ASC, false);
        IPage<Blog> blogs = blogMapper.selectAll(page, search);
        return blogs;
    }

    @Override
    public int updateByPrimaryKey(Blog record) {
        List<BlogES> blogEs = blogMapper.getBlogEs(0, 20);
        for (BlogES blogE : blogEs) {
            System.out.println(blogE);

        }
        return 1;

    }

    @Override
    public BlogVo selectByid(Integer id) {
        Blog blog = blogMapper.selectById(id);
        List<BlogTags> tags = blogTagsMapper.selectByBlogId(id);
        List<Integer> tagIds = new ArrayList<>();
        for (BlogTags tag : tags) {
            tagIds.add(tag.getTag_id());
        }

        BlogVo blogVo = convertBlogToVO(blog);
        blogVo.setTags(tagIds);


        return blogVo;
    }

    @Override
    public IPage<Blog> selectByTag(Integer pageNum, Integer pageSize, Integer search) {
        Page<User> page = new Page<>();
        return blogMapper.selectByTag(page, search);

    }

    @Override
    public IPage<Blog> selectByCategory(Integer pageNum, Integer pageSize, Integer search) {
        Page<User> page = new Page<>();
        return blogMapper.selectByCategory(page, search);

    }

    @Override
    public IPage<Blog> getBlogByTime(Integer pageNum, Integer pageSize, String search) {
        Page<User> page = new Page<>();
        String s = search.split("年")[1].split("月")[0];
        if (s.length() == 1) {
            s = 0 + s;
        }
        search = search.split("年")[0] + '-' + s;
        return blogMapper.getBlogByTime(page, search);
    }

    @Override
    public List<String> getBlogTime() {
        return blogMapper.getBlogTime();
    }

    /**
     * 同步数据到es
     */
    @Override
    public void syncBlog() {
        //删除 es中的数据
        IPage<Blog> blogs = blogMapper.selectAll(null, null);
        esUtil.deleteBatch(EsConstant.BOOKMARK_INDEX, blogs.getRecords());
        //新增
        int index = 0;
        int size = 500;
        List<EsEntity> res = new ArrayList<>();
        do {
            blogMapper.getBlogEs(index, size)
                    .forEach(item -> res.add(new EsEntity(item.getId(), item)));
            if (res.size() > 0) {
                esUtil.insertBatch(EsConstant.BOOKMARK_INDEX, res);
            }
            index += size;
        } while (res.size() == 500);

    }

    /**
     * Description: 根据context搜索
     *
     * @param context context
     * @author fanxb
     * @date 2019/7/25 10:45
     */
    @Override
    public IPage<BlogES> searchBlog(Integer pageNum, Integer pageSize, String context) {
        BoolQueryBuilder boolQueryBuilder = new BoolQueryBuilder();
        boolQueryBuilder.must(QueryBuilders.multiMatchQuery(context, "title", "summary", "content"));
        SearchSourceBuilder builder = new SearchSourceBuilder();
        if (pageNum <= 0) {
            pageNum = 0;
        }
        builder.from((pageNum - 1) * pageSize);
        builder.size(pageSize);
        builder.query(boolQueryBuilder);
        Map<String, Object> search = esUtil.search(EsConstant.BOOKMARK_INDEX, builder, BlogES.class);
        Page<BlogES> info = new Page<>();

        info.setRecords((List<BlogES>) search.get("list"));
        info.setPages(pageNum);
        Long total = (Long) search.get("total");
        info.setTotal(total);
        info.setPages((total.intValue() + pageSize - 1) / pageSize);

        return info;
    }


    private BlogVo convertBlogToVO(Blog blog) {
        BlogVo blogVo = new BlogVo();
        blogVo.setId(blog.getId());
        blogVo.setCategoryId(blog.getCategoryId());
        blogVo.setTitle(blog.getTitle());
        blogVo.setSummary(blog.getSummary());
        blogVo.setImgUrl(blog.getImgUrl());
        blogVo.setAuthor(blog.getAuthor());
        blogVo.setCode(blog.getCode());
        blogVo.setViewCount(blog.getViewCount());
        blogVo.setLikeCount(blog.getLikeCount());
        blogVo.setCommentCount(blog.getCommentCount());
        blogVo.setIsDeleted(blog.getIsDeleted());
        blogVo.setCreateTime(blog.getCreateTime());
        blogVo.setUpdateTime(blog.getUpdateTime());
        blogVo.setContent(blog.getContent());
        blogVo.setCategoryName(blog.getCategoryName());
        blogVo.setHtmlContent(blog.getHtmlContent());

        return blogVo;
    }
}
