//3
package controleur;

import javax.swing.JOptionPane;
import vue.VueConnexion;

public class Main {

    private static VueConnexion uneConnexion;

    public static void rendreVisible(boolean action) {
        Main.uneConnexion.setVisible(action);
    }

    public static void main(String[] args) {
        Main.uneConnexion = new VueConnexion();
    }

    public static void infoBox(String infoMessage, String titleBar) {
        int result = JOptionPane.showConfirmDialog(null,
                infoMessage,
                titleBar, JOptionPane.YES_OPTION);
        if (result == JOptionPane.YES_OPTION || result == JOptionPane.NO_OPTION) {
            System.exit(0);
        }
    }

}
