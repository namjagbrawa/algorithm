package com.bingo.algorithm.lintcode;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author zhangge created on 2019-03-01
 * @version $Id$
 */
public class T1 {

    @Test
    public void bitPlus() {
        Assert.assertEquals(-1, bitSum(1, -2));
        Assert.assertEquals(-1, bitSum(3, -4));
        Assert.assertEquals(16, bitSum(8, 8));
        Assert.assertEquals(160, bitSum(60, 100));
    }

    private int bitSum(int a, int b) {
        int exclusiveOr = a ^ b;
        int and = a & b;
        if (and != 0) {
            return bitSum(exclusiveOr, and << 1);
        }
        return exclusiveOr;
    }

    @Test
    public void subPlus() {
        Assert.assertEquals(-19, sub(1, 20));
        Assert.assertEquals(-1, sub(3, 4));
        Assert.assertEquals(0, sub(8, 8));
        Assert.assertEquals(500, sub(600, 100));
    }

    private int sub(int a, int b) {
        return bitSum(a, bitSum(~b, 1));
    }

    @Test
    public void mulitple() {
        Assert.assertEquals(20, bitMuliple(1, 20));
        Assert.assertEquals(-12, bitMuliple(-3, 4));
        Assert.assertEquals(-64, bitMuliple(-8, 8));
        Assert.assertEquals(60000, bitMuliple( 600, 100));
        Assert.assertEquals(0, bitMuliple(600, 0));
    }

    private int bitMuliple(int a, int b) {
        int _a = a >= 0 ? a : bitSum(~a, 1);
        int _b = b >= 0 ? b : bitSum(~b, 1);

        int sum = 0;
        int bit = 0;
        while (_b > 0) {
            if ((_b & 1) == 1) {
                sum = bitSum(sum, _a << bit);
            }
            _b = _b >> 1;
            bit = bitSum(bit, 1);
        }

        if ((a >= 0 && b >= 0) || (a <0 && b< 0)) {
            return sum;
        } else {
            return bitSum(~sum, 1);
        }
    }

    @Test
    public void division() {
        int b = 11;
        int a = b & 1;
        System.out.println(a);
    }
}
