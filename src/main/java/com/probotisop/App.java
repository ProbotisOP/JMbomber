package com.probotisop;

import java.io.IOException;
import java.util.Properties;
import java.util.Scanner;

import javax.mail.*;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import com.github.lalyos.jfiglet.FigletFont;

public class App {
	public static void main(String[] args) throws AddressException, MessagingException, IOException {
		
		   String asciiArt1 = FigletFont.convertOneLine("JMbomber");
		    System.out.print(asciiArt1);
		    System.out.print("				                   by: ProbotisOP");
	   
		    System.out.println();
		    System.out.println();
		    System.out.println();
		Scanner s = new Scanner(System.in);
		System.out.println("ENTER RECIVERS MAIL ADDRESS:  ");
		String to = s.nextLine();
		
		System.out.println("ENTER YOUR MAIL ADDRESS:  ");
		final String mail = s.nextLine();
		
		System.out.println("ENTER YOUR MAIL PASSWORD:  ");
		final String pass = s.nextLine();

		System.out.println("ENTER SUBJECT FOR MAIL :  ");
		String subject = s.nextLine();

		System.out.println("ENTER BODY MESSAGE:  ");
		String msg = s.nextLine();

		System.out.println("ENTER THE NUMBER OF MAILS YOU WANT TO SEND :  ");
		int x = s.nextInt();

		Properties prop = new Properties();
		prop.put("mail.smtp.host", "smtp.gmail.com");
		prop.put("mail.smtp.port", "465");
		prop.put("mail.smtp.auth", "true");
		prop.put("mail.smtp.ssl.enable", "true");

		Session session = Session.getInstance(prop, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(mail, pass);
			}
		});

		while (x > 0)
			try {

				Message message = new MimeMessage(session);
				message.setFrom(new InternetAddress(mail));
				message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to));
				message.setSubject(subject);
				message.setText(msg);

				Transport.send(message);
				System.out.println("Mail Sent...");
				x--;

			} catch (MessagingException e) {
				e.printStackTrace();
			}
	}
}