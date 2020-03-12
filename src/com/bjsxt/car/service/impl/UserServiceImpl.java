package com.bjsxt.car.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bjsxt.car.mapper.MenusMapper;
import com.bjsxt.car.mapper.RolesMapper;
import com.bjsxt.car.mapper.UserMapper;
import com.bjsxt.car.pojo.Menus;
import com.bjsxt.car.pojo.Roles;
import com.bjsxt.car.pojo.Users;
import com.bjsxt.car.service.UserService;
import com.bjsxt.car.util.PageBean;

@Service
public class UserServiceImpl implements UserService{
	@Autowired
	private UserMapper userMapper;
	@Autowired
	private MenusMapper menusMapper;
	@Autowired
	private RolesMapper rolesMapper;
	@Override
	public Users findUserByUNameAndPwd(Users user) {
		
		return userMapper.selectUserByNameAndPwd(user);
	}
	@Override
	public List<Menus> findAllMenus(Users u) {
		//Users users = userMapper.selectUserByNameAndPwd(u);
		List<Menus> menuses = menusMapper.selectMenusByRoleId(u.getRoles());
		System.out.println("menuses="+menuses);
		Menus root = null;
		for (Menus menus : menuses) {
			if (menus.getMenuid() == 1) {
				root = menus;
			}
			for (Menus menus2 : menuses) {
				//如果menus2是menus的子节点
				if (menus.getMenuid().equals(menus2.getFatherid())) {
					//将menus2装到容器里面
					menus.getMenuList().add(menus2);
				}
			}
		}
		List<Menus> menuslist = new ArrayList<Menus>();
		menuslist.add(root);
		return menuslist;
	}
	@Override
	public List<Roles> findAllRoles() {
		List<Roles> roleList = rolesMapper.selectAllRole();
		
		return roleList;
	}
	@Override
	public boolean addUsers(Users user) {
		int x = userMapper.insertUsers(user);
		if (x>0) {
			return true;
		}else{
			return false;
		}
	}
	@Override
	public List<Users> finAllUser() {
		List<Users> users = userMapper.selectAllUsers();
		return users;
	}
	@Override
	public List<Users> findUserByPage(PageBean<Users> page) {
		
		Map<String, Object> map = new HashMap<String,Object>();
		int start = page.getStartRow();
		int end = page.getEndRow();
		map.put("start", start);
		map.put("end", end);
 		List<Users> userList = userMapper.selectUserByPage(map);
		
		return userList;
	}
	@Override
	public List<Users> findUserByIf(Users user) {
		
		List<Users> userList = userMapper.selectUserByIf(user);
		
		return userList;
	}
	@Override
	public List<Users> findUserByIf(Users user, PageBean<Users> page) {
		user.setStart(page.getStartRow());
		user.setEnd(page.getEndRow());
		List<Users> userList = userMapper.selectUserByIfForPage(user);
		return userList;
	}
	@Override
	public Users findUserInfoByUName(String username) {
		Users users = new Users();
		users.setUsername(username);
		Users user = userMapper.selectOneUserByUname(users);
		return user;
	}
	@Override
	public boolean updateUsers(Users user) {
		int x = userMapper.updateUsers(user);	
		if (x>0) {
			return true;
		}else{
			return false;
		}
	}
	@Override
	public boolean deleteUserByUsername(String username) {
		Users user = new Users();
		user.setUsername(username);
		int x = userMapper.deleteUserByUsername(user);
		
		return x == 1;
	}
	

}
