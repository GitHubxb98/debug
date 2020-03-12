package com.bjsxt.car.service;

import java.util.List;

import com.bjsxt.car.pojo.Renttable;

public interface RentalTableService {
	/**
	 * 出租单的多条件查询
	 * @param renttable
	 * @return
	 */
	List<Renttable> findRentalTableByIf(Renttable renttable);
	/**
	 * 通过出租单表的主键id去查询出租但表的信息
	 * @param tableid
	 * @return
	 */
	Renttable findRentalByRenTableId(String tableid);
	/**
	 * 更新出租单表
	 * @param renttable
	 * @return boolean
	 */
	boolean updateRentable(Renttable renttable);
	/**
	 * 添加出租单表
	 * @param rent
	 * @return
	 */
	boolean addRentTable(Renttable rent);

}
