package kontroler;

import java.util.Date;
import java.util.List;

import model.Predmet;
import model.Profesor;
import model.StudenskaSluzba;
import model.Student;

public class ProfesorKontroler {
private static ProfesorKontroler instance = null;
	
	public static ProfesorKontroler getInstance() {
		if(instance==null)
			instance=new ProfesorKontroler();
		return instance;
	}
	private ProfesorKontroler() {
		
	}
	public void dodajProfesora(String ime, String prezime, Date datum, String adresaStanovanja, String kontaktTel, String email,
			String adresaKancelarije, String brLicneKarte, String titula, String zvanje) {
		Profesor p=new Profesor(ime, prezime, datum, adresaStanovanja, kontaktTel, email, adresaKancelarije, brLicneKarte, titula, zvanje, null);
		StudenskaSluzba.getInstance().dodajProfesora(p);
	}
	public void obrisiProfesora(String s) {
		StudenskaSluzba.getInstance().izbrisiProfesora(s);
	}
	public void izmeniProfesora(String ime, String prezime, Date datum, String adresaStanovanja, String kontaktTel, String email,
			String adresaKancelarije, String brLicneKarte, String titula, String zvanje) {
		StudenskaSluzba.getInstance().izmeniProfesora(ime, prezime, datum, adresaStanovanja, kontaktTel, email, adresaKancelarije, brLicneKarte, titula, zvanje);
	}
}
