package Beans;

import java.sql.Date;

public class Utilisateur {
	private Long id;
	private String prenom;
	private String nom;
	private Date date_naissance;
	private String email;
	private String Ville;
	private String mot_de_passe;
	private String categorie;
	private String sous_categorie;
	private Integer valide;
	private Integer portee_1;
	private Integer portee_2;
	private Integer portee_3;
	private Integer portee_4;
	private Date date_inscription;
	private String valide_hash;
	private Date date_connexion;
	
	
	public Utilisateur(Long id, String prenom, String nom, Date date_naissance, String email, String mot_de_passe,
			String categorie, String sous_categorie, Integer valide, Integer portee_1, Integer portee_2,
			Integer portee_3, Integer portee_4, Date date_inscription, String valide_hash,Date date_connexion) {
		super();
		this.id = id;
		this.prenom = prenom;
		this.nom = nom;
		this.date_naissance = date_naissance;
		this.email = email;
		this.mot_de_passe = mot_de_passe;
		this.categorie = categorie;
		this.sous_categorie = sous_categorie;
		this.valide = valide;
		this.portee_1 = portee_1;
		this.portee_2 = portee_2;
		this.portee_3 = portee_3;
		this.portee_4 = portee_4;
		this.date_inscription = date_inscription;
		this.valide_hash = valide_hash;
		this.date_connexion=date_connexion;
	}
	
	public Date getDate_connexion() {
		return date_connexion;
	}

	public void setDate_connexion(Date date_connexion) {
		this.date_connexion = date_connexion;
	}

	public Utilisateur() {
		// TODO Auto-generated constructor stub
	}

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public Date getDate_naissance() {
		return date_naissance;
	}
	public void setDate_naissance(Date date_naissance) {
		this.date_naissance = date_naissance;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getVille() {
		return Ville;
	}

	public void setVille(String ville) {
		Ville = ville;
	}

	public String getMot_de_passe() {
		return mot_de_passe;
	}
	public void setMot_de_passe(String mot_de_passe) {
		this.mot_de_passe = mot_de_passe;
	}
	public String getCategorie() {
		return categorie;
	}
	public void setCategorie(String categorie) {
		this.categorie = categorie;
	}
	public String getSous_categorie() {
		return sous_categorie;
	}
	public void setSous_categorie(String sous_categorie) {
		this.sous_categorie = sous_categorie;
	}
	public Integer getValide() {
		return valide;
	}
	public void setValide(Integer valide) {
		this.valide = valide;
	}
	public Integer getPortee_1() {
		return portee_1;
	}
	public void setPortee_1(Integer portee_1) {
		this.portee_1 = portee_1;
	}
	public Integer getPortee_2() {
		return portee_2;
	}
	public void setPortee_2(Integer portee_2) {
		this.portee_2 = portee_2;
	}
	public Integer getPortee_3() {
		return portee_3;
	}
	public void setPortee_3(Integer portee_3) {
		this.portee_3 = portee_3;
	}
	public Integer getPortee_4() {
		return portee_4;
	}
	public void setPortee_4(Integer portee_4) {
		this.portee_4 = portee_4;
	}
	public Date getDate_inscription() {
		return date_inscription;
	}
	public void setDate_inscription(Date date_inscription) {
		this.date_inscription = date_inscription;
	}
	public String getValide_hash() {
		return valide_hash;
	}
	public void setValide_hash(String valide_hash) {
		this.valide_hash = valide_hash;
	}
}
