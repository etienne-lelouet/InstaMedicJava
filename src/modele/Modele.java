package modele;

import controleur.Commentaire;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import controleur.Medecin;
import controleur.Patient;
import controleur.Technicien;
import java.sql.PreparedStatement;

public class Modele {

    public static Medecin Connexion(String login, String mdp) {
        int id = 0;
        String nom = null, prenom = null, libelle = null;
        String requete = "SELECT t1.idPersonne, t1.nom, t1.prenom, t2.idSpecialite, t3.libelle"
                + " FROM Personne t1, Medecin t2, Specialite t3"
                + " WHERE t1.idPersonne = t2.idPersonne"
                + " AND t2.idSpecialite = t3.idSpecialite"
                + " AND STATUS =2"
                + " AND login =\"" + login + "\" "
                + " AND PASSWORD =\"" + mdp + "\"";

        Bdd uneBdd = new Bdd();
        System.out.println(requete);
        try {
            uneBdd.seConnecter();
            Statement unStat = uneBdd.getMaConnexion().createStatement();
            ResultSet unRes = unStat.executeQuery(requete);
            unRes.last();
            int rows = unRes.getRow();
            unRes.beforeFirst();
            System.out.println(rows);

            if (rows != 1) {
                System.out.println("non");
                Medecin unMedecin = new Medecin();
                return unMedecin;
            }
            if (unRes.next()) {
                System.out.println("oui");
                id = unRes.getInt("idPersonne");
                nom = unRes.getString("nom");
                prenom = unRes.getString("prenom");
                libelle = unRes.getString("nom");
            }
            Medecin unMedecin = new Medecin(id, nom, prenom, libelle);

            unRes.close();
            unStat.close();
            uneBdd.seDeConnceter();
            return unMedecin;
        } catch (SQLException exp) {
            System.out.println(requete);
            System.out.println(exp);
            Medecin unMedecin = new Medecin();
            return unMedecin;
        }
    }

    //Modele des patients
    public static ArrayList<Patient> selectAllPatients(Medecin unMedecin) {
        ArrayList<Patient> lesPatients = new ArrayList<Patient>();
        String requete = " SELECT t2.*, t3.* FROM lien t1, Personne t2, DonnesBiologiques t3 "
                + " WHERE t1.idMedecin = " + unMedecin.getIdMedecin()
                + " AND t1.idPatient = t2.idPersonne AND t1.idPatient = t3.idPersonne ORDER BY nom ASC";
        Bdd uneBdd = new Bdd();
        try {
            uneBdd.seConnecter();
            Statement unStat = uneBdd.getMaConnexion().createStatement();
            ResultSet unRes = unStat.executeQuery(requete);
            while (unRes.next()) {
                int idPatient = unRes.getInt("idPersonne");
                int poids = unRes.getInt("poids");
                int taille = unRes.getInt("Taille");
                String etat_civil = unRes.getString("etat_civil");
                String nom = unRes.getString("nom");
                String prenom = unRes.getString("prenom");
                String date_naissance = unRes.getString("date_naissance");
                String adresse = unRes.getString("adresse");
                String adressecomp = unRes.getString("adressecomp");
                String code_postal = unRes.getString("code_postal");
                String Ville = unRes.getString("Ville");
                String telephone = unRes.getString("telephone");
                String email = unRes.getString("email");
                String urlphoto = unRes.getString("urlphoto");
                String GroupeSanguin = unRes.getString("GroupeSanguin");
                Patient unPatient = new Patient(idPatient, taille, poids, nom, prenom, etat_civil, date_naissance, adresse, adressecomp, code_postal, Ville, email, telephone, urlphoto, GroupeSanguin);
                lesPatients.add(unPatient);
            }
            unStat.close();
            unRes.close();
            uneBdd.seDeConnceter();
        } catch (SQLException exp) {
            System.out.println("Erreur : " + requete);
            System.out.println("Erreur : " + exp);
        }
        return lesPatients;
    }

