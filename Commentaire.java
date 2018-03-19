/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controleur;

/**
 *
 * @author etien
 */
public class Commentaire {

    private int idCommentaire, idMedecin, idPatient;
    private String contenu, nomMedecin, prenomMedecin;

    public Commentaire() {
        this.idCommentaire = this.idMedecin = this.idPatient = 0;
        this.contenu = this.nomMedecin = this.prenomMedecin = "";
    }

    public Commentaire(int idPatient, int idMedecin, String contenu, String nomMedecin, String prenomMedecin) {
        this.idPatient = idPatient;
        this.idMedecin = idMedecin;
        this.contenu = contenu;
        this.nomMedecin = nomMedecin;
        this.prenomMedecin = prenomMedecin;
    }

    public Commentaire(int idPatient, int idMedecin, String contenu) {
        this.idPatient = idPatient;
        this.idMedecin = idMedecin;
        this.contenu = contenu;
    }

    public Commentaire(int idCommentaire, int idPatient, int idMedecin, String contenu, String nomMedecin, String prenomMedecin) {
        this.idCommentaire = idCommentaire;
        this.idPatient = idPatient;
        this.idMedecin = idMedecin;
        this.contenu = contenu;
        this.nomMedecin = nomMedecin;
        this.prenomMedecin = prenomMedecin;
    }

    public int getIdCommentaire() {
        return idCommentaire;
    }

    public void setIdCommentaire(int idCommentaire) {
        this.idCommentaire = idCommentaire;
    }

    public int getIdMedecin() {
        return idMedecin;
    }

    public void setIdMedecin(int idMedecin) {
        this.idMedecin = idMedecin;
    }

    public int getIdPatient() {
        return idPatient;
    }

    public void setIdPatient(int idPatient) {
        this.idPatient = idPatient;
    }

    public String getContenu() {
        return contenu;
    }

    public void setContenu(String contenu) {
        this.contenu = contenu;
    }

    public String getNomMedecin() {
        return nomMedecin;
    }

    public void setNomMedecin(String nomMedecin) {
        this.nomMedecin = nomMedecin;
    }

    public String getPrenomMedecin() {
        return prenomMedecin;
    }

    public void setPrenomMedecin(String prenomMedecin) {
        this.prenomMedecin = prenomMedecin;
    }

}
