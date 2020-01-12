package dialog;

import java.awt.BorderLayout;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import kontroler.PredmetKontroler;
import pogled.StudentiNaPredmetuJTable;
import pogled.StudentiNaPredmetuTableModel;

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
		static private JButton obrisi;
		public void updateTable(){
			StudentiNaPredmetuTableModel model =(StudentiNaPredmetuTableModel) tabelaStudenataNaPredmetu.getModel();
			model.fireTableDataChanged();
		}
		
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
			
			obrisi=new JButton("Obrisi");
			obrisi.addActionListener(new ActionListener() {
				
				public void actionPerformed(ActionEvent e) {
					try {
						if(tabelaStudenataNaPredmetu.getSelectedRow()!=-1) {
							PredmetKontroler.getInstance().obrisiStudenta();
						}				
					} catch (Exception e2) {
						System.out.println("nista nije selektovano");
					}
				}
			});
			
			add(obrisi, BorderLayout.SOUTH);
			
			setVisible(true);
			
		}
		
		public JTable getTable(){
			return tabelaStudenataNaPredmetu;
		}

}
