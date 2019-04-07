package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Dao.DAOUtilitaire;
import Beans.Utilisateur;

public class UtilisateurDaoImpl implements UtilisateurDao {
	
	private DAOFactory          daoFactory;
	

    UtilisateurDaoImpl( DAOFactory daoFactory ) {

        this.daoFactory = daoFactory;

    }
	
    
	/* Implémentation de la méthode trouver() définie dans l'interface UtilisateurDao */
    private static final String SQL_SELECT_PAR_EMAIL = "SELECT * FROM Utilisateur WHERE email = ?";
    @Override
    public Utilisateur trouver( String email ) throws DAOException {
    	Connection connexion = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        Utilisateur utilisateur = null;
        try {

            /* Récupération d'une connexion depuis la Factory */
            connexion = daoFactory.getConnection();
            preparedStatement = DAOUtilitaire.initialisationRequetePreparee( connexion, SQL_SELECT_PAR_EMAIL, false, email );
            resultSet = preparedStatement.executeQuery();
            /* Parcours de la ligne de données de l'éventuel ResulSet retourné */
            if ( resultSet.next() ) {
                utilisateur = map( resultSet );
            }
        } catch ( SQLException e ) {
            throw new DAOException( e );
        } finally {
            DAOUtilitaire.fermeturesSilencieuses( resultSet, preparedStatement, connexion );
        }
        return utilisateur;

    }

    /* Implémentation de la méthode creer() définie dans l'interface UtilisateurDao */
    private static final String SQL_INSERT = "INSERT INTO Utilisateur (prenom, nom, date_naissance,email,ville,mot_de_passe,categorie,sous_categorie,date_inscription,valide_hash) VALUES (?, ?, ?, ?,?,?,?,?,NOW(),?)";
    @Override
    public void creer( Utilisateur utilisateur ) throws IllegalArgumentException, DAOException {
  
    	Connection connexion = null;
        PreparedStatement preparedStatement = null;
        ResultSet valeursAutoGenerees = null;

        try {

            /* Récupération d'une connexion depuis la Factory */

            connexion = daoFactory.getConnection();
            preparedStatement = DAOUtilitaire.initialisationRequetePreparee( connexion, SQL_INSERT, true, utilisateur.getPrenom(), utilisateur.getNom(), utilisateur.getDate_naissance(),utilisateur.getEmail(),utilisateur.getVille(),utilisateur.getMot_de_passe(),utilisateur.getCategorie(),utilisateur.getSous_categorie(),utilisateur.getValide_hash() );
            int statut = preparedStatement.executeUpdate();

            /* Analyse du statut retourné par la requête d'insertion */
            if ( statut == 0 ) {
                throw new DAOException( "Échec de la création de l'utilisateur, aucune ligne ajoutée dans la table." );
            }

            /* Récupération de l'id auto-généré par la requête d'insertion */
            valeursAutoGenerees = preparedStatement.getGeneratedKeys();
            if ( valeursAutoGenerees.next() ) {
                /* Puis initialisation de la propriété id du bean Utilisateur avec sa valeur */
                utilisateur.setId( valeursAutoGenerees.getLong( 1 ) );
            } else {
                throw new DAOException( "Échec de la création de l'utilisateur en base, aucun ID auto-généré retourné." );
            }
        } catch ( SQLException e ) {
            throw new DAOException( e );
        } finally {
            DAOUtilitaire.fermeturesSilencieuses( valeursAutoGenerees, preparedStatement, connexion );
        }

    }
    
    private static Utilisateur map( ResultSet resultSet ) throws SQLException {

        Utilisateur utilisateur = new Utilisateur();

        utilisateur.setId( resultSet.getLong( "id_utilisateur" ) );
        utilisateur.setPrenom(resultSet.getString("prenom"));
        utilisateur.setNom( resultSet.getString( "nom" ) );
        utilisateur.setDate_naissance(resultSet.getDate("date_naissance"));
        utilisateur.setEmail( resultSet.getString( "email" ) );
        utilisateur.setVille(resultSet.getString("ville"));
        utilisateur.setMot_de_passe( resultSet.getString( "mot_de_passe" ) );
        utilisateur.setCategorie(resultSet.getString("categorie"));
        utilisateur.setSous_categorie(resultSet.getString("sous_categorie"));
        utilisateur.setValide(resultSet.getInt("valide"));
        utilisateur.setPortee_1(resultSet.getInt("portee_1"));
        utilisateur.setPortee_2(resultSet.getInt("portee_2"));
        utilisateur.setPortee_3(resultSet.getInt("portee_3"));
        utilisateur.setPortee_4(resultSet.getInt("portee_4"));
        utilisateur.setDate_inscription( resultSet.getDate("date_inscription"));
        utilisateur.setValide_hash(resultSet.getString("valide_hash"));
        utilisateur.setDate_connexion(resultSet.getDate("date_connexion"));

        return utilisateur;

    }
    
