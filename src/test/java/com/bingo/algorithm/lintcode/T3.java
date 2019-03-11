package com.bingo.algorithm.lintcode;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author zhangge created on 2019-03-05
 * @version $Id$
 */
public class T3 {

    @Test
    public void digitCounts() {
        Assert.assertEquals(5, computerN(1, 12));
        Assert.assertEquals(1, computerN(1, 1));
        Assert.assertEquals(5, computerLogN(1, 12));
        Assert.assertEquals(1, computerLogN(1, 1));
    }

    private int computerLogN(int k, int n) {
        int sum = 0;
        int temp = n;
        int right = 0;
        int pow = 1;
        do {
            int remainder = temp % 10;
            int left = temp / 10 % 10;
            if (remainder > k) {
                sum += (left + 1) * pow;
            } else if (remainder < k) {
                sum += left * pow;
            } else {
                sum += left * pow + right + 1;
            }
            temp = temp / 10;
            right = remainder;
            pow++;
        } while (temp > 0);
        return sum;
    }

    private int computerN(int k, int n) {
        int sum = 0;
        for (int i = 0; i <= n; i++) {
            sum += computerHelperN(k, i);
        }
        return sum;
    }

    private int computerHelperN(int k, int n) {
        int sum = 0;
        int temp = n;
        do {
            int remainder = temp % 10;
            if (remainder == k) {
                sum++;
            }
            temp = temp / 10;
        } while (temp > 0);
        return sum;
    }
}
