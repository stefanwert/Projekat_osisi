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
			DialogStudent ds = new DialogStudent(MainFrame.getInstance(),"Dodaj studenta",true);
			ds.setVisible(true);
		}
		else if(MainFrame.getInstance().getTabbedPane().getSelectedIndex()==1) {
			DialogProfesor dp = new DialogProfesor(MainFrame.getInstance(),"Dodaj profesora",true);
			dp.setVisible(true);
		}
		else if(MainFrame.getInstance().getTabbedPane().getSelectedIndex()==2) {
			DialogPredmet d=new DialogPredmet(MainFrame.getInstance(),"DODAJ PREDMET",true);
			d.setVisible(true);
	    }
			
		MainFrame.getInstance().azurirajPrikaz();
	}

}
