package Beans;

import java.sql.Date;

public class Admin {
	private String id;
	
	public  Admin() {
		
		super();
		
	}
	
	public Admin(String id, String nom, String mot_de_passe) {
		super();
		this.id = id;
		this.nom = nom;
		this.mot_de_passe = mot_de_passe;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getMot_de_passe() {
		return mot_de_passe;
	}

	public void setMot_de_passe(String mot_de_passe) {
		this.mot_de_passe = mot_de_passe;
	}

	private String nom;
	
	private String mot_de_passe;
	
	
	
}