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
import Forms.EpaisseurForm;


public class Epaisseur extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static final String ATT_USER = "utilisateur";
	public static final String ATT_DONT_SHOW = "dontShow";
	public static final String ATT_NEXT = "next";
	public static final String ATT_CALCUL = "calcul";
	public static final String ATT_RESULT = "resultat";
	public static final String ATT_CHARGE = "charge";
	public static final String ATT_PORTEE = "portee";
	private static final String ATT_ERROR = "erreur";
	public static final String CONF_DAO_FACTORY = "daofactory";
    
	
	
	
	private IsostatiqueSimpleDao      isostatiqueSimpleDao;
	private IsostatiqueJumelleDao      isostatiqueJumelleDao;
	private ContinueSimpleDao      continueSimpleDao;
	private ContinueJumelleDao      continueJumelleDao;
	private UtilisateurDao utilisateurDao;
    
	
    public void init() throws ServletException {

        /* R�cup�ration d'une instance de notre DAO Utilisateur */
    	this.isostatiqueSimpleDao = ( (DAOFactory) getServletContext().getAttribute( CONF_DAO_FACTORY ) ).getIsostatiqueSimpleDao();
        this.isostatiqueJumelleDao = ( (DAOFactory) getServletContext().getAttribute( CONF_DAO_FACTORY ) ).getIsostatiqueJumelleDao();
        this.continueSimpleDao = ( (DAOFactory) getServletContext().getAttribute( CONF_DAO_FACTORY ) ).getContinueSimpleDao();
        this.continueJumelleDao = ( (DAOFactory) getServletContext().getAttribute( CONF_DAO_FACTORY ) ).getContinueJumelleDao();
        this.utilisateurDao = ( (DAOFactory) getServletContext().getAttribute( CONF_DAO_FACTORY ) ).getUtilisateurDao();

    }
   
    public Epaisseur() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		if (session.getAttribute(ATT_USER)!=null) {
			
				this.getServletContext().getRequestDispatcher("/WEB-INF/epaisseur.jsp").forward(req, resp);	
		}
		else {
			resp.sendRedirect("Login");
		}
	}


	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		if(req.getParameter(ATT_DONT_SHOW)!=null) {
			HttpSession session = req.getSession();
			Utilisateur utilisateur = (Utilisateur) session.getAttribute(ATT_USER);
			new DontShow(utilisateurDao,2,utilisateur).nePlusAfficher();
			this.getServletContext().getRequestDispatcher("/WEB-INF/epaisseur.jsp").forward(req, resp);
			//update la table pour mettre portee 1 � 1	
		}
		if(req.getParameter(ATT_CALCUL)!=null) {
			EpaisseurForm form = new EpaisseurForm(isostatiqueSimpleDao, isostatiqueJumelleDao, continueSimpleDao, continueJumelleDao);
			ArrayList<ArrayList<ArrayList<Integer>>> resultat = form.calculerEpaisseur(req);
			if (form.getErreurs().isEmpty()) {
				req.setAttribute(ATT_RESULT, resultat);
				req.setAttribute(ATT_CHARGE, req.getParameter(ATT_CHARGE));
				req.setAttribute(ATT_PORTEE, req.getParameter(ATT_PORTEE));
				this.getServletContext().getRequestDispatcher("/WEB-INF/epaisseurResultat.jsp").forward(req, resp);
			}
			else {
				req.setAttribute(ATT_ERROR, form.getErreurs());
				this.getServletContext().getRequestDispatcher("/WEB-INF/epaisseur.jsp").forward(req, resp);
			}
		}
	}

}
