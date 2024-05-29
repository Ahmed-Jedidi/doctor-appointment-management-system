package entity;

import java.io.Serializable;

public class User implements Serializable {
	private int id;
	private String nom;
	private String email;
	private String password;
	
	@Override
	public String toString() {
		return "User [id=" + id + ", nom=" + nom + ", email=" + email + ", password=" + password + "]";
	}
	
	public User(String nom, String email, String password) {
		super();
		this.nom = nom;
		this.email = email;
		this.password = password;
	}
	
	public User(int id, String nom, String email, String password) {
		super();
		this.id = id;
		this.nom = nom;
		this.email = email;
		this.password = password;
	}
	
	public User() {
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
	
	
}
