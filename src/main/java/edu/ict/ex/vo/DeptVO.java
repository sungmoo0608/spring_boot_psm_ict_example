package edu.ict.ex.vo;

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

public class DeptVO  {

	private int deptno;
	private String dname;
	private String loc;
	
}
