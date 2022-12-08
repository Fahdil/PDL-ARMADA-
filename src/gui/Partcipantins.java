package gui;
import dao.*;
import model.*;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JMenuItem;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Properties;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;
import javax.swing.JFormattedTextField;

public class Partcipantins extends JFrame {

	private JPanel contentPane;
	private JTextField nomin;
	private JTextField prenomin;
	private JTextField mailin;
	private JTextField datenain;
	private JPasswordField motdpin;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args)  {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Partcipantins frame = new Partcipantins();
					frame.setVisible(true);
					frame.setResizable(false);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * C:\Users\NeO MARKET\eclipse-workspace\PDL
	 * Create the frame.
	 */
	public Partcipantins()  {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 464);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(224, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel message_mailexiste = new JLabel("Ce mail exise deja veillez le changer pour vous s'inscrire");
		message_mailexiste.setForeground(new Color(165, 42, 42));
		message_mailexiste.setBounds(65, 69, 379, 14);
		contentPane.add(message_mailexiste);
		message_mailexiste.setVisible(false);
		
		JLabel message = new JLabel("Veillez entrez des informations corrects correcte ");
		message.setForeground(new Color(0, 0, 255));
		message.setBounds(55, 46, 294, 14);
		contentPane.add(message);
		message.setVisible(false);
		
		JLabel lblNewLabel = new JLabel("Veuillez entrer vos informations");
		lblNewLabel.setForeground(new Color(255, 0, 0));
		lblNewLabel.setBounds(127, 11, 285, 24);
		contentPane.add(lblNewLabel);
		
		JComboBox profil = new JComboBox();
		profil.setModel(new DefaultComboBoxModel(new String[] {"Entreprise", "Delegation", "Famille d'acceuil", "Commer\u00E7ant", "Bateau"}));
		profil.setMaximumRowCount(100);
		profil.setToolTipText("");
		profil.setBounds(188, 246, 163, 22);
		contentPane.add(profil);
		
		JLabel lblNewLabel_1 = new JLabel("Nom");
		lblNewLabel_1.setBounds(10, 97, 46, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Prenom");
		lblNewLabel_2.setBounds(10, 136, 46, 14);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Mail");
		lblNewLabel_3.setBounds(10, 173, 46, 14);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Date de Naissance");
		lblNewLabel_4.setBounds(10, 212, 138, 14);
		contentPane.add(lblNewLabel_4);
		
		nomin = new JTextField();
		nomin.setBounds(186, 94, 163, 20);
		contentPane.add(nomin);
		nomin.setColumns(10);
		
		prenomin = new JTextField();
		prenomin.setColumns(10);
		prenomin.setBounds(186, 133, 163, 20);
		contentPane.add(prenomin);
		
		mailin = new JTextField();
		mailin.setColumns(10);
		mailin.setBounds(186, 170, 163, 20);
		contentPane.add(mailin);
		
		datenain = new JTextField();
		datenain.setColumns(10);
		datenain.setBounds(186, 209, 163, 20);
		contentPane.add(datenain);
		datenain.setText("ex : 10/10/1990");
		
		JLabel lblNewLabel_4_1 = new JLabel("Profil");
		lblNewLabel_4_1.setBounds(10, 250, 93, 14);
		contentPane.add(lblNewLabel_4_1);
		
		JButton btnNewButton_1 = new JButton("Retour");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource()==btnNewButton_1) {
					Accueil Accueil=new Accueil();
					Accueil.setVisible(true);
					dispose();
				}
			}
		});
		btnNewButton_1.setBackground(new Color(135, 206, 250));
		btnNewButton_1.setBounds(55, 357, 93, 22);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_1_1 = new JButton("Valider");
		btnNewButton_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				if(nomin.getText().isEmpty()==false && prenomin.getText().isEmpty()==false && motdpin.getText().isEmpty()==false && (mailin.getText().contains(".com")==true  ||mailin.getText().contains(".fr")==true  ||mailin.getText().contains(".org")==true  ) && datenain.getText().contains("/")==true) {
					
					Meeeeessage.sendMail(mailin.getText());
					System.out.println(mailin.getText());
					
					InscriptionDAO condao = new InscriptionDAO();
					Inscription inscription = new Inscription (mailin.getText(),String.valueOf(motdpin.getPassword()),nomin.getText(),prenomin.getText(),datenain.getText(),String.valueOf(profil.getSelectedItem()),"non"); 
				     condao.addpar (inscription);
				 	 condao.addpm (inscription);
				 	 condao.complete(inscription);
				 	 
				 	ConDAO cond = new ConDAO();
					ArrayList<Connexionmodel> list = cond.getList();
					Connexionmodel connexionmodel = new Connexionmodel(mailin.getText(),String.valueOf(motdpin.getPassword()),"hh");
									
						if(inscription.comparaison(list)==true)	{
							     
							
							if(profil.getSelectedItem()=="Entreprise") {
								   Entrepriseins Entrepriseins =new Entrepriseins();
								   Entrepriseins.setVisible(true);
						                dispose();
							     }
							    else if(profil.getSelectedItem()=="Bateau") {
								   Bateauins Bateauins =new Bateauins();
								   Bateauins.setVisible(true);
								   dispose();
							     }
							   else if(profil.getSelectedItem()=="Delegation") {
								   Delegationins Delegationins =new Delegationins();
										   Delegationins.setVisible(true);
								   dispose();
							     }
							   else if(profil.getSelectedItem()=="Famille d'acceuil") {
								   FamilleDaccins FamilleDaccins =new FamilleDaccins();
								   FamilleDaccins.setVisible(true);
								   dispose();
							     }
							   else
								   if(profil.getSelectedItem()=="Commerçant") {
									   Commercantins Commercantins =new Commercantins();
									   Commercantins.setVisible(true);
									   dispose();
								     }
							// fin d'ajout des types de participants
							
						}
						
						//ce else est pour le cas ou le mail entrez pour s"inscrire existe deja
									else {
										message_mailexiste.setVisible(true);
									}
					   
				 }
				      //ce else est pour le cas ou les informations sonts bien remplits
						else {
							message.setVisible(true);
						}
			}
		});
		btnNewButton_1_1.setBackground(new Color(135, 206, 250));
		btnNewButton_1_1.setBounds(249, 357, 93, 22);
		contentPane.add(btnNewButton_1_1);
		
		JLabel lblNewLabel_4_2 = new JLabel("Mot de passe");
		lblNewLabel_4_2.setBounds(10, 291, 93, 14);
		contentPane.add(lblNewLabel_4_2);
		
		motdpin = new JPasswordField();
		motdpin.setBounds(188, 291, 162, 20);
		contentPane.add(motdpin);
		
		
		
			
		
	}
}
