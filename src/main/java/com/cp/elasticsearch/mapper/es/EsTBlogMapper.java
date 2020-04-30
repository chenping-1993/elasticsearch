package com.cp.elasticsearch.mapper.es;

import com.cp.elasticsearch.entity.es.EsTBlog;
import com.cp.elasticsearch.entity.mysql.TBlog;
import com.cp.elasticsearch.service.provider.SqlProvider;
import org.apache.ibatis.annotations.SelectProvider;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

/**
 * @description
 * @author: chenping
 * @create: 2019-10-31
 **/
public interface EsTBlogMapper extends ElasticsearchRepository<EsTBlog,Integer> {

}
