package model;
import java.util.*;

import javax.swing.table.TableModel;
import javax.xml.crypto.dsig.keyinfo.RetrievalMethod;

import pogled.MainFrame;

public class StudenskaSluzba {
	List<Student> listaStudenata=new ArrayList<Student>();
	List<Predmet> listaPredmeta=new ArrayList<Predmet>();
	List<Profesor> listaProfesora=new ArrayList<Profesor>();
	
	private List<String> kolonePredmeta;
	
	private static StudenskaSluzba instance =null;
	
	public static StudenskaSluzba getInstance() {
		if(instance==null) {
			instance=new StudenskaSluzba();
		}
		return instance;
	}
	
	public List<Predmet> getListPredmeta() {
		return listaPredmeta;
	}
	
	private StudenskaSluzba() {
		kolonePredmeta=new ArrayList<String>();
		kolonePredmeta.add("Sifra predmeta");
		kolonePredmeta.add("Naziv predmeta");
		kolonePredmeta.add("Semestar");
		kolonePredmeta.add("Godina studija");
		kolonePredmeta.add("Profesor");
		Predmet p=new Predmet("123","1234", 1, 1, 
				new Profesor("profa", "profic", new java.sql.Date(23), "novi safd", "nema", "ne'am jbg",
"123", "123", "Redovni profesor vandredni dekan", "asdf", null), null);
		p.setNazivPredmeta("dgsasdfgafd");
		listaPredmeta.add(p);
	}
	
	public String getColumnNamePredmeta(int i) {
		return kolonePredmeta.get(i);
	}
	
	public int getColumCountPredmeta() {
		return kolonePredmeta.size();
	}
	
	public List<Predmet> getPremet(){
		return listaPredmeta;
	}
	
	public void setPredmet(List<Predmet> predmeti) {
		this.listaPredmeta=predmeti;
	}
	
	public Predmet getRowPredmeta(int rowIndex) {
		return this.listaPredmeta.get(rowIndex);
	}
	
	public String getValueAtPredmet(int row,int column) {
		Predmet predmet=this.listaPredmeta.get(row);
		switch (column) {
		case 0:
			return predmet.getSifraPredmeta();
		case 1:
			return predmet.getNazivPredmeta();
		case 2:
			return Integer.toString(predmet.getSemestar());
		case 3:
			return Integer.toString(predmet.getGodinaStudija());
		case 4:
			return predmet.getProfesor().getIme()+predmet.getProfesor().getPrezime();
		default:
			return null;
		}
	}
	
	public boolean dodajPredmet(Predmet p) {
		for (Predmet predmet : listaPredmeta) {
			if(predmet.sifraPredmeta==p.sifraPredmeta)
				return false;
		}
		listaPredmeta.add(p);
		return true;
	}
	
	public boolean izbrisiPredmet(String sp) {
		for (Predmet predmet : listaPredmeta) {
			if(predmet.getSifraPredmeta().equals(sp)) {
				listaPredmeta.remove(predmet);
				return true;
			}	
		}	
		return false;	
	}
	public void izmeniPredmet(String sifraPredmeta, String nazivPredmeta, int semestar, int godinaStudija) {
		boolean jedistven=true;
		for (Predmet predmet : listaPredmeta) {
			if(predmet.getSifraPredmeta().equals(sifraPredmeta)) {
				jedistven=false;
			}
		}
		if(jedistven) {
			int i =MainFrame.getTabel().getSelectedRow();
			listaPredmeta.get(i).setSifraPredmeta(sifraPredmeta);
			listaPredmeta.get(i).setNazivPredmeta(nazivPredmeta);
			listaPredmeta.get(i).setSemestar(semestar);
			listaPredmeta.get(i).setGodinaStudija(godinaStudija);
		}
		else
			System.out.println("pokuslai ste da promenite kljuc u kljuc koji vec postoji");
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
