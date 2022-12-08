package gui;
import model.*;
import dao.*;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import dao.ListeDAO;
import model.Commercant;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.DefaultComboBoxModel;

public class AttribuerStand extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AttribuerStand frame = new AttribuerStand();
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
	public AttribuerStand() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(224, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel message = new JLabel("Stand attribuer avec succes");
		message.setForeground(new Color(0, 0, 255));
		message.setBounds(138, 174, 221, 14);
		contentPane.add(message);
		message.setVisible(false);
		
		JComboBox stand = new JComboBox();
		stand.setModel(new DefaultComboBoxModel(new String[] {"Stand A0", "Stand A1", "Stand A2", "Stand A3", "Stand A4", "Stand A5", "Stand A6", "Stand A7", "Stand A8", "Stand A9", "Stand A10", "Stand A11", "Stand A12", "Stand A13", "Stand A14", "Stand A15", "Stand B0", "Stand B1", "Stand B2", "Stand B3", "Stand B4", "Stand B5", "Stand B6", "Stand B7", "Stand B8", "Stand B9", "Stand B10", "Stand B11", "Stand B12", "Stand B13", "Stand B14", "Stand B15", "Stand B16", "Stand C0", "Stand C1", "Stand C2", "Stand C3", "Stand C4", "Stand C5", "Stand C6", "Stand C7", "Stand C8", "Stand C9", "Stand C10", "Stand C11", "Stand C12", "Stand C13", "Stand C14", "Stand C15", "Stand C16"}));
		stand.setBounds(246, 130, 134, 22);
		contentPane.add(stand);
		
		JComboBox lesCommercants = new JComboBox();
		lesCommercants.setBounds(26, 76, 373, 31);
		contentPane.add(lesCommercants);
		
		JLabel lblNewLabel = new JLabel("       Attribuer un stand a un commer\u00E7ant");
		lblNewLabel.setForeground(new Color(255, 0, 0));
		lblNewLabel.setBounds(91, 25, 228, 25);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1_1 = new JLabel("Stand");
		lblNewLabel_1_1.setBounds(91, 134, 86, 14);
		contentPane.add(lblNewLabel_1_1);
		
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
		btnNewButton_1.setBackground(new Color(135, 206, 250));
		btnNewButton_1.setBounds(79, 211, 93, 22);
		contentPane.add(btnNewButton_1);
		
		ListeDAO listDesCommercants = new ListeDAO();
		Attribution modifier = new Attribution();
		ArrayList<Commercant> list = listDesCommercants.getList();
		
		for(int i=0; i<list.size(); i++)
		{
			lesCommercants.addItem(list.get(i).toString());
			
		}
		
		JButton attribuer_Stand = new JButton("Attribuer");
		attribuer_Stand.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lesCommercants.getSelectedIndex();//recupere le commercant selectionner (sont indice)
				listDesCommercants.getList().get(lesCommercants.getSelectedIndex());//recupere le commercant dans la liste des commercants issus de la base de donner
				modifier.updatecom( String.valueOf(stand.getSelectedItem()),listDesCommercants.getList().get(lesCommercants.getSelectedIndex()).getIdcom());
							message.setVisible(true);
						
			}
		});
		attribuer_Stand.setBackground(new Color(135, 206, 250));
		attribuer_Stand.setBounds(266, 211, 93, 22);
		contentPane.add(attribuer_Stand);
		
	}

}
