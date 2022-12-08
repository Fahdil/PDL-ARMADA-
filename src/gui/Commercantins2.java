package gui;
import dao.*;
import model.*;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import model.Entreprise;

import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Commercantins2 extends JFrame {

	private JPanel contentPane;
	private JTextField activiteins;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Commercantins2 frame = new Commercantins2();
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
	public Commercantins2() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(224, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel message = new JLabel("Modifications enregistr\u00E9es avec succ\u00E8s ");
		message.setForeground(new Color(255, 0, 0));
		message.setBounds(104, 22, 294, 14);
		contentPane.add(message);
		message.setVisible(false);
		
		activiteins = new JTextField();
		activiteins.setBounds(195, 104, 229, 26);
		contentPane.add(activiteins);
		activiteins.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Activit\u00E9");
		lblNewLabel.setBounds(25, 107, 68, 20);
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton_1 = new JButton("Retour");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource()==btnNewButton_1) {
					AccueilDesParticipants retour=new AccueilDesParticipants();
					retour.setVisible(true);
					dispose();
				}
			}
		});
		btnNewButton_1.setBackground(new Color(135, 206, 250));
		btnNewButton_1.setBounds(88, 184, 93, 22);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_1_1 = new JButton("Valider");
		btnNewButton_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource()==btnNewButton_1_1 && activiteins.getText().isEmpty()==false) {
					ConDAO condao = new ConDAO();
					Commercant commercant = new Commercant(1, activiteins.getText(),"Aucun");
					condao.updatecom(commercant);
					message.setVisible(true);
			   }
			}
		});
		btnNewButton_1_1.setBackground(new Color(135, 206, 250));
		btnNewButton_1_1.setBounds(260, 184, 93, 22);
		contentPane.add(btnNewButton_1_1);
	}

}
