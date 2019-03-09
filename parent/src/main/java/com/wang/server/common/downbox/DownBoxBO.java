package com.wang.server.common.downbox;

/**
 * 页面下拉框列表统一结构
 *
 * @author lyh
 */
public class DownBoxBO {

    private int id;

    private String value;

    private String code;
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public DownBoxBO(int id, String value) {
        this.id = id;
        this.value = value;
    }

    public DownBoxBO() {
    }
}
