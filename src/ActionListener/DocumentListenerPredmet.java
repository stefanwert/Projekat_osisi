package ActionListener;

import java.awt.TextField;

import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.event.DocumentEvent;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

import pogled.MainFrame;
import pogled.MyToolbar;

public class DocumentListenerPredmet implements javax.swing.event.DocumentListener{

	private TableRowSorter<TableModel> rowSorter=MainFrame.getTableRowSorterPredmet();
	@Override
	public void removeUpdate(DocumentEvent e) {
		JTextField tf=MyToolbar.getInstance().getTextFild();
		String text=tf.getText();
		
		if(text.trim().length()==0) {
			rowSorter.setRowFilter(null);
        } else {
            rowSorter.setRowFilter(RowFilter.regexFilter("(?i)" + text));
        }
	}
	
	@Override
	public void insertUpdate(DocumentEvent e) {
		JTextField tf=MyToolbar.getInstance().getTextFild();
	
		String text = tf.getText();

        if (text.trim().length() == 0) {
            rowSorter.setRowFilter(null);
        } else {
            rowSorter.setRowFilter(RowFilter.regexFilter("(?i)" + text));
        }
	}
	
	@Override
	public void changedUpdate(DocumentEvent e) {
		throw new UnsupportedOperationException("Not supported yet.");
	}

}
