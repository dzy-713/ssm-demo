package com.rl.mes.util;

import org.joda.time.DateTime;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;

/**
 * 时间工具类
 * Created by douzy on 2017/10/13.
 */
public class DateUtil {
    public DateUtil() {
    }

    public static final boolean eqCompare(Date date1, Date date2) {
        return date1.getTime() == date2.getTime();
    }

    /**
     * date1 晚于 date2 则返回 true
     *
     * @param date1
     * @param date2
     * @return
     */
    public static final boolean gtCompare(Date date1, Date date2) {
        return date1.getTime() > date2.getTime();
    }

    /**
     * date1 早于 date2 则返回 true
     *
     * @param date1
     * @param date2
     * @return
     */
    public static final boolean ltCompare(Date date1, Date date2) {
        return date1.getTime() < date2.getTime();
    }

    public static final Date dayAdd(int dayNum) {
        return dayAdd(new Date(), dayNum);
    }

    public static Date dayAdd(Date myDate, int dayNum) {
        Calendar endDateCal = Calendar.getInstance();
        endDateCal.setTime(myDate);
        endDateCal.set(Calendar.DATE, endDateCal.get(Calendar.DATE) + dayNum);
        return endDateCal.getTime();
    }

    public static Date minuteAdd(int num) {
        return minuteAdd(new Date(), num);
    }

    public static Date minuteAdd(Date myDate, int num) {
        Calendar endDateCal = Calendar.getInstance();
        endDateCal.setTime(myDate);
        endDateCal.set(Calendar.MINUTE, endDateCal.get(Calendar.MINUTE) + num);
        return endDateCal.getTime();
    }

    public static final Date secondAdd(int secondNum) {
        return secondAdd(new Date(), secondNum);
    }

    public static Date secondAdd(Date myDate, int secondNum) {
        Calendar endDateCal = Calendar.getInstance();
        endDateCal.setTime(myDate);
        endDateCal.set(Calendar.SECOND, endDateCal.get(Calendar.SECOND) + secondNum);
        return endDateCal.getTime();
    }

    public static Date monthAdd(Date myDate, int num) {
        Calendar endDateCal = Calendar.getInstance();
        endDateCal.setTime(myDate);
        endDateCal.set(Calendar.MONDAY, endDateCal.get(Calendar.MONDAY) + num);
        return endDateCal.getTime();
    }

    public static Date monthAdd(int num) {
        return monthAdd(new Date(), num);
    }

    public static final int getYear() {
        GregorianCalendar gcDate = new GregorianCalendar();
        return gcDate.get(Calendar.YEAR);
    }

    public static final int getMonth() {
        GregorianCalendar gcDate = new GregorianCalendar();
        return gcDate.get(Calendar.MONDAY) + 1;
    }

    public static final int getDay() {
        GregorianCalendar gcDate = new GregorianCalendar();
        return gcDate.get(Calendar.DATE);
    }

    public static final int getDaysOfMonth() {
        GregorianCalendar gcDate = new GregorianCalendar();
        return gcDate.getActualMaximum(5);
    }

    public static final double hourDiff(Date beginDate, Date endDate) {
        long beginTime = beginDate.getTime();
        long endTime = endDate.getTime();
        double betweenHour = (double) ((endTime - beginTime) / 3600000L) + 0.1D;
        return betweenHour;
    }

    public static Date hourDiff(Date myDate, int hourNum) {
        long myTime = myDate.getTime() - (long) (3600000 * hourNum);
        return new Date(myTime);
    }

    public static final int dayDiff(Date beginDate, Date endDate) {
        long beginTime = beginDate.getTime();
        long endTime = endDate.getTime();
        double betweenDays = (double) ((endTime - beginTime) / 86400000L) + 0.1D;
        return (int) betweenDays;
    }

    public static final int monthDiff(Date beginDate, Date endDate) {
        GregorianCalendar gcBeginDate = new GregorianCalendar();
        gcBeginDate.setTime(beginDate);
        GregorianCalendar gcEndDate = new GregorianCalendar();
        gcEndDate.setTime(endDate);
        int beginYear = gcBeginDate.get(1);
        int endYear = gcEndDate.get(1);
        int beginMonth = gcBeginDate.get(2) + 1;
        int endMonth = gcBeginDate.get(2) + 1;
        return 12 * (endYear - beginYear) + endMonth - beginMonth;
    }

    public static final int yearDiff(Date beginDate, Date endDate) {
        GregorianCalendar gcBeginDate = new GregorianCalendar();
        gcBeginDate.setTime(beginDate);
        GregorianCalendar gcEndDate = new GregorianCalendar();
        gcEndDate.setTime(endDate);
        int beginYear = gcBeginDate.get(1);
        int endYear = gcEndDate.get(1);
        return endYear - beginYear;
    }

