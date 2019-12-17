package ActionListener;

import java.awt.Dialog;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import dialog.AddDialogPredmet;
import model.Predmet;
import model.Profesor;
import model.StudenskaSluzba;
import pogled.MainFrame;

public class ActionListenerAdd implements ActionListener {
	int a=0;
	@Override
	public void actionPerformed(ActionEvent arg0) {
		if(MainFrame.getInstance().getTabbedPane().getSelectedIndex()==0) {
//				Predmet p=new Predmet(Integer.toString(a++),"1234", 1, 1, 
//				new Profesor("profa", "profic", new java.sql.Date(23), "novi safd", "nema", "ne'am jbg","123", "123", "Redovni profesor vandredni dekan", "asdf", null), null);
//				StudenskaSluzba.getInstance().dodajPredmet(p);
		
				AddDialogPredmet d=new AddDialogPredmet(MainFrame.getInstance(),"DODAJ PREDMET",true);
				d.setVisible(true);
		}
		else if(MainFrame.getInstance().getTabbedPane().getSelectedIndex()==1) {
			//ovde ide studentov dialog
		}
		else if(MainFrame.getInstance().getTabbedPane().getSelectedIndex()==2) {
			//ovde ide dialog za profesora
			//tabovi moraju biti dodavani u ovom redosledu
		}
			
		
		
		MainFrame.getInstance().azurirajPrikaz();
	}

}
