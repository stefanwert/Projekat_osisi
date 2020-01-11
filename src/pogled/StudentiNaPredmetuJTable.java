package pogled;

import java.awt.Color;
import java.awt.Component;

import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.TableCellRenderer;

public class StudentiNaPredmetuJTable extends JTable{
	
public static final Color LIGHT_BLUE = new Color(100,205,255);
	
	public StudentiNaPredmetuJTable() 
	{
		this.setRowSelectionAllowed(true);
		this.setColumnSelectionAllowed(true);
		this.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		this.setRowHeight(20);	
		this.setModel(new StudentTableModel());
	}
	@Override
	public Component prepareRenderer(TableCellRenderer renderer, int row, int column) {
		Component c = super.prepareRenderer(renderer, row, column);
		if (isRowSelected(row)) {
			c.setBackground(LIGHT_BLUE);
		} else {
			c.setBackground(Color.WHITE);
		}
		return c;
	}

}
