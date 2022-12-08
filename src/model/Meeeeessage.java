package model;

import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class Meeeeessage {
	
	public static void sendMail(String recepient)  {
		Properties propeties = new Properties();
		propeties.put("mail.smtp.auth", "true");
		propeties.put("mail.smtp.starttls.enable", "true");
		propeties.put("mail.smtp.host", "smtp.gmail.com");
		propeties.put("mail.smtp.port", "587");
		
		String envoyeurDemail ="mmarc71779@gmail.com";
		//String pw="btnrrhdfnylxybhc";
		String pw="dbcunhxvyhhoknzm";
		
		Session session = Session.getInstance(propeties, new Authenticator() {
			@Override
				protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication (envoyeurDemail , pw);
			}
		
		});
		
		Message message =  prepareMessage(session, envoyeurDemail,recepient);
			
						try {
							Transport.send(message);
						} catch (MessagingException e)  {
							
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					
						
					 
	}
	
	
	private static Message prepareMessage(Session session, String envoyeurDemail, String recepient) {
		try {
			 Message message = new MimeMessage(session);
			 message.setFrom(new InternetAddress(envoyeurDemail));
			 message.setRecipient(Message.RecipientType.TO, new InternetAddress(recepient));
			 message.setSubject("Creation de compte AMARDA 2023 ");
			 message.setText("Felicitaion votre compte a ete cree avec succes \n attendez ça validation pour vous connecter \n Merci pour votre confiance \n cordialement, \n LES ORGANISATEURS ");
			 return message;
		} catch(Exception ex) {
		   Logger.getLogger(Meeeeessage.class.getName()).log(Level.SEVERE, null, ex);	
		}
		return null;
	}
	
}
