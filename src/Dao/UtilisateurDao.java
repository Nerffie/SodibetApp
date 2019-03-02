package Dao;

import Beans.Utilisateur;

public interface UtilisateurDao {
	void creer( Utilisateur utilisateur ) throws DAOException;

    Utilisateur trouver( String email ) throws DAOException;
    Utilisateur trouverParValideHash(String key) throws DAOException;
    boolean isValide(Long id) throws DAOException;
    void verifier(String key) throws DAOException;
    String getPass(String email) throws DAOException;
}
