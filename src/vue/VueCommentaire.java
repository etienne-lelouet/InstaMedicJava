package vue;

import controleur.Commentaire;
import controleur.Medecin;
import controleur.Patient;
import controleur.Tableau;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import controleur.Technicien;
import java.awt.Component;
import java.awt.Font;
import static java.awt.Font.PLAIN;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import modele.Modele;

public class VueCommentaire extends JPanel implements ActionListener {

    private Medecin unMedecin;
    private Patient unPatient;
    private JPanel panelListe = new JPanel();
    private JPanel panelModifs = new JPanel();
    private JTable tableMessages;
    private Tableau unTableau;
    private JTextArea areaMessage = new JTextArea();
    private JButton btAjouter = new JButton("Ajouter");
    private JButton btSupprimer = new JButton("Supprimer");
    private JButton btMiseAJour = new JButton("Editer");
    private JTextField txtNom = new JTextField();
    private JTextField txtPrenom = new JTextField();
    private JTextField txtIdCommentaires = new JTextField();
    private JTextField txtIdPatientActuel = new JTextField();
    private JTextField txtIdMedecinActuel = new JTextField();
    private JTextField txtNomMedecinActuel = new JTextField();
    private JTextField txtPrenomMedecinActuel = new JTextField();
    private JLabel labelIDCommentaire = new JLabel("ID Commenataire : ");
    private JLabel labelNom = new JLabel("Nom du médecin : ");
    private JLabel labelPrenom = new JLabel("Prénom du médecin : ");
    private JLabel labelArea = new JLabel("Corps du message : ");

