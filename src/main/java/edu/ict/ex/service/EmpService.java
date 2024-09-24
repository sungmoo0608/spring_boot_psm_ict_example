package edu.ict.ex.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.ict.ex.mapper.EmpMapper;
import edu.ict.ex.page.Criteria;
import edu.ict.ex.vo.EmpVO;
import edu.ict.ex.vo.join.EmpDeptSalgradeVO;
import edu.ict.ex.vo.join.EmpSalgradeVO;

//Command 계층 = 비지니스 로직
@Service
public class EmpService {

	@Autowired
	private EmpMapper empMapper;

	public List<EmpVO> getList(){
		System.out.println("getList() ..");

		return empMapper.getList();
	}

	public int insert(EmpVO empVO){
		System.out.println("insert() ..");

		return empMapper.insert(empVO);
	}
	
	public int getTotal() {            
		return empMapper.getTotalCount();
	}


	public List<EmpVO> getListWithPaging(Criteria cri) {      
		return empMapper.getListWithPaging(cri);
	}

	//조인 처리 - 추천 방법
	public List<EmpSalgradeVO> getEmpSalgrade() {      
		return empMapper.getEmpSalgrade();
	}
	
	//조인 처리 - 추천 방법2
	public List<EmpDeptSalgradeVO> getEmpDeptSalgrade() {      
		return empMapper.getEmpDeptSalgrade();
	}
	
	//삭제 추가
	public int delete(int empno){
		System.out.println("remove() ..");

		return empMapper.delete(empno);
	}
}
