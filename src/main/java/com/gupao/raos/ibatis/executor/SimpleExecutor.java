package com.gupao.raos.ibatis.executor;

/**
 * @author raos
 * @date 2021年5月12日23:20:22
 */
public class SimpleExecutor implements Executor {
    @Override
    public <T> T query(String statement, Object[] parameter, Class pojo) {
        StatementHandler statementHandler = new StatementHandler();
        return statementHandler.query(statement, parameter, pojo);
    }
}
