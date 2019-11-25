package kontroler;

import java.util.List;

import model.Predmet;
import model.Profesor;
import model.Student;

public class Predmet_kontroler {
	void dodaj_predmet(String sifraPredmeta, String nazivPredmeta, int semestar, int godinaStudija, Profesor profesor,List<Student> listaStudenata,List<Predmet> listaPredmeta) {
		Predmet p=new Predmet( sifraPredmeta,  nazivPredmeta,  semestar,  godinaStudija,  profesor, listaStudenata);
		listaPredmeta.add(p);
	}
	void obrisi_predmet(String sifraPredmeta,List<Predmet> listaPredmeta) {
		for (Predmet predmet : listaPredmeta) {
			if(sifraPredmeta.equals(predmet.getSifraPredmeta())) {
				listaPredmeta.remove(predmet);
			}
		}
	}
	void izmeni_predmet(String sifraPredmeta, String nazivPredmeta, int semestar, int godinaStudija, Profesor profesor,List<Student> listaStudenata,Predmet stari) {
		stari.setSifraPredmeta(sifraPredmeta);
		stari.setNazivPredmeta(nazivPredmeta);
		stari.setSemestar(semestar);
		stari.setGodinaStudija(godinaStudija);
		stari.setProfesor(profesor);
		stari.setListaStudenata(listaStudenata);
	}
	
}
