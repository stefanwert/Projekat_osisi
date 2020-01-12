package pogled;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.event.TableModelListener;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableModel;

import model.StudenskaSluzba;
import model.Predmet;

public class PredmetTableModel extends AbstractTableModel{
	
	
	private static final long serialVersionUID = 4754799851510826097L;

	@Override
	public int getColumnCount() {
		return StudenskaSluzba.getInstance().getColumCountPredmeta();
	}

	@Override
	public String getColumnName(int columnIndex) {
		return StudenskaSluzba.getInstance().getColumnNamePredmeta(columnIndex);
	}

	@Override
	public int getRowCount() {
		return StudenskaSluzba.getInstance().getListPredmeta().size();
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		if (columnIndex < 5)
			return StudenskaSluzba.getInstance().getValueAtPredmet(rowIndex, columnIndex);
		else if (columnIndex == 5) { 
			JButton btn = new JButton("" + rowIndex);
			return btn;
			}
		return null;
	}

	@Override
	public boolean isCellEditable(int rowIndex, int columnIndex) {
		if(columnIndex==5) {
			return true;
		}
		return false;
	}

	@Override
	public Class<?> getColumnClass(int columnIndex) {
		switch (columnIndex) {
		case 0:
		case 1:
		case 2:
		case 3:
		case 4:
		case 5:
			return JButton.class;
		default:
			return null;
		}
	}

	

	/*@Override
	public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
		Predmet predmet= StudenskaSluzba.getInstance().getListPredmeta().get(rowIndex);
		switch (columnIndex) {
		case 0:
			 predmet.setSifraPredmeta(aValue.toString());;
		case 1:
			 predmet.setNazivPredmeta(aValue.toString());
		case 2:
			 predmet.setSemestar(Integer.parseInt(aValue.toString()));
		case 3:
			 predmet.setGodinaStudija(Integer.parseInt(aValue.toString()));
		case 4:
			 predmet.getProfesor();
		
		}
	}*/

}
