/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package seamanifesto;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author TAMOJIT
 */
public class LoginManager {
    
    
    
    public static boolean Create() {
      Connection c = null;
      Statement stmt = null;
      
      try {
         Class.forName("org.sqlite.JDBC");
         c = DriverManager.getConnection("jdbc:sqlite:auth.db");
         System.out.println("Opened database successfully");

         stmt = c.createStatement();
         String sql = "CREATE TABLE AUTH " +
                        "(USERNAME TEXT PRIMARY KEY    NOT NULL, " + 
                        " PASSWORD       TEXT     NOT NULL)"; 
         stmt.executeUpdate(sql);
         stmt.close();
         c.close();
         return true;
      } catch ( Exception e ) {
         System.out.println( e.getClass().getName() + ": " + e.getMessage() );
         return false;
      }    
      
   }
  
  
  public static boolean Insert(String Username,String Password) {
      Connection c = null;
      Statement stmt = null;
      
      try {
         Class.forName("org.sqlite.JDBC");
         c = DriverManager.getConnection("jdbc:sqlite:auth.db");
         c.setAutoCommit(false);
         System.out.println("Opened database successfully");

         stmt = c.createStatement();
         String sql = "INSERT INTO AUTH (USERNAME,PASSWORD) " +
                        "VALUES ('"+Username+"', '"+Password+"');"; 
         
         System.out.println(sql);
         stmt.executeUpdate(sql);

         

         stmt.close();
         c.commit();
         c.close();
         return true;
      } catch ( Exception e ) {
         System.out.println( e.getClass().getName() + ": " + e.getMessage() );
         return false;
      }
      
   }
  
  public static boolean Check(String Username, String Password) {

   Connection c = null;
   
   try {
      Class.forName("org.sqlite.JDBC");
      c = DriverManager.getConnection("jdbc:sqlite:auth.db");
      c.setAutoCommit(false);
      System.out.println("Opened database successfully");
      
      String query="SELECT * FROM AUTH WHERE USERNAME=? AND PASSWORD=? ";
      
      var pst=c.prepareStatement(query);
      
      pst.setString(1, Username);
      pst.setString(2,Password);
      
      
     
      ResultSet rs = pst.executeQuery();
      
      
      
      
      int count=0;
      while(rs.next()){
          count++;          
      }
      
      

      
      rs.close();
      
      c.close();
      
      
      
      if (count==1){
          return true;
      }else{
          return false;
      }
      
      
      
      
   } catch ( Exception e ) {
      System.err.println( e.getClass().getName() + ": " + e.getMessage() );
      System.exit(0);
   }
   
   return false;
  }
    
}
