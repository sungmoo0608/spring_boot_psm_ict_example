package edu.ict.ex.service;

import java.util.List;

import edu.ict.ex.page.Criteria;
import edu.ict.ex.vo.BoardVO;

public interface BoardService {
	List<BoardVO> getList();
	BoardVO get(int bno);
	int remove(int bno);

	int writeBoard(BoardVO board);
	int modifyBoard(BoardVO board);
	
	// 댓글
	void writeReply(BoardVO board);

	// 히트
	int upHit(BoardVO board);
	
	// 페이징
	// 페이징 처리 함수
	int getTotal();
	List<BoardVO> getListWithPaging(Criteria cri);
	
	// 내가 했던 것
	// int insert(String bname,String btitle,String bcontent);
	// int update(String bname,String btitle,String bcontent,int bid);
	// int replyUpdate(int bid, String bname, String btitle, String bcontent, int bgroup, int bstep, int bindent);
	
}
