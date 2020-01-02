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
	
	public void dodajPredmet(String sifraPredmeta, String nazivPredmeta, int semestar, int godinaStudija, Profesor profesor,List<Student> listaStudenata) {
		Predmet p=new Predmet( sifraPredmeta,  nazivPredmeta,  semestar,  godinaStudija,  profesor, listaStudenata);
		StudenskaSluzba.getInstance().dodajPredmet(p);
	}
	
	public void obrisiPredmet(String s) {
		StudenskaSluzba.getInstance().izbrisiPredmet(s);
	}
	
	public void izmeniPredmet(String sifraStara,String sifraPredmeta, String nazivPredmeta, int semestar, int godinaStudija) {
		StudenskaSluzba.getInstance().izmeniPredmet(sifraStara,sifraPredmeta, nazivPredmeta, semestar, godinaStudija);
	}
	
}
