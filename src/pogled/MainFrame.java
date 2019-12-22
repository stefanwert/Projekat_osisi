package pogled;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.LayoutManager;
import java.awt.Panel;
import java.awt.Toolkit;

import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.table.TableModel;

import model.Predmet;
import model.StudenskaSluzba;


public class MainFrame extends JFrame{
	
	private static JTable tabelaPredmeta;
	private static JTable tabelaStudenata;
	private static JTable tabelaProfesora; 
	private static MainFrame instance=null;
	private JTabbedPane tabbedPane=null;
	
	public static MainFrame getInstance() {
		if(instance==null) {
			instance=new MainFrame();
		}
		return instance;
	}
	
	private MainFrame(){
	Toolkit kit = Toolkit.getDefaultToolkit();
	Dimension screenSize= kit.getScreenSize();
	int screenHeight=screenSize.height;
	int screenWidth=screenSize.width;
	
	setSize(screenWidth*3/5,screenHeight*3/5);
	setTitle("Studentska sluzba");
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	setLocationRelativeTo(null);
	setLayout(new BorderLayout(10,10));
	setBackground(Color.WHITE);
	
	MyMenuBar menu = new MyMenuBar();
	this.setJMenuBar(menu);
	
	MyToolbar toolbar = new MyToolbar();
	toolbar.setBackground(Color.white);
	add(toolbar,BorderLayout.NORTH);
	
	MyStatusBar statusbar = new MyStatusBar();
	add(statusbar,BorderLayout.SOUTH);
	
	prikaziTabele();
	
	setVisible(true);
	}
	
	private void prikaziTabele() {
		tabbedPane=new JTabbedPane();
		
		tabelaStudenata=new StudentJTable();
		tabelaStudenata.setAutoCreateRowSorter(true);
		JScrollPane scrollpaneStudent=new JScrollPane(tabelaStudenata);
		tabbedPane.addTab("Studenti",scrollpaneStudent);

//		JPanel pan=new JPanel();
		tabelaProfesora=new ProfesorJTable();
		tabelaProfesora.setAutoCreateRowSorter(true);
		JScrollPane scrollpaneProfesor=new JScrollPane(tabelaProfesora);
		tabbedPane.addTab("Profesori",scrollpaneProfesor);
		
		add(tabbedPane,BorderLayout.CENTER);
		
		tabelaPredmeta=new PredmetJTable();
		tabelaPredmeta.setAutoCreateRowSorter(true);
		JScrollPane scrollpanePredmet=new JScrollPane(tabelaPredmeta);
		tabbedPane.addTab("Predmeti",scrollpanePredmet);
		
		azurirajPrikaz();
	}
	
	public JTabbedPane getTabbedPane() {
		return tabbedPane;
	}
	
	public void azurirajPrikaz() {
		PredmetTableModel model=(PredmetTableModel) tabelaPredmeta.getModel();
		model.fireTableDataChanged();
		ProfesorTableModel model2=(ProfesorTableModel) tabelaProfesora.getModel();
		model2.fireTableDataChanged();
		
		//ovde dodaj i za studenta
		validate();
	}
	
	public static JTable getTabelPredmeta() {
		return tabelaPredmeta;
	}
	public static JTable getTabelProfesora() {
		return tabelaProfesora;
	}
	public static JTable getTabelStudenta() {
		return tabelaStudenata;
	}
}
