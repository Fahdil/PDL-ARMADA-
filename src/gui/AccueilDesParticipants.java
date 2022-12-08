package gui;
import dao.*;
import model.*;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AccueilDesParticipants extends JFrame {

	private JPanel contentPane;
	private JTextField txtArmada;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AccueilDesParticipants frame = new AccueilDesParticipants();
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
	public AccueilDesParticipants() {

	ConDAO condao = new ConDAO();
	Personmoral personmoral= condao.affiche(" ");
	
		setTitle(" Accueil");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 362);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(224, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txtArmada = new JTextField();
		txtArmada.setText("                       ARMADA 2023");
		txtArmada.setEditable(false);
		txtArmada.setColumns(10);
		txtArmada.setBackground(new Color(255, 182, 193));
		txtArmada.setBounds(87, 27, 224, 61);
		contentPane.add(txtArmada);
		
		JButton btnNewButton_3 = new JButton("Consulter profil");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)  {
					ConsulterProfilPM ConsulterProfil=new ConsulterProfilPM();
					ConsulterProfil.setVisible(true);
					dispose();
				
			}
		});
		btnNewButton_3.setBackground(new Color(135, 206, 250));
		btnNewButton_3.setBounds(118, 132, 163, 23);
		contentPane.add(btnNewButton_3);
		
		JButton btnNewButton_3_1 = new JButton("Modifier profil");
		btnNewButton_3_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
						if(personmoral.getProfil().contains("Entreprise")==true) {
							Entrepriseins2 entrepriseins = new Entrepriseins2();
							entrepriseins.setVisible(true);
							dispose();
						}
						else if(personmoral.getProfil().contains("Delegation")==true) {
							Delegationins2 delegationins= new Delegationins2();
							delegationins.setVisible(true);
							dispose();
						}
						else if(personmoral.getProfil().contains("Bateau")==true) {
							Bateauins2 bateau = new Bateauins2();
							bateau.setVisible(true);
							dispose();
						}
						else if(personmoral.getProfil().contains("Commerçant")==true) {
							Commercantins2 coircommercant = new Commercantins2();
							coircommercant.setVisible(true);
							dispose();
						}
						else if (personmoral.getProfil().contains("Famille d'acceuil")==true){
							FamilleDaccins2  VoirfamilleDacc = new FamilleDaccins2();
							VoirfamilleDacc.setVisible(true);
							dispose();
						}
						
			}
		});
		btnNewButton_3_1.setBackground(new Color(135, 206, 250));
		btnNewButton_3_1.setBounds(118, 180, 163, 23);
		contentPane.add(btnNewButton_3_1);
		
		JButton btnNewButton_3_2 = new JButton("Ins\u00E9rer fiche descriptive");
		btnNewButton_3_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource()==btnNewButton_3_2) {
					Fiche fiche = new Fiche ();
					fiche.setVisible(true);
					dispose();
				}
			}
		});
		btnNewButton_3_2.setBackground(new Color(135, 206, 250));
		btnNewButton_3_2.setBounds(118, 227, 163, 23);
		contentPane.add(btnNewButton_3_2);
		
		JButton btnRetour = new JButton("Retour");
		btnRetour.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource()==btnRetour) {
					Accueil Accueil=new Accueil();
					Accueil.setVisible(true);
					dispose();
				}
			}
		});
		btnRetour.setBackground(new Color(255, 182, 193));
		btnRetour.setBounds(324, 300, 110, 23);
		contentPane.add(btnRetour);
	}

}
