package Forms;

import Beans.Utilisateur;
import Dao.UtilisateurDao;

public class DontShow {

	
	private UtilisateurDao      utilisateurDao;
	private int numeroPortee;
	private Utilisateur utilisateur;
	
	public DontShow(UtilisateurDao utilisateurDao,int numeroPortee,Utilisateur utilisateur) {
		this.utilisateurDao=utilisateurDao;
		this.numeroPortee=numeroPortee;
		this.utilisateur=utilisateur;
	}


	public void nePlusAfficher() {
		if (numeroPortee ==1) {
			utilisateurDao.nePlusAfficher1(utilisateur.getEmail());
			utilisateur.setPortee_1(1);
		}
		else if (numeroPortee ==2) {
			utilisateurDao.nePlusAfficher2(utilisateur.getEmail());
			utilisateur.setPortee_2(1);
		}
		else if (numeroPortee ==3) {
			utilisateurDao.nePlusAfficher3(utilisateur.getEmail());
			utilisateur.setPortee_3(1);
		}
		else if (numeroPortee ==4) {
			utilisateurDao.nePlusAfficher4(utilisateur.getEmail());
			utilisateur.setPortee_4(1);
		}
	}

}
