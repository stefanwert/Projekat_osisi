package actionListener;

import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;

import actionListenerPredmet.ActionListenerSearchPredmet;
import actionListenerProfesor.ActionListenerSearchProfesor;
import actionListenerStudent.ActionListenerSearchStudent;
import dialog.DialogPredmet;
import pogled.MainFrame;
import pogled.MyToolbar;

public class ActionListenerSearch implements ActionListener{

	@Override
	public void actionPerformed(ActionEvent e) {
		if(MainFrame.getInstance().getTabbedPane().getSelectedIndex()==0) {
			MyToolbar.getInstance().getButtonSrc().addActionListener(new ActionListenerSearchStudent());
		}
		else if(MainFrame.getInstance().getTabbedPane().getSelectedIndex()==1) {
			MyToolbar.getInstance().getButtonSrc().addActionListener(new ActionListenerSearchProfesor());
		}
		else if(MainFrame.getInstance().getTabbedPane().getSelectedIndex()==2) {
			MyToolbar.getInstance().getButtonSrc().addActionListener(new ActionListenerSearchPredmet());
		}
		//MyToolbar.getInstance().getButtonSrc().removeActionListener(l);
		MainFrame.getInstance().azurirajPrikaz();
	}

}
