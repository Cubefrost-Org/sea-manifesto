/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package seamanifesto;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author TAMOJIT
 */
public class LoginManager {
    
    public static String Hashstring(String input) 
    { 
        
        try {  
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] messageDigest = md.digest(input.getBytes()); 
  
            // Convert byte array into signum representation 
            BigInteger no = new BigInteger(1, messageDigest); 
  
            // Convert message digest into hex value 
            String hashtext = no.toString(16); 
            while (hashtext.length() < 32) { 
                hashtext = "0" + hashtext; 
            } 
            return hashtext; 
        }  
        // For specifying wrong message digest algorithms 
        catch (NoSuchAlgorithmException e) { 
            throw new RuntimeException(e); 
        } 
    }

    public static boolean Create() {

      try {
         Class.forName("org.sqlite.JDBC");
         Connection c = DriverManager.getConnection("jdbc:sqlite:auth.db");
         System.out.println("Opened database successfully");

         Statement stmt = c.createStatement();
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

      try {
          
         Password=Hashstring(Password);
         Class.forName("org.sqlite.JDBC");
         Connection c = DriverManager.getConnection("jdbc:sqlite:auth.db");
         c.setAutoCommit(false);
         System.out.println("Opened database successfully");

         Statement stmt = c.createStatement();
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

   try {
      Password=Hashstring(Password);
      Class.forName("org.sqlite.JDBC");
      Connection c = DriverManager.getConnection("jdbc:sqlite:auth.db");
      c.setAutoCommit(false);
      System.out.println("Opened database successfully");
      
      String query="SELECT PASSWORD FROM AUTH WHERE USERNAME=\""+Username+"\";";
      
      var pst=c.prepareStatement(query);
      ResultSet rs = pst.executeQuery();
      String storedPassword = rs.getString("PASSWORD");

      rs.close();
      c.close();
      
      return storedPassword.equals(Password);

   } catch (java.sql.SQLException e){
       return false;
   }catch ( Exception e ) {
      System.err.println( e.getClass().getName() + ": " + e.getMessage() );
      System.exit(0);
   }

   return false;
  }
  
  
  
  

}
