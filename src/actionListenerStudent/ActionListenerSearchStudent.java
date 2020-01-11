package actionListenerStudent;

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

public class ActionListenerSearchStudent implements ActionListener {
	
	private TableRowSorter<TableModel> rowSorter=MainFrame.getTableRowSorterStudent();
	private RowFilter<Object, Object> fooBarFilter;
	@Override
	public void actionPerformed(ActionEvent e) {
		JTextField tf=MyToolbar.getInstance().getTextFild();
		String text=tf.getText();
		
		
		List<RowFilter<Object,Object>> filters = new ArrayList<RowFilter<Object,Object>>(2);
		String parts[]= text.split(";");
		String parts2[];
		for (String s : parts) {
			parts2=s.split(":");
			if(parts2[0].equalsIgnoreCase("broj indeksa")) {
				filters.add(RowFilter.regexFilter(parts2[1],0));
			}
			else if(parts2[0].equalsIgnoreCase("ime")) {
				filters.add(RowFilter.regexFilter(parts2[1],1));
			}
			else if(parts2[0].equalsIgnoreCase("prezime")) {
				filters.add(RowFilter.regexFilter(parts2[1],2));
			}
			else if(parts2[0].equalsIgnoreCase("godina studija")) {
				filters.add(RowFilter.regexFilter(parts2[1],3));
			}
			else if(parts2[0].equalsIgnoreCase("status")) {
				filters.add(RowFilter.regexFilter(parts2[1],4));
			}
			else if(parts2[0].equalsIgnoreCase("prosek")) {
				filters.add(RowFilter.regexFilter(parts2[1],5));
			}
		}
		fooBarFilter = RowFilter.andFilter(filters);
		rowSorter.setRowFilter(fooBarFilter);
	}
}
