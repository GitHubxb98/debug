package com.bjsxt.car.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bjsxt.car.mapper.CountRentMapper;
import com.bjsxt.car.pojo.CountBean;
import com.bjsxt.car.pojo.Renttable;
import com.bjsxt.car.service.CountRentService;

/**
 * 统计汽车的业务情况
 * @author zql
 *
 */
@Service
public class CountRentServiceImpl implements CountRentService{
	@Autowired
	private CountRentMapper countRentMapper;
	@Override
	public List<Renttable> countAllShouldPayPrice() {
		List<Renttable> countAllShouldPayPrice = countRentMapper.countAllShouldPayPrice();
		return countAllShouldPayPrice;
	}
	@Override
	public List<Renttable> countRentCarCount() {
		List<Renttable> list = countRentMapper.countRentCarCount();
		
		return list;
	}
	
}
