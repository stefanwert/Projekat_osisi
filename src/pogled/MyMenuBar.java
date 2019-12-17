package pogled;

import javax.swing.ButtonGroup;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JRadioButtonMenuItem;

public class MyMenuBar extends JMenuBar {

	public MyMenuBar() {

		JMenu file = new JMenu("File");
		JMenu miNew = new JMenu("New");
		JMenuItem miStudent = new JMenuItem("Student");
		JMenuItem miProfesor = new JMenuItem("Profesor");
		JMenuItem miPredmet = new JMenuItem("Predmet");
		miNew.add(miStudent);
		miNew.addSeparator();
		miNew.add(miProfesor);
		miNew.addSeparator();
		miNew.add(miPredmet);
		
		JMenuItem miClose = new JMenuItem("Close");
		
		file.add(miNew);
		file.addSeparator();
		file.add(miClose);
		file.addSeparator();
		
		JMenu edit = new JMenu("Edit");
		JMenu miEdit = new JMenu("Edit");
		miEdit.add(miStudent);
		miEdit.addSeparator();
		miEdit.add(miProfesor);
		miEdit.addSeparator();
		miEdit.add(miPredmet);
		
		JMenu miDelite = new JMenu("Delite");
		miDelite.add(miStudent);
		miDelite.addSeparator();
		miDelite.add(miProfesor);
		miDelite.addSeparator();
		miDelite.add(miPredmet);
		
		edit.add(miEdit);
		edit.addSeparator();
		edit.add(miDelite);
		edit.addSeparator();
		
		JMenu help = new JMenu("Help");
		JMenuItem miHelp = new JMenuItem("Help");
		JMenuItem miAbout = new JMenuItem("About");
		
		help.add(miHelp);
		help.addSeparator();
		help.add(miAbout);
		help.addSeparator();

		add(file);
		add(edit);
		add(help);

	}
	
}
