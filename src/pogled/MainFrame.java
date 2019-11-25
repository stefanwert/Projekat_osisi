package pogled;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;

public class MainFrame extends JFrame{
	MainFrame(){
	Toolkit kit = Toolkit.getDefaultToolkit();
	Dimension screenSize= kit.getScreenSize();
	int screenHeight=screenSize.height;
	int screenWidth=screenSize.width;
	
	setSize(screenWidth*3/4,screenHeight*3/4);
	setTitle("Glavni prozor");
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	setLocationRelativeTo(null);
	getContentPane().setBackground(Color.LIGHT_GRAY);

	
	
	setVisible(true);
	}
}
