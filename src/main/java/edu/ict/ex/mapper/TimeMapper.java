package edu.ict.ex.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

//마이바티스용 인터페이스라는걸 알려주는 애노테이션
@Mapper
public interface TimeMapper  {
	
	public String getTime();
	
	//마이바티스 3.0~ 부터 제공
	@Select("select sysdate from dual")
	public String getTime2();
}
