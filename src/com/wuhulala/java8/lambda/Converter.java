package com.wuhulala.java8.lambda;

/**
 * @version 1.0
 * @autor wuhulala
 * @time 1/26/17
 */
@FunctionalInterface
public interface Converter<F,T> {
    T convert(F from);
}
