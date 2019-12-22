package pogled;

import java.awt.Color;
import java.awt.Component;

import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.TableCellRenderer;

public class ProfesorJTable extends JTable {

	private static final long serialVersionUID = -1150628914407736196L;
	public static final Color LIGHT_BLUE = new Color(100,205,255);
	
	public ProfesorJTable() {
		this.setRowSelectionAllowed(true);
		this.setColumnSelectionAllowed(true);
		this.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		this.setModel(new ProfesorTableModel());
		this.setRowHeight(20);
	}
	
	public Component prepareRenderer(TableCellRenderer renderer, int row, int column) {
		Component c = super.prepareRenderer(renderer, row, column);
		// selektovani red ce imati drugaciju boju od ostalih
		if (isRowSelected(row)) {
			c.setBackground(LIGHT_BLUE);
		} else {
			c.setBackground(Color.WHITE);
		}
		return c;
	}
}
