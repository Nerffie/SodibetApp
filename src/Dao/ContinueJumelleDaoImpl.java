package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class ContinueJumelleDaoImpl implements ContinueJumelleDao {
	
	
	private DAOFactory          daoFactory;
	
	  ContinueJumelleDaoImpl( DAOFactory daoFactory ) {

	        this.daoFactory = daoFactory;

	    }
	 
	  
	  private static final String[] SQL_SELECT_PORTEE = {"SELECT charge_150 FROM continue_jumelle WHERE epaisseurX = ? AND epaisseurY= ?",
			  "SELECT charge_250 FROM continue_jumelle WHERE epaisseurX = ? AND epaisseurY= ?",
			  "SELECT charge_400 FROM continue_jumelle WHERE epaisseurX = ? AND epaisseurY= ?",
			  "SELECT charge_500 FROM continue_jumelle WHERE epaisseurX = ? AND epaisseurY= ?",
			  "SELECT charge_150T FROM continue_jumelle WHERE epaisseurX = ? AND epaisseurY= ?",
			  "SELECT charge_100T FROM continue_jumelle WHERE epaisseurX = ? AND epaisseurY= ?"};
	  
	    //@Override
	    public float calculerPortee( int epaisseurX,int epaisseurY, int numeroCharge ) throws DAOException {
	    	Connection connexion = null;
	        PreparedStatement preparedStatement = null;
	        ResultSet resultSet = null;
	        float resultat = 0; 
	        try {

	            /* R�cup�ration d'une connexion depuis la Factory */
	            connexion = daoFactory.getConnection();
	            preparedStatement = DAOUtilitaire.initialisationRequetePreparee( connexion, SQL_SELECT_PORTEE[numeroCharge], false, epaisseurX,epaisseurY );
	            resultSet = preparedStatement.executeQuery();
	            /* Parcours de la ligne de donn�es de l'�ventuel ResulSet retourn� */
	            if ( resultSet.next() ) {
	            	resultat=resultSet.getBigDecimal(1).floatValue();
	                
	            }
	        } catch ( SQLException e ) {
	            throw new DAOException( e );
	        } finally {
	            DAOUtilitaire.fermeturesSilencieuses( resultSet, preparedStatement, connexion );
	        }
	        return resultat;

	    }
}