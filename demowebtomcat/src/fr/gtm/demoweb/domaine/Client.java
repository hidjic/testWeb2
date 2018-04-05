package fr.gtm.demoweb.domaine;

public class Client {
	
	private int id;
	private String nom;
	private String prenom;
	private String email;
	private String adresse;
	private String phoneNumber;
	
	// constructeur vide
	public Client() {
		super();
	}
	// constructeur pour la creation
	public Client(int id, String nom, String prenom, String email, String adresse, String phoneNumber) {
		super();
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.adresse = adresse;
		this.phoneNumber = phoneNumber;
	}
	
	// constructeur pour update
	public Client(int id) {
		super();
		this.id = id;
	}


	// getters et setters
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAdresse() {
		return adresse;
	}
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
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
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}



	public String toString() {
		return "Client : id = "+this.getId()+",nom = "+this.getNom()+", prenom = "+this.getPrenom();
	}
	
}
