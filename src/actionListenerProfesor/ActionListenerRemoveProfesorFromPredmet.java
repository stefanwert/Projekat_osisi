package actionListenerProfesor;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import kontroler.PredmetKontroler;
import pogled.MainFrame;

public class ActionListenerRemoveProfesorFromPredmet implements ActionListener{

	@Override
	public void actionPerformed(ActionEvent e) {
		if(MainFrame.getInstance().getTabbedPane().getSelectedIndex()==2) {
			try {
				if(MainFrame.getInstance().getTabelPredmeta().getSelectedRow()!=-1) {
					PredmetKontroler.getInstance().obrisiProfesora();
				}
					
				
			} catch (Exception e2) {
				System.out.println("nista nije selektovano");
			}
		}
		else {
			System.out.println("nije selektovan predmet tab");
		}
		

		MainFrame.getInstance().azurirajPrikaz();
		
	}

}
