package edu.ict.ex.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import edu.ict.ex.service.EmpService;

@Controller
@RequestMapping("/emp")

public class EmpController {

	@Autowired
	private EmpService empService;
	
	@GetMapping("/list")
	public String list(Model model) {
		
		System.out.println("list()..");
		
		model.addAttribute("empList",empService.getList());
		
		return "emp/list";
	}
	
}
