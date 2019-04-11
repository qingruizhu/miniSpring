package com.zqr.zqrframework;

import java.lang.annotation.*;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface ZqrAutowired {
    String value() default "";
}
