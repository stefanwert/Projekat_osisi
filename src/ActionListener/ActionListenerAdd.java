package ActionListener;

import java.awt.Dialog;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import dialog.DialogPredmet;
import model.Predmet;
import model.Profesor;
import model.StudenskaSluzba;
import pogled.MainFrame;

public class ActionListenerAdd implements ActionListener {
	@Override
	public void actionPerformed(ActionEvent arg0) {
		if(MainFrame.getInstance().getTabbedPane().getSelectedIndex()==2) {
				DialogPredmet d=new DialogPredmet(MainFrame.getInstance(),"DODAJ PREDMET",true);
				d.setVisible(true);
		}
		else if(MainFrame.getInstance().getTabbedPane().getSelectedIndex()==0) {
			//ovde ide studentov dialog
		}
		else if(MainFrame.getInstance().getTabbedPane().getSelectedIndex()==1) {
			//ovde ide dialog za profesora
			//tabovi moraju biti dodavani u ovom redosledu
		}
			
		
		
		MainFrame.getInstance().azurirajPrikaz();
	}

}
