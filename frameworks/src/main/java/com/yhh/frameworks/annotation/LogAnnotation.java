package com.yhh.frameworks.annotation;

import java.lang.annotation.*;

/**
 * @author hyh
 * @date 2024/4/16
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface LogAnnotation {
    String value() default "";
}
