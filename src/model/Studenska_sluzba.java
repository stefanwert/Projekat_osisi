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

}
