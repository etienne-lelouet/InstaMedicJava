package controleur;

public class Technicien {
	private int idTech;
	private String nom, prenom, competence;
	
	public Technicien() 
	{
		this.idTech = 0;
		this.nom = "";
		this.prenom = "";
		this.competence = "";
	}
	
	public Technicien(int idTech, String nom, String prenom, String competence)
	{
		this.idTech = idTech;
		this.nom = nom;
		this.prenom = prenom;
		this.competence = competence;
	}
	
	public Technicien (String nom, String prenom, String competence)
	{
		this.idTech = 0;
		this.nom = nom;
		this.prenom = prenom;
		this.competence = competence;
	}

	public int getIdTech() {
		return idTech;
	}

	public void setIdTech(int idTech) {
		this.idTech = idTech;
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

	public String getCompetence() {
		return competence;
	}

	public void setCompetence(String competence) {
		this.competence = competence;
	}

}
