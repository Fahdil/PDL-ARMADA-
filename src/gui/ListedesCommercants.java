package gui;
import dao.*;
import model.*;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import dao.ConDAO;
import model.Connexionmodel;

import java.awt.Color;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JTextPane;
import javax.swing.JTextField;

public class ListedesCommercants extends JFrame {

	private JPanel contentPane;
	private JTextField rechercher;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ListedesCommercants frame = new ListedesCommercants();
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
	public ListedesCommercants() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 487, 322);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(224, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JComboBox mesCommercants = new JComboBox();
		mesCommercants.setBounds(21, 94, 429, 31);
		contentPane.add(mesCommercants);

		JLabel lblNewLabel = new JLabel("Liste des commer\u00E7ants");
		lblNewLabel.setForeground(new Color(255, 0, 0));
		lblNewLabel.setBounds(169, 37, 189, 20);
		contentPane.add(lblNewLabel);

		ListeDAO lesCommercants = new ListeDAO();
		ArrayList<Commercant> list = lesCommercants.getList();

		for(int i=0; i<list.size(); i++)
		{
			mesCommercants.addItem(list.get(i).toString());

		}

		JButton btnNewButton = new JButton("Retour");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Accueil accueil = new Accueil();
				accueil.setVisible(true);
				dispose();
			}
		});
		btnNewButton.setBounds(32, 238, 89, 23);
		contentPane.add(btnNewButton);

		JButton btnNewButton_1 = new JButton("Quitter");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnNewButton_1.setBounds(333, 238, 89, 23);
		contentPane.add(btnNewButton_1);

		JLabel lblNewLabel_1 = new JLabel("Retrouver un commer\u00E7ant selon vos critere ");
		lblNewLabel_1.setForeground(new Color(0, 0, 255));
		lblNewLabel_1.setBounds(109, 142, 261, 20);
		contentPane.add(lblNewLabel_1);

		rechercher = new JTextField();
		rechercher.setBounds(90, 184, 103, 20);
		contentPane.add(rechercher);
		rechercher.setColumns(10);

		JButton btnNewButton_2 = new JButton("Chercher");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(rechercher.getText().isEmpty()==true) {
					mesCommercants.removeAllItems();
				}
				else {
					mesCommercants.removeAllItems();
					for(int i=0; i<list.size(); i++)
					{
						if(list.get(i).toString().contains(rechercher.getText())==true) {
							mesCommercants.addItem(list.get(i).toString());

						}

					}

				}
			}
		});
		btnNewButton_2.setBackground(new Color(64, 224, 208));
		btnNewButton_2.setForeground(new Color(0, 0, 0));
		btnNewButton_2.setBounds(281, 183, 89, 23);
		contentPane.add(btnNewButton_2);


	}
}
