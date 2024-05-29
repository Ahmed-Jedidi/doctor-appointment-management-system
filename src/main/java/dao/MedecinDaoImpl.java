package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/*import connection.SingletonConnection;*/
import entity.Medecin;

public class MedecinDaoImpl implements MedecinDao {
	
	private Connection conn;

	public MedecinDaoImpl(Connection conn) {
		super();
		this.conn = conn;
	}

	@Override
	public List<Medecin> getMedecinParMotcle(String nom, String spececialite, String adresse) {
	    List<Medecin> medc = new ArrayList<>();

	    try {
	        /*SingletonConnection singleton = SingletonConnection.getInstance();
	        Connection conn = singleton.getConnection();*/
	    	
	        String sql = "SELECT * FROM Medecins WHERE nom LIKE ? AND specialite LIKE ? AND adresse LIKE ?";
	        
	        PreparedStatement pst = conn.prepareStatement(sql);
	            pst.setString(1, "%" + nom + "%");
	            pst.setString(2, "%" + spececialite + "%");
	            pst.setString(3, "%" + adresse + "%");
	            
	        ResultSet rs = pst.executeQuery();
	            while (rs.next()) {
	                Medecin med = new Medecin();

	                med.setId(rs.getInt("id"));
	                med.setNom(rs.getString("nom"));
	                med.setEmail(rs.getString("email"));
	                med.setPassword(rs.getString("password"));
		            med.setPhone(rs.getString("phone"));
		            med.setNaissance(rs.getString("naissance"));
		            med.setVille(rs.getString("ville"));
		            med.setAdresse(rs.getString("adresse"));
		            med.setSpecialite(rs.getString("specialite"));
		            med.setQualification(rs.getString("qualification"));
	                medc.add(med);
	            }
	    } catch (Exception e) {
	        System.out.println(e);
	    }
	    return medc;
	}
	
	
	


	
	public boolean ajouterMedecin(Medecin medecin) {

	    boolean isSuccess = false;

	    try {
	        String sql = "INSERT INTO medecins(nom, email, password, phone, naissance, ville, adresse, specialite, qualification) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";

	        PreparedStatement pstmt = this.conn.prepareStatement(sql);
	        pstmt.setString(1, medecin.getNom());
	        pstmt.setString(2, medecin.getEmail());
	        pstmt.setString(3, medecin.getPassword());
	        pstmt.setString(4, medecin.getPhone());
	        pstmt.setString(5, medecin.getNaissance());
	        pstmt.setString(6, medecin.getVille());
	        pstmt.setString(7, medecin.getAdresse());
	        pstmt.setString(8, medecin.getSpecialite());
	        pstmt.setString(9, medecin.getQualification());

	        int rowsAffected = pstmt.executeUpdate();
	        
	        // If the query was inserted successfully (all operations OK)
	        isSuccess = rowsAffected > 0;

	    } catch (Exception e) {
	        e.printStackTrace();
	    }

	    return isSuccess;
	}

	
	

