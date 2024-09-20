package edu.ict.ex.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import edu.ict.ex.page.Criteria;
import edu.ict.ex.vo.EmpDeptSalVO;
import edu.ict.ex.vo.DeptEmpVO;
import edu.ict.ex.vo.EmpDeptVO;
import edu.ict.ex.vo.EmpSalVO;
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
	
	//조인 처리 1:1 처리
	public List<EmpDeptVO> getEmpOneDeptList();
	
	//조인 처리 1:1 처리
	public List<EmpSalVO> getEmpOneSalList();
	
	//조인 처리 1:1 처리
	public List<EmpDeptSalVO> getDeptEmpSalList();
	
	//페이징 관련
	int getTotalCount();
	List<EmpVO> getListWithPaging(Criteria cri);
	
}
