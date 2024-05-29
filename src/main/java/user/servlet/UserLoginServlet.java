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
import entity.User;


import dao.UserDao;
import dao.UserDaoImpl;

@WebServlet("/userLogin")
public class UserLoginServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String email = req.getParameter("email");
		String password = req.getParameter("password");
		
		HttpSession session = req.getSession();
		
		boolean f = false; 
		
		try {
		// Create Connection with DB
		SingletonConnection singleton = SingletonConnection.getInstance();
		Connection conn = singleton.getConnection();
		
		UserDao userDao = new UserDaoImpl(conn);
		User user = userDao.loginUser(email, password);
		
		f = user!=null; 
		
		
		if (f) {
			session.setAttribute("userObj",user);
			resp.sendRedirect("index.jsp"); 
		}
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (!f){
			session.setAttribute("errorMsg","Invalid email or password");
			resp.sendRedirect("user_login.jsp"); 
		}
		
		
	}
	
	
}
