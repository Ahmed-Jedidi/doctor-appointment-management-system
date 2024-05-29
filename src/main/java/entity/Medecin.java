package entity;

import java.io.Serializable;

public class Medecin implements Serializable {
	
	private int id;
	private String nom;
	private String email;
	private String password;
	private String phone;
	private String naissance;
	private String ville;
	private String adresse;
	private String specialite;
	private String qualification;
	
	@Override
	public String toString() {
		return "Medecin [id=" + id + ", nom=" + nom + ", email=" + email + ", password=" + password + ", phone=" + phone
				+ ", naissance=" + naissance + ", ville=" + ville + ", adresse=" + adresse + ", specialite="
				+ specialite + ", qualification=" + qualification + "]";
	}
	public Medecin(int id, String nom, String email, String password, String phone, String naissance, String ville,
			String adresse, String specialite, String qualification) {
		super();
		this.id = id;
		this.nom = nom;
		this.email = email;
		this.password = password;
		this.phone = phone;
		this.naissance = naissance;
		this.ville = ville;
		this.adresse = adresse;
		this.specialite = specialite;
		this.qualification = qualification;
	}
	public Medecin(String nom, String email, String password, String phone, String naissance, String ville,
			String adresse, String specialite, String qualification) {
		super();
		this.nom = nom;
		this.email = email;
		this.password = password;
		this.phone = phone;
		this.naissance = naissance;
		this.ville = ville;
		this.adresse = adresse;
		this.specialite = specialite;
		this.qualification = qualification;
	}
	public Medecin() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getNaissance() {
		return naissance;
	}
	public void setNaissance(String naissance) {
		this.naissance = naissance;
	}
	public String getVille() {
		return ville;
	}
	public void setVille(String ville) {
		this.ville = ville;
	}
	public String getAdresse() {
		return adresse;
	}
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	public String getSpecialite() {
		return specialite;
	}
	public void setSpecialite(String specialite) {
		this.specialite = specialite;
	}
	public String getQualification() {
		return qualification;
	}
	public void setQualification(String qualification) {
		this.qualification = qualification;
	}
	
	

}
