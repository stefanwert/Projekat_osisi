package actionListener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;

import dialog.DialogProfesor;
import kontroler.ProfesorKontroler;

public class ActionListenerPotvrdiEditProfesor implements ActionListener{
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		try {
			String ime=DialogProfesor.getInstance().readtxtIme();
			String prezime=DialogProfesor.getInstance().readtxtPrezime();
			SimpleDateFormat formatter=new SimpleDateFormat("dd.MM.yyyy");  
			Date datumr =new SimpleDateFormat("dd.MM.yyyy").parse(DialogProfesor.getInstance().readtxtDatumRodjenja());
			System.out.println(datumr);
			String adresas=DialogProfesor.getInstance().readtxtAdresaStanovanja();
			String brojtel=DialogProfesor.getInstance().readtxtBrojTelefona();
			String email=DialogProfesor.getInstance().readtxtEmail();
			String adresak=DialogProfesor.getInstance().readtxtAdresaKancelarije();
			String brojlk=DialogProfesor.getInstance().readtxtBrojLicneKarte();
			String titula=DialogProfesor.getInstance().readtxtTitula();
			String zvanje=DialogProfesor.getInstance().readtxtZvanje();
			ProfesorKontroler.getInstance().izmeniProfesora(ime, prezime, datumr, adresas, brojtel, email, adresak, brojlk, titula, zvanje);
		} catch (Exception e2) {
			e2.printStackTrace();
		}
		
		DialogProfesor.getInstance().dispose();
		DialogProfesor.removeInstance();
	}

}
