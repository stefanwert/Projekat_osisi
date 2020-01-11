package pogled;

import javax.swing.table.AbstractTableModel;

import model.Predmet;
import model.StudenskaSluzba;

public class StudentiNaPredmetuJTableModel extends AbstractTableModel{

	@Override
	public Class<?> getColumnClass(int columnIndex) {
		return String.class;
	}
	
	@Override
	public int getRowCount() {
		int ret=0;
		//
		int i =MainFrame.getInstance().getTabelPredmeta().getSelectedRow();
		String s=(String)MainFrame.getInstance().getTabelPredmeta().getValueAt(i, 0);
		i=0;
		for (Predmet predmet : StudenskaSluzba.getInstance().getListPredmeta()) {
			if(s.equals(predmet.getSifraPredmeta())) {
				break;
			}
			i++;
		}
		ret=StudenskaSluzba.getInstance().getListPredmeta().get(i).getListaStudenata().size();
		
		return ret; 
	}
	
	@Override
	public int getColumnCount() {
		return 1;
	}
	
	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		int i =MainFrame.getInstance().getTabelPredmeta().getSelectedRow();
		String s=(String)MainFrame.getInstance().getTabelPredmeta().getValueAt(i, 0);
		i=0;
		for (Predmet predmet : StudenskaSluzba.getInstance().getListPredmeta()) {
			if(s.equals(predmet.getSifraPredmeta())) {
				break;
			}
			i++;
		}
		return StudenskaSluzba.getInstance().getListPredmeta().get(i).getListaStudenata().get(rowIndex).getBrojIndeksa();
	}
	
	@Override
	public String getColumnName(int columnIndex) {
		return "Broj indeksa";

	}
	
	@Override
	public boolean isCellEditable(int rowIndex, int columnIndex) {
		return false;
	}
}
