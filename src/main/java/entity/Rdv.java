package entity;

import java.io.Serializable;

public class Rdv implements Serializable {
	
	private int id;
	private int userId;
	private String nom;
	private String gendre;
	private String age;
	private String date;
	private String temps;
	private String email;
	private String phone;
	private String diseases;
	private int medcinId;
	private String addresse;
	private String status;
	@Override
	public String toString() {
		return "Rdv [id=" + id + ", userId=" + userId + ", nom=" + nom + ", gendre=" + gendre + ", age=" + age
				+ ", date=" + date + ", temps=" + temps + ", email=" + email + ", phone=" + phone + ", diseases="
				+ diseases + ", medcinId=" + medcinId + ", addresse=" + addresse + ", status=" + status + "]";
	}
	public Rdv() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Rdv(int userId, String nom, String gendre, String age, String date, String temps, String email, String phone,
			String diseases, int medcinId, String addresse, String status) {
		super();
		this.userId = userId;
		this.nom = nom;
		this.gendre = gendre;
		this.age = age;
		this.date = date;
		this.temps = temps;
		this.email = email;
		this.phone = phone;
		this.diseases = diseases;
		this.medcinId = medcinId;
		this.addresse = addresse;
		this.status = status;
	}
	public Rdv(int id, int userId, String nom, String gendre, String age, String date, String temps, String email,
			String phone, String diseases, int medcinId, String addresse, String status) {
		super();
		this.id = id;
		this.userId = userId;
		this.nom = nom;
		this.gendre = gendre;
		this.age = age;
		this.date = date;
		this.temps = temps;
		this.email = email;
		this.phone = phone;
		this.diseases = diseases;
		this.medcinId = medcinId;
		this.addresse = addresse;
		this.status = status;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getGendre() {
		return gendre;
	}
	public void setGendre(String gendre) {
		this.gendre = gendre;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getTemps() {
		return temps;
	}
	public void setTemps(String temps) {
		this.temps = temps;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getDiseases() {
		return diseases;
	}
	public void setDiseases(String diseases) {
		this.diseases = diseases;
	}
	public int getMedcinId() {
		return medcinId;
	}
	public void setMedcinId(int medcinId) {
		this.medcinId = medcinId;
	}
	public String getAddresse() {
		return addresse;
	}
	public void setAddresse(String addresse) {
		this.addresse = addresse;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}

	
}
