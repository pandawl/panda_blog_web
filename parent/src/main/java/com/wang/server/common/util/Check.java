package com.wang.server.common.util;



import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import java.util.Map;

/**
 * 非空检查工具类
 *
 * @author shq
 *
 *
 */
public final class Check implements Serializable {

    /**
     * 判断字符串是否为空字符串
     *
     * @param s 字符串(可以是null)
     * @return true为空false不为空
     */
    public static boolean isEmpty(final String s) {
        return null == s || s.length() == 0;
    }


    /**
     * 判断boolean[] 是否非空
     *
     * @param value 布尔型数组
     * @return true不为空 false为空
     */
    public static boolean notEmpty(final boolean[] value) {
        return null != value && value.length > 0;
    }

    /**
     * 判断byte[] 是否为空
     *
     * @param value 字节数组
     * @return true不为空 false为空
     */
    public static boolean notEmpty(final byte[] value) {
        return null != value && value.length > 0;
    }

    /**
     * 判断char[] 是否非空
     *
     * @param value 字符数组
     * @return true不为空 false为空
     */
    public static boolean notEmpty(final char[] value) {
        return null != value && value.length > 0;
    }

    /**
     * 判断字符串是否非空
     *
     * @param s 字符串(可以是null)
     * @return true不为空, false为空
     */
    public static boolean notEmpty(final CharSequence s) {
        return null != s && s.length() > 0;
    }

    /**
     * 判断CharSequence[] 是否非空
     *
     * @param value CharSequence数组
     * @return true不为空 false为空
     */
    public static boolean notEmpty(final CharSequence[] value) {
        return null != value && value.length > 0;
    }

    /**
     * 判断Collection是否非空
     *
     * @param collection 集合
     * @return ture集合不为空, false集合为空
     */
    public static boolean notEmpty(final Collection<?> collection) {
        return null != collection && collection.size() > 0;
    }

    /**
     * 判断日期是否为空
     *
     * @param time Date日期
     * @return ture不为空, false为空
     */
    public static boolean notEmpty(final Date time) {
        return null != time && 0 != time.getTime() && -28800000L != time.getTime();
    }

    /**
     * 判断int型数组是否非空
     *
     * @param a 数组(可以是null)
     * @return true数组不为空, false数组为空
     */
    public static boolean notEmpty(final int[] a) {
        return null != a && a.length > 0;
    }

    /**
     * 判断Integer对象数组是否非空
     *
     * @param a 数组(可以是null)
     * @return true不为空false为空
     */
    public static boolean notEmpty(final Integer[] a) {
        return null != a && a.length > 0;
    }

    /**
     * 判断long型数组是否非空
     *
     * @param a 数组(可以是null)
     * @return true数组不为空false数组为空
     */
    public static boolean notEmpty(final long[] a) {
        return null != a && a.length > 0;
    }

    /**
     * 判断Long型数组是否非空
     *
     * @param a Long数组
     * @return true数组不为空false数组为空
     */
    public static boolean notEmpty(final Long[] a) {
        return null != a && a.length > 0;
    }

    /**
     * 判断Map是否非空
     *
     * @param map 映射
     * @return ture映射不为空, false映射为空
     */
    public static boolean notEmpty(final Map<?, ?> map) {
        return null != map && map.size() > 0;
    }

    /**
     * 判断Object[] 是否非空
     *
     * @param value Object数组
     * @return true数组不为空false数组为空
     */
    public static boolean notEmpty(final Object[] value) {
        return null != value && value.length > 0;
    }

    /**
     * 判断字符串是否非空
     *
     * @param s 字符串(可以是null)
     * @return true字符串不为空, false字符串为空
     */
    public static boolean notEmpty(final String s) {
        return null != s && s.length() > 0;
    }

    /**
     * 判断字符串数组是否非空
     *
     * @param a 数组(可以是null)
     * @return true数组不为空false数组为空
     */
    public static boolean notEmpty(final String[] a) {
        return null != a && a.length > 0;
    }

    /**
     * 判断Long值是非空
     * @param value
     * @return true long值是非空或不为0
     */
    public static boolean notEmpty(final Long value) {
        return null != value && value != 0;
    }

    /**
     * 判断Long值是否为空
     * @param value Long值是null或0
     * @return
     */
    public static boolean isEmpty(final Long value) {
        return null == value || value == 0;
    }

}

