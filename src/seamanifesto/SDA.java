/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package seamanifesto;

/**
 *
 * @author alex
 */
public class SDA extends Form{
    private String jsonEntry;
    SDA(String jsondata, String messageType,String mid, String reportingevent, String sendID, String jobID, String date, String declaration){
        super(messageType, mid,"SDA",sendID,jobID,date,declaration);
        this.jsonEntry=jsondata;        
    }
    public String getData(){
        return jsonEntry;
    }
    public String getFileName(){
        return super.msgtype()+"_"+super.messageID()+"_"+super.reportingEvent()+"_"+super.senderID()+"_"+super.jobID()+"_"+super.Date()+"_"+super.declaration();
    }
}
