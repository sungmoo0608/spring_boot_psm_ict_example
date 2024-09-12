package edu.ict.ex.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import edu.ict.ex.vo.DeptVO;

//마이바티스용 인터페이스라는걸 알려주는 애노테이션
@Mapper
public interface DeptMapper  {
	
	public List<DeptVO> getList();
	
}
