package edu.ict.ex.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import edu.ict.ex.vo.EmpVO;

@SpringBootTest
class EmpDaoTest {

	@Autowired
	private EmpDao empDao;
	
	@Test
	void testEmpDao() {
		EmpDao dao = new EmpDao();
		
		for(EmpVO vo : dao.empSelect()) {
			System.out.println(vo);
		}
	}
	
	@Test
	void testEmpDaoRepository() {
		
		for(EmpVO vo :empDao.empSelect()) {
			System.out.println(vo);
		}
	}
}
