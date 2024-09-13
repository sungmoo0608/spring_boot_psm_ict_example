package edu.ict.ex.mapper;

import java.util.List;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import edu.ict.ex.page.Criteria;
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
	void testUpdate() {
		
		BoardVO board = new BoardVO();
		board.setBid(55);
		board.setBname("모닝모닝");
		board.setBtitle("모닝모닝");
		board.setBcontent("모닝모닝");
		
		int count = boardMapper.updateBoard(board);
		
		System.out.println("업데이트 갯수 : "+ count);
		
		System.out.println(boardMapper.read(55));
		
	}
	
	
	@Test
	void testGetListWithPaging() {
		
		Criteria criteria = new Criteria();
		
		criteria.setAmount(10);
		criteria.setPageNum(3);
		
		List<BoardVO> list = boardMapper.getListWithPaging(criteria);
		System.out.println(list);

	}
	
	
//	@Disabled
//	@Test
//	void testWrite() {
//		
//		int count = boardMapper.write("테스트","테스트","테스트");
//		
//		System.out.println("추가된 갯수 : "+ count);
//		
//	}
//	
//	@Disabled
//	@Test
//	void testModify() {
//		
//		int count = boardMapper.modify("테스트","테스트","테스트",44);
//		
//		System.out.println("수정된 갯수 : "+ count);
//				
//	}
//	
//	@Disabled
//	@Test
//	void testReply() {
//		
//		int count = boardMapper.reply(44,"test","test" ,"test", 77, 77, 77);
//		
//		System.out.println("추가된 갯수 : "+ count);
//	}

}
