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
	
	setSize(screenWidth*3/4,screenHeight*3/4);
	setTitle("Studentska sluzba");
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	setLocationRelativeTo(null);
	setBackground(Color.LIGHT_GRAY);
	
	MyMenuBar menu = new MyMenuBar();
	this.setJMenuBar(menu);
	
	MyToolbar toolbar = new MyToolbar();
	toolbar.setBackground(Color.white);
	add(toolbar,BorderLayout.NORTH);
	
	
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
		tabelaPredmeta=new PredmetJTable();
		tabelaPredmeta.setAutoCreateRowSorter(true);
		JScrollPane scrollpanePredmet=new JScrollPane(tabelaPredmeta);
		
		tabbedPane.addTab("Predmet",scrollpanePredmet);
		System.out.println(tabbedPane.indexOfTab("Predmet"));
		JPanel pan=new JPanel();
		pan.setBackground(Color.red);
		tabbedPane.addTab("Profesor",pan);
		add(tabbedPane,BorderLayout.CENTER);
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
