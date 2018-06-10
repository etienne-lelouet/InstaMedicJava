package vue;

import controleur.Patient;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import controleur.Tableau;
import java.awt.Image;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import modele.Modele;

public class VueInfos extends JPanel implements ActionListener {

    private JPanel panelBio = new JPanel();
    private JPanel panelG = new JPanel();
    private Tableau unTableau;
    private URL URLImg;
    private JLabel ImgLabel, nomcomplet, date_naissance, adresse, adressecomp,
            code_postal, ville, telephone, email, groupesanguin, taille, poids;

    public VueInfos(Patient unPatient) throws MalformedURLException, IOException {
        this.setBounds(0, 20, 1000, 660);
        this.setBackground(new Color(242, 242, 242));

        Border blackline = BorderFactory.createLineBorder(new Color(0, 0, 0), 1);

        TitledBorder title;
        panelG.setBounds(20, 40, 900, 290);
        panelG.setBackground(new Color(242, 242, 242));
        panelG.setLayout(null);
        title = BorderFactory.createTitledBorder(blackline, "Informations Generales");
        title.setTitleJustification(TitledBorder.LEFT);
        panelG.setBorder(title);

        panelBio.setBounds(20, 340, 900, 290);
        panelBio.setBackground(new Color(242, 242, 242));
        panelBio.setLayout(null);
        title = BorderFactory.createTitledBorder(blackline, "Informations Biologiques");
        title.setTitleJustification(TitledBorder.LEFT);
        panelBio.setBorder(title);

        this.add(panelG);
        this.add(panelBio);
        this.setLayout(null);
        this.setBackground(new Color(242, 242, 242));

        String img = "http://163.172.49.216/insta_medic/app/files/" + unPatient.getIdPatient() + "/" + unPatient.getUrlphoto();
        Image image = null;
        System.out.println(img);
        this.URLImg = new URL(img);
        try
        {
           image = ImageIO.read(URLImg); 
        }
        catch (Exception e)
        {
            System.out.println(e);
        }
        
        if (image == null) {
            ImageIcon imageUsr = new ImageIcon("src/images/default.jpg");
            Image imageToResize = imageUsr.getImage();
            Image newimg = imageToResize.getScaledInstance(120, 120, java.awt.Image.SCALE_SMOOTH); // scale it the smooth way  
            imageUsr = new ImageIcon(newimg);
            JLabel ImgLabel = new JLabel(imageUsr);
            ImgLabel.setBounds(10, 10, 150, 150);
            panelG.add(ImgLabel);
        } else {
            ImageIcon imageUsr = new ImageIcon(image);
            Image imageToResize = imageUsr.getImage();
            Image newimg = imageToResize.getScaledInstance(120, 120, java.awt.Image.SCALE_SMOOTH); // scale it the smooth way  
            imageUsr = new ImageIcon(newimg);
            JLabel ImgLabel = new JLabel(imageUsr);
            ImgLabel.setBounds(10, 10, 150, 150);
            panelG.add(ImgLabel);
        }
        String StrNomComplet = unPatient.getEtat_civil() + " " + unPatient.getPrenomPatient() + " " + unPatient.getNomPatient();
        JLabel nomcomplet = new JLabel(StrNomComplet, SwingConstants.LEFT);
        nomcomplet.setBounds(160, 30, 300, 20);
        panelG.add(nomcomplet);

        String Strdate_naissance = "Né le : " + unPatient.getDate_naissance();
        JLabel date_naissance = new JLabel(Strdate_naissance, SwingConstants.LEFT);
        date_naissance.setBounds(160, 60, 300, 20);
        panelG.add(date_naissance);

        String Strtel = "Téléphone : " + unPatient.getTelephone();
        JLabel tel = new JLabel(Strtel, SwingConstants.LEFT);
        tel.setBounds(160, 90, 300, 20);
        panelG.add(tel);

        String Strmail = "Adresse mail: " + unPatient.getEmail();
        JLabel mail = new JLabel(Strmail, SwingConstants.LEFT);
        mail.setBounds(160, 120, 300, 20);
        panelG.add(mail);

        String Stradresse = "Adresse : " + unPatient.getAdresse();
        JLabel adresse = new JLabel(Stradresse, SwingConstants.LEFT);
        adresse.setBounds(480, 30, 300, 20);
        panelG.add(adresse);

        String Strcomp = "Complément d'adresse : " + unPatient.getAdressecomp();
        JLabel adressecomp = new JLabel(Strcomp, SwingConstants.LEFT);
        adressecomp.setBounds(480, 60, 300, 20);
        panelG.add(adressecomp);

        String Strcode_postal = "Code Postal: " + unPatient.getCode_postal();
        JLabel code_postal = new JLabel(Strcode_postal, SwingConstants.LEFT);
        code_postal.setBounds(480, 90, 300, 20);
        panelG.add(code_postal);

        String StrVille = "Ville : " + unPatient.getVille();
        JLabel Ville = new JLabel(StrVille, SwingConstants.LEFT);
        Ville.setBounds(480, 120, 300, 20);
        panelG.add(Ville);
        ///////////////////////////////////////////////////////////////////////////////////////

        String StrGroupeSanguin = "Groupe Sanguin : " + unPatient.getGroupeSanguin();
        JLabel GroupeSanguin = new JLabel(StrGroupeSanguin, SwingConstants.LEFT);
        GroupeSanguin.setBounds(10, 30, 300, 20);
        panelBio.add(GroupeSanguin);

        String StrTaille = "Taille : " + unPatient.getTaille() + " cm";
        JLabel Taille = new JLabel(StrTaille, SwingConstants.LEFT);
        Taille.setBounds(10, 60, 300, 20);
        panelBio.add(Taille);

        /*String StrPoids = "Poids : " + unPatient.getPoids() + " Kg";
        JLabel Poids = new JLabel(StrPoids, SwingConstants.LEFT);
        Poids.setBounds(10, 90, 300, 20);
        panelBio.add(Poids);*/

        this.setVisible(false);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
