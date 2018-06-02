package vue;

import controleur.Commentaire;
import controleur.Medecin;
import controleur.Ordonnance;
import controleur.Patient;
import java.awt.Color;
import java.awt.Font;
import static java.awt.Font.PLAIN;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.Border;
import modele.Modele;

public class VueOrdonnance extends JPanel implements ActionListener {
    private Medecin unMedecin;
    private Patient unPatient;
    private JTextArea areaMessage = new JTextArea();
    private JButton btSauvegarder = new JButton("Sauvegarder");
    private JTextField txtNom = new JTextField();
    private JTextField txtPrenom = new JTextField();
    private JTextField txtIdMedecinActuel = new JTextField();
    private JTextField txtIdPatientActuel = new JTextField();
    private JLabel labelNom = new JLabel("Nom du Patient : ");
    private JLabel labelPrenom = new JLabel("Prénom du Patient : ");
    private JLabel labelArea = new JLabel("Corps du message : ");

    public VueOrdonnance(Medecin unMedecin, Patient unPatient) {
        this.unMedecin = unMedecin;
        this.unPatient = unPatient;
        this.setBounds(0, 20, 1000, 660);
        this.setLayout(null);
        this.setBackground(new Color(242, 242, 242));

        labelNom.setBounds(10, 110, 200, 30);
        this.add(labelNom);
        txtNom.setBounds(10, 140, 200, 30);
        txtNom.setEditable(false);
        txtNom.setText(unPatient.getNomPatient());
        this.add(txtNom);

        labelPrenom.setBounds(10, 200, 200, 30);
        this.add(labelPrenom);
        txtPrenom.setBounds(10, 230, 200, 30);
        txtPrenom.setEditable(false);
        txtPrenom.setText(unPatient.getPrenomPatient());
        this.add(txtPrenom);

        labelArea.setBounds(250, 70, 300, 30);
        this.add(labelArea);
        areaMessage.setBounds(250, 100, 600, 540);
        Border blackline = BorderFactory.createLineBorder(new Color(0, 0, 0), 1);
        areaMessage.setBorder(blackline);
        areaMessage.setFont(new Font("Arial", PLAIN, 16));
        areaMessage.setLineWrap(true);
        areaMessage.setWrapStyleWord(true);
        this.add(areaMessage);

        btSauvegarder.setBounds(870, 300, 100, 40);
        this.add(btSauvegarder);

        this.btSauvegarder.addActionListener(this);

        this.setVisible(false);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.btSauvegarder && emptyfields_insert()) {
            Ordonnance uneOrdonnance = new Ordonnance(unPatient.getIdPatient(),
                    unMedecin.getIdMedecin(), areaMessage.getText());

            Modele.insertOrdonnance(uneOrdonnance);
            JOptionPane.showMessageDialog(this, "Insertion réussie");
            areaMessage.setText("");
        }
    }
        private boolean emptyfields_insert() {

        if (areaMessage.getText().equals("")) {
            return false;
        }
        return true;
    }
}
