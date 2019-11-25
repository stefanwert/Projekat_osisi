package model;
import java.util.*;

public class Studenska_sluzba {
	List<Student> listaStudenata=new ArrayList<Student>();
	List<Predmet> listaPredmeta=new ArrayList<Predmet>();
	List<Profesor> listaProfesora=new ArrayList<Profesor>();
	
	public Studenska_sluzba(List<Student> listaStudenata, List<Predmet> listaPredmeta, List<Profesor> listaProfesora) {
		this.listaStudenata = listaStudenata;
		this.listaPredmeta = listaPredmeta;
		this.listaProfesora = listaProfesora;
	}
	void dodaj_predmet(String sifraPredmeta, String nazivPredmeta, int semestar, int godinaStudija, Profesor profesor,List<Student> listaStudenata) {
		Predmet p=new Predmet( sifraPredmeta,  nazivPredmeta,  semestar,  godinaStudija,  profesor, listaStudenata);
		listaPredmeta.add(p);
	}
	boolean obrisi_predmet(String sifraPredmeta) {
		for (Predmet predmet : listaPredmeta) {
			if(sifraPredmeta.equals(predmet.getSifraPredmeta())) {
				listaPredmeta.remove(predmet);
				return true;
			}
		}
		return false;
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
