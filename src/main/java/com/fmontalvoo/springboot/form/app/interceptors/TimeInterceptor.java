package com.fmontalvoo.springboot.form.app.interceptors;

import java.util.Random;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

@Component("timeInterceptor")
public class TimeInterceptor implements HandlerInterceptor {

	private static final Logger logger = LoggerFactory.getLogger(TimeInterceptor.class);

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {

		logger.info("METHOD: " + request.getMethod());

		if (request.getMethod().equalsIgnoreCase("post"))
			return true;

		if (handler instanceof HandlerMethod) {
			HandlerMethod method = (HandlerMethod) handler;
			logger.info("Metodo del controlador: " + method.getMethod().getName());
		}

		logger.info("TimeInterceptor: preHandle");
		long start = System.currentTimeMillis();
		request.setAttribute("start", start);

		Random r = new Random();
		Integer duration = r.nextInt(100);
		Thread.sleep(duration);
		return true;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {

		if (request.getMethod().equalsIgnoreCase("post"))
			return;

		long start = (Long) request.getAttribute("start");
		long end = System.currentTimeMillis();
		long duration = end - start;
		logger.info("TimeInterceptor: postHandle");
		logger.info("Duration: " + duration);
		if (handler instanceof HandlerMethod && modelAndView != null) {
			modelAndView.addObject("duration", duration);
		}
	}

}
