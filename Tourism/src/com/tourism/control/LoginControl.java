package com.tourism.control;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

public class LoginControl implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		String name = request.getParameter("name");
		String password = request.getParameter("password");
		if ("savvy".equals(name) && "abc1234".equals(password)) {
			return new ModelAndView("ok");
		}
		return new ModelAndView("login");
	}

}
