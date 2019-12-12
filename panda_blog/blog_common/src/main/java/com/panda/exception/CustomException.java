package com.panda.exception;


import com.panda.common.util.StringUtil;

import java.util.Arrays;

/**
 * 类功能简述： 自定义错误类，默认错误码为0,表示一般错误
 * 类功能详述：
 *
 * @author fanxb
 * @date 2019/3/19 18:09
 */
public class CustomException extends RuntimeException {

    private String message;
    private int code;

    public CustomException() {
        this(null, null, null);
    }

    public CustomException(String message) {
        this(message, null, null);
    }

    public CustomException(Exception e) {
        this(null, null, e);
    }

    public CustomException(String message, Exception e) {
        this(message, null, e);
    }

    public CustomException(String message, Integer code, Exception e) {
        super(e);
        this.message = message == null ? "" : message;
        this.code = code == null ? 0 : code;
    }

    @Override
    public String getMessage() {
        if (StringUtil.isEmpty(this.message)) {
            return super.getMessage();
        } else {
            return this.message;
        }
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public static void main(String[] args) {
        int[] arr = {5, 3, 8, 1, 6, 7, 2, 4};
        sort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));

    }

    public static void sort(int[] arr, int start, int end) {
        if (start >= end) {
            return;
        }
        int i = start;
        int j = end;
        int key = arr[start];
        //后面值比基准值大
        while (i < j) {
            while (arr[j] >= key && i < j) {
                j--;
            }
            //当前值比基准值小
            int t;
            t = arr[j];
            arr[j] = arr[i];
            arr[i] = t;

            while (arr[i] <= key && i < j) {
                i++;
            }
            t = arr[i];
            arr[i] = arr[j];
            arr[j] = t;
        }
        //排序左边
        sort(arr, start, i - 1);
        sort(arr, i + 1, end);
    }
}
