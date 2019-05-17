package com.wang.server.entity;

import java.io.Serializable;
import java.util.Date;

public class Tag implements Serializable {
    private Integer id;

    private String tag_name;

    private String tag_desc;

    private Byte type;

    private Date create_time;

    private Date update_time;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTag_name() {
        return tag_name;
    }

    public void setTag_name(String tag_name) {
        this.tag_name = tag_name == null ? null : tag_name.trim();
    }

    public String getTag_desc() {
        return tag_desc;
    }

    public void setTag_desc(String tag_desc) {
        this.tag_desc = tag_desc == null ? null : tag_desc.trim();
    }

    public Byte getType() {
        return type;
    }

    public void setType(Byte type) {
        this.type = type;
    }

    public Date getCreate_time() {
        return create_time;
    }

    public void setCreate_time(Date create_time) {
        this.create_time = create_time;
    }

    public Date getUpdate_time() {
        return update_time;
    }

    public void setUpdate_time(Date update_time) {
        this.update_time = update_time;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", tag_name=").append(tag_name);
        sb.append(", tag_desc=").append(tag_desc);
        sb.append(", type=").append(type);
        sb.append(", create_time=").append(create_time);
        sb.append(", update_time=").append(update_time);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}