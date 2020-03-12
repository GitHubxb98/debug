package com.bjsxt.car.service.impl;

import java.util.List;
import java.util.zip.Checksum;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bjsxt.car.mapper.CheckTableMapper;
import com.bjsxt.car.pojo.Checktable;
import com.bjsxt.car.service.CheckTableService;
@Service
public class CheckTableServiceImpl implements CheckTableService{
	@Autowired
	private CheckTableMapper checkMapper;
	@Override
	public List<Checktable> findCheckTableByIf(Checktable check) {
		List<Checktable> listCheck = checkMapper.selectCheckByIf(check);
		
		return listCheck;
	}
	@Override
	public Checktable findCheckTableById(Long checkid) {
		Checktable ct =  new Checktable();
		ct.setCheckid(checkid);
		Checktable check = checkMapper.selectCheckByPrimaryKey(ct);
		return check;
	}
	@Override
	public boolean updateCheckTable(Checktable check) {
		int x = checkMapper.updateCheckTable(check);
		if (x>0) {
			return true;
		}
		return false;
	}
	@Override
	public boolean deleteCheckTable(Long checkid) {
		Checktable ct = new Checktable();
		ct.setCheckid(checkid);
		int x = checkMapper.deleteCheckTableById(ct);
		if (x>0) {
			return true;
		}
		return false;
	}
	@Override
	public boolean addCheckTable(Checktable checktable) {
		int x = checkMapper.insertCheckTable(checktable);
		if (x>0) {
			return true;
		}else{
			return false;
		}
	}

}
