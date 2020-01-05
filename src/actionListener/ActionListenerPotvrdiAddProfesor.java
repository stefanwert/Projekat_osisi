package actionListener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import java.text.SimpleDateFormat;

import dialog.DialogProfesor;
import kontroler.ProfesorKontroler;

public class ActionListenerPotvrdiAddProfesor implements ActionListener {
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		try {
			String ime=DialogProfesor.getInstance().readtxtIme();
			String prezime=DialogProfesor.getInstance().readtxtPrezime();
			SimpleDateFormat formatter=new SimpleDateFormat("dd.MM.yyyy");  
			Date datumr=formatter.parse(DialogProfesor.getInstance().readtxtDatumRodjenja());
			String adresas=DialogProfesor.getInstance().readtxtAdresaStanovanja();
			String brojtel=DialogProfesor.getInstance().readtxtBrojTelefona();
			String email=DialogProfesor.getInstance().readtxtEmail();
			String adresak=DialogProfesor.getInstance().readtxtAdresaKancelarije();
			String brojlk=DialogProfesor.getInstance().readtxtBrojLicneKarte();
			String titula=DialogProfesor.getInstance().readtxtTitula();
			String zvanje=DialogProfesor.getInstance().readtxtZvanje();
			ProfesorKontroler.getInstance().dodajProfesora(ime, prezime, datumr, adresas, brojtel, email, adresak, brojlk, titula, zvanje);
		} catch (Exception e2) {
			
		}
		
		DialogProfesor.getInstance().dispose();
		DialogProfesor.removeInstance();
	}

}
