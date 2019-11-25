package java_oisisi;

import java.sql.Date;
import java.util.ArrayList;
enum Status{
	B,S;
}

public class Student 
{
    protected String Ime;
    protected String Prezime;
    protected Date Datum_rodjenja;
    protected String Adresa_stanovanja;
    protected String Kontakt_telefon;
    protected String Email;
    protected String Broj_indeksa;
    protected Date Datum_upisa;
    protected int Trenutna_godina;
    protected Status status;
    protected double Prosecna_ocena;
    
   // protected ArrayList <Ocena> ocene;

}
