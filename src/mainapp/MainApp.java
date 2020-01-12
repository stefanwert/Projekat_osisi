package mainapp;

import java.io.FileNotFoundException;
import java.io.IOException;

import dialog.DialogAddStudentToPredmet;
import dialog.DialogSpisakStudenataNaPredmetu;
import model.Predmet;
import model.StudenskaSluzba;
import pogled.*;
public class MainApp {

	public static void main(String[] args) {
		MainFrame.getInstance();
		StudenskaSluzba.getInstance().ucitajProfesore();
		StudenskaSluzba.getInstance().ucitajpredmete();
		StudenskaSluzba.getInstance().ucitajStudente();
		
		
		//StudenskaSluzba.getInstance().getListPredmeta().get(0).getListaStudenata().add(StudenskaSluzba.getInstance().getListStudenata().get(0));
		
	}

}
