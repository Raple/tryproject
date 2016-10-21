package com.lyp.easy.trys.annotation;

import java.lang.annotation.*;

/**
 * Created by lyp on 2016/10/21.
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface EnjoyMoney {

    public enum Number{ONE,TOW,THREE,FOUR};

    Number enjoyCount() default Number.TOW;
}
