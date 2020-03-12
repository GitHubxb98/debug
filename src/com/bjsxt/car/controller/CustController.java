package com.bjsxt.car.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bjsxt.car.pojo.Customers;
import com.bjsxt.car.service.CustService;
import com.bjsxt.car.util.PageBean;




@Controller
@RequestMapping("/user")
public class CustController {
	
	@Autowired
	private CustService custService;
	
//	/**
//	 * ģ����ѯ
//	 */
//	@RequestMapping("/custLike")
//	public String custLike(Customers cust){
//		
//		System.out.println("cust");
//		
//		Map<String,Object> map = new HashMap<String, Object>();
//		//��ӿͻ�������������
//		map.put("identity", cust.getIdentity());
//		map.put("custname", cust.getCustname());
//		map.put("phone", cust.getPhone());
//		map.put("career", cust.getCareer());
//		map.put("address", cust.getAddress());
//		map.put("sex", cust.getSex());
//		
//		List<Customers> custLike = custService.getAllCustByPage(map);
//		
//		return "redirect:/car/user/allCustByPage";
//	}
	
	
	/**
	 * �޸�1---��ѯһ��
	 */
	@RequestMapping("/findOne")
	public String findOne(String identity,Map<String,Object> map){
		
		Customers cust = custService.findOne(identity);
		
		map.put("cust", cust);
		
		return "forward:/custManager/updateCustomers.jsp";
	}
	/**
	 * �޸�2---update�޸�   
	 */
	@RequestMapping("/updateCust")
	public String updateCust(Customers cust){
		
		System.out.println("666"+cust);
		
		custService.updateCust(cust);
		
		return "redirect:/car/user/allCustByPage";
	}
	/**
	 * �޸�����
	 */
	@RequestMapping("/updateCust1")
	public String updateCust1(Customers cust){
		
		System.out.println("������");
		System.out.println(cust);
		
		custService.updateCust(cust);
		
		return "redirect:/car/user/findOne";
	}
	
	
	/**
	 * ɾ��һ���ͻ�---ͨ�����id
	 */
	@RequestMapping("/deleteCust")
	public String deleteCust(String identity){
		
		System.out.println(identity);
		
		custService.deleteCust(identity);
		
		return "redirect:/car/user/allCustByPage";
	}
	
	
	 
	/**
	 * ��ѯ���еĿͻ�---Ӧ��ʹ�÷�ҳ
	 */
	@RequestMapping("/allCustByPage")
	public String allCustByPage(HttpSession session,Model model,String size,String page,Customers cust){
		
		//System.out.println(cust);
		
		PageBean pb = new PageBean();
		 
		 //  ���ÿһҳ�ĳ��� --select
//		String  size = req.getParameter("size");
		 if(size!=null){    					//ֻ�е���һ�η��ʵ�ʱ�򣬻�Ϊnull��   �����ܳ���      "".equals(size)
			int  size1 = Integer.parseInt(size);
			 pb.setSize(size1);
		 }
		
		// 1    ��ǰ̨��ȡҪ��ѯ��ҳ�� 
//		 String page = req.getParameter("page");
		 int p = 1;
		 if(!"".equals(page)  &&   page!=null){
			  p = Integer.parseInt(page);
		 }
		 pb.setIndex(p);
		  
		// 2    ����βҳ
		 List<Customers> allCust = custService.getAllCust(cust);
		  int count = allCust.size();
		  pb.setTotalCount(count);
		  
		//���÷�ҳ
		int start = pb.getStartRow();
		int end = pb.getEndRow();
		
		Map<String,Object> map = new HashMap<String, Object>();
		//��ӿͻ�������������
		map.put("identity", cust.getIdentity());
		map.put("custname", cust.getCustname());
		map.put("phone", cust.getPhone());
		map.put("career", cust.getCareer());
		map.put("address", cust.getAddress());
		map.put("sex", cust.getSex());
		//��ӷ�ҳ��������
		map.put("end", end);
		map.put("start", start);
		List<Customers> allCustByPage = custService.getAllCustByPage(map);
		
		for (Customers customers : allCustByPage) {
			System.out.println(customers);
		}
		
		model.addAttribute("allCustByPage", allCustByPage);
		model.addAttribute("pb", pb);
		
		//model.addAttribute("cust", cust);
		session.setAttribute("cust", cust);
		
		return "custManager/viewCustomers";
	}
	/**
	 * ��ѯ���еĿͻ�---Ӧ��ʹ�÷�ҳ 22222222
	 */
	@RequestMapping("/allCustByPage2")
	public String allCustByPage2(HttpSession session,Model model,String size,String page){
		
		//��ҳʱģ����ѯ   ����ǰ̨��ȡ  ���Ǵ�session�л�ȡ
		Customers cust = (Customers) session.getAttribute("cust");
		
		System.out.println("��session�л�ȡ��cust"+cust);
		
		PageBean pb = new PageBean();
		 
		 //  ���ÿһҳ�ĳ��� --select
//		String  size = req.getParameter("size");
		 if(size!=null){    					//ֻ�е���һ�η��ʵ�ʱ�򣬻�Ϊnull��   �����ܳ���      "".equals(size)
			int  size1 = Integer.parseInt(size);
			 pb.setSize(size1);
		 }
		
		// 1    ��ǰ̨��ȡҪ��ѯ��ҳ�� 
//		 String page = req.getParameter("page");
		 int p = 1;
		 if(!"".equals(page)  &&   page!=null){
			  p = Integer.parseInt(page);
		 }
		 pb.setIndex(p);
		  
		// 2    ����βҳ
		 List<Customers> allCust = custService.getAllCust(cust);
		  int count = allCust.size();
		  pb.setTotalCount(count);
		  
		//���÷�ҳ
		int start = pb.getStartRow();
		int end = pb.getEndRow();
		
		Map<String,Object> map = new HashMap<String, Object>();
		//��ӿͻ�������������
		map.put("identity", cust.getIdentity());
		map.put("custname", cust.getCustname());
		map.put("phone", cust.getPhone());
		map.put("career", cust.getCareer());
		map.put("address", cust.getAddress());
		map.put("sex", cust.getSex());
		//��ӷ�ҳ��������
		map.put("end", end);
		map.put("start", start);
		List<Customers> allCustByPage = custService.getAllCustByPage(map);
		
		for (Customers customers : allCustByPage) {
			System.out.println(customers);
		}
		
		model.addAttribute("allCustByPage", allCustByPage);
		model.addAttribute("pb", pb);
		//model.addAttribute("cust", cust);
		
//		session.setAttribute("cust", cust);
		
		return "custManager/viewCustomers";
	}
	
//	/**
//	 * ��ѯ���еĿͻ�
//	 */
//	@RequestMapping("/allCust")
//	public String allCust(Model model){
//		
//		List<Customers> allCust = custService.getAllCust();
//		for (Customers customers : allCust) {
//			System.out.println(customers);
//		}
//		
//		model.addAttribute("allCust", allCust);
//		
//		return "custManager/viewCustomers";
//	}
	

	/**
	 * ����һ���ͻ�
	 */
	@RequestMapping("/addCust")
	public String addCust(Customers cust){
		
		Customers saveCust = custService.saveCust(cust);
		
		return "redirect:/car/user/allCustByPage";
	}
}
