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
    private String jsonEntry;
    private String messageType;
    private String messageid;
    private String reportingevent;
    private String sendID;
    private String jobID;
    private String date;
    private String declaration;

    Form(String json, String msgtyp,String mid, String repevent, String sID, String jID, String dt, String dec){
        this.jsonEntry=json;
        this.messageType=msgtyp;
        this.messageid=mid;
        this.reportingevent= repevent;
        this.sendID= sID;
        this.jobID=jID;
        this.date=dt;
        this.declaration=dec;
    }

    private String msgtype(){
        return this.messageType;
    }
    private String messageID(){
        return this.messageid;
    }
    private String reportingEvent(){
        return this.reportingevent;
    }
    private String senderID(){
        return this.sendID;
    }
    private String jobID(){
        return this.jobID;
    }
    private String Date(){
        return this.date;
    }
    private String declaration(){
        return this.declaration;
    }
    public String getData(){
        return jsonEntry;
    }
    public String getFileName(){
        return this.msgtype()+"_"+this.messageID()+"_"+this.reportingEvent()+"_"+this.senderID()+"_"+this.jobID()+"_"+this.Date()+"_"+this.declaration();
    }

}
