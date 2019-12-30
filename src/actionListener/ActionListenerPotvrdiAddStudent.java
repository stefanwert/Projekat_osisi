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
			int godina;
			if(" I(prva)".equals(DialogStudent.getInstance().readtxtComboBox().getSelectedItem().toString())){
				godina=1;
			}
			else if(" II(druga)".equals(DialogStudent.getInstance().readtxtComboBox().getSelectedItem().toString())){
				godina=1;
			}
			else if(" III(treca)".equals(DialogStudent.getInstance().readtxtComboBox().getSelectedItem().toString())){
				godina=1;
			}
			else if(" IV(cetvrta)".equals(DialogStudent.getInstance().readtxtComboBox().getSelectedItem().toString())){
				godina=1;
			}
			
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
