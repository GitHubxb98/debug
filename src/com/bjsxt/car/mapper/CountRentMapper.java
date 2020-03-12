package com.bjsxt.car.mapper;

import java.util.List;

import com.bjsxt.car.pojo.Renttable;

/**
 * 统计出租单的信息mapper
 * @author zql
 *
 */
public interface CountRentMapper {

	List<Renttable> countAllShouldPayPrice();

	List<Renttable> countRentCarCount();
	
}
