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

import dao.InscriptionDAO;
import model.Entreprise;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JButton;

public class FamilleDaccins extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FamilleDaccins frame = new FamilleDaccins();
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
	public FamilleDaccins() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(224, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(54, 87, 59, -25);
		contentPane.add(panel);
		
		JLabel lblNewLabel = new JLabel("Nom");
		lblNewLabel.setBounds(22, 57, 59, 19);
		contentPane.add(lblNewLabel);
		
		JLabel lblAdresse = new JLabel("Adresse");
		lblAdresse.setBounds(22, 87, 59, 19);
		contentPane.add(lblAdresse);
		
		JLabel lblNombreDePlace = new JLabel("Nombre de place");
		lblNombreDePlace.setBounds(22, 117, 91, 19);
		contentPane.add(lblNombreDePlace);
		
		JTextArea nomFamilleins = new JTextArea();
		nomFamilleins.setBounds(219, 54, 161, 22);
		contentPane.add(nomFamilleins);
		
		JTextArea addressFamins = new JTextArea();
		addressFamins.setBounds(219, 87, 161, 22);
		contentPane.add(addressFamins);
		
		JTextArea nombreplacins = new JTextArea();
		nombreplacins.setBounds(219, 114, 161, 22);
		contentPane.add(nombreplacins);
		
		JButton btnNewButton_1 = new JButton("Retour");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource()==btnNewButton_1) {
					
					Partcipantins Partcipantins=new Partcipantins();
					Partcipantins.setVisible(true);
					dispose();
				}
			}
		});
		btnNewButton_1.setBackground(new Color(135, 206, 250));
		btnNewButton_1.setBounds(82, 189, 93, 22);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_1_1 = new JButton("Valider");
		btnNewButton_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource()==btnNewButton_1_1 && nomFamilleins.getText() .isEmpty()==false && addressFamins.getText().isEmpty()==false && addressFamins.getText() .isEmpty()==false) {
					InscriptionDAO condao = new InscriptionDAO();
					FamilleAcc familleAcc = new FamilleAcc (1,nomFamilleins.getText() , addressFamins.getText(), Integer.valueOf(nombreplacins.getText()));
					condao.updatfam(familleAcc);
					Felicitation felicitation=new Felicitation();
					felicitation.setVisible(true);
					dispose();
				}
			}
		});
		btnNewButton_1_1.setBackground(new Color(135, 206, 250));
		btnNewButton_1_1.setBounds(256, 189, 93, 22);
		contentPane.add(btnNewButton_1_1);
	}

}
