/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

//Control Class
package seamanifesto;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 *
 * @author alex
 */
public class User {
    private String userid;
    private String password;
    private String email;
    private String contactno;
    private String department;
    User(String uid, String ps, String em, String cn, String dept){
        this.userid=uid;
        this.password=ps;
        this.email=em;
        this.contactno=cn;
        this.department=dept;
    }
    public String getUserID(){
        return this.userid;
    }
    public String getPassword(){
        return password;
    }
    public String getEmail(){
        return email;
    }
    public String getContact(){
        return contactno;
    }
    public String getDept(){
        return department;
    }
    @Override
    public String toString(){
        return this.userid+" "+this.password+" "+this.email+" "+this.department+" "+this.contactno;
    }
    public String getDetails(){
        return "User ID ="+this.userid+"\n"+"User Email ="+this.email+"\n"+"User Department = "+this.department+"\n"+" User Cell No. = "+this.contactno;
    }
    public void Hash() 
    { 
        String input = this.password;
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
            this.password = hashtext; 
        }  
        // For specifying wrong message digest algorithms 
        catch (NoSuchAlgorithmException e) { 
            throw new RuntimeException(e); 
        } 
    }
    
      public String Hashstring(String input) 
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
}
