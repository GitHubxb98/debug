package com.bjsxt.car.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.bjsxt.car.pojo.Menus;
import com.bjsxt.car.pojo.Roles;
import com.bjsxt.car.service.MenusService;
import com.bjsxt.car.service.RoleService;
import com.bjsxt.car.service.UserService;
import com.bjsxt.car.util.PageBean;




@RequestMapping("role")
@Controller
public class RoleController {
	@Autowired
	private MenusService menusService;
	@Autowired
	private RoleService roleService;
	@Autowired
	private UserService userService;

	/**
	 * ��ӽ�ɫ��Ϣ֮ǰ���н�ɫ��Ϣ�Ĳ�ѯ
	 * 
	 * @return
	 */
	@RequestMapping("findRole")
	public String findAllRole(@RequestParam("roleid") Long roleid,
			HttpServletRequest req) {
		Roles role = new Roles();
		role.setRoleid(roleid);
		List<Menus> menus = menusService.findMenusList(role);
		req.setAttribute("menus", menus);
		return "systemManager/addRole";
	}

	/**
	 * ��ӽ�ɫ�Ͷ���ӵĽ�ɫ������ص�ģ���Ȩ��
	 * 
	 * @param roleName
	 * @param req
	 * @return
	 */
	@RequestMapping("addRole")
	public String addRole(@RequestParam("roleName") String roleName,
			HttpServletRequest req) {
		// ��ѯ��ϵͳ����Ա��MenusList
		Roles role = new Roles();
		role.setRoleid(1L);
		List<Menus> menus = menusService.findMenusList(role);
		// ���ڱ���ѡ�е�����ģ��Ӳ˵���id
		List<Long> IdLists = new ArrayList<Long>();
		// �ֶ��������ö���ģ���id
		IdLists.add(1L);
		for (Menus menus2 : menus) {
			String fatherId = "";
			// ��ʾ���Ǵ�����ϵͳ����Ա
			if (menus2.getFatherid() == 1) {
				// ��ȡ��menuid�����Ӳ˵���id
				Long menuid = menus2.getMenuid();
				// ��ȡ��ϵͳ����Ա�µ���ģ���id
				fatherId = req.getParameter("f" + menuid);
				if (!"".equals(fatherId) && null != fatherId) {
					// ��ȡ��ģ���µ��Ӳ˵���id
					String[] sonIds = req.getParameterValues("s" + fatherId);
					// ��ȡ��֮�󣬵ö�string�������ת����ת����ΪLong[]����
					for (String sonId : sonIds) {
						// ���ӴӲ˵�id��ӽ�����
						IdLists.add(Long.parseLong(sonId));
					}
					// ����ģ���id��ӽ�����
					IdLists.add(Long.parseLong(fatherId));
				}
			}
		}
		// ����ҵ��㣬����ɫ��ģ��������,�����ɫ����Ϊ���򲻽������
		if (null != roleName && !"".equals(roleName)) {
			boolean flag = roleService.addMenusForRole(roleName, IdLists);
		}

		return "ok";
	}

	/**
	 * ��ѯ���н�ɫ�ķ�ҳ��ѯ
	 * 
	 * @param roleName
	 * @return
	 */
	@RequestMapping("findAllRole")
	public String findRole(@RequestParam("roleName") String roleName,
			HttpServletRequest req) {
		String pageIndex = req.getParameter("pageIndex");

		PageBean<Roles> page = new PageBean<Roles>();
		if (null != pageIndex && !"".equals(pageIndex)) {
			// ��õ�ǰҳ
			int index = Integer.parseInt(pageIndex);
			page.setIndex(index);
		}
		System.out.println(roleName + "��ǰҳ�룺" + page.getIndex());
		// ��ѯ����¼����
		List<Roles> lists = roleService.findAllRolesUseName(roleName);

		// ���ݽ�ɫ���Ƶķ�ҳģ����ѯ
		List<Roles> roleList = roleService.findAllRoles(page, roleName);
		// page.setTotalCount(roleList.size());
		page.setTotalCount(lists.size());
		req.setAttribute("page", page);
		req.setAttribute("roleList", roleList);
		return "systemManager/viewAllRole";
	}

