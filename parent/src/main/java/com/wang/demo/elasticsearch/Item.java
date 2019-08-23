package com.wang.demo.elasticsearch;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import static org.springframework.data.elasticsearch.annotations.FieldIndex.not_analyzed;

/**
 * @Auther: wl
 * @Date: 2019/8/13 09:59
 * @Description:
 */
@Document(indexName = "item",type = "docs", shards = 1, replicas = 0)
@Data
public class Item {
    @Id
    private Long id;
    @Field(type = FieldType.String, analyzer = "ik_max_word")
    private String title; //标题
    @Field(type = FieldType.String)
    private String category;// 分类
    @Field(type = FieldType.String)
    private String brand; // 品牌
    @Field(type = FieldType.Double)
    private Double price; // 价格
    @Field(index = not_analyzed, type = FieldType.String)
    private String images; // 图片地址
}
