package vue;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import controleur.Main;
import controleur.Medecin;
import controleur.Patient;
import controleur.Tableau;
import java.awt.Component;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import modele.Modele;

public class VuePatients extends JFrame implements ActionListener, KeyListener {

    private JPanel unPanel = new JPanel();
    private JTable tableClients;
    private Tableau unTableau;

    public VuePatients(Medecin unMedecin, boolean visible) {
        //recupération des données du medecin
        int idMedecin = unMedecin.getIdMedecin();
        String nomMedecin = unMedecin.getNom();
        String prenomMedecin = unMedecin.getPrenom();

        //On initialise la JFRAME
        this.setTitle("Selectionnez un Patient");
        this.setBounds(100, 0, 1000, 700);//résolution de l'écran
        //Layout: matrice
        this.setLayout(null);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.getContentPane().setBackground(Color.white);

        //construction du pannel
        this.unPanel.setBounds(50, 50, 900, 600);
        this.unPanel.setLayout(null);
        this.unPanel.setBackground(new Color(242, 242, 242));
        this.add(this.unPanel);
        this.unPanel.setVisible(visible);

        //On crée la string de texte du Label
        String textLabel = "Bienvenue Dr. " + prenomMedecin + " " + nomMedecin + ", veuillez selectionner un patient";
        JLabel Label1 = new JLabel(textLabel, SwingConstants.CENTER);
        Label1.setBounds(0, 0, 900, 50);
        this.unPanel.add(Label1);

        //On commence à créer la table
        String entetes[] = {"Id Patient", "Nom Patient", "Prénom Patient", "Date de naissance"};
        unTableau = new Tableau(this.recupererClientents(unMedecin), entetes);
        this.tableClients = new JTable(unTableau) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        //affichage de la jtable dans une scroll table
        JScrollPane uneScroll = new JScrollPane(this.tableClients);
        uneScroll.setBounds(100, 50, 700, 540);    //le cadre blanc
        uneScroll.setBackground(new Color(255, 255, 255));
        this.unPanel.add(uneScroll);
        this.tableClients.setEnabled(true);

        this.tableClients.addMouseListener(new MouseListener() {

            @Override
            public void mouseClicked(MouseEvent m) {
                System.out.println(m.getClickCount());
                int ligne = tableClients.getSelectedRow();
                int idClient = Integer.parseInt(tableClients.getValueAt(ligne, 0).toString());
                System.out.println(idClient);
                Patient PatientClicked = Modele.getPatientById(idClient);
                System.out.println(PatientClicked.getEmail());
                final Component source = m.getComponent();
                final JFrame frame = (JFrame) SwingUtilities.getRoot(source);
                frame.dispose();
                try {
                    new VueGeneral(unMedecin, PatientClicked);
                } catch (IOException ex) {
                    Logger.getLogger(VuePatients.class.getName()).log(Level.SEVERE, null, ex);
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

        //changer icone application
        ImageIcon logopetit = new ImageIcon("src/images/logoPetit.png");
        this.setIconImage(logopetit.getImage());
        this.setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }

    private Object[][] recupererClientents(Medecin unMedecin) {
        ArrayList<Patient> lesPatients = Modele.selectAllPatients(unMedecin);
        Object[][] donnees = new Object[lesPatients.size()][4];
        int i = 0;
        for (Patient unPatient : lesPatients) {
            donnees[i][0] = unPatient.getIdPatient() + "";
            donnees[i][1] = unPatient.getNomPatient();
            donnees[i][2] = unPatient.getPrenomPatient();
            donnees[i][3] = unPatient.getDate_naissance();
            i++;
        }
        return donnees;
    }

    public void toggleVisibilite(boolean action) {
        setVisible(action);
    }

}
