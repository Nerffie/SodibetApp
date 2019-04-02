package Dao;

import java.util.ArrayList;

import Beans.Admin;
import Beans.Utilisateur;

public interface AdminDao {
	

    Admin trouver( String email ) throws DAOException;
    String getPass(String email) throws DAOException;
  
}
