package entity;

import java.io.Serializable;

public class Ville  implements Serializable {
	private int id;
	private String nom;
	private String description;
	
	public Ville(int id, String nom, String description) {
		super();
		this.id = id;
		this.nom = nom;
		this.description = description;
	}
	
	public Ville() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public String toString() {
		return "Ville [id=" + id + ", nom=" + nom + ", description=" + description + "]";
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
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	

}
