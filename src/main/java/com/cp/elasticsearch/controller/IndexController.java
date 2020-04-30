package com.cp.elasticsearch.controller;

import com.cp.elasticsearch.entity.es.EsTBlog;
import com.cp.elasticsearch.entity.mysql.TBlog;
import com.cp.elasticsearch.entity.vo.ReqVo;
import com.cp.elasticsearch.mapper.es.EsTBlogMapper;
import com.cp.elasticsearch.mapper.mysql.TBlogMapper;
import lombok.extern.slf4j.Slf4j;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.DisMaxQueryBuilder;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.data.elasticsearch.core.query.SearchQuery;
import org.springframework.util.StopWatch;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Description:
 * @Author: chenping
 * @Date: 2020-04-23
 */
@Slf4j
@RestController
public class IndexController {

    @Autowired
    TBlogMapper tBlogMapper;

    @Autowired
    EsTBlogMapper esTBlogMapper;

    @RequestMapping("/ping")
    public String pong() {
        return "pong";
    }

    /** 
     * @Description:  es测试
     * @param:  
     * @return: com.cp.elasticsearch.entity.es.EsTBlog 
     * @Author: chenping
     * @Date: 2020/4/30
     */
    @RequestMapping("blog/es")
    public EsTBlog getBlog() {
        Iterable<EsTBlog> esblog = esTBlogMapper.findAll();
        return esblog.iterator().next();
    }
    /** 
     * @Description:  tkmybatis 查询测试
     * @param:  
     * @return: java.util.List<com.cp.elasticsearch.entity.mysql.TBlog> 
     * @Author: chenping
     * @Date: 2020/4/30
     */
    @RequestMapping("blog/tk")
    public List<TBlog> getTkBlog() {
        return tBlogMapper.selectAll();
    }

    /** 
     * @Description:  首页初始化
     * @param:  
     * @return: java.util.List<com.cp.elasticsearch.entity.mysql.TBlog> 
     * @Author: chenping
     * @Date: 2020/4/30
     */
    @RequestMapping("/blogs")
    public List<TBlog> getTkBlogs() {
        return tBlogMapper.getAll();
    }

    /** 
     * @Description:  博客详情
     * @param: id 
     * @return: java.lang.Object 
     * @Author: chenping
     * @Date: 2020/4/30
     */
    @GetMapping("/blog/{id}")
    public Object getBlogDetails(@PathVariable("id") Integer id) {
        TBlog tBlog = tBlogMapper.selectByPrimaryKey(id);
        return tBlog;
    }

    /** 
     * @Description:  es、mysql查询
     * @param: vo 
     * @return: java.lang.Object 
     * @Author: chenping
     * @Date: 2020/4/30
     */
    @RequestMapping("/search")
    public Object search(@RequestBody ReqVo vo) {
        Map map = new HashMap();

        String type = vo.getType();
        //计时器
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        if (type.equalsIgnoreCase("es")) {

//            BoolQueryBuilder boolQueryBuilder = QueryBuilders.boolQuery();
//            boolQueryBuilder.should(QueryBuilders.matchPhraseQuery("title",vo.getKeyword()));
//            boolQueryBuilder.should(QueryBuilders.matchPhraseQuery("content",vo.getKeyword()));
//            log.info("es构建查询条件：{}",boolQueryBuilder.toString());
//
//            Page<EsTBlog> esPage= (Page<EsTBlog>) esTBlogMapper.search(boolQueryBuilder);
            //es分词查询
            DisMaxQueryBuilder disMaxQueryBuilder = QueryBuilders.disMaxQuery();

            QueryBuilder title = QueryBuilders.matchQuery("title",vo.getKeyword());
            QueryBuilder content = QueryBuilders.matchQuery("content",vo.getKeyword());

            disMaxQueryBuilder.add(title);
            disMaxQueryBuilder.add(content);

            SearchQuery searchQuery = new NativeSearchQueryBuilder().withQuery(disMaxQueryBuilder).build();

            Page<EsTBlog> esPage= esTBlogMapper.search(searchQuery);
            List<EsTBlog> result = esPage.getContent();
            map.put("list",result);
        } else if (type.equalsIgnoreCase("mysql")) {
            map.put("list",tBlogMapper.list(vo));
        } else {
            return "no result";
        }
        stopWatch.stop();
        long minutes = stopWatch.getTotalTimeMillis();
        map.put("duration",minutes);
        return map;
    }

}
