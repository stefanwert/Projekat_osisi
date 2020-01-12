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
	        
	        String tekst="ADD: Klikom na Add dugme se vrsi dodavanje studenta,profesora i predmeta u zavisnosti od toga koji je tab selektovan pojavice se odgovarajuci dijalog za unos.\n Precica za dodavanje je Ctrl+N \n"
	        		+ "EDIT: Za editovanje je potrebno selektovati vrstu u tabeli koju zelite editovati i klikom na dugme Edit pojavice se dijalog u kom se vrse izmene.\n Precica za izmenu je Ctrl+E \n"
	        		+ "DELETE: Klikom na Delete dugme se brise selektovana vrsta iz tabele.\n Precica za brisanje je Ctrl+E \n \n"
	        		+ "DODAJ STUDENTA NA PREDMET: Ova funkcionalonst je omogucena tako sto se unutar tabele Predmet selektuje zeljeni predmet i na klik\n dugmeta Dodaj studenta na predmet se otvara dijalog u kome je neophodno uneti broj indeksa studenta.\n \n"
	        		+ "OBRISI STUDENTA SA PREDMETA: Ova funkcionalnost je omogucena tako sto se unutar tabele Predmet selektuje zeljeni predmet i klikom\n na dugme Prikazi se otvara dijalog sa spiskom studenata na predmetu odakle se selektuje jedana vrsta i klikom na dugme obrisi se brise.\n \n"
	        		+ "DODAJ PROFESORA NA PREDMET: Ova funkcionalonst je omogucena tako sto se unutar tabele Predmet selektuje zeljeni predmet i na klik\n dugmeta Dodaj profesora na predmet se otvara dijalog u kome je neophodno uneti broj licne karte profesora.\n \n"
	        		+ "OBRISI PROFESORA SA PREDMETA: Ova funkcionalnost je omogucena tako sto se unutar tabele Predmet selektuje zeljeni predmet i klikom\n na dugme Obrisi profesora se brise profesor sa predmeta.\n \n"
	        		+ "SEARCH: Unutar tekst polja za pretragu se unosi naziv klone po kojoj pretrazujemo zatim dvotacka pa nakon toga vrednost kolone.\n Ako zelimo da pretrazujemo po jos nekoj koloni potrebno je staviti ; i ponoviti postupak naziv kolone:vrednost kolone.\n"
	        		+ " Pritiskom na dugme search filtrira se tabela.\n Brisanjem teksta iz txt polja tabela se vraca u pocetno stanje.\n"
	        		+ "SORTIRANJE: Dvoklikom na kolonu tabele omogucuje se sortiranje rastucem ili opadajucem redosledu po izabranoj koloni.\n"
	        		+ " Precica za zatvaranje aplikacije je Ctrl+C\n";
	        // viselinijsko tekstualno polje
	        JTextArea textArea = new JTextArea(tekst);
	        textArea.setEditable(false);
	        // dodajemo scroller-e po potrebi
	        JScrollPane scrollPane = new JScrollPane(textArea, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
	        
	        txtPanel.add(scrollPane, BorderLayout.CENTER);
			
	        this.add(txtPanel);
		}
		
}
