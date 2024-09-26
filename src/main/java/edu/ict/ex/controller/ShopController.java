package edu.ict.ex.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import edu.ict.ex.service.EmpService;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/eshopper")

public class ShopController {

	@Autowired
	private EmpService empService;
	
	@GetMapping("/index")
	public String index(Model model) {
		
		log.info("index()..");
		
		model.addAttribute("empList",empService.getEmpDeptSalgrade());
		
		return "eshopper/index";
	}
	
	@GetMapping("/login")
	public String login(Model model) {
		
		log.info("login()..");
		

		
		return "eshopper/login";
	}
}
