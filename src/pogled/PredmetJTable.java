package pogled;

import java.awt.Color;
import java.awt.Component;

import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.TableCellRenderer;

public class PredmetJTable extends JTable {

	private static final long serialVersionUID = 253246876241413223L;
	public static final Color LIGHT_BLUE = new Color(100,205,255);

	public PredmetJTable() {
		this.setRowSelectionAllowed(true);
		this.setColumnSelectionAllowed(true);
		this.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		this.setModel(new PredmetTableModel());
		this.setRowHeight(20);
		new ButtonColumnStudenti(this, 5);
		//pozovi konstruktor za dugmice
		
	}
	@Override
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
