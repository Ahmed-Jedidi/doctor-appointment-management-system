package medecin.servlet;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import entity.Medecin;



public class MedecinModel implements Serializable {
	private String nom;
	private String specialite;
	private String adresse;
	private List<Medecin> medecins = new ArrayList<Medecin>();
	
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getSpecialite() {
		return specialite;
	}
	public void setSpecialite(String specialite) {
		this.specialite = specialite;
	}
	public String getAdresse() {
		return adresse;
	}
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	public List<Medecin> getMedecins() {
		return medecins;
	}
	public void setMedecins(List<Medecin> medecins) {
		this.medecins = medecins;
	}
	
	
}