    public static ArrayList<Commentaire> selectAllMessages(Patient unPatient) {
        ArrayList<Commentaire> lesCommentaires = new ArrayList<Commentaire>();
        String requete = "SELECT t1.* , t2.nom, t2.prenom"
                + " FROM DonneesMedicales t1, Personne t2"
                + " WHERE idPatient = " + unPatient.getIdPatient() + " AND t1.idMedecin = t2.idPersonne";
        Bdd uneBdd = new Bdd();
        try {
            uneBdd.seConnecter();
            Statement unStat = uneBdd.getMaConnexion().createStatement();
            ResultSet unRes = unStat.executeQuery(requete);
            while (unRes.next()) {
                int idDonneesMedicales = unRes.getInt("idDonneesMedicales");
                int idPatient = unRes.getInt("idPatient");
                int idMedecin = unRes.getInt("idMedecin");
                String nom = unRes.getString("nom");
                String prenom = unRes.getString("prenom");
                String contenu = unRes.getString("contenu");
                Commentaire unCommentaire = new Commentaire(idDonneesMedicales, idPatient, idMedecin, contenu, nom, prenom);
                lesCommentaires.add(unCommentaire);
            }
            unStat.close();
            unRes.close();
            uneBdd.seDeConnceter();
        } catch (SQLException exp) {
            System.out.println("Erreur : " + requete);
            System.out.println("Erreur : " + exp);
        }
        return lesCommentaires;
    }

    public static Patient getPatientById(int id) {
        Patient unPatient = new Patient();
        String requete = "SELECT t1.*, t2.* FROM Personne t1, DonnesBiologiques t2 WHERE t1.idPersonne = " + id + " AND t2.idPersonne = t1.idPersonne";
        Bdd uneBdd = new Bdd();
        try {
            uneBdd.seConnecter();
            Statement unStat = uneBdd.getMaConnexion().createStatement();
            ResultSet unRes = unStat.executeQuery(requete);
            while (unRes.next()) {
                int idPatient = unRes.getInt("idPersonne");
                int poids = unRes.getInt("poids");
                int taille = unRes.getInt("Taille");
                String etat_civil = unRes.getString("etat_civil");
                String nom = unRes.getString("nom");
                String prenom = unRes.getString("prenom");
                String date_naissance = unRes.getString("date_naissance");
                String adresse = unRes.getString("adresse");
                String adressecomp = unRes.getString("adressecomp");
                String code_postal = unRes.getString("code_postal");
                String Ville = unRes.getString("Ville");
                String telephone = unRes.getString("telephone");
                String email = unRes.getString("email");
                String urlphoto = unRes.getString("urlphoto");
                String GroupeSanguin = unRes.getString("GroupeSanguin");
                unPatient = new Patient(idPatient, taille, poids, nom, prenom, etat_civil, date_naissance, adresse, adressecomp, code_postal, Ville, email, telephone, urlphoto, GroupeSanguin);
            }
        } catch (SQLException e) {
            System.out.println(requete);
        }
        return unPatient;
    }

    public static int insertCommentaire(Commentaire unCommentaire) {
        int id = 0;
        String requete = "INSERT INTO DonneesMedicales VALUES (null, ?, ?, ?);";
        Bdd uneBdd = new Bdd();
        try {
            uneBdd.seConnecter();
            PreparedStatement ps = uneBdd.getMaConnexion().prepareStatement(requete, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, unCommentaire.getContenu());
            ps.setInt(2, unCommentaire.getIdPatient());
            ps.setInt(3, unCommentaire.getIdMedecin());
            ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys();

            if (rs.next()) {
                id = rs.getInt(1);
            }
            ps.close();
            uneBdd.seDeConnceter();
        } catch (Exception exp) {
            System.out.println("Erreur : " + requete);
            System.out.println("Erreur : " + exp);
        }
        return id;
    }

