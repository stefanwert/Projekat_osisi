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
import java.util.regex.Pattern;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import actionListener.ActionListenerPotvrdiAddStudent;
import actionListener.FocusListenerForDateInput;
import actionListener.FocusListenerForPotvrdiAddOrEdit;
import actionListener.KeyListenerForDouble;
import model.StudenskaSluzba;
import model.Student;
import pogled.MainFrame;

public class DialogStudent extends JDialog {
	
	static private JTextField txtIme;
	static private JTextField txtPrezime;
	static private JTextField txtDatumRodjenja;
	static private JTextField txtAdresaStanovanja;
	static private JTextField txtBrojTelefona;
	static private JTextField txtBrojIndeksa;
	static private JTextField txtProsecnaOcena;
	static private JComboBox<String> cb;
	static public JRadioButton budzet;
	static public JRadioButton samofinansiranje;
	static private ButtonGroup status;
	static private JButton ok;
	
 private static DialogStudent instance =null;
	
	static public DialogStudent getInstance() {
		if(instance==null) {
			instance=new DialogStudent();
		}
		return instance;
	}
	public static void removeInstance() {
		instance=null;
	}
	private DialogStudent(){
	}
	
	public void call(Frame parent, String title, boolean modal) {
		this.setLocationRelativeTo(parent);
		this.setTitle(title);
		this.setModal(modal);
		
		
		
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
		JLabel lblProsecnaOcena=new JLabel("Prosecna ocena:");
		lblProsecnaOcena.setFont(new Font("Prosecna ocena:",Font.PLAIN,18));
		JLabel lblTrenutnaGodinaStudija=new JLabel("Trenutna godina studija:");
		lblTrenutnaGodinaStudija.setFont(new Font("Trenutna godina studija:",Font.PLAIN,18));
		
		String[] godinaStudija = { " I(prva)"," II(druga)"," III(treca)"," IV(cetvrta)"};
	    cb = new JComboBox<String>(godinaStudija);
	    cb.setVisible(true);
	    
		budzet = new JRadioButton("Budzet");
		budzet.setFont(new Font("Budzet:",Font.PLAIN,18));
		budzet.setActionCommand( budzet.getText() );
		samofinansiranje = new JRadioButton("Samofinansiranje");
		samofinansiranje.setFont(new Font("Samofinansiranje:",Font.PLAIN,18));
		samofinansiranje.setActionCommand( samofinansiranje.getText() );
		// grupa regulise da samo jedan RadioButton može biti èekiran
		status = new ButtonGroup();
		status.add(budzet);
		status.add(samofinansiranje);
		
		txtIme=new JTextField();
		txtIme.setPreferredSize(new Dimension(250,25));
		txtPrezime=new JTextField();
		txtPrezime.setPreferredSize(new Dimension(250,25));
		txtDatumRodjenja=new JTextField();
		txtDatumRodjenja.setPreferredSize(new Dimension(250,25));
		txtDatumRodjenja.addFocusListener(new FocusListenerForDateInput());
		txtAdresaStanovanja=new JTextField();
		txtAdresaStanovanja.setPreferredSize(new Dimension(250,25));
		txtBrojTelefona=new JTextField();
		txtBrojTelefona.setPreferredSize(new Dimension(250,25));
		txtBrojIndeksa=new JTextField();
		txtBrojIndeksa.setPreferredSize(new Dimension(250,25));
		txtProsecnaOcena=new JTextField();
		txtProsecnaOcena.setPreferredSize(new Dimension(250,25));
		txtProsecnaOcena.addKeyListener(new KeyListenerForDouble());
		
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
		
		GridBagConstraints gblblBrojIndeksa=new GridBagConstraints();
		gblblBrojIndeksa.gridx=0;
		gblblBrojIndeksa.gridy=5;
		gblblBrojIndeksa.insets=new Insets(10, 0, 5, 0);
		gblblBrojIndeksa.anchor=GridBagConstraints.CENTER;
		panel.add(lblBrojIndeksa,gblblBrojIndeksa);
		GridBagConstraints gbtxtBrojIndeksa=new GridBagConstraints();
		gbtxtBrojIndeksa.gridx=1;
		gbtxtBrojIndeksa.gridy=5;
		gbtxtBrojIndeksa.insets=new Insets(10, 0, 5, 0);
		gbtxtBrojIndeksa.anchor=GridBagConstraints.WEST;
		gbtxtBrojIndeksa.weightx=100;
		panel.add(txtBrojIndeksa,gbtxtBrojIndeksa);
		
		GridBagConstraints gblblProsecnaOcena=new GridBagConstraints();
		gblblProsecnaOcena.gridx=0;
		gblblProsecnaOcena.gridy=6;
		gblblProsecnaOcena.insets=new Insets(10, 0, 5, 0);
		gblblProsecnaOcena.anchor=GridBagConstraints.CENTER;
		panel.add(lblProsecnaOcena,gblblProsecnaOcena);
		GridBagConstraints gbtxtProsecnaOcena=new GridBagConstraints();
		gbtxtProsecnaOcena.gridx=1;
		gbtxtProsecnaOcena.gridy=6;
		gbtxtProsecnaOcena.insets=new Insets(10, 0, 5, 0);
		gbtxtProsecnaOcena.anchor=GridBagConstraints.WEST;
		gbtxtProsecnaOcena.weightx=100;
		panel.add(txtProsecnaOcena,gbtxtProsecnaOcena);
		
		GridBagConstraints gblblTrenutnaGodinaStudija=new GridBagConstraints();
		gblblTrenutnaGodinaStudija.gridx=0;
		gblblTrenutnaGodinaStudija.gridy=7;
		gblblTrenutnaGodinaStudija.insets=new Insets(10, 10, 5, 0);
		gblblTrenutnaGodinaStudija.anchor=GridBagConstraints.CENTER;
		panel.add(lblTrenutnaGodinaStudija,gblblTrenutnaGodinaStudija);
		GridBagConstraints gbtxtcb=new GridBagConstraints();
		gbtxtcb.gridx=1;
		gbtxtcb.gridy=7;
		gbtxtcb.insets=new Insets(10, 5, 5, 0);
		gbtxtcb.anchor=GridBagConstraints.CENTER;
		panel.add(cb,gbtxtcb);
		
		GridBagConstraints gbBudzet=new GridBagConstraints();
		gbBudzet.gridx=0;
		gbBudzet.gridy=8;
		gbBudzet.insets=new Insets(10, 0, 5, 0);
		panel.add(budzet,gbBudzet);
		
		GridBagConstraints gbSamofinansiranje=new GridBagConstraints();
		gbSamofinansiranje.gridx=1;
		gbSamofinansiranje.gridy=8;
		gbSamofinansiranje.insets=new Insets(10, 0, 5, 0);
		panel.add(samofinansiranje,gbSamofinansiranje);
	
		
		ok=new JButton("Potvrda");
		ok.addActionListener(new ActionListenerPotvrdiAddStudent()); 
		ok.addFocusListener(new FocusListenerForPotvrdiAddOrEdit());
		JButton odustani=new JButton("Odustani");
		odustani.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				DialogStudent.getInstance().dispose();
				DialogStudent.getInstance().removeInstance();
			}
		});
