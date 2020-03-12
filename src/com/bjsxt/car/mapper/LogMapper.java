package com.bjsxt.car.mapper;

import com.bjsxt.car.pojo.Loginlogs;
import com.bjsxt.car.pojo.Logs;

/**
 * creat by gaoyu 2017年11月15日
 */
public interface LogMapper {
	// 添加普通日志信息
	void saveInter(Logs log);
	// 添加登录日志
	void saveLoginInter(Loginlogs log);
}
