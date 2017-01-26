package com.wuhulala.java8.stream;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

/**
 * @version 1.0
 * @autor wuhulala
 * @time 1/26/17
 */
public class StreamTest {
    List<String> stringCollection;
    List<String> values;

    @Before
    public void init() {
        stringCollection = new ArrayList<>();
        stringCollection.add("ddd2");
        stringCollection.add("aaa2");
        stringCollection.add("bbb1");
        stringCollection.add("aaa1");
        stringCollection.add("bbb3");
        stringCollection.add("ccc");
        stringCollection.add("bbb2");
        stringCollection.add("ddd1");

        int max = 1000000;
        values = new ArrayList<>(max);
        for (int i = 0; i < max; i++) {
            UUID uuid = UUID.randomUUID();
            values.add(uuid.toString());
        }
    }

    @Test
    public void testFilter() {
        stringCollection
                .stream()
                .filter((s) -> s.startsWith("a"))
                .forEach(System.out::println);
    }

    @Test
    public void testSorted() {
        stringCollection
                .stream()
                .sorted(String::compareTo)
                .filter((s) -> s.startsWith("a"))
                .forEach(System.out::println);
    }

    @Test
    public void testMap() {
        stringCollection
                .stream()
                .sorted(String::compareTo)
                .filter((s) -> s.startsWith("a"))
                .map(String::toUpperCase)
                .forEach(System.out::println);
    }

    @Test
    public void testCount() {
        long startsWithB =
                stringCollection
                        .stream()
                        .filter((s) -> s.startsWith("b"))
                        .count();
        System.out.println(startsWithB);                //	3
    }

    @Test
    public void testSequentialSort() {
        long t0 = System.nanoTime();
        long count = values.stream().sorted().count();
        System.out.println(count);
        long t1 = System.nanoTime();
        long millis = TimeUnit.NANOSECONDS.toMillis(t1 - t0);
        System.out.println(String.format("sequential	sort	took:	%d	ms",
                millis));
        //	sequential	sort	took:	1226	ms
    }

    @Test
    public void testParallelSort() {
        long t0 = System.nanoTime();
        long count = values.parallelStream().sorted().count();
        System.out.println(count);
        long t1 = System.nanoTime();
        long millis = TimeUnit.NANOSECONDS.toMillis(t1 - t0);
        System.out.println(String.format("parallel	sort	took:	%d	ms", millis));
        //parallel	sort	took:	960	ms
    }
}
