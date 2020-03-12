package com.bjsxt.car.mapper;

import java.util.List;
import java.util.Map;

import com.bjsxt.car.pojo.Users;
/**
 * usermapper
 * @author zql
 *
 */
public interface UserMapper {
	/***
	 * 通过用户名和密码进行查询
	 * @param user
	 * @return
	 */
	Users selectUserByNameAndPwd(Users user);
	/**
	 * 根据用户主键查询他的菜单信息
	 * @param username
	 * @return List<Users>
	 */
	Users selectAllMenus(Users user);
	/**
	 * 查询所有的用户
	 * @return
	 */
	List<Users> selectAllUsers();
	/**
	 * 添加用户
	 * @param user
	 * @return
	 */
	int insertUsers(Users user);
	/**
	 * 查询所有用户信息
	 * @return
	 */
	List<Users> selectAllUser();
	/**
	 * 分页查询
	 * @param map
	 * @return
	 */
	List<Users> selectUserByPage(Map<String, Object> map);
	/**
	 * 多条件查询
	 * @param user
	 * @return
	 */
	List<Users> selectUserByIf(Users user);
	/**
	 * 多条件的分页查询
	 * @param user
	 * @return
	 */
	List<Users> selectUserByIfForPage(Users user);
	/**
	 * 根据主键查询单个信息
	 * @param user
	 * @return
	 */
	Users selectOneUserByUname(Users user);
	/**
	 * 修改用户信息
	 * @param user
	 * @return
	 */
	int updateUsers(Users user);
	/**
	 * 通过主键删除
	 * @param user
	 * @return
	 */
	int deleteUserByUsername(Users user);
	
	
	
	
}
