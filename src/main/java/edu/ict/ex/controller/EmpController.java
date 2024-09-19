package edu.ict.ex.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import edu.ict.ex.service.DeptService;
import edu.ict.ex.service.EmpService;
import edu.ict.ex.vo.EmpVO;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/emp")

public class EmpController {

	@Autowired
	private EmpService empService;
	
	@Autowired
	private DeptService deptService;
	
	@GetMapping("/list")
	public String list(Model model) {
		
		log.info("list()..");
		
		model.addAttribute("empList",empService.getList());
		
		return "emp/list";
	}
	
	//http://localhost:8282/emp/insert_view
	@GetMapping("/insert_view")
	public String insert_view(Model model) {
		
		log.info("insert_view()..");
		
		model.addAttribute("empList",empService.getList());
		model.addAttribute("deptList",deptService.getList());
		
		return "emp/insert";

	}
	
	//http://localhost:8282/emp/insert
	@PostMapping("/insert")
	public String insert(EmpVO empVO) {	
		
		System.out.println("insert()..");
		System.out.println(empVO);
		
		empService.insert(empVO);
		
		return "redirect:/emp/list";
	}
	
}
