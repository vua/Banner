package com.cooooode.annotation;


import com.cooooode.BannerColor;
import com.cooooode.BannerType;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Banner {
    String name();
    BannerType type() default BannerType.Crawford2;
    BannerColor color() default BannerColor.Red;
}
