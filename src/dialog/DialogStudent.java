package dialog;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Frame;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import ActionListener.ActionListenerPotvrdiAdd;
import ActionListener.ActionListenerPotvrdiEdit;
import model.StudenskaSluzba;
import pogled.MainFrame;

public class DialogStudent extends JDialog {
	
	static private JTextField txtIme;
	static private JTextField txtPrezime;
	static private JTextField txtDatumRodjenja;
	static private JTextField txtAdresaStanovanja;
	static private JTextField txtBrojTelefona;
	static private JTextField txtBrojIndeksa;
	static private JButton ok;
	
 private static DialogStudent instance =null;
	
	public static DialogStudent getInstance() {
		if(instance==null) {
			instance=new DialogStudent();
		}
		return instance;
	}
	public static void removeInstance() {
		instance=null;
	}
	private DialogStudent(){
		instance=new DialogStudent();
	}
	
	public DialogStudent(Frame parent, String title, boolean modal) {
		super(parent, title, modal);
		instance=this;
		setSize(470,450);
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
		JLabel lblBrojIndeksa=new JLabel("Broj indeksa:");
		lblBrojIndeksa.setFont(new Font("Broj indeksa:",Font.PLAIN,18));
		JLabel lblTrenutnaGodinaStudija=new JLabel("Trenutna godina studija:");
		lblTrenutnaGodinaStudija.setFont(new Font("Trenutna godina studija:",Font.PLAIN,18));
		String[] godinaStudija = { " I(prva)"," II(druga)"," III(treca)"," IV(cetvrta)"};
	    final JComboBox<String> cb = new JComboBox<String>(godinaStudija);
	    cb.setVisible(true);
		JRadioButton budzet = new JRadioButton("Budzet");
		budzet.setFont(new Font("Budzet:",Font.PLAIN,18));
		JRadioButton samofinansiranje = new JRadioButton("Samofinansiranje");
		samofinansiranje.setFont(new Font("Samofinansiranje:",Font.PLAIN,18));
		// grupa regulise da samo jedan RadioButton može biti èekiran
		ButtonGroup status = new ButtonGroup();
		status.add(budzet);
		status.add(samofinansiranje);
		
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
		txtBrojIndeksa=new JTextField();
		txtBrojIndeksa.setPreferredSize(new Dimension(250,25));
		
		GridBagConstraints gblblIme=new GridBagConstraints();
		gblblIme.gridx=0;
		gblblIme.gridy=0;
		gblblIme.insets=new Insets(0, 0, 10, 0);
		gblblIme.anchor=GridBagConstraints.CENTER;
		panel.add(lblIme,gblblIme);
		GridBagConstraints gbtxtIme=new GridBagConstraints();
		gbtxtIme.gridx=1;
		gbtxtIme.gridy=0;
		gbtxtIme.insets=new Insets(0, 0, 10, 0);
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
		gblblDatumRodjenja.insets=new Insets(10, 0, 10, 0);
		gblblDatumRodjenja.anchor=GridBagConstraints.CENTER;
		panel.add(lblDatumRodjenja,gblblDatumRodjenja);
		GridBagConstraints gbtxtDatumRodjenja=new GridBagConstraints();
		gbtxtDatumRodjenja.gridx=1;
		gbtxtDatumRodjenja.gridy=2;
		gbtxtDatumRodjenja.insets=new Insets(10, 0, 10, 0);
		gbtxtDatumRodjenja.anchor=GridBagConstraints.WEST;
		gbtxtDatumRodjenja.weightx=100;
		panel.add(txtDatumRodjenja,gbtxtDatumRodjenja);
		
		GridBagConstraints gblblAdresaStanovanja=new GridBagConstraints();
		gblblAdresaStanovanja.gridx=0;
		gblblAdresaStanovanja.gridy=3;
		gblblAdresaStanovanja.insets=new Insets(10, 0, 10, 0);
		gblblAdresaStanovanja.anchor=GridBagConstraints.CENTER;
		panel.add(lblAdresaStanovanja,gblblAdresaStanovanja);
		GridBagConstraints gbtxtAdresaStanovanja=new GridBagConstraints();
		gbtxtAdresaStanovanja.gridx=1;
		gbtxtAdresaStanovanja.gridy=3;
		gbtxtAdresaStanovanja.insets=new Insets(10, 0, 10, 0);
		gbtxtAdresaStanovanja.anchor=GridBagConstraints.WEST;
		gbtxtAdresaStanovanja.weightx=100;
		panel.add(txtAdresaStanovanja,gbtxtAdresaStanovanja);
		
		GridBagConstraints gblblBrojTelefona=new GridBagConstraints();
		gblblBrojTelefona.gridx=0;
		gblblBrojTelefona.gridy=4;
		gblblBrojTelefona.insets=new Insets(10, 0, 10, 0);
		gblblBrojTelefona.anchor=GridBagConstraints.CENTER;
		panel.add(lblBrojTelefona,gblblBrojTelefona);
		GridBagConstraints gbtxtBrojTelefona=new GridBagConstraints();
		gbtxtBrojTelefona.gridx=1;
		gbtxtBrojTelefona.gridy=4;
		gbtxtBrojTelefona.insets=new Insets(10, 0, 10, 0);
		gbtxtBrojTelefona.anchor=GridBagConstraints.WEST;
		gbtxtBrojTelefona.weightx=100;
		panel.add(txtBrojTelefona,gbtxtBrojTelefona);
		
		GridBagConstraints gblblBrojIndeksa=new GridBagConstraints();
		gblblBrojIndeksa.gridx=0;
		gblblBrojIndeksa.gridy=5;
		gblblBrojIndeksa.insets=new Insets(10, 0, 10, 0);
		gblblBrojIndeksa.anchor=GridBagConstraints.CENTER;
		panel.add(lblBrojIndeksa,gblblBrojIndeksa);
		GridBagConstraints gbtxtBrojIndeksa=new GridBagConstraints();
		gbtxtBrojIndeksa.gridx=1;
		gbtxtBrojIndeksa.gridy=5;
		gbtxtBrojIndeksa.insets=new Insets(10, 0, 10, 0);
		gbtxtBrojIndeksa.anchor=GridBagConstraints.WEST;
		gbtxtBrojIndeksa.weightx=100;
		panel.add(txtBrojIndeksa,gbtxtBrojIndeksa);
		
		GridBagConstraints gblblTrenutnaGodinaStudija=new GridBagConstraints();
		gblblTrenutnaGodinaStudija.gridx=0;
		gblblTrenutnaGodinaStudija.gridy=6;
		gblblTrenutnaGodinaStudija.insets=new Insets(10, 0, 10, 0);
		gblblTrenutnaGodinaStudija.anchor=GridBagConstraints.CENTER;
		panel.add(lblTrenutnaGodinaStudija,gblblTrenutnaGodinaStudija);
		GridBagConstraints gbtxtcb=new GridBagConstraints();
		gbtxtcb.gridx=1;
		gbtxtcb.gridy=6;
		gbtxtcb.insets=new Insets(10, 5, 10, 0);
		gbtxtcb.anchor=GridBagConstraints.CENTER;
		panel.add(cb,gbtxtcb);
		
		GridBagConstraints gbBudzet=new GridBagConstraints();
		gbBudzet.gridx=0;
		gbBudzet.gridy=7;
		gbBudzet.insets=new Insets(0, 0, 10, 0);
		panel.add(budzet,gbBudzet);
		
		GridBagConstraints gbSamofinansiranje=new GridBagConstraints();
		gbSamofinansiranje.gridx=1;
		gbSamofinansiranje.gridy=7;
		gbSamofinansiranje.insets=new Insets(0, 0, 10, 0);
		panel.add(samofinansiranje,gbSamofinansiranje);
	
		
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
		gbok.insets=new Insets(15, 0, 0, 0);
		panel.add(ok,gbok);
		
		
		GridBagConstraints gbOdustani=new GridBagConstraints();
		gbOdustani.gridx=1;
		gbOdustani.gridy=10;
		gbOdustani.insets=new Insets(15, 0, 0, 0);
		panel.add(odustani,gbOdustani);
		
	}
	
	static public void setTxtFilds() {
		int i =MainFrame.getTabel().getSelectedRow();
		txtBrojIndeksa.setText(StudenskaSluzba.getInstance().getValueAtStudent(i, 0));
		txtIme.setText(StudenskaSluzba.getInstance().getValueAtStudent(i, 1));
		txtPrezime.setText(StudenskaSluzba.getInstance().getValueAtStudent(i, 2));
		
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
	
	static public String readtxtBrojIndeksa() {
		return txtBrojIndeksa.getText();
	}

}
