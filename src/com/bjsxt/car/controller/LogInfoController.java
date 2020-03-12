package com.bjsxt.car.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bjsxt.car.pojo.Loginlogs;
import com.bjsxt.car.pojo.Logs;
import com.bjsxt.car.service.LogInfoService;
import com.bjsxt.car.util.PageBean;

@Controller
@RequestMapping("log")
public class LogInfoController {
	@Autowired
	private LogInfoService logInfoService;
	/**
	 * ��ʱ��ת�����������ύ���ڲ����������400����
	 * @param binder
	 */
	@InitBinder    
    public void initBinder(WebDataBinder binder) {    

        binder.registerCustomEditor(Date.class, new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd"), true)); 
    }
	/*=============================================��־����ʼ==================================================================*/
  /**
   * ��ҳ��ѯ������־
   * @param logs
   * @return
   */
	@RequestMapping("findAllLog")
	public String findLog(String action,String username,Date actiontime,HttpServletRequest req){
		PageBean<Logs> page = new PageBean<Logs>();
		Logs log = new Logs();
		log.setAction(action);
		log.setUsername(username);
		log.setActiontime(actiontime);
		//��Ҫ��ǰ̨���ܵķ�ҳ������1����ǰҳ����2��ÿҳ��Ҫ��ʾ����
		String currentPage = req.getParameter("currentPage");
		int index = 1;
		if (null != currentPage && !"".equals(currentPage)) {
			index = Integer.parseInt(currentPage);
		}
		//�ѵ�ǰҳ���ý�ȥ
		page.setIndex(index);
		
		//��ȡÿҳ��Ҫ��ʾ����Ŀ
		String totalCount = req.getParameter("totalCount");
		//Ĭ��5��
		int total = 5;
		if (null != totalCount && !"".equals(totalCount)) {
			total = Integer.parseInt(totalCount);
		}
		//��ÿҳ��Ҫ��ʾ��ҳ�����ý�ȥ
		page.setSize(total);
		
		//1����ѯ�����е���־����
		List<Logs> logList = logInfoService.findLogInfoByIf(log);
		
		//2��ͳ��ҳ��(�����ܼ�¼����������)
		page.setTotalCount(logList.size());
		
		//3����ҳ��ѯ
		List<Logs> pageList = logInfoService.findLogInfoByPage(page,log);
		req.setAttribute("page", page);
		req.setAttribute("pageIndex", index);
		req.setAttribute("pageList", pageList);
		return "systemManager/viewLog";
	}
	/*=============================================��־�������==================================================================*/
	
	/*=============================================��¼��Ϣ����ʼ==================================================================*/
	/**
	 * ʹ����������ѯ��¼��Ϣ���ҷ�ҳ��ʾ
	 * @return
	 */
	@RequestMapping("findLoginInfoByIfByPage")
	public String findLoginInfoByIfByPage(HttpServletRequest req,Date logintime,Loginlogs logs){
		String loginname = req.getParameter("loginname");
		logs.setLoginname(loginname);
		//String logintime = req.getParameter("logintime");
		
		/*
		 * ��ҳ��ѯ�ܽ᣺
		 * 	��ȡ�ķ�ҳ����
		 * 		1����ǰҳ 2��ÿҳ��ʾ���� 3�������ܼ�¼�����������ҳ
		 * 
		 * Ȼ������ҳ��ѯʱ��ֻ��Ҫ�����������������ڷ�ҳ��ѯʱ��ֻ�贫��һ��page���������÷�ҳ�������ɣ�
		 * 		1����ʼ���� 2����������
		 * Ȼ���ٽ���ҳ����Ͳ�ѯ�����Ķ������õ�������ȥ���ɡ�
		 * 
		 * 
		 * */
		//req.getParameter("loginip");
		//req.getParameter("loginname");
		//req.getParameter("");
		//��һ�����Ȳ�ѯ�����е�����
		PageBean<Loginlogs> page = new PageBean<Loginlogs>();
		String currentPage = req.getParameter("currentPage");
		//��������ѯ
		List<Loginlogs> loginLogList = logInfoService.findLoginInfoByIf(logs);
		//�������еļ�¼�������ж���ҳ
		page.setTotalCount(loginLogList.size());
		int index = 1;
		if (null != currentPage && !"".equals(currentPage)) {
			index = Integer.parseInt(currentPage);
		}
		//�ѵ�ǰҳ���ý�ȥ
		page.setIndex(index);
		
		//��ȡÿҳ��Ҫ��ʾ����Ŀ
		String totalCount = req.getParameter("totalCount");
		//Ĭ��5��
		int total = 5;
		if (null != totalCount && !"".equals(totalCount)) {
			total = Integer.parseInt(totalCount);
		}
		//��ÿҳ��Ҫ��ʾ��ҳ�����ý�ȥ
		page.setSize(total);
		
		System.out.println(page.getStartRow()+"---"+page.getEndRow());
		List<Loginlogs> loginListByPage = logInfoService.findLoginInfoByPage(page,logs);
		req.setAttribute("page", page);
		req.setAttribute("pageIndex", index);
		req.setAttribute("loginList", loginListByPage);
		return "systemManager/showLoginLogInfo";
	}
}
