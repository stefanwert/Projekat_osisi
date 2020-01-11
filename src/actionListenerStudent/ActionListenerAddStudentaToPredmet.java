package actionListenerStudent;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import dialog.DialogAddStudentToPredmet;
import pogled.MainFrame;

public class ActionListenerAddStudentaToPredmet implements ActionListener{

	@Override
	public void actionPerformed(ActionEvent e) {
		if(MainFrame.getInstance().getTabbedPane().getSelectedIndex()==2) {
			try {
				if(MainFrame.getInstance().getTabelPredmeta().getSelectedRow()!=-1)
				DialogAddStudentToPredmet.getInstance().call(MainFrame.getInstance(),"Dodaj studenta na predmet",true);
				
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
