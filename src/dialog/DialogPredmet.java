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
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import actionListener.FocusListenerForPotvrdiAddOrEdit;
import actionListener.KeyListenerForInt;
import actionListenerPredmet.ActionListenerPotvrdiAddPredmet;
import actionListenerPredmet.ActionListenerPotvrdiEditPredmet;
import model.Predmet;
import model.StudenskaSluzba;
import pogled.MainFrame;

public class DialogPredmet extends JDialog {

	private static final long serialVersionUID = -4938172737691424918L;
	static private JTextField txtsifra;
	static private JTextField txtNazivPr;
	static private JTextField txtSemestar;
	static private JTextField txtGodinaStudjia;
	static private JButton ok;
	
	private static DialogPredmet instance =null;
	
	static public DialogPredmet getInstance() {
		if(instance==null) {
			instance=new DialogPredmet();
		}
		return instance;
	}
	public static void removeInstance() {
		instance=null;
	}
	private DialogPredmet(){}
	
	public void call(Frame parent, String title, boolean modal) {
		this.setTitle(title);
		this.setModal(modal);
		
		setSize(400,300);
		this.setLocationRelativeTo(parent);
		addWindowListener(new WindowListener() {
			
			@Override
			public void windowOpened(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void windowIconified(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void windowDeiconified(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void windowDeactivated(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void windowClosing(WindowEvent e) {
				dispose();
				removeInstance();
				
			}
			
			@Override
			public void windowClosed(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void windowActivated(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		
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
		txtSemestar.addKeyListener(new KeyListenerForInt());
		
		txtGodinaStudjia=new JTextField();
		txtGodinaStudjia.setPreferredSize(new Dimension(160,25));
		txtGodinaStudjia.addKeyListener(new KeyListenerForInt());
		
		GridBagConstraints gblblsifra=new GridBagConstraints();
		gblblsifra.gridx=0;
		gblblsifra.gridy=0;
		gblblsifra.insets=new Insets(15, 0, 10, 0);
		gblblsifra.anchor=GridBagConstraints.CENTER;
		p.add(lblsifra,gblblsifra);
		GridBagConstraints gbtxtsifr=new GridBagConstraints();
		gbtxtsifr.gridx=1;
		gbtxtsifr.gridy=0;
		gbtxtsifr.insets=new Insets(15, 5, 10, 0);
		gbtxtsifr.anchor=GridBagConstraints.CENTER;
		p.add(txtsifra,gbtxtsifr);
		
		GridBagConstraints gbNazivPr=new GridBagConstraints();
		gbNazivPr.gridx=0;
		gbNazivPr.gridy=1;
		gbNazivPr.insets=new Insets(0, 0, 10, 0);
		gbNazivPr.anchor=GridBagConstraints.CENTER;
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
		
		ok=new JButton("POTVRDA");
		ok.addActionListener(new ActionListenerPotvrdiAddPredmet());
		ok.addFocusListener(new FocusListenerForPotvrdiAddOrEdit());
		JButton odustani=new JButton("ODUSTANI");
		odustani.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				removeInstance();
			}
		});
	
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
		
		if(title.equals("Izmeni predmet")) {
			setTxtFilds();
		}
		setVisible(true);
	}
	
	static public void setTxtFilds() {
		int i = MainFrame.getInstance().getTabelPredmeta().getSelectedRow();
		String s=(String)MainFrame.getInstance().getTabelPredmeta().getValueAt(i, 0);
		i=0;
		for (Predmet predmet : StudenskaSluzba.getInstance().getListPredmeta()) {
			if(s.equals(predmet.getSifraPredmeta())) {
				break;
			}
			i++;
		}
		txtsifra.setText(StudenskaSluzba.getInstance().getValueAtPredmet(i, 0).toString());
		txtNazivPr.setText(StudenskaSluzba.getInstance().getValueAtPredmet(i, 1).toString());
		txtSemestar.setText(StudenskaSluzba.getInstance().getValueAtPredmet(i, 2).toString());
		txtGodinaStudjia.setText(StudenskaSluzba.getInstance().getValueAtPredmet(i, 3).toString());
		
		ok.removeActionListener(ok.getActionListeners()[0]);
		ActionListenerPotvrdiEditPredmet ls=new ActionListenerPotvrdiEditPredmet();
		ls.getStaraSif(DialogPredmet.getInstance().readtxtsifra());
		ok.addActionListener(ls);	
	}
	
	static public String readtxtsifra() {
		return txtsifra.getText();
	}
	
	static public String readtxtNazivPr() {
		return txtNazivPr.getText();
	}
	
	static public String readtxtSemestar() {
		return txtSemestar.getText();
	}
	
	static public String readtxtGodinaStudjia() {
		return txtGodinaStudjia.getText();
	}
	
	public boolean isTxtFieldsEmpty() {
		boolean ret=false;
		if(txtsifra.getText().isEmpty() || txtNazivPr.getText().isEmpty() || txtGodinaStudjia.getText().isEmpty() || txtSemestar.getText().isEmpty()) {
			ret=true;
		}
		
		return ret;
	}
}
