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
import org.springframework.web.bind.annotation.RequestParam;

import com.bjsxt.car.pojo.Renttable;
import com.bjsxt.car.service.RentalTableService;



@Controller
@RequestMapping("rentTable")
public class RentalTableController {
		@Autowired
		private RentalTableService rtServcie;
		/**
		 * ��ʱ��ת�����������ύ���ڲ����������400����
		 * @param binder
		 */
	  @InitBinder    
	    public void initBinder(WebDataBinder binder) {    

	        binder.registerCustomEditor(Date.class, new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd"), true)); 
	    }
	/**
	 * ��������ѯ
	 * @param rentflag
	 * @param renttable
	 * @param req
	 * @return
	 */
	@RequestMapping("findRentalTableByIf")
	public String findRentalTableByIf(@RequestParam("rentflag")Long rentflag ,Renttable renttable,HttpServletRequest req){
		List<Renttable> rentList = rtServcie.findRentalTableByIf(renttable);
		req.setAttribute("rentList", rentList);
		System.out.println(renttable);
		return "operatorManager/viewRenttables";
	}
	/**
	 * Ԥ���£�����֮ǰִ�в�ѯ�������������ʾ�����½���
	 * @return
	 */
	@RequestMapping("preUpdate")
	public String preUpdate(@RequestParam("tableid")String tableid,HttpServletRequest req){
		//��ѯ
		Renttable renttable = rtServcie.findRentalByRenTableId(tableid);
		
		req.setAttribute("rent", renttable);
		
		return "operatorManager/updateRenttable";
	}
	/**
	 * ִ�и��²���
	 * @param rentflag
	 * @param renttable
	 * @param req
	 * @return
	 */
	@RequestMapping("updateRentTable")
	public String updateRentTable(@RequestParam("rentflag")Long rentflag ,Renttable renttable,HttpServletRequest req){
		boolean flag = rtServcie.updateRentable(renttable);
		if (flag) {
			return "ok";
		}
		return "exception";
	}
}
