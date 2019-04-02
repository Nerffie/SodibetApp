package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import Dao.DAOUtilitaire;
import Beans.Admin;


public class AdminDaoImpl implements AdminDao {
	
	private DAOFactory          daoFactory;
	

    AdminDaoImpl( DAOFactory daoFactory ) {

        this.daoFactory = daoFactory;

    }



    private static final String SQL_SELECT_PAR_EMAIL = "SELECT * FROM admin WHERE id = ?";
    @Override
    public Admin trouver( String id ) throws DAOException {
    	Connection connexion = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        Admin admin = new Admin();
        try {

            /* Récupération d'une connexion depuis la Factory */
            connexion = daoFactory.getConnection();
            preparedStatement = DAOUtilitaire.initialisationRequetePreparee( connexion, SQL_SELECT_PAR_EMAIL, false,id );
            resultSet = preparedStatement.executeQuery();
            /* Parcours de la ligne de données de l'éventuel ResulSet retourné */
            if ( resultSet.next() ) {
                admin.setId(resultSet.getString("id"));
                admin.setMot_de_passe(resultSet.getString("password"));
                admin.setNom(resultSet.getString("name"));
            }
        } catch ( SQLException e ) {
            throw new DAOException( e );
        } finally {
            DAOUtilitaire.fermeturesSilencieuses( resultSet, preparedStatement, connexion );
        }
        return admin;

    }
    //Retourne le MDP hashé correspondant à l'email
    private static final String SQL_SELECT_PASS = "SELECT password FROM admin WHERE id = ?";
    public String getPass(String id) {
    	Connection connexion = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        String motDePasseHash = null;
        try {

            /* Récupération d'une connexion depuis la Factory */
            connexion = daoFactory.getConnection();
            preparedStatement = DAOUtilitaire.initialisationRequetePreparee( connexion, SQL_SELECT_PASS, false,id );
            resultSet = preparedStatement.executeQuery();
            /* Parcours de la ligne de données de l'éventuel ResulSet retourné */
            if ( resultSet.next() ) {
                motDePasseHash = resultSet.getString("password");
            }
        } catch ( SQLException e ) {
            throw new DAOException( e );
        } finally {
            DAOUtilitaire.fermeturesSilencieuses( resultSet, preparedStatement, connexion );
        }
        return motDePasseHash;
    }
    
}
