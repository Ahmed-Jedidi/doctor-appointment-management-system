package dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import entity.Rdv;

public class RdvDaoImpl implements RdvDao {
	

	private Connection conn;

	public RdvDaoImpl(Connection conn) {
		super();
		this.conn = conn;
	}

	
	
	// Creer un rendez-vous
	public boolean addRdv(Rdv rdv) {
	    boolean isSuccess = false;

	    try {
	        String sql = "INSERT INTO rdvs(userId, Nom, gendre, age, date, temps, email, phone, diseases, medcinId, addresse, status) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
	        PreparedStatement pstmt = this.conn.prepareStatement(sql);

	        pstmt.setInt(1, rdv.getUserId());
	        pstmt.setString(2, rdv.getNom());
	        pstmt.setString(3, rdv.getGendre());
	        pstmt.setString(4, rdv.getAge());
	        pstmt.setString(5, rdv.getDate());
	        pstmt.setString(6, rdv.getTemps());
	        pstmt.setString(7, rdv.getEmail());
	        pstmt.setString(8, rdv.getPhone());
	        pstmt.setString(9, rdv.getDiseases());
	        pstmt.setInt(10, rdv.getMedcinId());
	        pstmt.setString(11, rdv.getAddresse());
	        pstmt.setString(12, rdv.getStatus());

	        pstmt.executeUpdate();

	        isSuccess = true;

	    } catch (SQLException e) {
	        e.printStackTrace();
	    }

	    return isSuccess;
	}
	
	
	// get list of rdvs for logged-in specific user
	// show rdvs list for specific user panel
	public List<Rdv> getAllRdvsByUser(int userId) {
	    List<Rdv> rdvList = new ArrayList<>();

	    Rdv rdv = null;

	    try {

	        String sql = "SELECT * FROM rdvs WHERE userId=?";
	        PreparedStatement pstmt = this.conn.prepareStatement(sql);

	        pstmt.setInt(1, userId);

	        ResultSet resultSet = pstmt.executeQuery();

	        while (resultSet.next()) {
	            rdv = new Rdv();

	            rdv.setId(resultSet.getInt(1)); // rdv id
	            rdv.setUserId(resultSet.getInt(2)); // userId
	            rdv.setNom(resultSet.getString(3));
	            rdv.setGendre(resultSet.getString(4));
	            rdv.setAge(resultSet.getString(5));
	            rdv.setDate(resultSet.getString(6));
	            rdv.setTemps(resultSet.getString(7));
	            rdv.setEmail(resultSet.getString(8));
	            rdv.setPhone(resultSet.getString(9));
	            rdv.setDiseases(resultSet.getString(10));
	            rdv.setMedcinId(resultSet.getInt(11));
	            rdv.setAddresse(resultSet.getString(12));
	            rdv.setStatus(resultSet.getString(13));

	            rdvList.add(rdv);
	        }

	    } catch (SQLException e) {
	        e.printStackTrace();
	    }

	    return rdvList;
	}

	
	
	
	// get rdvs list of patient for specific medecin
	// show list of rdvs in a specific medecin panel
	public List<Rdv> getAllRdvsByMedecin(int medecinId) {
	    List<Rdv> rdvList = new ArrayList<>();

	    Rdv rdv = null;

	    try {

	        String sql = "SELECT * FROM rdvs WHERE medecinId=?";
	        PreparedStatement pstmt = this.conn.prepareStatement(sql);

	        pstmt.setInt(1, medecinId);

	        ResultSet resultSet = pstmt.executeQuery();

	        while (resultSet.next()) {
	            rdv = new Rdv();

	            rdv.setId(resultSet.getInt(1)); // rdv id
	            rdv.setUserId(resultSet.getInt(2)); // userId
	            rdv.setNom(resultSet.getString(3));
	            rdv.setGendre(resultSet.getString(4));
	            rdv.setAge(resultSet.getString(5));
	            rdv.setDate(resultSet.getString(6));
	            rdv.setTemps(resultSet.getString(7));
	            rdv.setEmail(resultSet.getString(8));
	            rdv.setPhone(resultSet.getString(9));
	            rdv.setDiseases(resultSet.getString(10));
	            rdv.setMedcinId(resultSet.getInt(11));
	            rdv.setAddresse(resultSet.getString(12));
	            rdv.setStatus(resultSet.getString(13));

	            rdvList.add(rdv);
	        }

	    } catch (SQLException e) {
	        e.printStackTrace();
	    }

	    return rdvList;
	}
	
	
	
