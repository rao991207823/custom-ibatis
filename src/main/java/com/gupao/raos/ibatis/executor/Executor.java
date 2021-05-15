package com.gupao.raos.ibatis.executor;

/**
 * 顶层的执行接口
 *
 * @author raos
 * @date 2021年5月12日23:20:22
 */
public interface Executor {
    /**
     * 查询
     * @param statement
     * @param parameter
     * @param pojo
     * @param <T>
     * @return
     */
    <T> T query(String statement, Object[] parameter, Class pojo);

}
