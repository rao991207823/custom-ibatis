package com.gupao.raos.ibatis.session;

import com.gupao.raos.ibatis.executor.Executor;

/**
 * 仿MeBatis的默认SqlSession API，提供给应用层使用
 *
 * @author raos
 * @date 2021年5月12日23:20:22
 */
public class DefaultSqlSession {

    private Configuration configuration;
    private Executor executor;

    public DefaultSqlSession(Configuration configuration) {
        this.configuration = configuration;
        // 根据全局配置决定是否使用缓存装饰
        this.executor = configuration.newExecutor();
    }

    public Configuration getConfiguration() {
        return configuration;
    }

    public <T> T getMapper(Class<T> clazz) {
        return configuration.getMapper(clazz, this);
    }

    public <T> T selectOne(String statement, Object[] parameter, Class pojo) {
        String sql = getConfiguration().getMappedStatement(statement);
        // 打印代理对象时会自动调用toString()方法，触发invoke()
        return executor.query(sql, parameter, pojo);
    }

}
