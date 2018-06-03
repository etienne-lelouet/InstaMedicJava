package vue;

import controleur.Commentaire;
import controleur.Medecin;
import controleur.Medicament;
import controleur.Ordonnance;
import controleur.Patient;
import controleur.Prescription;
import controleur.Tableau;
import java.awt.Color;
import java.awt.Font;
import static java.awt.Font.PLAIN;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import static java.util.Collections.list;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javafx.scene.control.DatePicker;
import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import modele.Modele;

public class VuePrescription extends JPanel implements ActionListener {

    private Medecin unMedecin;
    private Patient unPatient;
    private Tableau unTableau;
    private boolean valid;
    private int idSelected;
    private ArrayList<Medicament> lesMedicaments;
    private JTable tableMessages;
    private Pattern patternDate = Pattern.compile("(([0-2][0-9]|3[0-1])(\\/)(0[0-9]|1[0-2])(\\/)[0-9]{4})");
    private JPanel panelListe = new JPanel();
    private JPanel panelPrescrire = new JPanel();
    private JTextArea areaMessage = new JTextArea();
    private JLabel labelMedicament = new JLabel("Medicament à prescrire : ");
    private JLabel labelDateDebut = new JLabel("Date de début du traitement : ");
    private JLabel labelDateFin = new JLabel("Date de fin du traitement : ");
    private JLabel labelCommentaires = new JLabel("Commentaire : ");
    private JTextArea areaCommentaires = new JTextArea();
    private JComboBox listeMedicaments;
    private TextField txtDateDebut = new TextField();
    private TextField txtDateFin = new TextField();
    private JButton btAjouter = new JButton("Ajouter");
    private JButton btSupprimer = new JButton("Supprimer");
    private JButton btMiseAJour = new JButton("Editer");

