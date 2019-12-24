package ActionListener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import dialog.DialogStudent;
import kontroler.StudentKontroler;

public class ActionListenerPotvrdiAddStudent implements ActionListener {
	
	@Override
	public void actionPerformed(ActionEvent e) {

		try {
			String index=DialogStudent.getInstance().readtxtBrojIndeksa();
			String ime=DialogStudent.getInstance().readtxtIme();
			String prezime=DialogStudent.getInstance().readtxtPrezime();
			//int godina=Integer.parseInt(DialogStudent.getInstance().readtxtGodinaStudjia());
			//double prosek= Double.parseDouble(DialogStudent.getInstance().readtxtProsek());
		    //StudentKontroler.getInstance().dodajStudenta(index, ime, prezime, godina, prosek, null);
		} catch (Exception e2) {
			// TODO: handle exception
		}
		
		DialogStudent.getInstance().dispose();
		DialogStudent.removeInstance();
	}

}
