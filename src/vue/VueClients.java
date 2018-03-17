package vue;

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
import modele.Modele;

public class VueClients extends JPanel implements ActionListener {

    private JTable tableClients;
    private JPanel panelEdition = new JPanel();
    private JButton btAjouter = new JButton("Ajouter");
    private JButton btSupprimer = new JButton("Supprimer");
    private JButton btMiseAJour = new JButton("Editer");

    private JTextField txtNom = new JTextField();
    private JTextField txtPrenom = new JTextField();
    private JTextField txtAdresse = new JTextField();
    private JTextField txtIdclient = new JTextField();

    private Tableau unTableau;

    public VueClients() {
        this.setBounds(20, 70, 960, 590);
        this.setLayout(null);
        this.setBackground(new Color(242, 242, 242));

        //construction de la Jtable
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
                txtIdclient.setText(tableClients.getValueAt(ligne, 0).toString());
                txtNom.setText(tableClients.getValueAt(ligne, 1).toString());
                txtPrenom.setText(tableClients.getValueAt(ligne, 2).toString());
                txtAdresse.setText(tableClients.getValueAt(ligne, 3).toString());
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

        //construction du panel edition d'un client
        this.panelEdition.setBounds(20, 290, 650, 60);
        this.panelEdition.setLayout(new GridLayout(2, 4));
        this.panelEdition.add(new JLabel("ID Client : "));
        this.panelEdition.add(txtIdclient);
        this.panelEdition.add(new JLabel("Nom : "));
        this.panelEdition.add(txtNom);
        this.panelEdition.add(new JLabel("Prenom : "));
        this.panelEdition.add(txtPrenom);
        this.panelEdition.add(new JLabel("Adresse : "));
        this.panelEdition.add(txtAdresse);
        this.add(this.panelEdition);

        this.btAjouter.setBounds(200, 370, 100, 20);
        this.add(btAjouter);
        this.btSupprimer.setBounds(350, 370, 100, 20);
        this.add(btSupprimer);
        this.btMiseAJour.setBounds(470, 370, 100, 20);
        this.add(btMiseAJour);
        this.txtIdclient.setEditable(false); //ne peut pas éditer

        //rendre btn cliquables
        this.btAjouter.addActionListener(this);
        this.btSupprimer.addActionListener(this);
        this.btMiseAJour.addActionListener(this);

        this.setVisible(false);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.btAjouter) {
//			Client unClient = new Client(txtNom.getText(),
//					txtPrenom.getText(), txtAdresse.getText());
//			Modele.insertClient(unClient);
//			JOptionPane.showMessageDialog(this, "Insertion réussie");
//			txtNom.setText("");
//			txtPrenom.setText("");
//			txtAdresse.setText("");
//			Object data[] = {unClient.getIdclient()+"", unClient.getNom(), unClient.getPrenom(), unClient.getAdresse()};
//			this.unTableau.add(data);
        } else if (e.getSource() == this.btSupprimer) {
//			int idclient = Integer.parseInt(txtIdclient.getText());
//			Client unClient = new Client(txtNom.getText(),
//					txtPrenom.getText(), txtAdresse.getText());
//			Modele.deleteClient(unClient);
//			JOptionPane.showMessageDialog(this, "Suppression effectuée");
//			txtIdclient.setText("");
//			txtNom.setText("");
//			txtPrenom.setText("");
//			txtAdresse.setText("");
//			int rowIndex = tableClients.getSelectedRow();
//			unTableau.remove(rowIndex);
        } else if (e.getSource() == this.btMiseAJour) {
//			int idclient = Integer.parseInt(txtIdclient.getText());
//			Client unClient = new Client(idclient,txtNom.getText(),
//					txtPrenom.getText(), txtAdresse.getText());
//			Modele.updateClient(unClient);
//			JOptionPane.showMessageDialog(this, "Mise a jour effectuée");
//
//			Object data[] = {unClient.getIdclient()+"", unClient.getNom(), unClient.getPrenom(), unClient.getAdresse()};
//			int rowIndex = tableClients.getSelectedRow();
//			this.unTableau.update(rowIndex, data);
//
//			txtIdclient.setText("");
//			txtNom.setText("");
//			txtPrenom.setText("");
//			txtAdresse.setText("");

        }
    }

    //recuperer les données sous forme d"une matrice
//	private Object [][] recupererClientents()
//	{
////		ArrayList<Client>lesClients = Modele.selectAllClients();
////		Object[][] donnees = new Object[lesClients.size()][Client.getNbChampsClients()];
////		int i = 0;
////		for (Client unClient : lesClients)
////		{
////			donnees[i][0] = unClient.getIdclient() + "";
////			donnees[i][1] = unClient.getNom();
////			donnees[i][2] = unClient.getPrenom();
////			donnees[i][3] = unClient.getAdresse();
////			i++;
////		}
//		return donnees;
//	}
}
