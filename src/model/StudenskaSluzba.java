package model;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import model.Student.Status;
import pogled.MainFrame;

public class StudenskaSluzba {
	List<Student> listaStudenata=new ArrayList<Student>();
	List<Predmet> listaPredmeta=new ArrayList<Predmet>();
	List<Profesor> listaProfesora=new ArrayList<Profesor>();
	
	private List<String> kolonePredmeta;
	private List<String> koloneStudenata;
	private List<String> koloneProfesora;
	
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
	
	public List<Profesor> getListProfesora() {
		return listaProfesora;
	}
	
	private StudenskaSluzba() {
		kolonePredmeta=new ArrayList<String>();
		kolonePredmeta.add("Sifra predmeta");
		kolonePredmeta.add("Naziv predmeta");
		kolonePredmeta.add("Semestar");
		kolonePredmeta.add("Godina studija");
		kolonePredmeta.add("Profesor");
		Predmet p=new Predmet("123","1234", 1, 1, 
				/*new Profesor("profa", "profic", new java.sql.Date(23), "novi safd", "nema", "ne'am jbg",
"123", "123", "Redovni profesor vandredni dekan", "asdf", null)*/null, null);
		p.setNazivPredmeta("dgsasdfgafd");
		listaPredmeta.add(p);
		
		koloneStudenata = new ArrayList<String>();
		koloneStudenata.add("Index");
		koloneStudenata.add("Ime");
		koloneStudenata.add("Prezime");
		koloneStudenata.add("Godina studija");
		koloneStudenata.add("Status");
		koloneStudenata.add("Prosek");
		Student s = new Student("Nemanja","Tamindzija",new Date(2018,12,01),"adresa","066/123-456","nemanja.tam@gmail.com",
				"RA242-2018",new java.sql.Date(2018),3,Student.Status.B,7.5,listaPredmeta);
		listaStudenata.add(s);
		
		koloneProfesora= new ArrayList<String>();
		koloneProfesora.add("Ime");
		koloneProfesora.add("Prezime");
		koloneProfesora.add("Datum");
		koloneProfesora.add("Adresa stanovanja");
		koloneProfesora.add("Kontakt telefon");
		koloneProfesora.add("Email");
		koloneProfesora.add("Adresa kancelarije");
		koloneProfesora.add("Broj licne karte");
		koloneProfesora.add("Titula");
		koloneProfesora.add("Zvanje");
		listaProfesora.add(new Profesor("stefan","petrovic",new Date(2000,11,11),"adresa","tel","email","adresaKan","ovoJeKljuc","titula","zvanje",null));
	}
	
