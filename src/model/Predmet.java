package model;
import java.util.*;

public class Predmet {
	String sifraPredmeta;
	String nazivPredmeta;
	int semestar;
	int godinaStudija;
	Profesor profesor;
	List<Student> listaStudenata;
	public Predmet(String sifraPredmeta, String nazivPredmeta, int semestar, int godinaStudija, Profesor profesor,
			List<Student> listaStudenata) {
		this.sifraPredmeta = sifraPredmeta;
		this.nazivPredmeta = nazivPredmeta;
		this.semestar = semestar;
		this.godinaStudija = godinaStudija;
		this.profesor = profesor;
		this.listaStudenata = listaStudenata;
	}
	
	
}
