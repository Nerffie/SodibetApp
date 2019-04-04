package Srv;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Dao.DAOFactory;
import Dao.UtilisateurDao;
import Forms.AllUtilisateur;
import Beans.Utilisateur;


public class UsersData extends HttpServlet {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static final String ATT_USER = "administrateur";
	public static final String ATT_RESULTAT = "users";
	public static final String CONF_DAO_FACTORY = "daofactory";
	
	private UtilisateurDao utilisateurDao;

	
	public void init() throws ServletException {

        /* Récupération d'une instance de notre DAO Utilisateur */
    
        this.utilisateurDao = ( (DAOFactory) getServletContext().getAttribute( CONF_DAO_FACTORY ) ).getUtilisateurDao();

    }
	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = req.getSession();
		
		if (session.getAttribute(ATT_USER)!=null) {
			ArrayList<Utilisateur> resultat = new AllUtilisateur(utilisateurDao).getUsers();
			req.setAttribute(ATT_RESULTAT, resultat);
			this.getServletContext().getRequestDispatcher("/WEB-INF/usersData.jsp").forward(req, resp);
		}
		else {
			resp.sendRedirect("Login");
		}
	}
	

}
