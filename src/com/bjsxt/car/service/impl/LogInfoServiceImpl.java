package com.bjsxt.car.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bjsxt.car.mapper.LogInfoMapper;
import com.bjsxt.car.mapper.LoginLogMapper;
import com.bjsxt.car.pojo.Loginlogs;
import com.bjsxt.car.pojo.Logs;
import com.bjsxt.car.service.LogInfoService;
import com.bjsxt.car.util.PageBean;
@Service
public class LogInfoServiceImpl implements LogInfoService{
	@Autowired
	private LogInfoMapper logInfoMapper;
	@Autowired
	private LoginLogMapper loginLogMapper;
	@Override
	public List<Logs> findLogInfoByIf(Logs log) {
		List<Logs> logList = logInfoMapper.selectLogInfoByIf(log);
		return logList;
	}
	public List<Logs> findLogInfoByPage(PageBean<Logs> page, Logs log) {
		log.setStart(page.getStartRow());
		log.setEnd(page.getEndRow());
		List<Logs> logList = logInfoMapper.selectLogInfoByPage(log);
		
		return logList;
	}
	@Override
	public List<Loginlogs> findLoginInfoByIf(Loginlogs logs) {
		List<Loginlogs> loginList = loginLogMapper.findAllLoginInfoByIf(logs);
		return loginList;
	}
	@Override
	public List<Loginlogs> findLoginInfoByPage(PageBean<Loginlogs> page,
			Loginlogs logs) {
		logs.setStart(page.getStartRow());
		logs.setEnd(page.getEndRow());
		List<Loginlogs> loginList = loginLogMapper.selectAllLoginInfoByPage(logs);
		
		
		return loginList;
	}
	

}
