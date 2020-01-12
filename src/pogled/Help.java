package pogled;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class Help extends JFrame {

	 private static Help instance =null;
		
		static public Help getInstance() {
			if(instance==null) {
				instance=new Help();
			}
			return instance;
		}
		public static void removeInstance() {
			instance=null;
		}
		
		private Help(){
				
		       
		}
		public void call() {
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
	        
	        JLabel label = new JLabel("Detaljan opis o nacinu koriscenja aplikacije");
	        label.setPreferredSize(new Dimension(20, 20));
	        txtPanel.add(label, BorderLayout.NORTH);
	        
	        String tekst="ADD: add dugme vrsi dodavanje studenta,profesora i predmeta u zavisnosti koji je tab selektovan pojavice se dijalog"
	        		+ " za unos.\nEDIT: Za editovanje potrebno je selektovati unutar tabele vrstu koju zelite editovati i pritiskom na dugme edit pojavice se dijalog.\n"
	        		+ "REMOVE: remove dugme brise vrstu iz tabele ali je neophodno pre toga selektovati vrstu unutar tabele.\n"
	        		+ "DODAJ STUDENTA NA PREDMET: Ova funkcionalonst je omogucena tako sto se unutar tabele predmet selektuje neki predmet i na klik\n dugmeta dodaj studenta na predmet se otvara dijalog u kome je neophodno uneti broj indeksa studenta \n"
	        		+ "OBRISI STUDENTA SA PREDMETA: Ova funkcionalnost je omogucena tako sto se unutar tabele predmet selektuje zeljeni predmet i klikom\n na dugme prikazi se otvara dijalog sa spiskom studenata na predmetu odakle se selektuje jedana vrsta i klikom na dugme obrisi se brise  \n"
	        		+ "DODAJ PROFESORA NA PREDMET: Ova funkcionalonst je omogucena tako sto se unutar tabele predmet selektuje neki predmet i na klik\n dugmeta dodaj profesora na predmet se otvara dijalog u kome je neophodno uneti kljuc profesora\n"
	        		+ "OBRISI PROFESORA SA PREDMETA: Ova funkcionalnost je omogucena tako sto se unutar tabele predmet selektuje zeljeni predmet i klikom\n na dugme obrisi profesora sa predmeta se brise profesor sa predmeta"
	        		+ "\nSEARCH: Unese se naziv kolone dvotacka vrednost kolone unutar txt polja.\nAko zelimo da pretrazujemo po jos nekoj\n koloni potrebno je staviti ; i ponoviti postupak naziv kolone dvotacka "
	        		+ "vrednost kolone.Pritiskom na dugme search filtrira se tabela.\nBrisanjem teksta iz txt polja tabela se vraca u normalu."
	        		+ "\nSORTIRANJE: Dvoklikom na kolonu tabele tabela se sortira u rastucem ili opadajucem redosledu.\n";
	        // viselinijsko tekstualno polje
	        JTextArea textArea = new JTextArea(tekst);
	        // dodajemo scroller-e po potrebi
	        JScrollPane scrollPane = new JScrollPane(textArea, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
	        
	        txtPanel.add(scrollPane, BorderLayout.CENTER);
			
	        this.add(txtPanel);
		}
		
}
