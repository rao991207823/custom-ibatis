package com.gupao.raos.ibatis.interceptor;

import com.gupao.raos.ibatis.annotation.Intercepts;
import com.gupao.raos.ibatis.plugin.Interceptor;
import com.gupao.raos.ibatis.plugin.Invocation;
import com.gupao.raos.ibatis.plugin.Plugin;

import java.util.Arrays;

/**
 * 自定义插件
 *
 * @author raos
 * @date 2021年5月12日23:20:22
 */
@Intercepts("query")
public class MyPlugin implements Interceptor {

    @Override
    public Object intercept(Invocation invocation) throws Throwable {
        String statement = (String) invocation.getArgs()[0];
        Object[] parameter = (Object[]) invocation.getArgs()[1];
        Class pojo = (Class) invocation.getArgs()[2];
        System.out.println("进入自定义插件：MyPlugin");
        System.out.println("SQL：[" + statement + "]");
        System.out.println("Parameters：" + Arrays.toString(parameter));

        return invocation.proceed();
    }

    @Override
    public Object plugin(Object target) {
        return Plugin.wrap(target, this);
    }
}
