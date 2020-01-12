package actionListener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import dialog.DialogPredmet;
import dialog.DialogProfesor;
import dialog.DialogStudent;
import pogled.MainFrame;

public class ActionListenerEdit implements ActionListener{
	@Override
	public void actionPerformed(ActionEvent arg0) {
		
		if(MainFrame.getInstance().getTabbedPane().getSelectedIndex()==0) {
			try {
				DialogStudent.getInstance().call(MainFrame.getInstance(),"Izmeni studenta",true);
			} catch (Exception e) {
				System.out.println("Nista nije selektovano");
			}
		}
		else if(MainFrame.getInstance().getTabbedPane().getSelectedIndex()==1) {
			try {
				DialogProfesor.getInstance().call(MainFrame.getInstance(),"Izmeni profesora",true);
			} catch (Exception e) {
				System.out.println("Nista nije selektovano");
			}
		}
		else if(MainFrame.getInstance().getTabbedPane().getSelectedIndex()==2) {
			try {
				DialogPredmet.getInstance().call(MainFrame.getInstance(),"Izmeni predmet",true);
			} catch (Exception e) {
				System.out.println("Nista nije selektovano");
			}
			
		}		
		
		MainFrame.getInstance().azurirajPrikaz();
	}
}
