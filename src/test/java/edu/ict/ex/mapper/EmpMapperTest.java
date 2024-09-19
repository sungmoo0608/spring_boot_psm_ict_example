package edu.ict.ex.mapper;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import edu.ict.ex.vo.EmpVO;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootTest
class EmpMapperTest {
   
   @Autowired
   private EmpMapper mapper;

   @Test
   void testGetList() {
      System.out.println(mapper.getList());
      
      for(EmpVO vo : mapper.getList()) {
         System.out.println(vo);
      }      
   }
   
   
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

}
