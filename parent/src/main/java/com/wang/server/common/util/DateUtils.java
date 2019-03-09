package com.wang.server.common.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public class DateUtils {

    private static String ymdhms = "yyyy-MM-dd HH:mm:ss";
    private static String ymd = "yyyy-MM-dd";
    public static SimpleDateFormat ymdSDF = new SimpleDateFormat(ymd);
    private static String year = "yyyy";
    private static String month = "MM";
    private static String day = "dd";
    public static SimpleDateFormat yyyyMMddHHmmss = new SimpleDateFormat(ymdhms);
    public static SimpleDateFormat yearSDF = new SimpleDateFormat(year);
    public static SimpleDateFormat monthSDF = new SimpleDateFormat(month);
    public static SimpleDateFormat daySDF = new SimpleDateFormat(day);

    public static SimpleDateFormat yyyyMMddHHmm = new SimpleDateFormat("yyyy-MM-dd HH:mm");

    public static SimpleDateFormat yyyyMMddHH = new SimpleDateFormat("yyyy-MM-dd HH");

    public static SimpleDateFormat yyyyMMdd = new SimpleDateFormat("yyyy-MM-dd");

    public static SimpleDateFormat yyyyMMddHH_NOT_ = new SimpleDateFormat("yyyyMMdd");

    public static long DATEMM = 86400L;

    public static String dateFormat(Date date, String f) {
        SimpleDateFormat df = new SimpleDateFormat(f);
        return df.format(date);
    }

    public static String getCurrentTime() {
        return yyyyMMddHHmmss.format(new Date());
    }

    public static String getYesterdayYYYYMMDD() {
        Date date = new Date(System.currentTimeMillis() - DATEMM * 1000L);
        String str = yyyyMMdd.format(date);
        try {
            date = yyyyMMddHHmmss.parse(str + " 00:00:00");
            return yyyyMMdd.format(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return "";
    }

    public static String getStrDate(String backDay) {
        Calendar calendar = Calendar.getInstance();
        calendar.add(5, Integer.parseInt("-" + backDay));
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String back = sdf.format(calendar.getTime());
        return back;
    }

    public static String getCurrentYear() {
        return yearSDF.format(new Date());
    }

    public static String getCurrentMonth() {
        return monthSDF.format(new Date());
    }

    public static String getCurrentDay() {
        return daySDF.format(new Date());
    }

    public static String getCurrentymd() {
        return ymdSDF.format(new Date());
    }

    public static long getTimeNumberToday() {
        Date date = new Date();
        String str = yyyyMMdd.format(date);
        try {
            date = yyyyMMdd.parse(str);
            return date.getTime() / 1000L;
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return 0L;
    }

    public static String getTodateString() {
        String str = yyyyMMddHH_NOT_.format(new Date());
        return str;
    }

    public static String getYesterdayString() {
        Date date = new Date(System.currentTimeMillis() - DATEMM * 1000L);
        String str = yyyyMMddHH_NOT_.format(date);
        return str;
    }

    public static Date getYesterDayZeroHour() {
        Calendar cal = Calendar.getInstance();
        cal.add(5, -1);
        cal.set(13, 0);
        cal.set(12, 0);
        cal.set(10, 0);
        return cal.getTime();
    }

    public static String longToString(long date, String format) {
        SimpleDateFormat sdf = new SimpleDateFormat(format);

        Date dt2 = new Date(date * 1000L);
        String sDateTime = sdf.format(dt2);
        return sDateTime;
    }

    public static Date getTodayZeroHour() {
        Calendar cal = Calendar.getInstance();
        cal.set(13, 0);
        cal.set(12, 0);
        cal.set(10, 0);
        return cal.getTime();
    }

    public static Date getYesterDay24Hour() {
        Calendar cal = Calendar.getInstance();
        cal.add(5, -1);
        cal.set(13, 59);
        cal.set(12, 59);
        cal.set(10, 23);
        return cal.getTime();
    }

    public static Date stringToDate(String date, String format) {
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        try {
            return sdf.parse(date);
        } catch (ParseException e) {
        }
        return null;
    }

    public static Date getStartDayOfWeek(Date date) {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.set(7, 1);
        date = c.getTime();
        return date;
    }

    public static Date getStartDayOfMonth(Date date) {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.set(5, 1);
        date = c.getTime();
        return date;
    }

    public static Date getLastDayOfMonth(Date date) {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.set(5, 1);
        c.add(2, 1);
        c.add(5, -1);
        date = c.getTime();
        return date;
    }

    public static Date getStartDayOfNextMonth(Date date) {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.add(2, 1);
        c.set(5, 1);
        date = c.getTime();
        return date;
    }

    public static Date getLastDayOfNextMonth(Date date) {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.set(5, 1);
        c.add(2, 2);
        c.add(5, -1);
        date = c.getTime();
        return date;
    }

    public static String givedTimeToBefer(String givedTime, long interval, String format_Date_Sign) {
        String tomorrow = null;
        try {
            SimpleDateFormat sdf = new SimpleDateFormat(format_Date_Sign);
            Date gDate = sdf.parse(givedTime);
            long current = gDate.getTime();
            long beforeOrAfter = current - interval * 1000L;
            Date date = new Date(beforeOrAfter);
            tomorrow = new SimpleDateFormat(format_Date_Sign).format(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return tomorrow;
    }

    public static long stringToLong(String date, String format) {
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        Date dt2 = null;
        long lTime = 0L;
        try {
            dt2 = sdf.parse(date);

            lTime = dt2.getTime() / 1000L;
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return lTime;
    }

    public static Map<String, String> getTwoDay(String endTime, String beginTime, boolean isEndTime) {
        Map<String, String> result = new HashMap<String, String>();
        if ((endTime == null) || (endTime.equals("")) || (beginTime == null) || (beginTime.equals(""))) {
            return null;
        }
        try {
            Date date = ymdSDF.parse(endTime);
            endTime = ymdSDF.format(date);
            Date mydate = ymdSDF.parse(beginTime);
            long day = (date.getTime() - mydate.getTime()) / 86400000L;

            result = getDate(endTime, Integer.valueOf(Integer.parseInt(day + "")), isEndTime);
        } catch (Exception localException) {
        }
        return result;
    }

    public static Integer getTwoDayInterval(String endTime, String beginTime, boolean isEndTime) {
        if ((endTime == null) || (endTime.equals("")) || (beginTime == null) || (beginTime.equals(""))) {
            return Integer.valueOf(0);
        }
        long day = 0L;
        try {
            Date date = ymdSDF.parse(endTime);
            endTime = ymdSDF.format(date);
            Date mydate = ymdSDF.parse(beginTime);
            day = (date.getTime() - mydate.getTime()) / 86400000L;
        } catch (Exception e) {
            return Integer.valueOf(0);
        }
        return Integer.valueOf(Integer.parseInt(day + ""));
    }

    public static Map<String, String> getDate(String endTime, Integer interval, boolean isEndTime) {
        Map<String, String> result = new HashMap<String, String>();
        if (((interval.intValue() == 0) || (isEndTime)) && (isEndTime)) {
            result.put(endTime, endTime);
        }
        if (interval.intValue() > 0) {
            int begin = 0;
            for (int i = begin; i < interval.intValue(); i++) {
                endTime = givedTimeToBefer(endTime, DATEMM, ymd);
                result.put(endTime, endTime);
            }
        }
        return result;
    }

    public static String dateToString(Date date, String format) {
        SimpleDateFormat f = new SimpleDateFormat(format);
        return f.format(date);
    }

    public static Date StringToDate(String str, String format) {
        SimpleDateFormat f = new SimpleDateFormat(format);
        Date date = null;
        try {
            date = f.parse(str);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }

    public static int getDayNumOfCurrentMonth() {
        Calendar calendar = Calendar.getInstance(Locale.CHINA);
        int day = calendar.getActualMaximum(5);
        return day;
    }

    /**
     * 字符串转日期
     *
     * @param dateStr 字符串
     * @param pattern 字符串格式
     * @return
     * @throws ParseException
     */
    public static Date parseDate(String dateStr, String pattern) {
        try {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
            return simpleDateFormat.parse(dateStr);
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
    }
    public static int getTwoDayInterval(Date startTime, Date endTime) {
        Long changeStart = Long.valueOf(startTime.getTime());
        Long changeEnd = Long.valueOf(endTime.getTime());
        int intervalDays = (int) ((changeEnd.longValue() - changeStart.longValue()) / 86400000L);
        return intervalDays;
    }

    public static int getTwoDayIntervalYMD(Date startTime, Date endTime) throws ParseException {
        Long changeStart = Long.valueOf(getYmdDate(startTime).getTime());
        Long changeEnd = Long.valueOf(getYmdDate(endTime).getTime());
        int intervalDays = (int) ((changeEnd.longValue() - changeStart.longValue()) / 86400000L);
        return intervalDays;
    }

    public static Date getYmdDate(Date date) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat(ymd);
        String changeDate = sdf.format(date);
        Date getYmd = sdf.parse(changeDate);
        return getYmd;
    }

    public static String getYmdFormarDate(Date date) {
        SimpleDateFormat sdf = new SimpleDateFormat(ymd);
        String dateFormat = sdf.format(date);
        return dateFormat;
    }

    public static Date StringToDate(String str) {
        if (str == null)
            return null;
        String format = null;
        if (str.length() == ymd.length())
            format = ymd;
        else if (str.length() == ymdhms.length())
            format = ymdhms;
        else {
            return null;
        }

        SimpleDateFormat f = new SimpleDateFormat(format);
        Date date = null;
        try {
            date = f.parse(str);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }

    public static boolean startEnd(Date startTime, Date endTime) {
        if ((startTime == null) || ("".equals(startTime.toString())) || (endTime == null) || ("".equals(endTime.toString()))) {
            return false;
        }
        long startChange = startTime.getTime();
        long endChanege = endTime.getTime();
        if (endChanege - startChange < 0L) {
            return false;
        }
        return true;
    }

    public static int getField(Date date, int calendarField) {
        Calendar instance = createCalendar();
        instance.setTime(date);
        return instance.get(calendarField);
    }

    public static Date truncateDate(Date date, int calendarField) {
        Calendar instance = createCalendar();
        instance.setTime(date);

        int[] fields = {11, 12, 13, 14};
        boolean found = false;
        for (int i : fields) {
            if ((found) || (calendarField == i)) {
                found = true;
                instance.set(i, 0);
            }
        }
        return instance.getTime();
    }

    public static int getYear(Date date) {
        Calendar c = createCalendar();
        c.setTime(date);
        return c.get(1);
    }

    public static int getIntervalDays(Date fDate, Date oDate) {
        if ((null == fDate) || (null == oDate)) {
            return -1;
        }
        long intervalMilli = oDate.getTime() - fDate.getTime();
        return (int) (intervalMilli / 86400000L);
    }

    public static boolean isNextDate(Date fDate, Date oDate) {
        if ((null == fDate) || (null == oDate)) {
            return false;
        }
        return getIntervalDays(fDate, oDate) == 1;
    }

    public static boolean isSameDate(Date fDate, Date oDate) {
        if ((null == fDate) || (null == oDate)) {
            return false;
        }
        return getIntervalDays(fDate, oDate) == 0;
    }

    public static int getWeekOfYear(Date date) {
        Calendar c = createCalendar();

        c.setMinimalDaysInFirstWeek(7);
        c.setTime(date);
        return c.get(3);
    }

    public static int getMaxWeekNumOfYear(int year) {
        Calendar c = createCalendar();
        c.set(year, 11, 31, 23, 59, 59);

        return getWeekOfYear(c.getTime());
    }

    public static Date getFirstDayOfWeek(int year, int week) {
        Calendar c = createCalendar();
        c.setMinimalDaysInFirstWeek(7);
        c.set(1, year);
        c.set(3, week);
        c.set(7, 2);
        return getFirstDayOfWeek(c.getTime());
    }

    public static Date getLastDayOfWeek(int year, int week) {
        Calendar c = createCalendar();
        c.setMinimalDaysInFirstWeek(7);
        c.set(1, year);
        c.set(3, week);
        c.set(7, 2);
        c.add(5, 6);
        return getLastDayOfWeek(c.getTime());
    }

    public static Date getFirstDayOfWeek(Date date) {
        Calendar c = createCalendar();
        c.setTime(date);
        c.set(7, c.getFirstDayOfWeek());
        return c.getTime();
    }

    private static Calendar createCalendar() {
        Calendar c = Calendar.getInstance();
        c.setFirstDayOfWeek(2);
        return c;
    }

    public static Date getLastDayOfWeek(Date date) {
        Calendar c = createCalendar();
        c.setTime(date);
        c.set(7, c.getFirstDayOfWeek() + 6);
        return c.getTime();
    }

    public static Date getFirstDayOfWeek() {
        Calendar c = createCalendar();
        c.set(7, c.getFirstDayOfWeek());
        return c.getTime();
    }

    public static Date getLastDayOfWeek() {
        Calendar c = createCalendar();
        c.set(7, c.getFirstDayOfWeek() + 6);
        return c.getTime();
    }

    public static Date getBeforeTime(Date time, int before) {
        Calendar calendar = createCalendar();
        calendar.setTime(time);
        calendar.add(11, -before);
        return calendar.getTime();
    }

    public static Date getBeforeWeek(Date date, int n) {
        Calendar calendar = createCalendar();
        calendar.setTime(date);
        calendar.add(3, -n);
        return calendar.getTime();
    }

    public static Date getBeforeDay(Date date, int n) {
        Calendar calendar = createCalendar();
        calendar.setTime(date);
        calendar.add(6, -n);
        return calendar.getTime();
    }

    public static Date getBeforeHour(int n) {
        return getBeforeHour(new Date(), n);
    }

    public static Date getBeforeHour(Date date, int n) {
        Calendar calendar = createCalendar();
        calendar.setTime(date);
        calendar.add(11, -n);
        return calendar.getTime();
    }

    public static double getDayDifference(Date d1, Date d2) {
        return (d2.getTime() - d1.getTime()) / 1000L / 60L / 60L / 24L;
    }

    public static Date compareDate(Date date1, Date date2, int type) {
        if ((date1 == null) && (date2 == null)) {
            return null;
        }
        if (date1 == null) {
            return date2;
        }
        if (date2 == null) {
            return date1;
        }
        if (type == 1) {
            return date1.getTime() >= date2.getTime() ? date2 : date1;
        }
        if (type == 2) {
            return date1.getTime() < date2.getTime() ? date2 : date1;
        }
        return null;
    }


    /**
     * 判断date1是否大于等于date2
     * 调用方自行判断date1和date2不为空 才能调此方法
     * @param date1
     * @param date2
     * @return true date1大于等于date2
     */
    public static boolean compareDate(Date date1, Date date2) {
        return date1.getTime() >= date2.getTime();
    }
}
