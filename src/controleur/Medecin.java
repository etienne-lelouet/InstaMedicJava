package controleur;

public class Medecin {

    private int idMedecin;
    private String nom, prenom, specialite;

    public Medecin() {
        this.idMedecin = 0;
        this.nom = this.prenom = this.specialite = "";
    }

    public Medecin(int idclient, String nom, String prenom, String specialite) {
        this.idMedecin = idclient;
        this.nom = nom;
        this.prenom = prenom;
        this.specialite = specialite;
    }

    public Medecin(String nom, String prenom, String specialite) {
        this.idMedecin = 0;
        this.nom = nom;
        this.prenom = prenom;
        this.specialite = specialite;
    }

    public int getIdMedecin() {
        return idMedecin;
    }

    public void setIdMedecin(int idMedecin) {
        this.idMedecin = idMedecin;
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

    public String getSpecialite() {
        return specialite;
    }

    public void setSpecialite(String specialite) {
        this.specialite = specialite;
    }

}
