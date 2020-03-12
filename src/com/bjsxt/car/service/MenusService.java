package com.bjsxt.car.service;

import java.util.List;

import com.bjsxt.car.pojo.Menus;
import com.bjsxt.car.pojo.Roles;

public interface MenusService {
	/**
	 * 通过角色id查询出该角色下的所有菜单
	 * @param roleId
	 * @return
	 */
	public List<Menus> findMenusList(Roles roleId);
}
