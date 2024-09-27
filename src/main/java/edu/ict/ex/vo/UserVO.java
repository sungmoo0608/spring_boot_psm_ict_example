package edu.ict.ex.vo;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/*이름       널?       유형            
-------- -------- ------------- 
USERNAME NOT NULL VARCHAR2(50)  
PASSWORD NOT NULL VARCHAR2(100) 
ENABLED           CHAR(1)    */  

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString

public class UserVO  {
	
	private String username;
	private String password;
	private String enabled;
	
	private String email = "abcd@daum.net";
	
	private List<AuthVO> authList;
	
}
