package pogled;

import javax.swing.table.AbstractTableModel;

import model.Student;
import model.Student.Status;
import model.StudenskaSluzba;

public class StudentTableModel extends AbstractTableModel{
	
	private static final long serialVersionUID = 4754799851510826097L;
	@Override
	public Class<?> getColumnClass(int columnIndex) {
		return String.class;
	}
	
	@Override
	public int getRowCount() {
		return StudenskaSluzba.getInstance().getListStudenata().size();
	}
	
	@Override
	public int getColumnCount() {
		return StudenskaSluzba.getInstance().getColumCountStudenata();
	}
	
	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		return StudenskaSluzba.getInstance().getValueAtStudent(rowIndex, columnIndex);
	}
	
	@Override
	public String getColumnName(int columnIndex) {
		return StudenskaSluzba.getInstance().getColumnNameStudenata(columnIndex);

	}
	
	@Override
	public boolean isCellEditable(int rowIndex, int columnIndex) {
		return false;
	}

}