    public static int getAge(Date birthDay) throws Exception {
        Calendar cal = Calendar.getInstance();
        if (cal.before(birthDay)) {
            throw new IllegalArgumentException("出生时间大于当前时间!");
        } else {
            int yearNow = cal.get(1);
            int monthNow = cal.get(2) + 1;
            int dayOfMonthNow = cal.get(5);
            cal.setTime(birthDay);
            int yearBirth = cal.get(1);
            int monthBirth = cal.get(2);
            int dayOfMonthBirth = cal.get(5);
            int age = yearNow - yearBirth;
            if (monthNow <= monthBirth) {
                if (monthNow == monthBirth) {
                    if (dayOfMonthNow < dayOfMonthBirth) {
                        --age;
                    }
                } else {
                    --age;
                }
            }

            return age;
        }
    }

    public static final Date formatDate(String dateStr) {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.SIMPLIFIED_CHINESE);

        try {
            Date e = formatter.parse(dateStr);
            return e;
        } catch (Exception var3) {
            return new Date();
        }
    }

    public static final Date formatDate(String dateStr, String format) {
        SimpleDateFormat formatter = new SimpleDateFormat(format);

        try {
            Date e = formatter.parse(dateStr);
            return e;
        } catch (Exception var4) {
            return new Date();
        }
    }

    public static final Date getDate() {
        Calendar now = Calendar.getInstance();
        now.setTime(getTime());
        now.set(11, 0);
        now.set(12, 0);
        now.set(13, 0);
        return now.getTime();
    }

    public static final String formatDate(Date dateTimeStr, String typ) {
        try {
            SimpleDateFormat e = new SimpleDateFormat(typ, Locale.SIMPLIFIED_CHINESE);
            e.applyPattern(typ);
            String mDateTime = e.format(dateTimeStr);
            return mDateTime;
        } catch (Exception var4) {
            return "";
        }
    }

    public static final String formatDate(Date dateTimeStr) {
        return formatDate(dateTimeStr, "yyyy-MM-dd");
    }

    public static final Date getTime() {
        Calendar cal = Calendar.getInstance();

        try {
            SimpleDateFormat e = new SimpleDateFormat("yyyy-MM-dd HH:mm", Locale.SIMPLIFIED_CHINESE);
            String mDateTime = e.format(cal.getTime());
            Date date = e.parse(mDateTime);
            return date;
        } catch (Exception var4) {
            return new Date();
        }
    }

    public static final Timestamp getTimestamp() {
        Date date = new Date();
        Timestamp timeStamp = new Timestamp(date.getTime());
        return timeStamp;
    }

    public static final Date getDateOfWeekStart(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        int dayOfWeek = cal.get(7) - 1;
        cal.add(5, -dayOfWeek);
        return cal.getTime();
    }

    public static final Date getDateOfWeekEnd(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        int dayOfWeek = cal.get(7) - 1;
        cal.add(5, -dayOfWeek);
        cal.add(5, 6);
        return cal.getTime();
    }

    public static String formatMillisecond(long mss, String[] lang, boolean full) {
        if (lang == null || lang.length < 4) {
            lang = new String[]{"D", "H", "M", "S"};
        }

        long days = mss / 86400000L;
        long hours = mss % 86400000L / 3600000L;
        long minutes = mss % 3600000L / 60000L;
        long seconds = mss % 60000L / 1000L;
        StringBuilder result = new StringBuilder();
        if (days > 0L && full) {
            result.append(days).append(" ").append(lang[0]);
        }

        if (days > 0L && !full) {
            return days + " " + lang[0];
        } else {
            if (hours > 0L && full) {
                result.append(hours).append(" ").append(lang[1]);
            }

            if (hours > 0L && !full) {
                return hours + " " + lang[1];
            } else {
                if (minutes > 0L && full) {
                    result.append(minutes).append(" ").append(lang[2]);
                }

                if (minutes > 0L && !full) {
                    return minutes + " " + lang[2];
                } else {
                    result.append(seconds).append(" ").append(lang[3]);
                    return result.toString();
                }
            }
        }
    }

    public static void main(String[] args) {
        Date begin = new DateTime("1990-01-01").toDate();
        Date end = new DateTime("1991-01-01").toDate();

        while (begin.getTime()<=end.getTime()){
            Date date1 = begin;
            Date date2 = new DateTime(begin).plusDays(1).toDate();
            double diffHour = (date2.getTime()-date1.getTime()) / 3600000L;
            System.out.println(DateUtil.formatDate(date1,"yyyy-MM-dd")+" 至 "+DateUtil.formatDate(date2,"yyyy-MM-dd")+" 相差小时:"+diffHour);
            begin = date2;
        }
    }
}