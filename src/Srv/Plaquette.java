package Srv;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class Plaquette extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private static final String PLAQUETTE_NAME = "Plaquette Sodibet v2016.pdf";
    private static final String ATT_USER = "utilisateur";
    
    public Plaquette() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.setHeader("Content-Type", "application/pdf");
		//response.setHeader("Content-Disposition", "attachment;filename=\"" + PLAQUETTE_NAME + "\"");
		HttpSession session = req.getSession();
		if (session.getAttribute(ATT_USER)!=null) {
			this.getServletContext().getRequestDispatcher("/WEB-INF/"+PLAQUETTE_NAME).forward(req, resp);
		}
		else {
			resp.sendRedirect("Login");
		}
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
