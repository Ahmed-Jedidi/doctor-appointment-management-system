package notification;

import java.io.IOException;
import java.sql.Connection;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
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




@WebServlet("/confirmRdv")
public class NotificationRdvServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		boolean f = false;
		
		//get id(which is coming as string value) and convert into int	
		int id = Integer.parseInt(req.getParameter("id"));
		String eeemail = (String) req.getParameter("mail");
		
		HttpSession session = req.getSession();
		
		try {
			// Create Connection with DB
			SingletonConnection singleton = SingletonConnection.getInstance();
			Connection conn = singleton.getConnection();
		
			RdvDao rdvDAO = new RdvDaoImpl(conn);
		
			Rdv tempRdv = rdvDAO.getRdvById(id);
			
			
			
			
			tempRdv.setStatus("Confirmed");
			
			//////////////////////////////////////////////////////////
			final String mail="bonsoincentre.info@gmail.com";
			final String pass="ijfblvadxezpluiz";
			
			Properties props= new Properties();
			props.put("mail.smtp.auth", "true");
			props.put("mail.smtp.starttls.enable", "true");
			props.put("mail.smtp.host", "smtp.gmail.com");
			props.put("mail.smtp.port", "587");
			
			javax.mail.Session session1 = javax.mail.Session.getInstance(props, new javax.mail.Authenticator() {
	            protected PasswordAuthentication getPasswordAuthentication() {
	                return new PasswordAuthentication(mail, pass);
	            }
	        });
	        
	        try {
				Message message = new MimeMessage(session1);
				message.setFrom(new InternetAddress("bonsoincentre.info@gmail.com"));
				message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(eeemail));
				message.setSubject("ProjectDS");
				message.setText("Dear Mail BONSOINS,"+"\n\n"+"Votre rendus vous est confirme");
				
				Transport.send(message);
				
				System.out.println("Email Notification DONE");
			} catch (MessagingException e) {
				// TODO: handle exception
				e.printStackTrace();
			}
			
			
			
			/////////////////////////////////////////////////////////
			
			
			
			
			
			
			/////////////////////////////////////////////////////////
			
			
			
			f = rdvDAO.updateRdv(tempRdv);
		
		 } catch (Exception e) {
			e.printStackTrace();
		}
		
		if(f==true) {
			//session.setAttribute("successMsg", "Rendus-vous supprimé avec succes.");
			resp.sendRedirect("view_rdv.jsp");
		}
		else {
			//session.setAttribute("errorMsg", "Something went wrong on server!");
			resp.sendRedirect("view_rdv.jsp");
		}
	}
	
	

}