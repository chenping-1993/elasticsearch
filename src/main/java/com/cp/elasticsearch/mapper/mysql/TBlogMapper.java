package com.cp.elasticsearch.mapper.mysql;

import com.cp.elasticsearch.entity.mysql.TBlog;
import com.cp.elasticsearch.entity.vo.ReqVo;
import com.cp.elasticsearch.service.provider.SqlProvider;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

/**
 * @description
 * @author: chenping
 * @create: 2019-10-31
 **/
public interface TBlogMapper extends Mapper<TBlog> {

    @SelectProvider(type = SqlProvider.class, method = "getListSql")
    List<TBlog> list(ReqVo vo);

    @Select("select id,title,author,content,create_time createTime,update_time updateTime  from t_blog order by update_time desc ")
    List<TBlog> getAll();
}
