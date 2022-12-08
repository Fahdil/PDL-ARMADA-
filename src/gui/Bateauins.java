package gui;
import dao.*;
import model.*;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import dao.InscriptionDAO;
import model.Entreprise;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;

public class Bateauins extends JFrame {

	private JPanel contentPane;
	private JTextField nombatins;
	private JTextField nompavins;
	private JTextField taillepavins;
	private JTextField datedefabri;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Bateauins frame = new Bateauins();
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
	public Bateauins() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 319);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(224, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Nom du bateau");
		lblNewLabel.setBounds(10, 53, 83, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblPavillon = new JLabel("Pavillon");
		lblPavillon.setBounds(10, 93, 83, 14);
		contentPane.add(lblPavillon);
		
		JLabel lblTaille = new JLabel("Taille");
		lblTaille.setBounds(10, 133, 83, 14);
		contentPane.add(lblTaille);
		
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
		btnNewButton_1.setBounds(104, 231, 93, 22);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_1_1 = new JButton("Valider");
		btnNewButton_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if( nombatins.getText().isEmpty()==false && nompavins.getText().isEmpty()==false && taillepavins.getText().isEmpty()==false && datedefabri.getText().isEmpty()==false ){
					InscriptionDAO condao = new InscriptionDAO();
					Plaisancier plaisancier = new Plaisancier(1,"Aucun",nombatins.getText(), nompavins.getText(), "12/12/12", "12/12/12",datedefabri.getText(), Double.valueOf(taillepavins.getText()));
					condao.updatebat(plaisancier);
					Felicitation felicitation=new Felicitation();
					felicitation.setVisible(true);
					dispose();
				}
			}
		});
		btnNewButton_1_1.setBackground(new Color(135, 206, 250));
		btnNewButton_1_1.setBounds(260, 231, 93, 22);
		contentPane.add(btnNewButton_1_1);
		
		
		
		JLabel datefabrication = new JLabel("Date de fabrication");
		datefabrication.setBounds(10, 178, 125, 14);
		contentPane.add(datefabrication);
		
		nombatins = new JTextField();
		nombatins.setBounds(172, 50, 194, 20);
		contentPane.add(nombatins);
		nombatins.setColumns(10);
		
		nompavins = new JTextField();
		nompavins.setBounds(173, 90, 193, 20);
		contentPane.add(nompavins);
		nompavins.setColumns(10);
		
		taillepavins = new JTextField();
		taillepavins.setBounds(173, 130, 193, 20);
		contentPane.add(taillepavins);
		taillepavins.setColumns(10);
		
		datedefabri = new JTextField();
		datedefabri.setBounds(172, 175, 194, 20);
		contentPane.add(datedefabri);
		datedefabri.setColumns(10);
	}

}