	// for medecin comment need specific rdv id
	public Rdv getRdvById(int id) {

	    Rdv rdv = null;

	    try {

	        String sql = "SELECT * FROM rdvs WHERE id=?";
	        PreparedStatement pstmt = this.conn.prepareStatement(sql);

	        pstmt.setInt(1, id);

	        ResultSet resultSet = pstmt.executeQuery();

	        while (resultSet.next()) {
	            rdv = new Rdv();

	            rdv.setId(resultSet.getInt(1)); // rdv id
	            rdv.setUserId(resultSet.getInt(2)); // userId
	            rdv.setNom(resultSet.getString(3));
	            rdv.setGendre(resultSet.getString(4));
	            rdv.setAge(resultSet.getString(5));
	            rdv.setDate(resultSet.getString(6));
	            rdv.setTemps(resultSet.getString(7));
	            rdv.setEmail(resultSet.getString(8));
	            rdv.setPhone(resultSet.getString(9));
	            rdv.setDiseases(resultSet.getString(10));
	            rdv.setMedcinId(resultSet.getInt(11));
	            rdv.setAddresse(resultSet.getString(12));
	            rdv.setStatus(resultSet.getString(13));
	        }

	    } catch (SQLException e) {
	        e.printStackTrace();
	    }

	    return rdv;
	}
	

	
	// for update comment status
	public boolean updateMedecinRdvCommentStatus(int rdvId, int medecinId, String comment) {

	    boolean isSuccess = false;

	    try {

	        String sql = "UPDATE rdvs SET status=? WHERE id=? AND medecinId=?";
	        PreparedStatement pstmt = this.conn.prepareStatement(sql);
	        pstmt.setString(1, comment);
	        pstmt.setInt(2, rdvId);
	        pstmt.setInt(3, medecinId);

	        pstmt.executeUpdate();

	        isSuccess = true;

	    } catch (SQLException e) {
	        e.printStackTrace();
	    }

	    return isSuccess;
	}

	
	// get all rdvs in admin panel
	public List<Rdv> getAllRdvs() {
	    List<Rdv> rdvList = new ArrayList<>();
	    Rdv rdv = null;

	    try {
	        String sql = "SELECT * FROM rdvs ORDER BY id DESC";
	        PreparedStatement pstmt = this.conn.prepareStatement(sql);

	        ResultSet resultSet = pstmt.executeQuery();

	        while (resultSet.next()) {
	            rdv = new Rdv();

	            rdv.setId(resultSet.getInt(1)); // rdv id
	            rdv.setUserId(resultSet.getInt(2)); // userId
	            rdv.setNom(resultSet.getString(3));
	            rdv.setGendre(resultSet.getString(4));
	            rdv.setAge(resultSet.getString(5));
	            rdv.setDate(resultSet.getString(6));
	            rdv.setTemps(resultSet.getString(7));
	            rdv.setEmail(resultSet.getString(8));
	            rdv.setPhone(resultSet.getString(9));
	            rdv.setDiseases(resultSet.getString(10));
	            rdv.setMedcinId(resultSet.getInt(11));
	            rdv.setAddresse(resultSet.getString(12));
	            rdv.setStatus(resultSet.getString(13));

	            rdvList.add(rdv);
	        }

	    } catch (SQLException e) {
	        e.printStackTrace();
	    }

	    return rdvList;
	}


	
	// delete rdv by id
	public boolean deleteRdvById(int rdvId) {
	    boolean isSuccess = false;

	    try {
	        String sql = "DELETE FROM rdvs WHERE id=?";
	        PreparedStatement pstmt = this.conn.prepareStatement(sql);
	        pstmt.setInt(1, rdvId);

	        int rowsAffected = pstmt.executeUpdate();
	        // if query deleted or all okay then
	        isSuccess = rowsAffected > 0;

	    } catch (SQLException e) {
	        e.printStackTrace();
	    }

	    return isSuccess;
	}

	
	// update rdv
	public boolean updateRdv(Rdv rdv) {
	    boolean isSuccess = false;

	    try {
	        String sql = "UPDATE rdvs SET userId=?, nom=?, gendre=?, age=?, date=?, temps=?, email=?, phone=?, diseases=?, medcinId=?, addresse=?, status=? WHERE id=?";
	        PreparedStatement pstmt = this.conn.prepareStatement(sql);

	        pstmt.setInt(1, rdv.getUserId());
	        pstmt.setString(2, rdv.getNom());
	        pstmt.setString(3, rdv.getGendre());
	        pstmt.setString(4, rdv.getAge());
	        pstmt.setString(5, rdv.getDate());
	        pstmt.setString(6, rdv.getTemps());
	        pstmt.setString(7, rdv.getEmail());
	        pstmt.setString(8, rdv.getPhone());
	        pstmt.setString(9, rdv.getDiseases());
	        pstmt.setInt(10, rdv.getMedcinId());
	        pstmt.setString(11, rdv.getAddresse());
	        pstmt.setString(12, rdv.getStatus());
	        pstmt.setInt(13, rdv.getId());

	        int rowsAffected = pstmt.executeUpdate();
	        // if query updated or all okay then
	        isSuccess = rowsAffected > 0;

	    } catch (SQLException e) {
	        e.printStackTrace();
	    }

	    return isSuccess;
	}


