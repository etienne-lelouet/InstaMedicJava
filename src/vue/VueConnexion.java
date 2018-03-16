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
import modele.Modele;

public class VueConnexion extends JFrame implements ActionListener, KeyListener {

    private JPanel unPanel = new JPanel();
    private JButton btAnnuler = new JButton("Annuler");
    private JButton btSeConnecter = new JButton("Se Connecter");
    private JTextField txtLogin = new JTextField();
    private JPasswordField pwdMdp = new JPasswordField();

    public VueConnexion() {
        this.setTitle("Connexion à Insta Medic Lourd");
        this.setBounds(100, 0, 1000, 700);
        //Layout: matrice
        this.setLayout(null);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.getContentPane().setBackground(Color.white);

        //construction du pannel
        this.unPanel.setBounds(100, 300, 800, 150);
        this.unPanel.setBackground(new Color(242, 242, 242));
        this.unPanel.setLayout(new GridLayout(3, 2));
        this.unPanel.add(new JLabel("Login : "));
        this.unPanel.add(this.txtLogin);
        this.unPanel.add(new JLabel("MDP : "));
        this.unPanel.add(this.pwdMdp);
        this.unPanel.add(this.btAnnuler);
        this.unPanel.add(this.btSeConnecter);

        this.unPanel.setVisible(true);
        this.add(this.unPanel);

        //ajout de l'image à la fenetre
        ImageIcon logo = new ImageIcon("src/images/logoClinique.png");
        JLabel lbLogo = new JLabel(logo);
        lbLogo.setBounds(100, 40, 800, 240);
        this.add(lbLogo);

        //changer icone application
        ImageIcon logopetit = new ImageIcon("src/images/logoPetit.png");
        this.setIconImage(logopetit.getImage());

        //rendre les boutons cliquables
        this.btAnnuler.addActionListener(this);
        this.btSeConnecter.addActionListener(this);

        //rendre la touche entree ecoutable
        this.txtLogin.addKeyListener(this);
        this.pwdMdp.addKeyListener(this);

        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {
            case "Annuler":
                this.txtLogin.setText("");
                this.pwdMdp.setText("");
                break;
            case "Se Connecter":
                traitement();
                break;
        }

    }

    @Override
    public void keyTyped(KeyEvent e) {
        // TODO Auto-generated method stub

    }

    private String md5(String mdp) {
        byte[] uniqueKey = mdp.getBytes();
        byte[] hash = null;
        try {
            hash = MessageDigest.getInstance("MD5").digest(uniqueKey);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }

        StringBuilder hashString = new StringBuilder();

        for (int i = 0; i < hash.length; i++) {
            String hex = Integer.toHexString(hash[i]);
            if (hex.length() == 1) {
                hashString.append('0');
                hashString.append(hex.charAt(hex.length() - 1));
            } else {
                hashString.append(hex.substring(hex.length() - 2));
            }
        }
        mdp = hashString.toString();
        return mdp;
    }

    private void traitement() {
        String login = this.txtLogin.getText();
        String mdp = new String(this.pwdMdp.getPassword());
        if (login.equals("") || mdp.equals("")) {
            JOptionPane.showMessageDialog(this, "Veuillez remplir les champs");
        } else {
            mdp = md5(mdp);
            Medecin MedecinLogged = Modele.Connexion(login, mdp);
            if (MedecinLogged.getIdMedecin() != 0) {
                //JOptionPane.showMessageDialog(this, "Bienvenue !", "Connexion réussie", JOptionPane.INFORMATION_MESSAGE);
                //appel de la JFrame generale
                Main.rendreVisible(false);
                new VuePatients(MedecinLogged);

            } else {
                JOptionPane.showMessageDialog(this, "Identifiants incorrects");
                this.txtLogin.setText("");
                this.pwdMdp.setText("");
            }

        }
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyChar() == KeyEvent.VK_ENTER) {
            traitement();
        }

    }

    @Override
    public void keyReleased(KeyEvent e) {
        // TODO Auto-generated method stub

    }
}
