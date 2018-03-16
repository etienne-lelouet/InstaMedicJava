package modele;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import controleur.Medecin;
import controleur.Patient;
import controleur.Technicien;

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
//    public static ArrayList<Patient> selectAllPatients(Medecin unMedecin) {
//        ArrayList<Patient> lesClients = new ArrayList<Patient>();
//        String requete = "SELECT t2.nom, t2.prenom, t3.iddossier" +
//                        " FROM lien t1, Personne t2, Patient t3" +
//                        " WHERE t1.idMedecin =" + unMedecin.getIdMedecin() +
//                        " AND t1.idPatient = t2.idPersonne" +
//                        " AND t1.idPatient = t3.idPersonne" +
//                        " ORDER BY nom ASC";
//        Bdd uneBdd = new Bdd();
//        try {
//            uneBdd.seConnecter();
//            Statement unStat = uneBdd.getMaConnexion().createStatement();
//            ResultSet unRes = unStat.executeQuery(requete);
//            while (unRes.next()) {
//                int idclient = unRes.getInt("idclient");
//                String nom = unRes.getString("nom");
//                String prenom = unRes.getString("prenom");
//                String adresse = unRes.getString("adressse");
//                Patient unPatient = new Patient(idclient, nom, prenom, adresse);
//                lesClients.add(unPatient);
//            }
//            unStat.close();
//            unRes.close();
//            uneBdd.seDeConnceter();
//        } catch (SQLException exp) {
//            System.out.println("Erreur : " + requete);
//        }
//        return lesClients;
//    }

//    public static ArrayList<Patient> selectAllPatients(Medecin unMedecin) {
//        ArrayList<Patient> lesClients = new ArrayList<Patient>();
//        String requete = "SELECT t2.nom, t2.prenom, t3.iddossier" +
//                        " FROM lien t1, Personne t2, Patient t3" +
//                        " WHERE t1.idMedecin =" + unMedecin.getIdMedecin() +
//                        " AND t1.idPatient = t2.idPersonne" +
//                        " AND t1.idPatient = t3.idPersonne" +
//                        " ORDER BY nom ASC";
//        Bdd uneBdd = new Bdd();
//        try {
//            uneBdd.seConnecter();
//            Statement unStat = uneBdd.getMaConnexion().createStatement();
//            ResultSet unRes = unStat.executeQuery(requete);
//            while (unRes.next()) {
//                int idclient = unRes.getInt("idclient");
//                String nom = unRes.getString("nom");
//                String prenom = unRes.getString("prenom");
//                String adresse = unRes.getString("adressse");
//                Patient unPatient = new Patient(idclient, nom, prenom, adresse);
//                lesClients.add(unPatient);
//            }
//            unStat.close();
//            unRes.close();
//            uneBdd.seDeConnceter();
//        } catch (SQLException exp) {
//            System.out.println("Erreur : " + requete);
//        }
//        return lesClients;
//    }
//
//    public static void insertClient(Client unClient) {
//        String requete = "insert into client values (null, '" + unClient.getNom()
//                + "','" + unClient.getPrenom()
//                + "','" + unClient.getAdresse() + "');";
//        Bdd uneBdd = new Bdd(host, bdd, user, password);
//        try {
//            uneBdd.seConnecter();
//            Statement unStat = uneBdd.getMaConnexion().createStatement();
//            unStat.execute(requete);
//            unStat.close();
//            uneBdd.seDeConnceter();
//        } catch (Exception exp) {
//            System.out.println("Erreur : " + requete);
//        }
//    }
//
//    public static void deleteClient(Client unClient) {
//        String requete = "delete from client where idclient = " + unClient.getIdclient() + ";";
//        Bdd uneBdd = new Bdd("localhost:8889", "intervention", "root", "root");
//        try {
//            uneBdd.seConnecter();
//            Statement unStat = uneBdd.getMaConnexion().createStatement();
//            unStat.execute(requete);
//            unStat.close();
//            uneBdd.seDeConnceter();
//        } catch (Exception exp) {
//            System.out.println("Erreur : " + requete);
//        }
//    }
//
//    public static void updateClient(Client unClient) {
//        String requete = "update client "
//                + " set nom ='" + unClient.getNom()
//                + "', prenom = '" + unClient.getPrenom()
//                + "', adressse = '" + unClient.getAdresse()
//                + "' where idclient = " + unClient.getIdclient() + "; ";
//        Bdd uneBdd = new Bdd("localhost:8889", "intervention", "root", "root");
//        try {
//            uneBdd.seConnecter();
//            Statement unStat = uneBdd.getMaConnexion().createStatement();
//            unStat.execute(requete);
//            unStat.close();
//            uneBdd.seDeConnceter();
//        } catch (Exception exp) {
//            System.out.println("Erreur : " + requete);
//        }
//    }
//    /**
//     * ********* Modele des Techniciens ****************
//     */
//    public static ArrayList<Technicien> selectAllTechniciens() {
//        ArrayList<Technicien> lesTechniciens = new ArrayList<Technicien>();
//        String requete = "Select * from technicien ; ";
//        Bdd uneBdd = new Bdd();
//        try {
//            uneBdd.seConnecter();
//            Statement unStat = uneBdd.getMaConnexion().createStatement();
//            ResultSet unRes = unStat.executeQuery(requete);
//            while (unRes.next()) {
//                int idTech = unRes.getInt("idtech");
//                String nom = unRes.getString("nom");
//                String prenom = unRes.getString("prenom");
//                String competence = unRes.getString("competence");
//                Technicien unTechnicien = new Technicien(idTech, nom, prenom, competence);
//                lesTechniciens.add(unTechnicien);
//            }
//            unStat.close();
//            unRes.close();
//            uneBdd.seDeConnceter();
//        } catch (Exception exp) {
//            System.out.println("Erreur : " + requete);
//        }
//        return lesTechniciens;
//    }
//
//    public static Technicien selectWhereTechnicien(Technicien unTechnicien) {
//        String requete = "Select * from Technicien where idtech = " + unTechnicien.getIdTech();
//        Technicien unTechResultat = null;
//        Bdd uneBdd = new Bdd();
//        try {
//            uneBdd.seConnecter();
//            Statement unStat = uneBdd.getMaConnexion().createStatement();
//            ResultSet unRes = unStat.executeQuery(requete);
//            while (unRes.next()) {
//                int idTech = unRes.getInt("idtech");
//                String nom = unRes.getString("nom");
//                String prenom = unRes.getString("prenom");
//                String competence = unRes.getString("competence");
//                unTechResultat = new Technicien(idTech, nom, prenom, competence);
//            }
//            unStat.close();
//            unRes.close();
//            uneBdd.seDeConnceter();
//        } catch (Exception exp) {
//            System.out.println("Erreur : " + requete);
//        }
//        return unTechResultat;
//    }

}
