package com.cp.elasticsearch.controller;

import com.cp.elasticsearch.mapper.mysql.TBlogMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Description:
 * @Author: chenping
 * @Date: 2020-04-23
 */
@Controller
public class TestController {

    @Autowired
    TBlogMapper tBlogMapper;

    @RequestMapping("/")
    public String toIndex() {
        System.out.println(tBlogMapper.selectAll().size());
        return "index.html";
    }

}
