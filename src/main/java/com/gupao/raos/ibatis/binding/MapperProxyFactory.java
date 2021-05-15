package com.gupao.raos.ibatis.binding;

import com.gupao.raos.ibatis.session.DefaultSqlSession;

import java.lang.reflect.Proxy;

/**
 * 用于产生MapperProxy代理类
 *
 * @param <T>
 * @author raos
 * @date 2021年5月12日23:20:22
 */
public class MapperProxyFactory<T> {
    private Class<T> mapperInterface;
    private Class object;

    public MapperProxyFactory(Class<T> mapperInterface, Class object) {
        this.mapperInterface = mapperInterface;
        this.object = object;
    }

    public T newInstance(DefaultSqlSession sqlSession) {
        return (T) Proxy.newProxyInstance(mapperInterface.getClassLoader(),
                new Class[]{mapperInterface},
                new MapperProxy(sqlSession, object));
    }
}
