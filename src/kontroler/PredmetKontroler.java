package kontroler;

import java.util.List;

import model.*;


public class PredmetKontroler {
	
	private static PredmetKontroler instance = null;
	
	public static PredmetKontroler getInstance() {
		if(instance==null)
			instance=new PredmetKontroler();
		return instance;
	}
	private PredmetKontroler() {
		
	}
	public void dodaj_predmet(String sifraPredmeta, String nazivPredmeta, int semestar, int godinaStudija, Profesor profesor,List<Student> listaStudenata) {
		Predmet p=new Predmet( sifraPredmeta,  nazivPredmeta,  semestar,  godinaStudija,  profesor, listaStudenata);
		StudenskaSluzba.getInstance().dodajPredmet(p);
	}
	public void obrisi_predmet(int rowSelectedIndex) {
		if(rowSelectedIndex<0) {
			return;
		}
		Predmet p=StudenskaSluzba.getInstance().getRowPredmeta(rowSelectedIndex);
		StudenskaSluzba.getInstance().izbrisiPredmet(p.getSifraPredmeta());
	}
	public void izmeni_predmet(int rowSelectedIndex) {
		if(rowSelectedIndex<0) {
			return;
		}
		// za sad se menja samo godina na 11
		Predmet p=StudenskaSluzba.getInstance().getRowPredmeta(rowSelectedIndex);
		StudenskaSluzba.getInstance().izmeniPredmet(p.getSifraPredmeta(), p.getNazivPredmeta(), 11,p.getGodinaStudija());
	}
	
}
