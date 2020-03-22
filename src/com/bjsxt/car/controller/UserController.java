package com.bjsxt.car.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bjsxt.car.pojo.Menus;
import com.bjsxt.car.pojo.Roles;
import com.bjsxt.car.pojo.Users;
import com.bjsxt.car.service.UserService;
import com.bjsxt.car.util.PageBean;

@Controller
@RequestMapping("user")
public class UserController{
	@Autowired
	UserService userService;
	@RequestMapping(value="login")
	public String login(HttpServletRequest request ){
		
		try {
			String code = request.getParameter("code");
			String value = (String) request.getSession().getValue("key");
			if(!code.equals(value)) {
				request.setAttribute("errors", "验证码错误！");
				return "login";
			}
			String username =  request.getParameter("username");
			String userPwd =  request.getParameter("userPwd");
			Users user = new Users();
			user.setUsername(username);
			user.setUserpwd(userPwd);
			if(username==null & userPwd ==null ) {
				return "login";
			}
			Users user1 = userService.findUserByUNameAndPwd(user);
			if (null == user1) {
				request.setAttribute("errors", "用户名或密码不对！");
				return "login";
			}
			
			List<Menus> menu = userService.findAllMenus(user1);
			System.out.println(menu);
			request.getSession().setAttribute("menus", menu);
			request.getSession().setAttribute("user", user1);
			
			return "index";
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		//��������쳣����ת������ҳ��
		return "error";
	}
	/**
	 * �û��˳�ϵͳ��ע��session�����ص�¼����
	 * 
	 * */
	@RequestMapping("logout")
	public String logout(HttpServletRequest req){
		//ע��session
		req.getSession().invalidate();
		return "login";
	}
	/**
	 * ��ѯ���н�ɫ��Ϣ��Ϊ��ѯ�û���Ϣ��׼��
	 * @param req
	 * @return
	 */
	@RequestMapping("findAllUsers")
	public String findAllRoles(HttpServletRequest req){
		List<Roles> roles = userService.findAllRoles();
		req.setAttribute("roles", roles);
		return "userManager/addUser";
	}
	
	@RequestMapping("addUsers")
	public String addUsers(Users user,HttpServletRequest req){
		boolean flag = userService.addUsers(user);
		if (flag) {
			return "forward:/car/user/findUserByPage";
		}
		return "exception";
	}
	/**
	 * ��ҳ��ѯ
	 * @return
	 */
	@RequestMapping("findUserByPage")
	public String findUserByPage(HttpServletRequest req){
		//��õ�ǰҳ�� 
		String index = req.getParameter("currentPage");
		
		PageBean<Users> page = new PageBean<Users>();
		//��ѯ�����û�������ܼ�¼����
		List<Users> list = userService.finAllUser();
		page.setTotalCount(list.size());
		int currentIndex=1;
		if (null != index && !"".equals(index) ) {
			currentIndex = Integer.parseInt(index);
		}
		//���õ�ǰҳ
		System.out.println("��ǰҳ��"+currentIndex);
		page.setIndex(currentIndex);
		List<Users> userList = userService.findUserByPage(page);
		req.setAttribute("pageIndex", currentIndex);
		req.setAttribute("page", page);
		req.setAttribute("userList", userList);
		return "userManager/viewUser";
	}
	
	/**
	 * ��ѯ���н�ɫ��Ϣ��Ϊ������ѯ�û���Ϣ��׼��
	 * @param req
	 * @return
	 */
	@RequestMapping("findAllRoles")
	public String findAllRoles1(HttpServletRequest req){
		List<Roles> roles = userService.findAllRoles();
		req.setAttribute("roles", roles);
		return "userManager/findUser";
	}
	/**
	 * ��������ҳ��ѯ�û���Ϣ
	 * @param user
	 * @param req
	 * @return
	 */
	@RequestMapping("findUserByIf")
	public String findUserByIf(Users user,HttpServletRequest req){
		//��õ�ǰҳ�� 
		String index = req.getParameter("currentPage");
		PageBean<Users> page = new PageBean<Users>();
		//��������ѯ�����н��
		List<Users> byIfList = userService.findUserByIf(user);
		page.setSize(byIfList.size());
		int currentIndex = 1;
		
		if (null != index && !"".equals(index) ) {
			currentIndex = Integer.parseInt(index);
		}
		//���õ�ǰҳ
		System.out.println("��ǰҳ��"+currentIndex);
		page.setIndex(currentIndex);
		//�������ķ�ҳ��ѯ
		List<Users> list = userService.findUserByIf(user, page);
		//System.out.println(list.get(1).getRoles().getRolename());
		req.setAttribute("pageIndex", currentIndex);
		req.setAttribute("page", page);
		//req.setAttribute("userList", list);
		req.setAttribute("userList", list);
		return "userManager/viewUserByPage";
	}
	/**
	 * �����û���Ϣ֮ǰ��Ҫͨ���û�������ѯ��Ϣ������Ϣ��ʾ�ڸ��½���
	 * @param username
	 * @param req
	 * @return
	 */
	@RequestMapping("preUpdate")
	public String preUpdate(String username,HttpServletRequest req){
		//����֮ǰҲ���������£����Ȳ�ѯrole����û���
		//��Ҫ�����ɫ�ļ���
		List<Roles> roles = userService.findAllRoles();
		Users user = userService.findUserInfoByUName(username);
		req.setAttribute("roles", roles);
		req.setAttribute("obj", user);
		return "userManager/updateUser";
	}
	/**
	 * �����û���Ϣ
	 * @param user
	 * @return
	 */
	@RequestMapping("updateUser")
	public String updateUser(Users user){
		boolean flag = userService.updateUsers(user);
		if (flag) {
			//�޸ĳɹ�
			return "forward:/car/user/findUserByPage";
		}
		return "exception";
	}
	/**
	 * ɾ���û���Ϣ
	 * @param username
	 * @return
	 */
	@RequestMapping("deleteUser")
	public String deleteMapper(String username){
		boolean flag = userService.deleteUserByUsername(username);
		if (flag) {
			//ɾ���ɹ�
			return "forward:/car/user/findUserByPage";
		}
		return "exception";
	}
	/**
	 * ��������֮ǰ�Ȳ�ѯ����
	 * @param username
	 * @param req
	 * @return
	 */
	@RequestMapping("preUpdatePwd")
	public String preUpdatePwd(String username,HttpServletRequest req){
		//����֮ǰ�Ȳ�ѯ���ݣ�Ȼ�󣬽�������ʾ������
		Users user = userService.findUserInfoByUName(username);
		req.setAttribute("user", user);
		return "userManager/changeUserPwd";
	}
	/**
	 * ��������
	 * @param okNewPwd
	 * @param userName
	 * @return
	 */
	@RequestMapping("updatePwd")
	public String updatePwd(String okNewPwd,String userName){
		Users user = new Users();
		user.setUsername(userName);
		user.setUserpwd(okNewPwd);
		boolean flag = userService.updateUsers(user);
		if (flag) {
			//�޸ĳɹ�
			return "forward:/car/user/findUserByPage";
		}
		return "exception";
	}
	
}