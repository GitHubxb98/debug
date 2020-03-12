package com.bjsxt.car.service;

import java.util.List;

import com.bjsxt.car.pojo.Menus;
import com.bjsxt.car.pojo.Roles;
import com.bjsxt.car.pojo.Users;
import com.bjsxt.car.util.PageBean;

public interface UserService {
	/**
	 * 根据用户名和密码进行查询
	 * @param user
	 * @return
	 */
	Users findUserByUNameAndPwd(Users user);
	/**
	 * 查询用户名为username下的所有的菜单
	 * @param u
	 * @return
	 */
	List<Menus> findAllMenus(Users u);
	/**
	 * 查询所有角色 
	 * @return
	 */
	List<Roles> findAllRoles();
	/**
	 * 添加用户
	 * @param user
	 * @return
	 */
	boolean addUsers(Users user);
	/**
	 * 查询所有用户信息
	 * @return
	 */
	List<Users> finAllUser();
	/**
	 * 分页查询
	 * @param page
	 * @return
	 */
	List<Users> findUserByPage(PageBean<Users> page);
	/**
	 * 多条件分页查询
	 * @param user
	 * @return
	 */
	List<Users> findUserByIf(Users user, PageBean<Users> page);
	/**
	 * 多条件查询
	 * @param user
	 * @return
	 */
	List<Users> findUserByIf(Users user);
	/**
	 * 根据主键查询用户信息
	 * @param username
	 * @return
	 */
	Users findUserInfoByUName(String username);
	/**
	 * 修改密码
	 * @param user
	 * @return
	 */
	boolean updateUsers(Users user);
	/**
	 * 通过主键删除用户信息
	 * @param username
	 * @return
	 */
	boolean deleteUserByUsername(String username);

}