    public VueCommentaire(Medecin unMedecin, Patient unPatient) {

        this.unMedecin = unMedecin;
        this.unPatient = unPatient;

        this.setBounds(0, 20, 1000, 660);
        this.setLayout(null);
        this.setBackground(new Color(242, 242, 242));

        Border blackline = BorderFactory.createLineBorder(new Color(0, 0, 0), 1);
        TitledBorder title;
        panelListe.setBounds(20, 40, 900, 290);
        panelListe.setBackground(new Color(242, 242, 242));
        panelListe.setLayout(null);
        title = BorderFactory.createTitledBorder(blackline, "Affichage des Commentaires");
        title.setTitleJustification(TitledBorder.LEFT);
        panelListe.setBorder(title);
        this.add(panelListe);

        //On commence à créer la table
        String entetes[] = {"Id Message", "Nom Medecin", "Prénom Médecin", "Contenu"};
        unTableau = new Tableau(this.recupererMessages(unPatient), entetes);
        this.tableMessages = new JTable(unTableau) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        //affichage de la jtable dans une scroll table
        JScrollPane uneScroll = new JScrollPane(this.tableMessages);
        uneScroll.setBounds(0, 0, 900, 290);    //le cadre blanc
        uneScroll.setBackground(new Color(255, 255, 255));
        this.panelListe.add(uneScroll);
        this.tableMessages.setEnabled(true);

        this.tableMessages.addMouseListener(new MouseListener() {

            @Override
            public void mouseClicked(MouseEvent m) {
                int ligne = tableMessages.getSelectedRow();
                txtIdCommentaires.setText(tableMessages.getValueAt(ligne, 0).toString());
                txtNom.setText(tableMessages.getValueAt(ligne, 1).toString());
                txtPrenom.setText(tableMessages.getValueAt(ligne, 2).toString());
                areaMessage.setText(tableMessages.getValueAt(ligne, 3).toString());
            }

            @Override
            public void mousePressed(MouseEvent e) {
                // TODO Auto-generated method stub
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                // TODO Auto-generated method stub
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                // TODO Auto-generated method stub

            }

            @Override
            public void mouseExited(MouseEvent e) {
                // TODO Auto-generated method stub

            }
        });
        panelModifs.setBounds(20, 340, 900, 290);
        panelModifs.setBackground(new Color(242, 242, 242));
        panelModifs.setLayout(null);
        title = BorderFactory.createTitledBorder(blackline, "Ajouter/Modifier un commentaire");
        title.setTitleJustification(TitledBorder.LEFT);
        panelModifs.setBorder(title);

        labelIDCommentaire.setBounds(10, 20, 200, 30);
        panelModifs.add(labelIDCommentaire);
        txtIdCommentaires.setBounds(10, 50, 200, 30);
        txtIdCommentaires.setEditable(false);
        panelModifs.add(txtIdCommentaires);

        labelNom.setBounds(10, 110, 200, 30);
        panelModifs.add(labelNom);
        txtNom.setBounds(10, 140, 200, 30);
        txtNom.setEditable(false);
        panelModifs.add(txtNom);

        labelPrenom.setBounds(10, 200, 200, 30);
        panelModifs.add(labelPrenom);
        txtPrenom.setBounds(10, 230, 200, 30);
        txtPrenom.setEditable(false);
        panelModifs.add(txtPrenom);

        labelArea.setBounds(250, 20, 300, 30);
        panelModifs.add(labelArea);
        areaMessage.setBounds(250, 50, 450, 210);
        areaMessage.setBorder(blackline);
        areaMessage.setFont(new Font("Arial", PLAIN, 16));
        areaMessage.setLineWrap(true);
        areaMessage.setWrapStyleWord(true);
        panelModifs.add(areaMessage);

        btAjouter.setBounds(750, 85, 100, 40);
        panelModifs.add(btAjouter);

        btMiseAJour.setBounds(750, 135, 100, 40);
        panelModifs.add(btMiseAJour);

        btSupprimer.setBounds(750, 185, 100, 40);
        panelModifs.add(btSupprimer);

        this.add(panelModifs);

        txtIdMedecinActuel.setText(String.valueOf(unMedecin.getIdMedecin()));
        txtIdPatientActuel.setText(String.valueOf(unPatient.getIdPatient()));
        txtNomMedecinActuel.setText(unMedecin.getNom());
        txtPrenomMedecinActuel.setText(unMedecin.getPrenom());
        this.btAjouter.addActionListener(this);
        this.btSupprimer.addActionListener(this);
        this.btMiseAJour.addActionListener(this);

        this.setVisible(false);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.btAjouter && emptyfields_insert()) {

            Commentaire unCommentaire = new Commentaire(unPatient.getIdPatient(),
                    unMedecin.getIdMedecin(), areaMessage.getText());

            int id = Modele.insertCommentaire(unCommentaire);
            Object data[][] = this.recupererMessages(unPatient);
            unTableau.setDonnees(data);
            JOptionPane.showMessageDialog(this, "Insertion réussie");
        } else if (e.getSource() == this.btSupprimer && emptyfields()) {

            if (Modele.verifyAuthorization(Integer.parseInt(txtIdCommentaires.getText()), Integer.parseInt(txtIdMedecinActuel.getText()))) {

                Commentaire unCommentaire = new Commentaire(Integer.parseInt(txtIdCommentaires.getText()),
                        unPatient.getIdPatient(), unMedecin.getIdMedecin(), areaMessage.getText(),
                        unMedecin.getNom(), unMedecin.getPrenom());

                Modele.deleteCommentaire(unCommentaire);
                Object data[][] = this.recupererMessages(unPatient);
                unTableau.setDonnees(data);
                JOptionPane.showMessageDialog(this, "Suppression effectuée");
            } else {
                JOptionPane.showMessageDialog(this, "Vous n'avez pas les droits suffisants pour supprimer ce message !");
            }

        } else if (e.getSource() == this.btMiseAJour && emptyfields()) {

            if (Modele.verifyAuthorization(Integer.parseInt(txtIdCommentaires.getText()), Integer.parseInt(txtIdMedecinActuel.getText()))) {

                Commentaire unCommentaire = new Commentaire(Integer.parseInt(txtIdCommentaires.getText()),
                        unPatient.getIdPatient(), unMedecin.getIdMedecin(), areaMessage.getText(),
                        unMedecin.getNom(), unMedecin.getPrenom());

                Modele.updateCommentaire(unCommentaire);
                JOptionPane.showMessageDialog(this, "Mise a jour effectuée");

                Object data[][] = this.recupererMessages(unPatient);
                unTableau.setDonnees(data);
            } else {
                JOptionPane.showMessageDialog(this, "Vous n'avez pas les droits suffisants pour supprimer ce message !");
            }
        }
    }

    private Object[][] recupererMessages(Patient unPatient) {
        ArrayList<Commentaire> lesCommentaires = Modele.selectAllMessages(unPatient);
        Object[][] donnees = new Object[lesCommentaires.size()][4];
        int i = 0;
        for (Commentaire unCommentaire : lesCommentaires) {
            donnees[i][0] = unCommentaire.getIdCommentaire() + "";
            donnees[i][1] = unCommentaire.getNomMedecin();
            donnees[i][2] = unCommentaire.getPrenomMedecin();
            donnees[i][3] = unCommentaire.getContenu();
            i++;
        }
        return donnees;
    }

    private boolean emptyfields() {
        if (txtIdCommentaires.getText().equals("")) {
            return false;
        }
        if (txtNom.getText().equals("")) {
            return false;
        }
        if (txtPrenom.getText().equals("")) {
            return false;
        }
        if (areaMessage.getText().equals("")) {
            return false;
        }
        return true;
    }

    private boolean emptyfields_insert() {

        if (areaMessage.getText().equals("")) {
            return false;
        }
        return true;
    }
}
