package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LitrageDaoImpl implements LitrageDao {
	
private DAOFactory          daoFactory;
	

    LitrageDaoImpl( DAOFactory daoFactory ) {

        this.daoFactory = daoFactory;

    }
    private static final String SQL_SELECT_CONSOMMATION = "SELECT consommation FROM litrage WHERE epaisseurX = ? and epaisseurY = ?";
	@Override
	public float chercherConsommation(int epaisseurX, int epaisseurY) {
		// TODO Auto-generated method stub
		Connection connexion = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        float resultat = 0; 
        try {

            /* Récupération d'une connexion depuis la Factory */
            connexion = daoFactory.getConnection();
            preparedStatement = DAOUtilitaire.initialisationRequetePreparee( connexion, SQL_SELECT_CONSOMMATION, false, epaisseurX,epaisseurY );
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
