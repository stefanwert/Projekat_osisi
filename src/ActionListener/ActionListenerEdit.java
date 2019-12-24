package ActionListener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import dialog.DialogPredmet;
import dialog.DialogProfesor;
import dialog.DialogStudent;
import pogled.MainFrame;

public class ActionListenerEdit implements ActionListener{
	@Override
	public void actionPerformed(ActionEvent arg0) {
		
		if(MainFrame.getInstance().getTabbedPane().getSelectedIndex()==0) {
			try {
				DialogStudent ds=new DialogStudent(MainFrame.getInstance(),"Dodaj studenta",true);
				ds.setTxtFilds();
				ds.setVisible(true);
			} catch (Exception e) {
				System.out.println("Nista nije selektovano");
			}
		}
		else if(MainFrame.getInstance().getTabbedPane().getSelectedIndex()==1) {
			try {
				DialogProfesor dp=new DialogProfesor(MainFrame.getInstance(),"Dodaj profesora",true);
				dp.setTxtFilds();
				dp.setVisible(true);
			} catch (Exception e) {
				System.out.println("Nista nije selektovano");
			}
		}
		else if(MainFrame.getInstance().getTabbedPane().getSelectedIndex()==2) {
			try {
				DialogPredmet d=new DialogPredmet(MainFrame.getInstance(),"DODAJ PREDMET",true);
				d.setTxtFilds();
				d.setVisible(true);
			} catch (Exception e) {
				System.out.println("Nista nije selektovano");
			}
			
		}		
		
		MainFrame.getInstance().azurirajPrikaz();
	}
}
