package com.gupao.raos.ibatis.mapper;

import java.io.Serializable;

/**
 * 实体 -- 博客类
 *
 * @author raos
 * @date 2021年5月12日23:20:22
 */
public class Blog implements Serializable {
    /**
     * 文章ID
     */
    Integer bid;
    /**
     * 文章标题
     */
    String name;
    /**
     * 文章作者ID
     */
    Integer authorId;

    public Integer getBid() {
        return bid;
    }

    public void setBid(Integer bid) {
        this.bid = bid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAuthorId() {
        return authorId;
    }

    public void setAuthorId(Integer authorId) {
        this.authorId = authorId;
    }

    @Override
    public String toString() {
        return "Blog{" +
                "bid=" + bid +
                ", name='" + name + '\'' +
                ", authorId='" + authorId + '\'' +
                '}';
    }

}