    // Retourne l'utilisateur qui correspond à la clé de validation passé en parametre
    private static final String SQL_SELECT_PAR_VALIDE_HASH = "SELECT * FROM Utilisateur WHERE valide_hash = ?";
    public Utilisateur trouverParValideHash(String key) throws DAOException{
    	Connection connexion = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        Utilisateur utilisateur = null;
        try {

            /* Récupération d'une connexion depuis la Factory */
            connexion = daoFactory.getConnection();
            preparedStatement = DAOUtilitaire.initialisationRequetePreparee( connexion, SQL_SELECT_PAR_VALIDE_HASH, false, key );
            resultSet = preparedStatement.executeQuery();
            /* Parcours de la ligne de données de l'éventuel ResulSet retourné */
            if ( resultSet.next() ) {
                utilisateur = map( resultSet );
            }
        } catch ( SQLException e ) {
            throw new DAOException( e );
        } finally {
            DAOUtilitaire.fermeturesSilencieuses( resultSet, preparedStatement, connexion );
        }
        return utilisateur;
    }
    
    // Retourne Vrai si l'utilisateur est valide, faux sinon
    private static final String SQL_SELECT_PAR_ID = "SELECT * FROM Utilisateur WHERE id_utilisateur = ?";
    public boolean isValide(Long id) throws DAOException{
    	Connection connexion = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        Utilisateur utilisateur = null;
        try {

            /* Récupération d'une connexion depuis la Factory */
            connexion = daoFactory.getConnection();
            preparedStatement = DAOUtilitaire.initialisationRequetePreparee( connexion, SQL_SELECT_PAR_ID, false, id );
            resultSet = preparedStatement.executeQuery();
            /* Parcours de la ligne de données de l'éventuel ResulSet retourné */
            if ( resultSet.next() ) {
                utilisateur = map( resultSet );
                if (utilisateur.getValide()==1) {
                	return true;
                }
                else {
                	return false;
                }
            }
        } catch ( SQLException e ) {
            throw new DAOException( e );
        } finally {
            DAOUtilitaire.fermeturesSilencieuses( resultSet, preparedStatement, connexion );
        }
        return false;
    }
    
    private static final String SQL_UPDATE_VERIFY = "UPDATE utilisateur SET valide = 1 WHERE valide_hash = ?";
    public void verifier(String key) {
    	
    	Connection connexion = null;
        PreparedStatement preparedStatement = null;
        ResultSet valeursAutoGenerees = null;

        try {

            /* Récupération d'une connexion depuis la Factory */

            connexion = daoFactory.getConnection();
            preparedStatement = DAOUtilitaire.initialisationRequetePreparee( connexion, SQL_UPDATE_VERIFY, false, key);
            int statut = preparedStatement.executeUpdate();

            /* Analyse du statut retourné par la requête d'insertion */
            if ( statut == 0 ) {
                throw new DAOException( "Échec de la vérification de l'utilisateur dans la DB, aucune ligne mise à jour dans la table." );
            }
        } catch ( SQLException e ) {
            throw new DAOException( e );
        } finally {
            DAOUtilitaire.fermeturesSilencieuses( valeursAutoGenerees, preparedStatement, connexion );
        }
    }
    
    
    //Retourne le MDP hashé correspondant à l'email
    private static final String SQL_SELECT_PASS = "SELECT mot_de_passe FROM utilisateur WHERE email = ?";
    public String getPass(String email) {
    	Connection connexion = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        String motDePasseHash = null;
        try {

            /* Récupération d'une connexion depuis la Factory */
            connexion = daoFactory.getConnection();
            preparedStatement = DAOUtilitaire.initialisationRequetePreparee( connexion, SQL_SELECT_PASS, false, email );
            resultSet = preparedStatement.executeQuery();
            /* Parcours de la ligne de données de l'éventuel ResulSet retourné */
            if ( resultSet.next() ) {
                motDePasseHash = resultSet.getString("mot_de_passe");
            }
        } catch ( SQLException e ) {
            throw new DAOException( e );
        } finally {
            DAOUtilitaire.fermeturesSilencieuses( resultSet, preparedStatement, connexion );
        }
        return motDePasseHash;
    }
    
    private static final String SQL_UPDATE_PORTEE_1 = "UPDATE utilisateur SET portee_1 = 1 WHERE email = ?";
    public void nePlusAfficher1(String email) {
    	Connection connexion = null;
        PreparedStatement preparedStatement = null;
        ResultSet valeursAutoGenerees = null;

        try {
        	connexion = daoFactory.getConnection();
            preparedStatement = DAOUtilitaire.initialisationRequetePreparee( connexion, SQL_UPDATE_PORTEE_1, false, email);
            int statut = preparedStatement.executeUpdate();

            /* Analyse du statut retourné par la requête d'insertion */
            if ( statut == 0 ) {
                throw new DAOException( "Échec de la mise à jour de ne plus afficher portee 1 en base de donnée." );
            }
        } catch ( SQLException e ) {
            throw new DAOException( e );
        } finally {
            DAOUtilitaire.fermeturesSilencieuses( valeursAutoGenerees, preparedStatement, connexion );
        }
    }
    
    
    
