package pogled;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.LayoutManager;
import java.awt.Panel;
import java.awt.Toolkit;

import javax.swing.JFrame;

public class MainFrame extends JFrame{
	MainFrame(){
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
	

	
	
	
	setVisible(true);
	}
}
