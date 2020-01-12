package actionListenerPredmet;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

import dialog.DialogPredmet;
import kontroler.PredmetKontroler;
import model.Predmet;
import model.Profesor;
import model.StudenskaSluzba;

public class ActionListenerPotvrdiAddPredmet implements ActionListener{

	@Override
	public void actionPerformed(ActionEvent e) {

		try {
			String sif=DialogPredmet.getInstance().readtxtsifra();
			String naz=DialogPredmet.getInstance().readtxtNazivPr();
			int sem= Integer.parseInt(DialogPredmet.getInstance().readtxtSemestar());
			int god=Integer.parseInt(DialogPredmet.getInstance().readtxtGodinaStudjia());
			PredmetKontroler.getInstance().dodajPredmet(sif, naz, sem, god, null, null);
		} catch (Exception e2) {
			
		}
		
		DialogPredmet.getInstance().dispose();
		DialogPredmet.removeInstance();
	}

}
