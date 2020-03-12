package com.bjsxt.car.service.impl;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import com.bjsxt.car.mapper.CarMapper;
import com.bjsxt.car.pojo.Cars;
import com.bjsxt.car.service.CarService;
import com.bjsxt.car.util.PageBean;

/**
 * creat by gaoyu 2017年11月13日
 */
@Service
public class CarServiceImpl implements CarService {
	// 自动装箱
	@Autowired
	private CarMapper mapper;

	/*
	 * 添加车辆
	 */
	@Override
	public int addCar(Cars car) {
		return mapper.addCar(car);
	}

	/*
	 * 查找全部车辆
	 */
	@Override
	public List<Cars> getAllCars(Map<String, Object> map) {
		return mapper.getAllCars(map);
	}

	/*
	 * 模糊，分页查询
	 */
	@Override
	public List<Cars> getPageLikeCars(Map<String, Object> map) {
		return mapper.getPageLikeCars(map);
	}

	/*
	 * 更改
	 */
	@Override
	public int updateCar(Cars car) {
		return mapper.updateCar(car);
	}

	/*
	 * 查询单个
	 */
	@Override
	public Cars getOneCar(String carNumber) {
		return mapper.getOneCar(carNumber);
	}

	/*
	 * 删除单个
	 */
	@Override
	public int deleteOne(Cars car) {
		return mapper.deleteOne(car);
	}

	/**
	 * 图片上传逻辑处理
	 */
	public String uploadImg(MultipartFile file, HttpSession session) {
		// 检查服务器下是否有上传文件夹
		String path = session.getServletContext().getRealPath("/upload");
		// 判断
		File fi = new File(path);
		if (!fi.exists()) {
			// 创建新文件夹
			fi.mkdirs();
		}
		// 获取唯一文件名
		String name = file.getOriginalFilename();
		String type = name.substring(name.lastIndexOf("."));
		String uuid = UUID.randomUUID().toString();
		uuid = uuid.replace("-", "");
		String newName = uuid + type;
		// 指定文件上传目录，文件名
		try {
			file.transferTo(new File(fi, newName));
		} catch (IllegalStateException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return newName;
	}

	/*
	 * 分页
	 */
	@Override
	public PageBean getPageCar(String sindex, String sSize,Cars car) {
		PageBean pageBean = new PageBean();
		// 赋值分页信息
		if (sindex != null && !"".equals(sindex)) {
			int index = Integer.parseInt(sindex);
			// 为bean赋值页号
			pageBean.setIndex(index);
		}
		if (sSize != null && !"".equals(sSize)) {
			int size = Integer.parseInt(sSize);
			// 设置显示条数
			pageBean.setSize(size);
		}
		// bean设置总数据
		Map<String, Object> map1 = new HashMap<String, Object>();
		map1.put("cars", car);
		int sizeCount = getAllCars(map1).size(); // 查询共有几条
		System.out.println("一共有" + sizeCount);
		pageBean.setTotalCount(sizeCount);

		// 计算开始条数，和结尾条数
		int start = pageBean.getStartRow();
		int end = pageBean.getEndRow();
		System.out.println(start + ",,,," + end + "总条数" + sizeCount);
		// 查询分页结果信息
		// 创建Map参数集合
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("cars", car);
		map.put("start", start);
		map.put("end", end);
		List<Cars> carList = getPageLikeCars(map);
		// 将要显示的数据设置到bean中
		pageBean.setList(carList);
		return pageBean;
	}
	/**
	 * 新添加的方法--->不通过条件查询全部汽车
	 */
	@Override
	public List<Cars> findAllCars() {
		List<Cars> carList = mapper.selectAllCars();
		return carList;
	}

}
