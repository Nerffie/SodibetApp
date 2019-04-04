package Dao;



import Beans.Admin;

public interface AdminDao {
	

    Admin trouver( String email ) throws DAOException;
    String getPass(String email) throws DAOException;
  
}
