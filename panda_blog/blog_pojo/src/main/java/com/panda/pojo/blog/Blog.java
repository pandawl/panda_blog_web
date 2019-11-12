package com.panda.pojo.blog;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class Blog implements Serializable {
    private Integer id;

    private Integer categoryId;

    private String title;

    private String summary;

    private String imgUrl;

    private String author;

    private Integer code;

    private Integer viewCount;

    private Integer likeCount;

    private Integer commentCount;

    private Byte isDeleted;

    private Date createTime;

    private Date updateTime;

    private String content;

    private String htmlContent;

    private String categoryName;

    private static final long serialVersionUID = 1L;


}
