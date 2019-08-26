package com.wang.server.entity.es;

import com.wang.server.vo.BlogVo;
import lombok.Data;

/**
 * @author Mr.wl
 * @create 2019-08-25 15:03
 * @description: blog es vo
 */

@Data
public class BlogES {

    /**id*/
    private Integer id;

    /**标题*/
    private String title;

    /**描述*/
    private String summary;

    /**正文*/
    private String content;

    /**html正文*/
    private String html_content;
    public BlogES() {
    }

    public BlogES(BlogVo blogVo){
        this.id = blogVo.getId();
       this.title = blogVo.getTitle();
       this.summary = blogVo.getSummary();
       this.content = blogVo.getContent();
       this.html_content = blogVo.getHtmlContent();
    }


}
