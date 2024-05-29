package dao;

import java.util.List;

import entity.Rdv;

public interface RdvDao {
	
	public boolean addRdv(Rdv rdv);
	
	public List<Rdv> getAllRdvsByUser(int userId);
	
	public List<Rdv> getAllRdvsByMedecin(int medecinId);
	
	public Rdv getRdvById(int id);
	
	public boolean updateMedecinRdvCommentStatus(int rdvId, int medecinId, String comment);
	
	public List<Rdv> getAllRdvs();
	
	public boolean deleteRdvById(int rdvId);
	
	public boolean updateRdv(Rdv rdv);
	
	public int countTotalRdvs();
	
	public int countTotalRdvsByUserId(int userId);

}
