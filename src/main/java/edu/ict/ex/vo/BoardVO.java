package edu.ict.ex.vo;

import java.sql.Timestamp;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

//이름       널?       유형             
//-------- -------- -------------- 
//BID      NOT NULL NUMBER(4)      
//BNAME             VARCHAR2(100)  
//BTITLE            VARCHAR2(300)  
//BCONTENT          VARCHAR2(1200) 
//BDATE             DATE           
//BHIT              NUMBER(4)      
//BGROUP            NUMBER(4)      
//BSTEP             NUMBER(4)      
//BINDENT           NUMBER(4)      

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString

public class BoardVO  {
	
	private int bid;
	private String bname;
	private String btitle;
	private String bcontent;
	private Timestamp bdate;
	private int bhit;
	private int bgroup;
	private int bstep;
	private int bindent;
	
}
