package com.bjsxt.car.test;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * creat by gaoyu 2017年11月15日
 */
public class TestLog {
	public static void main(String[] args) {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		Calendar ca = Calendar.getInstance();
		ca.set(Calendar.DAY_OF_MONTH,
				ca.getActualMaximum(Calendar.DAY_OF_MONTH));
		String last = format.format(ca.getTime());
		System.out.println("===============last:" + last);
	}

	/**
	 * 测试添加
	 */
	public static void addCar() {
		System.out.println("我是添加的方法");
	}

	/**
	 * 测试修改
	 */
	public static void updateCar() {
		System.out.println("我是修改的方法");
	}

	/**
	 * 测试删除
	 */
	public static void deleteCar() {
		System.out.println("我是删除的方法");
	}

}
