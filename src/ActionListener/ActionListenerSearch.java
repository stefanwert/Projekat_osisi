package ActionListener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import dialog.DialogPredmet;
import pogled.MainFrame;

public class ActionListenerSearch implements ActionListener{

	@Override
	public void actionPerformed(ActionEvent e) {
		if(MainFrame.getInstance().getTabbedPane().getSelectedIndex()==0) {
			//ovde ide studentov dialog
		}
		else if(MainFrame.getInstance().getTabbedPane().getSelectedIndex()==1) {
			//ovde ide dialog za profesora
			//tabovi moraju biti dodavani u ovom redosledu
		}
		else if(MainFrame.getInstance().getTabbedPane().getSelectedIndex()==2) {
			
			
		}		
		
		MainFrame.getInstance().azurirajPrikaz();
	}

}
