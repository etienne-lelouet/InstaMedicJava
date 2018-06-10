package controleur;

public class Patient {

    private int idPatient, taille;
    private String nomPatient, prenomPatient, etat_civil, date_naissance, groupeSanguin, adresse, adressecomp,
            code_postal, Ville, email, telephone, urlphoto;

    public Patient() {
        this.idPatient = 0;
        this.taille = 0;

        this.etat_civil = "";
        this.nomPatient = "";
        this.prenomPatient = "";
        this.date_naissance = "";
        this.adresse = "";
        this.adressecomp = "";
        this.code_postal = "";
        this.Ville = "";
        this.email = "";
        this.telephone = "";
        this.urlphoto = "";
        this.groupeSanguin = "";
    }

    public Patient(int idPatient, int taille,
            String nomPatient, String prenomPatient,
            String etat_civil, String date_naissance,
            String adresse, String adressecomp, String code_postal, String Ville,
            String email, String telephone,
            String urlPhoto, String groupeSanguin) {

        this.idPatient = idPatient;
        this.taille = taille;

        this.etat_civil = etat_civil;
        this.nomPatient = nomPatient;
        this.prenomPatient = prenomPatient;
        this.date_naissance = date_naissance;
        this.adresse = adresse;
        this.adressecomp = adressecomp;
        this.code_postal = code_postal;
        this.Ville = Ville;
        this.email = email;
        this.telephone = telephone;
        this.urlphoto = urlPhoto;
        this.groupeSanguin = groupeSanguin;
    }

    public Patient(int idPatient, String nomPatient,
            String prenomPatient, String date_naissance) {
        this.idPatient = idPatient;
        this.nomPatient = nomPatient;
        this.prenomPatient = prenomPatient;
        this.date_naissance = date_naissance;
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

    public String getEtat_civil() {
        return etat_civil;
    }

    public void setEtat_civil(String etat_civil) {
        this.etat_civil = etat_civil;
    }

    public String getDate_naissance() {
        return date_naissance;
    }

    public void setDate_naissance(String date_naissance) {
        this.date_naissance = date_naissance;
    }

    public String getGroupeSanguin() {
        return groupeSanguin;
    }

    public void setGroupeSanguin(String groupeSanguin) {
        this.groupeSanguin = groupeSanguin;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getAdressecomp() {
        return adressecomp;
    }

    public void setAdressecomp(String adressecomp) {
        this.adressecomp = adressecomp;
    }

    public String getCode_postal() {
        return code_postal;
    }

    public void setCode_postal(String code_postal) {
        this.code_postal = code_postal;
    }

    public String getVille() {
        return Ville;
    }

    public void setVille(String Ville) {
        this.Ville = Ville;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getUrlphoto() {
        return urlphoto;
    }

    public void setUrlphoto(String urlphoto) {
        this.urlphoto = urlphoto;
    }

}
