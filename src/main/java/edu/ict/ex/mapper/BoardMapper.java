package edu.ict.ex.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import edu.ict.ex.vo.BoardVO;

//마이바티스용 인터페이스라는걸 알려주는 애노테이션
@Mapper
public interface BoardMapper  {
	
	public List<BoardVO> getList();
	BoardVO read(int bno);
	
	//게시판 삭제 == 삭제된 갯수 리턴
	int delete(int bno); 
	
	//내가 해본 것
	//게시판 작성 == 추가된 갯수 리턴 
	//int write(String bname,String btitle,String bcontent);
	
	//내가 해본 것
	//게시판 수정 == 수정된 갯수 리턴
	//int modify(String bname,String btitle,String bcontent, int bid);
	
	//내가 해본 것
	//답글 작성 == 추가된 갯수 리턴
	//int reply(int bid, String bname, String btitle, String bcontent, int bgroup, int bstep, int bindent);
	
	//게시판 insert
	int intsertBoard(@Param("board") BoardVO boardVO);
	//2개 이상 불러올떄
	//int intsertBoard(@Param("board") BoardVO boardVO, @Param("emp") EmpVO empVO);
	
	//게시판 update
	int updateBoard(BoardVO boardVO);
	
	//조회수 관련
	int upHit(BoardVO boardVO);

	//댓글 관련
	public void updateShape(BoardVO boardVO);
	public void insertReply(BoardVO boardVO);
	

	
}
