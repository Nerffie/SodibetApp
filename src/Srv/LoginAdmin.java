package Srv;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Beans.Admin;
import Beans.Utilisateur;
import Dao.AdminDao;
import Dao.DAOFactory;
import Dao.UtilisateurDao;
import Forms.ConnexionForm;
import Forms.ConnexionFormAdmin;


public class LoginAdmin extends HttpServlet {
	
	
	private static final long serialVersionUID = 1L;
	public static final String CONF_DAO_FACTORY = "daofactory";
	public static final String ATT_USER = "administrateur";

    public static final String ATT_FORM = "form";
	 private AdminDao adminDao;
     

    public LoginAdmin() {
        super();
       
    }
    public void init() throws ServletException {

        /* Récupération d'une instance de notre DAO Utilisateur */

        this.adminDao = ( (DAOFactory) getServletContext().getAttribute( CONF_DAO_FACTORY ) ).getAdminDao();

    }
	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.getServletContext().getRequestDispatcher("/WEB-INF/loginAdmin.jsp").forward(req, resp);
	}
	
	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		 /* Préparation de l'objet formulaire */
       ConnexionFormAdmin form = new ConnexionFormAdmin(adminDao);
		
       /* Appel au traitement et à la validation de la requête, et récupération du bean en résultant */
      Admin admin = form.connecterAdmin(req);
       
       /* Stockage du formulaire et du bean dans l'objet request */
       
       if (form.getErreurs().isEmpty()){
    		   HttpSession session= req.getSession();
   				session.setAttribute(ATT_USER, admin);
   				resp.sendRedirect("UsersData"); 
		}
		else {
			req.setAttribute(ATT_FORM, form);
			req.setAttribute(ATT_USER, admin);
			this.getServletContext().getRequestDispatcher("/WEB-INF/loginAdmin.jsp").forward( req, resp );
		}
	}
}
