package com.gupao.raos.ibatis.parameter;

import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * 参数处理器
 *
 * @author raos
 * @date 2021年5月12日23:20:22
 */
public class ParameterHandler {

    /**
     * 预编译对象
     */
    private PreparedStatement psmt;

    public ParameterHandler(PreparedStatement statement) {
        this.psmt = statement;
    }

    /**
     * 从方法中获取参数，遍历设置SQL中的 ? 占位符
     *
     * @param parameters
     */
    public void setParameters(Object[] parameters) {
        if (null == parameters || parameters.length ==0) {
            return;
        }
        try {
            // PreparedStatement的序号是从1开始的
            for (int i = 0; i < parameters.length; i++) {
                int k = i + 1;
                if (parameters[i] instanceof Integer) {
                    psmt.setInt(k, (Integer) parameters[i]);
                } else if (parameters[i] instanceof Long) {
                    psmt.setLong(k, (Long) parameters[i]);
                } else if (parameters[i] instanceof String) {
                    psmt.setString(k, String.valueOf(parameters[i]));
                } else if (parameters[i] instanceof Boolean) {
                    psmt.setBoolean(k, (Boolean) parameters[i]);
                } else {
                    psmt.setString(k, String.valueOf(parameters[i]));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
