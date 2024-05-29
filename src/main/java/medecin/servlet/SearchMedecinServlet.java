package medecin.servlet;


import java.io.IOException;
import java.sql.Connection;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import connection.SingletonConnection;
import dao.MedecinDao;
import dao.MedecinDaoImpl;
import entity.Medecin;



/**
 * Servlet implementation class medecinController
 */
@WebServlet("/SearchMedecinServlet")
public class SearchMedecinServlet extends HttpServlet {
	private MedecinDao medecinDAO;
	@Override
	public void init() throws ServletException {
		try {
		// Create Connection with DB
		SingletonConnection singleton = SingletonConnection.getInstance();
		Connection conn = singleton.getConnection();
		
		medecinDAO = new MedecinDaoImpl(conn);
		
		}  catch (Exception e) {
			e.printStackTrace();
		}
	} 

	private static final long serialVersionUID = 1L;
       
    
    public SearchMedecinServlet() {
        super();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nom = request.getParameter("nom");
		String specialite = request.getParameter("specialite");
		String adresse = request.getParameter("adresse");
		
		MedecinModel medM = new MedecinModel();
		medM.setNom(nom);
		medM.setAdresse(adresse);
		medM.setSpecialite(specialite);
		List<Medecin> med = medecinDAO.getMedecinParMotcle(nom, specialite, adresse);
		medM.setMedecins(med);
		request.setAttribute("modele", medM);
		
		request.getRequestDispatcher("search_medecin.jsp").forward(request, response);
	}

}
