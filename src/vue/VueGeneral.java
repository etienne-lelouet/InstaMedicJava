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

public class VueGeneral extends JFrame implements ActionListener {

    private JPanel paneMenu = new JPanel();

    private JButton tabButton[] = new JButton[5];
    private String tabNoms[] = {"Informations", "Données Médicales", "Traitement", "Commentaire", "Quitter"};

    //Creation 3 panels
    private static VueInters uneVueInters = new VueInters();
    private static VueTechs uneVueTechs = new VueTechs();
    private static VueCommentaire uneVueCommentaire = new VueCommentaire();

    public VueGeneral(Medecin unMedecin) {
        this.setTitle("Gestion des interventions");
        this.setLayout(null);
        this.setResizable(false);
        this.setBounds(100, 0, 1000, 700);
        this.getContentPane().setBackground(Color.white);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        this.paneMenu.setBounds(0, 20, 1000, 30);
        this.paneMenu.setLayout(new GridLayout(1, 4));
        this.add(this.paneMenu);
        //va avec le tab de button
        for (int i = 0; i < 5; i++) {
            this.tabButton[i] = new JButton(tabNoms[i]);
            this.paneMenu.add(this.tabButton[i]);
            //les rendres cliquables
            this.tabButton[i].addActionListener(this);
        }
        this.paneMenu.setVisible(true);
        this.add(uneVueInters);
        this.add(uneVueTechs);
        this.add(uneVueCommentaire);
        this.setVisible(true);

        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.tabButton[3]) {
            this.dispose();
            Main.rendreVisible(true);
        } else if (e.getSource() == this.tabButton[0]) {
            uneVueInters.setVisible(false);
            uneVueTechs.setVisible(false);
        } else if (e.getSource() == this.tabButton[1]) {
            uneVueInters.setVisible(false);
            uneVueTechs.setVisible(true);
        } else if (e.getSource() == this.tabButton[2]) {
            uneVueInters.setVisible(true);
            uneVueTechs.setVisible(false);
        }

    }
}
