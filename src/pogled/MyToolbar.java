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

import ActionListener.ActionListenerAdd;
import ActionListener.ActionListenerEdit;
import ActionListener.ActionListenerRemove;
import ActionListener.ActionListenerSearch;
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
		//dodati action listener
		
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
		btnSearch.addActionListener(new ActionListenerSearch());
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
}
