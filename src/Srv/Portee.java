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


public class Portee extends HttpServlet {
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
   
    public Portee() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		
		if (session.getAttribute(ATT_USER)!=null) {
			Utilisateur utilisateur = (Utilisateur) session.getAttribute(ATT_USER);
			if(utilisateur.getPortee_1()==1) {
				this.getServletContext().getRequestDispatcher("/WEB-INF/portee.jsp").forward(req, resp);
			}
			else {
				this.getServletContext().getRequestDispatcher("/WEB-INF/porteeExplication.jsp").forward(req, resp);
			}
		}
		else {
			resp.sendRedirect("Login");
		}
		
	}


	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		if(req.getParameter(ATT_DONT_SHOW)!=null) {
			HttpSession session = req.getSession();
			Utilisateur utilisateur = (Utilisateur) session.getAttribute(ATT_USER);
			this.getServletContext().getRequestDispatcher("/WEB-INF/portee.jsp").forward(req, resp);
			//update la table pour mettre portee 1 à 1
			new DontShow(utilisateurDao,1,utilisateur).nePlusAfficher();
		}
		else if(req.getParameter(ATT_NEXT)!=null) {
			this.getServletContext().getRequestDispatcher("/WEB-INF/portee.jsp").forward(req, resp);
		}
	}

}