    private static final String SQL_UPDATE_PORTEE_2 = "UPDATE utilisateur SET portee_2 = 1 WHERE email = ?";
    public void nePlusAfficher2(String email) {
    	Connection connexion = null;
        PreparedStatement preparedStatement = null;
        ResultSet valeursAutoGenerees = null;

        try {
        	connexion = daoFactory.getConnection();
            preparedStatement = DAOUtilitaire.initialisationRequetePreparee( connexion, SQL_UPDATE_PORTEE_2, false, email);
            int statut = preparedStatement.executeUpdate();

            /* Analyse du statut retourné par la requête d'insertion */
            if ( statut == 0 ) {
                throw new DAOException( "Échec de la mise à jour de ne plus afficher portee 2 en base de donnée." );
            }
        } catch ( SQLException e ) {
            throw new DAOException( e );
        } finally {
            DAOUtilitaire.fermeturesSilencieuses( valeursAutoGenerees, preparedStatement, connexion );
        }
    }

    
    private static final String SQL_UPDATE_PORTEE_3 = "UPDATE utilisateur SET portee_3 = 1 WHERE email = ?";
    public void nePlusAfficher3(String email) {
    	Connection connexion = null;
        PreparedStatement preparedStatement = null;
        ResultSet valeursAutoGenerees = null;

        try {
        	connexion = daoFactory.getConnection();
            preparedStatement = DAOUtilitaire.initialisationRequetePreparee( connexion, SQL_UPDATE_PORTEE_3, false, email);
            int statut = preparedStatement.executeUpdate();

            /* Analyse du statut retourné par la requête d'insertion */
            if ( statut == 0 ) {
                throw new DAOException( "Échec de la mise à jour de ne plus afficher portee 3 en base de donnée." );
            }
        } catch ( SQLException e ) {
            throw new DAOException( e );
        } finally {
            DAOUtilitaire.fermeturesSilencieuses( valeursAutoGenerees, preparedStatement, connexion );
        }
    }
    
    private static final String SQL_UPDATE_PORTEE_4 = "UPDATE utilisateur SET portee_4 = 1 WHERE email = ?";
    public void nePlusAfficher4(String email) {
    	Connection connexion = null;
        PreparedStatement preparedStatement = null;
        ResultSet valeursAutoGenerees = null;

        try {
        	connexion = daoFactory.getConnection();
            preparedStatement = DAOUtilitaire.initialisationRequetePreparee( connexion, SQL_UPDATE_PORTEE_4, false, email);
            int statut = preparedStatement.executeUpdate();

            /* Analyse du statut retourné par la requête d'insertion */
            if ( statut == 0 ) {
                throw new DAOException( "Échec de la mise à jour de ne plus afficher portee 4 en base de donnée." );
            }
        } catch ( SQLException e ) {
            throw new DAOException( e );
        } finally {
            DAOUtilitaire.fermeturesSilencieuses( valeursAutoGenerees, preparedStatement, connexion );
        }
    }

    private static final String SQL_SELECT_ALL = "SELECT * FROM utilisateur";
	@Override
	public ArrayList<Utilisateur> getUsers() throws DAOException {
		// TODO Auto-generated method stub
		
		Connection connexion = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        ArrayList<Utilisateur> resultat = new ArrayList<Utilisateur>();
        Utilisateur user;

        try {
        	connexion = daoFactory.getConnection();
            preparedStatement = DAOUtilitaire.initialisationRequetePreparee( connexion, SQL_SELECT_ALL, false);
            resultSet = preparedStatement.executeQuery();

            /* Analyse du statut retourné par la requête d'insertion */
            while( resultSet.next() ) {
                user = map(resultSet);
                resultat.add(user);
            }
        } catch ( SQLException e ) {
            throw new DAOException( e );
        } finally {
            DAOUtilitaire.fermeturesSilencieuses( resultSet, preparedStatement, connexion );
        }
		
		return resultat;
	}

	
	
	

	
    private static final String SQL_UPDATE_LAST_CONNEXION = "UPDATE utilisateur SET date_connexion = NOW() WHERE email = ?";
	@Override
	public void updateLastConnexion(String email) throws DAOException {
		// TODO Auto-generated method stub
		Connection connexion = null;
        PreparedStatement preparedStatement = null;
        ResultSet valeursAutoGenerees = null;

        try {

            /* Récupération d'une connexion depuis la Factory */

            connexion = daoFactory.getConnection();
            preparedStatement = DAOUtilitaire.initialisationRequetePreparee( connexion, SQL_UPDATE_LAST_CONNEXION, false, email);
            int statut = preparedStatement.executeUpdate();

            /* Analyse du statut retourné par la requête d'insertion */
            if ( statut == 0 ) {
                throw new DAOException( "Échec de la mise à jour de la derniere connexion dans la base de données" );
            }
        } catch ( SQLException e ) {
            throw new DAOException( e );
        } finally {
            DAOUtilitaire.fermeturesSilencieuses( valeursAutoGenerees, preparedStatement, connexion );
        }
	}
}
