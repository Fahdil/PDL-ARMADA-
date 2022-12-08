package gui;
import model.*;
import dao.*;
import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

public class ConsulterProfilPM extends JFrame {

	private JPanel contentPane;
	private JTextField nomField;
	private JTextField prenField;
	private JTextField mailField_2;
	private JTextField mdpField_3;
	private JTextField profilField_4;
	private JTextField naissancedate;
	private JTextField vip;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ConsulterProfilPM frame = new ConsulterProfilPM();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public ConsulterProfilPM() {
		//Connexionmodel connexionmodel = new Connexionmodel (mail.getText(), String.valueOf(motdp.getPassword()));
		
		ConDAO condao = new ConDAO();
		Personmoral personmoral= condao.affiche(" ");
		//Personmoral personmoral;
		/*Personmoral personmoral=*///condao.get(mail.getText());
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 400);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(224, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
	    	
		JLabel nomlb = new JLabel("Nom");
		nomlb.setBounds(10, 49, 67, 22);
		contentPane.add(nomlb);
		
		
		JLabel lblPrenom = new JLabel("Prenom");
		lblPrenom.setBounds(10, 88, 67, 22);
		contentPane.add(lblPrenom);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setBounds(10, 168, 67, 22);
		contentPane.add(lblEmail);
		
		JLabel lblMotDePasse = new JLabel("Mot de passe");
		lblMotDePasse.setBounds(10, 201, 67, 22);
		contentPane.add(lblMotDePasse);
		
		JLabel lblProfil = new JLabel("Profil");
		lblProfil.setBounds(10, 232, 67, 22);
		contentPane.add(lblProfil);
		
		nomField = new JTextField();
		nomField.setEditable(false);
		nomField.setBounds(196, 50, 165, 20);
		contentPane.add(nomField);
		nomField.setColumns(10);
		nomField.setText(personmoral.getNom());
		
		prenField = new JTextField();
		prenField.setEditable(false);
		prenField.setColumns(10);
		prenField.setBounds(196, 89, 165, 20);
		contentPane.add(prenField);
		prenField.setText(personmoral.getPrenom());
		
		mailField_2 = new JTextField();
		mailField_2.setEditable(false);
		mailField_2.setColumns(10);
		mailField_2.setBounds(196, 171, 165, 20);
		contentPane.add(mailField_2);
		mailField_2.setText(personmoral.getMail());
		
		mdpField_3 = new JTextField();
		mdpField_3.setEditable(false);
		mdpField_3.setColumns(10);
		mdpField_3.setBounds(196, 202, 165, 20);
		contentPane.add(mdpField_3);
		mdpField_3.setText("•••••••••");
		
		profilField_4 = new JTextField();
		profilField_4.setEditable(false);
		profilField_4.setColumns(10);
		profilField_4.setBounds(196, 233, 165, 20);
		contentPane.add(profilField_4);
		profilField_4.setText(personmoral.getProfil());
		
		JButton btnRetour = new JButton("Retour");
		btnRetour.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource()==btnRetour) {
					AccueilDesParticipants AccueilDesParticipants=new AccueilDesParticipants();
					AccueilDesParticipants.setVisible(true);
					dispose();
				}
			}
		 });
		btnRetour.setBackground(new Color(135, 206, 235));
		btnRetour.setBounds(66, 327, 89, 23);
		contentPane.add(btnRetour);
		
		JButton btnVoirPlus = new JButton("Voir plus");
		btnVoirPlus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				System.out.println(personmoral.getProfil());
				if(personmoral.getProfil().contains("Entreprise")==true) {
					Voirentreprise Voirentreprise = new Voirentreprise();
					Voirentreprise.setVisible(true);
					dispose();
				}
				else if(personmoral.getProfil().contains("Delegation")==true) {
					Voirdelegation Voirdelegation= new Voirdelegation();
					Voirdelegation.setVisible(true);
					dispose();
				}
				else if(personmoral.getProfil().contains("Bateau")==true) {
					Voirbateau bateau = new Voirbateau();
					bateau.setVisible(true);
					dispose();
				}
				else if(personmoral.getProfil().contains("Commerçant")==true) {
					Voircommercant2 Voircommercant = new Voircommercant2();
					Voircommercant.setVisible(true);
					dispose();
				}
				else if (personmoral.getProfil().contains("Famille d'acceuil")==true){
					VoirfamilleDacc  VoirfamilleDacc = new VoirfamilleDacc();
					VoirfamilleDacc.setVisible(true);
					dispose();
				}
			
			}
		 });
		btnVoirPlus.setBackground(new Color(135, 206, 235));
		btnVoirPlus.setBounds(257, 327, 89, 23);
		contentPane.add(btnVoirPlus);
		
		JLabel lblMonProfil = new JLabel("MON PROFIL");
		lblMonProfil.setForeground(new Color(255, 0, 0));
		lblMonProfil.setBounds(162, 17, 137, 22);
		contentPane.add(lblMonProfil);
		
		JLabel datenaiss = new JLabel("Date de naissance");
		datenaiss.setBounds(10, 135, 145, 22);
		contentPane.add(datenaiss);
		
		naissancedate = new JTextField();
		naissancedate.setEditable(false);
		naissancedate.setText((String) null);
		naissancedate.setColumns(10);
		naissancedate.setBounds(196, 136, 165, 20);
		contentPane.add(naissancedate);
		naissancedate.setText(personmoral.getDate_nais());
		
		vip = new JTextField();
		vip.setText((String) null);
		vip.setEditable(false);
		vip.setColumns(10);
		vip.setBounds(196, 271, 165, 20);
		contentPane.add(vip);
		vip.setText(personmoral.getVip());
		
		JLabel lblVip = new JLabel("Vip");
		lblVip.setBounds(10, 274, 67, 22);
		contentPane.add(lblVip);
	}

}