	/*
	// update rdv
	public boolean updateRdv(Rdv rdv) {
	    boolean isSuccess = false;

	    try {
	        String sql = "UPDATE rdvs SET userId=?, nom=?, gendre=?, age=?, date=?, email=?, phone=?, diseases=?, medecinId=?, addresse=?, status=? WHERE id=?";
	        PreparedStatement pstmt = this.conn.prepareStatement(sql);

	        pstmt.setInt(1, rdv.getUserId());
	        pstmt.setString(2, rdv.getNom());
	        pstmt.setString(3, rdv.getGendre());
	        pstmt.setString(4, rdv.getAge());
	        pstmt.setString(5, rdv.getDate());
	        pstmt.setString(6, rdv.getEmail());
	        pstmt.setString(7, rdv.getPhone());
	        pstmt.setString(8, rdv.getDiseases());
	        pstmt.setInt(9, rdv.getMedcinId());
	        pstmt.setString(10, rdv.getAddresse());
	        pstmt.setString(11, rdv.getStatus());
	        pstmt.setInt(12, rdv.getId());

	        int rowsAffected = pstmt.executeUpdate();
	        // if query updated or all okay then
	        isSuccess = rowsAffected > 0;

	    } catch (SQLException e) {
	        e.printStackTrace();
	    }

	    return isSuccess;
	}*/
	
	
	// Count total Rdv Number
	public int countTotalRdvs() {
	    int count = 0;

	    try {
	        String sql = "SELECT COUNT(*) FROM rdvs";
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

	
	
	// Count total Rdv Number for a specific medecin
	public int countTotalRdvsByMedecinId(int medecinId) {
	    int count = 0;

	    try {
	        String sql = "SELECT COUNT(*) FROM rdvs WHERE medecinId=?";
	        PreparedStatement pstmt = this.conn.prepareStatement(sql);
	        pstmt.setInt(1, medecinId);

	        ResultSet resultSet = pstmt.executeQuery();
	        if (resultSet.next()) {
	            count = resultSet.getInt(1);
	        }

	    } catch (SQLException e) {
	        e.printStackTrace();
	    }

	    return count;
	}
	
	
	
	
	// Count total Rdv Number for a specific user
	public int countTotalRdvsByUserId(int userId) {
	    int count = 0;

	    try {
	        String sql = "SELECT COUNT(*) FROM rdvs WHERE userId=?";
	        PreparedStatement pstmt = this.conn.prepareStatement(sql);
	        pstmt.setInt(1, userId);

	        ResultSet resultSet = pstmt.executeQuery();
	        if (resultSet.next()) {
	            count = resultSet.getInt(1);
	        }

	    } catch (SQLException e) {
	        e.printStackTrace();
	    }

	    return count;
	}




}
