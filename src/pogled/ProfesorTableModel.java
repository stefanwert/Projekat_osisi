package pogled;

import java.text.SimpleDateFormat;

import javax.swing.table.AbstractTableModel;

import model.Predmet;
import model.Profesor;
import model.StudenskaSluzba;

public class ProfesorTableModel extends AbstractTableModel{

	@Override
	public int getColumnCount() {
		return StudenskaSluzba.getInstance().getColumCountProfesora();
	}

	@Override
	public int getRowCount() {
		return StudenskaSluzba.getInstance().getListProfesora().size();
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		return StudenskaSluzba.getInstance().getValueAtProfesor(rowIndex, columnIndex);
	}
	
	public boolean isCellEditable(int rowIndex, int columnIndex) {
		return false;
	}
	
	@Override
	public String getColumnName(int columnIndex) {
		return StudenskaSluzba.getInstance().getColumnNameProfesora(columnIndex);
	}
	
}
