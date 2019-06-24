package com.wang.server.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class Tag implements Serializable {

    private Integer id;


    private String tagName;

    private String tagDesc;

    private Date createTime;

    private Date updateTime;

    private static final long serialVersionUID = 1L;


}
