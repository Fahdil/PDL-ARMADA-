package gui;
import dao.*;
import model.*;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JEditorPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.DefaultComboBoxModel;

public class Voirdelegation extends JFrame {

	private JPanel contentPane;
	private JTextField nombredeper;
	private JTextField pays;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Voirdelegation frame = new Voirdelegation();
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
	public Voirdelegation() {
		ConDAO condao = new ConDAO();
		Delegation de =condao.affichevoirplusde(" ");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(224, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Pays");
		lblNewLabel.setBounds(22, 42, 57, 18);
		contentPane.add(lblNewLabel);
		
		JLabel lblNombreDePersonnes = new JLabel("Nombre de personnes");
		lblNombreDePersonnes.setBounds(22, 91, 113, 18);
		contentPane.add(lblNombreDePersonnes);
		
		nombredeper = new JTextField();
		nombredeper.setEditable(false);
		nombredeper.setBounds(197, 90, 174, 20);
		contentPane.add(nombredeper);
		nombredeper.setColumns(10);
		nombredeper.setText(String.valueOf(de.getNbpersonne()));
		
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
		btnNewButton_1.setBounds(137, 187, 174, 22);
		contentPane.add(btnNewButton_1);
		
		pays = new JTextField();
		pays.setEditable(false);
		pays.setColumns(10);
		pays.setBounds(197, 41, 174, 20);
		contentPane.add(pays);
		pays.setText(de.getPays());
	}
}
