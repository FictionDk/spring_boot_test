package cn.fictio.springboot.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.thymeleaf.ThymeleafProperties;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import cn.fictio.springboot.common.ResponseBody;
import cn.fictio.springboot.pojo.Person;
import cn.fictio.springboot.pojo.User;
import cn.fictio.springboot.service.SampleService;
import cn.fictio.springboot.service.UserService;

@Controller
public class SampleController {
	
	private static Logger log = LoggerFactory.getLogger(SampleController.class); 
	
	@RequestMapping("/test")
	public String test(Model model){
		
		model.addAttribute("hello", "From test Controller");
		return "test";
	}
	
}