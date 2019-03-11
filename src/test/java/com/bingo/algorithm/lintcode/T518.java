package com.bingo.algorithm.lintcode;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

/**
 * @author zhangge created on 2019-03-05
 * @version $Id$
 */
public class T518 {

    @Test
    public void uglyNumber() {
        Assert.assertEquals(13, uglyNumberLogN(6, new int[]{2, 7, 13, 19}));
        Assert.assertEquals(15, uglyNumberLogN(11, new int[]{2, 3, 5}));
    }

    private int uglyNumberLogN(int number, int[] prime) {
        int[] array = new int[number];
        int[] read = new int[prime.length];
        int[] values = new int[prime.length];
        array[0] = 1;
        int location = 1;
        while (location < number) {
            int min = Integer.MAX_VALUE;
            for (int i = 0; i < read.length; i++) {
                values[i] = array[read[i]] * prime[i];
                min = Math.min(values[i], min);
            }
            for (int i = 0; i < values.length; i++) {
                if (values[i] == min) {
                    read[i]++;
                    // read[i] = read[i] + 1;
                }
            }
            array[location] = min;
            location++;
        }
        return array[number - 1];
    }

    @Test
    public void print() {
        printAllUglyNumber(1000, new int[]{2, 7, 13, 19});
    }

    private void printAllUglyNumber(int number, int[] prime) {
        int temp = 1;
        int order = 1;
        while (temp < number) {
            if (isUglyNumber(temp, prime)) {
                System.out.println(order + " = " + temp + " : " + temp / order + " % " + temp % order);
                order++;
            }
            temp++;
        }
    }

    private boolean isUglyNumber(int number, int[] prime) {
        int temp = number;
        boolean divisible = false;
        while (true) {
            for (int p : prime) {
                if (temp % p == 0) {
                    temp = temp / p;
                    divisible = true;
                }
            }
            if (divisible) {
                divisible = false;
            } else {
                return temp == 1 ? true : false;
            }
        }
    }
}
