package com.wuhulala.java8.interfaces;

/**
 * @version 1.0
 * @autor wuhulala
 * @time 1/26/17
 */
public interface Formula {
    double calculate(int a);
    double minus(int a,int b);
    default double sqrt(int a){
        return Math.sqrt(a);
    }
}
