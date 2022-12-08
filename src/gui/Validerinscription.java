package gui;
import model.*;
import dao.*;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JList;
import javax.swing.AbstractListModel;
import java.awt.Color;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;

public class Validerinscription extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Validerinscription frame = new Validerinscription();
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
	public Validerinscription() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 692, 361);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(224, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel message = new JLabel("Inscription valider avec succes");
		message.setForeground(new Color(0, 0, 255));
		message.setBounds(265, 213, 258, 14);
		contentPane.add(message);
		message.setVisible(false);
		
		JComboBox validationEnAttente = new JComboBox();
		validationEnAttente.setBounds(29, 73, 616, 34);
		contentPane.add(validationEnAttente);
		
		ListeDAO lesParticipant = new ListeDAO();
		
		/* On cree une liste des participants dont l'incription n'est pas valider (listparticipantsnonvalider)
		 * a l'aide de chaque element de la liste precedente, on obtient la personne moral qui corespond a ce participant
		 * on regroupe toute les personnes moral dans une nouvelle liste (list)
		 * Quand l'organisateur fait valider, on recuper l'index choit depuis la combobox
		 * on appel la fontion validerInscription qui prend en parametre le mail du participant choisit
		 * pour recuper le mail
		 * on prent la list ou on recuper le mail de la personne moral dont l'indice correspont a l'indice cjhoisit dans la combobox
		 */
		ArrayList<Connexionmodel> listparticipantsnonvalider = lesParticipant.getListparticipantNonValider();
		
		
for(int j=0; j<listparticipantsnonvalider.size(); j++) {
			
		ArrayList<Personmoral> list = lesParticipant.getListpersonreMoral(listparticipantsnonvalider.get(j).getMailcon());
				
				for(int i=0; i<list.size(); i++)
				{
					if(list.get(i).getMail().equals("rm@gmail.com")==true) {
						
					}
					else
					validationEnAttente.addItem(list.get(i).toString());
					
				}
		}
		
		
		JButton validerLinscription = new JButton("Valider l'inscription");
		validerLinscription.setBackground(new Color(175, 238, 238));
		validerLinscription.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				validationEnAttente.getSelectedIndex();
				message.setVisible(true);
				lesParticipant.validerInscription(listparticipantsnonvalider.get(validationEnAttente.getSelectedIndex()).getMailcon());	
				
				MeeeeessageValidationInscrip.sendMail(listparticipantsnonvalider.get(validationEnAttente.getSelectedIndex()).getMailcon());
				Validerinscription valid = new Validerinscription(); valid.setVisible(true);
				dispose();
			}
		});
		validerLinscription.setBounds(233, 155, 220, 23);
		contentPane.add(validerLinscription);
		
		JButton Retour = new JButton("Retour");
		Retour.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AccueilORG accueilorg = new  AccueilORG();
				accueilorg.setVisible(true);
				dispose();
			}
		});
		Retour.setBackground(new Color(135, 206, 250));
		Retour.setBounds(148, 271, 89, 23);
		contentPane.add(Retour);
		
		JButton Quitter = new JButton("Quitter");
		Quitter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		Quitter.setBackground(new Color(135, 206, 250));
		Quitter.setBounds(410, 271, 89, 23);
		contentPane.add(Quitter);
		
		JLabel lblNewLabel = new JLabel("Validation d'inscription ");
		lblNewLabel.setForeground(new Color(255, 0, 0));
		lblNewLabel.setBounds(267, 27, 314, 23);
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Refuser");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Supprparticipantdao suppr = new Supprparticipantdao();// instencie le classe de suppression dao 
				validationEnAttente.getSelectedIndex(); // recupere l'indice selectionner 
				suppr.delete(listparticipantsnonvalider.get(validationEnAttente.getSelectedIndex()).getMailcon());// passe a la suppresin du participant via la methode delete de supprparticipant en lui passant en parametre le mail de la personne selectionnée	
				Validerinscription valid = new Validerinscription(); valid.setVisible(true); // affiche une nouvelle fois la page en guise d'actualisation
				dispose();
			}
		});
		btnNewButton.setBackground(new Color(255, 0, 0));
		btnNewButton.setBounds(587, 209, 89, 23);
		contentPane.add(btnNewButton);
		
		
	}
}
