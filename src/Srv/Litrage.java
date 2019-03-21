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
import Forms.LitrageForm;


public class Litrage extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static final String ATT_USER = "utilisateur";
	public static final String ATT_DONT_SHOW = "dontShow";
	public static final String ATT_NEXT = "next";
	public static final String ATT_CALCUL = "calcul";
	public static final String CONF_DAO_FACTORY = "daofactory";
	private static final String ATT_ERROR = "erreur";
	public static final String ATT_RESULT = "resultat";
	public static final String ATT_EPAISSEUR = "epaisseur";
	public static final String ATT_SUPERFICIE = "superficie";
	
    
	
	private UtilisateurDao utilisateurDao;
    
	
    public void init() throws ServletException {

        /* Récupération d'une instance de notre DAO Utilisateur */

        this.utilisateurDao = ( (DAOFactory) getServletContext().getAttribute( CONF_DAO_FACTORY ) ).getUtilisateurDao();

    }
   
    public Litrage() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		
		if (session.getAttribute(ATT_USER)!=null) {
				this.getServletContext().getRequestDispatcher("/WEB-INF/litrage.jsp").forward(req, resp);
		}
		else {
			resp.sendRedirect("Login");
		}
	}


	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		if(req.getParameter(ATT_DONT_SHOW)!=null) {
			HttpSession session = req.getSession();
			Utilisateur utilisateur = (Utilisateur) session.getAttribute(ATT_USER);
			new DontShow(utilisateurDao,4,utilisateur).nePlusAfficher();
			this.getServletContext().getRequestDispatcher("/WEB-INF/litrage.jsp").forward(req, resp);
			//update la table pour mettre portee 1 à 1
		}
		if(req.getParameter(ATT_CALCUL)!=null) {
			LitrageForm form = new LitrageForm();
			float resultat = form.calculerLitrage(req);
			if (form.getErreurs().isEmpty()) {
				req.setAttribute(ATT_RESULT, resultat);
				req.setAttribute(ATT_EPAISSEUR, req.getParameter(ATT_EPAISSEUR));
				req.setAttribute(ATT_SUPERFICIE, req.getParameter(ATT_SUPERFICIE));
				
				this.getServletContext().getRequestDispatcher("/WEB-INF/litrageResultat.jsp").forward(req, resp);
			}
			else {
				req.setAttribute(ATT_ERROR, form.getErreurs());
				this.getServletContext().getRequestDispatcher("/WEB-INF/litrage.jsp").forward(req, resp);
			}
		}
		
	}

}
