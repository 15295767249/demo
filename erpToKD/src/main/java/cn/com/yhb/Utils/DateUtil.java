package cn.com.yhb.Utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class DateUtil {

    private static final Logger logger = LoggerFactory.getLogger(DateUtil.class);

    private static final SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    private static final SimpleDateFormat simpleDateFormat1 = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");

    private static final DateFormat df = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
    private static final DateFormat df1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    /**
     * java.util.Date日期转化成字符串
     * @param date
     * @return yyyy-MM-dd HH:mm:ss
     */
    public static String utilString(Date date) {
        return  simpleDateFormat.format(date);
    }

    /**
     * 将date类型转换成datetime类型字符串
     * @param date
     * @return
     */
    public static  String dateToDateTimeString(Date date) {
        return df.format(date);
    }

    /**
     * 将datetime类型字符串转换成date类型
     * @param timeString
     * @return
     */
    public static Date StringToDate(String timeString) {
        Date date = null;
        try {
            date = df.parse(timeString);
        } catch (Exception e) {
            logger.error(e.toString());
        }
        return date;
    }

    /**
     * 将datetime类型字符串转换成date类型
     * @param timeString
     * @return
     */
    public static Date StringToDate1(String timeString) {
        Date date = null;
        try {
            if (!StringUtils.isEmpty(timeString)) {
                date = df1.parse(timeString);
            }
        } catch (Exception e) {
            logger.error(e.toString());
        }
        return date;
    }

    /**
     * 判断两个时间间隔小时数
     * @param startTime
     * @param endTime
     * @return
     */
    public static double timeIntervalHour(String startTime, String endTime) {
        double timeInterval = 0.0;
        try {
            Date start = simpleDateFormat.parse(startTime);
            Date end = simpleDateFormat.parse(endTime);
            long cha = end.getTime() - start.getTime();
            if (cha < 0) {
                return 0;
            }
            timeInterval = cha * 1.0 / (1000 * 60 * 60);
        } catch (Exception e) {
            logger.error(e.toString());
        }
        return timeInterval;
    }

    /**
     * 判断两个时间间隔分数
     * @param startTime
     * @param endTime
     * @return
     */
    public static double timeIntervalMinute(String startTime, String endTime) {
        double timeInterval = 0.0;
        try {
            Date start = simpleDateFormat.parse(startTime);
            Date end = simpleDateFormat.parse(endTime);
            long cha = end.getTime() - start.getTime();
            if (cha < 0) {
                return 0;
            }
            timeInterval = cha * 1.0 / (1000 * 60);
        } catch (Exception e) {
            logger.error(e.toString());
        }
        return timeInterval;
    }

    /**
     * 判断两个时间间隔天数
     * @param startTime
     * @param endTime
     * @return
     */
    public static double timeIntervalDay(String startTime, String endTime) {
        double timeInterval = 0.0;
        try {
            Date start = simpleDateFormat.parse(startTime);
            Date end = simpleDateFormat.parse(endTime);
            long cha = end.getTime() - start.getTime();
            if (cha < 0) {
                return 0;
            }
            timeInterval = cha * 1.0 / (1000 * 60 * 60 * 24);
        } catch (Exception e) {
            logger.error(e.toString());
        }
        return timeInterval;
    }

    /**
     * 判断两个时间间隔天数
     * @param start
     * @param end
     * @return
     */
    public static double timeIntervalDay(Date start, Date end) {
        double timeInterval = 0.0;
        try {
            long cha = end.getTime() - start.getTime();
            if (cha < 0) {
                return 0;
            }
            timeInterval = cha * 1.0 / (1000 * 60 * 60 * 24);
        } catch (Exception e) {
            logger.error(e.toString());
        }
        return timeInterval;
    }



    public static Date LongTimeToDate(Date date, int timeInterval, int type) {
        Date result = null;
        try {
            long timeIntervalTime = 0L;
            long time = date.getTime();
            if (type == 0) {
                timeIntervalTime = timeInterval * 60 * 1000L;
            } else if (type == 1) {
                timeIntervalTime = timeInterval * 60 * 60 * 1000L;
            } else {
                timeIntervalTime = timeInterval * 24*60*60*1000L;
            }
            long time1 = time - timeIntervalTime;

            result =  df1.parse(simpleDateFormat.format(time1));
        } catch (Exception e) {
            logger.error(e.toString());
        }
        return result;
    }

    public static String LongTimeToString(Long time) {
        return simpleDateFormat.format(time);
    }

    public static Date getMonthFirstDate(int year, int month) {
        Date date = null;
        try {
            Calendar c = Calendar.getInstance();
            c.set(Calendar.YEAR, year);
            c.set(Calendar.MONTH, month - 1);
            //获取某月第一天
            int firstDay = c.getMinimum(Calendar.DATE);
            c.set(Calendar.DAY_OF_MONTH, firstDay);
            c.set(Calendar.HOUR_OF_DAY, 0);
            c.set(Calendar.MINUTE, 0);
            c.set(Calendar.SECOND, 0);
            date = c.getTime();
        } catch (Exception e) {
            logger.error(e.toString());
        }
        return date;
    }

    public static Date getNowMonthFirstDate() {
        Date date = null;
        try {
            Calendar c = Calendar.getInstance();
            //获取某月第一天
            int firstDay = c.getMinimum(Calendar.DATE);
            c.set(Calendar.DAY_OF_MONTH, firstDay);
            c.set(Calendar.HOUR_OF_DAY, 0);
            c.set(Calendar.MINUTE, 0);
            c.set(Calendar.SECOND, 0);
            date = c.getTime();
        } catch (Exception e) {
            logger.error(e.toString());
        }
        return date;
    }


    public static void main(String[] args) {
        String startTime = "";
        //上周开始时间（上周一）
        Date weekStartTime = DateUtil.lastMonday();
        //获取本月1日时间
        Date nowMonthFirstDay = DateUtil.getNowMonthFirstDate();
        if (StringToDate1("2020-09-28 00:00:00").getTime() < nowMonthFirstDay.getTime()) {
            startTime = DateUtil.utilString(nowMonthFirstDay);
        } else {
            startTime = DateUtil.utilString(weekStartTime);
        }
        System.out.println(startTime);
    }

    public static Date getMonthLastDate(int year, int month) {
        Date date = null;
        try {
            Calendar c = Calendar.getInstance();
            c.set(Calendar.YEAR, year);
            c.set(Calendar.MONTH, month - 1);
            //获取某月最后一天
            int lastDay = c.getActualMaximum(Calendar.DATE);
            c.set(Calendar.DAY_OF_MONTH, lastDay);
            c.set(Calendar.HOUR_OF_DAY, 23);
            c.set(Calendar.MINUTE, 59);
            c.set(Calendar.SECOND, 59);
            date = c.getTime();
        } catch (Exception e) {
            logger.error(e.toString());
        }
        return date;
    }

    public static int getMonthDays(int year, int month) {
        int days = 0;
        try {
            Calendar c = Calendar.getInstance();
            c.set(Calendar.YEAR, year);
            c.set(Calendar.MONTH, month - 1);
            //获取某月最后一天
            days = c.getActualMaximum(Calendar.DATE);
        } catch (Exception e) {
            logger.error(e.toString());
        }
        return days;
    }

    /**
     * 获取上周日时间
     */
    public static Date lastSunday() {

        //作用防止周日得到本周日期
        Calendar calendar = Calendar.getInstance();
        while (calendar.get(Calendar.DAY_OF_WEEK) != Calendar.MONDAY) {
            calendar.add(Calendar.DAY_OF_WEEK, -1);
        }
        int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK) - 1;
        int offset = 7 - dayOfWeek;
        calendar.add(Calendar.DATE, offset - 7);

        return getLastDayOfWeek(calendar.getTime(), 1);//这是从上周日开始数的到本周五为6

    }

    /**
     * 获取上周一时间
     */
    public static Date lastMonday() {
        Calendar calendar = Calendar.getInstance();
        while (calendar.get(Calendar.DAY_OF_WEEK) != Calendar.MONDAY) {
            calendar.add(Calendar.DAY_OF_WEEK, -1);
        }
        int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK) - 1;
        int offset = 1 - dayOfWeek;
        calendar.add(Calendar.DATE, offset - 7);
        return getFirstDayOfWeek(calendar.getTime(), 2);
    }

    /**
     * 获取本周一时间
     */
    public static Date getNowMonday() {
        Calendar calendar = Calendar.getInstance();
        while (calendar.get(Calendar.DAY_OF_WEEK) != Calendar.MONDAY) {
            calendar.add(Calendar.DAY_OF_WEEK, -1);
        }
        int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK) - 1;
        int offset = 1 - dayOfWeek;
        calendar.add(Calendar.DATE, offset - 0);
        return getFirstDayOfWeek(calendar.getTime(), 2);
    }

    /**
     * 得到某一天的该星期的第一日 00:00:00
     *
     * @param date
     * @param firstDayOfWeek
     *            一个星期的第一天为星期几
     *
     * @return
     */
    public static Date getFirstDayOfWeek(Date date, int firstDayOfWeek) {
        Calendar cal = Calendar.getInstance();
        if (date != null)
            cal.setTime(date);
        cal.setFirstDayOfWeek(firstDayOfWeek);//设置一星期的第一天是哪一天
        cal.set(Calendar.DAY_OF_WEEK, firstDayOfWeek);//指示一个星期中的某天
        cal.set(Calendar.HOUR_OF_DAY, 0);//指示一天中的小时。HOUR_OF_DAY 用于 24 小时制时钟。例如，在 10:04:15.250 PM 这一时刻，HOUR_OF_DAY 为 22。
        cal.set(Calendar.MINUTE, 0);//指示一小时中的分钟。例如，在 10:04:15.250 PM 这一时刻，MINUTE 为 4。
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MILLISECOND, 0);
        return cal.getTime();
    }

    /**
     * 得到某一天的该星期的最后一日 23:59:59
     *
     * @param date
     * @param firstDayOfWeek
     *            一个星期的第一天为星期几
     *
     * @return
     */
    public static Date getLastDayOfWeek(Date date, int firstDayOfWeek) {
        Calendar cal = Calendar.getInstance();
        if (date != null)
            cal.setTime(date);
        cal.setFirstDayOfWeek(firstDayOfWeek);//设置一星期的第一天是哪一天
        cal.set(Calendar.DAY_OF_WEEK, firstDayOfWeek);//指示一个星期中的某天
        cal.set(Calendar.HOUR_OF_DAY, 23);//指示一天中的小时。HOUR_OF_DAY 用于 24 小时制时钟。例如，在 10:04:15.250 PM 这一时刻，HOUR_OF_DAY 为 22。
        cal.set(Calendar.MINUTE, 59);//指示一小时中的分钟。例如，在 10:04:15.250 PM 这一时刻，MINUTE 为 4。
        cal.set(Calendar.SECOND, 59);
        cal.set(Calendar.MILLISECOND, 0);
        return cal.getTime();
    }

    /**
     * 获取当月的月份和年份
     * @return
     */
    public static Map<String, Integer> getNowMonthAndYear() {
        Map<String, Integer> result = new HashMap<>();
        //获取上月的月份和年份
        int year = 0;
        int month = 0;
        Calendar now = Calendar.getInstance();
        int nowYear = now.get(Calendar.YEAR);
        int nowMonth = now.get(Calendar.MONTH) + 1;
        if (nowMonth == 1) {
            month = 12;
            year = nowYear - 1;
        } else {
            month = nowMonth;
            year = nowYear;
        }
        result.put("month", month);
        result.put("year", year);
        return result;
    }

    /**
     * 获取当前时间前一个月的月份和年份
     * @return
     */
    public static Map<String, Integer> getLastMonthAndYear() {
        Map<String, Integer> result = new HashMap<>();
        //获取上月的月份和年份
        int year = 0;
        int month = 0;
        Calendar now = Calendar.getInstance();
        int nowYear = now.get(Calendar.YEAR);
        int nowMonth = now.get(Calendar.MONTH) + 1;
        if (nowMonth == 1) {
            month = 12;
            year = nowYear - 1;
        } else {
            month = nowMonth - 1;
            year = nowYear;
        }
        result.put("month", month);
        result.put("year", year);
        return result;
    }

    /**
     * 获取传入的时间的月份和年份
     * @return
     */
    public static Map<String, Integer> getDateMonthAndYear(String date) {
        Map<String, Integer> result = new HashMap<>();
        //获取上月的月份和年份
        int year = 0;
        int month = 0;
        Calendar cal = Calendar.getInstance();
        cal.setTime(StringToDate1(date));
        int nowYear = cal.get(Calendar.YEAR);
        int nowMonth = cal.get(Calendar.MONTH) + 1;
        month = nowMonth;
        year = nowYear;
        result.put("month", month);
        result.put("year", year);
        return result;
    }

    public static String getUpMonthFirstTime() {
        Calendar calendar=Calendar.getInstance();
        calendar.add(Calendar.MONTH, -1);//上个月
        //获取某月第一天
        int firstDay = calendar.getMinimum(Calendar.DATE);
        calendar.set(Calendar.DAY_OF_MONTH, firstDay);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        String first_day = df1.format(calendar.getTime());
        return first_day;
    }



//    public static void main(String[] args) {
//        int year = 2019;
//        int month = 12;
//        System.out.println(dateToDateTimeString(getMonthFirstDate(year, month)));
//        System.out.println(dateToDateTimeString(getMonthLastDate(year, month)));
//    }

//    public static void main(String[] args) {
//        String start = "2020-01-13 00:00:00";
////        String end = "2020-07-19 01:00:00";
////
////        System.out.println(timeIntervalDay(start, end));
////        System.out.println((int)timeIntervalDay(start, end));
//        System.out.println(getDateMonthAndYear(start));
//    }

}
