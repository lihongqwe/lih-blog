package com.lih.blogcommon.utils;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAccessor;

public class DateUtils {

    public static final String DATETIME_PATTERN = "yyyy-MM-dd HH:mm:ss";

    public static final String DATE_PATTERN = "yyyy-MM-dd";

    public static final String TIME_PATTERN = "HH:mm:ss";

    public static final String UNSIGNED_DATETIME_PATTERN = "yyyyMMddHHmmss";

    public static final String UNSIGNED_DATE_PATTERN = "yyyyMMdd";

    /**
     * 获取当前日期和时间字符串.
     *
     * @return 日期时间字符串
     */
    public static String getLocalDateTimeStr() {
        return format(LocalDateTime.now(), DATETIME_PATTERN);
    }

    /**
     * 获取无符号的当前日期和时间字符串.
     *
     * @return 无符号日期时间字符串
     */
    public static String getUnsignedLocalDateTimeStr() {
        return format(LocalDateTime.now(), UNSIGNED_DATETIME_PATTERN);
    }

    /**
     * 获取当前日期字符串.
     *
     * @return 日期字符串
     */
    public static String getLocalDateStr() {
        return format(LocalDate.now(), DATE_PATTERN);
    }

    /**
     * 获取当前时间字符串.
     *
     * @return 时间字符串
     */
    public static String getLocalTimeStr() {
        return format(LocalTime.now(), TIME_PATTERN);
    }

    /**
     * 获取日期时间字符串
     *
     * @param temporal 需要转化的日期时间
     * @param pattern  时间格式
     * @return 目标字符串
     */
    public static String format(TemporalAccessor temporal, String pattern) {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern(pattern);
        return dateTimeFormatter.format(temporal);
    }

}
