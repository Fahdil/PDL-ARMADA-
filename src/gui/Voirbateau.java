package gui;
import model.*;
import dao.*;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;

public class Voirbateau extends JFrame {

	private JPanel contentPane;
	private JTextField nombateau;
	private JTextField pavillon;
	private JTextField taille;
	private JTextField datefabrication;
	private JTextField datearriver;
	private JTextField datedepart;
	private JTextField emplacement;
	private JLabel lblEmplacement;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Voirbateau frame = new Voirbateau();
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
	public Voirbateau() {
		ConDAO condao = new ConDAO();
		Plaisancier pl =condao.affichevoirpluspl(" ");
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 401);
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
		
		JLabel dateFabrication = new JLabel("Date de fabrication");
		dateFabrication.setBounds(10, 168, 118, 14);
		contentPane.add(dateFabrication);
		
		JButton btnNewButton_1 = new JButton("Retour");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource()==btnNewButton_1) {
					contentPane.setVisible(false);
					ConsulterProfilPM AjouterPartcipant=new ConsulterProfilPM();
					AjouterPartcipant.setVisible(true);
					dispose();
				}
			}
		});
		btnNewButton_1.setBackground(new Color(135, 206, 250));
		btnNewButton_1.setBounds(126, 329, 193, 22);
		contentPane.add(btnNewButton_1);
		
		JLabel arriver = new JLabel("Date d'arriver");
		arriver.setBounds(10, 208, 118, 14);
		contentPane.add(arriver);
		
		JLabel depart = new JLabel("Date de depart");
		depart.setBounds(10, 246, 118, 14);
		contentPane.add(depart);
		
		nombateau = new JTextField();
		nombateau.setEditable(false);
		nombateau.setBounds(189, 47, 183, 20);
		contentPane.add(nombateau);
		nombateau.setColumns(10);
		nombateau.setText(pl.getNombt());
		
		pavillon = new JTextField();
		pavillon.setEditable(false);
		pavillon.setColumns(10);
		pavillon.setBounds(189, 90, 183, 20);
		contentPane.add(pavillon);
		pavillon.setText(pl.getPavillon());
		
		taille = new JTextField();
		taille.setEditable(false);
		taille.setColumns(10);
		taille.setBounds(189, 130, 183, 20);
		contentPane.add(taille);
		taille.setText(String.valueOf(pl.getTaille()));
		
		datefabrication = new JTextField();
		datefabrication.setEditable(false);
		datefabrication.setColumns(10);
		datefabrication.setBounds(189, 165, 183, 20);
		contentPane.add(datefabrication);
		datefabrication.setText(pl.getDatefabricaion());
		
		datearriver = new JTextField();
		datearriver.setEditable(false);
		datearriver.setColumns(10);
		datearriver.setBounds(189, 205, 183, 20);
		contentPane.add(datearriver);
		datearriver.setText(pl.getDateAriver());
		
		datedepart = new JTextField();
		datedepart.setEditable(false);
		datedepart.setColumns(10);
		datedepart.setBounds(189, 243, 183, 20);
		contentPane.add(datedepart);
		datedepart.setText(pl.getDateDepart());
		
		emplacement = new JTextField();
		emplacement.setText((String) null);
		emplacement.setEditable(false);
		emplacement.setColumns(10);
		emplacement.setBounds(189, 284, 183, 20);
		contentPane.add(emplacement);
		emplacement.setText(pl.getEmplacement());
		
		lblEmplacement = new JLabel("Emplacement");
		lblEmplacement.setBounds(10, 287, 118, 14);
		contentPane.add(lblEmplacement);
	}

}
