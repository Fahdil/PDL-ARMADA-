package gui;

import java.awt.BorderLayout;
import model.*;
import dao.*;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AjouterUnOrganisateur extends JFrame {

	private JPanel contentPane;
	private JTextField nom;
	private JTextField prenom;
	private JTextField mail;
	private JTextField mdp;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AjouterUnOrganisateur frame = new AjouterUnOrganisateur();
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
	public AjouterUnOrganisateur() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 354);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		nom = new JTextField();
		nom.setBounds(240, 57, 86, 20);
		contentPane.add(nom);
		nom.setColumns(10);
		
		prenom = new JTextField();
		prenom.setBounds(240, 103, 86, 20);
		contentPane.add(prenom);
		prenom.setColumns(10);
		
		mail = new JTextField();
		mail.setBounds(240, 148, 86, 20);
		contentPane.add(mail);
		mail.setColumns(10);
		
		mdp = new JTextField();
		mdp.setBounds(240, 194, 86, 20);
		contentPane.add(mdp);
		mdp.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Nom");
		lblNewLabel.setBounds(59, 60, 94, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblPrenom = new JLabel("Prenom");
		lblPrenom.setBounds(59, 106, 94, 14);
		contentPane.add(lblPrenom);
		
		JLabel lblMail = new JLabel("mail");
		lblMail.setBounds(59, 151, 94, 14);
		contentPane.add(lblMail);
		
		JLabel lblMotDePasse = new JLabel("mot de passe");
		lblMotDePasse.setBounds(59, 197, 94, 14);
		contentPane.add(lblMotDePasse);
		
		JButton btnNewButton = new JButton("Ajouter");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Organisateur org = new Organisateur(nom.getText(), prenom.getText(), mail.getText(), mdp.getText());
				OrganisateurDAO addd = new OrganisateurDAO();
				addd.add(org);
			}
		});
		btnNewButton.setBounds(177, 250, 89, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Retour");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AccueilORG acc = new AccueilORG();
				acc.setVisible(true);
				dispose();
			}
		});
		btnNewButton_1.setBounds(10, 281, 89, 23);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Quitter");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnNewButton_2.setBounds(345, 281, 89, 23);
		contentPane.add(btnNewButton_2);
	}
}
