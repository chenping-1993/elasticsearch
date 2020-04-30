package com.cp.elasticsearch.entity.vo;

import lombok.Data;

/**
 * @Description:
 * @Author: chenping
 * @Date: 2020-04-29
 */
@Data
public class ReqVo {

    //查询类型 es mysql
    private String type;

    //查询关键字
    private String keyword;
}
