package edu.ict.ex.mapper;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import edu.ict.ex.vo.BoardVO;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootTest
class BoardMapperTest {

	@Autowired
	private BoardMapper boardMapper;
	
	@Disabled
	@Test
	void testGetList() {
		System.out.println(boardMapper.getList());
		
		for(BoardVO vo : boardMapper.getList()) {
			System.out.println(vo);
		}
	}
	
	@Disabled
	@Test
	void testRead() {
		System.out.println(boardMapper.read(6));
	}
	
	
	@Disabled
	@Test
	void testDelete() {
		
		int count = boardMapper.delete(6);
		
		System.out.println("삭제된 갯수 : "+ count);
		
		if(boardMapper.read(6)==null) {
			System.out.println("제대로 삭제되었음");
		}
		
	}
	
	@Disabled
	@Test
	void testWrite() {
		
		int count = boardMapper.write("테스트","테스트","테스트");
		
		System.out.println("추가된 갯수 : "+ count);
		
//		if(boardMapper.read(16)!=null) {
//			System.out.println("제대로 추가되었음");
//		}
		
	}
	
	@Disabled
	@Test
	void testModify() {
		
		int count = boardMapper.modify("테스트","테스트","테스트",44);
		
		System.out.println("수정된 갯수 : "+ count);
				
	}
	
	@Test
	void testReply() {
		
		int count = boardMapper.reply(44,"test","test" ,"test", 77, 77, 77);
		
		System.out.println("추가된 갯수 : "+ count);
	}

}
