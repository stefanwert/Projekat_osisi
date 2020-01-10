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

import actionListenerStudent.ActionListenerAddStudentaToPredmet;
import actionListenerStudent.ActionListenerPotvrdiAddStudentaToPredmet;

public class DialogAddStudentToPredmet extends JDialog {

	private static final long serialVersionUID = 5411149443296880822L;
	static private JTextField txtBrojIndeksa;
	static private JButton ok;
	
	private static DialogAddStudentToPredmet instance=null;
	
	static public DialogAddStudentToPredmet getInstance() {
		if(instance==null) {
			instance=new DialogAddStudentToPredmet();
		}
		return instance;
	}
	
	public static void removeInstance() {
		instance=null;
	}
	
	private DialogAddStudentToPredmet() {}

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
		
		JLabel lblBrojIndeksa=new JLabel("Broj indeksa:");
		lblBrojIndeksa.setFont(new Font("Broj indeksa:",Font.PLAIN,18));
		
		txtBrojIndeksa=new JTextField();
		txtBrojIndeksa.setPreferredSize(new Dimension(160,25));
		
		GridBagConstraints gbLblBrojIndeksa=new GridBagConstraints();
		gbLblBrojIndeksa.gridx=0;
		gbLblBrojIndeksa.gridy=0;
		gbLblBrojIndeksa.insets=new Insets(15, 0, 50, 0);
		gbLblBrojIndeksa.anchor=GridBagConstraints.CENTER;
		p.add(lblBrojIndeksa,gbLblBrojIndeksa);
		
		GridBagConstraints gbTxtBrojIndeksa=new GridBagConstraints();
		gbTxtBrojIndeksa.gridx=1;
		gbTxtBrojIndeksa.gridy=0;
		gbTxtBrojIndeksa.insets=new Insets(15, 5, 50, 0);
		p.add(txtBrojIndeksa,gbTxtBrojIndeksa);
		
		ok=new JButton("Potvrda");
		ok.addActionListener(new ActionListenerPotvrdiAddStudentaToPredmet());
		JButton odustani=new JButton("Odustani");
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
		
		setVisible(true);
	}
	
	static public String readtxtBrojIndeksa() {
		return txtBrojIndeksa.getText();
	}
}
