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
		
		private About(){}
		
		public void call(){
			Toolkit kit = Toolkit.getDefaultToolkit();
	        Dimension screenSize = kit.getScreenSize();
	        int screenHeight = screenSize.height;
	        int screenWidth = screenSize.width;
	        setSize(screenWidth / 2, screenHeight / 2);
	        setTitle("About");
	        setLocationRelativeTo(null);
	        setVisible(true);
	        
	        JPanel txtPanel = new JPanel(new BorderLayout(10,5));
	        txtPanel.setBackground(Color.LIGHT_GRAY);
	        
	        JLabel label = new JLabel("Informacije o autorima");
	        label.setPreferredSize(new Dimension(20, 20));
	        txtPanel.add(label, BorderLayout.NORTH);
	        
	        String tekst="Verzija aplikacije: v1.0StudentskaSluzba\n \n"
	        		+ " Opis aplikacije:\n"
	        		+ " Ova aplikacija sluzi za rad na studentskoj sluzbi.Omoguceno je manipulisanje nad svim postojecim podacima kao i dodavanje novih.\n Neke od funkijonalnosti sistema su: dodavanje,izmena,brisanje,pretraga i sortiranje nad tabelama Studenata,Profesora i Predmeta.\n \n"
	        		+ " O autorima:\n"
	        		+ " Nemanja Tamindzija - Rodjen 16.08.1997 u Rumi, odrastao je u Nevesinju gdje je pohadjao osnovnu skolu \"Risto Prorokovic\" \n "
	        		+ " i gimnaziju \"Aleksa Santic\".Trenutno je student trece godine Elektrotehnike na Fakultetu tehnickih nauka u Novom Sadu.\n \n"
	        		+ " Stefan Petrovic - Rodjen 21.10.1998 u Smederevu gdje je odrastao i stekao obrazovanje, pohadjao je osnovnu skolu \"Ivo andric\" \n"
	        		+ " i Srednju tehnicku skolu u Smederevu.Trenutno je student trece godine Elektrotehnike na Fakultetu tehnickih nauka u Novom Sadu.\n";
	        
	        // viselinijsko tekstualno polje
	        JTextArea textArea = new JTextArea(tekst);
	        textArea.setEditable(false);
	        // dodajemo scroller-e po potrebi
	        JScrollPane scrollPane = new JScrollPane(textArea, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
	        
	        txtPanel.add(scrollPane, BorderLayout.CENTER); 
	        
	        this.add(txtPanel);
		}

}
