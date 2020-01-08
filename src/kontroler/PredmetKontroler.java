package kontroler;

import java.util.List;

import model.*;
import pogled.MainFrame;


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
	
	public void dodajStudenta(String brojIndeksa) {
		int i =MainFrame.getInstance().getTabelPredmeta().getSelectedRow();
		String s=(String)MainFrame.getInstance().getTabelPredmeta().getValueAt(i, 0);
		i=0;
		for (Predmet predmet : StudenskaSluzba.getInstance().getListPredmeta()) {
			if(s.equals(predmet.getSifraPredmeta())) {
				break;
			}
			i++;
		}
		List<Student> listaStudenata = null;
		for (Student student : StudenskaSluzba.getInstance().getListStudenata()) {
			if(student.getBrojIndeksa().equals(brojIndeksa)) {
			
				listaStudenata.add(student);
				StudenskaSluzba.getInstance().getListPredmeta().get(i).setListaStudenata(listaStudenata);
			}
		}
	}
	
	public void dodajProfesora(String brLicne) {
		int i =MainFrame.getInstance().getTabelPredmeta().getSelectedRow();
		String s=(String)MainFrame.getInstance().getTabelPredmeta().getValueAt(i, 0);
		i=0;
		for (Predmet predmet : StudenskaSluzba.getInstance().getListPredmeta()) {
			if(s.equals(predmet.getSifraPredmeta())) {
				break;
			}
			i++;
		}
		Profesor p=null;
		for (Profesor profesor : StudenskaSluzba.getInstance().getListProfesora()) {
			if(profesor.getBrLicneKarte().equals(brLicne)) {
				//
				StudenskaSluzba.getInstance().getListPredmeta().get(i).setProfesor(profesor);
			}
		}
	}
	
}
