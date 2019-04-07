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
import Forms.ConnexionForm;


public class Login extends HttpServlet {
	
	
	private static final long serialVersionUID = 1L;
	public static final String CONF_DAO_FACTORY = "daofactory";
	public static final String ATT_USER = "utilisateur";

    public static final String ATT_FORM = "form";
	 private UtilisateurDao utilisateurDao;
     

    public Login() {
        super();
       
    }
    public void init() throws ServletException {

        /* Récupération d'une instance de notre DAO Utilisateur */

        this.utilisateurDao = ( (DAOFactory) getServletContext().getAttribute( CONF_DAO_FACTORY ) ).getUtilisateurDao();

    }
	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = req.getSession();
		if (session.getAttribute(ATT_USER)!=null) {
			resp.sendRedirect("Index");
		}
		else {
			this.getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(req, resp);
		}
		
	}
	
	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		 /* Préparation de l'objet formulaire */
       ConnexionForm form = new ConnexionForm(utilisateurDao);
		
       /* Appel au traitement et à la validation de la requête, et récupération du bean en résultant */
       Utilisateur utilisateur = form.connecterUtilisateur(req);
       
       /* Stockage du formulaire et du bean dans l'objet request */
       
       if (form.getErreurs().isEmpty()){
			//this.getServletContext().getRequestDispatcher("/WEB-INF/verifyPending.jsp").forward( req, resp );
    	   if(utilisateur.getValide()==1) {
    		   HttpSession session= req.getSession();
   				session.setAttribute(ATT_USER, utilisateur);
   				resp.sendRedirect("Home"); 
    	   }
    	   else {
    		   this.getServletContext().getRequestDispatcher("/WEB-INF/verifyPending.jsp").forward( req, resp );
    	   }
			 
		}
		else {
			req.setAttribute(ATT_FORM, form);
			req.setAttribute(ATT_USER, utilisateur);
			this.getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward( req, resp );
		}
	}
}
