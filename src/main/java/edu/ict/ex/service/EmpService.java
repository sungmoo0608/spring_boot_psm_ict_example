package edu.ict.ex.service;

import java.util.List;

import edu.ict.ex.vo.EmpVO;

public interface EmpService {
	List<EmpVO> getList();

	int insert(EmpVO emp);

}