//		JPanel btnPanel=new JPanel();
//		btnPanel.add(ok,BorderLayout.EAST);
//		btnPanel.add(odustani,BorderLayout.WEST);
			
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
		
		if(title.equals("Izmeni studenta")) {
			this.setTxtFilds();
		}else {
			//ovde samo obrisi txt pre unosa 
		}
		DialogStudent.getInstance().setVisible(true);
	}
	
	/*public DialogStudent(Frame parent, String title, boolean modal) {
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
		JLabel lblProsecnaOcena=new JLabel("Prosecna ocena:");
		lblProsecnaOcena.setFont(new Font("Prosecna ocena:",Font.PLAIN,18));
		JLabel lblTrenutnaGodinaStudija=new JLabel("Trenutna godina studija:");
		lblTrenutnaGodinaStudija.setFont(new Font("Trenutna godina studija:",Font.PLAIN,18));
		
		String[] godinaStudija = { " I(prva)"," II(druga)"," III(treca)"," IV(cetvrta)"};
	    cb = new JComboBox<String>(godinaStudija);
	    cb.setVisible(true);
	    
		JRadioButton budzet = new JRadioButton("Budzet");
		budzet.setFont(new Font("Budzet:",Font.PLAIN,18));
		budzet.setActionCommand( budzet.getText() );
		JRadioButton samofinansiranje = new JRadioButton("Samofinansiranje");
		samofinansiranje.setFont(new Font("Samofinansiranje:",Font.PLAIN,18));
		samofinansiranje.setActionCommand( samofinansiranje.getText() );
		// grupa regulise da samo jedan RadioButton može biti èekiran
		status = new ButtonGroup();
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
		txtProsecnaOcena=new JTextField();
		txtProsecnaOcena.setPreferredSize(new Dimension(250,25));
		
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
		
		GridBagConstraints gblblBrojIndeksa=new GridBagConstraints();
		gblblBrojIndeksa.gridx=0;
		gblblBrojIndeksa.gridy=5;
		gblblBrojIndeksa.insets=new Insets(10, 0, 5, 0);
		gblblBrojIndeksa.anchor=GridBagConstraints.CENTER;
		panel.add(lblBrojIndeksa,gblblBrojIndeksa);
		GridBagConstraints gbtxtBrojIndeksa=new GridBagConstraints();
		gbtxtBrojIndeksa.gridx=1;
		gbtxtBrojIndeksa.gridy=5;
		gbtxtBrojIndeksa.insets=new Insets(10, 0, 5, 0);
		gbtxtBrojIndeksa.anchor=GridBagConstraints.WEST;
		gbtxtBrojIndeksa.weightx=100;
		panel.add(txtBrojIndeksa,gbtxtBrojIndeksa);
		
		GridBagConstraints gblblProsecnaOcena=new GridBagConstraints();
		gblblProsecnaOcena.gridx=0;
		gblblProsecnaOcena.gridy=6;
		gblblProsecnaOcena.insets=new Insets(10, 0, 5, 0);
		gblblProsecnaOcena.anchor=GridBagConstraints.CENTER;
		panel.add(lblProsecnaOcena,gblblProsecnaOcena);
		GridBagConstraints gbtxtProsecnaOcena=new GridBagConstraints();
		gbtxtProsecnaOcena.gridx=1;
		gbtxtProsecnaOcena.gridy=6;
		gbtxtProsecnaOcena.insets=new Insets(10, 0, 5, 0);
		gbtxtProsecnaOcena.anchor=GridBagConstraints.WEST;
		gbtxtProsecnaOcena.weightx=100;
		panel.add(txtProsecnaOcena,gbtxtProsecnaOcena);
		
		GridBagConstraints gblblTrenutnaGodinaStudija=new GridBagConstraints();
		gblblTrenutnaGodinaStudija.gridx=0;
		gblblTrenutnaGodinaStudija.gridy=7;
		gblblTrenutnaGodinaStudija.insets=new Insets(10, 10, 5, 0);
		gblblTrenutnaGodinaStudija.anchor=GridBagConstraints.CENTER;
		panel.add(lblTrenutnaGodinaStudija,gblblTrenutnaGodinaStudija);
		GridBagConstraints gbtxtcb=new GridBagConstraints();
		gbtxtcb.gridx=1;
		gbtxtcb.gridy=7;
		gbtxtcb.insets=new Insets(10, 5, 5, 0);
		gbtxtcb.anchor=GridBagConstraints.CENTER;
		panel.add(cb,gbtxtcb);
		
		GridBagConstraints gbBudzet=new GridBagConstraints();
		gbBudzet.gridx=0;
		gbBudzet.gridy=8;
		gbBudzet.insets=new Insets(10, 0, 5, 0);
		panel.add(budzet,gbBudzet);
		
		GridBagConstraints gbSamofinansiranje=new GridBagConstraints();
		gbSamofinansiranje.gridx=1;
		gbSamofinansiranje.gridy=8;
		gbSamofinansiranje.insets=new Insets(10, 0, 5, 0);
		panel.add(samofinansiranje,gbSamofinansiranje);
	
		
		ok=new JButton("Potvrda");
		ok.addActionListener(new ActionListenerPotvrdiAddStudent()); 
		JButton odustani=new JButton("Odustani");
		odustani.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				DialogStudent.getInstance().dispose();
				
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
		
	}*/
	
	static public void setTxtFilds() {
		int i = MainFrame.getInstance().getTabelStudenta().getSelectedRow();
		String s=(String)MainFrame.getInstance().getTabelStudenta().getValueAt(i, 0);
		i=0;
		for (Student student : StudenskaSluzba.getInstance().getListStudenata()) {
			if(s.equals(student.getBrojIndeksa())) {
				break;
			}
			i++;
		}
		
		txtBrojIndeksa.setText(StudenskaSluzba.getInstance().getValueAtStudent(i, 0));
		txtIme.setText(StudenskaSluzba.getInstance().getValueAtStudent(i, 1));
		txtPrezime.setText(StudenskaSluzba.getInstance().getValueAtStudent(i, 2));	
		System.out.println(cb.getSelectedItem());
		//cb.setSelectedItem(anObject);
		//cb.setText(StudenskaSluzba.getInstance().getValueAtStudent(i, 3));
		//status.setText(StudenskaSluzba.getInstance().getValueAtStudent(i, 4));
		txtProsecnaOcena.setText(StudenskaSluzba.getInstance().getValueAtStudent(i, 5));
		txtDatumRodjenja.setText(StudenskaSluzba.getInstance().getValueAtStudent(i, 6));
		txtAdresaStanovanja.setText(StudenskaSluzba.getInstance().getValueAtStudent(i, 7));
		txtBrojTelefona.setText(StudenskaSluzba.getInstance().getValueAtStudent(i, 8));
		ok.removeActionListener(ok.getActionListeners()[0]);
		ok.addActionListener(new ActionListenerPotvrdiAddStudent());
		
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
	
	static public String readtxtProsecnaOcena() {
		return txtProsecnaOcena.getText();
	}
	
	static public JComboBox readtxtComboBox(){
		return cb;
	}
	
	static public ButtonGroup getStatus(){
		return status;
	}
	
	public boolean isTxtFieldsEmpty() {
		boolean ret=false;
		Pattern p=Pattern.compile("\\d{2}\\.\\d{2}\\.\\d{4}");
		if(txtIme.getText().isEmpty() || txtPrezime.getText().isEmpty() || !p.matcher(txtDatumRodjenja.getText()).matches() 
				|| txtAdresaStanovanja.getText().isEmpty() || txtBrojTelefona.getText().isEmpty() || txtBrojIndeksa.getText().isEmpty()) {
			ret=true;
		}
		
		return ret;
	}
}
