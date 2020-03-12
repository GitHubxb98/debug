package com.bjsxt.car.mapper;

import java.util.Date;
import java.util.List;
import java.util.Map;

import com.bjsxt.car.pojo.Renttable;

/**
 * creat by gaoyu
 * 2017年11月15日
 */
public interface StatisticsMapper {
	//获取所有，租车信息
	List<Renttable> getAllStati(String date);
	//查询单个
	//Renttable getOneStati(int tableid);
	/**
	 * 查询单个，参数类型为Long
	 * @param tableid
	 * @return
	 */
	Renttable getOneStati(Long tableid);
	
	//通过汽车id查找
	List<Renttable> getAmountByCarIdMonth(Map<String,String> map);
}
