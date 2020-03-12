package com.bjsxt.car.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.bjsxt.car.pojo.Users;
import com.bjsxt.car.service.InterceptorService;
import com.bjsxt.car.service.impl.InterceptorServiceImpl;

/**
 * creat by gaoyu 2017年11月15日
 */
public class LogInterceptor implements HandlerInterceptor {

	@Autowired
	private InterceptorService myInterServiceImpl;

	/*
	 * 在到controller之前执行
	 */
	@Override
	public boolean preHandle(HttpServletRequest req, HttpServletResponse arg1,
			Object arg2) throws Exception {
		return true;
	}

	/*
	 * jsp前
	 */
	@Override
	public void postHandle(HttpServletRequest req, HttpServletResponse resp,
			Object arg2, ModelAndView arg3) throws Exception {
		
		String flagName = "";
		if (arg2 instanceof HandlerMethod) {
			// 获取方法名
			HandlerMethod hd = (HandlerMethod) arg2;
			flagName = hd.getMethod().getName();
			System.out.println("拦截器flag====" + hd.getMethod().getName());
		}
		// 获取用户
		HttpSession session = req.getSession();
		Users user = (Users) session.getAttribute("user");
		if (null == user || "".equals(user)) {
			return;
		}
		String userName = user.getFullname();
		System.out.println("拦截器username====" + user.getFullname());

		// 获取action
		String action = req.getRequestURI().toString();
		//String action = req.getServletPath().toString();
		System.out.println("拦截器action=====" + action);
		
		//获取客户端ip
		String clientIp = req.getRemoteAddr();
		//数据处理
		myInterServiceImpl.saveInter(flagName, userName, action ,clientIp);
	}

	/*
	 * jsp之后
	 */
	@Override
	public void afterCompletion(HttpServletRequest arg0,
			HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {
	}

}
