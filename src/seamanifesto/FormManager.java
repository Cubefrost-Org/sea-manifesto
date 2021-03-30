/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package seamanifesto;

import java.awt.Dialog;

/**
 *
 * @author nibba
 */
public class FormManager {
    public void createArrivalManifest(){
        new NewArrivalManifest().setVisible(true);
    }
    
    public void ammendArrivalManifest(){
        new ArrivalManifestAmmendment().setVisible(true);
    }
    
    public void createDepatureManifest(){
        new DepartureManifest().setVisible(true);
    }
    
    public void ammendDepartureManifest(){
        new DepartureManifestAmmendment().setVisible(true);
    }
    
    public void createNotification(){
        new DepartureNotification().setVisible(true);
    }
    
    public void createEntryInward(){
        new EntryInward().setVisible(true);
    }
}
