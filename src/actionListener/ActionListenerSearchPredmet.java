package actionListener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

import pogled.MainFrame;
import pogled.MyToolbar;

public class ActionListenerSearchPredmet implements ActionListener{
	private TableRowSorter<TableModel> rowSorter=MainFrame.getTableRowSorterPredmet();
	private RowFilter<Object, Object> fooBarFilter;
	@Override
	public void actionPerformed(ActionEvent e) {
		JTextField tf=MyToolbar.getInstance().getTextFild();
		String text=tf.getText();
		if(text.endsWith(":")) {
			text=text+" ";
		}
		
		List<RowFilter<Object,Object>> filters = new ArrayList<RowFilter<Object,Object>>(2);
		String parts[]= text.split(";");
		String parts2[];
		for (String s : parts) {
			parts2=s.split(":");
			if(parts2[0].equals("sifra predmeta")) {
				//rowSorter.setRowFilter(RowFilter.regexFilter(parts2[1],0));
				filters.add(RowFilter.regexFilter(parts2[1],0));
			}
			else if(parts2[0].equals("naziv predmeta")) {
				//rowSorter.setRowFilter(RowFilter.regexFilter(parts2[1],1));
				filters.add(RowFilter.regexFilter(parts2[1],1));
			}
		}
		fooBarFilter = RowFilter.andFilter(filters);
		rowSorter.setRowFilter(fooBarFilter);
		
	}

}
