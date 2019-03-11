package com.bingo.algorithm.lintcode;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

/**
 * @author zhangge created on 2019-03-05
 * @version $Id$
 */
public class T5 {

    @Test
    public void largest() {
        Assert.assertEquals(4, largest(1, new int[]{1, 3, 4, 2}));
        Assert.assertEquals(4, largest(3, new int[]{9, 3, 2, 4, 8}));
        Assert.assertEquals(6, largest(4, new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9}));
    }

    private int largest(int n, int[] numbers) {

        return 0;
    }

    @Test
    public void quickSort() {
        //System.out.println(Arrays.toString(quickSort1(new int[]{5, 9, 8, 7, 6, 5, 4, 3, 2, 1, 10}, 0, 10)));
        //System.out.println(Arrays.toString(quickSort1(new int[]{9, 6, 4, 5, 8, 2, 3, 1, 4, 2, 10}, 0, 10)));
        //System.out.println(Arrays.toString(quickSort1(new int[]{5, 9, 8, 7, 6, 5, 4, 3, 2, 1, 10}, 0, 10)));
        //System.out.println(Arrays.toString(quickSort1(new int[]{1, 1, 2, 3, 4, 5, 6, 7, 9, 8, 10}, 0, 10)));

        System.out.println(Arrays.toString(quickSort1(new int[]{ 9, 8, 7, 6, 5, 4, 3, 2, 1, 10}, 0, 9)));
        //System.out.println(Arrays.toString(quickSort1(new int[]{9, 6, 4, 5, 8, 2, 3, 1, 4, 2, 10}, 0, 10)));
        //System.out.println(Arrays.toString(quickSort1(new int[]{5, 9, 8, 7, 6, 5, 4, 3, 2, 1, 10}, 0, 10)));
        //System.out.println(Arrays.toString(quickSort1(new int[]{1, 1, 2, 3, 4, 5, 6, 7, 9, 8, 10}, 0, 10)));

        //System.out.println(Arrays.toString(quickSort1(new int[]{10, 9, 8, 7, 6, 5, 4, 3, 2, 1, 10}, 0, 10)));
    }

    public int[] quickSort1(int[] numbers, int start, int end) {
        if (start >= end) {
            return numbers;
        }

        int k = numbers[end];

        int i = start;
        int j = start + 1;

        while (j <= end) {
            if (numbers[i] <= k && numbers[j] > k) {
                swap(numbers, i, j);
            }
            if (numbers[i] > k) {
                i++;
            }
            if (numbers[j] <= k) {
                j++;
            }
        }

        quickSort1(numbers, start, i - 1);
        quickSort1(numbers, i, end);

        return numbers;
    }

    @Test
    public void bitSwap() {
        int[] swap = swap(new int[]{0, 10}, 0, 1);
        System.out.println(Arrays.toString(swap));
    }

    private int[] swapTemp(int[] numbers, int i, int j) {
        int temp = numbers[i];
        numbers[i] = numbers[j];
        numbers[j] = temp;
        return numbers;
    }

    // 同一位的交换结果为0
    private int[] swap(int[] numbers, int i, int j) {
        numbers[i] = numbers[i] ^ numbers[j];
        numbers[j] = numbers[i] ^ numbers[j];
        numbers[i] = numbers[i] ^ numbers[j];
        return numbers;
    }

    public int[] quickSort2(int[] numbers, int start, int end) {
        if (end - start <= 0) {
            return numbers;
        }

        int k = numbers[start];
        int i = start + 1;
        int left = start;
        int j = end;
        while (i <= j) {
            while (i < j && numbers[i] < k) {
                swap(numbers, left, i);
                i++;
                left++;
            }
            while (i <= j && numbers[i] == k) {
                i++;
            }
            while (i <= j && numbers[j] > k) {
                j--;
            }
            while (numbers[j] == k && i < j) {
                swap(numbers, i, j);
                i++;
                j--;
            }
            while (numbers[j] < k && i < j) {
                swap(numbers, i, j);
                j--;
                swap(numbers, left, i);
                left++;
                i++;
            }
        }
        quickSort2(numbers, start, left - 1);
        quickSort2(numbers, i, end);
        return numbers;
    }

    public int[] quickSort3(int[] numbers, int start, int end) {
        if (end - start <= 0) {
            return numbers;
        }

        int k = numbers[start];
        int i = start;
        for (int j = start; j <= end; ) {
            if (numbers[i] < k) {
                i++;
            }
            if (numbers[j] < k && j > i) {
                swap(numbers, i, j);
            }
            j++;
        }

        quickSort3(numbers, start, i - 1);
        quickSort3(numbers, i, end);

        return numbers;
    }

    public int[] quickSort4(int[] numbers, int start, int end) {
        if (start >= end) {
            return numbers;
        }

        int k = numbers[start];
        int left = start;
        int i = start + 1;
        int j = end;

        while (i <= j) {
            while (i <= j && numbers[i] > k) {
                i++;
            }
            while (i <= j && numbers[j] > k) {
                j--;
            }
            if (i < j) {
                swapTemp(numbers, i, j);
                i++;
                j--;
            }
        }

        numbers[start] = numbers[j];
        numbers[j] = k;

        quickSort4(numbers, start, j);
        quickSort4(numbers, j + 1, end);

        return null;
    }

    @Test
    public void bubbleSort() {
        System.out.println(Arrays.toString(bubbleSort(new int[]{9, 8, 7, 6, 5, 4, 3, 2, 1})));
        System.out.println(Arrays.toString(bubbleSort(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9})));
        System.out.println(Arrays.toString(bubbleSort(new int[]{4, 5, 23, 2, 5, 2, 2, 2, 3, 4, 5, 6, 7, 8, 9, 8, 7, 6, 5, 4, 3, 2, 1})));
        System.out.println(Arrays.toString(bubbleSortWrong(new int[]{9, 8, 7, 6, 5, 4, 3, 2, 1})));
        System.out.println(Arrays.toString(bubbleSortWrong(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9})));
        System.out.println(Arrays.toString(bubbleSortCommon(new int[]{9, 8, 7, 6, 5, 4, 3, 2, 1})));
        System.out.println(Arrays.toString(bubbleSortCommon(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9})));
    }

    private int[] bubbleSort(int[] numbers) {
        int count = 0;
        boolean flag = false;
        int last = numbers.length - 1;
        do {
            int k = last;
            flag = false;
            for (int i = 0; i < last; i++) {
                // System.out.println(last);
                if (numbers[i] < numbers[i + 1]) {
                    numbers[i] = numbers[i] ^ numbers[i + 1];
                    numbers[i + 1] = numbers[i] ^ numbers[i + 1];
                    numbers[i] = numbers[i] ^ numbers[i + 1];
                    flag = true;
                    k = i;
                }
            }
            last = k;
            // count++;
        } while (flag);
        // System.out.println(count);
        return numbers;
    }

    private int[] bubbleSortWrong(int[] numbers) {
        for (int i = 0; i < numbers.length; i++) {
            for (int j = i + 1; j < numbers.length - 1; j++) {
                if (numbers[i] < numbers[j]) {
                    numbers[i] = numbers[i] ^ numbers[j];
                    numbers[j] = numbers[i] ^ numbers[j];
                    numbers[i] = numbers[i] ^ numbers[j];
                }
            }
        }
        return numbers;
    }

    private int[] bubbleSortCommon(int[] numbers) {
        for (int i = 0; i < numbers.length; i++) {
            for (int j = numbers.length - 1; j > i; j--) {
                if (numbers[j - 1] > numbers[j]) {
                    numbers[j - 1] = numbers[j] ^ numbers[j - 1];
                    numbers[j] = numbers[j - 1] ^ numbers[j];
                    numbers[j - 1] = numbers[j] ^ numbers[j - 1];
                }
            }
        }
        return numbers;
    }
}
