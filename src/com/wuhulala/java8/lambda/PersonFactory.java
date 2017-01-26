package com.wuhulala.java8.lambda;

/**
 * @version 1.0
 * @autor wuhulala
 * @time 1/26/17
 */
public interface PersonFactory<P extends Person> {
    P create(String firstName, String lastName);
}
