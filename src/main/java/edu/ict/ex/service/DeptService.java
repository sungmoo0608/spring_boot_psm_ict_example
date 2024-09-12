package edu.ict.ex.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.ict.ex.mapper.DeptMapper;
import edu.ict.ex.vo.DeptVO;


//Command 계층 = 비지니스 로직
@Service
public class DeptService {

	@Autowired
	private DeptMapper deptMapper;
	
	public List<DeptVO> getList(){
		return deptMapper.getList();
	}
	
	
//	@Autowired
//	private DeptDao dao;
//	
//	public List<DeptVO> getList(){
//		
//		System.out.println("getList()..");
//		
//		return dao.deptSelect();
//	}

}
