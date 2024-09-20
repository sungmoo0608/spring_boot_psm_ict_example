package edu.ict.ex.vo;

import java.sql.Timestamp;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


//이름    널? 유형     
//----- -- ------ 
//GRADE    NUMBER 
//LOSAL    NUMBER 
//HISAL    NUMBER 

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString

public class SalgradeVO  {
	
	private int grade;
	private int losal;
	private int hisal;
}
