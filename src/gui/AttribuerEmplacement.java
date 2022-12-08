package gui;
import dao.*;
import model.*;
import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.tree.DefaultMutableTreeNode;

import dao.Attribution;
import dao.ListeDAO;
import model.Commercant;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTree;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class AttribuerEmplacement extends JFrame {

	private JPanel contentPane;
	private JTextField taille;
	private JTextField pavillon;
	private JTextField emplacement;
	private JTextField nombt;

	
	 /**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AttribuerEmplacement frame = new AttribuerEmplacement();
					frame.setVisible(true);
					frame.setResizable(false);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame
	 * 
	 */
	public AttribuerEmplacement() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 895, 462);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(224, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		
		JLabel lblAttribuerUnEmplacement = new JLabel("       Attribuer un emplacement a un bateau");
		lblAttribuerUnEmplacement.setForeground(Color.RED);
		lblAttribuerUnEmplacement.setBounds(545, 11, 257, 25);
		contentPane.add(lblAttribuerUnEmplacement);
		
		JLabel lblNomDuBateau = new JLabel("Nom du bateau");
		lblNomDuBateau.setForeground(Color.BLACK);
		lblNomDuBateau.setBounds(490, 70, 116, 25);
		contentPane.add(lblNomDuBateau);
		
		nombt = new JTextField();
		nombt.setColumns(10);
		nombt.setBounds(700, 72, 151, 20);
		contentPane.add(nombt);
		
		JLabel lblNom = new JLabel("Taille du bateau");
		lblNom.setForeground(new Color(0, 0, 0));
		lblNom.setBounds(490, 117, 116, 25);
		contentPane.add(lblNom);
		
		JLabel lblMail = new JLabel("Pavillon ");
		lblMail.setForeground(Color.BLACK);
		lblMail.setBounds(490, 164, 88, 25);
		contentPane.add(lblMail);
		
		JLabel lblEmplacement = new JLabel("emplacement actuel");
		lblEmplacement.setForeground(Color.BLACK);
		lblEmplacement.setBounds(490, 211, 134, 25);
		contentPane.add(lblEmplacement);
		
		taille = new JTextField();
		taille.setBounds(700, 119, 151, 20);
		contentPane.add(taille);
		taille.setColumns(10);
		
		pavillon = new JTextField();
		pavillon.setColumns(10);
		pavillon.setBounds(700, 166, 151, 20);
		contentPane.add(pavillon);
		
		emplacement = new JTextField();
		emplacement.setColumns(10);
		emplacement.setBounds(700, 213, 151, 20);
		contentPane.add(emplacement);
		
		JComboBox mesbateaux = new JComboBox();
		mesbateaux.setBounds(10, 137, 442, 42);
		contentPane.add(mesbateaux);
		
		JLabel lblEmplacement_1 = new JLabel("Emplacement");
		lblEmplacement_1.setForeground(Color.BLACK);
		lblEmplacement_1.setBounds(490, 253, 88, 25);
		contentPane.add(lblEmplacement_1);
		
		JComboBox emplacementliste = new JComboBox();
		emplacementliste.setModel(new DefaultComboBoxModel(new String[] {"Emplacement 0", "Emplacement 1", "Emplacement 2", "Emplacement 3", "Emplacement 4", "Emplacement 5", "Emplacement 6", "Emplacement 7", "Emplacement 8", "Emplacement 9", "Emplacement 10", "Emplacement 11", "Emplacement 11", "Emplacement 12", "Emplacement 13", "Emplacement 14", "Emplacement 15"}));
		emplacementliste.setBounds(700, 253, 156, 25);
		contentPane.add(emplacementliste);
		
		JLabel lblNewLabel = new JLabel("Listes des participants avec un bateau");
		lblNewLabel.setForeground(new Color(0, 128, 0));
		lblNewLabel.setBounds(69, 81, 305, 24);
		contentPane.add(lblNewLabel);
		
		
		ListeDAO listDesBateau= new ListeDAO();
		Attribution modifier = new Attribution();
		ArrayList<Plaisancier> list = listDesBateau.getListBateau();
		
			for(int i=0; i<list.size(); i++)
			{
				mesbateaux.addItem(list.get(i).toString());
	
			}
		
		JButton btnNewButton_1 = new JButton("Retour");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource()==btnNewButton_1) {
					AccueilORG AccueilORG=new AccueilORG();
					AccueilORG.setVisible(true);
					dispose();
				}
			}
		});
		
		JButton btnNewButton = new JButton("choisir ce participant");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				    nombt.setText(list.get(mesbateaux.getSelectedIndex()).getNombt());
			  		emplacement.setText(list.get(mesbateaux.getSelectedIndex()).getEmplacement());
					taille.setText(String.valueOf(list.get(mesbateaux.getSelectedIndex()).getTaille()));
					pavillon.setText(list.get(mesbateaux.getSelectedIndex()).getPavillon());
			}
		});
		btnNewButton.setBackground(new Color(135, 206, 250));
		btnNewButton.setForeground(new Color(0, 0, 0));
		btnNewButton.setBounds(150, 244, 200, 42);
		contentPane.add(btnNewButton);
		
		btnNewButton_1.setBackground(new Color(135, 206, 250));
		btnNewButton_1.setBounds(485, 341, 93, 22);
		contentPane.add(btnNewButton_1);
	
		JButton btnNewButton_1_1 = new JButton("Valider");
		btnNewButton_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mesbateaux.getSelectedIndex();//recupere l(indice de la personne choisit 
				list.get(mesbateaux.getSelectedIndex()).getEmplacement();//recupere le bateau coprrespondant au choix fait
				modifier.updatemplacement(String.valueOf(emplacementliste.getSelectedItem()), list.get(mesbateaux.getSelectedIndex()).getId());
				//emplacementliste.removeItem(emplacementliste.getSelectedItem());
				dispose();
				AttribuerEmplacement empl = new AttribuerEmplacement();
				empl.setVisible(true);
			}
		});
		btnNewButton_1_1.setBackground(new Color(135, 206, 250));
		btnNewButton_1_1.setBounds(711, 341, 93, 22);
		contentPane.add(btnNewButton_1_1);
			
		
		
	}
}
