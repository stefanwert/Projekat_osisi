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
    private Date datum_rodjenja;
    private String adresa_stanovanja;
    private String kontakt_telefon;
    private String email;
    private String broj_indeksa;
    private Date datum_upisa;
    private int trenutna_godina;
    private Status status;
    private double prosecna_ocena;
    private List<Predmet> listaPredmeta;
    
	public Student(String ime, String prezime, Date datum_rodjenja, String adresa_stanovanja, String kontakt_telefon,
			String email, String broj_indeksa, Date datum_upisa, int trenutna_godina, Status status,
			double prosecna_ocena, List<Predmet> listaPredmeta) {
		super();
		this.ime = ime;
		this.prezime = prezime;
		this.datum_rodjenja = datum_rodjenja;
		this.adresa_stanovanja = adresa_stanovanja;
		this.kontakt_telefon = kontakt_telefon;
		this.email = email;
		this.broj_indeksa = broj_indeksa;
		this.datum_upisa = datum_upisa;
		this.trenutna_godina = trenutna_godina;
		this.status = status;
		this.prosecna_ocena = prosecna_ocena;
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

	public Date getDatum_rodjenja() {
		return datum_rodjenja;
	}

	public void setDatum_rodjenja(Date datum_rodjenja) {
		this.datum_rodjenja = datum_rodjenja;
	}

	public String getAdresa_stanovanja() {
		return adresa_stanovanja;
	}

	public void setAdresa_stanovanja(String adresa_stanovanja) {
		this.adresa_stanovanja = adresa_stanovanja;
	}

	public String getKontakt_telefon() {
		return kontakt_telefon;
	}

	public void setKontakt_telefon(String kontakt_telefon) {
		this.kontakt_telefon = kontakt_telefon;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getBroj_indeksa() {
		return broj_indeksa;
	}

	public void setBroj_indeksa(String broj_indeksa) {
		this.broj_indeksa = broj_indeksa;
	}

	public Date getDatum_upisa() {
		return datum_upisa;
	}

	public void setDatum_upisa(Date datum_upisa) {
		this.datum_upisa = datum_upisa;
	}

	public int getTrenutna_godina() {
		return trenutna_godina;
	}

	public void setTrenutna_godina(int trenutna_godina) {
		this.trenutna_godina = trenutna_godina;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public double getProsecna_ocena() {
		return prosecna_ocena;
	}

	public void setProsecna_ocena(double prosecna_ocena) {
		this.prosecna_ocena = prosecna_ocena;
	}

	public List<Predmet> getListaPredmeta() {
		return listaPredmeta;
	}

	public void setListaPredmeta(List<Predmet> listaPredmeta) {
		this.listaPredmeta = listaPredmeta;
	}
    
    

}
