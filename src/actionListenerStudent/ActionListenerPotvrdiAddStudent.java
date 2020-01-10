package actionListenerStudent;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;

import dialog.DialogProfesor;
import dialog.DialogStudent;
import kontroler.StudentKontroler;
import model.Student;

public class ActionListenerPotvrdiAddStudent implements ActionListener {
	
	@Override
	public void actionPerformed(ActionEvent e) {

		try {
			String ime=DialogStudent.getInstance().readtxtIme();
			String prezime=DialogStudent.getInstance().readtxtPrezime();
			SimpleDateFormat formatter=new SimpleDateFormat("dd.MM.yyyy");  
			Date datumr=formatter.parse(DialogStudent.getInstance().readtxtDatumRodjenja());
			String adresa=DialogStudent.getInstance().readtxtAdresaStanovanja();
			String brojtel=DialogStudent.getInstance().readtxtBrojTelefona();
			String index=DialogStudent.getInstance().readtxtBrojIndeksa();
			int godina=0;
			if(" I(prva)".equals(DialogStudent.getInstance().readtxtComboBox().getSelectedItem().toString())){
				godina=1;
			}
			else if(" II(druga)".equals(DialogStudent.getInstance().readtxtComboBox().getSelectedItem().toString())){
				godina=2;
			}
			else if(" III(treca)".equals(DialogStudent.getInstance().readtxtComboBox().getSelectedItem().toString())){
				godina=3;
			}
			else if(" IV(cetvrta)".equals(DialogStudent.getInstance().readtxtComboBox().getSelectedItem().toString())){
				godina=4;
			}
			Student student = new Student();
			if(DialogStudent.getInstance().budzet.isSelected()==true) {
				student.setStatus(Student.Status.B);
				}else {
					student.setStatus(Student.Status.S);
				}
			double prosek= Double.parseDouble(DialogStudent.getInstance().readtxtProsecnaOcena());
		   StudentKontroler.getInstance().dodajStudenta(ime, prezime, datumr, adresa, brojtel, null, index, null, godina, student.getStatus(), prosek, null, null);
		} catch (Exception e2) {
			// TODO: handle exception
		}
		
		DialogStudent.getInstance().dispose();
		DialogStudent.removeInstance();
	}

}
