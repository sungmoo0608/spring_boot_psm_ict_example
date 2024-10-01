package edu.ict.ex.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.ict.ex.mapper.BoardMapper;
import edu.ict.ex.page.Criteria;
import edu.ict.ex.vo.BoardVO;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class BoardServiceImpl implements BoardService {
	
	@Autowired
	private BoardMapper boardMapper;

	@Override
	public List<BoardVO> getList() {
		
		log.info("getList()..");

		return boardMapper.getList();
	}

	@Override
	public BoardVO get(int bno) {
		
		log.info("get()..");
		
		BoardVO board = new BoardVO();
		board.setBid(bno);
		
		boardMapper.upHit(board);
		
		return boardMapper.read(bno);
	}

	@Override
	public int remove(int bno) {
		
		log.info("remove()..");

		return boardMapper.delete(bno);
	}
	
	@Override
	public int writeBoard(BoardVO board) {

		log.info("writeBoard()..");
		
		return boardMapper.insertBoard(board);
	}
	
	@Override
	public int modifyBoard(BoardVO board) {

		log.info("modifyBoard()..");
		
		return boardMapper.updateBoard(board);
	}

	// 순서 있는 기능이 오는 부분 = 비지니스 로직 = 기능이 있는 로직 = 반드시 서비스 단에서 해결
	@Transactional(rollbackFor = Exception.class)	
	// 두개 중 하나는 에러가 날 수 있기에 트랜잭션을 무조건 넣어줌
	@Override
	public void writeReply(BoardVO board) {
		log.info("writeReply()..");
		
		boardMapper.updateShape(board);
		boardMapper.insertReply(board);
		
	}

	@Override
	public int upHit(BoardVO board) {
		log.info("upHit()..");
		
		return boardMapper.upHit(board);
	}

	@Override
	public int getTotal() {
		log.info("getTotal()..");
		
		return boardMapper.getTotalCount();
	}

	@Override
	public List<BoardVO> getListWithPaging(Criteria cri) {
		
		return boardMapper.getListWithPaging(cri);
	}

//  내가 해본 것
//	@Override
//	public int insert(String bname, String btitle, String bcontent) {
//		
//		log.info("insert()..");
//		
//		return boardMapper.write(bname, btitle, bcontent);
//	}
//	
//	@Override
//	public int update(String bname, String btitle, String bcontent, int bid) {
//		
//		log.info("update()..");
//		
//		return boardMapper.modify(bname, btitle, bcontent, bid);
//	}
//
//	@Override
//	public int replyUpdate(int bid, String bname, String btitle, String bcontent, int bgroup, int bstep, int bindent) {
//		
//		log.info("update()..");
//		
//		return boardMapper.reply(bid, bname, btitle, bcontent, bgroup, bstep, bindent);
//	}
	
}
