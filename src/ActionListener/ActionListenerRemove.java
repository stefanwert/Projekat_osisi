package ActionListener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import dialog.DialogPredmet;
import kontroler.PredmetKontroler;
import kontroler.ProfesorKontroler;
import model.StudenskaSluzba;
import pogled.MainFrame;

public class ActionListenerRemove implements ActionListener{

	@Override
	public void actionPerformed(ActionEvent e) {
		if(MainFrame.getInstance().getTabbedPane().getSelectedIndex()==2) {
			try {
				int i=MainFrame.getInstance().getTabelPredmeta().getSelectedRow();
				System.out.println(i);
				String s=(String)MainFrame.getInstance().getTabelPredmeta().getValueAt(i, 0);
				//StudenskaSluzba.getInstance().izbrisiPredmet(s);
				PredmetKontroler.getInstance().obrisiPredmet(s);
			} catch (Exception e2) {
				System.out.println("niste selektovali vrstu");
			}
			
		}
		else if(MainFrame.getInstance().getTabbedPane().getSelectedIndex()==0) {
		//ovde ide studentov 
		}
		else if(MainFrame.getInstance().getTabbedPane().getSelectedIndex()==1) {
			try {
				int i=MainFrame.getInstance().getTabelProfesora().getSelectedRow();
				System.out.println(i);
				String s=(String)MainFrame.getInstance().getTabelProfesora().getValueAt(i, 7);
				System.out.println(s);
				ProfesorKontroler.getInstance().obrisiProfesora(s);
			} catch (Exception e2) {
				System.out.println("niste selektovali vrstu u tabeli profesor");
			}
		}
		
		
		MainFrame.getInstance().azurirajPrikaz();
	}

}
