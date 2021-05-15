package com.gupao.raos.ibatis;

import com.gupao.raos.ibatis.mapper.Blog;
import com.gupao.raos.ibatis.mapper.BlogMapper;
import com.gupao.raos.ibatis.session.DefaultSqlSession;
import com.gupao.raos.ibatis.session.SqlSessionFactory;

/**
 * 自定义mybatis框架测试
 *
 * @author raos
 * @date 2021年5月12日23:20:22
 */
public class IbatisTest {

    public static void main(String[] args) {
        SqlSessionFactory factory = new SqlSessionFactory();
        DefaultSqlSession sqlSession = factory.build().openSqlSession();
        // 获取MapperProxy代理
        BlogMapper mapper = sqlSession.getMapper(BlogMapper.class);
        Blog blog = mapper.selectBlogById(1);

        System.out.println("第一次查询: " + blog);
        System.out.println();
        blog = mapper.selectBlogById(1);
        System.out.println("第二次查询: " + blog);
    }
}
