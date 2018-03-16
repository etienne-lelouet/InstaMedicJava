//2
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
import controleur.Tableau;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import modele.Modele;

public class VuePatients extends JFrame implements ActionListener, KeyListener {

    private JPanel unPanel = new JPanel();
    private JTable tableClients;
    private Tableau unTableau;

    public VuePatients(Medecin unMedecin) {
        //recupération des données du medecin
        int idMedecin = unMedecin.getIdMedecin();
        String nomMedecin = unMedecin.getNom();
        String prenomMedecin = unMedecin.getPrenom();

        //On initialise la JFRAME
        this.setTitle("Selectionnez un Patient");
        this.setBounds(100, 0, 1000, 700);
        //Layout: matrice
        this.setLayout(null);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.getContentPane().setBackground(Color.white);

        //construction du pannel
        this.unPanel.setBounds(50, 50, 900, 600);
        this.unPanel.setBackground(new Color(242, 242, 242));

        //On crée la string de texte du Label
        String textLabel = "Bienvenue Dr. " + prenomMedecin + " " + nomMedecin + ", veuillez selectionner un patient";
        JLabel Label1 = new JLabel(textLabel);
        Label1.setBounds(50, 50, 900, 50);
        unPanel.add(Label1);
        this.unPanel.setVisible(true);
        this.add(this.unPanel);

        //On commence à créer la table
        String entetes[] = {"Id Client", "Nom Client", "Prénom Client", "Adresse"};
        //unTableau = new Tableau(this.recupererClientents(), entetes);
        this.tableClients = new JTable(unTableau) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        this.tableClients.setEnabled(true);

        this.tableClients.addMouseListener(new MouseListener() {

            @Override
            public void mouseClicked(MouseEvent m) {
                System.out.println(m.getClickCount());
                int ligne = tableClients.getSelectedRow();
//                txtIdclient.setText(tableClients.getValueAt(ligne, 0).toString());
//                txtNom.setText(tableClients.getValueAt(ligne, 1).toString());
//                txtPrenom.setText(tableClients.getValueAt(ligne, 2).toString());
//                txtAdresse.setText(tableClients.getValueAt(ligne, 3).toString());
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
        //affichage de la jtable dans une scroll table
        JScrollPane uneScroll = new JScrollPane(this.tableClients);
        uneScroll.setBounds(20, 20, 600, 250);
        uneScroll.setBackground(Color.black);
        this.add(uneScroll);
        
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
}
