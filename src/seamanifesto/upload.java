package seamanifesto;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Soham
 */
import java.io.IOException;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
//import static org.junit.Assert.assertEquals;
import java.util.*;
public class upload {

	public static void main(String[] args) {
		//assert(true);
                
                System.out.println("preparing to send mail");
                Scanner Sc=new Scanner(System.in);
                System.out.println("Enter Username and password");
		String usname = Sc.nextLine();
		String pwd = Sc.nextLine();
                String username=usname;
                String password=pwd;
		final String fromEmail =username;
                System.out.println("Enter email Id to send");
		final String toEmail = Sc.nextLine();
		System.out.println("Enter subject");
                String subject=Sc.nextLine();
                System.out.println("Enter bodypart");
                String body=Sc.nextLine();
                System.out.println("Enter file location to attach");
                String location=Sc.nextLine();
                //assertEquals("seamanifestoofficial@gmail.com",username);
                //assertEquals("$eaManifesto4",password);
		
                Properties properties = new Properties();
		properties.put("mail.smtp.auth", "true");
		properties.put("mail.smtp.starttls.enable", "true");
		properties.put("mail.smtp.host", "smtp.gmail.com");
		properties.put("mail.smtp.port", "587");
		Session session = Session.getInstance(properties, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(username,password);
			}
		});
		
		MimeMessage msg = new MimeMessage(session);
		try {
			msg.setFrom(new InternetAddress(fromEmail));
			msg.addRecipient(Message.RecipientType.TO, new InternetAddress(toEmail));
			msg.setSubject(subject);
			
			Multipart emailContent = new MimeMultipart();
			
			
			MimeBodyPart textBodyPart = new MimeBodyPart();
			textBodyPart.setText(body);
			
			
			MimeBodyPart jsonAttachment = new MimeBodyPart();
			jsonAttachment.attachFile(location);
			
			
			emailContent.addBodyPart(textBodyPart);
			emailContent.addBodyPart(jsonAttachment);
			
			
			msg.setContent(emailContent);
			
			Transport.send(msg);
			System.out.println("Message sent Successfully");
		} catch (MessagingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
