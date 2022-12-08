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
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;
import java.util.*
;public class Connexion extends JFrame {

	private JPanel contentPane;
	public JTextField mail;
	private JPasswordField motdp;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Connexion frame = new Connexion();
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
	public Connexion() {
		setTitle("Connexion");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(224, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel message = new JLabel("Veillez enttrez un mail et un mot de passe correcte ");
		message.setForeground(new Color(0, 0, 255));
		message.setBounds(127, 38, 294, 14);
		contentPane.add(message);
		message.setVisible(false);
		
		JLabel lblNewLabel = new JLabel("CONNEXION");
		lblNewLabel.setForeground(new Color(255, 0, 0));
		lblNewLabel.setBounds(174, 11, 113, 22);
		contentPane.add(lblNewLabel);
		
		mail = new JTextField();
		mail.setBounds(228, 80, 169, 20);
		contentPane.add(mail);
		mail.setColumns(10);
		
		JLabel lblMailidentifiant = new JLabel("Mail/Identifiant");
		lblMailidentifiant.setForeground(new Color(0, 0, 0));
		lblMailidentifiant.setBounds(51, 79, 113, 22);
		contentPane.add(lblMailidentifiant);
		
		JLabel lblMotDePasse = new JLabel("Mot de passe");
		lblMotDePasse.setForeground(new Color(0, 0, 0));
		lblMotDePasse.setBounds(51, 137, 113, 22);
		contentPane.add(lblMotDePasse);
		
		JButton btnNewButton = new JButton("Retour");
		btnNewButton.setBackground(new Color(135, 206, 235));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				   if(e.getSource()==btnNewButton) {
					dispose();
					Accueil Accueil = new Accueil(); Accueil.setVisible(true);
			    }
			}
		});
		btnNewButton.setBounds(87, 201, 89, 23);
		contentPane.add(btnNewButton);
		
		motdp = new JPasswordField();
		motdp.setBounds(228, 138, 169, 20);
		contentPane.add(motdp);
		
		JButton btnValide = new JButton("Valider");
		btnValide.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if((mail.getText().contains(".com")==true  ||mail.getText().contains(".fr")==true  ||mail.getText().contains(".org")==true  ) && String.valueOf(motdp.getPassword()).isEmpty()==false) {
					ConDAO condao = new ConDAO();
					OrganisateurDAO org = new  OrganisateurDAO(); 
					Connexionmodel connexionmodel = new Connexionmodel (mail.getText(), String.valueOf(motdp.getPassword()),condao.valider());
					condao.Pouravoirlemail(connexionmodel);
					ArrayList<Connexionmodel> listor = org.getListor();
					ArrayList<Connexionmodel> list = condao.getList();
					
					for(int i=0; i<list.size(); i++)
					{
						list.get(i).toString();
					}
					
				
				if(connexionmodel.comparaison(list)==true ) {
					System.out.println("true");
					AccueilDesParticipants AccueilDesParticipants = new AccueilDesParticipants(); AccueilDesParticipants.setVisible(true);
                     dispose();
				    }
				if(connexionmodel.comparaison(listor)==true ) {
					System.out.println("true");
					dispose();
					AccueilORG accueilORG = new AccueilORG(); accueilORG.setVisible(true);
				    }
				else 
					System.out.println("ERREUR");
				}
				else {
					message.setVisible(true);
				}
				
			}
		});
		btnValide.setBackground(new Color(135, 206, 235));
		btnValide.setBounds(236, 201, 89, 23);
		contentPane.add(btnValide);
	
	}
}
