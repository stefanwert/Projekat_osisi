package ActionListener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import dialog.DialogPredmet;
import pogled.MainFrame;

public class ActionListenerEdit implements ActionListener{
	public void actionPerformed(ActionEvent arg0) {
		if(MainFrame.getInstance().getTabbedPane().getSelectedIndex()==2) {
			try {
				DialogPredmet d=new DialogPredmet(MainFrame.getInstance(),"DODAJ PREDMET",true);
				d.setTxtFilds();
				d.setVisible(true);
			} catch (Exception e) {
				System.out.println("nisi selektovao nista");
			}
			
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
