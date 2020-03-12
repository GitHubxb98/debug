package com.bjsxt.car.service;

import java.util.List;

import com.bjsxt.car.pojo.CountBean;
import com.bjsxt.car.pojo.Renttable;

public interface CountRentService {
	/**
	 * 统计每辆汽车的租赁费用
	 * @return
	 */
	List<Renttable> countAllShouldPayPrice();
	/**
	 * 统计每辆车被出租出去的次数
	 * @return
	 */
	List<Renttable> countRentCarCount();

}
