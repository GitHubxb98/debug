package com.bjsxt.car.service;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.web.multipart.MultipartFile;

import com.bjsxt.car.pojo.Cars;
import com.bjsxt.car.util.PageBean;


public interface CarService {
	// ��ӳ���
	int addCar(Cars car);

	// ����ȫ������
	List<Cars> getAllCars(Map<String,Object> map);
	
	//��ҳ��ģ����ѯ
	List<Cars> getPageLikeCars(Map<String,Object> map);

	//���ҵ���
	Cars getOneCar(String carNumber);
	
	//����
	int updateCar(Cars car);
	
	//ɾ��
	int deleteOne(Cars car);
	
	// �ϴ�ͼƬ
	String uploadImg(MultipartFile file, HttpSession session);
	
	//��ҳ
	PageBean getPageCar(String sindex,String sSize,Cars car);
	/**
	 * ��ѯȫ������
	 * @return
	 */
	List<Cars> findAllCars();
}
