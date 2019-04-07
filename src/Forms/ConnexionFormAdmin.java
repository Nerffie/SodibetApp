package Forms;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.jasypt.util.password.ConfigurablePasswordEncryptor;

import Beans.Admin;
import Dao.AdminDao;

public class ConnexionFormAdmin {

	private static final String CHAMP_ID  = "id";
	private static final String CHAMP_PASS  = "password";
	private static final String ALGO_CHIFFREMENT = "SHA-256";
	
	private String resultat;
	private AdminDao      adminDao;
	private Map<String, String> erreurs      = new HashMap<String, String>();


	public ConnexionFormAdmin( AdminDao adminDao ) {
	    this.adminDao = adminDao;
	}
	
	public String getResultat() {
	    return resultat;
	}

	public Map<String, String> getErreurs() {
	    return erreurs;
	}

	public Admin connecterAdmin( HttpServletRequest request ) {
		
	    String id = getValeurChamp( request, CHAMP_ID );
	    String motDePasse = getValeurChamp( request, CHAMP_PASS );
	    
	    Admin admin = new Admin();
	    
	    traiterLogin(id,motDePasse,admin);
	   

	    if ( erreurs.isEmpty() ) {
	    	admin = adminDao.trouver(id);
	        resultat = "Succès de login.";
	    } else {
	    	System.out.println(erreurs.values());
	        resultat = "Échec de login. ";
	    }
	    return admin;
	}
	
	
	
	private void traiterLogin(String id, String motDePasse, Admin admin) {
		traiterId(id, admin);//Vérification de l'existence du mail + set admin son mail
		if(erreurs.isEmpty()) {// id existe
			//System.out.println("id existe");
			traiterMotsDePasse(motDePasse,id,admin);//Comparaison des 2 mots de passe
		}
//		System.out.println("i skipped the part");
//		System.out.println(erreurs.get(CHAMP_ID));
//		System.out.println(erreurs.size());
//		System.out.println(erreurs.values());
			
		
	}
	private void traiterMotsDePasse(String motDePasse, String id,Admin admin ) {
	    try {
	        validationMotsDePasse(motDePasse,id );
	        admin.setMot_de_passe(motDePasse);
	    } catch ( Exception e ) {
	        setErreur( CHAMP_PASS, e.getMessage() );
	    }
	}
	private void validationMotsDePasse( String motDePasse,String id ) throws Exception {
		ConfigurablePasswordEncryptor passwordEncryptor = new ConfigurablePasswordEncryptor();
	    passwordEncryptor.setAlgorithm( ALGO_CHIFFREMENT );
	    passwordEncryptor.setPlainDigest( false );
	    String motDePasseHash = adminDao.getPass(id);
	     if(!passwordEncryptor.checkPassword(motDePasse, motDePasseHash)) {
	    	 throw new Exception("Les informations de connexion sont incorrects");
	     }
	}

	private void setErreur( String champ, String message ) {
	    erreurs.put( champ, message );
	}

	
	private void traiterId( String id, Admin admin ) {
	    try {
	    	if ( adminDao.trouver( id ) == null ) {
	            throw new Exception( "Les informations de connexion sont incorrects" );
			}
		    admin.setId( id );
	    }
	    catch(Exception e){
	    	setErreur( CHAMP_ID, e.getMessage() );
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
