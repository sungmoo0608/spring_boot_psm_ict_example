package edu.ict.ex.mapper;

import java.util.List;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import edu.ict.ex.page.Criteria;
import edu.ict.ex.vo.EmpVO;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootTest
class EmpMapperTest {
   
   @Autowired
   private EmpMapper mapper;
   
   @Test
   void testGetDeptEmpList() {
      System.out.println(mapper.getDeptEmpList());
   }
   
   @Disabled
   @Test
   void testGetEmpDeptList() {
      System.out.println(mapper.getEmpDeptList());
      
      for(EmpVO vo : mapper.getEmpDeptList()) {
         System.out.println(vo);
      }      
   }

   @Disabled
   @Test
   void testGetList() {
      System.out.println(mapper.getList());
      
      for(EmpVO vo : mapper.getList()) {
         System.out.println(vo);
      }      
   }
   
   @Disabled
   @Test
   void testInsert() {
      
      //INSERT INTO EMP  VALUES (1111,'홍길동','CLERK',7369,'2024-09-24', 800,8000,10);
      
      EmpVO emp = new EmpVO();
      emp.setEmpno(2001);
      emp.setEname("홍길동");
      emp.setJob("CLERK");
      emp.setMgr(7369);
      emp.setHiredate2("2024-09-24");
      emp.setComm(800);
      emp.setSal(2000);
      emp.setDeptno(10);
      
      mapper.insert(emp);
      
      
      for(EmpVO vo : mapper.getList()) {
         System.out.println(vo);
      }      
   }
   
   @Disabled
   @Test
   void testGetListWithPaging() {

	   Criteria criteria = new Criteria();

	   criteria.setAmount(10);
	   criteria.setPageNum(1);

	   List<EmpVO> list = mapper.getListWithPaging(criteria);
	   System.out.println(list);

   }
   
   

}
