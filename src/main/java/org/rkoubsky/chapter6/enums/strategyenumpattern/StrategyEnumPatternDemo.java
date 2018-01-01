package org.rkoubsky.chapter6.enums.strategyenumpattern;

import java.math.BigDecimal;

/**
 * @author Radek Koubsky (radekkoubsky@gmail.com)
 */
public class StrategyEnumPatternDemo {
    public static void main(String[] args) {
        System.out.printf("I worked 10 hours on Friday, I have 10$ per hour, I get %s$.%n",
                PayrollDay.FRIDAY.pay(new BigDecimal("10"), new BigDecimal("10")));

        System.out.printf("I worked 10 hours on Sunday, I have 10$ per hour, I get %s$.%n",
                PayrollDay.SUNDAY.pay(new BigDecimal("10"), new BigDecimal("10")));
    }
}
