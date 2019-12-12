package com.panda.common.util;

import org.apache.commons.lang3.time.DateUtils;

import java.text.ParseException;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * 时间工具类
 *
 * @author :wl
 * @date 09.28.2018
 */
public class MyDateUtils {
    /**
     * 获取现在时间
     *
     * @return 返回短时间字符串格式yyyy-MM-dd
     */
    public static String getStringDateShort() {
        Date currentTime = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        String dateString = formatter.format(currentTime);
        return dateString;
    }

    public static String getStringDateLong() {
        Date currentTime = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String dateString = formatter.format(currentTime);
        return dateString;
    }

    /**
     * 将长时间格式字符串转换为时间 yyyy-MM-dd HH:mm:ss
     *
     * @param strDate
     * @return
     */
    public static Date strToDateLong(String strDate) {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        ParsePosition pos = new ParsePosition(0);
        return formatter.parse(strDate, pos);
    }

    /**
     * 将短时间格式字符串转换为时间 yyyy-MM-dd
     *
     * @param strDate
     * @return
     */
    public static Date strToDate(String strDate) {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        ParsePosition pos = new ParsePosition(0);
        return formatter.parse(strDate, pos);
    }

    /**
     * 获得指定日期的后一天
     *
     * @param specifiedDay
     * @return
     */
    public static String getDayAfter(String specifiedDay) throws ParseException {
        Calendar c = Calendar.getInstance();
        Date date = new SimpleDateFormat("yyyy-MM-dd").parse(specifiedDay);
        c.setTime(date);
        int day = c.get(Calendar.DATE);
        c.set(Calendar.DATE, day + 1);
        String dayAfter = new SimpleDateFormat("yyyy-MM-dd").format(c.getTime());
        return dayAfter;
    }

    /**
     * 获取指定日期的前7天
     *
     * @param specifiedDay
     * @return
     * @throws ParseException
     */
    public static String getDayWeek(String specifiedDay) throws ParseException {
        Calendar c = Calendar.getInstance();
        Date date = new SimpleDateFormat("yyyy-MM-dd").parse(specifiedDay);
        c.setTime(date);
        int day = c.get(Calendar.DATE);
        c.set(Calendar.DATE, day - 7);
        String dayAfter = new SimpleDateFormat("yyyy-MM-dd").format(c.getTime());
        return dayAfter;
    }


    /**
     * 获得指定日期的前一天
     *
     * @param specifiedDay
     * @return
     */
    public static String getDayBefore(String specifiedDay) throws ParseException {
        Calendar c = Calendar.getInstance();
        Date date = new SimpleDateFormat("yyyy-MM-dd").parse(specifiedDay);
        c.setTime(date);
        int day = c.get(Calendar.DATE);
        c.set(Calendar.DATE, day - 1);
        String dayAfter = new SimpleDateFormat("yyyy-MM-dd").format(c.getTime());
        return dayAfter;
    }

    /**
     * 获得指定日期的前一天
     *
     * @param specifiedDay
     * @return
     */
    public static String getMonBefore(String specifiedDay) throws ParseException {
        Calendar c = Calendar.getInstance();
        Date date = new SimpleDateFormat("yyyy-MM-dd").parse(specifiedDay);
        c.setTime(date);
        int day = c.get(Calendar.DATE);
        c.set(Calendar.DATE, day - 30);
        String dayAfter = new SimpleDateFormat("yyyy-MM-dd").format(c.getTime());
        return dayAfter;
    }

    /**
     * 获得指定日期的前一年
     *
     * @param specifiedDay
     * @return
     */
    public static String getYearBefore(String specifiedDay) throws ParseException {
        Calendar c = Calendar.getInstance();
        Date date = new SimpleDateFormat("yyyy-MM-dd").parse(specifiedDay);
        c.setTime(date);
        c.add(Calendar.YEAR, -1);
        String dayAfter = new SimpleDateFormat("yyyy-MM-dd").format(c.getTime());
        return dayAfter;
    }


    /**
     * 获取开始结束时间内每一天
     *
     * @param dBegin1
     * @param dEnd1
     * @return
     */
    public static List<String> findDatess(String dBegin1, String dEnd1) {
        List<String> lDate = new ArrayList<>();
        Date dBegin = null;
        Date dEnd = null;
        try {
            dBegin = DateUtils.parseDate(dBegin1, "yyyy-MM-dd");
            dEnd = DateUtils.parseDate(dEnd1, "yyyy-MM-dd");
        } catch (ParseException e) {
            e.printStackTrace();
        }
        lDate.add(dBegin1);
        Calendar calBegin = Calendar.getInstance();
        calBegin.setTime(dBegin);
        Calendar calEnd = Calendar.getInstance();
        calEnd.setTime(dEnd);
        while (dEnd.after(calBegin.getTime())) {
            calBegin.add(Calendar.DAY_OF_MONTH, 1);
            String dayAfter = new SimpleDateFormat("yyyy-MM-dd").format(calBegin.getTime());
            lDate.add(dayAfter);
        }
        return lDate;
    }

    public static void main(String[] args) throws ParseException {


        System.out.println(getYearBefore("2019-02-28"));
    }
}
