package cn.fictio.springboot.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.fictio.springboot.pojo.Good;
import cn.fictio.springboot.service.GoodService;

@Controller
public class SystemController {
	
	@Autowired
	private GoodService goodService;
	
	@RequestMapping("/goodAdd")
	public String addGood(HttpServletRequest request,HttpServletResponse response,Model model){
		
		
		
		Good good = new Good();
		good.setGoodName(request.getParameter("goodName"));
		good.setGoodPrice(Integer.parseInt(request.getParameter("goodPrice")));
		good.setCostPrice(Float.parseFloat(request.getParameter("costPrice")));
		
		
		return "goodList";
	}
	
	@RequestMapping("/goodEdit")
	public String goodEdit(HttpServletRequest request,HttpServletResponse response,Model model){
		
		String strId = request.getParameter("id");
		if(strId != null){
			Good good = goodService.getGoodById(Long.parseLong(strId));
			model.addAttribute("good", good);
		}
		return "system/goodEdit";
	}
	
	@RequestMapping("/goodList")
	public String goodList(HttpServletRequest request,HttpServletResponse response,Model model){
		List<Good> goodList = goodService.getGoodList();
		model.addAttribute("goodList", goodList);
		return "system/goodList";
	}
	
	

}
