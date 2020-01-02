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
		/*if(columnIndex==2) {
			System.out.println(rowIndex+" row "+columnIndex+" column");
			System.out.println(StudenskaSluzba.getInstance().getValueAtProfesor(rowIndex, columnIndex)+"ovde");
		}*/
		return StudenskaSluzba.getInstance().getValueAtProfesor(rowIndex, columnIndex);
	}
	
	public boolean isCellEditable(int rowIndex, int columnIndex) {
		return false;
	}
	
	@Override
	public String getColumnName(int columnIndex) {
		return StudenskaSluzba.getInstance().getColumnNameProfesora(columnIndex);
	}
	/*public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
		Profesor profesor= StudenskaSluzba.getInstance().getListProfesora().get(rowIndex);
		switch (columnIndex) {
		case 0:
			
		case 1:
			
		case 2:
			
		case 3:
			
		case 4:
			
		case 5:
			
		case 6:
			
		case 7:
			
		case 8:
			
		case 9:
			
			
			 
		
		}
	}*/
	
	
}
