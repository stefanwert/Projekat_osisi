package dialog;

import java.awt.BorderLayout;import java.awt.BufferCapabilities;
import java.awt.Button;
import java.awt.Color;
import java.awt.Dialog;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Frame;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.LayoutManager;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import ActionListener.ActionListenerPotvrdiAdd;
import model.StudenskaSluzba;

public class AddDialogPredmet extends JDialog {

	private static final long serialVersionUID = -4938172737691424918L;
	static private JTextField txtsifra;
	static private JTextField txtNazivPr;
	static private JTextField txtSemestar;
	static private JTextField txtGodinaStudjia;
	
	private static AddDialogPredmet instance =null;
	
	public static AddDialogPredmet getInstance() {
		if(instance==null) {
			instance=new AddDialogPredmet();
		}
		return instance;
	}
	public static void removeInstance() {
		instance=null;
	}
	private AddDialogPredmet(){
		instance=new AddDialogPredmet();
	}
	
	public AddDialogPredmet(Frame parent, String title, boolean modal) {
		super(parent, title, modal);
		instance=this;
		setSize(350,350);
		setLocationRelativeTo(parent);
		
		setLayout(new BorderLayout());
		JPanel p=new JPanel();
		GridBagLayout g=new GridBagLayout();
		setResizable(false);
		
		g.preferredLayoutSize(p);
		p.setLayout(g);
		add(p,BorderLayout.CENTER);
		
		JLabel lblsifra=new JLabel("SIFRA:");
		lblsifra.setFont(new Font("SIFRA:",Font.PLAIN,18));
		JLabel lblNazivPr=new JLabel("NAZIV PREDMETA:");
		lblNazivPr.setFont(new Font("NAZIV PREDMETA:",Font.PLAIN,18));
		JLabel lblSemestar=new JLabel("SEMESTAR:");
		lblSemestar.setFont(new Font("SEMESTAR:",Font.PLAIN,18));
		JLabel lblGodinsaStudija=new JLabel("GODINA STUDIJA:");
		lblGodinsaStudija.setFont(new Font("GODINA STUDIJA:",Font.PLAIN,18));
		
		txtsifra=new JTextField();
		txtsifra.setPreferredSize(new Dimension(160,25));
		
		txtNazivPr=new JTextField();
		txtNazivPr.setPreferredSize(new Dimension(160,25));
		
		txtSemestar=new JTextField();
		txtSemestar.setPreferredSize(new Dimension(160,25));
		
		txtGodinaStudjia=new JTextField();
		txtGodinaStudjia.setPreferredSize(new Dimension(160,25));
		
		GridBagConstraints gblblsifra=new GridBagConstraints();
		gblblsifra.gridx=0;
		gblblsifra.gridy=0;
		gblblsifra.insets=new Insets(15, 0, 10, 0);
		gblblsifra.anchor=GridBagConstraints.CENTER;
		//gblblsifra.insets=new Insets(20, 0, 0, 0);
		p.add(lblsifra,gblblsifra);
		GridBagConstraints gbtxtsifr=new GridBagConstraints();
		gbtxtsifr.gridx=1;
		gbtxtsifr.gridy=0;
		gbtxtsifr.insets=new Insets(15, 5, 10, 0);
		gbtxtsifr.anchor=GridBagConstraints.CENTER;
		//gbtxtsifr.weightx=100;
		//gbtxtsifr.weighty=100;
		//gblblsifra.insets=new Insets(20, 0, 0, 0);
		p.add(txtsifra,gbtxtsifr);
		
		GridBagConstraints gbNazivPr=new GridBagConstraints();
		gbNazivPr.gridx=0;
		gbNazivPr.gridy=1;
		gbNazivPr.insets=new Insets(0, 0, 10, 0);
		gbNazivPr.anchor=GridBagConstraints.CENTER;
		//gbNazivPr.weightx=1;
		//gbNazivPr.weighty=1;
		p.add(lblNazivPr,gbNazivPr);
		
		GridBagConstraints gbtxtNazivPr=new GridBagConstraints();
		gbtxtNazivPr.gridx=1;
		gbtxtNazivPr.gridy=1;
		gbtxtNazivPr.insets=new Insets(0, 5, 10, 0);
		p.add(txtNazivPr,gbtxtNazivPr);
		
		GridBagConstraints gblblSemestar=new GridBagConstraints();
		gblblSemestar.gridx=0;
		gblblSemestar.gridy=2;
		gblblSemestar.insets=new Insets(0, 0, 10, 0);
		gblblSemestar.anchor=GridBagConstraints.CENTER;
		p.add(lblSemestar,gblblSemestar);
		
		GridBagConstraints gbtxtSemestar=new GridBagConstraints();
		gbtxtSemestar.gridx=1;
		gbtxtSemestar.gridy=2;
		gbtxtSemestar.insets=new Insets(0, 5, 10, 0);
		p.add(txtSemestar,gbtxtSemestar);
		
		GridBagConstraints gblblGodinsaStudija=new GridBagConstraints();
		gblblGodinsaStudija.gridx=0;
		gblblGodinsaStudija.gridy=3;
		gblblGodinsaStudija.anchor=GridBagConstraints.CENTER;
		p.add(lblGodinsaStudija,gblblGodinsaStudija);
		
		GridBagConstraints gbtxtGodinaStudjia=new GridBagConstraints();
		gbtxtGodinaStudjia.gridx=1;
		gbtxtGodinaStudjia.gridy=3;
		gbtxtGodinaStudjia.insets=new Insets(0, 5, 0, 0);
		p.add(txtGodinaStudjia,gbtxtGodinaStudjia);
		
		JButton ok=new JButton("POTVRDA");
		ok.addActionListener(new ActionListenerPotvrdiAdd());
		JButton odustani=new JButton("ODUSTANI");
		JPanel btnPanel=new JPanel();
		btnPanel.add(ok,BorderLayout.EAST);
		btnPanel.add(odustani,BorderLayout.WEST);
		
		GridBagConstraints empty=new GridBagConstraints();
		empty.gridheight=5;
		empty.gridwidth=5;
		empty.weightx=5;
		empty.weighty=5;
		p.add(new JPanel(),empty);
		
		
		GridBagConstraints gbok=new GridBagConstraints();
		gbok.gridx=0;
		gbok.gridy=10;
		gbok.insets=new Insets(0, 0, 10, 0);
		p.add(ok,gbok);
		
		
		GridBagConstraints gbOdustani=new GridBagConstraints();
		gbOdustani.gridx=1;
		gbOdustani.gridy=10;
		gbOdustani.insets=new Insets(0, 0, 10, 0);
		p.add(odustani,gbOdustani);
	}
	static  public String readtxtsifra() {
		return txtsifra.getText();
	}
	
	static  public String readtxtNazivPr() {
		return txtNazivPr.getText();
	}
	
	static  public String readtxtSemestar() {
		return txtSemestar.getText();
	}
	
	static  public String readtxtGodinaStudjia() {
		return txtGodinaStudjia.getText();
	}
}
