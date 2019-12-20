package model;

import java.sql.Date;
import java.util.List;


public class Student 
{
	public enum Status{
		B,S
	}
	private String ime;
    private String prezime;
    private Date datumRodjenja;
    private String adresaStanovanja;
    private String kontaktTelefon;
    private String email;
    private String brojIndeksa;
    private Date datumUpisa;
    private int trenutnaGodina;
    private Status status;
    private double prosecnaOcena;
    private List<Predmet> listaPredmeta;
    
	public Student(String ime, String prezime, Date datumRodjenja, String adresaStanovanja, String kontaktTelefon,
			String email, String brojIndeksa, Date datumUpisa, int trenutnaGodina, Status status,
			double prosecnaOcena, List<Predmet> listaPredmeta) {
		super();
		this.ime = ime;
		this.prezime = prezime;
		this.datumRodjenja = datumRodjenja;
		this.adresaStanovanja = adresaStanovanja;
		this.kontaktTelefon = kontaktTelefon;
		this.email = email;
		this.brojIndeksa = brojIndeksa;
		this.datumUpisa = datumUpisa;
		this.trenutnaGodina = trenutnaGodina;
		this.status = status;
		this.prosecnaOcena = prosecnaOcena;
		this.listaPredmeta = listaPredmeta;
	}

	public String getIme() {
		return ime;
	}

	public void setIme(String ime) {
		this.ime = ime;
	}

	public String getPrezime() {
		return prezime;
	}

	public void setPrezime(String prezime) {
		this.prezime = prezime;
	}

	public Date getDatumRodjenja() {
		return datumRodjenja;
	}

	public void setDatumRodjenja(Date datum_rodjenja) {
		this.datumRodjenja = datum_rodjenja;
	}

	public String getAdresaStanovanja() {
		return adresaStanovanja;
	}

	public void setAdresaStanovanja(String adresa_stanovanja) {
		this.adresaStanovanja = adresa_stanovanja;
	}

	public String getKontaktTelefon() {
		return kontaktTelefon;
	}

	public void setKontaktTelefon(String kontakt_telefon) {
		this.kontaktTelefon = kontakt_telefon;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getBrojIndeksa() {
		return brojIndeksa;
	}

	public void setBrojIndeksa(String broj_indeksa) {
		this.brojIndeksa = broj_indeksa;
	}

	public Date getDatumUpisa() {
		return datumUpisa;
	}

	public void setDatumUpisa(Date datum_upisa) {
		this.datumUpisa = datum_upisa;
	}

	public int getTrenutnaGodina() {
		return trenutnaGodina;
	}

	public void setTrenutnaGodina(int trenutna_godina) {
		this.trenutnaGodina = trenutna_godina;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public double getProsecnaOcena() {
		return prosecnaOcena;
	}

	public void setProsecnaOcena(double prosecna_ocena) {
		this.prosecnaOcena = prosecna_ocena;
	}

	public List<Predmet> getListaPredmeta() {
		return listaPredmeta;
	}

	public void setListaPredmeta(List<Predmet> listaPredmeta) {
		this.listaPredmeta = listaPredmeta;
	}
    
    

}
