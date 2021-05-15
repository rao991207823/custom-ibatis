package com.gupao.raos.ibatis.annotation;

import java.lang.annotation.*;

/**
 * 注解方法，配置SQL语句
 *
 * @author raos
 * @date 2021年5月12日23:20:22
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface Select {
    String value();
}
