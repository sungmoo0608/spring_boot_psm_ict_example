package edu.ict.ex.vo;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class EmpVOTest {

	@DisplayName("Emp 테스트")
	@Test
	void testEmpVO() {
		
		EmpVO empVO = new EmpVO();
		
		empVO.setEmpno(10);
		empVO.setEname("홍길동");
		empVO.setJob("MA");
		empVO.setMgr(55);
		empVO.getHiredate();
		empVO.setSal(10);
		empVO.setComm(10);
		empVO.setDeptno(124);
		
		System.out.println(empVO.getEmpno());
		System.out.println(empVO.getEname());
		System.out.println(empVO.getJob());
		System.out.println(empVO.getMgr());
		System.out.println(empVO.getHiredate());
		System.out.println(empVO.getSal());
		System.out.println(empVO.getComm());
		System.out.println(empVO.getDeptno());
		
	}

}
