package actionListener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import dialog.DialogPredmet;
import kontroler.PredmetKontroler;
import model.StudenskaSluzba;

public class ActionListenerPotvrdiEditPredmet implements ActionListener {
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
	try {
		String sif=DialogPredmet.getInstance().readtxtsifra();
		String naz=DialogPredmet.getInstance().readtxtNazivPr();
		int sem= Integer.parseInt(DialogPredmet.getInstance().readtxtSemestar());
		int god=Integer.parseInt(DialogPredmet.getInstance().readtxtGodinaStudjia());
		PredmetKontroler.getInstance().izmeniPredmet(sif, naz, sem, god);
		
	} catch (Exception e2) {
		// TODO: handle exception
	}

	DialogPredmet.getInstance().dispose();
	DialogPredmet.removeInstance();

	}
}



