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

import ch.qos.logback.classic.sift.MDCBasedDiscriminator;
import cn.fictio.springboot.common.util.MD5;
import cn.fictio.springboot.pojo.User;
import cn.fictio.springboot.service.UserService;

@Controller
public class UserController {
	
	private static final String key = "user@spring";
	
	private static Logger logger = LoggerFactory.getLogger(UserController.class);

	@Autowired
	private UserService userService;
	
	@RequestMapping("/reg")
	public String reg(Model model){
		model.addAttribute("title", "注册页面");
		model.addAttribute("action", "/regAct");
		return "sign";
	}
	
	@RequestMapping("/regAct")
	public String regAct(HttpServletRequest request,HttpServletResponse response,Model model){
		
		String name = request.getParameter("name");
		String pwd = request.getParameter("pwd");
		String[] check = request.getParameterValues("check");
		if(check != null){
			
		}
		logger.info("name={};pwd = {};",name,pwd);
		
		User u = new User();
		u.setUserName(name);
		u.setPwd(pwd);
		u = userService.reg(u);
		if(u == null){
			model.addAttribute("error", "该用户名已经存在,请重新选择");
			return "false";
		}
		Cookie nameCookie = new Cookie("userName", u.getUserName());
		String token = MD5.getMD5(key+u.getUserName());
		
		Cookie tokenCookie = new Cookie("token",token);
		logger.info("token:{}",token);
		response.addCookie(nameCookie);
		response.addCookie(tokenCookie);
		model.addAttribute("user", u);
		return "ucenter";
	}
	
	@RequestMapping("/login")
	public String login(HttpServletRequest request, HttpServletResponse response,Model model){
		
		Cookie[] cookies = request.getCookies();
		User u = validataUser(cookies);
		if(u != null){
			model.addAttribute("user", u);
			return "ucenter";
		}
		model.addAttribute("title", "登录页面");
		model.addAttribute("action", "/loginAct");
		return "sign";
	}
	
	@RequestMapping("/loginAct")
	public String loginAct(HttpServletRequest request, HttpServletResponse response,Model model){
		
		String name = request.getParameter("name");
		String pwd = request.getParameter("pwd");
		String[] check = request.getParameterValues("check");
		boolean isRemember = false;
		for (String item : check) {
			if(item != null && "rememberMe".equals(item)){
				isRemember = true;
			}
		}
		
		User u = new User();
		u.setUserName(name);
		u.setPwd(pwd);
		u = userService.login(u);
		
		if(u != null){
			Cookie nameCookie = new Cookie("userName", u.getUserName());
			String token = MD5.getMD5(u.getUserName()+key);
			Cookie tokenCookie = new Cookie("token",token);
			logger.info("token为:{}",token);
			response.addCookie(nameCookie);
			response.addCookie(tokenCookie);
			model.addAttribute("user", u);
			return "ucenter";
		}
		return "false";
	}
	
	@RequestMapping("/home")
	public String home(HttpServletRequest request, HttpServletResponse response, Model model){

		Cookie[] cookies = request.getCookies();
		User u = new User();
		String token = "";
		String cookieToken = "1";
		for (Cookie cookie : cookies) {
			logger.info("cookieName:{},cookieValue:{}",cookie.getName(),cookie.getValue());
			if(cookie.getName().equals("userName")){
				u.setUserName(cookie.getValue());
				token = MD5.getMD5(key+u.getUserName());
				logger.info("user={}",u);
			}
			if(cookie.getName().equals("token")){
				logger.info("cookievalue = {}",cookie.getValue());
				cookieToken = cookie.getValue();
			}
		}
		logger.info("token={},cookieToken={}",token,cookieToken);
		if(token.equals(cookieToken)){
			model.addAttribute("user", u);
			return "ucenter";
		}
		return "false";
	}
	
	/**
	 * 验证是否已经登录
	 * 
	 * @param cookies
	 * @return
	 */
	private User validataUser(Cookie[] cookies){
		String token = "";
		String cookieToken = "1";
		User u = new User();
		for (Cookie cookie : cookies) {
			logger.info("cookieName:{},cookieValue:{}",cookie.getName(),cookie.getValue());
			if(cookie.getName().equals("userName")){
				token = MD5.getMD5(key+cookie.getValue());
				u.setUserName(cookie.getValue());
			}
			if(cookie.getName().equals("token")){
				cookieToken = cookie.getValue();
			}
		}
		if(token.equals(cookieToken)){
			return u;
		}
		return null;
	}
	
}
