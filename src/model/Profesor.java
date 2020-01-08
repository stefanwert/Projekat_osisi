package model;

import java.io.Serializable;
import java.util.*;



public class Profesor implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -1201453532984709189L;
	private String ime;
	private String prezime;
	private Date datum;
	private String adresaStanovanja;
	private String kontaktTel;
	private String email;
	private String adresaKancelarije;
	private String brLicneKarte;
	private String titula;
	private String zvanje;
	private List<Predmet> ListaPredmeta;
	
	public Profesor(String ime, String prezime, Date datum, String adresaStanovanja, String kontaktTel, String email,
			String adresaKancelarije, String brLicneKarte, String titula, String zvanje, List<Predmet> listaPredmeta) {
		super();
		this.ime = ime;
		this.prezime = prezime;
		this.datum = datum;
		this.adresaStanovanja = adresaStanovanja;
		this.kontaktTel = kontaktTel;
		this.email = email;
		this.adresaKancelarije = adresaKancelarije;
		this.brLicneKarte = brLicneKarte;
		this.titula = titula;
		this.zvanje = zvanje;
		ListaPredmeta = listaPredmeta;
	}
	public Profesor() {};

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

	public Date getDatum() {
		return datum;
	}

	public void setDatum(Date datum) {
		this.datum = datum;
	}

	public String getAdresaStanovanja() {
		return adresaStanovanja;
	}

	public void setAdresaStanovanja(String adresaStanovanja) {
		this.adresaStanovanja = adresaStanovanja;
	}

	public String getKontaktTel() {
		return kontaktTel;
	}

	public void setKontaktTel(String kontaktTel) {
		this.kontaktTel = kontaktTel;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAdresaKancelarije() {
		return adresaKancelarije;
	}

	public void setAdresaKancelarije(String adresaKancelarije) {
		this.adresaKancelarije = adresaKancelarije;
	}

	public String getBrLicneKarte() {
		return brLicneKarte;
	}

	public void setBrLicneKarte(String brLicneKarte) {
		this.brLicneKarte = brLicneKarte;
	}

	public String getTitula() {
		return titula;
	}

	public void setTitula(String titula) {
		this.titula = titula;
	}

	public String getZvanje() {
		return zvanje;
	}

	public void setZvanje(String zvanje) {
		this.zvanje = zvanje;
	}

	public List<Predmet> getListaPredmeta() {
		return ListaPredmeta;
	}

	public void setListaPredmeta(List<Predmet> listaPredmeta) {
		ListaPredmeta = listaPredmeta;
	} 
	
	
	
}
