package actionListenerStudent;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import dialog.DialogAddStudentToPredmet;
import kontroler.PredmetKontroler;

public class ActionListenerPotvrdiAddStudentaToPredmet implements ActionListener{
	@Override
	public void actionPerformed(ActionEvent e) {
		try {
			String s =DialogAddStudentToPredmet.getInstance().readtxtBrojIndeksa();
			PredmetKontroler.getInstance().dodajStudenta(s);
			
		} catch (Exception e2) {
			System.out.println("nista nije selektovano");
		}
		
		DialogAddStudentToPredmet.getInstance().dispose();
		DialogAddStudentToPredmet.removeInstance();
	}

}
