package vue;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import controleur.Main;
import controleur.Medecin;
import controleur.Patient;
import java.io.IOException;

public class VueGeneral extends JFrame implements ActionListener {

    private JPanel paneMenu = new JPanel();

    private JButton tabButton[] = new JButton[4];
    private String tabNoms[] = {"Informations", "Données Médicales", "Traitement", "Revenir à la liste des patients"};

    //Creation 3 panels
    private static VueInfos uneVueInfos;
    private static VueTechs uneVueTechs;
    private static VueCommentaire uneVueCommentaire;
    private static Medecin unMedecin;

    public VueGeneral(final Medecin unMedecin, Patient unPatient) throws IOException {
        this.uneVueInfos = new VueInfos(unPatient);
        this.uneVueTechs = new VueTechs();
        this.uneVueCommentaire = new VueCommentaire(unMedecin, unPatient);
        this.setTitle("Gestion du dossier médical de " + unPatient.getPrenomPatient() + " " + unPatient.getNomPatient());
        this.setLayout(null);
        this.setResizable(false);
        this.setBounds(100, 0, 1000, 700);
        this.getContentPane().setBackground(Color.white);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.unMedecin = unMedecin;

        this.paneMenu.setBounds(0, 20, 1000, 30);
        this.paneMenu.setLayout(new GridLayout(1, 4));
        this.add(this.paneMenu);
        //va avec le tab de button
        for (int i = 0; i < 4; i++) {
            this.tabButton[i] = new JButton(tabNoms[i]);
            this.paneMenu.add(this.tabButton[i]);
            //les rendres cliquables
            this.tabButton[i].addActionListener(this);
        }
        this.paneMenu.setVisible(true);
        this.add(uneVueInfos);
        this.add(uneVueTechs);
        this.add(uneVueCommentaire);

        //on met la vueinfos comme vue par défaut
        this.uneVueInfos.setVisible(true);
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.tabButton[0]) {
            uneVueInfos.setVisible(true);
            uneVueTechs.setVisible(false);
            uneVueCommentaire.setVisible(false);
        } else if (e.getSource() == this.tabButton[1]) {
            uneVueInfos.setVisible(false);
            uneVueTechs.setVisible(false);
            uneVueCommentaire.setVisible(true);
        } else if (e.getSource() == this.tabButton[2]) {
            uneVueInfos.setVisible(false);
            uneVueTechs.setVisible(false);
            uneVueCommentaire.setVisible(false);
        } else if (e.getSource() == this.tabButton[3]) {
            this.dispose();
            new VuePatients(this.unMedecin, true);
        }

    }

    public static Medecin getUnMedecin() {
        return unMedecin;
    }

    public static void setUnMedecin(Medecin unMedecin) {
        VueGeneral.unMedecin = unMedecin;
    }
}
