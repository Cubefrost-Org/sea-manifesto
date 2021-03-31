/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import seamanifesto.StartUI;
import seamanifesto.UserManager;

/**
 *
 * @author TAMOJIT
 */
public class MasterManager {
    public static void main(String[] args) {
        StartUI start = new StartUI();
        start.setVisible(true);
        start.disp();
        new UserManager().startApp();
        
    }
}
