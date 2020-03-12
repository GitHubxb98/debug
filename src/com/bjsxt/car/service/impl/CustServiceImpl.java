package com.bjsxt.car.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bjsxt.car.mapper.CustMapper;
import com.bjsxt.car.pojo.Customers;
import com.bjsxt.car.service.CustService;


@Service
public class CustServiceImpl implements CustService {
	
	@Autowired
	private CustMapper custMapper;
	
	
	@Override
	public Customers saveCust(Customers cust) {
		
		int n = custMapper.saveCust(cust);
		
		System.out.println("n="+n+",添加");
		
		return cust;
	}


	@Override
	public List<Customers> getAllCust(Customers cust) {
		
		List<Customers> allCust = custMapper.getAllCust(cust);
		
		return allCust;
	}


	@Override
	public List<Customers> getAllCustByPage(Map<String, Object> map) {
		
		List<Customers> allCustByPage = custMapper.getAllCustByPage(map);
		
		return allCustByPage;
	}


	@Override
	public String deleteCust(String identity) {
		
		int n = custMapper.deleteCust(identity);
		
		System.out.println("n="+n+",删除");
		
		return identity;
	}


	@Override
	public Customers findOne(String identity) {
		
		Customers findOne = custMapper.findOne(identity);
		
		return findOne;
	}


	@Override
	public Customers updateCust(Customers cust) {
		
		int n = custMapper.updateCust(cust);
		
		System.out.println("n="+n+",修改");
		
		return cust;
	}


//	@Override
//	public List<Customers> getCustLike(Customers cust) {
//		
//		List<Customers> custLike = custMapper.getCustLike(cust);
//		return custLike;
//	}
	
	
	
	
	
	@Override
	public List<Customers> findOne1(String identity) {
		
		List<Customers> findOne1 = custMapper.findOne1(identity);
		
		if(findOne1.size()<=1){
			
			return findOne1;
			
		}else{
			
			System.out.println("该id有两个,数据库错误！");
			
		}
		
		return null;
	}


	@Override
	public List<Customers> getAllCustByPage2(Map<String, Object> map) {
		// TODO Auto-generated method stub
		
		List<Customers> allCustByPage2 = custMapper.getAllCustByPage2(map);
		
		return allCustByPage2;
		
	}

}







