package Srv;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class Index extends HttpServlet {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static final String ATT_USER = "utilisateur";
	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = req.getSession();
		StringBuilder requestURL = new StringBuilder(req.getRequestURL().toString());
		System.out.println(requestURL.toString());
		if (session.getAttribute(ATT_USER)!=null) {
			this.getServletContext().getRequestDispatcher("/WEB-INF/index.jsp").forward(req, resp);
		}
		else {
			resp.sendRedirect("Login");
		}
	}
	

}
