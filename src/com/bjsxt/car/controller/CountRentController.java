package com.bjsxt.car.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bjsxt.car.pojo.Renttable;
import com.bjsxt.car.service.CountRentService;
import com.bjsxt.car.util.MyUtil;

@Controller
@RequestMapping("countRent")
public class CountRentController {
	@Autowired
	private CountRentService countService;
	/**
	 * ͳ�Ʊ���˾��ÿ���������۶�ͺͱ�����ķ���
	 * ��Ӧjson��ʽ
	 * @return
	 */
	@RequestMapping("countPriceAndNum")
	public String countPriceAndNum(HttpServletRequest req){
		//ͳ��ÿ���������ȥ���ܷ���
		List<Renttable> countAllShouldPayPrice = countService.countAllShouldPayPrice();
		
		//ͳ��ÿ��������Ĵ���
		List<Renttable> list = countService.countRentCarCount();
		for (Renttable r1 : countAllShouldPayPrice) {
			for (Renttable r2 : list) {
				//������ƺ���ͬ
				if (r1.getCars().getCarNumber().equals(r2.getCars().getCarNumber())) {
					//���������ⵥr2��ÿ�����ĳ���״����r1
					r1.setCarrentcount(r2.getCarrentcount());
				}
			}
		}
		String sires = MyUtil.getSires(countAllShouldPayPrice);
		System.out.println(sires);
		req.setAttribute("sires", sires);
		//req.setAttribute("list", countAllShouldPayPrice);
		//req.setAttribute("a", "carNumber");
		return "count/countRent";
	}
	
}
