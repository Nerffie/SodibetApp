package Forms;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;

import Beans.Utilisateur;
import Dao.DAOConfigurationException;

public class Question {
    private static final String PROPERTY_NOM_UTILISATEUR = "nomutilisateur";
    private static final String PROPERTY_MOT_DE_PASSE    = "motdepasse";
    private static final String PROPERTY_EMAIL_1    = "email1";
    private static final String PROPERTY_EMAIL_2    = "email2";
    private static final String FICHIER_PROPERTIES       = "/Forms/question.properties";
    private static final String CHAMP_SUBJECT = "sujet";
    private static final String CHAMP_BODY = "message";
	private Utilisateur utilisateur;
	//private String subject;
	//private String body;
	
	public Question(Utilisateur utilisateur) {
		this.utilisateur=utilisateur;
	}
	
	public void sendMail(HttpServletRequest req) {
		Properties properties = new Properties();
		
        String nomUtilisateur;
        String motDePasse;
        String email1;
        String email2;
        
        String sujet = getValeurChamp(req, CHAMP_SUBJECT);
        String message = getValeurChamp(req,CHAMP_BODY);
        
        
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        InputStream fichierProperties = classLoader.getResourceAsStream( FICHIER_PROPERTIES );

        if ( fichierProperties == null ) {
            throw new DAOConfigurationException( "Le fichier properties " + FICHIER_PROPERTIES + " est introuvable." );
        }

        try {
            properties.load( fichierProperties );
            nomUtilisateur = properties.getProperty( PROPERTY_NOM_UTILISATEUR );
            motDePasse = properties.getProperty( PROPERTY_MOT_DE_PASSE );
            email1 = properties.getProperty(PROPERTY_EMAIL_1);
            email2 = properties.getProperty(PROPERTY_EMAIL_2);
        } catch ( IOException e ) {
            throw new DAOConfigurationException( "Impossible de charger le fichier properties " + FICHIER_PROPERTIES, e );
        }
		
		Properties props = new Properties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.ssl.trust", "smtp.gmail.com");
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.port", "587");
		
		Session session = Session.getInstance(props,
				  new javax.mail.Authenticator() {
					protected PasswordAuthentication getPasswordAuthentication() {
						return new PasswordAuthentication(nomUtilisateur
								, motDePasse);
					}
				  });
	
		try {

			Message message1 = new MimeMessage(session);
			message1.setFrom(new InternetAddress(nomUtilisateur));
			message1.setRecipients(Message.RecipientType.TO,
				InternetAddress.parse(email1));
			message1.setSubject("Question : "+sujet);
			message1.setText("De : "+utilisateur.getNom()+" "+utilisateur.getPrenom()+
			"\nEmail : "+utilisateur.getEmail()+
			"\n\n\n"+message);
			
			
			Message message2 = new MimeMessage(session);
			message2.setFrom(new InternetAddress(nomUtilisateur));
			message2.setRecipients(Message.RecipientType.TO,
				InternetAddress.parse(email2));
			message2.setSubject("Question : "+sujet);
			message2.setText("De : "+utilisateur.getNom()+" "+utilisateur.getPrenom()+
			"\nEmail : "+utilisateur.getEmail()+
			"\n\n\n"+message);

			
			
			Transport.send(message1);
			Transport.send(message2);

		} catch (MessagingException e) {
			throw new RuntimeException(e);
		}
	
	}
	private static String getValeurChamp( HttpServletRequest request, String nomChamp ) {
	    String valeur = request.getParameter( nomChamp );
	    if ( valeur == null || valeur.trim().length() == 0 ) {
	        return null;
	    } else {
	        return valeur.trim();
	    }
	}
	
}
