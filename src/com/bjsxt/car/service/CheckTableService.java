package com.bjsxt.car.service;

import java.util.List;

import com.bjsxt.car.pojo.Checktable;

public interface CheckTableService {
	/**
	 * 检查单表多条件查询
	 * @param check
	 * @return
	 */
	List<Checktable> findCheckTableByIf(Checktable check);
	/**
	 * 通过检查单id查询检查单表的信息
	 * @param checkid
	 * @return
	 */
	Checktable findCheckTableById(Long checkid);
	/**
	 * 修改检查单
	 * @param check
	 * @return
	 */
	boolean updateCheckTable(Checktable check);
	/**
	 * 删除检查单表，通过id
	 * @param checkid
	 * @return
	 */
	boolean deleteCheckTable(Long checkid);
	/**
	 * 添加检查单
	 * @param checktable
	 * @return
	 */
	boolean addCheckTable(Checktable checktable);

}
