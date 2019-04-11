package com.zqr.zqrframework;

import java.lang.annotation.*;

@Target({ElementType.TYPE,ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface ZqrRequestMapping {
    String value() default "";
}
