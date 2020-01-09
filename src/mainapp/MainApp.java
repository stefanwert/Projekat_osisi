package mainapp;

import java.io.FileNotFoundException;
import java.io.IOException;

import dialog.DialogAddStudentToPredmet;
import model.Predmet;
import model.StudenskaSluzba;
import pogled.*;
public class MainApp {

	public static void main(String[] args) {
		MainFrame.getInstance();
		//StudenskaSluzba.getInstance().ucitajpredmete();
		StudenskaSluzba.getInstance().ucitajProfesore();
		System.out.println(StudenskaSluzba.getInstance().getListProfesora().size());
		
	}

}
