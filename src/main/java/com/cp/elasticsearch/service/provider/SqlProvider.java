package com.cp.elasticsearch.service.provider;

import com.cp.elasticsearch.entity.vo.ReqVo;

/**
 * @Description:
 * @Author: chenping
 * @Date: 2020-04-23
 */
public class SqlProvider {

    public String getListSql(ReqVo vo) {
        StringBuffer sqlList = new StringBuffer();
        sqlList.append(" select id,title,author,content,create_time createTime,update_time updateTime  from t_blog where 1= 1 ");
        if (vo != null && vo.getKeyword() != null) {
            sqlList.append(" and title like '%"+vo.getKeyword()+"%' or content like '%"+vo.getKeyword()+"%' ");
        }
        sqlList.append(" order by update_time desc");
        return sqlList.toString();
    }
}
