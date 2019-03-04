package com.bingo.algorithm.lintcode;

import org.junit.Test;

/**
 * @author zhangge created on 2019-03-04
 * @version $Id$
 */
public class T2 {

    @Test
    public void factorial() {
        double pow = Math.pow(125, 1 / 5);
        System.out.println(pow);
    }

    private int computerZero(int number) {
        int sum = 0;
        for (int i = 5; i <= number; i += 5) {
            sum += Math.pow(i, 1/5);
        }
        return sum;
    }

    @Test
    public void print() {
        printFactorial(106);
    }

    private void printFactorial(int number) {
        for (int i = 1; i <= number; i++) {
            System.out.println(i + " = " + computer(i));
        }
    }

    private long computer(int number) {
        if (number == 1) {
            return 1;
        }
        return computer(number - 1) * number;
    }
}
