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
	
	
	/*String[][] data = { 
            { "sifra","naz","2","2","vidakovic"},
            { "sifra","naz","24","3","perisic"}
        }; 
	String[] columnNames = new String[5];
	for(int i=0;i<StudenskaSluzba.getInstance().getColumCountPredmeta();i++)
		columnNames[i]=StudenskaSluzba.getInstance().getColumnNamePredmeta(i);
	
	tabelaPredmeta=new JTable(data,columnNames);
	tabelaPredmeta.setBounds(30, 40, 200, 300); 
	JScrollPane sp=new JScrollPane(tabelaPredmeta);
	
	
	JTabbedPane q=new JTabbedPane();
	q.addTab("prvi", sp);
	add(q,BorderLayout.CENTER);*/
	
	
	prikaziTabeluIgraca();
	
	
	setVisible(true);
	}
	
	private void prikaziTabeluIgraca() {
		tabbedPane=new JTabbedPane();
		
		tabelaStudenata=new StudentJTable();
		tabelaStudenata.setAutoCreateRowSorter(true);
		JScrollPane scrollpaneStudent=new JScrollPane(tabelaStudenata);
		tabbedPane.addTab("Studenti",scrollpaneStudent);
		System.out.println(tabbedPane.indexOfTab("Studenti"));

		JPanel pan=new JPanel();
		pan.setBackground(Color.WHITE);
		tabbedPane.addTab("Profesori",pan);
		add(tabbedPane,BorderLayout.CENTER);
		
		tabelaPredmeta=new PredmetJTable();
		tabelaPredmeta.setAutoCreateRowSorter(true);
		JScrollPane scrollpanePredmet=new JScrollPane(tabelaPredmeta);
		tabbedPane.addTab("Predmeti",scrollpanePredmet);
		System.out.println(tabbedPane.indexOfTab("Predmeti"));
		azurirajPrikaz();
		
	}
	
	public JTabbedPane getTabbedPane() {
		return tabbedPane;
	}
	public void azurirajPrikaz() {
		PredmetTableModel model=(PredmetTableModel) tabelaPredmeta.getModel();
		model.fireTableDataChanged();
		validate();
	}
	
	public static JTable getTabel() {
		return tabelaPredmeta;
	}
}
