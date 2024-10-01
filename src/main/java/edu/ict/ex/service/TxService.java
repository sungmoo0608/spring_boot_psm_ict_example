package edu.ict.ex.service;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.ict.ex.mapper.BoardMapper;
import edu.ict.ex.vo.BoardVO;

@Service
public class TxService {
	
	@Autowired
	private BoardMapper mapper;
	
	//2개 이상의 작업이 하나의 함수안에서 이루어질때는
	//반드시 @Transactional을 붙일것
	
	@Transactional
	public void txTest1() {
		
		System.out.println("1번 테스트...");
		
		BoardVO vo = new BoardVO();
		
		vo.setBcontent("트랜잭션1");
		vo.setBname("트랜잭션1");
		vo.setBtitle("트랜잭션1");
		
		mapper.insertBoard(vo);
		
		BoardVO vo2 = new BoardVO();
		
		vo2.setBcontent("트랜잭션2");
		vo2.setBname("트랜잭션2");
		vo2.setBtitle("트랜잭션2");
		
		vo2=null;
		
		mapper.insertBoard(vo2);
		
	}
	
	@Transactional
	public void txTest2() {
		
		System.out.println("테스트 2번");
		
		BoardVO boardVO = new BoardVO();
		boardVO.setBcontent("트랜잭션4");
		boardVO.setBname("트랜잭션4");
		boardVO.setBtitle("트랜잭션4");      
	   
		mapper.insertBoard(boardVO);
	      
		throw new RuntimeException("RuntimeException for rollback");
	      
	}
	
	@Transactional
	public void txTest3() throws SQLException {
		
		System.out.println("테스트 3번");
		
		BoardVO boardVO = new BoardVO();
		boardVO.setBcontent("트랜잭션5");
		boardVO.setBname("트랜잭션5");
		boardVO.setBtitle("트랜잭션5");      
	   
		mapper.insertBoard(boardVO);
	      
		throw new SQLException("SQLException for rollback");
	      
	}
	
	
	//@Transactional의 rollbackFor 옵션을 이용하면 Rollback이 되는 클래스를 지정가능함.
	// Exception예외로 롤백을 하려면 다음과 같이 지정하면됩니다. 
	//@Transactional(rollbackFor = Exception.class) 
	// 여러개의 예외를 지정할 수도 있습니다.    
	
	@Transactional(rollbackFor = Exception.class)
	public void txTest4() throws SQLException {
		
		System.out.println("테스트 4번");
		
		BoardVO boardVO = new BoardVO();
		boardVO.setBcontent("트랜잭션4");
		boardVO.setBname("트랜잭션4");
		boardVO.setBtitle("트랜잭션4");      
	   
		mapper.insertBoard(boardVO);
	      
		throw new SQLException("SQLException for rollback");
	      
	}
	
	
	public void checkExample() throws RuntimeException {
		
		//File file = new File("aa.txt");
		//Scanner scanner = new Scanner(file);
		
	}
	
	public void useCheckException() {
		checkExample();
	}
	

}
