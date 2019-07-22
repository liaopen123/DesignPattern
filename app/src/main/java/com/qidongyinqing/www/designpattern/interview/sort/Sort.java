package com.qidongyinqing.www.designpattern.interview.sort;

import android.util.Log;

import java.util.Arrays;

public class Sort {


    private static final String TAG = "Sort";
    private static int[] array = {9, 3, 6, 4, 7, 5, 1, 2, 8};


    public static void chooseShort() {
        for (int i = 0; i < array.length; i++) {

            for (int k = i + 1; k < array.length; k++) {
                if (array[k] < array[i]) {
                    array[k] = array[k] + array[i];
                    array[i] = array[k] - array[i];
                    array[k] = array[k] - array[i];
                }
            }

        }
        Log.e(TAG, "冒泡排序得到的结果是:" + Arrays.toString(array));

    }


    public static void bubble1Short() {
        for (int i = 0; i < array.length; i++) {
            boolean hasEnded = true;
            for (int k = 0; k < array.length - 1 - i; k++) {
                if (array[k + 1] < array[k]) {
                    array[k] = array[k] + array[k + 1];
                    array[k + 1] = array[k] - array[k + 1];
                    array[k] = array[k] - array[k + 1];

                    hasEnded = false;
                }
            }


            if (hasEnded) {
                //如果已经结束
                Log.e(TAG, " 冒泡排序得到的结果是" + Arrays.toString(array));
            }
        }

        Log.e(TAG, "冒泡排序得到的结果是:" + Arrays.toString(array));

    }


    public static void insertionSorting() {
        // 插入排序
        int arr[] = {12, 5, 17, 16, 19, 23, 14, 52, 13};

        for (int i = 1; i < arr.length; i++) {
            int insertVal = arr[i];
            //insertVal准备和前一个数比较

            int index = i - 1;
            while (index >= 0 && insertVal < arr[index]) {
                //将arr[index]向后移动一位
                arr[index + 1] = arr[index];
                index--;
            }
            //将insertVal的值插入适当位置
            arr[index + 1] = insertVal;
        }

        Log.e(TAG, Arrays.toString(arr));

    }


    public static void replace() {

        for (int i = 0; i < array.length; i++) {
            if (array.length - i - 2 >= 0) {
                array[array.length - i - 1] = array[array.length - i - 2];
            }
        }


        Log.e(TAG, "replace的结果是：" + Arrays.toString(array));
    }

}
