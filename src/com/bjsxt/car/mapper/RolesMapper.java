package com.bjsxt.car.mapper;

import java.util.List;
import java.util.Map;

import com.bjsxt.car.pojo.Menus;
import com.bjsxt.car.pojo.Roles;

public interface RolesMapper {
	
	/**
	 * 添加角色
	 * @param role
	 * @return int
	 */
	int insertOneRole(Roles role);
	/**
	 * 根据角色名称查询角色id
	 * @param r
	 * @return Roles
	 */
	Roles selectIdByRoleName(Roles r);
	/**
	 * 关联roles和menus
	 * @param map
	 * @return int
	 */
	int insertMenusForRole(Map<String, Long> map);
	/**
	 * 查询全部角色信息，用roleName做条件判读，如果rolename不为空，则根据
	 * rolename查询，否则查询全部角色信息
	 * @return List<Roles>
	 */
	List<Roles> selectAllRoles(Roles role);
	/**
	 * 根据角色名的分页查询
	 * @param map
	 * @return List<Roles>
	 */
	List<Roles> selectRolesByNameByPage(Map<String, Object> map);
	/**
	 * 通过主键查询角色信息
	 * @param roleid
	 * @return
	 */
	Roles selectByPrimaryKey(Long roleid);
	
	/**
	 * 解除角色和模块的关系
	 * @param role
	 * @return
	 */
	int deleteMenusForRole(Roles role);
	/**
	 * 删除角色的信息
	 * @param roleid
	 * @return
	 */
	int deleteRolesById(Roles role);
	/**
	 * 查询所有角色信息
	 * @return
	 */
	List<Roles> selectAllRole();
	
	
}
