package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


public class IsostatiqueSimpleDaoImpl implements IsostatiqueSimpleDao {
	
	
	private DAOFactory          daoFactory;
	
	  IsostatiqueSimpleDaoImpl( DAOFactory daoFactory ) {

	        this.daoFactory = daoFactory;

	    }
	 
	  
	  private static final String[] SQL_SELECT_PORTEE = {"SELECT charge_150 FROM isostatique_simple WHERE epaisseurX = ? AND epaisseurY= ?",
			  "SELECT charge_250 FROM isostatique_simple WHERE epaisseurX = ? AND epaisseurY= ?",
			  "SELECT charge_400 FROM isostatique_simple WHERE epaisseurX = ? AND epaisseurY= ?",
			  "SELECT charge_500 FROM isostatique_simple WHERE epaisseurX = ? AND epaisseurY= ?",
			  "SELECT charge_150T FROM isostatique_simple WHERE epaisseurX = ? AND epaisseurY= ?",
			  "SELECT charge_100T FROM isostatique_simple WHERE epaisseurX = ? AND epaisseurY= ?"};
	  
	    //@Override
	    public float calculerPortee( int epaisseurX,int epaisseurY, int numeroCharge ) throws DAOException {
	    	Connection connexion = null;
	        PreparedStatement preparedStatement = null;
	        ResultSet resultSet = null;
	        float resultat = 0; 
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
	    //"select epaisseurX,epaisseurY from isostatique_simple where charge_150 >= ?"
	    private static final String[] SQL_SELECT_EPAISSEUR = {"SELECT epaisseurX,epaisseurY FROM isostatique_simple WHERE charge_150 > ?",
	    		"SELECT epaisseurX,epaisseurY FROM isostatique_simple WHERE charge_250 > ?",
	    		"SELECT epaisseurX,epaisseurY FROM isostatique_simple WHERE charge_400 > ?",
	    		"SELECT epaisseurX,epaisseurY FROM isostatique_simple WHERE charge_500 > ?",
	    		"SELECT epaisseurX,epaisseurY FROM isostatique_simple WHERE charge_150T > ?",
	    		"SELECT epaisseurX,epaisseurY FROM isostatique_simple WHERE charge_100T > ?"};
	    public ArrayList<ArrayList<Integer>> calculerEpaisseur(float portee, int numeroCharge) {
	    	Connection connexion = null;
	        PreparedStatement preparedStatement = null;
	        ResultSet resultSet = null;
	        ArrayList<ArrayList<Integer>> resultat = new ArrayList<ArrayList<Integer>>(); 
	        try {

	            /* Récupération d'une connexion depuis la Factory */
	            connexion = daoFactory.getConnection();
	            preparedStatement = DAOUtilitaire.initialisationRequetePreparee( connexion, SQL_SELECT_EPAISSEUR[numeroCharge], false,portee );
	            resultSet = preparedStatement.executeQuery();
	            /* Parcours de la ligne de données de l'éventuel ResulSet retourné */
	            while ( resultSet.next() ) {
	            	ArrayList<Integer> row = new ArrayList<Integer>();
	            	row.add(resultSet.getInt(1));
	            	row.add(resultSet.getInt(2));
	            	resultat.add(row);
	            }
	        } catch ( SQLException e ) {
	            throw new DAOException( e );
	        } finally {
	            DAOUtilitaire.fermeturesSilencieuses( resultSet, preparedStatement, connexion );
	        }
	        return resultat;
	    }
}