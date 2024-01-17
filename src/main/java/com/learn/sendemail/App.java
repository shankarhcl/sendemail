package com.learn.sendemail;

import java.io.File;
import java.util.Properties;

import com.learn.sendemail.gmailsender.GmailSender;

public class App 
{
    public static void main( String[] args )
    {
        String to = "preeti.pandey68@gmail.com";
        String from = "shankar.sharma89202@gmail.com";
        String subject = "Send mail using Gmail";
        String message="Preeti mail aa gayi hogi tumhe";
        
        
       	System.out.println( "Preparing to send message..." );
    	GmailSender gmailSender =  new GmailSender();
    	
    	File file = new File("C:\\Users\\Shank\\Downloads\\sample\\sample.txt");
        boolean b =  gmailSender.sendEmailWithAttachment(to, from, subject, message, file);

        if(b)
           	System.out.println( "email sent successfully..." );

        else
           	System.out.println( "Something went wrong" );
    }
}
