package entity;

import java.io.Serializable;

public class Specialite  implements Serializable {
	
	private int id;
	private String nom;
	private String description;
	
	
	public Specialite(int id, String nom, String description) {
		super();
		this.id = id;
		this.nom = nom;
		this.description = description;
	}

	public Specialite() {
		super();
	}
	
	@Override
	public String toString() {
		return "Specialite [id=" + id + ", nom=" + nom + "]";
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
