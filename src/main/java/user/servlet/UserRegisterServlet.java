package user.servlet;

import java.io.IOException;
import java.io.PrintWriter;
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

import entity.User;

@WebServlet("/user_register")
public class UserRegisterServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		boolean isSuccess = false;
		try {

			// PrintWriter out = resp.getWriter();

			// get all data/value which is coming from signup.jsp page for new User
			// registration
			String nom = req.getParameter("nom");
			String email = req.getParameter("email");
			String password = req.getParameter("password");

			// Set all data to User Entity
			User user = new User(nom, email, password);

			// Create Connection with DB
			SingletonConnection singleton = SingletonConnection.getInstance();
			Connection conn = singleton.getConnection();
			
			UserDao userDao = new UserDaoImpl(conn);
			

			

			// call userRegister() and pass user object to insert or save user into DB.
			isSuccess = userDao.userRegister(user); // userRegister() method return boolean type value
			} catch (Exception e) {
				e.printStackTrace();
			}
		
			//get session
			HttpSession session = req.getSession();
			if (isSuccess == true) {
				session.setAttribute("successMsg", "Register Successfully");
				resp.sendRedirect("signup.jsp");//which page you want to show this msg
				//System.out.println("register successfull");
				// out.println("success");

			} else {
				
				session.setAttribute("errorMsg", "Something went wrong!");
				resp.sendRedirect("signup.jsp");//which page you want to show this msg
				
				//System.out.println("Error! Something went wrong");
				// out.println("error");
			}

		

	}

}
