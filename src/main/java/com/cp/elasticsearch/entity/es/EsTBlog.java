package com.cp.elasticsearch.entity.es;

import com.fasterxml.jackson.annotation.JsonAlias;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import java.util.Date;

/**
 * @Description: useServerConfiguration 使用线上es配置
 * createIndex 是否在启动时候创建es索引（默认使用es配置好的索引）
 * @Author: chenping
 * @Date: 2020-04-29
 */
@Data
@Document(indexName = "blog",type = "doc",useServerConfiguration = true,createIndex = false)
public class EsTBlog {
    @Id
    private Integer id;

    @Field(type = FieldType.Text,analyzer = "ik_max_word")
    private String title;
    @Field(type = FieldType.Text,analyzer = "ik_max_word")
    private String author;
    @Field(type = FieldType.Text,analyzer = "ik_max_word")
    private String content;

//    @Field(name = "create_time",type = FieldType.Date,format = DateFormat.custom,pattern = "yyyy-MM-dd HH:mm:ss||yyyy-MM-dd||epoch_millis")
//    @JsonFormat(shape = JsonFormat.Shape.STRING,pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    //解决字段与es字段不一致问题
    @JsonAlias("create_time")
    private Date createTime;

//    @Field(name = "update_time",type = FieldType.Date,format = DateFormat.custom,pattern = "yyyy-MM-dd HH:mm:ss||yyyy-MM-dd||epoch_millis")
//    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @JsonAlias("update_time")
    private Date updateTime;
}
