package kontroler;

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
	
	public void pretraziStudenta(String kriterijum_pretrage)
	{
		//String parts[] = kriterijum_pretrage.split(";");
		//String index[] = parts[2].split(":");
		//String br_indx = index[1];
	}
	
}
