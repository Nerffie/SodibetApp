package Srv;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Beans.Utilisateur;
import Forms.Question;


public class Ask extends HttpServlet {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static final String ATT_USER = "utilisateur";

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = req.getSession();
		
		if (session.getAttribute(ATT_USER)!=null) {
			this.getServletContext().getRequestDispatcher("/WEB-INF/ask.jsp").forward(req, resp);
		}
		else {
			resp.sendRedirect("Login");
		}
	}
	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = req.getSession();
		if (session.getAttribute(ATT_USER)!=null) {
			Utilisateur user = (Utilisateur) session.getAttribute(ATT_USER);
			Question question = new Question(user);
			question.sendMail(req);
			this.getServletContext().getRequestDispatcher("/WEB-INF/askDone.jsp").forward(req, resp);
		}
		else {
			resp.sendRedirect("Login");
		}
	}
	

}
