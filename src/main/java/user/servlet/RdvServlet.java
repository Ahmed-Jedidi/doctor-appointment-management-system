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
import entity.Rdv;



@WebServlet("/addRdv")
public class RdvServlet extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
	
		
	int userId	= Integer.parseInt(req.getParameter("userId"));
	String nom = req.getParameter("nom");
	String gendre = req.getParameter("gendre");
	String age = req.getParameter("age");
	String date = req.getParameter("date");
	String temps = req.getParameter("temps");
	String email = req.getParameter("email");
	String phone = req.getParameter("phone");
	String diseases = req.getParameter("diseases");
	int medcinId = Integer.parseInt(req.getParameter("medcinId"));
	String addresse = req.getParameter("addresse");
	
	
	Rdv rdv = new Rdv(userId, nom, gendre, age, date, temps, email, phone, diseases, medcinId, addresse, "Pending");
	
	boolean f = false;
	try {
	// Create Connection with DB
	SingletonConnection singleton = SingletonConnection.getInstance();
	Connection conn = singleton.getConnection();
	
	RdvDao rdvDAO = new RdvDaoImpl(conn);
	f = rdvDAO.addRdv(rdv);

	} catch (Exception e) {
		e.printStackTrace();
	}
	
	
	//get session
	HttpSession session = req.getSession();
	
	
	if(f==true) {
		
		session.setAttribute("successMsg", "Rendus-vous is recorded Successfully.");
		resp.sendRedirect("user_rdv.jsp?id="+ (String) req.getParameter("medcinId"));
		
		
	}
	else {
		
		session.setAttribute("errorMsg", "Something went wrong on server!");
		resp.sendRedirect("user_rdv.jsp?id="+ (String) req.getParameter("medcinId"));
		
	}
	
		
	
	
		
	}

	
}
