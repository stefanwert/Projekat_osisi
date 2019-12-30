package actionListener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import dialog.DialogStudent;
import kontroler.StudentKontroler;
import model.Student;

public class ActionListenerPotvrdiAddStudent implements ActionListener {
	
	@Override
	public void actionPerformed(ActionEvent e) {

		try {
			String index=DialogStudent.getInstance().readtxtBrojIndeksa();
			String ime=DialogStudent.getInstance().readtxtIme();
			String prezime=DialogStudent.getInstance().readtxtPrezime();
			int godina=Integer.parseInt(DialogStudent.getInstance().readtxtComboBox().getSelectedItem().toString());
			String status=DialogStudent.getInstance().getStatus().getSelection().getActionCommand(); 
			double prosek= Double.parseDouble(DialogStudent.getInstance().readtxtProsecnaOcena());
		    //StudentKontroler.getInstance().dodajStudenta(index, ime, prezime, godina, status, prosek,  );
		} catch (Exception e2) {
			// TODO: handle exception
		}
		
		DialogStudent.getInstance().dispose();
		DialogStudent.removeInstance();
	}

}
