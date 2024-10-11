package com.cybercat.user.helper;

import java.io.File;
import java.nio.file.Files;
import java.util.Properties;
import javax.mail.Authenticator;
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
import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class SendMailOTP {
	public static void mailSend(String mail, String content) throws Exception {
		String to = mail;
		Properties prop = new Properties();
		prop.load(SendMailOTP.class.getClassLoader().getResourceAsStream("application.properties"));
		final String from = (String) prop.get("mailserver.mailid");
		String pass = (String) prop.get("mailserver.password");
		final String host = (String) prop.get("mailserver.host");
		final String password = AESEncryption.decrypt(pass);
		prop.setProperty("mail.smtp.host", host);
		prop.put("mail.smtp.auth", "true");
		prop.put("mail.smtp.port", "587");
		prop.put("mail.smtp.starttls.enabled", "none");
		Session session = Session.getInstance(prop, new Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(from, password);
			}
		});

		try {

			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress(from));
			message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
			message.setSubject("CYBERCAT SUPPORT - SECURITY CODE VERIFICATION");
			File htmlFile = new File("home/otp_template.html");
			String msg1 = new String(Files.readAllBytes(htmlFile.toPath()));
			msg1 = msg1.replace("SECURITYCODE", content);

			MimeBodyPart messageBody2 = new MimeBodyPart();
			messageBody2.setContent(msg1, "text/html");

			Multipart multipart = new MimeMultipart();
			multipart.addBodyPart(messageBody2);

			message.setContent(multipart);

			Transport.send(message);

			System.out.println("successfully send");

		} catch (MessagingException ex) {
			ex.printStackTrace();
		}
	}
	public static void approvalSend(String mail, String content) throws Exception {
		String to = mail;
		Properties prop = new Properties();
		prop.load(SendMailOTP.class.getClassLoader().getResourceAsStream("application.properties"));
		final String from = (String) prop.get("mailserver.mailid");
		String pass = (String) prop.get("mailserver.password");
		final String host = (String) prop.get("mailserver.host");
		final String password = AESEncryption.decrypt(pass);
		prop.setProperty("mail.smtp.host", host);
		prop.put("mail.smtp.auth", "true");
		prop.put("mail.smtp.port", "587");
		prop.put("mail.smtp.starttls.enabled", "none");
		Session session = Session.getInstance(prop, new Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(from, password);
			}
		});

		try {

			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress(from));
			message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
			message.setSubject("CTRACK CLAIM APPROVAL");
			File htmlFile = new File("home/approval_template.html");
			String msg1 = new String(Files.readAllBytes(htmlFile.toPath()));
			msg1 = msg1.replace("SECURITYCODE", content);

			MimeBodyPart messageBody2 = new MimeBodyPart();
			messageBody2.setContent(msg1, "text/html");

			Multipart multipart = new MimeMultipart();
			multipart.addBodyPart(messageBody2);

			message.setContent(multipart);

			Transport.send(message);

			System.out.println("successfully send");

		} catch (MessagingException ex) {
			ex.printStackTrace();
		}
	}
}
