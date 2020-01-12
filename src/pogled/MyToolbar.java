package pogled;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JToolBar;
import javax.swing.SwingConstants;
import javax.swing.event.DocumentListener;

import actionListener.ActionListenerAdd;
import actionListener.ActionListenerEdit;
import actionListener.ActionListenerRemove;
import actionListener.DocumentListenerForDelete;
import actionListenerPredmet.ActionListenerSearchPredmet;
import actionListenerProfesor.ActionListenerAddProfesorOnPredmet;
import actionListenerProfesor.ActionListenerRemoveProfesorFromPredmet;
import actionListenerProfesor.ActionListenerSearchProfesor;
import actionListenerStudent.ActionListenerAddStudentaToPredmet;
import actionListenerStudent.ActionListenerSearchStudent;
public class MyToolbar extends JToolBar{
	/**
	 * 
	 */
	private JTextField tf;
	static private MyToolbar instance=null;
	private static final long serialVersionUID = 1L;
	private boolean tacno=false;
	private JButton btnSearch;
	
	static public MyToolbar getInstance() {
		if(instance==null) {
			 instance=new MyToolbar();
		}
		return instance;
		
	}
	
	private MyToolbar() {
		super(SwingConstants.HORIZONTAL);
		
		Toolkit kit = Toolkit.getDefaultToolkit();
		Dimension screenSize= kit.getScreenSize();
		int screenHeight=screenSize.height;
		int screenWidth=screenSize.width;
		setLayout(new BorderLayout());
		
		JButton btnNew=new JButton();
		btnNew.addActionListener(new ActionListenerAdd());
		btnNew.setBackground(Color.white);
		btnNew.setToolTipText("Add");
		btnNew.setIcon(new ImageIcon("images/addbtn.png"));
		btnNew.setBorderPainted(false);

		
		
		JButton btnEdit=new JButton();
		btnEdit.setToolTipText("Edit");
		btnEdit.setBackground(Color.white);
		btnEdit.setIcon(new ImageIcon("images/editbtn.png"));
		btnEdit.setBorderPainted(false);
		btnEdit.addActionListener(new ActionListenerEdit());
		
		JButton btnDelete=new JButton();
		btnDelete.addActionListener(new ActionListenerRemove());
		btnDelete.setToolTipText("Delete");
		btnDelete.setBackground(Color.white);
		btnDelete.setIcon(new ImageIcon("images/removebtn.png"));
		btnDelete.setBorderPainted(false);
		
		JButton btnAddStudentaNaPredmet =new JButton();
		btnAddStudentaNaPredmet.setToolTipText("Dodaj studenta na predmet");
		btnAddStudentaNaPredmet.setBackground(Color.white);
		btnAddStudentaNaPredmet.setIcon(new ImageIcon("images/add2.png"));
		btnAddStudentaNaPredmet.setBorderPainted(false);
		btnAddStudentaNaPredmet.addActionListener(new ActionListenerAddStudentaToPredmet());
		
		JButton btnAddProfesoraNapredmet =new JButton();
		btnAddProfesoraNapredmet.setToolTipText("Dodaj Profesora na predmet");
		btnAddProfesoraNapredmet.setBackground(Color.white);
		btnAddProfesoraNapredmet.setIcon(new ImageIcon("images/add3.png"));
		btnAddProfesoraNapredmet.setBorderPainted(false);
		btnAddProfesoraNapredmet.addActionListener(new ActionListenerAddProfesorOnPredmet());
		
		JButton btnRemoveProfesoraSaPredmeta=new JButton();
		btnRemoveProfesoraSaPredmeta.setToolTipText("Obrisi Profesora sa predmeta");
		btnRemoveProfesoraSaPredmeta.setBackground(Color.white);
		btnRemoveProfesoraSaPredmeta.setIcon(new ImageIcon("images/remove2.png"));
		btnRemoveProfesoraSaPredmeta.setBorderPainted(false);
		btnRemoveProfesoraSaPredmeta.addActionListener(new ActionListenerRemoveProfesorFromPredmet());
		
		JPanel left=new JPanel();
		left.setBackground(Color.white);
	    left.add(btnNew);
		left.add(btnEdit);
		left.add(btnDelete);
		left.add(btnAddStudentaNaPredmet);
		left.add(btnAddProfesoraNapredmet);
		left.add(btnRemoveProfesoraSaPredmeta);
		
		tf=new JTextField();
		tf.setPreferredSize(new Dimension(200,20));
		DocumentListener dl=new DocumentListenerForDelete();
		tf.getDocument().addDocumentListener(dl);
		
		btnSearch =new JButton();
		btnSearch.setToolTipText("Search");
		btnSearch.setBackground(Color.white);
		btnSearch.addActionListener(new ActionListenerSearchPredmet());
		btnSearch.addActionListener(new ActionListenerSearchProfesor());
		btnSearch.addActionListener(new ActionListenerSearchStudent());
		btnSearch.setIcon(new ImageIcon("images/loopbtn.png"));
		btnSearch.setBorderPainted(false);

		JPanel right=new JPanel();
		right.setBackground(Color.white);
		right.add(tf);
		right.add(btnSearch);
		
		
		add(left,BorderLayout.WEST);
		add(right,BorderLayout.EAST);
		
		setFloatable(false);
	}
	public JTextField getTextFild() {
		return tf; 
	}
	
	public JButton getButtonSrc() {
		return btnSearch;
	}
}
