package com.bjsxt.car.util;

import java.util.List;
import java.util.Map;

import com.bjsxt.car.pojo.CarsRentMonth;
import com.bjsxt.car.pojo.Renttable;

/**
 * creat by gaoyu
 * 2017年11月16日
 */
/*
 * 做出这个格式，就成功了
 * 
 * 			[ {
				name : "兰博基尼",
				data : [ 1, 2, 3, 5, 4, 2, 3, 6, 4, 7, 19, 15 ]
			}, {
				name : "玛莎拉蒂",
				data : [ 1, 2, 3, 5, 4, 2, 3, 6, 4, 7, 19, 15 ]
			}, {
				name : "保时捷",
				data : [ 1, 2, 3, 5, 4, 2, 3, 6, 4, 7, 19, 15 ]
			}, {
				name : "宾利",
				data : [ 1, 2, 3, 5, 4, 2, 3, 6, 4, 7, 19, 15 ]
			}, {
				name : "法拉利",
				data : [ 1, 2, 3, 5, 4, 2, 3, 6, 4, 7, 19, 15 ]
			}, {
				name : "林肯",
				data : [ 1, 2, 3, 5, 4, 2, 3, 6, 4, 7, 19, 15 ]
			} ]
 */
public class StringUtil {
	public static String formatString(List<CarsRentMonth> monthAmount){
		StringBuilder sb = new StringBuilder();
		//添加开头
		sb.append("[ ");
		//遍历所有数据
		for(int i= 0 ; i< monthAmount.size() ;i++){
			CarsRentMonth carsRentMonth = monthAmount.get(i);
			System.out.println("车的名字==="+carsRentMonth.getCarName());
			System.out.println("车的月份map==="+carsRentMonth.getMap());
			sb.append("{ name :'"+carsRentMonth.getCarName()+"',");
			sb.append("data : [");
			//遍历map 月份，次数
			for(int j = 1 ; j<= carsRentMonth.getMap().size();j++){
				carsRentMonth.getMap().get(""+j);
				if(j==carsRentMonth.getMap().size()){
					sb.append(carsRentMonth.getMap().get(""+j));
				}else{
					sb.append(carsRentMonth.getMap().get(""+j)+",");
				}
			}
			if(i==(monthAmount.size()-1)){
				sb.append(" ] }");
			}else{
				sb.append(" ] },");
			}
		}
		//添加结尾
		sb.append(" ]");
		return sb.toString();
	}
	
}
