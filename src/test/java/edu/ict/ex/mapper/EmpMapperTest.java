package edu.ict.ex.mapper;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import edu.ict.ex.vo.EmpVO;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootTest
class EmpMapperTest {
	
	@Autowired
	private EmpMapper empMapper;

	@Test
	void testGetList() {
		for (EmpVO vo : empMapper.getList()) {
			System.out.println(vo);
		}
	}

}
