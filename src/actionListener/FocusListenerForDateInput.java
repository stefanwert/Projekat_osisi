package actionListener;

import java.awt.Color;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.util.regex.Pattern;

import javax.swing.JTextField;

public class FocusListenerForDateInput implements FocusListener{

	@Override
	public void focusGained(FocusEvent e) {
		JTextField txt = (JTextField) e.getComponent();
		txt.setBackground(Color.WHITE);
		
	}

	@Override
	public void focusLost(FocusEvent e) {
		JTextField txt = (JTextField) e.getComponent();
		txt.setBackground(Color.GRAY);

		// polje prezime je obavezno za unos:
		Pattern p=Pattern.compile("\\d{2}\\.\\d{2}\\.\\d{4}");
		System.out.println(p.matcher(txt.getText()).matches());
		if (!p.matcher(txt.getText()).matches()) {
			txt.setText("Unesite datum u formatu: dd.MM.yyyy");
			txt.requestFocus();
			txt.setForeground(Color.RED);
		} else {
			txt.setForeground(Color.BLACK);
		}
		
		
	}

}
