package edu.ict.ex.service;

import java.util.List;

import edu.ict.ex.vo.BoardVO;

public interface BoardService {
	List<BoardVO> getList();
	BoardVO get(int bno);
	int remove(int bno);
	int insert(String bname,String btitle,String bcontent);
	int update(String bname,String btitle,String bcontent,int bid);
	int replyUpdate(int bid, String bname, String btitle, String bcontent, int bgroup, int bstep, int bindent);
}
