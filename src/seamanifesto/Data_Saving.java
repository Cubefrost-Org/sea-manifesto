package seamanifesto;



import java.io.FileWriter;
import java.io.IOException;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import java.util.*;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Soham
 */
public class Data_Saving {
    public static void main(String args[])throws IOException, ParseException
    {
        Scanner Sc=new Scanner(System.in);
        System.out.println("Enter msgtype");
        String msgtype=Sc.nextLine();
        System.out.println("Enter msgid");
        String msgid=Sc.nextLine();
        System.out.println("Enter jobid");
        String jobid=Sc.nextLine();
        System.out.println("Enter senderid");
        String senderid=Sc.nextLine();
        System.out.println("Enter reporting event");
        String reportingevent=Sc.nextLine();
        System.out.println("Enter bldate");
        String bldate=Sc.nextLine();
        System.out.println("Enter declaration");
        String declaration=Sc.nextLine();
        System.out.println("Enter path to save");
        String path=Sc.nextLine();
        System.out.println("Saved Successfully");
        
        JSONObject json=new JSONObject();
        json.put("msgtype",msgtype);
        json.put("msgid",msgid);
        json.put("jobid",jobid);
        json.put("SenderID",senderid);
        json.put("reporting event",reportingevent);
        json.put("B/L date",bldate);
        json.put("Declaration",declaration);
     
        try(FileWriter writer=new FileWriter(path))
        {
            writer.write(json.toString());
            writer.flush();
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
}
}
