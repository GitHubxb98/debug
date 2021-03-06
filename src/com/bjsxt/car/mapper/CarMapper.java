package com.bjsxt.car.mapper;

import java.util.List;
import java.util.Map;

import com.bjsxt.car.pojo.Cars;

/**
 * creat by gaoyu 2017年11月13日
 */
public interface CarMapper {
	// 添加车辆
	int addCar(Cars car);

	// 查找全部车辆
	List<Cars> getAllCars(Map<String,Object> map);
	
	//查找单个
	Cars getOneCar(String carNumber);

	//更改
	int updateCar(Cars car);
	
	//删除
	int deleteOne(Cars car);
	
	//分页，模糊查询
	List<Cars> getPageLikeCars(Map<String,Object> map);
	/**
	 * 不通过条件查询全部汽车
	 * @return
	 */
	List<Cars> selectAllCars();
}
