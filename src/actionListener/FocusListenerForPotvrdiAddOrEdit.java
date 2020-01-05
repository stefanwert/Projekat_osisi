package actionListener;

import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.JButton;

import dialog.DialogPredmet;
import dialog.DialogProfesor;
import dialog.DialogStudent;
import pogled.MainFrame;

public class FocusListenerForPotvrdiAddOrEdit implements FocusListener{

	@Override
	public void focusGained(FocusEvent e) {
		JButton b=(JButton) e.getComponent();
		if(MainFrame.getInstance().getTabbedPane().getSelectedIndex()==0) {
			if(DialogStudent.getInstance().isTxtFieldsEmpty()) {
				b.setEnabled(false);
			}else {
				b.setEnabled(true);
			}
		}
		else if(MainFrame.getInstance().getTabbedPane().getSelectedIndex()==1) {
			if(DialogProfesor.getInstance().isTxtFieldsEmpty()) {
				b.setEnabled(false);
			}else {
				b.setEnabled(true);
			}
		}
		else if(MainFrame.getInstance().getTabbedPane().getSelectedIndex()==2) {
			if(DialogPredmet.getInstance().isTxtFieldsEmpty()) {	
				b.setEnabled(false);
			}else {
				b.setEnabled(true);
			}
	    }
		
		
		
	}

	@Override
	public void focusLost(FocusEvent e) {
		JButton b=(JButton) e.getComponent();
		b.setEnabled(true);
	}

}
