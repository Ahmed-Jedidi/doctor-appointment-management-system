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
import dao.UserDao;
import dao.UserDaoImpl;

@WebServlet("/userChangePassword")
public class ChangePasswordServlet extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		try {
		
		int userId = Integer.parseInt(req.getParameter("userId"));
		String oldPassword = req.getParameter("oldPassword");
		String newPassword = req.getParameter("newPassword");
		
		// Create Connection with DB
		SingletonConnection singleton = SingletonConnection.getInstance();
		Connection conn = singleton.getConnection();
		
		UserDao userDao = new UserDaoImpl(conn);
		
		boolean isCorrectPassword = userDao.checkOldPassword(userId, oldPassword);
		
		
		HttpSession session = req.getSession();
		
		if( isCorrectPassword ) {
			
			if(userDao.changePassword(userId, newPassword)) {
				
				session.setAttribute("successMsg", "Password Change Successfully.");
				resp.sendRedirect("change_password.jsp");
				
			}else {
				
				session.setAttribute("errorMsg", "Something wrong on server!");
				resp.sendRedirect("change_password.jsp");
				
			}
			
		}else {
			session.setAttribute("errorMsg", "Old password incorrect");
			resp.sendRedirect("change_password.jsp");
		}
		
		}  catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	

}
