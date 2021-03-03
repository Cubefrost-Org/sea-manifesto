/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package seamanifesto;

import org.w3c.dom.events.UIEvent;

/**
 *
 * @author TAMOJIT
 */
public class UserManager {
    
    public static String USER="";
    
    public static void main(String[] args) {
        new UserManager().startApp();
    }
    
    public void startApp(){
        Login login=new Login();
        login.setVisible(true);
    }
    
    
}
