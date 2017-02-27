package com.felight.javamail;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import org.apache.log4j.*;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class SendMail {
	final static Logger logger=Logger.getLogger(SendMail.class);
	String username;
	String password;
	String to;
	String Body;
	String Subject;
	public SendMail(String username,String password,String to,String Body,String Subject) {
		this.username=username;
		this.password=password;
		this.to=to;
		this.Subject=Subject;
		this.Body=Body;
	}
	
	public void send() {
		
		PropertyConfigurator.configure("log4j.properties");
		File file = new File("mail.properties");
		FileInputStream fileInput = null;
		logger.info("************SendMail Started******************");
		try {
			fileInput = new FileInputStream(file);
			logger.debug("Reading file mail.properties");
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
			logger.error("error while reading mail.properties"+e1);
		}
		Properties props = new Properties();
		logger.info("retriving properties from mail.properties");
		try {
			props.load(fileInput);
		} catch (IOException e1) {
			logger.error("Failed to retrive properties "+e1);
			e1.printStackTrace();
		}
		props.getProperty("mail.smtp.auth");
		logger.debug("Initializing mail.smtp.auth ");
		props.getProperty("mail.smtp.starttls.enable");
		logger.debug("Initilalizing mail.smtp.starttls.enable");
		props.getProperty("mail.smtp.starttls.enable");
		logger.debug("Initilalizing mail.smtp.starttls.enable");
		props.getProperty("mail.smtp.host");
		logger.debug("initializing mail.smtp.host");
		props.getProperty("mail.smtp.port");
		logger.debug("initializing mail.smtp.port");

		Session session = Session.getInstance(props, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(username, password);
			}
		});
		logger.debug("session Created");
		try {

			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress(username));
			message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to));
			message.setSubject(Subject);
			message.setText(Body);
			logger.debug("created message");
			logger.info("Trying to send mail");
			Transport.send(message);
			logger.info("Mail sent successfully");
			logger.info("*******End**********");

			System.out.println("Done");

		} catch (MessagingException e) {
			logger.error("Failed to create message"+e);
			throw new RuntimeException(e);
		}

	}
}