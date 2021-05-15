package com.gupao.raos.ibatis.annotation;

import java.lang.annotation.*;

/**
 * 用于注解接口，以映射返回的实体类
 *
 * @author raos
 * @date 2021年5月12日23:20:22
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface Entity {
    Class<?> value();
}
