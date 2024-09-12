package edu.ict.ex.mapper;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import edu.ict.ex.vo.DeptVO;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootTest
class DeptMapperTest {

	
	@Autowired
	private DeptMapper deptMapper;
	
	@Test
	void testGetList() {
		for (DeptVO vo : deptMapper.getList()) {
			System.out.println(vo);
		}
		
	}

}
