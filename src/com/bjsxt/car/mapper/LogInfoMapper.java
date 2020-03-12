package com.bjsxt.car.mapper;

import java.util.List;

import com.bjsxt.car.pojo.Logs;

public interface LogInfoMapper {
	/**
	 * 条件查询所有的日志信息
	 * @return
	 */
	List<Logs> selectLogInfoByIf(Logs log);
	/**
	 * 多条件的分页查询
	 * @param log
	 * @return
	 */
	List<Logs> selectLogInfoByPage(Logs log);

}
