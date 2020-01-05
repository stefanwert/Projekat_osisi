package actionListener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import dialog.DialogoAddProfesorToPredmet;
import kontroler.PredmetKontroler;

public class ActionListenerPotvrdiAddProfesoraOnPredmet implements ActionListener {
	@Override
	public void actionPerformed(ActionEvent e) {
		try {
			String s=DialogoAddProfesorToPredmet.getInstance().readtxt();
			PredmetKontroler.getInstance().dodajProfesora(s);
			
		} catch (Exception e2) {
			System.out.println("nista nije selektovano");
		}
		
		DialogoAddProfesorToPredmet.getInstance().dispose();
		DialogoAddProfesorToPredmet.removeInstance();
	}
	

}
