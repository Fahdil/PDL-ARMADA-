package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JTextField;

public class AccueilORG extends JFrame {

	private JPanel contentPane;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AccueilORG frame = new AccueilORG();
					frame.setVisible(true);
					frame.setResizable(false);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public AccueilORG() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 488, 357);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(224, 255, 255));
		panel.setForeground(new Color(224, 255, 255));
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JButton btnNewButton = new JButton("les d\u00E9parts et arriv\u00E9es");
		btnNewButton.setBackground(new Color(135, 206, 235));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource()==btnNewButton) {
					dispose();
					PlanifierDepardAriver PlanifierDepartAriver = new PlanifierDepardAriver();
					PlanifierDepartAriver.setVisible(true);
				}
			}
		});
		btnNewButton.setBackground(new Color(135, 206, 235));
		btnNewButton.setBounds(255, 117, 173, 23);
		panel.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("attribuer un emplacement");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource()==btnNewButton_1) {
					AttribuerEmplacement AttribuerEmplacement = new AttribuerEmplacement();
					AttribuerEmplacement.setVisible(true);
					dispose();
				}
			}
		});
		btnNewButton_1.setBackground(new Color(135, 206, 235));
		btnNewButton_1.setBounds(255, 168, 173, 23);
		panel.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("attribuer un stand");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource()==btnNewButton_2) {
					dispose();
					AttribuerStand AttribuerStand = new AttribuerStand();
					AttribuerStand.setVisible(true);
				}
			}
		});
		btnNewButton_2.setBackground(new Color(135, 206, 235));
		btnNewButton_2.setBounds(255, 217, 173, 23);
		panel.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Valider une inscription");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource()==btnNewButton_3) {
					Validerinscription  validation = new Validerinscription();
					validation.setVisible(true);
					dispose();
					
				}
			}
		});
		btnNewButton_3.setBackground(new Color(135, 206, 235));
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_3.setBounds(22, 117, 173, 23);
		panel.add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("modifier les information ");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource()==btnNewButton_4) {
					ModifierInfoDuP ModifierInfoDuP  = new ModifierInfoDuP ();
					ModifierInfoDuP.setVisible(true);
					dispose();
					
				}
			}
		});
		btnNewButton_4.setBackground(new Color(135, 206, 235));
		btnNewButton_4.setBounds(22, 168, 173, 23);
		panel.add(btnNewButton_4);
		
		JButton btnNewButton_5 = new JButton("supprimer le participant");
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource()==btnNewButton_5) {
					dispose();
					SupprimerParticipant SupprimerParticipant  = new SupprimerParticipant ();
					SupprimerParticipant.setVisible(true);
				}
			}
		}); 
		btnNewButton_5.setBackground(new Color(135, 206, 235));
		btnNewButton_5.setBounds(22, 217, 173, 23);
		panel.add(btnNewButton_5);
		
		textField_1 = new JTextField();
		textField_1.setText("                ARMADA 2023");
		textField_1.setEditable(false);
		textField_1.setColumns(10);
		textField_1.setBackground(new Color(255, 182, 193));
		textField_1.setBounds(150, 41, 173, 42);
		panel.add(textField_1);
		
		JButton btnNewButton_6 = new JButton("Retour");
		btnNewButton_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource()==btnNewButton_6) {
					dispose();
					Accueil Accueil = new Accueil ();
					Accueil.setVisible(true);
				}
			}
		}); 
		btnNewButton_6.setBackground(new Color(250, 128, 114));
		btnNewButton_6.setBounds(150, 274, 148, 23);
		panel.add(btnNewButton_6);
		
		JButton btnNewButton_7 = new JButton("Ajouter");
		btnNewButton_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AjouterUnOrganisateur ajt = new AjouterUnOrganisateur();
				ajt.setVisible(true);
				dispose();
			}
		});
		btnNewButton_7.setForeground(new Color(0, 0, 0));
		btnNewButton_7.setBounds(364, 0, 98, 23);
		panel.add(btnNewButton_7);
		
		
	}
}
