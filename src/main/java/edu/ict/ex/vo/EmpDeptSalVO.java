package edu.ict.ex.vo;

import java.sql.Timestamp;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

//이름     널?       유형           
//------ -------- ------------ 
//DEPTNO NOT NULL NUMBER(2)    
//DNAME           VARCHAR2(14) 
//LOC             VARCHAR2(13)

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString

public class EmpDeptSalVO  {

	private int empno;
	private String ename;
	private String job;
	private int mgr;
	private Timestamp hiredate;
	private int sal;
	private int comm;
	private int deptno;
	
	private DeptVO dept;
	private SalgradeVO salGrade;
	
}
