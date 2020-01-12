package actionListener;

import java.awt.TextField;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.event.DocumentEvent;
import javax.swing.event.RowSorterListener;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

import pogled.MainFrame;
import pogled.MyToolbar;
import pogled.PredmetTableModel;

public class DocumentListenerForDelete implements javax.swing.event.DocumentListener{

	private TableRowSorter<TableModel> rowSorter=MainFrame.getTableRowSorterPredmet();
	private TableRowSorter<TableModel> rowSorter2=MainFrame.getTableRowSorterProfesor();
	private TableRowSorter<TableModel> rowSorter3=MainFrame.getTableRowSorterStudent();
	@Override
	public void removeUpdate(DocumentEvent e) {
		JTextField tf=MyToolbar.getInstance().getTextFild();
		String text=tf.getText();
		if(text.length()==0) {
			rowSorter.setRowFilter(null);
			rowSorter2.setRowFilter(null);
			rowSorter3.setRowFilter(null);
		}
		
	}
	
	@Override
	public void insertUpdate(DocumentEvent e) {
		
	}
	
	@Override
	public void changedUpdate(DocumentEvent e) {
		throw new UnsupportedOperationException("Not supported yet.");
	}

}
