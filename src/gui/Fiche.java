package gui;
import dao.*;
import model.*;
import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.InputStream;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

//import org.jcp.xml.dsig.internal.dom.Utils;

import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.JLabel;

public class Fiche extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Fiche frame = new Fiche();
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
	public Fiche() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 490, 417);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(224, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel message = new JLabel("Fiche inserer avec succes ");
		message.setForeground(new Color(0, 0, 255));
		message.setBounds(127, 38, 294, 14);
		contentPane.add(message);
		message.setVisible(false);
		
		JTextArea fiche = new JTextArea();
		fiche.setBounds(29, 63, 423, 239);
		contentPane.add(fiche);
		
		JButton Valider = new JButton("Valider");
		Valider.setBackground(new Color(135, 206, 235));
		Valider.setBounds(346, 331, 89, 23);
		contentPane.add(Valider);
		Valider.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource()==Valider) {
					ConDAO condao = new ConDAO();
					Fichemodel fichemodel = new Fichemodel(fiche.getText());
					condao.InsererFiche(fichemodel);
					message.setVisible(true);
					fiche.setText(null);
					
				}
			}
		 });
		
		JButton Retour = new JButton("Retour");
		Retour.setBackground(new Color(135, 206, 235));
		Retour.setBounds(47, 331, 89, 23);
		contentPane.add(Retour);
		Retour.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource()==Retour) {
					AccueilDesParticipants AccueilDesParticipants=new AccueilDesParticipants();
					AccueilDesParticipants.setVisible(true);
					dispose();
				}
			}
		 });
		
		JLabel lblNewLabel = new JLabel("Veillez creer votre fiche descriptits");
		lblNewLabel.setForeground(new Color(255, 0, 0));
		lblNewLabel.setBounds(141, 11, 249, 23);
		contentPane.add(lblNewLabel);
	}
}
