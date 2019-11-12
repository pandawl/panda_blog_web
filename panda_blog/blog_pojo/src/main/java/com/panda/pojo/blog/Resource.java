package com.panda.pojo.blog;

import java.io.Serializable;
import java.util.Date;

public class Resource implements Serializable {
    private Long id;

    private Date create_at;

    private String remarks;

    private Date update_at;

    private String icon;

    private Integer list_order;

    private String name;

    private String perm;

    private Long pid;

    private String res_type;

    private String tip;

    private String url;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getCreate_at() {
        return create_at;
    }

    public void setCreate_at(Date create_at) {
        this.create_at = create_at;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks == null ? null : remarks.trim();
    }

    public Date getUpdate_at() {
        return update_at;
    }

    public void setUpdate_at(Date update_at) {
        this.update_at = update_at;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon == null ? null : icon.trim();
    }

    public Integer getList_order() {
        return list_order;
    }

    public void setList_order(Integer list_order) {
        this.list_order = list_order;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getPerm() {
        return perm;
    }

    public void setPerm(String perm) {
        this.perm = perm == null ? null : perm.trim();
    }

    public Long getPid() {
        return pid;
    }

    public void setPid(Long pid) {
        this.pid = pid;
    }

    public String getRes_type() {
        return res_type;
    }

    public void setRes_type(String res_type) {
        this.res_type = res_type == null ? null : res_type.trim();
    }

    public String getTip() {
        return tip;
    }

    public void setTip(String tip) {
        this.tip = tip == null ? null : tip.trim();
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url == null ? null : url.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", create_at=").append(create_at);
        sb.append(", remarks=").append(remarks);
        sb.append(", update_at=").append(update_at);
        sb.append(", icon=").append(icon);
        sb.append(", list_order=").append(list_order);
        sb.append(", name=").append(name);
        sb.append(", perm=").append(perm);
        sb.append(", pid=").append(pid);
        sb.append(", res_type=").append(res_type);
        sb.append(", tip=").append(tip);
        sb.append(", url=").append(url);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}