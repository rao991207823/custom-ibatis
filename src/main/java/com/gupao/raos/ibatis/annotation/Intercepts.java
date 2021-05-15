package com.gupao.raos.ibatis.annotation;

import java.lang.annotation.*;

/**
 * 用于注解拦截器，指定拦截的方法
 *
 * @author raos
 * @date 2021年5月12日23:20:22
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface Intercepts {
    String value();
}
