package com.trump.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

/**
 * 时间工具类
 *
 * @author of753
 */
public final class DateUtil {

    /**
     * 私有构造
     */
    private DateUtil() {

    }

    public static String getDateTimePattern() {
        return "yyyy-MM-dd HH:mm:ss";
    }
    
    public static String getDatePatternString() {
        return "yyyy-MM-dd";
    }
    public static String dataFormat(Date date) {
        SimpleDateFormat time = new SimpleDateFormat("yyyyMMdd", Locale.UK);
        return time.format(date);
    }
    /**
     * 获取日期格式 yyyy-MM-dd
     * @param aDateStr
     * @return
     */
    public static String getDatePattern(String aDateStr) {
        SimpleDateFormat df = null;
        String returnValue = "";
        Date date = null;
        try
        {
            if (aDateStr != null) {
                df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                date = df.parse(aDateStr);
            }
            SimpleDateFormat sdft = new SimpleDateFormat(getDatePatternString());
            if (date != null) {
                returnValue = sdft.format(date);
            }
        }
        catch (ParseException e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return (returnValue);
    }
    
    /**
     * 获取日期格式 yyyy-MM-dd HH:mm:ss
     * @param aDate
     * @return
     */
    public static String getDateTime(Date aDate, String format) {
		SimpleDateFormat df = null;
		String returnValue = "";
		if (aDate != null) {
			if (!StringUtil.isEmpty(format)) {
				df = new SimpleDateFormat(format);
			} else {
				df = new SimpleDateFormat(getDateTimePattern());
			}
			returnValue = df.format(aDate);
		}
		return (returnValue);
    }
    
    public static String dateTime2Str(Date date, String format){
    	if(null != date){
    		return getDateTime(new Date(date.getTime()), format);
    	}else{
    		return "";
    	}
    }

    
    /**
     * @description 增加日期
     * @param date
     *            日期
     * @param i
     *            天数
     */
    public static String dateAdd(String date, int i) {
        Calendar cal = Calendar.getInstance();
        // 年
        int year = Integer.parseInt(date.substring(0, 4));
        cal.set(Calendar.YEAR, year);
        // 月，注意要减1，因为一月对应的是0
        int month = Integer.parseInt(date.substring(5, 7));
        cal.set(Calendar.MONTH, month - 1);
        // 日
        int day = Integer.parseInt(date.substring(8));
        cal.set(Calendar.DAY_OF_MONTH, day);
        // 如果想要得到第二天的日期就加1，如果超过了当月的最大天数，Calendar会自动处理
        cal.add(Calendar.DAY_OF_MONTH, i);
        return new SimpleDateFormat("yyyy-MM-dd").format(cal.getTime());
    }

    /**
     * 功能: 将插入的字符串按格式转换成对应的日期对象
     *
     * @param str 字符串
     * @param pattern 格式
     * @return Date
     */
    public static Date StringToDate(String str, String pattern)
    {
        Date dateTime = null;
        try
        {
            if (str != null && !str.equals(""))
            {
                SimpleDateFormat formater = new SimpleDateFormat(pattern);
                dateTime = formater.parse(str);
            }
        }
        catch (Exception ex)
        {
        }
        return dateTime;
    }

    /**
     * 获得指定日期的前一天(含时分秒)
     *
     * @param specifiedDay
     * @return
     * @throws Exception
     */
    public static String getSpecifiedDayBefore(String specifiedDay) {
        Calendar c = Calendar.getInstance();
        Date date = null;
        try {
            date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(specifiedDay);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        c.setTime(date);
        int day = c.get(Calendar.DATE);
        c.set(Calendar.DATE, day - 1);

        String dayBefore = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(c
                .getTime());
        return dayBefore;
    }

    /**
     * 获得指定日期的前一天(不含时分秒)
     *
     * @param specifiedDay
     * @return
     * @throws Exception
     */
    public static String getSpecifiedDayBeforeNoTime(String specifiedDay) {
        Calendar c = Calendar.getInstance();
        Date date = null;
        try {
            date = new SimpleDateFormat("yyyy-MM-dd").parse(specifiedDay);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        c.setTime(date);
        int day = c.get(Calendar.DATE);
        c.set(Calendar.DATE, day - 1);

        String dayBefore = new SimpleDateFormat("yyyy-MM-dd").format(c
                .getTime());
        return dayBefore;
    }

    /**
     * UTC时间转换为本地时间
     *
     * @param utcTime
     * @param utcTimePatten
     * @param localTimePatten
     * @return String
     * @throws Exception
     */
    public static String utc2Local(String utcTime, String utcTimePatten, String localTimePatten) {
        SimpleDateFormat utcFormater = new SimpleDateFormat(utcTimePatten);
        utcFormater.setTimeZone(TimeZone.getTimeZone("UTC"));
        Date gpsUTCDate = null;
        try {
            gpsUTCDate = utcFormater.parse(utcTime);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        SimpleDateFormat localFormater = new SimpleDateFormat(localTimePatten);
        localFormater.setTimeZone(TimeZone.getDefault());
        String localTime = localFormater.format(gpsUTCDate.getTime());
        return localTime;
    }

    public static void main(String[] args)
    {
        System.out.println(DateUtil.getSpecifiedDayBeforeNoTime("2014-05-16 00:57:37"));
    }
}