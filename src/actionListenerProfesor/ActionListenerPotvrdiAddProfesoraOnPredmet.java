package actionListenerProfesor;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import dialog.DialogAddProfesorToPredmet;
import kontroler.PredmetKontroler;

public class ActionListenerPotvrdiAddProfesoraOnPredmet implements ActionListener {
	@Override
	public void actionPerformed(ActionEvent e) {
		try {
			String s=DialogAddProfesorToPredmet.getInstance().readtxt();
			PredmetKontroler.getInstance().dodajProfesora(s);
			
		} catch (Exception e2) {
			System.out.println("nista nije selektovano");
		}
		
		DialogAddProfesorToPredmet.getInstance().dispose();
		DialogAddProfesorToPredmet.removeInstance();
	}
	
}
