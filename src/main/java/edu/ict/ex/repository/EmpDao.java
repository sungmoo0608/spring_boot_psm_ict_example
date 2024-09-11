package edu.ict.ex.repository;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import edu.ict.ex.vo.EmpVO;

//DeptRepository


//@Bean = @Component
//@Bean + Dao의 의미
@Repository
public class EmpDao {

   public List<EmpVO> empSelect() {

      List<EmpVO> vos = new ArrayList<>();

      Connection connection = null;
      Statement statement = null;
      ResultSet rs = null;

      String driver = "oracle.jdbc.driver.OracleDriver";
      String url = "jdbc:oracle:thin:@localhost:1521:xe";
      String uid = "scott";
      String upw = "tiger";

      String sql = "select * from emp";

      try {
    	  Class.forName(driver);
         connection = DriverManager.getConnection(url, uid, upw);

         statement = connection.createStatement();
         rs = statement.executeQuery(sql);

         while (rs.next()) {
            int empno = rs.getInt("empno");
            String ename = rs.getString("ename");
            String job = rs.getString("job");
            int mgr = rs.getInt("mgr");
            Date hiredate = rs.getDate("hiredate");
            int sal = rs.getInt("sal");
            int comm = rs.getInt("comm");
            int deptno = rs.getInt("deptno");

            EmpVO vo = new EmpVO(empno, ename, job, mgr, hiredate, sal, comm, deptno);

            vos.add(vo);
         }

      } catch (Exception e) {
         e.printStackTrace();
      } finally {

         try {
            if (rs != null)
               rs.close();

            if (statement != null)
               statement.close();

            if (connection != null)
               connection.close();
         } catch (Exception e) {
         }

      }

      return vos;

   }

}
