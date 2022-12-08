package gui;
import dao.*;
import model.*;
import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import model.Entreprise;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.JTextField;

public class FamilleDaccins2 extends JFrame { 

	private JPanel contentPane;
	private JTextField nomFamilleins;
	private JTextField addressFamins;
	private JTextField nombreplacins;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FamilleDaccins2 frame = new FamilleDaccins2();
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
	public FamilleDaccins2() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(224, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel message = new JLabel("Modifications enregistr\u00E9es avec succ\u00E8s ");
		message.setForeground(new Color(255, 0, 0));
		message.setBounds(104, 22, 294, 14);
		contentPane.add(message);
		message.setVisible(false);
		
		
		JPanel panel = new JPanel();
		panel.setBounds(54, 87, 59, -25);
		contentPane.add(panel);
		
		JLabel lblNewLabel = new JLabel("Nom");
		lblNewLabel.setBounds(22, 73, 59, 19);
		contentPane.add(lblNewLabel);
		
		JLabel lblAdresse = new JLabel("Adresse");
		lblAdresse.setBounds(22, 111, 59, 19);
		contentPane.add(lblAdresse);
		
		JLabel lblNombreDePlace = new JLabel("Nombre de place");
		lblNombreDePlace.setBounds(22, 153, 91, 19);
		contentPane.add(lblNombreDePlace);
		
		JButton btnNewButton_1 = new JButton("Retour");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource()==btnNewButton_1) {
					AccueilDesParticipants retour=new AccueilDesParticipants();
					retour.setVisible(true);
					dispose();
				}
			}
		});
		btnNewButton_1.setBackground(new Color(135, 206, 250));
		btnNewButton_1.setBounds(69, 216, 93, 22);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_1_1 = new JButton("Valider");
		btnNewButton_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource()==btnNewButton_1_1 && nomFamilleins.getText() .isEmpty()==false && addressFamins.getText() .isEmpty()==false && addressFamins.getText() .isEmpty()==false) {
					ConDAO condao = new ConDAO();
					FamilleAcc familleAcc = new FamilleAcc (1,nomFamilleins.getText() , addressFamins.getText(), Integer.valueOf(nombreplacins.getText()));
					condao.updatfam(familleAcc);
					message.setVisible(true);
				}
			}
		});
		btnNewButton_1_1.setBackground(new Color(135, 206, 250));
		btnNewButton_1_1.setBounds(258, 216, 93, 22);
		contentPane.add(btnNewButton_1_1);
		
		nomFamilleins = new JTextField();
		nomFamilleins.setBounds(219, 72, 161, 20);
		contentPane.add(nomFamilleins);
		nomFamilleins.setColumns(10);
		
		addressFamins = new JTextField();
		addressFamins.setBounds(219, 110, 161, 20);
		contentPane.add(addressFamins);
		addressFamins.setColumns(10);
		
		nombreplacins = new JTextField();
		nombreplacins.setBounds(219, 152, 161, 20);
		contentPane.add(nombreplacins);
		nombreplacins.setColumns(10);
	}

}
