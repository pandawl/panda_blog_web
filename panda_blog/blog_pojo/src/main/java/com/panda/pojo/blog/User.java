package com.panda.pojo.blog;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class User implements Serializable {
    private Integer id;

    private String email;

    private String userName;

    private Date creatTime;

    private Date updateTime;






}
