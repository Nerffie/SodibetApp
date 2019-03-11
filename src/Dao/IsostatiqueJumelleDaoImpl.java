package Dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class IsostatiqueJumelleDaoImpl implements IsostatiqueJumelleDao {
	
	
	private DAOFactory          daoFactory;
	
	  IsostatiqueJumelleDaoImpl( DAOFactory daoFactory ) {

	        this.daoFactory = daoFactory;

	    }
	 
	  
	  private static final String[] SQL_SELECT_PORTEE = {"SELECT charge_150 FROM isostatique_jumelle WHERE epaisseurX = ? AND epaisseurY= ?",
			  "SELECT charge_250 FROM isostatique_jumelle WHERE epaisseurX = ? AND epaisseurY= ?",
			  "SELECT charge_400 FROM isostatique_jumelle WHERE epaisseurX = ? AND epaisseurY= ?",
			  "SELECT charge_500 FROM isostatique_jumelle WHERE epaisseurX = ? AND epaisseurY= ?",
			  "SELECT charge_150T FROM isostatique_jumelle WHERE epaisseurX = ? AND epaisseurY= ?",
			  "SELECT charge_100T FROM isostatique_jumelle WHERE epaisseurX = ? AND epaisseurY= ?"};
	  
	    //@Override
	    public float calculerPortee( int epaisseurX,int epaisseurY, int numeroCharge ) throws DAOException {
	    	Connection connexion = null;
	        PreparedStatement preparedStatement = null;
	        ResultSet resultSet = null;
	        float resultat=123; 
	        try {

	            /* Récupération d'une connexion depuis la Factory */
	            connexion = daoFactory.getConnection();
	            preparedStatement = DAOUtilitaire.initialisationRequetePreparee( connexion, SQL_SELECT_PORTEE[numeroCharge], false, epaisseurX,epaisseurY );
	            resultSet = preparedStatement.executeQuery();
	            /* Parcours de la ligne de données de l'éventuel ResulSet retourné */
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