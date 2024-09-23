package edu.ict.ex.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


/* 
 *  상대 경로와 절대 경로
 * 
 * */

@Controller
public class PathController {

	@GetMapping("/path")
	public String index(Model model) {
		
		return "path/path";
	}
	
	@GetMapping("/path/img")
	public String pathImg(Model model) {
		
		return "path/path";
	}
	
}
