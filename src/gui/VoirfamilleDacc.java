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
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.JTextField;

public class VoirfamilleDacc extends JFrame {

	private JPanel contentPane;
	private JTextField nomf;
	private JTextField adreef;
	private JTextField nombrde;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VoirfamilleDacc frame = new VoirfamilleDacc();
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
	public VoirfamilleDacc() {
		ConDAO condao = new ConDAO();
		FamilleAcc fa=condao.affichevoirplusfa(" ");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(224, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(54, 87, 59, -25);
		contentPane.add(panel);
		
		JLabel lblNewLabel = new JLabel("Nom");
		lblNewLabel.setBounds(22, 57, 59, 19);
		contentPane.add(lblNewLabel);
		
		JLabel lblAdresse = new JLabel("Adresse");
		lblAdresse.setBounds(22, 87, 59, 19);
		contentPane.add(lblAdresse);
		
		JLabel lblNombreDePlace = new JLabel("Nombre de place");
		lblNombreDePlace.setBounds(22, 117, 91, 19);
		contentPane.add(lblNombreDePlace);
		
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
		btnNewButton_1.setBounds(130, 188, 157, 22);
		contentPane.add(btnNewButton_1);
		
		nomf = new JTextField();
		nomf.setEditable(false);
		nomf.setBounds(154, 56, 194, 20);
		contentPane.add(nomf);
		nomf.setColumns(10);
		nomf.setText(fa.getNomFa());
		
		adreef = new JTextField();
		adreef.setEditable(false);
		adreef.setColumns(10);
		adreef.setBounds(154, 87, 194, 20);
		contentPane.add(adreef);
		adreef.setText(fa.getAddresse());
		
		nombrde = new JTextField();
		nombrde.setEditable(false);
		nombrde.setColumns(10);
		nombrde.setBounds(154, 116, 194, 20);
		contentPane.add(nombrde);
		nombrde.setText(String.valueOf(fa.getNbplace()));
	}

}
