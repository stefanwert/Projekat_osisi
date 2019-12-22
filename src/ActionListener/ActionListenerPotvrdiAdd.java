package ActionListener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import dialog.DialogPredmet;
import kontroler.PredmetKontroler;
import model.Predmet;
import model.Profesor;
import model.StudenskaSluzba;

public class ActionListenerPotvrdiAdd implements ActionListener{

	@Override
	public void actionPerformed(ActionEvent e) {
		Profesor pro= new Profesor("profa", "profic", new java.sql.Date(23), "novi safd", "nema", "ne'am jbg","123", "123", "Redovni profesor vandredni dekan", "asdf", null);
		
		
		try {
			String sif=DialogPredmet.getInstance().readtxtsifra();
			String naz=DialogPredmet.getInstance().readtxtNazivPr();
			int sem= Integer.parseInt(DialogPredmet.getInstance().readtxtSemestar());
			int god=Integer.parseInt(DialogPredmet.getInstance().readtxtGodinaStudjia());
			//Predmet p=new Predmet(sif,naz,sem,god,pro,null);
			//StudenskaSluzba.getInstance().dodajPredmet(p);
			PredmetKontroler.getInstance().dodajPredmet(sif, naz, sem, god, pro, null);
		} catch (Exception e2) {
			
		}
		
		
		DialogPredmet.getInstance().dispose();
		DialogPredmet.removeInstance();
	}

}
