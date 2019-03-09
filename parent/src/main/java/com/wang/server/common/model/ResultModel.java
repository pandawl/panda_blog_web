package com.wang.server.common.model;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.wang.server.common.CommonConstant;
import com.wang.server.common.util.ResultCode;

import java.io.Serializable;

/**
 * 通用返回对象
 *
 * @author: shq
 *
 */
public class ResultModel implements Serializable {

    private int        code;

    private String     message;

    private JSONObject data;

    public ResultModel() {
        this.code = CommonConstant.HTTP_SUCCESS;
        this.message = "";
    }

    public ResultModel(final JSONObject data) {
        this.code = CommonConstant.HTTP_SUCCESS;
        this.data = data;
        this.message = "";
    }



    public ResultModel(final int code, final String message) {
        this.code = code;
        this.message = message;
    }
    public ResultModel(final ResultCode resultCode, final String message) {
        this.code = code;
        this.message = message;
    }

    public String toJsonString() {
        return JSON.toJSONString(this);
    }

    public JSONObject toJson() {
        return (JSONObject) JSON.toJSON(this);
    }

    public int getCode() {
        return code;
    }

    public void setCode(final int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(final String message) {
        this.message = message;
    }

    public JSONObject getData() {
        return data;
    }

    public void setData(final JSONObject data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "ResultModel{" +
                "code=" + code +
                ", message='" + message + '\'' +
                ", data=" + data +
                '}';
    }
}