	// getAllMedecins list
	public List<Medecin> getAllMedecins() {

	    Medecin medecin = null;
	    List<Medecin> medecinList = new ArrayList<>();

	    try {
	        //String sql = "SELECT id, nom, email, password, phone, naissance, ville, adresse, specialite, qualification FROM medecins ORDER BY id DESC";
	    	String sql = "SELECT * FROM medecins ORDER BY id DESC";
	        PreparedStatement pstmt = this.conn.prepareStatement(sql);

	        ResultSet resultSet = pstmt.executeQuery();

	        while (resultSet.next()) {
	            medecin = new Medecin();

	            medecin.setId(resultSet.getInt("id"));
	            medecin.setNom(resultSet.getString("nom"));
	            medecin.setEmail(resultSet.getString("email"));
	            medecin.setPassword(resultSet.getString("password"));
	            medecin.setPhone(resultSet.getString("phone"));
	            medecin.setNaissance(resultSet.getString("naissance"));
	            medecin.setVille(resultSet.getString("ville"));
	            medecin.setAdresse(resultSet.getString("adresse"));
	            medecin.setSpecialite(resultSet.getString("specialite"));
	            medecin.setQualification(resultSet.getString("qualification"));

	            medecinList.add(medecin);
	        }

	    } catch (Exception e) {
	        e.printStackTrace();
	    }

	    return medecinList;
	}

	
	// get medecin by id
	public Medecin getMedecinById(int id) {

	    Medecin medecin = null;

	    try {

	        //String sql = "SELECT id, nom, email, password, phone, naissance, ville, adresse, specialite, qualification FROM medecins WHERE id=?";
	        String sql = "SELECT * FROM medecins WHERE id=?";
	    	PreparedStatement pstmt = this.conn.prepareStatement(sql);
	        pstmt.setInt(1, id);

	        ResultSet resultSet = pstmt.executeQuery();

	        while (resultSet.next()) {
	            medecin = new Medecin();

	            medecin.setId(resultSet.getInt("id"));
	            medecin.setNom(resultSet.getString("nom"));
	            medecin.setEmail(resultSet.getString("email"));
	            medecin.setPassword(resultSet.getString("password"));
	            medecin.setPhone(resultSet.getString("phone"));
	            medecin.setNaissance(resultSet.getString("naissance"));
	            medecin.setVille(resultSet.getString("ville"));
	            medecin.setAdresse(resultSet.getString("adresse"));
	            medecin.setSpecialite(resultSet.getString("specialite"));
	            medecin.setQualification(resultSet.getString("qualification"));
	        }

	    } catch (Exception e) {
	        e.printStackTrace();
	    }

	    return medecin;
	}
	
	
	// update medecin by id
	public boolean updateMedecin(Medecin medecin) {

	    boolean isSuccess = false;

	    try {

	        String sql = "UPDATE medecins SET nom=?, email=?, password=?, phone=?, naissance=?, ville=?, adresse=?, specialite=?, qualification=? WHERE id=?";

	        PreparedStatement pstmt = this.conn.prepareStatement(sql);
	        pstmt.setString(1, medecin.getNom());
	        pstmt.setString(2, medecin.getEmail());
	        pstmt.setString(3, medecin.getPassword());
	        pstmt.setString(4, medecin.getPhone());
	        pstmt.setString(5, medecin.getNaissance());
	        pstmt.setString(6, medecin.getVille());
	        pstmt.setString(7, medecin.getAdresse());
	        pstmt.setString(8, medecin.getSpecialite());
	        pstmt.setString(9, medecin.getQualification());
	        // need to set id also for update
	        pstmt.setInt(10, medecin.getId());

	        int rowsAffected = pstmt.executeUpdate();
	        // if query updated or all ok than
	        isSuccess = rowsAffected > 0;

	    } catch (Exception e) {
	        e.printStackTrace();
	    }

	    return isSuccess;
	}

	
	// delete medecin by id
	public boolean deleteMedecinById(int id) {

	    boolean isSuccess = false;

	    try {

	        String sql = "DELETE FROM medecins WHERE id=?";
	        PreparedStatement pstmt = this.conn.prepareStatement(sql);
	        pstmt.setInt(1, id);

	        int rowsAffected = pstmt.executeUpdate();

	        // if query deleted or all ok then
	        isSuccess = rowsAffected > 0;

	    } catch (Exception e) {
	        e.printStackTrace();
	    }

	    return isSuccess;
	}


	
	
