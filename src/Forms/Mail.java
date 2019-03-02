package Forms;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import Beans.Utilisateur;

public class Mail {
	private final String username="testsodibet@gmail.com";
	private final String password="sodibettesting";
	private Utilisateur utilisateur;
	
	public Mail(Utilisateur utilisateur) {
		this.utilisateur=utilisateur;
	}
	
	public void sendMail() {
		Properties props = new Properties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.port", "587");
		
		Session session = Session.getInstance(props,
				  new javax.mail.Authenticator() {
					protected PasswordAuthentication getPasswordAuthentication() {
						return new PasswordAuthentication(username, password);
					}
				  });
	
		try {

			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress("sodibettest@gmail.com"));
			message.setRecipients(Message.RecipientType.TO,
				InternetAddress.parse(utilisateur.getEmail()));
			message.setSubject("Validation du compte Sodibet");
			message.setText("Bonjour "+utilisateur.getNom()+" "+utilisateur.getPrenom()+"\n\n"+"Merci d'avoir créer un compte chez Sodibet,"
				+ "\n\n Pour vérifier votre compte, veuillez cliquez sur le lien suivant!"
					+"\n\n"+"http://localhost:8080/Sodibet/Verify?key="+utilisateur.getValide_hash());

			Transport.send(message);

			System.out.println("Done");

		} catch (MessagingException e) {
			throw new RuntimeException(e);
		}
	
	}
}
