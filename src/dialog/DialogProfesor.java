package dialog;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Frame;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import ActionListener.ActionListenerPotvrdiAdd;
import ActionListener.ActionListenerPotvrdiEdit;
import model.StudenskaSluzba;
import pogled.MainFrame;

public class DialogProfesor extends JDialog {

	static private JTextField txtIme;
	static private JTextField txtPrezime;
	static private JTextField txtDatumRodjenja;
	static private JTextField txtAdresaStanovanja;
	static private JTextField txtBrojTelefona;
	static private JTextField txtEmail;
	static private JTextField txtAdresaKancelarije;
	static private JTextField txtBrojLicneKarte;
	static private JTextField txtTitula;
	static private JTextField txtZvanje;
	static private JButton ok;
	
 private static DialogProfesor instance =null;
	
	public static DialogProfesor getInstance() {
		if(instance==null) {
			instance=new DialogProfesor();
		}
		return instance;
	}
	public static void removeInstance() {
		instance=null;
	}
	private DialogProfesor(){
		instance=new DialogProfesor();
	}
	
	public DialogProfesor(Frame parent, String title, boolean modal) {
		super(parent, title, modal);
		instance=this;
		setSize(440,500);
		setLocationRelativeTo(parent);
		
		setLayout(new BorderLayout());
		JPanel panel=new JPanel();
		GridBagLayout gridb=new GridBagLayout();
		setResizable(false);
		
		gridb.preferredLayoutSize(panel);
		panel.setLayout(gridb);
		add(panel,BorderLayout.CENTER);
		
		JLabel lblIme=new JLabel("Ime:");
		lblIme.setFont(new Font("Ime:",Font.PLAIN,18));
		JLabel lblPrezime=new JLabel("Prezime:");
		lblPrezime.setFont(new Font("Prezime:",Font.PLAIN,18));
		JLabel lblDatumRodjenja=new JLabel("Datum rodjenja:");
		lblDatumRodjenja.setFont(new Font("Datum rodjenja:",Font.PLAIN,18));
		JLabel lblAdresaStanovanja=new JLabel("Adresa stanovanja:");
		lblAdresaStanovanja.setFont(new Font("Adresa stanovanja:",Font.PLAIN,18));
		JLabel lblBrojTelefona=new JLabel("Broj telefona:");
		lblBrojTelefona.setFont(new Font("Broj telefona:",Font.PLAIN,18));
		JLabel lblEmail=new JLabel("E-mail:");
		lblEmail.setFont(new Font("Email:",Font.PLAIN,18));
		JLabel lblAdresaKancelarije=new JLabel("Adresa kancelarije:");
		lblAdresaKancelarije.setFont(new Font("Adresa kancelarije:",Font.PLAIN,18));
		JLabel lblBrojLicneKarte=new JLabel("Broj licne karte:");
		lblBrojLicneKarte.setFont(new Font("Broj licne karte:",Font.PLAIN,18));
		JLabel lblTitula=new JLabel("Titula:");
		lblTitula.setFont(new Font("Titula:",Font.PLAIN,18));
		JLabel lblZvanje=new JLabel("Zvanje:");
		lblZvanje.setFont(new Font("Zvanje:",Font.PLAIN,18));
		
		
		txtIme=new JTextField();
		txtIme.setPreferredSize(new Dimension(250,25));
		txtPrezime=new JTextField();
		txtPrezime.setPreferredSize(new Dimension(250,25));
		txtDatumRodjenja=new JTextField();
		txtDatumRodjenja.setPreferredSize(new Dimension(250,25));
		txtAdresaStanovanja=new JTextField();
		txtAdresaStanovanja.setPreferredSize(new Dimension(250,25));
		txtBrojTelefona=new JTextField();
		txtBrojTelefona.setPreferredSize(new Dimension(250,25));
		txtEmail=new JTextField();
		txtEmail.setPreferredSize(new Dimension(250,25));
		txtAdresaKancelarije=new JTextField();
		txtAdresaKancelarije.setPreferredSize(new Dimension(250,25));
		txtBrojLicneKarte=new JTextField();
		txtBrojLicneKarte.setPreferredSize(new Dimension(250,25));
		txtTitula=new JTextField();
		txtTitula.setPreferredSize(new Dimension(250,25));
		txtZvanje=new JTextField();
		txtZvanje.setPreferredSize(new Dimension(250,25));
		
		
		GridBagConstraints gblblIme=new GridBagConstraints();
		gblblIme.gridx=0;
		gblblIme.gridy=0;
		gblblIme.insets=new Insets(0, 0, 5, 0);
		gblblIme.anchor=GridBagConstraints.CENTER;
		panel.add(lblIme,gblblIme);
		GridBagConstraints gbtxtIme=new GridBagConstraints();
		gbtxtIme.gridx=1;
		gbtxtIme.gridy=0;
		gbtxtIme.insets=new Insets(0, 0, 5, 0);
		gbtxtIme.anchor=GridBagConstraints.WEST;
		gbtxtIme.weightx=100;
		gbtxtIme.weighty=0;
		panel.add(txtIme,gbtxtIme);
		
		GridBagConstraints gblblPrezime=new GridBagConstraints();
		gblblPrezime.gridx=0;
		gblblPrezime.gridy=1;
		gblblPrezime.insets=new Insets(10, 0, 5, 0);
		gblblPrezime.anchor=GridBagConstraints.CENTER;
		panel.add(lblPrezime,gblblPrezime);
		GridBagConstraints gbtxtPrezime=new GridBagConstraints();
		gbtxtPrezime.gridx=1;
		gbtxtPrezime.gridy=1;
		gbtxtPrezime.insets=new Insets(10, 0, 5, 0);
		gbtxtPrezime.anchor=GridBagConstraints.WEST;
		gbtxtPrezime.weightx=100;
		gbtxtPrezime.weighty=0;
		panel.add(txtPrezime,gbtxtPrezime);
		
		GridBagConstraints gblblDatumRodjenja=new GridBagConstraints();
		gblblDatumRodjenja.gridx=0;
		gblblDatumRodjenja.gridy=2;
		gblblDatumRodjenja.insets=new Insets(10, 0, 5, 0);
		gblblDatumRodjenja.anchor=GridBagConstraints.CENTER;
		panel.add(lblDatumRodjenja,gblblDatumRodjenja);
		GridBagConstraints gbtxtDatumRodjenja=new GridBagConstraints();
		gbtxtDatumRodjenja.gridx=1;
		gbtxtDatumRodjenja.gridy=2;
		gbtxtDatumRodjenja.insets=new Insets(10, 0, 5, 0);
		gbtxtDatumRodjenja.anchor=GridBagConstraints.WEST;
		gbtxtDatumRodjenja.weightx=100;
		panel.add(txtDatumRodjenja,gbtxtDatumRodjenja);
		
		GridBagConstraints gblblAdresaStanovanja=new GridBagConstraints();
		gblblAdresaStanovanja.gridx=0;
		gblblAdresaStanovanja.gridy=3;
		gblblAdresaStanovanja.insets=new Insets(10, 5, 5, 0);
		gblblAdresaStanovanja.anchor=GridBagConstraints.CENTER;
		panel.add(lblAdresaStanovanja,gblblAdresaStanovanja);
		GridBagConstraints gbtxtAdresaStanovanja=new GridBagConstraints();
		gbtxtAdresaStanovanja.gridx=1;
		gbtxtAdresaStanovanja.gridy=3;
		gbtxtAdresaStanovanja.insets=new Insets(10, 0, 5, 0);
		gbtxtAdresaStanovanja.anchor=GridBagConstraints.WEST;
		gbtxtAdresaStanovanja.weightx=100;
		panel.add(txtAdresaStanovanja,gbtxtAdresaStanovanja);
		
		GridBagConstraints gblblBrojTelefona=new GridBagConstraints();
		gblblBrojTelefona.gridx=0;
		gblblBrojTelefona.gridy=4;
		gblblBrojTelefona.insets=new Insets(10, 0, 5, 0);
		gblblBrojTelefona.anchor=GridBagConstraints.CENTER;
		panel.add(lblBrojTelefona,gblblBrojTelefona);
		GridBagConstraints gbtxtBrojTelefona=new GridBagConstraints();
		gbtxtBrojTelefona.gridx=1;
		gbtxtBrojTelefona.gridy=4;
		gbtxtBrojTelefona.insets=new Insets(10, 0, 5, 0);
		gbtxtBrojTelefona.anchor=GridBagConstraints.WEST;
		gbtxtBrojTelefona.weightx=100;
		panel.add(txtBrojTelefona,gbtxtBrojTelefona);
		
		GridBagConstraints gblblEmail=new GridBagConstraints();
		gblblEmail.gridx=0;
		gblblEmail.gridy=5;
		gblblEmail.insets=new Insets(10, 0, 5, 0);
		gblblEmail.anchor=GridBagConstraints.CENTER;
		panel.add(lblEmail,gblblEmail);
		GridBagConstraints gbtxtEmail=new GridBagConstraints();
		gbtxtEmail.gridx=1;
		gbtxtEmail.gridy=5;
		gbtxtEmail.insets=new Insets(10, 0, 5, 0);
		gbtxtEmail.anchor=GridBagConstraints.WEST;
		gbtxtEmail.weightx=100;
		gbtxtEmail.weighty=0;
		panel.add(txtEmail,gbtxtEmail);
		
		GridBagConstraints gblblAdresaKancelarije=new GridBagConstraints();
		gblblAdresaKancelarije.gridx=0;
		gblblAdresaKancelarije.gridy=6;
		gblblAdresaKancelarije.insets=new Insets(10, 5, 5, 0);
		gblblAdresaKancelarije.anchor=GridBagConstraints.CENTER;
		panel.add(lblAdresaKancelarije,gblblAdresaKancelarije);
		GridBagConstraints gbtxtAdresaKancelarije=new GridBagConstraints();
		gbtxtAdresaKancelarije.gridx=1;
		gbtxtAdresaKancelarije.gridy=6;
		gbtxtAdresaKancelarije.insets=new Insets(10, 0, 5, 0);
		gbtxtAdresaKancelarije.anchor=GridBagConstraints.WEST;
		gbtxtAdresaKancelarije.weightx=100;
		panel.add(txtAdresaKancelarije,gbtxtAdresaKancelarije);
		
		GridBagConstraints gblblBrojLicneKarte=new GridBagConstraints();
		gblblBrojLicneKarte.gridx=0;
		gblblBrojLicneKarte.gridy=7;
		gblblBrojLicneKarte.insets=new Insets(10, 0, 5, 0);
		gblblBrojLicneKarte.anchor=GridBagConstraints.CENTER;
		panel.add(lblBrojLicneKarte,gblblBrojLicneKarte);
		GridBagConstraints gbtxtBrojLicneKarte=new GridBagConstraints();
		gbtxtBrojLicneKarte.gridx=1;
		gbtxtBrojLicneKarte.gridy=7;
		gbtxtBrojLicneKarte.insets=new Insets(10, 0, 5, 0);
		gbtxtBrojLicneKarte.anchor=GridBagConstraints.WEST;
		gbtxtBrojLicneKarte.weightx=100;
		panel.add(txtBrojLicneKarte,gbtxtBrojLicneKarte);
		
		GridBagConstraints gblblTitula=new GridBagConstraints();
		gblblTitula.gridx=0;
		gblblTitula.gridy=8;
		gblblTitula.insets=new Insets(10, 0, 5, 0);
		gblblTitula.anchor=GridBagConstraints.CENTER;
		panel.add(lblTitula,gblblTitula);
		GridBagConstraints gbtxtTitula=new GridBagConstraints();
		gbtxtTitula.gridx=1;
		gbtxtTitula.gridy=8;
		gbtxtTitula.insets=new Insets(10, 0, 5, 0);
		gbtxtTitula.anchor=GridBagConstraints.WEST;
		gbtxtTitula.weightx=100;
		gbtxtTitula.weighty=0;
		panel.add(txtTitula,gbtxtTitula);
		
		GridBagConstraints gblblZvanje=new GridBagConstraints();
		gblblZvanje.gridx=0;
		gblblZvanje.gridy=9;
		gblblZvanje.insets=new Insets(10, 0, 5, 0);
		gblblZvanje.anchor=GridBagConstraints.CENTER;
		panel.add(lblZvanje,gblblZvanje);
		GridBagConstraints gbtxtZvanje=new GridBagConstraints();
		gbtxtZvanje.gridx=1;
		gbtxtZvanje.gridy=9;
		gbtxtZvanje.insets=new Insets(10, 0, 5, 0);
		gbtxtZvanje.anchor=GridBagConstraints.WEST;
		gbtxtZvanje.weightx=100;
		gbtxtZvanje.weighty=0;
		panel.add(txtZvanje,gbtxtZvanje);
	
		ok=new JButton("Potvrda");
		ok.addActionListener(new ActionListenerPotvrdiAdd());
		JButton odustani=new JButton("Odustani");
		odustani.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				DialogPredmet.getInstance().dispose();
				
			}
		});
		JPanel btnPanel=new JPanel();
		btnPanel.add(ok,BorderLayout.EAST);
		btnPanel.add(odustani,BorderLayout.WEST);
			
		GridBagConstraints gbok=new GridBagConstraints();
		gbok.gridx=0;
		gbok.gridy=10;
		gbok.insets=new Insets(20, 0, 0, 0);
		panel.add(ok,gbok);
		
		GridBagConstraints gbOdustani=new GridBagConstraints();
		gbOdustani.gridx=1;
		gbOdustani.gridy=10;
		gbOdustani.insets=new Insets(20, 0, 0, 0);
		panel.add(odustani,gbOdustani);
		
	}
	
	static public void setTxtFilds() {
		int i =MainFrame.getTabelStudenta().getSelectedRow();
		txtIme.setText(StudenskaSluzba.getInstance().getValueAtStudent(i, 0));
		txtPrezime.setText(StudenskaSluzba.getInstance().getValueAtStudent(i, 1));
		
		ok.removeActionListener(ok.getActionListeners()[0]);
		ok.addActionListener(new ActionListenerPotvrdiEdit());
		
	}
	
	static public String readtxtIme() {
		return txtIme.getText();
	}
	
	static public String readtxtPrezime() {
		return txtPrezime.getText();
	}
	
	static public String readtxtDatumRodjenja() {
		return txtDatumRodjenja.getText();
	}
	
	static public String readtxtAdresaStanovanja() {
		return txtAdresaStanovanja.getText();
	}
	
	static public String readtxtBrojTelefona() {
		return txtBrojTelefona.getText();
	}
	
}
