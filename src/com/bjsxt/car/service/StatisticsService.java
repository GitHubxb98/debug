package com.bjsxt.car.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.bjsxt.car.pojo.CarsRentMonth;
import com.bjsxt.car.pojo.Renttable;

/**
 * creat by gaoyu
 * 2017年11月15日
 */

public interface StatisticsService {
	//获取所有，租车信息
	List<Renttable> getAllStati();
	//查询单个
	Renttable getOneStati(int tableid);
	/**
	 * 查询单个
	 * @param tableid
	 * @return
	 */
	Renttable getOneStati(Long tableid);
	
	//查询按月分布统计车辆租出情况
	List<CarsRentMonth> getMonthAmount();
}
