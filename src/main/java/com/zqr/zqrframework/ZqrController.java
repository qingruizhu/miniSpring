package com.zqr.zqrframework;

import java.lang.annotation.*;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface ZqrController {
    String value() default "";
}
