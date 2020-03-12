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

import com.bjsxt.car.pojo.Checktable;
import com.bjsxt.car.service.CheckTableService;

@Controller
@RequestMapping("check")
public class CheckTableController {
	@Autowired
	private CheckTableService checkService;
	
	/**
	 * ��ʱ��ת�����������ύ���ڲ����������400����
	 * @param binder
	 */
  @InitBinder    
    public void initBinder(WebDataBinder binder) {    

        binder.registerCustomEditor(Date.class, new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd"), true)); 
    }
  /**
   * ��鵥�Ķ�������ѯ
   * @param tableid
   * @param check
   * @param req
   * @return
   */
	@RequestMapping("findCheckByIf")
	public String findCheckByIf(@RequestParam("tableid")Long tableid,Checktable check,HttpServletRequest req){
		List<Checktable> ck = checkService.findCheckTableByIf(check);
		req.setAttribute("CheckList", ck);
		return "operatorManager/viewCheckTables";
	}
	/**
	 * ͨ��id��ѯ��鵥����Ϣ
	 * @param checkid
	 * @param req
	 * @return
	 */
	@RequestMapping("findByCheckId")
	public String findByCheckId(@RequestParam("checkid")Long checkid,HttpServletRequest req){
		
		Checktable ct = checkService.findCheckTableById(checkid);
		req.setAttribute("check", ct);
		return "operatorManager/updateCheckTable";
	}
	/**
	 * ���¼�鵥
	 * @param checkid
	 * @param check
	 * @return
	 */
	@RequestMapping("updateCheck")
	public String updateCheck(@RequestParam("checkid")Long checkid,Checktable check){
		boolean flag = checkService.updateCheckTable(check);
		if (flag) {
			return "ok";
		}
		return "exception";
	}
	/**
	 * ɾ����鵥��ͨ��id
	 * @param checkid
	 * @return
	 */
	@RequestMapping("deleteByCheckId")
	public String deleteByCheckId(@RequestParam("checkid")Long checkid){
		boolean flag = checkService.deleteCheckTable(checkid);
		if (flag) {
			return "ok";
		}else{
			return "exception";
		}
	}
}
