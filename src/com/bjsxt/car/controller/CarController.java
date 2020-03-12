package com.bjsxt.car.controller;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import com.bjsxt.car.pojo.Cars;
import com.bjsxt.car.service.CarService;
import com.bjsxt.car.util.PageBean;

@Controller
@RequestMapping("/car")
public class CarController {

	// serrviceʵ�ֲ���
	@Autowired
	private CarService service;

	/**
	 * ��ӳ���
	 * 
	 * @param car
	 * @param file
	 * @param session
	 * @return
	 */
	@RequestMapping("/addCar")
	public String addCar(Cars car, MultipartFile file, HttpSession session) {
		// ����ͼƬ�ϴ�ҵ���߼������ȫ·��
		String uploadImg = service.uploadImg(file, session);
		// ��·�����õ�car�����У��浽���ݿ�
		car.setCarImg(uploadImg);
		// �洢
		service.addCar(car);
		return "redirect:getPageCars";
	}

	/**
	 * ��ҳ��ģ��
	 * 
	 * @param car
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping("/getPageCars")
	public String getPageCars(Cars car, HttpServletRequest request,
			HttpServletResponse response) {
		// ���ܵ�ǰҳ����һҳ��Ŀ
		String sindex = request.getParameter("page");
		String sSize = request.getParameter("size");
		PageBean pageBean = service.getPageCar(sindex, sSize, car);
		// ��bean ����ǰ̨
		request.setAttribute("pageBean", pageBean);
		// ��סģ����ѯ��ֵ
		request.setAttribute("oldCar", car);
		return "carManager/viewCars";
	}

	/**
	 * ��ѯ����
	 * 
	 * @param car
	 * @param req
	 * @param resp
	 * @return
	 */
	@RequestMapping("/getOneCar")
	public String getOneCar(Cars car, HttpServletRequest req,
			HttpServletResponse resp) {
		Cars oneCar = service.getOneCar(car.getCarNumber());
		req.setAttribute("oneCar", oneCar);
		return "carManager/updateCar";
	}

	/**
	 * ����
	 * 
	 * @param car
	 * @param file
	 * @param session
	 * @return
	 */
	@RequestMapping("/updateCar")
	public String updateCar(Cars car, MultipartFile file, HttpSession session) {
		// ����ͼƬ�ϴ�ҵ���߼������ȫ·��
		String uploadImg = null;
		if (file.getOriginalFilename() != null
				&& !"".equals(file.getOriginalFilename())) {
			uploadImg = service.uploadImg(file, session);
		}else{
			// ͼƬ����
			Cars oneCar = service.getOneCar(car.getCarNumber());
			uploadImg = oneCar.getCarImg();
		}
		// ��·�����õ�car�����У��浽���ݿ�
		car.setCarImg(uploadImg);
		// ����
		System.out.println("�޸ĺ��Ӧ����" + car);
		service.updateCar(car);
		return "redirect:getPageCars";
	}

	/**
	 * ɾ��
	 * 
	 * @param car
	 * @return
	 */
	@RequestMapping("/deleteOne")
	public String deleteOne(Cars car) {
		System.out.println("ɾ��" + car.getCarNumber());
		service.deleteOne(car);
		return "redirect:getPageCars";
	}

	/**
	 * ������ת
	 */
	@RequestMapping("/test")
	public String Test() {
		System.out.println("����");
		return "redirect:getAllCars";
	}
}
