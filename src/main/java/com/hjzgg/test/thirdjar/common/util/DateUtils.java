package com.hjzgg.test.thirdjar.common.util;

import org.apache.commons.lang3.StringUtils;
import org.joda.time.DateTime;
import org.joda.time.Hours;
import org.joda.time.Minutes;
import org.joda.time.Seconds;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;


public final class DateUtils {

    /**
     * 默认日期格式: "yyyy-MM-dd"
     */
    public static final String DATE_DEFAULT_FORMAT = "yyyy-MM-dd";

    /**
     * 默认日期格式: "yyyy-MM-dd HH:mm:ss"
     */
    public static final String DATETIME_DEFAULT_FORMAT = "yyyy-MM-dd HH:mm:ss";

    public static final String HOUR_MINUTS = "HH:mm";

    /**
     * JD加密时间戳
     */
    public static final String SIGN_TIMESTAMP = "yyyy-MM-ddHH:mm:ss";

    public static final String MIN = "分";

    public static final String SEC = "秒";

    public static final String HOUR = "时";

    private static final int hour = 60 * 60; /*60秒 * 60分*/

    private static final int min = 60; /*60秒*/

    /**
     * 获取当前时间的秒数
     *
     * @return
     */
    public static int currentTimeSeconds() {
        Long currTime = System.currentTimeMillis() / 1000L;
        return (currTime.intValue());
    }

    /**
     * 将字符串时间转换为DateTime
     * @param date
     * @return
     */
    public static DateTime transfer(String date, String fmt) {
        DateTimeFormatter format = DateTimeFormat.forPattern(fmt);
        DateTime dateTime = DateTime.parse(date, format);
        return dateTime;
    }

    /**
     * 字符换时间转时间戳
     * @param date
     * @return
     */
    public static Integer dateStrToTimeStamp(String date, String fmt) {
        if (StringUtils.isBlank(date)) {
            return null;
        }
        DateTime dateTime = transfer(date, fmt);
        long millisOfSecond = dateTime.getMillis();
        return (int) (millisOfSecond / 1000);
    }

    /**
     * 将时间戳转换为默认日期格式: "yyyy-MM-dd HH:mm:ss"
     *
     * @param timeSecond int 类型的时间戳
     * @return
     */
    public static String formatTimeStampToString(Integer timeSecond) {
        // 因为传入的时间戳是10位的整数, 需要乘1000来弥补毫秒数的不足
        return formatTimeStampToString(timeSecond, DATE_DEFAULT_FORMAT);
    }

    /**
     * 将时间戳转换为自定义时间格式
     *
     * @param timeSecond int 类型的时间戳
     * @param format     需要格式化为String类型的日期格式
     * @return
     */
    public static String formatTimeStampToString(Integer timeSecond, String format) {
        if (null == timeSecond || timeSecond == 0) {
            return null;
        }
        // 因为传入的时间戳是10位的整数, 需要乘1000来弥补毫秒数的不足
        DateTime dateTime = new DateTime(timeSecond * 1000L);
        return dateTime.toString(format);
    }

    /**
     * 获取当前时间DateTime对象
     *
     * @return
     */
    public static DateTime getCurrentDateTime() {
        return new DateTime();
    }

    /**
     * 获取两个时间之间的时间差, 返回结果 X分
     *
     * @param d1
     * @param d2
     * @return
     */
    public static Integer getMinutesBetween(DateTime d1, DateTime d2) {
        return Minutes.minutesBetween(d1, d2).getMinutes();
    }

    /**
     * 获取两个时间之间的时间差, 返回结果 X秒
     *
     * @param d1
     * @param d2
     * @return
     */
    public static Integer getSecondsBetween(DateTime d1, DateTime d2) {
        return Seconds.secondsBetween(d1, d2).getSeconds();
    }

    /**
     * 获取小时差 返回结果X时
     *
     * @param d1
     * @param d2
     * @return
     */
    public static Integer getHoursBetween(DateTime d1, DateTime d2) {
        return Hours.hoursBetween(d1, d2).getHours();
    }

    /**
     * 获取时间差 返回结果 X时X分X秒
     *
     * @param d1
     * @param d2
     * @return
     */
    public static String getTimeBetween(DateTime d1, DateTime d2) {
        int before = (int) (d1.getMillis() / 1000);
        int after = (int) (d2.getMillis() / 1000);
        if (before > after) {
            int swap = before;
            before = after;
            after = swap;
        }
        int consume = after - before;
        StringBuffer sb = new StringBuffer();
        if (consume > hour) {
            int h = consume / hour;
            sb.append(h).append(HOUR);
        } else {
            sb.append(0).append(HOUR);
        }
        int minute = consume % hour;
        if (minute > min) {
            int m = minute / min;
            sb.append(m).append(MIN);
        } else {
            sb.append(0).append(MIN);
        }
        int second = minute % min;
        sb.append(second).append(SEC);
        return sb.toString();
    }
}
