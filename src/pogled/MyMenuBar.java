package pogled;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.KeyStroke;

import ActionListener.ActionListenerAdd;
import dialog.DialogPredmet;
import dialog.DialogProfesor;
import dialog.DialogStudent;
import kontroler.PredmetKontroler;
import kontroler.ProfesorKontroler;
import kontroler.StudentKontroler;

public class MyMenuBar extends JMenuBar {

	public MyMenuBar() {

		JMenu file = new JMenu("File");
		file.setMnemonic(KeyEvent.VK_F);
		JMenuItem miNew = new JMenuItem("New");
		miNew.setMnemonic(KeyEvent.VK_N);
		miNew.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N,InputEvent.CTRL_MASK));
		miNew.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				if(MainFrame.getInstance().getTabbedPane().getSelectedIndex()==0) {
					DialogStudent ds = new DialogStudent(MainFrame.getInstance(),"Dodaj studenta",true);
					ds.setVisible(true);
				}
				else if(MainFrame.getInstance().getTabbedPane().getSelectedIndex()==1) {
					DialogProfesor dp = new DialogProfesor(MainFrame.getInstance(),"Dodaj profesora",true);
					dp.setVisible(true);
				}
				else if(MainFrame.getInstance().getTabbedPane().getSelectedIndex()==2) {
					DialogPredmet d=new DialogPredmet(MainFrame.getInstance(),"DODAJ PREDMET",true);
					d.setVisible(true);
			    }
				MainFrame.getInstance().azurirajPrikaz();
			}
		});
		
		JMenuItem miClose = new JMenuItem("Close");
		miClose.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C,InputEvent.CTRL_MASK));
		
		file.add(miNew);
		file.addSeparator();
		file.add(miClose);
		file.addSeparator();
		
		JMenu edit = new JMenu("Edit");
		edit.setMnemonic(KeyEvent.VK_E);
		JMenuItem miEdit = new JMenuItem("Edit");
		miEdit.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_E,InputEvent.CTRL_MASK));
		miEdit.addActionListener(new ActionListener() {
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
		});
		
		JMenuItem miDelete = new JMenuItem("Delete");
		miDelete.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_D,InputEvent.CTRL_MASK));
		miDelete.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
			
				if(MainFrame.getInstance().getTabbedPane().getSelectedIndex()==0) {
					int choice = JOptionPane.showConfirmDialog(null,"Da li ste sigurni da zelite da izbrisete studenta?","Brisanje studenta",JOptionPane.YES_NO_OPTION);
					if( choice == JOptionPane.YES_NO_OPTION){
						try {
							int i = MainFrame.getInstance().getTabelStudenta().getSelectedRow();
							System.out.println(i);
							String s=(String)MainFrame.getInstance().getTabelStudenta().getValueAt(i, 0);
							System.out.println(s);
							StudentKontroler.getInstance().obrisiStudenta(s);
						} catch (Exception e2) {
						System.out.println("niste selektovali vrstu u tabeli profesor");
						}
					}
				}
				else if(MainFrame.getInstance().getTabbedPane().getSelectedIndex()==1) {
					int choice = JOptionPane.showConfirmDialog(null,"Da li ste sigurni da zelite da izbrisete profesora?","Brisanje profesora",JOptionPane.YES_NO_OPTION);
					if( choice == JOptionPane.YES_NO_OPTION){
						try {
							int i = MainFrame.getInstance().getTabelProfesora().getSelectedRow();
							System.out.println(i);
							String s=(String)MainFrame.getInstance().getTabelProfesora().getValueAt(i, 7);
							System.out.println(s);
							ProfesorKontroler.getInstance().obrisiProfesora(s);
						} catch (Exception e2) {
						System.out.println("niste selektovali vrstu u tabeli profesor");
						}
					}
				}
				else if(MainFrame.getInstance().getTabbedPane().getSelectedIndex()==2) {
					int choice = JOptionPane.showConfirmDialog(null,"Da li ste sigurni da zelite da izbrisete predmet?","Brisanje predmeta",JOptionPane.YES_NO_OPTION);
					if( choice == JOptionPane.YES_NO_OPTION){
						try {
							int i = MainFrame.getInstance().getTabelPredmeta().getSelectedRow();
							System.out.println(i);
							String s=(String)MainFrame.getInstance().getTabelPredmeta().getValueAt(i, 0);
							//StudenskaSluzba.getInstance().izbrisiPredmet(s);
							PredmetKontroler.getInstance().obrisiPredmet(s);
						} catch (Exception e2) {
						System.out.println("niste selektovali vrstu u tabeli predmet");
						}
					}
				}
				
				MainFrame.getInstance().azurirajPrikaz();
			}
		});
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
