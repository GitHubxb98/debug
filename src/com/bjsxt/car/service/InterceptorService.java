package com.bjsxt.car.service;

/**
 * creat by gaoyu
 * 2017年11月15日
 */
public interface InterceptorService {
	//添加普通日志信息
	void saveInter(String flagName,String userName,String action,String clientIp);
}
