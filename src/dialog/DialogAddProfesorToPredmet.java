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

import actionListener.ActionListenerAddProfesorOnPredmet;
import actionListener.ActionListenerPotvrdiAddProfesoraOnPredmet;

public class DialogAddProfesorToPredmet extends JDialog{

	private static final long serialVersionUID = 5411149443296880822L;
	static private JTextField txtBrLicneKarte;
	static private JButton ok;
	
	private static DialogAddProfesorToPredmet instance=null;
	
	static public DialogAddProfesorToPredmet getInstance() {
		if(instance==null) {
			instance=new DialogAddProfesorToPredmet();
		}
		return instance;
	}
	
	public static void removeInstance() {
		instance=null;
	}
	
	private DialogAddProfesorToPredmet() {}

	public void call(Frame parent, String title, boolean modal) {
		this.setLocationRelativeTo(parent);
		this.setTitle(title);
		this.setModal(modal);
		setSize(350,200);
		
		setLayout(new BorderLayout());
		JPanel p=new JPanel();
		GridBagLayout g=new GridBagLayout();
		setResizable(false);
		
		g.preferredLayoutSize(p);
		p.setLayout(g);
		add(p,BorderLayout.CENTER);
		
		JLabel lblsifra=new JLabel("Broj licne karte:");
		lblsifra.setFont(new Font("Broj licne karte:",Font.PLAIN,18));
		
		txtBrLicneKarte=new JTextField();
		txtBrLicneKarte.setPreferredSize(new Dimension(160,25));
		
		GridBagConstraints gbLbl=new GridBagConstraints();
		gbLbl.gridx=0;
		gbLbl.gridy=0;
		//gbLbl.anchor=GridBagConstraints.NORTH;
		//gbLbl.gridheight=100;
		gbLbl.insets=new Insets(15, 0, 50, 0);
		gbLbl.anchor=GridBagConstraints.CENTER;
		p.add(lblsifra,gbLbl);
		
		GridBagConstraints gbTxt=new GridBagConstraints();
		gbTxt.gridx=1;
		gbTxt.gridy=0;
		//gbTxt.anchor=GridBagConstraints.NORTH;
		//gbTxt.gridheight=100;
		gbTxt.insets=new Insets(15, 5, 50, 0);
		//gbTxt.anchor=GridBagConstraints.CENTER;
		p.add(txtBrLicneKarte,gbTxt);
		
		ok=new JButton("POTVRDA");
		ok.addActionListener(new ActionListenerPotvrdiAddProfesoraOnPredmet());
//		ok.addFocusListener(l);
		JButton odustani=new JButton("ODUSTANI");
		odustani.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				removeInstance();
				
			}
		});
		
		GridBagConstraints gbok=new GridBagConstraints();
		gbok.gridx=0;
		gbok.gridy=1;
		gbok.insets=new Insets(0, 0, 10, 0);
		p.add(ok,gbok);
		
		GridBagConstraints gbOdustani=new GridBagConstraints();
		gbOdustani.gridx=1;
		gbOdustani.gridy=1;
		gbOdustani.insets=new Insets(0, 0, 10, 0);
		p.add(odustani,gbOdustani);
		
		//DialogoAddProfesorToPredmet.getInstance().setVisible(true);
		setVisible(true);
	}
	
	static public String readtxt() {
		return txtBrLicneKarte.getText();
	}
	
	
}
