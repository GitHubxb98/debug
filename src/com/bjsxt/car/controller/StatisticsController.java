package com.bjsxt.car.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bjsxt.car.pojo.CarsRentMonth;
import com.bjsxt.car.pojo.Renttable;
import com.bjsxt.car.service.StatisticsService;
import com.bjsxt.car.util.StringUtil;





@Controller
@RequestMapping("/statistics")
public class StatisticsController {
	@Autowired
	private StatisticsService service;

	@RequestMapping("/getAllStati")
	public String getAllStati(HttpServletRequest req, HttpServletResponse resp) {
		List<Renttable> allStati = service.getAllStati();
		for (Renttable renttable : allStati) {
			System.out.println("�鵽������Ϣ=====" + renttable);
		}
		req.setAttribute("allStati", allStati);
		return "operatorStatistics/viewMonthReturnCarResult";
	}

	@RequestMapping("/getOneStati")
	public String getOneStati(HttpServletRequest req, HttpServletResponse resp) {
		// �����Ӧ�ĳ����id
		Long tableid = 0L;
		String sTableid = req.getParameter("tableid");
		if (sTableid != null && !"".equals(sTableid)) {
			//tableid = Integer.parseInt(sTableid);
			tableid = Long.parseLong(sTableid);
		}
		//���ݿ����
		Renttable oneStati = service.getOneStati(tableid);
		//Renttable oneStati = service.getOneStati(tableid);
		req.setAttribute("rent", oneStati);
		return "operatorStatistics/findMonthReturnCarByInfo";
	}
	/**
	 * ҵ���ѯ�������·ݲ�ѯ��������ͼ
	 * @param req
	 * @param resp
	 * @return
	 */
	@RequestMapping("/getMonthAmount")
	public String getMonthAmount(HttpServletRequest req,
			HttpServletResponse resp) {
		List<CarsRentMonth> monthAmount = service.getMonthAmount();
		System.out.println("================="+monthAmount);
		String str1 = StringUtil.formatString(monthAmount);
		//��ֵ��ǰ̨
		req.setAttribute("strformat", str1);
		return "operatorStatistics/carRentByMonthAmount";
	}
}
