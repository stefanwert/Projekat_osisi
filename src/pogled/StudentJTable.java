package pogled;

import java.awt.Color;
import java.awt.Component;

import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableCellRenderer;

public class StudentJTable extends JTable {
	
	public static final Color LIGHT_BLUE = new Color(100,205,255);
	
	public StudentJTable() 
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
    //svaka parna vrsta je siva a neparna bijela
	static class MyTableCellRenderer extends DefaultTableCellRenderer {

		public static final Color VERY_LIGHT_GRAY = new Color(245,245,245);
	    @Override
	    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
	        StudentTableModel model = (StudentTableModel) table.getModel();
	        final Component c = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
	        c.setBackground(row % 2 == 0 ? VERY_LIGHT_GRAY : Color.RED);
	        return c;
	    }
	}

}
