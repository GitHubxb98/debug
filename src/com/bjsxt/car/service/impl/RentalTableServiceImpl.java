package com.bjsxt.car.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bjsxt.car.mapper.RentalTableMapper;
import com.bjsxt.car.pojo.Renttable;
import com.bjsxt.car.service.RentalTableService;
@Service
public class RentalTableServiceImpl implements RentalTableService{
	
	@Autowired
	private RentalTableMapper rtMapper;
	@Override
	public List<Renttable> findRentalTableByIf(Renttable renttable) {
		List<Renttable> list = rtMapper.selectRentalTableByIf(renttable);
		System.out.println(list);
		return list;
	}
	@Override
	public Renttable findRentalByRenTableId(String tableid) {
		Renttable renttable = new Renttable();
		if (null != tableid && !"".equals(tableid)) {
			renttable.setTableid(Long.parseLong(tableid));
		}else{
			throw new RuntimeException("接收到的tableid为空，不能转换成Long类型！");
		}
		
		Renttable rt = rtMapper.selectRentaalTableByPrimaryKey(renttable);
		return rt;
	}
	@Override
	public boolean updateRentable(Renttable renttable) {
		
		int x = rtMapper.updateRenttable(renttable);
		if (x>0) {
			return true;
		}
		return false;
	}
	
	@Override
	public boolean addRentTable(Renttable rent) {
		int x = rtMapper.insertRenttable(rent);
		if (x>0) {
			return true;
		}
		return false;
	}
	
	
	
}
