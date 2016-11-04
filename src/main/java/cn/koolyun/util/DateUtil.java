package cn.koolyun.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.apache.commons.lang.StringUtils;

/**
 * 日期Util类
 * @author wangwch
 */
public class DateUtil {
	private static String defaultDatePattern = "yyyyMMdd";

	/**
	 * 获得默认的 date pattern
	 */
	private static String getDatePattern() {
		return defaultDatePattern;
	}

	public static Boolean validateDateStr(String str) {
		try {
			SimpleDateFormat f = new SimpleDateFormat("yyyyMMdd");
			Date d = (Date) f.parseObject(str);
			String tmp = f.format(d);
			if (tmp.equals(str)) {
				return true;
			} else {
				return false;
			}
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	
	/**
	 * 返回 当前日期字符串
	 * @return yyyyMMdd 
	 */
	public static String getToday() {
		Date today = new Date();
		return format(today);
	}

	/**
	 * 使用预设Format格式化Date成字符串
	 */
	public static String format(Date date) {
		return date == null ? "" : format(date, getDatePattern());
	}

	/**
	 * 使用参数Format格式化Date成字符串
	 */
	public static String format(Date date, String pattern) {
		return date == null ? "" : new SimpleDateFormat(pattern).format(date);
	}

	/**
	 * 使用预设格式将字符串转为Date
	 */
	public static Date parse(String strDate) throws ParseException {
		return StringUtils.isBlank(strDate) ? null : parse(strDate, getDatePattern());
	}

	/**
	 * 使用参数Format将字符串转为Date
	 */
	public static Date parse(String strDate, String pattern) throws ParseException {
		return StringUtils.isBlank(strDate) ? null : new SimpleDateFormat(pattern).parse(strDate);
	}

	/**
	 * 在日期上增加数个整月
	 */
	public static Date addMonth(Date date, int n) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.add(Calendar.MONTH, n);
		return cal.getTime();
	}

	/**
	 * 获得月末日
	 */
	public static Date getLastDayOfMonth(String year, String month, int flag) {

		Calendar cal = Calendar.getInstance();
		//年
		cal.set(Calendar.YEAR, Integer.parseInt(year));
		//月，因为Calendar里的月是从0开始，所以要-1
		cal.set(Calendar.MONTH, Integer.parseInt(month) - 1);
		//日，设为一号
		cal.set(Calendar.DATE, 1);
		//月份加一，得到下个月的一号
		cal.add(Calendar.MONTH, flag);
		//下一个月减一为本月最后一天
		cal.add(Calendar.DATE, -1);
		return cal.getTime();
	}

	/**
	 * 获得月末日: flag=1:获得上月月末日 flag=0：获得本月月末日
	 */
	public static Date getLastDayOfMonth(Date date, int flag) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		//日，设为一号
		cal.set(Calendar.DATE, 1);
		//月份加一，得到下个月的一号
		cal.add(Calendar.MONTH, flag);
		//下一个月减一为本月最后一天
		cal.add(Calendar.DATE, -1);
		return cal.getTime();
	}

