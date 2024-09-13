package edu.ict.ex.db;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.sql.DataSource;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootTest
class DataSourceTest {
   
   @Autowired
   private DataSource dataSource;
      
   
   @Test
   public void testDataSource() throws Exception {
      System.out.println("DS=" + dataSource);

      try (Connection conn = dataSource.getConnection()) {
         System.out.println("Cooooooooonn=" + conn);
         assertThat(conn).isInstanceOf(Connection.class);

         assertEquals(100, getLong(conn, "select 100 from dual"));
         //assertTrue(0 < getLong(conn, "select count(*) from User"));

      } catch (Exception e) {
         e.printStackTrace();
      }
   }
   
   private long getLong(Connection conn, String sql) {
      long result = 0;
      try (Statement stmt = conn.createStatement()) {
         ResultSet rs = stmt.executeQuery(sql);
         if (rs.next()) {
            result = rs.getLong(1);
         }
         rs.close();
      } catch (Exception e) {
         e.printStackTrace();
      }
      
      return result;
   }

}
