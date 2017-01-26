package com.wuhulala.java8.annotation;

/**
 * @version 1.0
 * @autor wuhulala
 * @time 1/26/17
 */
public class AnnotationTest {
    public static void main(String[] args) {
        Hint hint = Person.class.getAnnotation(Hint.class);
        System.out.println(hint);                                                                            //	null
        Hints hints1 = Person.class.getAnnotation(Hints.class);
        System.out.println(hints1.value().length);        //	2
        Hint[] hints2 = Person.class.getAnnotationsByType(Hint.class);
        System.out.println(hints2.length);                                        //	2
    }
}
