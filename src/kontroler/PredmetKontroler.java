package kontroler;

import java.util.ArrayList;
import java.util.List;

import dialog.DialogSpisakStudenataNaPredmetu;
import model.*;
import pogled.MainFrame;
import pogled.StudentiNaPredmetuJTable;


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
		boolean postoji=false;
		ArrayList<Student> studenti=(ArrayList<Student>) StudenskaSluzba.getInstance().getListPredmeta().get(i).getListaStudenata();
		for (Student student : studenti) {
			if(student.getBrojIndeksa().equals(brojIndeksa)){
				postoji=true;
			}
		}
		if(!postoji){
			for (Student student : StudenskaSluzba.getInstance().getListStudenata()) {
				if(student.getBrojIndeksa().equals(brojIndeksa)) {
					StudenskaSluzba.getInstance().getListPredmeta().get(i).getListaStudenata().add(student);
				}
			}
		}
					
			
	}
	
	public void obrisiStudenta() {
		int i =MainFrame.getInstance().getTabelPredmeta().getSelectedRow();
		int j=DialogSpisakStudenataNaPredmetu.getInstance().getTable().getSelectedRow();
		String s=(String)MainFrame.getInstance().getTabelPredmeta().getValueAt(i, 0);
		i=0;
		System.out.println(s);
		for (Predmet predmet : StudenskaSluzba.getInstance().getListPredmeta()) {
			if(s.equals(predmet.getSifraPredmeta())) {
				break;
			}
			i++;
		}
		System.out.println(i+" "+j);
		StudenskaSluzba.getInstance().getListPredmeta().get(i).getListaStudenata().remove(j);
		DialogSpisakStudenataNaPredmetu.getInstance().updateTable();
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
	
	public void obrisiProfesora() {
		int i =MainFrame.getInstance().getTabelPredmeta().getSelectedRow();
		String s=(String)MainFrame.getInstance().getTabelPredmeta().getValueAt(i, 0);
		i=0;
		for (Predmet predmet : StudenskaSluzba.getInstance().getListPredmeta()) {
			if(s.equals(predmet.getSifraPredmeta())) {
				break;
			}
			i++;
		}
		
		StudenskaSluzba.getInstance().getListPredmeta().get(i).setProfesor(null);
	}
	
}
