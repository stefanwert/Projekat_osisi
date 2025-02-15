package model;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.swing.JButton;

import dialog.DialogSpisakStudenataNaPredmetu;
import dialog.DialogStudent;
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
		kolonePredmeta.add("Studenti");

		koloneStudenata = new ArrayList<String>();
		koloneStudenata.add("Index");
		koloneStudenata.add("Ime");
		koloneStudenata.add("Prezime");
		koloneStudenata.add("Godina studija");
		koloneStudenata.add("Status");
		koloneStudenata.add("Prosek");
		
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

		try {
			serializeRead();
		} catch (ClassNotFoundException | IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public void ucitajStudente() {
		BufferedReader csvReader = null;
		try {
			csvReader=new BufferedReader(new InputStreamReader(new FileInputStream("File/Studenti.csv"),"UTF-8") );
			String row;
			int i=0;
			while((row=csvReader.readLine())!=null) {
				if(i!=0) {
					String[] data=row.split(",");
					SimpleDateFormat formatter=new SimpleDateFormat("dd.MM.yyyy");
					String pom1=data[2].substring(0,data[2].length()-1);
					String pom2=data[2].substring(0,data[8].length()-1);
					Status status;
					if(data[10].equals("B")) {
						status=Status.B;
					}else {
						status=Status.S;
					}
					Date datr;
					Date datu;
					try {
						datr = formatter.parse(pom1);
						datu = formatter.parse(pom2);
						Student s=new Student(data[0], data[1],datr, 
								data[3].substring(1,data[3].length())+" "+data[4].substring(0,data[4].length()-1),
								data[5], data[6],data[7],datu, Integer.parseInt(data[9]),status,8.0, new ArrayList<Predmet>());
						dodajStudenta(s);
					} catch (ParseException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				i++;
					
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		try {
			csvReader.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		MainFrame.getInstance().azurirajPrikaz();
	}
	
	public void ucitajProfesore() {
		BufferedReader csvReader = null;
		try {
			csvReader=new BufferedReader(new InputStreamReader(new FileInputStream("File/Profesori.csv"),"UTF-8") );
			String row;
			int i=0;
			while((row=csvReader.readLine())!=null) {
				if(i!=0) {
					String[] data=row.split(",");
					SimpleDateFormat formatter=new SimpleDateFormat("dd.MM.yyyy");
					String pom=data[2].substring(0,data[2].length()-1);
					  
					Date dat;
					try {
						dat = formatter.parse(pom);
						Profesor p=new Profesor(data[0], data[1],dat, 
								data[3].substring(1,data[3].length())+" "+data[4].substring(0,data[4].length()-1),
								data[5], data[6],data[7].substring(1,data[7].length())+" "+data[8]+" "+data[9].substring(0,data[9].length()-1),
								data[10].substring(3, data[10].length()-3), data[11],data[12], new ArrayList<Predmet>());
						
						dodajProfesora(p);
						//listaProfesora.add(p);
					} catch (ParseException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				i++;
					
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		try {
			csvReader.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		MainFrame.getInstance().azurirajPrikaz();
	}
	
	public void ucitajStudenteNaPredmet(){
		BufferedReader csvReader = null;
		
		try {
			csvReader=new BufferedReader(new InputStreamReader(new FileInputStream("File/StudentiNaPredmetu.csv"),"UTF-8") );
			String row;
			int i=0;
			int indeksPredmet=0;
			while((row=csvReader.readLine())!=null) {
					indeksPredmet=0;
					String[] data=row.split(",");
					csvReader.readLine();
					csvReader.readLine();
					
					for (Predmet predmet : StudenskaSluzba.getInstance().getListPredmeta()) {
						if(data[1].equals(predmet.getSifraPredmeta())) {
							break;
						}
						indeksPredmet++;
					}
					System.out.println(indeksPredmet);
					
					while((!(row=csvReader.readLine()).equals(",,,")) && row != null){
						data=row.split(",");
						for (Student student : listaStudenata) {
							if(student.getBrojIndeksa().equals(data[1])){
								listaPredmeta.get(indeksPredmet).getListaStudenata().add(student);
							}
						}
					}
					csvReader.readLine();
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
		}
		try {
			csvReader.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
//		try {
//			csvReader=new BufferedReader(new InputStreamReader(new FileInputStream("File/StudentiNaPredmetu.csv"),"UTF-8") );
//			String row;
//			int i=0;
//			int indeksProfesora=0;
//			while((row=csvReader.readLine())!=null) {
//					String[] data=row.split(",");
//					if(row.equals(",,,")){
//						i=0;
//					}
//					else{
//						if(i==0){
//							indeksProfesora=0;
//							System.out.println(data[1]);
//							for (Predmet predmet : StudenskaSluzba.getInstance().getListPredmeta()) {
//								if(data[1].equals(predmet.getSifraPredmeta())) {
//									break;
//								}
//								indeksProfesora++;
//							}
//							System.out.println(indeksProfesora);
//						}
//						else if(i==1 || i==2){
//							System.out.println("nista");
//						}else{
//							for (Student student : listaStudenata) {
//								if(student.getBrojIndeksa().equals(data[1])){
//									listaPredmeta.get(indeksProfesora).getListaStudenata().add(student);
//								}
//							}
//						}
//					}
//				i++;	
//			}
//		} catch (UnsupportedEncodingException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (FileNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (NumberFormatException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		try {
//			csvReader.close();
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		MainFrame.getInstance().azurirajPrikaz();
		DialogSpisakStudenataNaPredmetu.getInstance().updateTable();
	}
	
	
	public void ucitajpredmete() {
		BufferedReader csvReader = null;
		try {
			csvReader=new BufferedReader(new InputStreamReader(new FileInputStream("File/Predmeti.csv"),"UTF-8") );
			String row;
			int i=0;
			while((row=csvReader.readLine())!=null) {
				if(i!=0) {
					String[] data=row.split(",");
					
					
					String pom="";
					if(!data[4].equals("null")) {
						pom=data[4].substring(3, data[4].length()-2);
						
					}
					System.out.println(pom);
					Profesor pr=null;
					for (Profesor p : listaProfesora) {
						if(p.getBrLicneKarte().equals(pom)) {
							pr=p;
						}
					}
					Predmet p=new Predmet(data[0],data[1],Integer.parseInt(data[2]),Integer.parseInt(data[3]),pr,new ArrayList<Student>());
					dodajPredmet(p);
				}
				i++;
					
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		try {
			csvReader.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		MainFrame.getInstance().azurirajPrikaz();
		
	}
	
	public void serializeWrite() throws FileNotFoundException, IOException {
		File f= new File("File/readPredmete.txt");
		ObjectOutputStream oos=new ObjectOutputStream(
				new BufferedOutputStream(new FileOutputStream(f)));
		try {
			oos.writeObject(listaPredmeta);
		} finally {
			oos.close();
		}

		//profesori
		File f2= new File("File/readProfesore.txt");
		ObjectOutputStream oos2=new ObjectOutputStream(
				new BufferedOutputStream(new FileOutputStream(f2)));
		try {
			oos2.writeObject(listaProfesora);
		} finally {
			oos2.close();
		}
		//student
		File f3= new File("File/readStudente.txt");
		ObjectOutputStream oos3=new ObjectOutputStream(
				new BufferedOutputStream(new FileOutputStream(f3)));
		try {
			oos3.writeObject(listaStudenata);
		} finally {
			oos3.close();
		}
	}
	
	public void serializeRead() throws FileNotFoundException, IOException, ClassNotFoundException {
		File f= new File("File/readPredmete.txt");
		ObjectInputStream ois=new ObjectInputStream(
				new BufferedInputStream(new FileInputStream(f)));
		try {
			listaPredmeta= (List<Predmet>) ois.readObject();
		} finally {
			ois.close();
		}
		//profesor

				File f2= new File("File/readProfesore.txt");
				ObjectInputStream ois2=new ObjectInputStream(
						new BufferedInputStream(new FileInputStream(f2)));
				try {
					listaProfesora= (List<Profesor>) ois2.readObject();
				} finally {
					ois2.close();
				}
		//student
				File f3= new File("File/readStudente.txt");
				ObjectInputStream ois3=new ObjectInputStream(
						new BufferedInputStream(new FileInputStream(f3)));
				try {
					listaStudenata= (List<Student>) ois3.readObject();
				} finally {
					ois3.close();
				}
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
		case 6:
			SimpleDateFormat formatter=new SimpleDateFormat("dd.MM.yyyy");
			String dr=formatter.format(student.getDatumRodjenja());
			return dr;
		case 7:
			return student.getAdresaStanovanja();
		case 8:
			return student.getKontaktTelefon();
		
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
	
	public void setPredmet(List<Predmet> predmeti) {
		this.listaPredmeta=predmeti;
	}
	
	public Predmet getRowPredmeta(int rowIndex) {
		return this.listaPredmeta.get(rowIndex);
	}
	
	public Object getValueAtPredmet(int row,int column) {
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
		case 5:
			
            return "Prikazi";
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
		boolean jedistven=true;
		int i = MainFrame.getInstance().getTabelPredmeta().getSelectedRow();
		for (Predmet predmet : listaPredmeta) {
			if(predmet.getSifraPredmeta().equals(sifraStara)) {
				jedistven=false;
				break;
			} 
		}
		if(jedistven) {
			listaPredmeta.get(i).setSifraPredmeta(sifraPredmeta);
		}
		else
		System.out.println("pokuslai ste da promenite kljuc u kljuc koji vec postoji");
		listaPredmeta.get(i).setNazivPredmeta(nazivPredmeta);
		listaPredmeta.get(i).setSemestar(semestar);
		listaPredmeta.get(i).setGodinaStudija(godinaStudija);
	}

}
