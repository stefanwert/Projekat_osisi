package dialog;

import java.awt.BorderLayout;
import java.awt.Frame;

import javax.swing.JDialog;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import pogled.StudentiNaPredmetuJTable;

public class DialogSpisakStudenataNaPredmetu extends JDialog{
	
	 private static DialogSpisakStudenataNaPredmetu instance =null;
		
		static public DialogSpisakStudenataNaPredmetu getInstance() {
			if(instance==null) {
				instance=new DialogSpisakStudenataNaPredmetu();
			}
			return instance;
		}
		public static void removeInstance() {
			instance=null;
		}
		
		private JTable tabelaStudenataNaPredmetu;
		
		public void call(Frame parent, String title, boolean modal) {
			this.setLocationRelativeTo(parent);
			this.setTitle(title);
			this.setModal(modal);
			
			setSize(300,300);
			setLocationRelativeTo(parent);
			setLayout(new BorderLayout(10,10));
			setResizable(false);
			
			tabelaStudenataNaPredmetu = new StudentiNaPredmetuJTable();
			JScrollPane scrollPane = new JScrollPane(tabelaStudenataNaPredmetu);
			add(scrollPane, BorderLayout.CENTER);
			
			setVisible(true);
			
		}

}
