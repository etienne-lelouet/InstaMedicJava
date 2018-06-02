package controleur;

import javax.swing.table.AbstractTableModel;

public class Tableau extends AbstractTableModel {

    private Object[][] donnees;
    private final String[] entetes;

    public Tableau(Object[][] donnees, String[] entetes) {
        super();
        this.donnees = donnees;
        this.entetes = entetes;
    }

    public int getRowCount() {
        return donnees.length;
    }

    public int getColumnCount() {
        return entetes.length;
    }

    public String getColumnName(int columnIndex) {
        return entetes[columnIndex];
    }

    public Object getValueAt(int rowIndex, int columnIndex) {
        return donnees[rowIndex][columnIndex];
    }

    public void setDonnees(Object[][] donnees)
    {
        this.donnees = donnees;
        this.fireTableDataChanged();
    }
    

}
