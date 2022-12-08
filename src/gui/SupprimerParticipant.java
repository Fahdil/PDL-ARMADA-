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
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JComboBox;

public class SupprimerParticipant extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SupprimerParticipant frame = new SupprimerParticipant();
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
	public SupprimerParticipant() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 325);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(224, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		InscriptionDAO lesParticipant= new InscriptionDAO();
		JComboBox mesParticipants = new JComboBox();
		mesParticipants.setBounds(133, 150, 264, 22);
		contentPane.add(mesParticipants);
		
		JLabel lblSupprimerUnParticipant = new JLabel("Supprimer un participant");
		lblSupprimerUnParticipant.setForeground(Color.RED);
		lblSupprimerUnParticipant.setBounds(154, 28, 257, 25);
		contentPane.add(lblSupprimerUnParticipant);
		
		JLabel lblMail = new JLabel("Participant");
		lblMail.setBounds(35, 150, 80, 23);
		contentPane.add(lblMail);
		
		JLabel lblProfil = new JLabel("Pour supprimer un participant  ");
		lblProfil.setBounds(35, 64, 344, 14);
		contentPane.add(lblProfil);
		
		JButton btnRetour = new JButton("Retour");
		btnRetour.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource()==btnRetour) {
					dispose();
					AccueilORG AccueilORG = new AccueilORG(); AccueilORG.setVisible(true);
				}
			}
		});
		
		
		//
		
		ArrayList<Inscription> listpart = lesParticipant.getList();
		
		
		for(int j=0; j<listpart.size(); j++) {
							if(listpart.get(j).getEmail().equals("rm@gmail.com")==true) {
								
							}
							else
								mesParticipants.addItem(listpart.get(j).toString());
							
				
				}
		//
		btnRetour.setBackground(new Color(135, 206, 250));
		btnRetour.setBounds(69, 224, 107, 22);
		contentPane.add(btnRetour);
		
		JButton supprimer = new JButton("Supprimer");
		supprimer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				  Supprparticipantdao supprimer = new Supprparticipantdao();
				  supprimer.delete(listpart.get(mesParticipants.getSelectedIndex()).getEmail());
				  dispose();
				  SupprimerParticipant nouveau = new SupprimerParticipant();
				  nouveau.setVisible(true);
				}
		});
		supprimer.setBackground(new Color(135, 206, 250));
		supprimer.setBounds(251, 224, 107, 22);
		contentPane.add(supprimer);
		
		JLabel lblPuisCliquezSur = new JLabel("2-Puis cliquez sur supprimer ");
		lblPuisCliquezSur.setBounds(35, 113, 344, 14);
		contentPane.add(lblPuisCliquezSur);
		
		JLabel lblVeillezInsererCidessous = new JLabel("1-Veillez inserer ci-dessous sont mail  ");
		lblVeillezInsererCidessous.setBounds(35, 89, 344, 14);
		contentPane.add(lblVeillezInsererCidessous);
		
		
	}
}
