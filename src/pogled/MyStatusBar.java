package pogled;

import java.awt.BorderLayout;
import java.awt.Color;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class MyStatusBar extends JPanel{
	
	public MyStatusBar(){
		super();
	    setLayout(new BorderLayout());
		setBackground(Color.LIGHT_GRAY);		
		JLabel ssl = new JLabel("Studentska sluzba");
		add(ssl,BorderLayout.WEST);
	
	    LocalDateTime myDateObj = LocalDateTime.now();
	    DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("HH:mm  dd.MM.yyyy.");
	    String formattedDate = myDateObj.format(myFormatObj);
	    JLabel vr_dat = new JLabel(formattedDate);
	    add(vr_dat,BorderLayout.EAST);
	
	}
	
}