	// medecin login
	public Medecin loginMedecin(String email, String password) {

	    Medecin medecin = null;

	    try {

	        //String sql = "SELECT id, nom, email, password, phone, naissance, ville, adresse, specialite, qualification FROM medecins WHERE email=? AND password=?";
	    	String sql = "SELECT * FROM medecins WHERE email=? AND password=?";
	    	PreparedStatement pstmt = this.conn.prepareStatement(sql);

	        pstmt.setString(1, email);
	        pstmt.setString(2, password);

	        ResultSet resultSet = pstmt.executeQuery();

	        while (resultSet.next()) {
	            medecin = new Medecin();

	            medecin.setId(resultSet.getInt("id"));
	            medecin.setNom(resultSet.getString("nom"));
	            medecin.setEmail(resultSet.getString("email"));
	            medecin.setPassword(resultSet.getString("password"));
	            medecin.setPhone(resultSet.getString("phone"));
	            medecin.setNaissance(resultSet.getString("naissance"));
	            medecin.setVille(resultSet.getString("ville"));
	            medecin.setAdresse(resultSet.getString("adresse"));
	            medecin.setSpecialite(resultSet.getString("specialite"));
	            medecin.setQualification(resultSet.getString("qualification"));

	        }

	    } catch (SQLException e) {
	        e.printStackTrace();
	    }

	    return medecin;
	}

	
	// Count total medecin number
	public int countTotalMedecin() {

	    int count = 0;

	    try {

	        String sql = "SELECT COUNT(*) FROM medecins";
	        PreparedStatement pstmt = this.conn.prepareStatement(sql);

	        ResultSet resultSet = pstmt.executeQuery();
	        if (resultSet.next()) {
	            count = resultSet.getInt(1);
	        }

	    } catch (SQLException e) {
	        e.printStackTrace();
	    }

	    return count;
	}
	
	
	// check old password
	public boolean checkOldPassword(int medecinId, String oldPassword) {

	    boolean isMatch = false;

	    try {

	        String sql = "SELECT * FROM medecins WHERE id=? AND password=?";
	        PreparedStatement pstmt = this.conn.prepareStatement(sql);
	        pstmt.setInt(1, medecinId);
	        pstmt.setString(2, oldPassword);

	        ResultSet resultSet = pstmt.executeQuery();

	        if (resultSet.next()) {
	            isMatch = true;
	        }

	    } catch (SQLException e) {
	        e.printStackTrace();
	    }

	    return isMatch;
	}
	
	
	
	// change password
	public boolean changePassword(int medecinId, String newPassword) {

	    boolean isSuccess = false;

	    try {

	        String sql = "UPDATE medecins SET password=? WHERE id=?";
	        PreparedStatement pstmt = this.conn.prepareStatement(sql);
	        pstmt.setString(1, newPassword);
	        pstmt.setInt(2, medecinId);

	        int rowsAffected = pstmt.executeUpdate();
	        // if query updated or all ok then
	        isSuccess = rowsAffected > 0;

	    } catch (SQLException e) {
	        e.printStackTrace();
	    }

	    return isSuccess;
	}

	
	// edit medecin profile in medecin panel edit profile
	public boolean editMedecinProfile(Medecin medecin) {

	    boolean isSuccess = false;

	    try {

	        String sql = "UPDATE medecins SET nom=?, email=?, password=?, phone=?, naissance=?, ville=?, adresse=?, specialite=?, qualification=? WHERE id=?";

	        PreparedStatement pstmt = this.conn.prepareStatement(sql);
	        pstmt.setString(1, medecin.getNom());
	        pstmt.setString(2, medecin.getEmail());
	        pstmt.setString(3, medecin.getPassword());
	        pstmt.setString(4, medecin.getPhone());
	        pstmt.setString(5, medecin.getNaissance());
	        pstmt.setString(6, medecin.getVille());
	        pstmt.setString(7, medecin.getAdresse());
	        pstmt.setString(8, medecin.getSpecialite());
	        pstmt.setString(9, medecin.getQualification());
	        pstmt.setInt(10, medecin.getId());

	        int rowsAffected = pstmt.executeUpdate();
	        // if query updated or all okay than
	        isSuccess = rowsAffected > 0;

	    } catch (SQLException e) {
	        e.printStackTrace();
	    }

	    return isSuccess;
	}

}