	/**
	 * 获得周末日
	 */
	public static Date getLastDayOfWeek(Date date) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
		cal.add(Calendar.DATE, -1);
		return cal.getTime();
	}

	/**
	 * 在日期上增加数天
	 * @param date
	 * @param n
	 * @return 
	 */
	public static Date addDay(Date date, int n) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.add(Calendar.DAY_OF_MONTH, n);
		return cal.getTime();
	}

	/**
	 * 得到当前时间
	 * @return HHmmss
	 */
	public static String GetCurrentTime() {
		StringBuffer result = new StringBuffer();
		Calendar calendar = Calendar.getInstance();
		int h = calendar.get(Calendar.HOUR_OF_DAY);
		int m = calendar.get(Calendar.MINUTE);
		int s = calendar.get(Calendar.SECOND);
		if (h < 10) {
			result.append("0");
		}
		result.append(h);
		if (m < 10) {
			result.append("0");
		}
		result.append(m);
		if (s < 10) {
			result.append("0");
		}
		result.append(s);
		return result.toString();
	}

	/**
	 * 得到当前日期时间 
	 * @return yyyyMMddHHmmss
	 */
	public static String getCurrDateTime() {
		Date now = new Date();
		SimpleDateFormat outFormat = new SimpleDateFormat("yyyyMMddHHmmss");
		String s = outFormat.format(now);
		return s;
	}

	/**
	 * Formats a Date object to return a date using the global locale.
	 */
	public static String formatDate(Date date) {
		SimpleDateFormat outFormat = new SimpleDateFormat("yyyy-MM-dd");
		return outFormat.format(date);
	}

	/**
	 * Formats a Date object to return a date and time using the global locale.
	 */
	public static String formatDateTime(Date date) {
		SimpleDateFormat outFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		return outFormat.format(date);
	}

	public static String formatDate2(Date myDate) {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy/MM/dd");
		String strDate = formatter.format(myDate);
		return strDate;
	}

	public static String formatDate3(Date myDate) {
		SimpleDateFormat formatter = new SimpleDateFormat("MM-dd HH:mm");
		String strDate = formatter.format(myDate);
		return strDate;
	}

	public static String formatDate4(Date myDate) {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMdd");
		String strDate = formatter.format(myDate);
		return strDate;
	}

	public static String formatDate5(Date myDate) {
		String strDate = getYear(myDate) + "-" + getMonth(myDate) + "-" + getDay(myDate);
		return strDate;
	}

	public static String formatDate6(Date myDate) {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		String strDate = formatter.format(myDate);
		return strDate;
	}
	
	public static String formatDate7(Date myDate) {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String strDate = formatter.format(myDate);
		return strDate;
	}
	
	public static String getCurrentYear(Date myDate) {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy");
		String strDate = formatter.format(myDate);
		return strDate;
	}

	public static long Date2Long(int year, int month, int date) {
		Calendar cld = Calendar.getInstance();
		month = month - 1;
		cld.set(year, month, date);
		return cld.getTime().getTime();
	}

	public static long Time2Long(int year, int month, int date, int hour, int minute, int second) {
		Calendar cld = Calendar.getInstance();
		month = month - 1;
		cld.set(year, month, date, hour, minute, second);
		return cld.getTime().getTime();
	}

	public static int getYear(long t) {
		Calendar cld = Calendar.getInstance();
		if (t > 0) {
			cld.setTime(new java.util.Date(t));
		}
		return cld.get(Calendar.YEAR);
	}

	public static int getMonth(long t) {
		Calendar cld = Calendar.getInstance();
		if (t > 0) {
			cld.setTime(new java.util.Date(t));
		}
		return cld.get(Calendar.MONTH) + 1;
	}

	public static int getDay(long t) {
		Calendar cld = Calendar.getInstance();
		if (t > 0) {
			cld.setTime(new java.util.Date(t));
		}
		return cld.get(Calendar.DAY_OF_MONTH);
	}

	public static int getHour(long t) {
		Calendar cld = Calendar.getInstance();
		if (t > 0) {
			cld.setTime(new java.util.Date(t));
		}
		return cld.get(Calendar.HOUR_OF_DAY);
	}

	public static int getMinute(long t) {
		Calendar cld = Calendar.getInstance();
		if (t > 0) {
			cld.setTime(new java.util.Date(t));
		}
		return cld.get(Calendar.MINUTE);
	}

	public static int getSecond(long t) {
		Calendar cld = Calendar.getInstance();
		if (t > 0) {
			cld.setTime(new java.util.Date(t));
		}
		return cld.get(Calendar.SECOND);
	}

	public static int getYear(Date date) {
		Calendar cld = Calendar.getInstance();
		cld.setTime(date);
		return cld.get(Calendar.YEAR);
	}

	public static int getMonth(Date date) {
		Calendar cld = Calendar.getInstance();
		cld.setTime(date);
		return cld.get(Calendar.MONTH) + 1;
	}

	public static int getDay(Date date) {
		Calendar cld = Calendar.getInstance();
		cld.setTime(date);
		return cld.get(Calendar.DAY_OF_MONTH);
	}

	public static int getHour(Date date) {
		Calendar cld = Calendar.getInstance();
		cld.setTime(date);
		return cld.get(Calendar.HOUR_OF_DAY);
	}

	public static int getMinute(Date date) {
		Calendar cld = Calendar.getInstance();
		cld.setTime(date);
		return cld.get(Calendar.MINUTE);
	}

	public static int getSecond(Date date) {
		Calendar cld = Calendar.getInstance();
		cld.setTime(date);
		return cld.get(Calendar.SECOND);
	}

	public static int getYear() {
		Calendar cld = Calendar.getInstance();
		cld.setTime(new java.util.Date());
		return cld.get(Calendar.YEAR);
	}

	public static int getMonth() {
		Calendar cld = Calendar.getInstance();
		cld.setTime(new java.util.Date());
		return cld.get(Calendar.MONTH) + 1;
	}

	public static int getDay() {
		Calendar cld = Calendar.getInstance();
		cld.setTime(new java.util.Date());
		return cld.get(Calendar.DAY_OF_MONTH);
	}

	/**
	 * 把日期转成2006/12/30格式
	 * @param date
	 * @return
	 */
	public static String formatDate(String date) {
		if (date != null && date.trim().length() >= 8) {
			return date.substring(0, 4) + "-" + date.substring(4, 6) + "-" + date.substring(6, 8);
		}
		return date;
	}

	public static String formatTime(String time) {
		if (time != null && time.trim().length() >= 6) {
			return time.substring(0, 2) + ":" + time.substring(2, 4) + ":" + time.substring(4, 6);
		}
		return time;
	}

	public static String formateTimeOfDay(String time) {
		if (time != null && time.trim().length() >= 12) {
			return time.substring(0, 4) + "-" + time.substring(4, 6) + "-" + time.substring(6, 8) + " "
					+ time.substring(8, 10) + "：" + time.substring(10, 12);
		}
		return time;
	}

	/**
	 * 获得两天之间相差天数 date-date1
	 * @param date    
	 * @param date1
	 * @return
	 */
	public static int getDiffDate(java.util.Date date, java.util.Date date1) {
		return (int) ((date.getTime() - date1.getTime()) / (24 * 3600 * 1000));
	}

	/**
	 * 获取两个时间的秒差  date-date1
	 * @param date
	 * @param date1
	 * @return
	 */
	public static long getDiffTime(java.util.Date date, java.util.Date date1) {
		return (date.getTime() - date1.getTime()) / 1000;
	}

	/**
	 * 从 yyyyMMddHHmmss格式的时间中 获取日期 yyyyMMdd
	 * @param time
	 * @return yyyyMMdd
	 */
	public static String getDateFromyyyyMMddHHmmss(String time) {
		return time.substring(0, 8);
	}

	/**
	 * 从 yyyyMMddHHmmss格式的时间中 获取时间 HHmmss
	 * @param time
	 * @return HHmmss
	 */
	public static String getTimeFromyyyyMMddHHmmss(String time) {
		return time.substring(8, 14);
	}

	public static java.sql.Timestamp getBeginOfDate(String date) throws ParseException {
		return getBeginOfDate(parse(date));
	}

	public static java.sql.Timestamp getBeginOfDate(Date date) {
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		c.set(Calendar.AM_PM, Calendar.AM);
		c.set(Calendar.HOUR, 0);
		c.set(Calendar.MINUTE, 0);
		c.set(Calendar.SECOND, 0);
		java.sql.Timestamp startTimeStamp = new java.sql.Timestamp(c.getTimeInMillis());
		return startTimeStamp;
	}

	public static java.sql.Timestamp getEndOfDate(String date) throws ParseException {
		return getEndOfDate(parse(date));
	}

	public static java.sql.Timestamp getEndOfDate(Date date) {
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		c.set(Calendar.AM_PM, Calendar.PM);
		c.set(Calendar.HOUR, 11);
		c.set(Calendar.MINUTE, 59);
		c.set(Calendar.SECOND, 59);
		java.sql.Timestamp endTimeStamp = new java.sql.Timestamp(c.getTimeInMillis());
		return endTimeStamp;
	}

	public static void main(String args[]) throws ParseException {
		//    	Date date = new Date();
		//    	Date d = getLastDayOfWeek(date);
		//    	System.out.println("d:" + d);
		String fStr = "yyyyMMdd";
		SimpleDateFormat format = new SimpleDateFormat(fStr);
		String d1 = "20050101", d2 = "20050302";
		Date date1 = parse(d1), date2 = parse(d2);
		for (int i = 0; i <= getDiffDate(date2, date1); i++) {
			System.out.println(format.format(addDay(date1, i)));
		}
	}
}