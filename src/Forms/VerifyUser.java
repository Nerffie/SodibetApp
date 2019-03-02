package Forms;

import Beans.Utilisateur;
import Dao.UtilisateurDao;

public class VerifyUser {
	private UtilisateurDao      utilisateurDao;
	private String key;
	
	public VerifyUser( UtilisateurDao utilisateurDao, String key ) {
	    this.utilisateurDao = utilisateurDao;
	    this.key = key;
	}

	// on cherche si la clé de validation existe PUIS on cherche si l'utilisateur est déjà validé ou non et donc TRUE si on peut valider l'user 
	public boolean verificationPossible() {
		Utilisateur utilisateurAValider = utilisateurDao.trouverParValideHash(key);
		if (utilisateurAValider == null){
			return false;
		}
		else {
			return !utilisateurDao.isValide(utilisateurAValider.getId());
		}
	}
	//on update la table en mettant le champ valide à 1
	public void verifierUtilisateur() {
		utilisateurDao.verifier(key);
	}
	
	//méthode generale qui rassemble les 2 précedentes True pour verification done 
	public boolean traiterVerification() {
		if (verificationPossible()) {
			verifierUtilisateur();
			return true;
		}
		return false;
	}
}
