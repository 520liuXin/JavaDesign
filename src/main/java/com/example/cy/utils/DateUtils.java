package com.example.cy.utils;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

@Slf4j
public class DateUtils {

    /**
     * 得到当前系统日期,日期格式为"yyyy-MM-dd"
     *
     * @return String
     */
    public static String getCurrentDate() {
        String pattern = "yyyy-MM-dd";
        SimpleDateFormat df = new SimpleDateFormat(pattern);
        return df.format(new Date());
    }

    /**
     * 获取当前系统日期 , 格式:"yyyyMMdd"  如:20180608
     * @return
     */
    public static String getCurrentDateString() {
        String pattern = FORMAT_DATE_YYYYMMDD;
        SimpleDateFormat df = new SimpleDateFormat(pattern);
        return df.format(new Date());
    }

    /**
     * 日期格式yyyyMMdd
     */
    public static String FORMAT_DATE_YYYYMMDD = "yyyyMMdd";
    /**
     * 日期格式yyyy-MM-dd
     */
    public static String FORMAT_DATE_YYYY_MM_DD = "yyyy-MM-dd";

    public static String FORMAT_DATE_hhmmss = "hhmmss";





    /**
     * 获取当前系统时间戳
     * @return
     */
    public static Date getCurrentTimestamp() {
        return new Timestamp(System.currentTimeMillis());
    }

    public static Timestamp getTimestamp(Date date) {
        return new Timestamp(date.getTime());
    }

    /**
     * @Author able-liu
     * @Description  将短时间格式时间转换为字符串 yyyy-MM-dd
     * @Param
     * @return
     **/
    public static Date strToDate(String str) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date date = null;
        try {
            date = format.parse(str);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }


    /**
     *  当前时间戳
     * @param date
     * @return
     */
    public static String getCurrentTimeStamp(Date date) {
        return getDateTimeFormat().format(date);
    }

    public static SimpleDateFormat getDateTimeFormat() {
        SimpleDateFormat dateTimeFormat = new SimpleDateFormat();
        dateTimeFormat.applyPattern("yyyyMMddHHmmssSSS");
        return dateTimeFormat;
    }

    /**
     * 获取当前系统时间戳
     * @return
     */
    public static String getCurrentTimestampString() {
        String timestamp = new Timestamp(System.currentTimeMillis()).toString();
        return "to_timestamp('" + timestamp + "','yyyy-mm-dd hh24:mi:ss.ff')";
    }



    /**
     * 输入符合格式要求的日期字符串，返回日期类型变量
     *
     * @param dateString
     * @return Date
     * @throws ParseException
     */
    public static Date getDate(String dateString) throws ParseException {
        Date date = null;
        if (dateString != null && !"".equals(dateString)) {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat(
                    "yyyy-MM-dd");
            date = simpleDateFormat.parse(dateString);
            log.info("date:" + date.toString());
        }
        log.info("dateString:" + dateString);

        return date;
    }

    /**
     * 输入日期类型变量，返回日期字符串
     * 如:2018-06-08 15:46:09
     *
     * @param date
     * @return String
     */
    public static String getDateString(Date date) {
        String dateString = null;
        if (date != null) {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            dateString = simpleDateFormat.format(date);
        }
        return dateString;
    }


    /**
     * 输入日期类型变量，返回日期int
     *
     * @param date
     * @return String
     */
    public static Integer getDateInteger(Date date) {
        String dateString = getDateString(date);
        Integer dateNum = Integer.parseInt(dateString.replace("-", ""));
        return dateNum;
    }


    public static String getShotDate(Date date) {
        if (date == null) {
            return "";
        }
        return dateStr(date, "yyyy-MM-dd");
    }

    /**
     * 日期转换为字符串 格式自定义
     *
     * @param date
     * @param f
     * @return
     */
    public static String dateStr(Date date, String f) {
        if (date == null) {
            return "";
        }
        SimpleDateFormat format = new SimpleDateFormat(f);
        String str = format.format(date);
        return str;
    }

    /**
     * 计算两个日期之间相差的天数
     *
     * @param date1
     * @param date2
     * @return date1>date2时结果<0,  date1=date2时结果=0, date2>date1时结果>0
     */
    public static int daysBetween(Date date1, Date date2) {
        DateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        Calendar cal = Calendar.getInstance();
        try {
            Date d1 = sdf.parse(DateUtils.dateStr(date1, "yyyyMMdd"));
            Date d2 = sdf.parse(DateUtils.dateStr(date2, "yyyyMMdd"));
            cal.setTime(d1);
            long time1 = cal.getTimeInMillis();
            cal.setTime(d2);
            long time2 = cal.getTimeInMillis();
            return Integer.parseInt(String.valueOf((time2 - time1) / 86400000L));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return 0;
    }




    public static void main(String[] arys){
        String s="2019-01-21";
        String s1="2019-03-20";
        Date date=strToDate(s);
        Date date1=strToDate(s1);
        int i=daysBetween(date,date1)+1;
        System.out.println(i);
    }



}