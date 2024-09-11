package edu.ict.ex.repository;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import edu.ict.ex.vo.DeptVO;


@SpringBootTest
class DeptDaoTest {
	
	@Autowired
	private DeptDao deptDao;
	
	
	@Test
	void testDeptDao() {
		DeptDao dao = new DeptDao();
		
		for(DeptVO vo :dao.deptSelect()) {
			System.out.println(vo);
		}
	}


	@Test
	void testDeptDaoRepository() {
		
		for(DeptVO vo :deptDao.deptSelect()) {
			System.out.println(vo);
		}
	}

}
