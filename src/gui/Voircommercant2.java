package gui;
import dao.*;
import model.*;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Voircommercant2 extends JFrame {

	private JPanel contentPane;
	private JTextField activit;
	private JTextField stan;
	private JTextField emplac;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Voircommercant2 frame = new Voircommercant2();
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
	public Voircommercant2() {
		ConDAO condao = new ConDAO();
		Commercant co=condao.affichevoirplusco(" ");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 419, 281);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(224, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
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
		btnNewButton_1.setBounds(130, 184, 160, 22);
		contentPane.add(btnNewButton_1);
		
		JLabel ativit = new JLabel("Activit\u00E9");
		ativit.setBounds(21, 81, 68, 20);
		contentPane.add(ativit);
		
		JLabel stand = new JLabel("Stand");
		stand.setBounds(21, 132, 68, 20);
		contentPane.add(stand);
		
		activit = new JTextField();
		activit.setEditable(false);
		activit.setColumns(10);
		activit.setBounds(203, 81, 166, 20);
		contentPane.add(activit);
		activit.setText(co.getActivite());
		
		stan = new JTextField();
		stan.setEditable(false);
		stan.setColumns(10);
		stan.setBounds(203, 132, 166, 20);
		contentPane.add(stan);
		stan.setText(co.getStand());
		
	}

}
