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
public class Prescription {

    private int idPrescription;
    private int idMedicament;
    private int idMedecin;
    private int idPatient;
    private String dateDebut;
    private String dateFin;
    private String commentaire;
    private String nomMedecin;
    private String prenomMedecin;
    private String nomMedicament;

    public String getNomMedicament() {
        return nomMedicament;
    }

    public void setNomMedicament(String nomMedicament) {
        this.nomMedicament = nomMedicament;
    }

    public Prescription(int idMedicament, int idMedecin, int idPatient, String dateDebut, String dateFin, String commentaire) {
        this.idMedicament = idMedicament;
        this.idMedecin = idMedecin;
        this.idPatient = idPatient;
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
        this.commentaire = commentaire;
    }

    public Prescription(int idPrescription, String nomMedecin, String prenomMedecin, String nomMedicament,
            String dateDebut, String dateFin, String commentaire
    ) {
        this.idPrescription = idPrescription;
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
        this.commentaire = commentaire;
        this.nomMedecin = nomMedecin;
        this.prenomMedecin = prenomMedecin;
        this.nomMedicament = nomMedicament;
    }

    public int getIdPrescription() {
        return idPrescription;
    }

    public void setIdPrescription(int idPrescription) {
        this.idPrescription = idPrescription;
    }

    public int getIdMedicament() {
        return idMedicament;
    }

    public void setIdMedicament(int idMedicament) {
        this.idMedicament = idMedicament;
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

    public String getDateDebut() {
        return dateDebut;
    }

    public void setDateDebut(String dateDebut) {
        this.dateDebut = dateDebut;
    }

    public String getDateFin() {
        return dateFin;
    }

    public void setDateFin(String dateFin) {
        this.dateFin = dateFin;
    }

    public String getCommentaire() {
        return commentaire;
    }

    public void setCommentaire(String commentaire) {
        this.commentaire = commentaire;
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
