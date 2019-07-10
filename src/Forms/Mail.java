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

import Beans.Utilisateur;
import Dao.DAOConfigurationException;

public class Mail {
	//private final String username="testsodibet@gmail.com";
	//private final String password="sodibettesting";
	//private static final String PROPERTY_URL             = "url";
    //private static final String PROPERTY_DRIVER          = "driver";
    private static final String PROPERTY_NOM_UTILISATEUR = "nomutilisateur";
    private static final String PROPERTY_MOT_DE_PASSE    = "motdepasse";
    private static final String FICHIER_PROPERTIES       = "/Forms/mail.properties";
	private Utilisateur utilisateur;
	private String url;
	
	public Mail(Utilisateur utilisateur,String url) {
		this.utilisateur=utilisateur;
		this.url = url;
	}
	
	public void sendMail() {
		Properties properties = new Properties();
        
        //String driver;
        
        String nomUtilisateur;
        String motDePasse;

        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        InputStream fichierProperties = classLoader.getResourceAsStream( FICHIER_PROPERTIES );

        if ( fichierProperties == null ) {
            throw new DAOConfigurationException( "Le fichier properties " + FICHIER_PROPERTIES + " est introuvable." );
        }

        try {
            properties.load( fichierProperties );
            //url = properties.getProperty( PROPERTY_URL );
            //driver = properties.getProperty( PROPERTY_DRIVER );
            nomUtilisateur = properties.getProperty( PROPERTY_NOM_UTILISATEUR );
            motDePasse = properties.getProperty( PROPERTY_MOT_DE_PASSE );
        } catch ( IOException e ) {
            throw new DAOConfigurationException( "Impossible de charger le fichier properties " + FICHIER_PROPERTIES, e );
        }
		
		Properties props = new Properties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
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

			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress(nomUtilisateur));
			message.setRecipients(Message.RecipientType.TO,
				InternetAddress.parse(utilisateur.getEmail()));
			message.setSubject("Validation du compte Sodibet");
			message.setText("Bonjour "+utilisateur.getNom()+" "+utilisateur.getPrenom()+"\n\n"+"Merci d'avoir créer un compte chez Sodibet,"
				+ "\n\n Pour valider votre inscription, veuillez cliquer sur le lien suivant!"
					+"\n\n"+url+"/Sodibet/Verify?key="+utilisateur.getValide_hash());

			Transport.send(message);

		} catch (MessagingException e) {
			throw new RuntimeException(e);
		}
	
	}
}
