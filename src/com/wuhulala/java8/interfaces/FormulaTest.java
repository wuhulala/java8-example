package com.wuhulala.java8.interfaces;

/**
 * @version 1.0
 * @autor wuhulala
 * @time 1/26/17
 */
public class FormulaTest {
    public static void main(String[] args) {
        Formula formula = new Formula() {
            @Override
            public double calculate(int a) {
                return sqrt(a * 100);
            }

            @Override
            public double minus(int a, int b) {
                return a - b;
            }
        };
        double a = formula.calculate(100);
        System.out.println(a);
        a = formula.sqrt(16);
        System.out.println(a);
        a= formula.minus(100,10);
        System.out.println(a);

    }
}
