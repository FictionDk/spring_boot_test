package cn.fictio.springboot.controller;


import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.security.MD5Encoder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.fictio.springboot.pojo.User;
import cn.fictio.springboot.service.UserService;

@Controller
public class UserController {
	
	private static final String key = "user@spring";
	
	private static Logger logger = LoggerFactory.getLogger(UserController.class);

	@Autowired
	private UserService userService;
	
	@RequestMapping("/regAct")
	public String reg(HttpServletRequest request,HttpServletResponse response,Model model){
		
		String name = request.getParameter("name");
		String pwd = request.getParameter("pwd");
		logger.info("name={};pwd = {}",name,pwd);
		
		User u = new User();
		u.setUserName(name);
		u.setPwd(pwd);
		u = userService.reg(u);
		if(u == null){
			model.addAttribute("error", "该用户名已经存在,请重新选择");
			return "false";
		}
		Cookie nameCookie = new Cookie("userName", u.getUserName());
		String token = MD5Encoder.encode((u.getUserName()+key).getBytes());
		Cookie tokenCookie = new Cookie("token",token);
		response.addCookie(nameCookie);
		response.addCookie(tokenCookie);
		model.addAttribute("user", u);
		return "sucess";
	}
	
}
