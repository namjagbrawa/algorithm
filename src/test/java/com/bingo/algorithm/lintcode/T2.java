package com.bingo.algorithm.lintcode;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author zhangge created on 2019-03-04
 * @version $Id$
 */
public class T2 {

    @Test
    public void factorial() {
        Assert.assertEquals(0, computerZero(3));
        Assert.assertEquals(1, computerZero(9));
        Assert.assertEquals(3, computerZero(16));
        Assert.assertEquals(6, computerZero(26));
    }

    private int computerZero(int number) {
        int sum = 0;
        for (int i = 5; i <= number; i += 5) {
            sum++;
            int current = i;
            while ((current = current / 5) >= 5) {
                sum++;
            }
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
