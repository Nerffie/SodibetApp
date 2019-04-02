package Srv;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Beans.Utilisateur;
import Dao.DAOFactory;
import Dao.UtilisateurDao;
import Forms.DontShow;


public class Hauteur extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static final String ATT_USER = "utilisateur";
	public static final String ATT_DONT_SHOW = "dontShow";
	public static final String ATT_NEXT = "next";
	public static final String CONF_DAO_FACTORY = "daofactory";
    
	
	private UtilisateurDao utilisateurDao;
    
	
    public void init() throws ServletException {

        /* Récupération d'une instance de notre DAO Utilisateur */

        this.utilisateurDao = ( (DAOFactory) getServletContext().getAttribute( CONF_DAO_FACTORY ) ).getUtilisateurDao();

    }
   
    public Hauteur() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		
		if (session.getAttribute(ATT_USER)!=null) {
				this.getServletContext().getRequestDispatcher("/WEB-INF/hauteur.jsp").forward(req, resp);
		}
		
		else {
			resp.sendRedirect("Login");
		}
		
	}


	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		if(req.getParameter(ATT_DONT_SHOW)!=null) {
			HttpSession session = req.getSession();
			Utilisateur utilisateur = (Utilisateur) session.getAttribute(ATT_USER);
			new DontShow(utilisateurDao,3,utilisateur).nePlusAfficher();
			this.getServletContext().getRequestDispatcher("/WEB-INF/hauteur.jsp").forward(req, resp);
			//update la table pour mettre portee 1 à 1
			
		}
	}

}
