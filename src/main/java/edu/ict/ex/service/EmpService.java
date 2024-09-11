package edu.ict.ex.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.ict.ex.repository.EmpDao;
import edu.ict.ex.vo.EmpVO;


//Command 계층 = 비지니스 로직
@Service
public class EmpService {
	
	@Autowired
	private EmpDao dao;
	
	public List<EmpVO> getList(){
		
		System.out.println("getList()..");
		
		return dao.empSelect();
	}

}
