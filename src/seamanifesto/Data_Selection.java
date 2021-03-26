package seamanifesto;




import java.io.FileReader;
import java.io.IOException;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
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
public class Data_Selection {
    public static void main(String args[])throws IOException, ParseException
    {
        Scanner Sc=new Scanner(System.in);
        System.out.println("Enter file path");
        String path=Sc.nextLine();
        System.out.println("File Selected Successfully");
        JSONParser jsonparser=new JSONParser();
        FileReader reader=new FileReader(path);
        //assert.hasExtension("json");
        Object ob=jsonparser.parse(reader);
        JSONObject jsonob=(JSONObject)ob;
        System.out.println(jsonob.get("msgtype"));
        System.out.println(jsonob.get("msgid"));
        System.out.println(jsonob.get("jobid"));
        System.out.println(jsonob.get("SenderID"));
        System.out.println(jsonob.get("reporting event"));
        System.out.println(jsonob.get("B/L date"));
        System.out.println(jsonob.get("Declaration"));
    }
}
