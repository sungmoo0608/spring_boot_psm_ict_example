package edu.ict.ex.mapper;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootTest
class TimeMapperTest {
	
	@Autowired
	private TimeMapper timeMapper;

	@Disabled
	@Test
	void testGetTime() {
		log.info("확인"+timeMapper.getTime());
		System.out.println(timeMapper.getTime());
	}
	
	@Test
	void testGetTime2() {
		log.info("확인"+timeMapper.getTime2());
		System.out.println("==============="+timeMapper.getTime2());
	}

}
