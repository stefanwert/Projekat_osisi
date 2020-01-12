package actionListener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import dialog.DialogPredmet;
import dialog.DialogProfesor;
import dialog.DialogStudent;
import pogled.MainFrame;

public class ActionListenerAdd implements ActionListener {
	@Override
	public void actionPerformed(ActionEvent arg0) {
		
		if(MainFrame.getInstance().getTabbedPane().getSelectedIndex()==0) {
			DialogStudent.getInstance().call(MainFrame.getInstance(),"Dodaj studenta",true);
		}
		else if(MainFrame.getInstance().getTabbedPane().getSelectedIndex()==1) {
			DialogProfesor.getInstance().call(MainFrame.getInstance(),"Dodaj profesora",true);
		}
		else if(MainFrame.getInstance().getTabbedPane().getSelectedIndex()==2) {
			DialogPredmet.getInstance().call(MainFrame.getInstance(),"DODAJ PREDMET",true);
	    }
			
		MainFrame.getInstance().azurirajPrikaz();
	}

}
