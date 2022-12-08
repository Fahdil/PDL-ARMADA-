package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

//saki@gmail.com saki
public class Accueil extends JFrame { 

	private JPanel contentPane;
	private JTextField txtAmada;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() { 
				try {
					Accueil frame = new Accueil();
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
	public Accueil() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 522, 358);
		contentPane = new JPanel();
		contentPane.setForeground(Color.BLACK);
		contentPane.setBackground(new Color(224, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(5, 5, 424, 0);
		contentPane.add(panel);
		panel.setLayout(new GridLayout(1, 0, 0, 0));
		
		JButton btnNewButton = new JButton("S'identifier");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource()==btnNewButton) {
					Connexion connexion = new Connexion();
					connexion.setVisible(true);
					dispose();
				}
			}
		});
		btnNewButton.setBackground(new Color(135, 206, 250));
		btnNewButton.setBounds(29, 159, 126, 31);
		contentPane.add(btnNewButton);
		
		txtAmada = new JTextField();
		txtAmada.setEditable(false);
		txtAmada.setBackground(new Color(255, 182, 193));
		txtAmada.setText("                ARMADA 2023");
		txtAmada.setColumns(10);
		txtAmada.setBounds(162, 36, 173, 61);
		contentPane.add(txtAmada);
		
		JButton btnNewButton_1 = new JButton("S'inscrire");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource()==btnNewButton_1) {
					Partcipantins Partcipantins = new Partcipantins();
					Partcipantins.setVisible(true);
					dispose();
				}
			}
		});
		btnNewButton_1.setBackground(new Color(135, 206, 250));
		btnNewButton_1.setBounds(344, 159, 126, 31);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Liste des commer\u00E7ants");
		btnNewButton_2.setForeground(new Color(0, 0, 0));
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ListedesCommercants liste = new ListedesCommercants();
				liste.setVisible(true);
				dispose();
			}
		});
		btnNewButton_2.setBackground(new Color(135, 206, 250));
		btnNewButton_2.setBounds(162, 239, 199, 31);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Quitter");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnNewButton_3.setBackground(new Color(255, 0, 0));
		btnNewButton_3.setForeground(new Color(0, 0, 0));
		btnNewButton_3.setBounds(417, 296, 89, 23);
		contentPane.add(btnNewButton_3);
	}


}
