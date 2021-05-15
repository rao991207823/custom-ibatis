package com.gupao.raos.ibatis.mapper;

import com.gupao.raos.ibatis.annotation.Entity;
import com.gupao.raos.ibatis.annotation.Select;

/**
 * @author raos
 * @date 2021年5月12日23:20:22
 */
@Entity(Blog.class)
public interface BlogMapper {
    /**
     * 根据主键查询文章
     * @param bid
     * @return
     */
    @Select("select * from blog where bid = ? ")
    Blog selectBlogById(Integer bid);

}
