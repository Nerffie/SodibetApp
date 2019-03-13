package Srv;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Beans.Utilisateur;
import Dao.ContinueJumelleDao;
import Dao.ContinueSimpleDao;
import Dao.DAOFactory;
import Dao.IsostatiqueJumelleDao;
import Dao.IsostatiqueSimpleDao;
import Dao.UtilisateurDao;
import Forms.DontShow;
import Forms.PorteeForm;


public class Portee extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static final String ATT_USER = "utilisateur";
	public static final String ATT_DONT_SHOW = "dontShow";
	public static final String ATT_CALCUL = "calcul";
	public static final String ATT_NEXT = "next";
	public static final String CONF_DAO_FACTORY = "daofactory";
	public static final String ATT_RESULT ="resultat";
    
	private IsostatiqueSimpleDao      isostatiqueSimpleDao;
	private IsostatiqueJumelleDao      isostatiqueJumelleDao;
	private ContinueSimpleDao      continueSimpleDao;
	private ContinueJumelleDao      continueJumelleDao;
	private UtilisateurDao utilisateurDao;
    
	
    public void init() throws ServletException {

        /* Récupération d'une instance de notre DAO Utilisateur */
    	this.isostatiqueSimpleDao = ( (DAOFactory) getServletContext().getAttribute( CONF_DAO_FACTORY ) ).getIsostatiqueSimpleDao();
        this.isostatiqueJumelleDao = ( (DAOFactory) getServletContext().getAttribute( CONF_DAO_FACTORY ) ).getIsostatiqueJumelleDao();
        this.continueSimpleDao = ( (DAOFactory) getServletContext().getAttribute( CONF_DAO_FACTORY ) ).getContinueSimpleDao();
        this.continueJumelleDao = ( (DAOFactory) getServletContext().getAttribute( CONF_DAO_FACTORY ) ).getContinueJumelleDao();
        this.utilisateurDao = ( (DAOFactory) getServletContext().getAttribute( CONF_DAO_FACTORY ) ).getUtilisateurDao();
    }
   
    public Portee() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		
		if (session.getAttribute(ATT_USER)!=null) {
				this.getServletContext().getRequestDispatcher("/WEB-INF/portee.jsp").forward(req, resp);
		}
		else {
			resp.sendRedirect("Login");
		}
		
	}


	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		if(req.getParameter(ATT_DONT_SHOW)!=null) {
			HttpSession session = req.getSession();
			Utilisateur utilisateur = (Utilisateur) session.getAttribute(ATT_USER);
			
			//update la table pour mettre portee 1 à 1
			new DontShow(utilisateurDao,1,utilisateur).nePlusAfficher();
			this.getServletContext().getRequestDispatcher("/WEB-INF/portee.jsp").forward(req, resp);
		}
		if(req.getParameter(ATT_CALCUL)!=null) {
			ArrayList<Float> resultat = new PorteeForm(isostatiqueSimpleDao, isostatiqueJumelleDao, continueSimpleDao, continueJumelleDao).calculerPortee(req);
			req.setAttribute(ATT_RESULT, resultat);
			this.getServletContext().getRequestDispatcher("/WEB-INF/porteeResultat.jsp").forward(req, resp);
		}
	}

}
