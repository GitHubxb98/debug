package com.bjsxt.car.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.bjsxt.car.pojo.Cars;
import com.bjsxt.car.pojo.Checktable;
import com.bjsxt.car.pojo.Customers;
import com.bjsxt.car.pojo.Renttable;
import com.bjsxt.car.service.CarService;
import com.bjsxt.car.service.CheckTableService;
import com.bjsxt.car.service.CustService;
import com.bjsxt.car.service.RentalTableService;
import com.bjsxt.car.util.MyUtil;


@RequestMapping("main")
@Controller
public class OperatorManagerController {
	@Autowired
	private CustService custService;
	@Autowired
	private CarService carService;
	@Autowired
	private RentalTableService rtService;
	@Autowired
	private CheckTableService ctService;
	
	/**
	 * ��ʱ��ת�����������ύ���ڲ����������400����
	 * @param binder
	 */
  @InitBinder    
    public void initBinder(WebDataBinder binder) {    

        binder.registerCustomEditor(Date.class, new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd"), true)); 
    }
  /***************************************�ͻ��⳵����**********************************************************/
	/**
	 * ��ѯ���ݿ��Ƿ���������֤
	 * @return
	 * @throws IOException 
	 */
	@RequestMapping("findIdentity")
	public void findIdentity(String identity,HttpServletResponse resp,HttpServletRequest req) throws IOException{
		Customers customers = custService.findOne(identity);
		//req.setAttribute("identity", identity);
		PrintWriter out = resp.getWriter();
		if (null != customers && !"".equals(identity)) {
			out.print("true");
		}else{
			out.print("false");
		}
	}
	/**
	 * ��ѯ��������Ϣ
	 * @return
	 */
	@RequestMapping("findCars")
	public String findCars(HttpServletRequest req){
		//��ѯȫ������
		List<Cars> cars = carService.findAllCars();
		req.setAttribute("list", cars);
		String indetity = (String) req.getAttribute("indetity");
		req.setAttribute("indetity", indetity);
		return "operatorManager/showCar";
	}
	/**
	 * Ԥ�⳵�������⳵��
	 * ͨ���⳵����id��ѯ����صĳ���Ϣ
	 * Ȼ�������⳵��
	 * @return
	 */
	@RequestMapping("preRentCar")
	public String preRentCar(HttpServletRequest req){
		//�����û�id���ͻ�id������id��ѯ�����Ϣ��
		String carNumber = req.getParameter("carNumber");
		String identity = req.getParameter("identity");
		//ͨ��carnumber��ѯcar����Ϣ
		Cars car = carService.getOneCar(carNumber);
		Customers customer = custService.findOne(identity);
		//��ѯ���֮�������һ����ǰʱ�������ʱ��
		String date = MyUtil.getCurrentDate();
		//���һ��18λ������������Ϊ���ⵥid
		Long rentId = MyUtil.getRandomId();
		
		//���ݻ����֮������ʾ��ҳ����
		req.setAttribute("car", car);
		req.setAttribute("customer", customer);
		req.setAttribute("date", date);
		req.setAttribute("rentId", rentId);
		
		//֮�󵽴���ⵥ����ҳ��
		return "operatorManager/preCreateRenting";
	}
	/**
	 * ���ͻ����֤Я����������ת��showcar����
	 * @return
	 */
	@RequestMapping("goForShowCar")
	public String goForShowCar(String identity,HttpServletRequest req){
		req.setAttribute("indetity", identity);
		return "forward:/car/main/findCars";
	}
	/**
	 * ��ӳ��ⵥ
	 * @return
	 */
	@RequestMapping("addRentTable")
	public String addRentTable(@RequestParam("rentflag")Long rentflag,Renttable rent){
		boolean flag = rtService.addRentTable(rent);
		if (flag) {
			return "ok";
		}
		return "exception";
	}
	/***************************************�ͻ���������**********************************************************/
	/**
	 * ��ѯ���ⵥ�����Ϣ��Ŀ����Ϊ����Ӧajax����
	 * @return
	 * @throws IOException 
	 */
	@RequestMapping("findRentTableId")
	public void findRentTableId(String tableid,HttpServletResponse resp) throws IOException{
		//��ѯ���ⵥ
		Renttable renttable = rtService.findRentalByRenTableId(tableid);
		PrintWriter writer = resp.getWriter();
		if (null != renttable && !"".equals(renttable)) {
			writer.print("true");
		}else{
			writer.print("false");
		}
		
	}
	/**
	 * ��ѯ��鵥,Ȼ�����ɼ�鵥����Ϣ
	 * ������������Ҫ��̬����
	 * 1����鵥��
	 * 2�����ʱ��
	 * @param tableid
	 * @return
	 */
	@RequestMapping("findCheckTable")
	public String findCheckTable(String tableid,HttpServletRequest req){
		//����һ����鵥��id
		Long checkId = MyUtil.getRandomId();
		//����ϵͳ��ǰʱ��
		String currentDate = MyUtil.getCurrentDate();
		//��ѯ���ⵥ
		Renttable renttable = rtService.findRentalByRenTableId(tableid);
		req.setAttribute("rent", renttable);
		req.setAttribute("checkId", checkId);
		req.setAttribute("checkDate", currentDate);
		return "operatorManager/createCheckTable";
	}
	/**
	 * ���ɼ�鵥������鵥��ӵ����ݿ�
	 * @return
	 */
	@RequestMapping("addCheck")
	public String addCheck(Checktable checktable){
		boolean flag = ctService.addCheckTable(checktable);
		if (flag) {
			return "ok";
		}
		return "exception";
	}
	
}