	/**
	 * ͨ��id��ѯrole��Ϣ
	 * 
	 * @param roleid
	 * @param req
	 * @return
	 */
	@RequestMapping("queryRoleById")
	public String queryRoleById(@RequestParam("roleid") Long roleid,
			HttpServletRequest req) {

		// Ҫ���¡����ȵ��Ȳ�ѯ��Ȼ���ٽ���ѯ���д������б�
		Roles role = roleService.findOneByRoleid(roleid);
		// ��ù���Ա������Ĳ˵�,�����޸��û�Ȩ��
		Roles admin = new Roles();
		admin.setRoleid(1L);
		admin.setRolename("����Ա");
		//��ѯ����Ա���еĲ˵�����
		List<Menus> adminMenus = menusService.findMenusList(admin);
		//��ѯѡ�еĵ�ǰ��ɫ���еĲ˵�����
		List<Menus> roleMenu = menusService.findMenusList(role);
		//ѡ�е�ǰ��ɫӵ�еĲ˵�
		for (Menus menus1 : adminMenus) {
			for (Menus menus2 : roleMenu) {
				if (menus1.getMenuid() == menus2.getMenuid()) {
					menus1.setIsChecked("Checked");
				}
			}
		}
		
		
		req.setAttribute("role", role);
		req.setAttribute("menus", adminMenus);
		return "systemManager/updateRole";
	}

	@RequestMapping("updateRole")
	public String updateRole(@RequestParam("roleName") String roleName,
			HttpServletRequest req) {
		// ��ѯ��ϵͳ����Ա��MenusList,���ڻ�ȡ�ύ��Ȩ��
		Roles role = new Roles();
		role.setRoleid(1L);
		List<Menus> menus = menusService.findMenusList(role);
		// ���ڱ���ѡ�е�����ģ��Ӳ˵���id
		List<Long> IdLists = new ArrayList<Long>();
		// �ֶ��������ö���ģ���id
		IdLists.add(1L);
		for (Menus menus2 : menus) {
			String fatherId = "";
			// ��ʾ���Ǵ�����ϵͳ����Ա
			if (menus2.getFatherid() == 1) {
				// ��ȡ��menuid�����Ӳ˵���id
				Long menuid = menus2.getMenuid();
				// ��ȡ��ϵͳ����Ա�µ���ģ���id
				fatherId = req.getParameter("f" + menuid);
				if (!"".equals(fatherId) && null != fatherId) {
					// ��ȡ��ģ���µ��Ӳ˵���id
					String[] sonIds = req.getParameterValues("s" + fatherId);
					// ��ȡ��֮�󣬵ö�string�������ת����ת����ΪLong[]����
					for (String sonId : sonIds) {
						// ���ӴӲ˵�id��ӽ�����
						IdLists.add(Long.parseLong(sonId));
					}
					// ����ģ���id��ӽ�����
					IdLists.add(Long.parseLong(fatherId));
				}
			}
		}
		boolean flag = false;
		// ����ҵ��㣬����ɫ��ģ��������,�����ɫ����Ϊ���򲻽������
		if (null != roleName && !"".equals(roleName)) {
			flag = roleService.updateMenusForRole(roleName, IdLists);
		}
		//���½���֮��Ӧ�ò�ѯ��ɫ����Ϣ4
		if (flag) {
			return "ok";
		}else{
			return "exception";
		}
	}
	
	@RequestMapping("deleteRoleById")
	public String deleteRoleById(@RequestParam("roleid") Long roleid){
		
		boolean flag = roleService.deleteRoleById(roleid);
		if (flag) {
			return "ok";
		}else{
			return "exception";
		}
	
	}
}
