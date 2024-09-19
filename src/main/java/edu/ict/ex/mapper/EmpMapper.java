package edu.ict.ex.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import edu.ict.ex.page.Criteria;
import edu.ict.ex.vo.BoardVO;
import edu.ict.ex.vo.DeptEmpVO;
import edu.ict.ex.vo.EmpVO;

//마이바티스용 인터페이스라는걸 알려주는 애노테이션
@Mapper
public interface EmpMapper  {
	
	public List<EmpVO> getList();
	public int insert(EmpVO empVO);
	
	//조인 처리 첫번째 방법
	public List<EmpVO> getEmpDeptList();	
	
	//조인 처리 두번째 방법
	public List<DeptEmpVO> getDeptEmpList();
	
	//페이징 관련
	int getTotalCount();
	List<EmpVO> getListWithPaging(Criteria cri);
	
}
