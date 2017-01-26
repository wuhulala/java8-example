package com.wuhulala.java8.lambda;

import org.junit.Test;

import java.util.*;
import java.util.function.Predicate;

/**
 * @version 1.0
 * @autor wuhulala
 * @time 1/26/17
 */
public class LambdaTest {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("peter", "anna", "mike", "xen ia");
        Collections.sort(names, new Comparator<String>() {
            @Override
            public int compare(String a, String b) {
                return b.compareTo(a);
            }
        });
        System.out.println(names);
        Collections.sort(names, (a, b) ->  b.compareTo(a));
        System.out.println(names);
        Collections.sort(names, Comparator.reverseOrder());
        System.out.println(names);
    }

    @Test
    public void testInterfaceLambda(){
        Converter<String , Integer> converter = (from) -> Integer.valueOf(from);
        Integer converted = converter.convert("100");
        System.out.println(converted);
        converter = Integer::valueOf;
        converted = converter.convert("100");
        System.out.println(converted);
    }

    @Test
    public void test(){
        Something something = new Something();
        Converter<String,String >converter = something::StartWith;
        String converted = converter.convert("JAVA");
        System.out.println(converted);
    }

    @Test
    public void test2(){
        PersonFactory personFactory = Person::new;
        Person person = personFactory.create("asd","asd");
    }

    @Test
    public void testPredicate(){
        Predicate<String> predicate	=	(s)	->	s.length()	>	0;
        predicate.test("foo");														//	true
        predicate.negate().test("foo");					//	false
        Predicate<Boolean>	nonNull	=	Objects::nonNull;
        Predicate<Boolean>	isNull	=	Objects::isNull;
        Predicate<String>	isEmpty	=	String::isEmpty;
        Predicate<String>	isNotEmpty	=	isEmpty.negate();
    }
}
