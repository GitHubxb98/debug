package com.bjsxt.car.mapper;

import java.util.List;

import com.bjsxt.car.pojo.Loginlogs;

public interface LoginLogMapper {
	/**
	 * 多条件查询用户登录信息
	 * @param logs
	 * @return
	 */
	List<Loginlogs> findAllLoginInfoByIf(Loginlogs logs);
	/**
	 * 分页查询登录日志信息
	 * @return
	 */
	List<Loginlogs> selectAllLoginInfoByPage(Loginlogs logs);
		
}
