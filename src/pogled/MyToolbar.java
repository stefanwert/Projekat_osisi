package pogled;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

import actionListener.ActionListenerAdd;
import actionListener.ActionListenerAddProfesorOnPredmet;
import actionListener.ActionListenerEdit;
import actionListener.ActionListenerRemove;
import actionListener.ActionListenerSearch;
import actionListener.DocumentListenerPredmet;
import model.Predmet;
import model.Profesor;
import kontroler.*;
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
		
		JButton btnAddProfesoraNapredmet =new JButton();
		btnAddProfesoraNapredmet.setToolTipText("Dodaj Profesora na predmet");
		btnAddProfesoraNapredmet.setBackground(Color.white);
		btnAddProfesoraNapredmet.setIcon(new ImageIcon("images/add3.png"));
		btnAddProfesoraNapredmet.setBorderPainted(false);
		btnAddProfesoraNapredmet.addActionListener(new ActionListenerAddProfesorOnPredmet());
		
		JPanel left=new JPanel();
		left.setBackground(Color.white);
	    left.add(btnNew);
		left.add(btnEdit);
		left.add(btnDelete);
		left.add(btnAddStudentaNaPredmet);
		left.add(btnAddProfesoraNapredmet);
		
		tf=new JTextField();
		DocumentListenerPredmet dl=new DocumentListenerPredmet();
		//tf.getDocument().addDocumentListener(dl);
		//tf.setMaximumSize(new Dimension(200,2000));
		tf.setPreferredSize(new Dimension(200,20));

		
		btnSearch =new JButton();
		btnSearch.setToolTipText("Search");
		btnSearch.setBackground(Color.white);
		btnSearch.addActionListener(new ActionListenerSearch());
		btnSearch.setIcon(new ImageIcon("images/loopbtn.png"));
		btnSearch.setBorderPainted(false);
		btnSearch.addActionListener(new ActionListenerSearch());

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
