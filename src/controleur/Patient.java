package controleur;
public class Patient {

	private int idPatient, taille;
	private String nomPatient, prenomPatient, groupeSanguin, adresse, adressecomp, 
                code_postal, ville, email, telephone, urlphoto;
	private float poids;
	
	public Patient()
	{
		this.idPatient=this.taille=0;
		this.nomPatient=this.prenomPatient=this.groupeSanguin="";
		this.poids=0;
	}
	
	public Patient(int taille, String nomPatient, 
			String prenomPatient, String groupeSanguin, float poids)
	{
		this.idPatient=0;
		this.nomPatient=nomPatient;
		this.prenomPatient=prenomPatient;
		this.groupeSanguin=groupeSanguin;
		this.poids=poids;
	}
	
	public Patient(int idPatient, int taille, String nomPatient,
                        String etat_civil, String date_naissance,
                       String adresse, String email, String telephone,
                       String urlPhoto,
			String prenomPatient, String groupeSanguin, float poids)
	{
		this.idPatient=idPatient;
		this.nomPatient=nomPatient;
		this.prenomPatient=prenomPatient;
		this.groupeSanguin=groupeSanguin;
		this.poids=poids;
	}

	public int getIdPatient() {
		return idPatient;
	}

	public void setIdPatient(int idPatient) {
		this.idPatient = idPatient;
	}

	public int getTaille() {
		return taille;
	}

	public void setTaille(int taille) {
		this.taille = taille;
	}

	public String getNomPatient() {
		return nomPatient;
	}

	public void setNomPatient(String nomPatient) {
		this.nomPatient = nomPatient;
	}

	public String getPrenomPatient() {
		return prenomPatient;
	}

	public void setPrenomPatient(String prenomPatient) {
		this.prenomPatient = prenomPatient;
	}

	public String getGroupeSanguin() {
		return groupeSanguin;
	}

	public void setGroupeSanguin(String groupeSanguin) {
		this.groupeSanguin = groupeSanguin;
	}

	public float getPoids() {
		return poids;
	}

	public void setPoids(float poids) {
		this.poids = poids;
	}

	
}
