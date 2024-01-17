package com.learn.sendemail.gmailsender;

import java.io.File;
import java.util.Properties;

import jakarta.mail.Authenticator;
import jakarta.mail.Message;
import jakarta.mail.PasswordAuthentication;
import jakarta.mail.Session;
import jakarta.mail.Transport;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeBodyPart;
import jakarta.mail.internet.MimeMessage;
import jakarta.mail.internet.MimeMultipart;

public class GmailSender {

	public boolean sendEmail(String to, String from, String subject, String message) {
		
		       boolean flag = false;
		       
			   Properties properties = System.getProperties();
		       System.out.println( "properties: "+properties );
		       
		       // Step1: configure SMTP server details
		       properties.put("mail.smtp.host", "smtp.gmail.com");
		       properties.put("mail.smtp.port", "587");
		       properties.put("mail.smtp.starttls.enable", true);
		       properties.put("mail.smtp.auth", true);
		      
		       //Step2: to get session object
		       final String username = "shankar.sharma89202";
		       final String password = "tohmcvzbjfeybmbu";
		       Session session= Session.getInstance(properties, new Authenticator() {  
		    	    @Override
		    	     protected PasswordAuthentication getPasswordAuthentication() {
		    		 return new PasswordAuthentication(username,password);
		    	  }
			   });  
		      
		       //Step3: compose the messsage
		       Message msg = new MimeMessage(session);
		       try {	
		    	//Step4: set to,from,message,subject
		    	   msg.setFrom(new InternetAddress(from));
		    	   msg.setRecipient(Message.RecipientType.TO, new InternetAddress(to));
		    	   msg.setSubject(subject);
		    	   msg.setText(message);
		           
		           //Step5: send message using Transport class
		           Transport.send(msg);
		           flag = true;
		           System.out.println( "message sent successfully..." );
		       }catch (Exception e) {
				e.printStackTrace();
			}
           return flag;
		}
	
	public boolean sendEmailWithAttachment(String to, String from, String subject, String message,File file) {
		
	       boolean flag = false;
	       
		   Properties properties = System.getProperties();
	       System.out.println( "properties: "+properties );
	       
	       // Step1: configure SMTP server details
	       properties.put("mail.smtp.host", "smtp.gmail.com");
	       properties.put("mail.smtp.port", "587");
	       properties.put("mail.smtp.starttls.enable", true);
	       properties.put("mail.smtp.auth", true);
	      
	       //Step2: to get session object
	       final String username = "shankar.sharma89202";
	       final String password = "tohmcvzbjfeybmbu";
	       Session session= Session.getInstance(properties, new Authenticator() {  
	    	    @Override
	    	     protected PasswordAuthentication getPasswordAuthentication() {
	    		 return new PasswordAuthentication(username,password);
	    	  }
		   });  
	      
	       //Step3: compose the messsage
	       Message msg = new MimeMessage(session);
	       try {	
	    	//Step4: set to,from,message,subject
	    	   msg.setFrom(new InternetAddress(from));
	    	   msg.setRecipient(Message.RecipientType.TO, new InternetAddress(to));
	    	   msg.setSubject(subject);
	    	   
	    	   MimeBodyPart part1 = new MimeBodyPart(); 
	    	   part1.setText(message);
	    	   MimeBodyPart part2 = new MimeBodyPart(); 
	    	   part2.attachFile(file);
	    	   
	    	   MimeMultipart multipart = new MimeMultipart();
	    	   multipart.addBodyPart(part1);
	    	   multipart.addBodyPart(part2);
	    	   
	    	   msg.setContent(multipart);

	           //Step5: send message using Transport class
	           Transport.send(msg);
	           flag = true;
	           System.out.println( "message sent successfully with file..." );
	       }catch (Exception e) {
			e.printStackTrace();
		}
    return flag;
	}
}
