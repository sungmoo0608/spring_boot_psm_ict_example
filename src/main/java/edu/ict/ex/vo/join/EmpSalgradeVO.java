package edu.ict.ex.vo.join;

import edu.ict.ex.vo.EmpVO;
import edu.ict.ex.vo.SalgradeVO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString

public class EmpSalgradeVO  {
	
	private EmpVO emp;
	private SalgradeVO salGrade;

}
