package gui;
import dao.*;
import model.*;
import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextField;

public class Voirentreprise extends JFrame {

	private JPanel contentPane;
	private JTextField nomentre;
	private JTextField immatricul;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Voirentreprise frame = new Voirentreprise();
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
	public Voirentreprise() {
		ConDAO condao =new ConDAO();
		Entreprise en =condao.affichevoirplusen(" ");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(224, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Nom");
		lblNewLabel.setBounds(31, 67, 66, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblImma = new JLabel("Immatriculation");
		lblImma.setBounds(31, 129, 89, 14);
		contentPane.add(lblImma);
		
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
		btnNewButton_1.setBounds(121, 202, 209, 22);
		contentPane.add(btnNewButton_1);
		
		nomentre = new JTextField();
		nomentre.setEditable(false);
		nomentre.setBounds(221, 64, 181, 20);
		contentPane.add(nomentre);
		nomentre.setColumns(10);
		nomentre.setText(en.getNom());
		
		immatricul = new JTextField();
		immatricul.setEditable(false);
		immatricul.setColumns(10);
		immatricul.setBounds(221, 126, 181, 20);
		contentPane.add(immatricul);
		immatricul.setText(en.getImmatriculation());
	}

}
