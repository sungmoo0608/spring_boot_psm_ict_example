package edu.ict.ex.mapper;

import org.apache.ibatis.annotations.Mapper;

import edu.ict.ex.vo.UserVO;

//마이바티스용 인터페이스라는걸 알려주는 애노테이션
@Mapper
public interface UserMapper  {
	UserVO getUser(String username);
	
	int insertUser(UserVO userVO);
	int insertAuthorities(UserVO userVO);
	
}
