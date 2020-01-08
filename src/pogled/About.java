package pogled;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class About extends JFrame {
	
	 private static About instance =null;
		
		static public About getInstance() {
			if(instance==null) {
				instance=new About();
			}
			return instance;
		}
		public static void removeInstance() {
			instance=null;
		}
		
		private About(){
				Toolkit kit = Toolkit.getDefaultToolkit();
		        Dimension screenSize = kit.getScreenSize();
		        int screenHeight = screenSize.height;
		        int screenWidth = screenSize.width;
		        setSize(screenWidth / 2, screenHeight / 2);
		        setTitle("Help");
		        setLocationRelativeTo(null);
		        setVisible(true);
		        
		        JPanel txtPanel = new JPanel(new BorderLayout(10,5));
		        txtPanel.setBackground(Color.LIGHT_GRAY);
		        
		        JLabel label = new JLabel("Informacije o autorima");
		        label.setPreferredSize(new Dimension(20, 20));
		        txtPanel.add(label, BorderLayout.NORTH);
		        
		        // viselinijsko tekstualno polje
		        JTextArea textArea = new JTextArea("Ovo je viselinijsko tekstualno polje");
		        // dodajemo scroller-e po potrebi
		        JScrollPane scrollPane = new JScrollPane(textArea, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		        
		        txtPanel.add(scrollPane, BorderLayout.CENTER); 
		        
		        this.add(txtPanel);
		       
		}

}
