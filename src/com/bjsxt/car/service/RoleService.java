package com.bjsxt.car.service;

import java.util.List;
import java.util.Map;

import com.bjsxt.car.pojo.Roles;
import com.bjsxt.car.util.PageBean;

public interface RoleService {
	/**
	 * 将角色和模块关联添加
	 * @param roleName 表示角色的名称
	 * @param idMap 系统管理模块下的子模块的父id和子id
	 * @return boolean
	 */
	boolean addMenusForRole(String roleName,List<Long> idLists);
	/**
	 * 根据角色名的分页查询，查询全部角色
	 * @param page
	 * @return
	 */
	List<Roles> findAllRoles(PageBean<Roles> page, String roleName);
	/**
	 * 使用角色名做条件查询
	 * @param roleName
	 * @return
	 */
	List<Roles> findAllRolesUseName(String roleName);
	/**
	 * 通过角色id进行查询单个角色信息
	 * @param roleid
	 * @return
	 */
	Roles findOneByRoleid(Long roleid);
	/**
	 * 修改该角色的权限
	 * @param roleName
	 * @param idLists
	 * @return
	 */
	boolean updateMenusForRole(String roleName, List<Long> idLists);
	/**
	 * 通过角色的id删除角色的信息
	 * @param roleid
	 * @return
	 */
	boolean deleteRoleById(Long roleid);

}
