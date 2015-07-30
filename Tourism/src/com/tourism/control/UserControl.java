package com.tourism.control;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.tourism.entity.User;
import com.tourism.service.UserService;


@Controller
@RequestMapping("/user")
public class UserControl extends BaseControl{

	@Autowired
	private UserService _userService;
	
	//进入用户管理页面
	@RequestMapping("/getAllUser")
	public String getAllUser(ModelMap modelMap, HttpServletRequest request) {
		List userList = _userService.findAllUser();
		modelMap.put("userList", userList);
		HttpSession session = request.getSession();
		session.setAttribute("name", "张三");
//		return "common/index";
		return "index";
	}
	
	//进入添加用户页面
	@RequestMapping("/registerUser")
	public String registerUser(HttpSession session){
		session.setAttribute("name", "李四");
		return "common/register";
	}

	//添加用户
	@RequestMapping("/addUser")
	public String addUser(User user, ModelMap modelMap) {
//		User u = new User();
		user.setId(_userService.getUserId() + 1);
//		u.setAge(Integer.parseInt(request.getParameter("age")));
//		u.setEmail(request.getParameter("email"));
//		u.setSex(Integer.parseInt(request.getParameter("sex")));
//		u.setUsername(request.getParameter("username"));
		
		try {
			User newU = _userService.saveToTable(user);
		} catch (Exception e) {
			e.printStackTrace();
			modelMap.put("result", "FAIL");
			return "addUser";
		}
		return "redirect:/user/getAllUser";
	}
	
	//修改用户
	@RequestMapping("/updateUser")
	public String updateUser(User user, ModelMap modelMap) {
//		User u = _userService.get(Integer.valueOf(id));
//		u.setAge(Integer.parseInt(request.getParameter("age")));
//		u.setEmail(request.getParameter("email"));
//		u.setSex(Integer.parseInt(request.getParameter("sex")));
//		u.setUsername(request.getParameter("username"));
		_userService.update(user);
		modelMap.put("user", user);
		return "redirect:/user/getAllUser";
	}
	
	//查看用户
	@RequestMapping("/showUser")
	public String showUser(@RequestParam("id") String id, HttpServletRequest request, ModelMap modelMap) {
		User u = _userService.get(Integer.valueOf(id));
		modelMap.put("user", u);
		return "common/editUser";
	}
	
	//删除用户
	@RequestMapping("/delUser")
	public void delUser(@RequestParam("id") String id, HttpServletRequest request, HttpServletResponse response) {
		User u = _userService.get(Integer.valueOf(id));
		_userService.delete(u);
		response.setContentType("text;charset=utf-8");
		PrintWriter out = null;
		try {
			out = response.getWriter();
		} catch(IOException e) {
			e.printStackTrace();
		}
		if(_userService.get(Integer.valueOf(id)) == null) {
			out.print("success");
		} else {
			out.print("fail");
		}
	}
	
}