	//za studenta deo
	
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
			return student.getIme();
		case 1:
			return student.getPrezime();
		case 2:
			SimpleDateFormat formatterdr=new SimpleDateFormat("dd.MM.yyyy");
			String dr=formatterdr.format(student.getDatumRodjenja());
			return dr;
		case 3:
			return student.getAdresaStanovanja();
		case 4:
			return student.getKontaktTelefon();
		case 5:
			return student.getEmail();
		case 6:
			return student.getBrojIndeksa();
		case 7:
			SimpleDateFormat formatterdu=new SimpleDateFormat("dd.MM.yyyy");
			String du=formatterdu.format(student.getDatumUpisa());
			return du;
		case 8:
			return Integer.toString(student.getTrenutnaGodina());
		case 9:
			return student.getStatus().toString();
		case 10:
			return Double.toString(student.getProsecnaOcena());
		default:
			return null;
		}
	}
	
	
	public boolean dodajStudenta(Student s) {
		for (Student student : listaStudenata) {
			if(student.getBrojIndeksa().equals(s.getBrojIndeksa()))
				return false;
		}
		listaStudenata.add(s);
		return true;
	}
	
	public boolean obrisiStudenta(String brindx) {
		for (Student student : listaStudenata) {
			if(student.getBrojIndeksa().equals(brindx)) {
				listaStudenata.remove(student);
				return true;
			}	
		}	
		return false;	
	}
	
	public boolean obrisiStudenta(int i) {
		listaStudenata.remove(i);
		return true;
	}
	
	public void izmeniStudenta(String ime, String prezime, Date datumRodjenja, String adresaStanovanja, String kontaktTelefon,
			String email, String brojIndeksa, Date datumUpisa, int trenutnaGodina, Status status,
			double prosecnaOcena, List<Predmet> listaPredmeta,Student stari){
		
		boolean jedistven=true;
		for (Student student : listaStudenata) {
			if(student.getBrojIndeksa().equals(brojIndeksa)) {
				jedistven=false;
			}
		}
		
		int i = MainFrame.getInstance().getTabelStudenta().getSelectedRow();
		if(jedistven) {
			listaStudenata.get(i).setBrojIndeksa(brojIndeksa);
		}
		else
			System.out.println("pokuslai ste da promenite kljuc u kljuc koji vec postoji");
		listaStudenata.get(i).setIme(ime);
		listaStudenata.get(i).setPrezime(prezime);
		listaStudenata.get(i).setDatumRodjenja(datumRodjenja);
		listaStudenata.get(i).setAdresaStanovanja(adresaStanovanja);
		listaStudenata.get(i).setKontaktTelefon(kontaktTelefon);
		listaStudenata.get(i).setEmail(email);
		listaStudenata.get(i).setBrojIndeksa(brojIndeksa);
		listaStudenata.get(i).setDatumUpisa(datumUpisa);
		listaStudenata.get(i).setTrenutnaGodina(trenutnaGodina);
		listaStudenata.get(i).setStatus(status);
		listaStudenata.get(i).setProsecnaOcena(prosecnaOcena);
		
	}
	
	//za profesora deo
	
	public String getColumnNameProfesora(int i) {
		return koloneProfesora.get(i);
	}
	
	public int getColumCountProfesora() {
		return koloneProfesora.size();
	}
	public Profesor getRowProfesora(int rowIndex) {
		return this.listaProfesora.get(rowIndex);
	}
	
	public String getValueAtProfesor(int row,int column) {
		Profesor profesor=this.getRowProfesora(row);
		switch (column) {
		case 0:
			return profesor.getIme();
		case 1:
			return profesor.getPrezime();
		case 2:
			SimpleDateFormat formatter=new SimpleDateFormat("dd.MM.yyyy");
			String s=formatter.format(profesor.getDatum());
			return s;
		case 3:
			return profesor.getAdresaStanovanja();
		case 4:
			return profesor.getKontaktTel();
		case 5:
			return profesor.getEmail();
		case 6:
			return profesor.getAdresaKancelarije();
		case 7:
			return profesor.getBrLicneKarte();
		case 8:
			return profesor.getTitula();
		case 9:
			return profesor.getZvanje();
		default:
			return null;
		}
	}
	
	public boolean dodajProfesora(Profesor p) {
		for (Profesor profesor : listaProfesora) {
			if(profesor.getBrLicneKarte().equals(p.getBrLicneKarte()))
				return false;
		}
		listaProfesora.add(p);
		return true;
	}
	
	public boolean izbrisiProfesora(String brLicKarte) {
		for (Profesor profesor : listaProfesora) {
			if(profesor.getBrLicneKarte().equals(brLicKarte)) {
				listaProfesora.remove(profesor);
				return true;
			}	
		}	
		return false;	
	}
	
	public boolean izbrisiProfesora(int i) {
		listaProfesora.remove(i);
		return true;
	}
	
	public void izmeniProfesora(String ime, String prezime, Date datum, String adresaStanovanja, String kontaktTel, String email,
			String adresaKancelarije, String brLicneKarte, String titula, String zvanje) {
		boolean jedistven=true;
		for (Profesor profesor : listaProfesora) {
			if(profesor.getBrLicneKarte().equals(brLicneKarte)) {
				jedistven=false;
			}
		}
		
		int i =MainFrame.getInstance().getTabelProfesora().getSelectedRow();
		if(jedistven) {
			listaProfesora.get(i).setBrLicneKarte(brLicneKarte);
		}
		else
			System.out.println("pokuslai ste da promenite kljuc u kljuc koji vec postoji");
		listaProfesora.get(i).setIme(ime);
		listaProfesora.get(i).setPrezime(prezime);
		System.out.println(datum);
		listaProfesora.get(i).setDatum(datum);
		listaProfesora.get(i).setAdresaStanovanja(adresaStanovanja);
		listaProfesora.get(i).setKontaktTel(kontaktTel);
		listaProfesora.get(i).setEmail(email);
		listaProfesora.get(i).setAdresaKancelarije(adresaKancelarije);
		listaProfesora.get(i).setTitula(titula);
		listaProfesora.get(i).setZvanje(zvanje);
		
		
	}
	
	//za predmet deo
	
	public String getColumnNamePredmeta(int i) {
		return kolonePredmeta.get(i);
	}
	
	public int getColumCountPredmeta() {
		return kolonePredmeta.size();
	}
	
	/*public List<Predmet> getPremet(){
		return listaPredmeta;
	}*/
	
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
			if(predmet.getProfesor()==null) {
				return "Null";
			}
			return predmet.getProfesor().getIme()+" "+predmet.getProfesor().getPrezime();
		default:
			return null;
		}
	}
	
	public boolean dodajPredmet(Predmet p) {
		for (Predmet predmet : listaPredmeta) {
			if(predmet.getSifraPredmeta().equals(p.getSifraPredmeta()))
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
	
	public void izmeniPredmet(String sifraStara,String sifraPredmeta, String nazivPredmeta, int semestar, int godinaStudija) {
//		boolean jedistven=true;
//		int i = MainFrame.getInstance().getTabelPredmeta().getSelectedRow();
		int i=0;
		for (Predmet predmet : listaPredmeta) {
			if(predmet.getSifraPredmeta().equals(sifraStara)) {
//				jedistven=false;
				break;
			}
			i++; 
		}
//		if(jedistven) {
			listaPredmeta.get(i).setSifraPredmeta(sifraPredmeta);
//		}
//		else
//			System.out.println("pokuslai ste da promenite kljuc u kljuc koji vec postoji");
		listaPredmeta.get(i).setNazivPredmeta(nazivPredmeta);
		listaPredmeta.get(i).setSemestar(semestar);
		listaPredmeta.get(i).setGodinaStudija(godinaStudija);
	}

}