    public static boolean verifyAuthorization(int idMessage, int idMedecin) {
        String requete = "SELECT * FROM DonneesMedicales WHERE idDonneesMedicales = ? AND idMedecin = ?;";
        Bdd uneBdd = new Bdd();
        try {
            uneBdd.seConnecter();
            PreparedStatement ps = uneBdd.getMaConnexion().prepareStatement(requete);
            ps.setInt(1, idMessage);
            ps.setInt(2, idMedecin);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                return true;
            }
            uneBdd.seDeConnceter();
        } catch (SQLException exp) {
            System.out.println("Erreur : " + requete);
            System.out.println("Erreur : " + exp);
        }
        return false;
    }

    public static void deleteCommentaire(Commentaire unCommentaire) {
        String requete = "DELETE FROM DonneesMedicales where idDonneesMedicales = ?;";
        Bdd uneBdd = new Bdd();
        try {
            uneBdd.seConnecter();
            PreparedStatement ps = uneBdd.getMaConnexion().prepareStatement(requete);
            ps.setInt(1, unCommentaire.getIdCommentaire());
            ps.executeUpdate();
            uneBdd.seDeConnceter();
        } catch (Exception exp) {
            System.out.println("Erreur : " + requete);
            System.out.println("Erreur : " + exp);
        }
    }

    public static void updateCommentaire(Commentaire unCommentaire) {
        String requete = "UPDATE DonneesMedicales "
                + " SET contenu = ? where idDonneesMedicales = ?;";
        Bdd uneBdd = new Bdd();
        try {
            uneBdd.seConnecter();
            PreparedStatement ps = uneBdd.getMaConnexion().prepareStatement(requete);
            ps.setString(1, unCommentaire.getContenu());
            ps.setInt(2, unCommentaire.getIdCommentaire());
            ps.executeUpdate();
            uneBdd.seDeConnceter();
        } catch (Exception exp) {
            System.out.println("Erreur : " + requete);
            System.out.println("Erreur : " + exp);
        }
    }
//    /**

    /* ********* Modele des Techniciens ****************
     */
    public static ArrayList<Technicien> selectAllTechniciens() {
        ArrayList<Technicien> lesTechniciens = new ArrayList<Technicien>();
        String requete = "Select * from technicien ; ";
        Bdd uneBdd = new Bdd();
        try {
            uneBdd.seConnecter();
            Statement unStat = uneBdd.getMaConnexion().createStatement();
            ResultSet unRes = unStat.executeQuery(requete);
            while (unRes.next()) {
                int idTech = unRes.getInt("idtech");
                String nom = unRes.getString("nom");
                String prenom = unRes.getString("prenom");
                String competence = unRes.getString("competence");
                Technicien unTechnicien = new Technicien(idTech, nom, prenom, competence);
                lesTechniciens.add(unTechnicien);
            }
            unStat.close();
            unRes.close();
            uneBdd.seDeConnceter();
        } catch (Exception exp) {
            System.out.println("Erreur : " + requete);
        }
        return lesTechniciens;
    }

    public static Technicien selectWhereTechnicien(Technicien unTechnicien) {
        String requete = "Select * from Technicien where idtech = " + unTechnicien.getIdTech();
        Technicien unTechResultat = null;
        Bdd uneBdd = new Bdd();
        try {
            uneBdd.seConnecter();
            Statement unStat = uneBdd.getMaConnexion().createStatement();
            ResultSet unRes = unStat.executeQuery(requete);
            while (unRes.next()) {
                int idTech = unRes.getInt("idtech");
                String nom = unRes.getString("nom");
                String prenom = unRes.getString("prenom");
                String competence = unRes.getString("competence");
                unTechResultat = new Technicien(idTech, nom, prenom, competence);
            }
            unStat.close();
            unRes.close();
            uneBdd.seDeConnceter();
        } catch (Exception exp) {
            System.out.println("Erreur : " + requete);
        }
        return unTechResultat;
    }

    public static String cleanString(String string) {
        string = string.replaceAll("'", "\'");
        return string;
    }

}
