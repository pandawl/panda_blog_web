package com.panda.threadPool;

import java.util.Arrays;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ThreadFactory;

/**
 * 类功能简述：
 * 类功能详述：线程工厂
 *
 * @author: fanxb
 * @date: 2018/10/12 11:29
 */
public class CustomThreadFactory implements ThreadFactory {

    /**
     * 记录创建线程数
     */
    private int counter;
    /**
     * 线程工程名
     */
    private String name;
    /**
     * 记录最近1000条创建历史
     */
    private List<String> history;

    private int historyLength;

    public CustomThreadFactory(String name) {
        this.name = name;
        this.history = new LinkedList<>();
        this.historyLength = 1000;
    }

    @Override
    public Thread newThread(Runnable r) {
        Thread t = new Thread(r, name + "-Thread-" + counter);
        this.counter++;
        history.add(String.format("Created thread %d with name %s on %s \n", t.getId(), t.getName(), new Date().toString()));
        if (history.size() >= this.historyLength) {
            history.remove(0);

        }
        return t;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        this.history.forEach(builder::append);
        return builder.toString();
    }

    public static void main(String[] args) {
        // 快速排序
        // 0 1  2 3 4 5 下标
        // 6 12 7 3 8 9 数组
        int[] arr = {1, 4, 7, 2, 5, 8, -4, -12};
        sort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));

    }

    /**
     * @param arr  排序的数组
     * @param low
     * @param high
     */
    public static void sort(int[] arr, int low, int high) {
        // int i ,j光标
        if (low >= high) {
            return;
        }
        int i = low;
        int j = high;
        int key = arr[i];//起始光标值
        while (i < j) {
            while (arr[j] >= key && i < j) {
                j--;
            }
            int t;//中间变量
            if (i < j) {

                t = arr[j];
                arr[j] = arr[i];
                arr[i] = t;
            }
            while (arr[i] <= key && i < j) {
                i++;
            }
            if (i < j) {
                t = arr[i];
                arr[i] = arr[j];
                arr[j] = t;
            }
        }
        //对基准左侧和右侧在排序
        sort(arr, low, i - 1);
        sort(arr, i + 1, high);
    }
}
