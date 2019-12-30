package pogled;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;

public class MyStatusBar extends JPanel{
	
	public MyStatusBar(){
		setLayout(new BorderLayout());
		setBackground(Color.LIGHT_GRAY);
	
		JLabel ssluzba =  new JLabel("Studentska sluzba");
		add(ssluzba,BorderLayout.WEST);
		
		DateTimeFormatter formatTime = DateTimeFormatter.ofPattern("HH:mm");
		DateTimeFormatter formatDate = DateTimeFormatter.ofPattern("dd.MM.yyyy.");
		JLabel vrDat =  new JLabel();
		add(vrDat,BorderLayout.EAST);
		
		Timer timer = new Timer(1000,new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent actionEvent){
				LocalTime vreme = LocalTime.now();
				LocalDate datum = LocalDate.now();
				String vremeIdatum = vreme.format(formatTime).toString() + "   "+ datum.format(formatDate).toString();
				vrDat.setText(vremeIdatum);
			}
		});
		timer.start();
	}
	
}
