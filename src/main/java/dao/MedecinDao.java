package dao;

import java.util.List;

import entity.Medecin;

public interface MedecinDao {
	
	public List<Medecin> getMedecinParMotcle(String nom,String specialite,String adresse);
	
	public boolean ajouterMedecin(Medecin medecin);
	
	public List<Medecin> getAllMedecins();
	
	public Medecin getMedecinById(int id);
	
	public boolean updateMedecin(Medecin medecin);
	
	public boolean deleteMedecinById(int id);
	
	public Medecin loginMedecin(String email, String password);
	
	public int countTotalMedecin();
	
	public boolean checkOldPassword(int medecinId, String oldPassword);
	
	public boolean changePassword(int medecinId, String newPassword);
	
	public boolean editMedecinProfile(Medecin medecin);
	
	
	
	
	
}
