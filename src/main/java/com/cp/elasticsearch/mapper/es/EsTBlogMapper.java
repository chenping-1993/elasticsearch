package com.cp.elasticsearch.mapper.es;

import com.cp.elasticsearch.entity.es.EsTBlog;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;


/**
 * @description es mapper
 * @author: chenping
 * @create: 2019-10-31
 **/
public interface EsTBlogMapper extends ElasticsearchRepository<EsTBlog,Integer> {

}
