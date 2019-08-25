package com.wang.server.entity.es;

import lombok.Data;

/**
 * 类功能简述：
 * 类功能详述：
 *
 * @author fanxb
 * @date 2019/7/24 17:37
 */
@Data
public final class EsEntity<T> {

    private String id;
    private T data;

    public EsEntity() {
    }

    public EsEntity(Integer id, T data) {
        this.data = data;
        this.id = String.valueOf(id);
    }
}
