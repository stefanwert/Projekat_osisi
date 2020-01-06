package kontroler;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import model.Predmet;
import model.Student;
import model.Student.Status;
import model.StudenskaSluzba;

public class StudentKontroler {
	
private static StudentKontroler instance = null;
	
	public static StudentKontroler getInstance() {
		if(instance==null)
			instance=new StudentKontroler();
		return instance;
	}
	private StudentKontroler() {
		
	}
	
	public void dodajStudenta(String ime, String prezime, Date datumRodjenja, String adresaStanovanja, String kontaktTelefon,
			String email, String brojIndeksa, Date datumUpisa, int trenutnaGodina, Status status,
			double prosecnaOcena, List<Predmet> listaPredmeta,List<Student> listaStudenata){
		
		Student s = new Student(ime,prezime,datumRodjenja,adresaStanovanja,kontaktTelefon,email,
				brojIndeksa,datumUpisa,trenutnaGodina,status,prosecnaOcena,listaPredmeta);
		
		StudenskaSluzba.getInstance().dodajStudenta(s);
	}
    
	public void obrisiStudenta(String brojIndeksa){
		
		StudenskaSluzba.getInstance().obrisiStudenta(brojIndeksa);
		
	}
	
	public void izmeniStudenta(String ime, String prezime, Date datumRodjenja, String adresaStanovanja, String kontaktTelefon,
			String email, String brojIndeksa, Date datumUpisa, int trenutnaGodina, Status status,
			double prosecnaOcena, List<Predmet> listaPredmeta,Student stari){
		
		StudenskaSluzba.getInstance().izmeniStudenta(ime, prezime, datumRodjenja, adresaStanovanja, kontaktTelefon, email, brojIndeksa, datumUpisa, trenutnaGodina, status, prosecnaOcena, listaPredmeta, stari);
		
	}
	
	public void pretraziStudenta(String kriterijum_pretrage,List<Student> listaStudenata)
	{
		String parts[] = kriterijum_pretrage.split(";");
		int duzina = parts.length;
		String parts2[];
		List<Student> retList=StudenskaSluzba.getInstance().getListStudenata();
		for (String s : parts) {
			parts2=s.split(":");
			if(parts[0].equals("ime")) {
				for (Student student : StudenskaSluzba.getInstance().getListStudenata()) {
					if(!student.getIme().equals(parts2[1])) {
						System.out.println(retList.size());
						retList.remove(student);
						System.out.println(retList.size());		//provera da li se brisu
					}
				}
			}
			if(parts[0].equals("prezime")) {
				for (Student student : StudenskaSluzba.getInstance().getListStudenata()) {
					if(!student.getPrezime().equals(parts2[1])) {
						System.out.println(retList.size());
						retList.remove(student);
						System.out.println(retList.size());		
					}
				}
			}
			if(parts[0].equals("indeks")) {
				for (Student student : StudenskaSluzba.getInstance().getListStudenata()) {
					if(!student.getBrojIndeksa().equals(parts2[1])) {
						System.out.println(retList.size());
						retList.remove(student);
						System.out.println(retList.size());		
					}
				}
			}
			if(parts[0].equals("status")) {
				for (Student student : StudenskaSluzba.getInstance().getListStudenata()) {
					if(!student.getStatus().equals(parts2[1])) {
						System.out.println(retList.size());
						retList.remove(student);
						System.out.println(retList.size());		
					}
				}
			}
			
		}
		
	}
	
}
