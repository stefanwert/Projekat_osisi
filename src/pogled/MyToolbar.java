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

import javax.imageio.ImageIO;
import javax.swing.*;

import model.Predmet;
import model.Profesor;
import kontroler.*;
public class MyToolbar extends JToolBar{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public MyToolbar() {
		super(SwingConstants.HORIZONTAL);
		
		Toolkit kit = Toolkit.getDefaultToolkit();
		Dimension screenSize= kit.getScreenSize();
		int screenHeight=screenSize.height;
		int screenWidth=screenSize.width;
		setLayout(new BorderLayout());
		
		JButton btnNew=new JButton();
		btnNew.setBackground(Color.white);
		btnNew.setToolTipText("Add");
		btnNew.setIcon(new ImageIcon("images/addbtn.png"));
		btnNew.setBorderPainted(false);
		btnNew.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				PredmetKontroler.getInstance().dodaj_predmet("sifra_pr", "naziv",1,2,new Profesor(), null);
			}
		});
		
		
		JButton btnEdit=new JButton();
		btnEdit.setToolTipText("Edit");
		btnEdit.setBackground(Color.white);
		btnEdit.setIcon(new ImageIcon("images/editbtn.png"));
		btnEdit.setBorderPainted(false);
		btnEdit.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				PredmetKontroler.getInstance().izmeni_predmet(MainFrame.getTabel().getSelectedRow());
				
			}
		});
		
		JButton btnDelete=new JButton();
		btnDelete.setToolTipText("Delete");
		btnDelete.setBackground(Color.white);
		btnDelete.setIcon(new ImageIcon("images/removebtn.png"));
		btnDelete.setBorderPainted(false);
		btnDelete.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				PredmetKontroler.getInstance().obrisi_predmet(MainFrame.getTabel().getSelectedRow());
				
			}
		});
		
		JPanel left=new JPanel();
		left.setBackground(Color.white);
	    left.add(btnNew);
		left.add(btnEdit);
		left.add(btnDelete);
		
		JTextField tf=new JTextField();
		//tf.setMaximumSize(new Dimension(200,2000));
		tf.setPreferredSize(new Dimension(200,20));

		
		JButton btnSearch =new JButton();
		btnSearch.setToolTipText("Search");
		btnSearch.setBackground(Color.white);
		btnSearch.setIcon(new ImageIcon("images/loopbtn.png"));
		btnSearch.setBorderPainted(false);

		JPanel right=new JPanel();
		right.setBackground(Color.white);
		right.add(tf);
		right.add(btnSearch);
		
//		add(btnNew);
//		add(btnEdit);
//		add(btnDelete);
//		add(tf);
//		add(btnSearch);
		//add(btnDelete,WEST);
		//add(tf,EAST);
		
		
		add(left,BorderLayout.WEST);
		add(right,BorderLayout.EAST);
		
		setFloatable(false);
	}
}
