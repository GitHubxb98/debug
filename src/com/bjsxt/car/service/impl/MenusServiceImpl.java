package com.bjsxt.car.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bjsxt.car.mapper.MenusMapper;
import com.bjsxt.car.pojo.Menus;
import com.bjsxt.car.pojo.Roles;
import com.bjsxt.car.service.MenusService;
@Service
public class MenusServiceImpl implements MenusService{
	@Autowired
	private MenusMapper mapper;
	
	@Override
	public List<Menus> findMenusList(Roles roleId) {
		List<Menus> menusList = mapper.selectMenusByRoleId(roleId);
		return menusList;
	}
	
	
	
}
