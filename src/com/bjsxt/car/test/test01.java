package com.bjsxt.car.test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.bjsxt.car.pojo.Customers;
import com.bjsxt.car.service.CustService;

public class test01 {
	
	
	@Test
	public void test01(){
		
		/*ApplicationContext context = new ClassPathXmlApplicationContext("classpath:spring/*.xml");
		
		CustService bean = (CustService) context.getBean("custServiceImpl");
		
		Customers cust = new Customers("124", "123", "123", "123", "123", "123", "123");
		
		
		Customers saveCust = bean.saveCust(cust);
		
		System.out.println(saveCust);*/
		addCar();
		updateCar();
		deleteCar();
	}
	
	/**
	 * 测试添加
	 */
	public void addCar(){
		System.out.println("我是添加的方法");
	}
	
	/**
	 * 测试修改
	 */
	public void updateCar(){
		System.out.println("我是修改的方法");
	}
	
	/**
	 * 测试删除
	 */
	public void deleteCar(){
		System.out.println("我是删除的方法");
	}

}
