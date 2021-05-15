package com.gupao.raos.ibatis.executor;

import com.gupao.raos.ibatis.parameter.ParameterHandler;
import com.gupao.raos.ibatis.session.Configuration;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * 封装JDBC Statement，用于操作数据库
 *
 * @author raos
 * @date 2021年5月12日23:20:22
 */
public class StatementHandler {
    private ResultSetHandler resultSetHandler = new ResultSetHandler();

    public <T> T query(String statement, Object[] parameter, Class pojo) {
        Connection conn = null;
        PreparedStatement preparedStatement = null;
        Object result = null;

        try {
            conn = getConnection();
            preparedStatement = conn.prepareStatement(statement);
            ParameterHandler parameterHandler = new ParameterHandler(preparedStatement);
            parameterHandler.setParameters(parameter);
            preparedStatement.execute();
            try {
                result = resultSetHandler.handle(preparedStatement.getResultSet(), pojo);
            } catch (Exception e) {
                e.printStackTrace();
            }
            return (T) result;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                conn = null;
            }
        }
        // 只在try里面return会报错
        return null;
    }

    /**
     * 获取连接
     *
     * @return
     * @throws SQLException
     */
    private Connection getConnection() {
        String driver = Configuration.properties.getString("jdbc.driver");
        String url = Configuration.properties.getString("jdbc.url");
        String username = Configuration.properties.getString("jdbc.username");
        String password = Configuration.properties.getString("jdbc.password");
        Connection conn = null;
        try {
            Class.forName(driver);
            conn = DriverManager.getConnection(url, username, password);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }
}
