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

import java.awt.Color;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextField;

public class Entrepriseins extends JFrame  {

	private JPanel contentPane;
	private JTextField nomField;
	private JTextField immaField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Entrepriseins frame = new Entrepriseins();
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
	public Entrepriseins() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(224, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Nom");
		lblNewLabel.setBounds(31, 67, 66, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblImma = new JLabel("Immatriculation");
		lblImma.setBounds(31, 129, 89, 14);
		contentPane.add(lblImma);
		
		JButton btnNewButton_1 = new JButton("Retour");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				InscriptionDAO condao = new InscriptionDAO();
				  // condao.delectpartdurantinscription();
				  // condao.delectpmdurantinscription();
				    Partcipantins Partcipantins=new Partcipantins();
				    Partcipantins.setVisible(true);
					dispose();
			}		
		});
		
		btnNewButton_1.setBackground(new Color(135, 206, 250));
		btnNewButton_1.setBounds(79, 192, 93, 22);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_1_1 = new JButton("Valider");
		btnNewButton_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource()==btnNewButton_1_1 && nomField.getText().isEmpty()==false && immaField.getText().isEmpty()==false) {
					InscriptionDAO condao = new InscriptionDAO();
					Entreprise entreprise = new Entreprise(nomField.getText(),immaField.getText());
					condao.updateent(entreprise);
					Felicitation felicitation=new Felicitation();
					felicitation.setVisible(true);
					dispose();
					
				}
			}
		});
		btnNewButton_1_1.setBackground(new Color(135, 206, 250));
		btnNewButton_1_1.setBounds(273, 192, 93, 22);
		contentPane.add(btnNewButton_1_1);
		
		nomField = new JTextField();
		nomField.setBounds(255, 64, 137, 20);
		contentPane.add(nomField);
		nomField.setColumns(10);
		
		immaField = new JTextField();
		immaField.setColumns(10);
		immaField.setBounds(255, 126, 137, 20);
		contentPane.add(immaField);
		
		
	}
}
