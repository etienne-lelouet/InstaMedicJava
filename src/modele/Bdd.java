package modele;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Bdd {

    private String serveur, bdd, user, mdp;

    private Connection maConnexion;

    public Bdd() {
        this.serveur = "163.172.49.216";
        this.bdd = "Clinique";
        this.user = "wef";
        this.mdp = "ppe2018wef";
        this.maConnexion = null;
    }

    public void chargerPilote() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException exp) {
            System.out.println("Erreur de chargement du pilote JDBC");
        }
    }

    public void seConnecter() {
        String url = "jdbc:mysql://" + this.serveur + "/" + this.bdd;
        this.chargerPilote();
        try {
            this.maConnexion = DriverManager.getConnection(url, this.user, this.mdp);
        } catch (SQLException exp) {
            System.out.println(url);
            System.out.println(exp);
        }
    }

    public void seDeConnceter() {
        try {
            if (this.maConnexion != null) {
                this.maConnexion.close();
            }
        } catch (SQLException exp) {
            System.out.println("Erreur de fermeture de la connexion !");
        }
    }

    public Connection getMaConnexion() {
        return this.maConnexion;
    }

}
