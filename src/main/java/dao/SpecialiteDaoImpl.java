package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


import entity.Specialite;

public class SpecialiteDaoImpl implements SpecialiteDao{
	
	private Connection conn;

	public SpecialiteDaoImpl(Connection conn) {
		super();
		this.conn = conn;
	}
	
	public boolean addSpecialite(String sp) {
		
		boolean isSuccess = false;
		
		try {
			
			String sql = "insert into specialites (nom, description) values(?, ?)";
			PreparedStatement pstmt = this.conn.prepareStatement(sql);
			
			pstmt.setString(1, sp);
			
			pstmt.executeUpdate();
			
			isSuccess = true;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return isSuccess;
	}
	
	
	public List<Specialite> getAllSpecialite(){
		
		List<Specialite> spList = new ArrayList<Specialite>();
		
		Specialite specialiteObj = null;
		
		try {
			
			String sql = "select * from specialites";
			PreparedStatement pstmt = this.conn.prepareStatement(sql);
			ResultSet resultSet = pstmt.executeQuery();
			
			while(resultSet.next()) {
				
				//create object
				specialiteObj = new Specialite();
				//specialistObj.setId(resultSet.getInt("id"));
				//specialistObj.setNom(resultSet.getString("nom"));
				//specialistObj.setDescription(resultSet.getString("description"));
				//above two line same as below line
				specialiteObj.setId(resultSet.getInt(1));//column index number 1 -(id)
				specialiteObj.setNom(resultSet.getString(2));//column index number 2 -(nom)
				specialiteObj.setDescription(resultSet.getString(3));//column index number 3 -(description)
				
				//now add Specialite object into List 
				spList.add(specialiteObj);
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		return spList;
	}
	
	// Count total Specialist Number
	public int countTotalSpecialite() {

		int i = 0;

		try {

			String sql = "select * from specialites";
			PreparedStatement pstmt = this.conn.prepareStatement(sql);

			ResultSet resultSet = pstmt.executeQuery();
			while (resultSet.next()) {

				i++;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return i;
	}

}
