package Dao;

import java.util.ArrayList;

import Beans.Utilisateur;

public interface UtilisateurDao {
	void creer( Utilisateur utilisateur ) throws DAOException;

    Utilisateur trouver( String email ) throws DAOException;
    Utilisateur trouverParValideHash(String key) throws DAOException;
    boolean isValide(Long id) throws DAOException;
    void verifier(String key) throws DAOException;
    String getPass(String email) throws DAOException;
    void nePlusAfficher1(String email) throws DAOException;
    void nePlusAfficher2(String email) throws DAOException;
    void nePlusAfficher3(String email) throws DAOException;
    void nePlusAfficher4(String email) throws DAOException;
    ArrayList<Utilisateur> getUsers() throws DAOException;
}
