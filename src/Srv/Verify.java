package Srv;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dao.DAOFactory;
import Dao.UtilisateurDao;
import Forms.VerifyUser;


public class Verify extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static final String ATT_VALIDE_HASH = "key";
	public static final String CONF_DAO_FACTORY = "daofactory";
	private UtilisateurDao utilisateurDao;
       

    public Verify() {
        super();
    }
    
    public void init() throws ServletException {

        /* Récupération d'une instance de notre DAO Utilisateur */

        this.utilisateurDao = ( (DAOFactory) getServletContext().getAttribute( CONF_DAO_FACTORY ) ).getUtilisateurDao();

    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String valide_hash = request.getParameter(ATT_VALIDE_HASH);
		if (valide_hash == null) {
			response.sendRedirect("Home");
		}
		else {
			VerifyUser verification = new VerifyUser(utilisateurDao,valide_hash);
			if (verification.traiterVerification()) {
				this.getServletContext().getRequestDispatcher("/WEB-INF/verifyDone.jsp").forward(request, response);
			}
			else {
				System.out.println("it didn't verify");
				response.sendRedirect("Home");
			}
			
			
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
