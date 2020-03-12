package com.bjsxt.car.mapper;

import java.util.List;

import com.bjsxt.car.pojo.Renttable;

public interface RentalTableMapper {
	/**
	 * 出租单表的多条件查询
	 * @param renttable
	 * @return
	 */
	List<Renttable> selectRentalTableByIf(Renttable renttable);
	/**
	 * 通过主键查询出租单表的信息
	 * @param renttable
	 * @return
	 */
	Renttable selectRentaalTableByPrimaryKey(Renttable renttable);
	/**
	 * 更新出租单表
	 * @param renttable
	 * @return
	 */
	int updateRenttable(Renttable renttable);
	/**
	 * 添加出租单表
	 * @param rent
	 * @return
	 */
	int insertRenttable(Renttable rent);

}
