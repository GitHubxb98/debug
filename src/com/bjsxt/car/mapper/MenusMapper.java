package com.bjsxt.car.mapper;

import java.util.List;

import com.bjsxt.car.pojo.Menus;
import com.bjsxt.car.pojo.Roles;

public interface MenusMapper {
	/**
	 * 通过角色id查询出该角色下的所有菜单
	 * @param roles
	 * @return
	 */
	List<Menus> selectMenusByRoleId(Roles roles);
}
