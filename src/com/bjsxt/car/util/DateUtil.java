package com.bjsxt.car.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Map;

/**
 * creat by gaoyu 2017年11月16日
 */
public class DateUtil {
	/**
	 * 某一个月第一天和最后一天
	 * 
	 * @param date
	 * @return
	 */
	public static Map<String, String> getDate(int year, int month) {
		// 格式化工厂
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		// 获取接受的年份
		String dateStr = "" + year + "-" + month + "-" + 1;
		System.out.println("预设时间是" + dateStr);
		Date date = null;
		try {
			date = df.parse(dateStr);
		} catch (ParseException e) {
			System.out.println("时间异常");
			e.printStackTrace();
		}
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.add(Calendar.MONTH, 0);
		Date theDate = calendar.getTime();
		// 本月第一天
		GregorianCalendar gcLast = (GregorianCalendar) Calendar.getInstance();
		gcLast.setTime(theDate);
		gcLast.set(Calendar.DAY_OF_MONTH, 1);
		String day_first = df.format(gcLast.getTime());
		StringBuffer str = new StringBuffer().append(day_first);
		day_first = str.toString();

		// 本月最后一天
		calendar.add(Calendar.MONTH, 1); // 加一个月
		calendar.set(Calendar.DATE, 1); // 设置为该月第一天
		calendar.add(Calendar.DATE, -1); // 再减一天即为上个月最后一天
		String day_last = df.format(calendar.getTime());
		StringBuffer endStr = new StringBuffer().append(day_last);
		day_last = endStr.toString();

		Map<String, String> map = new HashMap<String, String>();
		map.put("first", day_first);
		map.put("last", day_last);
		return map;
	}

}
