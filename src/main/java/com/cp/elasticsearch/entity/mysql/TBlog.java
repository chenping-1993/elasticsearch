package com.cp.elasticsearch.entity.mysql;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;

/**
 * @Description:
 * @Author: chenping
 * @Date: 2020-04-23
 */
@Data
@Table(name = "t_blog")
public class TBlog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String title;

    private String author;

    @Column(columnDefinition = "mediumtext")
    private String content;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date createTime;
//
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date updateTime;

//    @Column(name = "create_time")
//    private String createTime;
//
//    @Column(name = "update_time")
//    private String updateTime;
}
