package com.bjsxt.car.service;

import java.util.List;

import com.bjsxt.car.pojo.Loginlogs;
import com.bjsxt.car.pojo.Logs;
import com.bjsxt.car.util.PageBean;

public interface LogInfoService {
	/**
	 * 条件查询所有的日志信息
	 * @return
	 */
	List<Logs> findLogInfoByIf(Logs log);
	/**
	 * 分页查询
	 * @param page
	 * @param log
	 * @return
	 */
	List<Logs> findLogInfoByPage(PageBean<Logs> page, Logs log);
	/**
	 * 查询登录信息，多条件查询
	 * @param logs
	 * @return
	 */
	List<Loginlogs> findLoginInfoByIf(Loginlogs logs);
	/**
	 * 分页查询登录日志信息
	 * @param page
	 * @param logs
	 * @return
	 */
	List<Loginlogs> findLoginInfoByPage(PageBean<Loginlogs> page, Loginlogs logs);

}
