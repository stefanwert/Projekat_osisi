package ActionListener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import dialog.DialogPredmet;
import model.StudenskaSluzba;
import pogled.MainFrame;

public class ActionListenerRemove implements ActionListener{

	@Override
	public void actionPerformed(ActionEvent e) {
		if(MainFrame.getInstance().getTabbedPane().getSelectedIndex()==2) {
			try {
				int i=MainFrame.getInstance().getTabel().getSelectedRow();
				StudenskaSluzba.getInstance().izbrisiPredmet(i);
			} catch (Exception e2) {
				System.out.println("niste selektovali vrstu");
			}
			
		}
		else if(MainFrame.getInstance().getTabbedPane().getSelectedIndex()==0) {
		//ovde ide studentov 
		}
		else if(MainFrame.getInstance().getTabbedPane().getSelectedIndex()==1) {
		//ovde ide za profesora
		//tabovi moraju biti dodavani u ovom redosledu
		}
		
		
		MainFrame.getInstance().azurirajPrikaz();
	}

}
