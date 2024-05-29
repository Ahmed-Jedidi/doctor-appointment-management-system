package user.servlet;

import java.io.IOException;
import java.sql.Connection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import connection.SingletonConnection;
import dao.RdvDao;
import dao.RdvDaoImpl;

@WebServlet("/deleteRdv")
public class DeleteRdvServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		boolean f = false;
		
		//get id(which is coming as string value) and convert into int	
		int id = Integer.parseInt(req.getParameter("id"));
		
		HttpSession session = req.getSession();
		
		try {
			// Create Connection with DB
			SingletonConnection singleton = SingletonConnection.getInstance();
			Connection conn = singleton.getConnection();
		
			RdvDao rdvDAO = new RdvDaoImpl(conn);
		
		
			f = rdvDAO.deleteRdvById(id);
		
		 } catch (Exception e) {
			e.printStackTrace();
		}
		
		if(f==true) {
			session.setAttribute("successMsg", "Rendus-vous supprimé avec succes.");
			resp.sendRedirect("view_rdv.jsp");
		}
		else {
			session.setAttribute("errorMsg", "Something went wrong on server!");
			resp.sendRedirect("view_rdv.jsp");
		}
	}
	
	

}
