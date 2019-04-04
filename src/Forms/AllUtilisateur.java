package Forms;

import java.util.ArrayList;

import Beans.Utilisateur;
import Dao.UtilisateurDao;

public class AllUtilisateur {
	
	UtilisateurDao utilisateurDao;

	public AllUtilisateur(UtilisateurDao utilisateurDao) {
		// TODO Auto-generated constructor stub
		this.utilisateurDao=utilisateurDao;
	}

	public ArrayList<Utilisateur> getUsers() {
		// TODO Auto-generated method stub
		return utilisateurDao.getUsers();
	}

}
