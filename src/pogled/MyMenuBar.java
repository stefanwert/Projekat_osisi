package pogled;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.KeyStroke;

import ActionListener.ActionListenerAdd;

public class MyMenuBar extends JMenuBar {

	public MyMenuBar() {

		JMenu file = new JMenu("File");
		file.setMnemonic(KeyEvent.VK_F);
		JMenu miNew = new JMenu("New");
		miNew.setMnemonic(KeyEvent.VK_N);
		JMenuItem miStudent = new JMenuItem("Student");
		//miStudent.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N,InputEvent.CTRL_MASK));
		JMenuItem miProfesor = new JMenuItem("Profesor");
		//miProfesor.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N,InputEvent.CTRL_MASK));
		JMenuItem miPredmet = new JMenuItem("Predmet");
		//miPredmet.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N,InputEvent.CTRL_MASK));
		miNew.add(miStudent);
		miNew.addSeparator();
		miNew.add(miProfesor);
		miNew.addSeparator();
		miNew.add(miPredmet);
		
		JMenuItem miClose = new JMenuItem("Close");
		miClose.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C,InputEvent.CTRL_MASK));
		
		file.add(miNew);
		file.addSeparator();
		file.add(miClose);
		file.addSeparator();
		
		JMenu edit = new JMenu("Edit");
		edit.setMnemonic(KeyEvent.VK_E);
		JMenu miEdit = new JMenu("Edit");
		//miEdit.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_E,InputEvent.CTRL_MASK));
		miEdit.add(miStudent);
		miEdit.addSeparator();
		miEdit.add(miProfesor);
		miEdit.addSeparator();
		miEdit.add(miPredmet);
		
		JMenu miDelete = new JMenu("Delete");
		//miDelete.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_D,InputEvent.CTRL_MASK));
		miDelete.add(miStudent);
		miStudent.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_D + KeyEvent.VK_S,InputEvent.CTRL_MASK));
		miDelete.addSeparator();
		miDelete.add(miProfesor);
		miProfesor.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_D,InputEvent.CTRL_MASK));
		miDelete.addSeparator();
		miDelete.add(miPredmet);
		miPredmet.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_D,InputEvent.CTRL_MASK));
		
		edit.add(miEdit);
		edit.addSeparator();
		edit.add(miDelete);
		edit.addSeparator();
		
		JMenu help = new JMenu("Help");
		help.setMnemonic(KeyEvent.VK_H);
		JMenuItem miHelp = new JMenuItem("Help");
		miHelp.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_H,InputEvent.CTRL_MASK));
		JMenuItem miAbout = new JMenuItem("About");
		miAbout.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A,InputEvent.CTRL_MASK));
		
		help.add(miHelp);
		help.addSeparator();
		help.add(miAbout);
		help.addSeparator();

		add(file);
		add(edit);
		add(help);

	}
	
}
