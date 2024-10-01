package edu.ict.ex.controller;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import edu.ict.ex.service.TxService;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/tx")
public class TransactionTestController {
	
	@Autowired
	private TxService txService;

	@GetMapping("/{num}")
	public String test(@PathVariable int num) throws SQLException {
		
		System.out.println("테스트 번호 : " + num);

		// http://localhost:8282/tx/1
		if(num==1) {
			txService.txTest1();
		}
		
		if(num==2) {
			txService.txTest2();
		}
		
		if(num==3) {
			txService.txTest3();
		}
		
		if(num==4) {
			txService.txTest4();
		}
		
		return "redirect:/boards/rest";
	}
	
}
