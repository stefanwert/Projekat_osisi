package actionListener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import kontroler.PredmetKontroler;
import kontroler.ProfesorKontroler;
import kontroler.StudentKontroler;
import pogled.MainFrame;

public class ActionListenerRemove implements ActionListener{

	@Override
	public void actionPerformed(ActionEvent e) {
	
		if(MainFrame.getInstance().getTabbedPane().getSelectedIndex()==0) {
			int choice = JOptionPane.showConfirmDialog(null,"Da li ste sigurni da zelite da izbrisete studenta?","Brisanje studenta",JOptionPane.YES_NO_OPTION);
			if( choice == JOptionPane.YES_NO_OPTION){
				try {
					int i = MainFrame.getInstance().getTabelStudenta().getSelectedRow();
					System.out.println(i);
					String s=(String)MainFrame.getInstance().getTabelStudenta().getValueAt(i, 0);
					System.out.println(s);
					StudentKontroler.getInstance().obrisiStudenta(s);
				} catch (Exception e2) {
				System.out.println("niste selektovali vrstu u tabeli profesor");
				}
			}
		}
		else if(MainFrame.getInstance().getTabbedPane().getSelectedIndex()==1) {
			int choice = JOptionPane.showConfirmDialog(null,"Da li ste sigurni da zelite da izbrisete profesora?","Brisanje profesora",JOptionPane.YES_NO_OPTION);
			if( choice == JOptionPane.YES_NO_OPTION){
				try {
					int i = MainFrame.getInstance().getTabelProfesora().getSelectedRow();
					System.out.println(i);
					String s=(String)MainFrame.getInstance().getTabelProfesora().getValueAt(i, 7);
					System.out.println(s);
					ProfesorKontroler.getInstance().obrisiProfesora(s);
				} catch (Exception e2) {
				System.out.println("niste selektovali vrstu u tabeli profesor");
				}
			}
		}
		else if(MainFrame.getInstance().getTabbedPane().getSelectedIndex()==2) {
			int choice = JOptionPane.showConfirmDialog(null,"Da li ste sigurni da zelite da izbrisete predmet?","Brisanje predmeta",JOptionPane.YES_NO_OPTION);
			if( choice == JOptionPane.YES_NO_OPTION){
				try {
					int i = MainFrame.getInstance().getTabelPredmeta().getSelectedRow();
					System.out.println(i);
					String s=(String)MainFrame.getInstance().getTabelPredmeta().getValueAt(i, 0);
					//StudenskaSluzba.getInstance().izbrisiPredmet(s);
					PredmetKontroler.getInstance().obrisiPredmet(s);
				} catch (Exception e2) {
				System.out.println("niste selektovali vrstu u tabeli predmet");
				}
			}
		}
		
		MainFrame.getInstance().azurirajPrikaz();
	}

}
