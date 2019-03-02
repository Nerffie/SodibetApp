package Srv;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Beans.Utilisateur;
import Dao.UtilisateurDao;
import Forms.InscriptionForm;
import Dao.DAOFactory;


//@WebServlet("/SignUp")
public class SignUp extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static final String CONF_DAO_FACTORY = "daofactory";
	public static final String ATT_USER = "utilisateur";

    public static final String ATT_FORM = "form";

    public static final String VUE = "/WEB-INF/inscription.jsp";
    private UtilisateurDao utilisateurDao;
       

    public SignUp() {
        super();
       
    }
    public void init() throws ServletException {

        /* Récupération d'une instance de notre DAO Utilisateur */

        this.utilisateurDao = ( (DAOFactory) getServletContext().getAttribute( CONF_DAO_FACTORY ) ).getUtilisateurDao();

    }


	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.getServletContext().getRequestDispatcher("/WEB-INF/signup.jsp").forward(req, resp);
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		 /* Préparation de l'objet formulaire */
        InscriptionForm form = new InscriptionForm(utilisateurDao);
		
        /* Appel au traitement et à la validation de la requête, et récupération du bean en résultant */
        Utilisateur utilisateur = form.inscrireUtilisateur(req);
        
        /* Stockage du formulaire et du bean dans l'objet request */
        //request.setAttribute( ATT_FORM, form );
        //request.setAttribute( ATT_USER, utilisateur );
		if (form.getErreurs().isEmpty()){
			this.getServletContext().getRequestDispatcher("/WEB-INF/verifyPending.jsp").forward( req, resp );
			//response.sendRedirect("Home");  
		}
		else {
			req.setAttribute(ATT_FORM, form);
			req.setAttribute(ATT_USER, utilisateur);
			this.getServletContext().getRequestDispatcher("/WEB-INF/signup.jsp").forward( req, resp );
		}
        
	}

}
