package ActionListener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import dialog.AddDialogPredmet;
import model.Predmet;
import model.Profesor;
import model.StudenskaSluzba;

public class ActionListenerPotvrdiAdd implements ActionListener{

	@Override
	public void actionPerformed(ActionEvent e) {
		Profesor pro= new Profesor("profa", "profic", new java.sql.Date(23), "novi safd", "nema", "ne'am jbg","123", "123", "Redovni profesor vandredni dekan", "asdf", null);
		String sif=AddDialogPredmet.getInstance().readtxtsifra();
		String naz=AddDialogPredmet.getInstance().readtxtNazivPr();
		int sem= Integer.parseInt(AddDialogPredmet.getInstance().readtxtSemestar());
		int god=Integer.parseInt(AddDialogPredmet.getInstance().readtxtGodinaStudjia());
		Predmet p=new Predmet(sif,naz,sem,god,pro,null);
		StudenskaSluzba.getInstance().dodajPredmet(p);
		AddDialogPredmet.getInstance().dispose();
		AddDialogPredmet.removeInstance();
	}

}
