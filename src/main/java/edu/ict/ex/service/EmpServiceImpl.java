package edu.ict.ex.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.ict.ex.mapper.EmpMapper;
import edu.ict.ex.vo.EmpVO;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class EmpServiceImpl implements EmpService {
	
	@Autowired
	private EmpMapper empMapper;

	@Override
	public List<EmpVO> getList() {
		
		log.info("getList()..");

		return empMapper.getList();
	}

	@Override
	public int insert(EmpVO emp) {
		
		log.info("insert()..");
		
		return empMapper.insert(emp);
	}
	
}
