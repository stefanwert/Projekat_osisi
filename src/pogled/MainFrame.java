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
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.table.TableModel;

import model.Predmet;
import model.StudenskaSluzba;

public class MainFrame extends JFrame{
	
	private static JTable tabelaPredmeta;
	
	public MainFrame(){
	Toolkit kit = Toolkit.getDefaultToolkit();
	Dimension screenSize= kit.getScreenSize();
	int screenHeight=screenSize.height;
	int screenWidth=screenSize.width;
	
	setSize(screenWidth*3/4,screenHeight*3/4);
	setTitle("Studentska sluzba");
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	setLocationRelativeTo(null);
	setBackground(Color.LIGHT_GRAY);
	
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
		JTabbedPane tabbedPanePredmet=new JTabbedPane();
		tabelaPredmeta=new PredmetJTable();
		JScrollPane scrollpanePredmet=new JScrollPane(tabelaPredmeta);
		
		tabbedPanePredmet.addTab("Predmet",scrollpanePredmet);
		//tabbedPanePredmet.addTab("Profesor",null);
		add(tabbedPanePredmet,BorderLayout.CENTER);
		
		azurirajPrikaz(null,-1);
		
	}
	
	public void azurirajPrikaz(String akcija,int vrednost) {
		PredmetTableModel model=(PredmetTableModel) tabelaPredmeta.getModel();
		if(akcija != null) {
			if (akcija.toUpperCase().trim().equals("DODAT")) {
				//model.igracDodat();
			} else if (akcija.toUpperCase().trim().equals("UKLONJEN")) {
				//model.igracUklonjen(vrednost);
			}
		}
		model.fireTableDataChanged();
		validate();
	}
	
	public static JTable getTabel() {
		return tabelaPredmeta;
	}
}
