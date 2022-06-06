package dao;
import java.sql.*;


public abstract class DAO {
    
   protected Connection c = null; 
   protected PreparedStatement ps = null;
    
   private final String USER = "root";
   private final String PASSWORD = "1234";
   private final String DRIVER = "com.mysql.cj.jdbc.Driver";
   private final String DATABASE = "jdbc:mysql://localhost/mydb";
   
   protected void connect () {
       
       try {
           Class.forName(DRIVER);
           c = DriverManager.getConnection(DATABASE,USER,PASSWORD);
           
       } catch( ClassNotFoundException | SQLException e ){
           
           System.out.println(e);
       }
   }
   
   protected void disconnect (Connection c) {
       try {
           
           c.close();
           
       }catch( SQLException e ){
           
           System.out.println(e);
           
       }
   }
   
    
}
