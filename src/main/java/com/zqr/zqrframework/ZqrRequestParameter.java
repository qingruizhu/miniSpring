package com.zqr.zqrframework;

import java.lang.annotation.*;

@Target(ElementType.PARAMETER)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface ZqrRequestParameter {
    String value() default "";
}
