package pogled;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

import actionListener.WindowListenerForMainFrame;


public class MainFrame extends JFrame{
	
	private static JTable tabelaPredmeta;
	private JTable tabelaStudenata;
	private JTable tabelaProfesora; 
	private static MainFrame instance=null;
	private JTabbedPane tabbedPane=null;
	private static TableRowSorter<TableModel> rowSorterTableStudent;
	private static TableRowSorter<TableModel> rowSorterTableProfesor;
	private static TableRowSorter<TableModel> rowSorterTablePredmet;
	
	
	static public MainFrame getInstance() {
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
	
	this.addWindowListener(new WindowListenerForMainFrame());
	
	setSize(screenWidth*3/5,screenHeight*3/5);
	setTitle("Studentska sluzba");
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	setLocationRelativeTo(null);
	setLayout(new BorderLayout(10,10));
	setBackground(Color.WHITE);
	
	prikaziTabele();
	MyMenuBar menu = new MyMenuBar();
	this.setJMenuBar(menu);
	
	MyToolbar toolbar = MyToolbar.getInstance();
	toolbar.setBackground(Color.white);
	add(toolbar,BorderLayout.NORTH);
	
	MyStatusBar statusbar = new MyStatusBar();
	add(statusbar,BorderLayout.SOUTH);
	
	
	setVisible(true);
	}
	
	private void prikaziTabele() {
		tabbedPane=new JTabbedPane();
		
		tabelaStudenata=new StudentJTable();
		tabelaStudenata.setAutoCreateRowSorter(true);
		JScrollPane scrollpaneStudent=new JScrollPane(tabelaStudenata);
		tabbedPane.addTab("Studenti",scrollpaneStudent);

		tabelaProfesora=new ProfesorJTable();
		tabelaProfesora.setAutoCreateRowSorter(true);
		JScrollPane scrollpaneProfesor=new JScrollPane(tabelaProfesora);
		tabbedPane.addTab("Profesori",scrollpaneProfesor);
		
		tabelaPredmeta=new PredmetJTable();
		tabelaPredmeta.setAutoCreateRowSorter(true);
		JScrollPane scrollpanePredmet=new JScrollPane(tabelaPredmeta);
		tabbedPane.addTab("Predmeti",scrollpanePredmet);
		
		rowSorterTableStudent=new TableRowSorter<TableModel>(tabelaStudenata.getModel());	
		tabelaStudenata.setRowSorter(rowSorterTableStudent);	
		rowSorterTablePredmet=new TableRowSorter<TableModel>(tabelaPredmeta.getModel());	
		tabelaPredmeta.setRowSorter(rowSorterTablePredmet);									
		rowSorterTableProfesor=new TableRowSorter<TableModel>(tabelaProfesora.getModel());
		tabelaProfesora.setRowSorter(rowSorterTableProfesor);
																				
		
		
		add(tabbedPane,BorderLayout.CENTER);
		
		azurirajPrikaz();
	}
	
	public JTabbedPane getTabbedPane() {
		return tabbedPane;
	}
	
	public void azurirajPrikaz() {
		StudentTableModel model=(StudentTableModel) tabelaStudenata.getModel();
		model.fireTableDataChanged();
		ProfesorTableModel model2=(ProfesorTableModel) tabelaProfesora.getModel();
		model2.fireTableDataChanged();
		PredmetTableModel model3=(PredmetTableModel) tabelaPredmeta.getModel();
		model3.fireTableDataChanged();
		validate();
	}
	
	public JTable getTabelStudenta() {
		return tabelaStudenata;
	}
	public JTable getTabelProfesora() {
		return tabelaProfesora;
	}
	public static JTable getTabelPredmeta() {
		return tabelaPredmeta;
	}
	
	public static TableRowSorter getTableRowSorterStudent() {
		return rowSorterTableStudent;
	}
	public static TableRowSorter getTableRowSorterProfesor() {
		return rowSorterTableProfesor;
	}
	public static TableRowSorter getTableRowSorterPredmet() {
		return rowSorterTablePredmet;
	}
}
