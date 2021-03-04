/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package seamanifesto;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 *
 * @author alex
 */
public class FileManager {
    
    String jsondata="{\"name\": \"Sam Smith\", \"technology\": \"Python\"}";
    String messagetype="MESSAGE TYPE",messageid="MESSAGE ID",reportingevent="REPORTING EVENT",senderid="SENDERID",jobid="JOBID",date="DATE",declaration="DECLARATION";
    Form samobj=new Form(jsondata,messagetype,messageid,reportingevent,senderid,jobid,date,declaration);
    public static void main(String[] args){
        FileManager fm = new FileManager();
        fm.init();
    }
    public void init(){
    System.out.println(samobj.getFileName());
    System.out.println(samobj.getData());
    System.out.println("\n============================================\n");
    this.exportfile(samobj, "PATH");
    }
    
    public void exportfile(Form obj, String path) {
        String jsonstring=obj.getData();
//String jsonstring="";
        JSONObject  jsonObject=new JSONObject();
    JSONParser jsonParser=new  JSONParser();
    if ((jsonstring != null) && !(jsonstring.isEmpty())) {
        try {
            jsonObject=(JSONObject) jsonParser.parse(jsonstring);
        } catch (org.json.simple.parser.ParseException e) {
            e.printStackTrace();
        }
        
    }
    System.out.println(jsonObject.toJSONString());
    
    }
}
