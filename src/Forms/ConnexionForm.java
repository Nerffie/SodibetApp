package Forms;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.jasypt.util.password.ConfigurablePasswordEncryptor;

import Beans.Utilisateur;
import Dao.UtilisateurDao;

public class ConnexionForm {

	private static final String CHAMP_EMAIL  = "email";
	private static final String CHAMP_PASS  = "password";
	private static final String ALGO_CHIFFREMENT = "SHA-256";
	
	private String resultat;
	private UtilisateurDao      utilisateurDao;
	private Map<String, String> erreurs      = new HashMap<String, String>();


	public ConnexionForm( UtilisateurDao utilisateurDao ) {
	    this.utilisateurDao = utilisateurDao;
	}
	
	public String getResultat() {
	    return resultat;
	}

	public Map<String, String> getErreurs() {
	    return erreurs;
	}

	public Utilisateur connecterUtilisateur( HttpServletRequest request ) {
		
	    String email = getValeurChamp( request, CHAMP_EMAIL );
	    String motDePasse = getValeurChamp( request, CHAMP_PASS );
	    
	    Utilisateur utilisateur = new Utilisateur();
	    
	    traiterLogin(email,motDePasse,utilisateur);
	    //traiterEmail(email, utilisateur);
	    //traiterMotsDePasse(email,motDePasse, utilisateur);
	   

	    if ( erreurs.isEmpty() ) {
	    	utilisateur = utilisateurDao.trouver(email);
	        resultat = "Succès de login.";
	        
	    } else {
	        resultat = "Échec de login. ";
	    }
	    return utilisateur;
	}
	
	
	
	private void traiterLogin(String email, String motDePasse, Utilisateur utilisateur) {
		traiterEmail(email, utilisateur);//Vérification de l'existence du mail + set utilisateur son mail
		if(erreurs.isEmpty()) {// email existe
			traiterMotsDePasse(motDePasse,email,utilisateur);//Comparaison des 2 mots de passe
		}
		
			
		
	}
	private void traiterMotsDePasse(String motDePasse, String email,Utilisateur utilisateur ) {
	    try {
	        validationMotsDePasse(motDePasse,email );
	        utilisateur.setMot_de_passe(motDePasse);
	    } catch ( Exception e ) {
	        setErreur( CHAMP_PASS, e.getMessage() );
	    }
	}
	private void validationMotsDePasse( String motDePasse,String email ) throws Exception {
		ConfigurablePasswordEncryptor passwordEncryptor = new ConfigurablePasswordEncryptor();
	    passwordEncryptor.setAlgorithm( ALGO_CHIFFREMENT );
	    passwordEncryptor.setPlainDigest( false );
	    String motDePasseHash = utilisateurDao.getPass(email);
	     if(!passwordEncryptor.checkPassword(motDePasse, motDePasseHash)) {
	    	 throw new Exception("Le mot de passe n'est pas correct");
	     }
	}

	private void setErreur( String champ, String message ) {
	    erreurs.put( champ, message );
	}

	
	private void traiterEmail( String email, Utilisateur utilisateur ) {
	    try {
	    	if ( utilisateurDao.trouver( email ) == null ) {
	            throw new Exception( "Cette adresse email est introuvable." );
			}
		    utilisateur.setEmail( email );
	    }
	    catch(Exception e){
	    	setErreur( CHAMP_EMAIL, e.getMessage() );
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
