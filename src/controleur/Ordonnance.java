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
public class Ordonnance {

    private int idMedecin, idPatient;
    private String contenu;

    public Ordonnance() {
        this.idMedecin = this.idPatient = 0;
        this.contenu = "";
    }

    public Ordonnance(int idPatient, int idMedecin, String contenu) {
        this.idPatient = idPatient;
        this.idMedecin = idMedecin;
        this.contenu = contenu;
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


}
