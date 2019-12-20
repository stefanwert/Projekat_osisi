package kontroler;

import java.sql.Date;
import java.util.List;
import model.Predmet;
import model.Student;
import model.Student.Status;

public class StudentKontroler {
	
	void dodaj_studenta(String ime, String prezime, Date datum_rodjenja, String adresa_stanovanja, String kontakt_telefon,
			String email, String broj_indeksa, Date datum_upisa, int trenutna_godina, Status status,
			double prosecna_ocena, List<Predmet> listaPredmeta,List<Student> listaStudenata)
	{
		Student s = new Student(ime,prezime,datum_rodjenja,adresa_stanovanja,kontakt_telefon,email,
				broj_indeksa,datum_upisa,trenutna_godina,status,prosecna_ocena,listaPredmeta);
		
		listaStudenata.add(s);
	}
    
	void obrisi_studenta(String broj_indeksa,List<Student> listaStudenata)
	{
		for(Student student : listaStudenata)
		{
			if(broj_indeksa.equals(student.getBrojIndeksa()))
			{
				listaStudenata.remove(student);
			}
		}
	}
	
	void izmeni_studenta(String ime, String prezime, Date datum_rodjenja, String adresa_stanovanja, String kontakt_telefon,
			String email, String broj_indeksa, Date datum_upisa, int trenutna_godina, Status status,
			double prosecna_ocena, List<Predmet> listaPredmeta,Student stari)
	{
		stari.setIme(ime);
		stari.setPrezime(prezime);
		stari.setDatumRodjenja(datum_rodjenja);
		stari.setAdresaStanovanja(adresa_stanovanja);
		stari.setKontaktTelefon(kontakt_telefon);
		stari.setEmail(email);
		stari.setBrojIndeksa(broj_indeksa);
		stari.setDatumUpisa(datum_upisa);
		stari.setTrenutnaGodina(trenutna_godina);
		stari.setStatus(status);
		stari.setProsecnaOcena(prosecna_ocena);
		stari.setListaPredmeta(listaPredmeta);
	}
	
	void pretrazi_studenta(String kriterijum_pretrage)
	{
		//String parts[] = kriterijum_pretrage.split(";");
		//String index[] = parts[2].split(":");
		//String br_indx = index[1];
	}
	
}
