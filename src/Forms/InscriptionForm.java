package Forms;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import org.jasypt.util.password.ConfigurablePasswordEncryptor;

import Beans.Utilisateur;
import Dao.UtilisateurDao;

public class InscriptionForm {

	
	private static final String CHAMP_NOM  = "nom";
	private static final String CHAMP_PRENOM  = "prenom";
	private static final String CHAMP_EMAIL  = "email";
	private static final String CHAMP_VILLE  = "ville";
	private static final String CHAMP_PASS  = "password";
	private static final String CHAMP_PASS_CONF  = "password_confirmation";
	private static final String CHAMP_CATEGORIE  = "categorie";
	private static final String[] CHAMP_SOUS_CATEGORIE  = {"sous_categorie_architecte","sous_categorie_ingenieur"};
	private static final String CHAMP_DATE_NAISSANCE  = "date_naissance";
	private static final String ALGO_CHIFFREMENT = "SHA-256";
	
	private String resultat;
	private UtilisateurDao      utilisateurDao;
	private Map<String, String> erreurs      = new HashMap<String, String>();


	public InscriptionForm( UtilisateurDao utilisateurDao ) {
	    this.utilisateurDao = utilisateurDao;
	}
	
	public String getResultat() {
	    return resultat;
	}

	public Map<String, String> getErreurs() {
	    return erreurs;
	}

	public Utilisateur inscrireUtilisateur( HttpServletRequest request ) {
		
		String nom = getValeurChamp(request, CHAMP_NOM );
		String prenom = getValeurChamp(request,CHAMP_PRENOM );
	    String email = getValeurChamp( request, CHAMP_EMAIL );
	    String ville = getValeurChamp(request, CHAMP_VILLE);
	    String motDePasse = getValeurChamp( request, CHAMP_PASS );
	    String confirmation = getValeurChamp( request, CHAMP_PASS_CONF );
	    String categorie = getValeurChamp(request, CHAMP_CATEGORIE);
	    String sous_categorie = getSousCategorie(request,categorie);
	    String birthday = getValeurChamp(request,CHAMP_DATE_NAISSANCE);
	    java.util.Date date;
	    Date date_naissance =null;
	    try {
	    	date = new SimpleDateFormat("yyyy-MM-dd").parse(birthday);
			date_naissance = new java.sql.Date(date.getTime());
		} catch (ParseException e1) {
			System.out.println("ERREUR LORS DE LA TRANSFORMATION DE LA DATE");
			e1.printStackTrace();
		}
	    
	    Utilisateur utilisateur = new Utilisateur();
	    
	    //utilisateur.setMot_de_passe( motDePasse );
	    traiterMotsDePasse(motDePasse, confirmation, utilisateur);
	    traiterEmail(email, utilisateur);
	    utilisateur.setCategorie(categorie);
	    utilisateur.setSous_categorie(sous_categorie);
	    utilisateur.setDate_naissance(date_naissance);
	    utilisateur.setNom( nom );
	    utilisateur.setPrenom(prenom);
	    utilisateur.setVille(ville);
	    //utilisateur.setValide_hash("Random Key hash");
	    traiterValideHash(email, nom, prenom, utilisateur);
	    //utilisateur.setEmail( email );

	    if ( erreurs.isEmpty() ) {
	    	utilisateurDao.creer(utilisateur);
	        resultat = "Succès de l'inscription.";
	        //send mail
	        new Mail(utilisateur).sendMail();
	    } else {
	        resultat = "Échec de l'inscription.";
	    }
	    return utilisateur;

	}
	
	
	private String getSousCategorie(HttpServletRequest request, String categorie) {
		switch (categorie) {
		case "architecte" : return getValeurChamp(request, CHAMP_SOUS_CATEGORIE[0]);
		case "ingenieur" : return getValeurChamp(request, CHAMP_SOUS_CATEGORIE[1]);
		}
		return null;
	}

	private void traiterValideHash (String email,String nom,String prenom,Utilisateur utilisateur) {
		ConfigurablePasswordEncryptor passwordEncryptor = new ConfigurablePasswordEncryptor();
	    passwordEncryptor.setAlgorithm( ALGO_CHIFFREMENT );
	    passwordEncryptor.setPlainDigest( false );
	    String valide_hash = passwordEncryptor.encryptPassword(email+nom+prenom );
	    utilisateur.setValide_hash(valide_hash);
	}
	
	private void traiterMotsDePasse( String motDePasse, String confirmation, Utilisateur utilisateur ) {
	    try {
	        validationMotsDePasse( motDePasse, confirmation );
	    } catch ( Exception e ) {
	        setErreur( CHAMP_PASS, e.getMessage() );
	        setErreur( CHAMP_PASS_CONF, null );
	    }
	    /*
	     * Utilisation de la bibliothèque Jasypt pour chiffrer le mot de passe efficacement.
	     * L'algorithme SHA-256 est ici utilisé, avec par défaut un salage aléatoire et un grand nombre d'itérations de la fonction de hashage.
	     * La String retournée est de longueur 56 et contient le hash en Base64.
	     */
	    ConfigurablePasswordEncryptor passwordEncryptor = new ConfigurablePasswordEncryptor();
	    passwordEncryptor.setAlgorithm( ALGO_CHIFFREMENT );
	    passwordEncryptor.setPlainDigest( false );
	    String motDePasseChiffre = passwordEncryptor.encryptPassword( motDePasse );
	    utilisateur.setMot_de_passe( motDePasseChiffre );

	}
	private void validationMotsDePasse( String motDePasse, String confirmation ) throws Exception {
	    if ( motDePasse != null && confirmation != null ) {
	        if ( !motDePasse.equals( confirmation ) ) {
	            throw new Exception( "Les mots de passe entrés sont différents, merci de les saisir à nouveau." );
	        } else if ( motDePasse.length() < 3 ) {
	            throw new Exception( "Les mots de passe doivent contenir au moins 3 caractères." );
	        }
	    } else {
	        throw new Exception( "Merci de saisir et confirmer votre mot de passe." );
	    }
	}

	private void setErreur( String champ, String message ) {
	    erreurs.put( champ, message );
	}

	
	private void traiterEmail( String email, Utilisateur utilisateur ) {
	    try {
	    	if ( utilisateurDao.trouver( email ) != null ) {
	            throw new Exception( "Cette adresse email est déjà utilisée, merci d'en choisir une autre." );
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
