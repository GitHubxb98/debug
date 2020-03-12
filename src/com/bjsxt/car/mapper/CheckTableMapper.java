package com.bjsxt.car.mapper;

import java.util.List;

import com.bjsxt.car.pojo.Checktable;

public interface CheckTableMapper {
	/**
	 * 检查单表的多条件查询
	 * @param check
	 * @return
	 */
	List<Checktable> selectCheckByIf(Checktable check);
	/**
	 * 通过主键查询检查单表的信息
	 * @param ct
	 * @return
	 */
	Checktable selectCheckByPrimaryKey(Checktable ct);
	/**
	 * 修改检查单
	 * @param check
	 * @return
	 */
	int updateCheckTable(Checktable check);
	/**
	 * 通过id删除检查单表
	 * @param ct
	 * @return
	 */
	int deleteCheckTableById(Checktable ct);
	/**
	 * 添加检查单表
	 * @param checktable
	 * @return
	 */
	int insertCheckTable(Checktable checktable);

}
