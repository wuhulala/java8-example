package com.wuhulala.java8.annotation;

import java.lang.annotation.Repeatable;

/**
 * @version 1.0
 * @autor wuhulala
 * @time 1/26/17
 */
@Repeatable(Hints.class)
public @interface Hint {
    String value();
}
