package vue;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import controleur.Technicien;
import modele.Modele;

public class VueTechs extends JPanel implements ActionListener {

    private JComboBox cbxTechnicien = new JComboBox();
    private JButton btOK = new JButton("OK");

    private JTextArea areaTech = new JTextArea();

    public VueTechs() {
        this.setBounds(20, 70, 960, 590);
        this.setLayout(null);
        this.setBackground(new Color(242, 242, 242));

        this.cbxTechnicien.setBounds(50, 50, 200, 20);
        this.add(cbxTechnicien);
        this.btOK.setBounds(280, 50, 80, 20);
        this.add(btOK);
        this.areaTech.setBounds(50, 80, 360, 150);
        this.add(this.areaTech);

        this.remplirCBX();
        this.btOK.addActionListener(this);
        this.areaTech.setEditable(false);//ne pourra plus être édité
        this.setVisible(false);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.btOK) {
            String chaine = this.cbxTechnicien.getSelectedItem().toString();
            String tab[] = chaine.split(" - ");
            int idtech = Integer.parseInt(tab[0]);
            Technicien unTechnicien = new Technicien(idtech, tab[1], tab[2], "");
            //unTechnicien = Modele.selectWhereTechnicien(unTechnicien);
            this.areaTech.setText("technicien sélectionné :\n"
                    + "Id Tech : " + unTechnicien.getIdTech() + "\n"
                    + "Nom Tech : " + unTechnicien.getNom() + "\n"
                    + "Prenom Tech : " + unTechnicien.getPrenom() + "\n"
                    + "Competence Tech : " + unTechnicien.getCompetence() + "\n"
            );
        }

    }

    public void remplirCBX() {
//		ArrayList<Technicien> lesTechniciens = Modele.selectAllTechniciens();
//		for (Technicien unTechnicien : lesTechniciens)
//		{
//			this.cbxTechnicien.addItem(unTechnicien.getIdTech() + " - " + unTechnicien.getNom() + " - " + unTechnicien.getPrenom() );
//		}
    }
}