    public VuePrescription(Medecin unMedecin, Patient unPatient) {

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
        title = BorderFactory.createTitledBorder(blackline, "Suivi des traitement de " + this.unPatient.getPrenomPatient() + " " + this.unPatient.getNomPatient());
        title.setTitleJustification(TitledBorder.LEFT);
        panelListe.setBorder(title);
        this.add(panelListe);

        //On commence à créer la table
        String entetes[] = {"Préscription n° ", "Préscripteur", "Medicament", "Commentaire", "Date début du traitement", "Date de fin du traitement"};
        unTableau = new Tableau(this.recupererPrescriptions(unPatient), entetes);
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
                setIdSelected(Integer.parseInt(tableMessages.getValueAt(ligne, 0).toString()));
                txtDateDebut.setText(tableMessages.getValueAt(ligne, 4).toString());
                if (tableMessages.getValueAt(ligne, 5) != null) {
                    txtDateFin.setText(tableMessages.getValueAt(ligne, 5).toString());
                }
                if (tableMessages.getValueAt(ligne, 3)!= null) {
                    areaCommentaires.setText(tableMessages.getValueAt(ligne, 3).toString());
                }
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
        this.panelPrescrire.setBounds(20, 340, 900, 290);
        this.panelPrescrire.setBackground(new Color(242, 242, 242));
        this.panelPrescrire.setLayout(null);
        title = BorderFactory.createTitledBorder(blackline, "Ajouter/Modifier un traitement");
        title.setTitleJustification(TitledBorder.LEFT);
        this.panelPrescrire.setBorder(title);

        this.labelMedicament.setBounds(10, 20, 175, 30);
        this.panelPrescrire.add(labelMedicament);
        this.lesMedicaments = Modele.getAllMedicaments();
        int i = 0;
        int size = lesMedicaments.size();
        String[] comboText;
        comboText = new String[size];
        for (Medicament unMedicament : this.lesMedicaments) {
            comboText[i] = unMedicament.getNom();
            i++;
        }
        this.listeMedicaments = new JComboBox(comboText);
        this.listeMedicaments.setBounds(10, 60, 175, 30);
        this.panelPrescrire.add(listeMedicaments);

        this.labelCommentaires.setBounds(250, 10, 175, 30);
        this.panelPrescrire.add(labelCommentaires);

        this.areaCommentaires.setBounds(250, 50, 450, 210);
        this.areaCommentaires.setBorder(blackline);
        this.areaCommentaires.setFont(new Font("Arial", PLAIN, 16));
        this.areaCommentaires.setLineWrap(true);
        this.areaCommentaires.setWrapStyleWord(true);
        this.panelPrescrire.add(areaCommentaires);

        this.labelDateDebut.setBounds(10, 100, 175, 30);
        this.panelPrescrire.add(labelDateDebut);
        this.txtDateDebut.setBounds(10, 140, 175, 30);
        this.panelPrescrire.add(txtDateDebut);

        this.labelDateFin.setBounds(10, 180, 175, 30);
        this.panelPrescrire.add(labelDateFin);
        this.txtDateFin.setBounds(10, 220, 175, 30);
        this.panelPrescrire.add(txtDateFin);

        this.btAjouter.setBounds(750, 85, 100, 40);
        this.panelPrescrire.add(btAjouter);

        this.btMiseAJour.setBounds(750, 135, 100, 40);
        this.panelPrescrire.add(btMiseAJour);

        this.add(panelPrescrire);

        this.btAjouter.addActionListener(this);
        this.btMiseAJour.addActionListener(this);

        this.setVisible(false);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        this.valid = true;
        String medicamentChoisi = this.listeMedicaments.getSelectedItem().toString();
        int idMedicament = getIdSelected(this.lesMedicaments, medicamentChoisi);
        String dateDebut = this.txtDateDebut.getText();
        String dateFin = this.txtDateFin.getText();

        if (!dateDebut.isEmpty()) {
            if (this.patternDate.matcher(this.txtDateDebut.getText()).matches() == false) {
                this.valid = false;
                JOptionPane.showMessageDialog(null, "Vous devez fournir une date de début de traitement valide", "Erreur", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            this.valid = false;
            JOptionPane.showMessageDialog(null, "Vous devez fournir une date de début de traitement", "Erreur", JOptionPane.ERROR_MESSAGE);
        }
        if (!dateFin.isEmpty()) {
            if (this.patternDate.matcher(this.txtDateFin.getText()).matches() == false) {
                this.valid = false;
                JOptionPane.showMessageDialog(null, "Vous devez fournir une date de fin de traitement valide", "Erreur", JOptionPane.ERROR_MESSAGE);
            }
        }

        if (idMedicament == 0) {
            this.valid = false;
            JOptionPane.showMessageDialog(null, "Erreur lors du choix du médicament", "Erreur", JOptionPane.ERROR_MESSAGE);
        }
        Prescription unePrescription = new Prescription(idMedicament, unMedecin.getIdMedecin(),
                unPatient.getIdPatient(), txtDateDebut.getText(), txtDateFin.getText(), areaCommentaires.getText());

        if (e.getSource() == this.btAjouter && valid) {
            Modele.insertPrescription(unePrescription);
            JOptionPane.showMessageDialog(this, "Insertion réussie");
            this.areaMessage.setText("");
            this.txtDateDebut.setText("");
            this.txtDateFin.setText("");

            Object data[][] = this.recupererPrescriptions(unPatient);
            unTableau.setDonnees(data);
        }

        if (e.getSource() == this.btMiseAJour && valid) {
            if (getIdSelected() == 0) {
                JOptionPane.showMessageDialog(null, "Veuillez selectionner un champ à mettre à jours", "Erreur", JOptionPane.ERROR_MESSAGE);
            }

            if (Modele.verifyAuthorizationPrescription(getIdSelected(), this.unMedecin.getIdMedecin())) {
                Modele.updatePrescription(getIdSelected(), unePrescription);
                JOptionPane.showMessageDialog(this, "Insertion réussie");
                this.areaMessage.setText("");
                this.txtDateDebut.setText("");
                this.txtDateFin.setText("");
            } else {
                JOptionPane.showMessageDialog(null, "Vous ne pouvez pas modifier cette prescription", "Erreur", JOptionPane.ERROR_MESSAGE);
            }

            Object data[][] = this.recupererPrescriptions(unPatient);
            unTableau.setDonnees(data);

        }
    }

    private Object[][] recupererPrescriptions(Patient unPatient) {
        ArrayList<Prescription> lesPrescriptions = Modele.selectAllPrescriptions(unPatient);
        Object[][] donnees = new Object[lesPrescriptions.size()][6];
        int i = 0;
        for (Prescription unePrescription : lesPrescriptions) {
            donnees[i][0] = unePrescription.getIdPrescription() + "";
            donnees[i][1] = unePrescription.getNomMedecin() + " " + unePrescription.getPrenomMedecin();
            donnees[i][2] = unePrescription.getNomMedicament();
            donnees[i][3] = unePrescription.getCommentaire();
            donnees[i][4] = unePrescription.getDateDebut();
            donnees[i][5] = unePrescription.getDateFin();

            i++;
        }
        return donnees;
    }

    private boolean emptyfields_insert() {

        if (areaMessage.getText().equals("")) {
            return false;
        }
        return true;
    }

    private int getIdSelected(ArrayList<Medicament> lesMedicaments, String medicamentChoisi) {
        for (Medicament unMedicament : this.lesMedicaments) {
            if (unMedicament.getNom() == medicamentChoisi) {
                return unMedicament.getId();
            }
        }
        return 0;
    }

    public void setIdSelected(int idSelected) {
        this.idSelected = idSelected;
    }

    public int getIdSelected() {
        return idSelected;
    }

}
