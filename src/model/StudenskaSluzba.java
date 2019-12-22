package model;
import java.util.ArrayList;
import java.util.List;

import pogled.MainFrame;

public class StudenskaSluzba {
	List<Student> listaStudenata=new ArrayList<Student>();
	List<Predmet> listaPredmeta=new ArrayList<Predmet>();
	List<Profesor> listaProfesora=new ArrayList<Profesor>();
	
	private List<String> kolonePredmeta;
	private List<String> koloneStudenata;
	
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
	
	public List<Student> getListStudenata() {
		return listaStudenata;
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
		
		koloneStudenata = new ArrayList<String>();
		koloneStudenata.add("Index");
		koloneStudenata.add("Ime");
		koloneStudenata.add("Prezime");
		koloneStudenata.add("Godina studija");
		koloneStudenata.add("Status");
		koloneStudenata.add("Prosek");
		Student s = new Student("Nemanja","Tamindzija",new java.sql.Date(1997),"adresa","066/123-456","nemanja.tam@gmail.com",
				"RA242-2018",new java.sql.Date(2018),3,Student.Status.B,7.5,listaPredmeta);
		listaStudenata.add(s);
		
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
	
	public String getColumnNameStudenata(int i) {
		return koloneStudenata.get(i);
	}
	
	public int getColumCountStudenata() {
		return koloneStudenata.size();
	}
	
	public List<Student> getStudent(){
		return listaStudenata;
	}
	
	public void setStudent(List<Student> studenti) {
		this.listaStudenata=studenti;
	}
	
	public Student getRowStudenata(int rowIndex) {
		return this.listaStudenata.get(rowIndex);
	}
	
	public String getValueAtStudent(int row,int column) {
		Student student=this.listaStudenata.get(row);
		switch (column) {
		case 0:
			return student.getBrojIndeksa();
		case 1:
			return student.getIme();
		case 2:
			return student.getPrezime();
		case 3:
			return Integer.toString(student.getTrenutnaGodina());
		case 4:
			return student.getStatus().toString();
		case 5:
			return Double.toString(student.getProsecnaOcena());
		default:
			return null;
		}
	}
	
	
	public boolean dodajPredmet(Predmet p) {
		for (Predmet predmet : listaPredmeta) {
			if(predmet.sifraPredmeta.equals(p.getSifraPredmeta()))
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
	
	public boolean izbrisiPredmet(int i) {
		listaPredmeta.remove(i);
		return true;
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
