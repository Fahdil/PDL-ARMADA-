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

public class MeeeeessageRefusInscrip2 {
	
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
			 message.setSubject("Evolution de votre compte AMARDA 2023 ");
			 message.setText(" Apres etude de votre incription, cette derniere a ete valider \n vous pouvez donc vous connectez \n Merci pour votre confiance \n cordialement, \n LES ORGANISATEURS ");
			 return message;
		} catch(Exception ex) {
		   Logger.getLogger(MeeeeessageRefusInscrip2.class.getName()).log(Level.SEVERE, null, ex);	
		}
		return null;
	}
	
}
