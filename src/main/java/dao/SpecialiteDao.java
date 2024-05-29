package dao;

import java.util.List;

import entity.Specialite;

public interface SpecialiteDao {
	
	public boolean addSpecialite(String sp);
	
	public List<Specialite> getAllSpecialite();
	
	public int countTotalSpecialite();

}
