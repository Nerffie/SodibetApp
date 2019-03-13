package Dao;

import java.util.ArrayList;

public interface ContinueSimpleDao {
	public float calculerPortee( int epaisseurX,int epaisseurY, int numeroCharge ) throws DAOException;
	public ArrayList<ArrayList<Integer>> calculerEpaisseur(float portee, int numeroCharge) throws DAOException;
}
