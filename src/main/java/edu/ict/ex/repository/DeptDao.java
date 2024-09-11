package edu.ict.ex.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import edu.ict.ex.vo.DeptVO;

//DeptRepository


//@Bean = @Component
//@Bean + Dao의 의미
@Repository
public class DeptDao {

   public List<DeptVO> deptSelect() {

      List<DeptVO> vos = new ArrayList<>();

      Connection connection = null;
      Statement statement = null;
      ResultSet rs = null;

      String driver = "oracle.jdbc.driver.OracleDriver";
      String url = "jdbc:oracle:thin:@localhost:1521:xe";
      String uid = "scott";
      String upw = "tiger";

      String sql = "select * from dept";

      try {
    	  Class.forName(driver);
         connection = DriverManager.getConnection(url, uid, upw);

         statement = connection.createStatement();
         rs = statement.executeQuery(sql);

         while (rs.next()) {
            int deptno = rs.getInt("deptno");
            String dname = rs.getString("dname");
            String loc = rs.getString("loc");

            DeptVO vo = new DeptVO(deptno, dname, loc);

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
