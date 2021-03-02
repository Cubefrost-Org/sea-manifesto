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
public class Form {
    private String messageType;
    private String messageid;
    private String reportingevent;
    private String sendID;
    private String jobID;
    private String date;
    private String declaration;
    Form(String msgtyp,String mid, String repevent, String sID, String jID, String dt, String dec){
        this.messageType=msgtyp;
        this.messageid=mid;
        this.reportingevent= repevent;
        this.sendID= sID;
        this.jobID=jID;
        this.date=dt;
        this.declaration=dec;
    }
    protected String msgtype(){
        return this.messageType;
    }
    protected String messageID(){
        return this.messageid;
    }
    protected String reportingEvent(){
        return this.reportingevent;
    }
    protected String senderID(){
        return this.sendID;
    }
    protected String jobID(){
        return this.jobID;
    }
    protected String Date(){
        return this.date;
    }
    protected String declaration(){
        return this.declaration;
    }
    
}
