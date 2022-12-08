 package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import dao.PlannifierADAO;
import model.Plaisancier;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTable;

public class PlanifierDepardAriver extends JFrame {

	private JPanel contentPane;
	private JTextField depart;
	private JTextField arriver;
	private JTable table;
	private JTable table_3;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PlanifierDepardAriver frame = new PlanifierDepardAriver();
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
	public PlanifierDepardAriver() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 869, 399);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(224, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblPlanifierLarriverEt = new JLabel("Planifier l'arriver et le d\u00E9part d'un participant");
		lblPlanifierLarriverEt.setForeground(Color.RED);
		lblPlanifierLarriverEt.setBounds(319, 26, 257, 25);
		contentPane.add(lblPlanifierLarriverEt);
		
		JLabel lblArriver = new JLabel("Dapart");
		lblArriver.setForeground(Color.BLACK);
		lblArriver.setBounds(461, 230, 88, 25);
		contentPane.add(lblArriver);
		
		JLabel lblDepart = new JLabel("Arriver");
		lblDepart.setForeground(Color.BLACK);
		lblDepart.setBounds(36, 230, 88, 25);
		contentPane.add(lblDepart);
		
		depart = new JTextField();
		depart.setColumns(10);
		depart.setBounds(559, 232, 175, 20);
		contentPane.add(depart);
		
		arriver = new JTextField();
		arriver.setColumns(10);
		arriver.setBounds(112, 232, 175, 20);
		contentPane.add(arriver);
		
		JButton btnNewButton_1 = new JButton("Retour");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource()==btnNewButton_1) {
					AccueilORG  AccueilORG=new AccueilORG();
					AccueilORG.setVisible(true);
					dispose();
				}
			}
		});
		btnNewButton_1.setBackground(new Color(135, 206, 250));
		btnNewButton_1.setBounds(56, 314, 93, 22);
		contentPane.add(btnNewButton_1);
		

		JLabel message = new JLabel("Veilliez remplir les champs arriver et depart ");
		message.setForeground(new Color(255, 0, 0));
		message.setBounds(327, 191, 375, 14);
		contentPane.add(message);
		message.setVisible(false);
		
		table = new JTable();
		table.setBackground(Color.LIGHT_GRAY);
		table.setForeground(new Color(0, 0, 255));
		table.setBounds(36, 64, 778, 103);
		contentPane.add(table);
		
		
		
		// remplir un tableau
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
		Class.forName("oracle.jdbc.OracleDriver");
		con=DriverManager.getConnection("jdbc:oracle:thin:@oracle.esigelec.fr:1521:orcl","C##BDD1_3 ","BDD13");
		java.sql.Statement st = con.createStatement();
		String sql = "SELECT * FROM plaisancier";
		rs =  st.executeQuery(sql);
		ResultSetMetaData md = rs.getMetaData();
		DefaultTableModel model = (DefaultTableModel)table.getModel();

		int col = md.getColumnCount();
		String columnNames [] = new String [col];

		for(int i=0;i<col;i++)
		{
		columnNames[i]=md.getColumnName(i+1);
		}
		model.setColumnIdentifiers(columnNames);

		String Arriver,Depart,email,pavillon,taille,Fabricatio,emplacement,nomBateau;
		int id;
		
		while(rs.next())
		{
			id=rs.getInt(1);
			nomBateau=rs.getString(8);
			Arriver=rs.getString(2);
			Depart=rs.getString(3);
			pavillon=rs.getString(4);
		email=rs.getString(7);
		taille=rs.getString(5);
		Fabricatio=rs.getString(6);
		emplacement=rs.getString(9);
		

		String ligne []= {String.valueOf(id),nomBateau,Arriver,Depart,pavillon,email,taille,Fabricatio,emplacement};
		model.addRow(ligne);
		}
		} catch (ClassNotFoundException | SQLException e1) {
		// TODO Auto-generated catch block
		    e1.printStackTrace();
		}
		for(int i=0; i<table.getRowCount();i++) {
			 if(table.getSelectedRow()==i) {
				 depart.setText((String) table.getValueAt(table.getSelectedRow(),2));
					arriver.setText((String) table.getValueAt(table.getSelectedRow(),3));
			 }
		
		}
		
		JButton btnNewButton_1_1 = new JButton("Valider");
		btnNewButton_1_1.addActionListener(new ActionListener() {
			    public void actionPerformed(ActionEvent e) {
			    	if(arriver.getText().isEmpty()==false && depart.getText().isEmpty()==false ) {
			    		Plaisancier pl = new Plaisancier(Integer.valueOf((String) table.getValueAt(table.getSelectedRow(),0)),"d","f","p",arriver.getText(),depart.getText(),"f",12);
						PlannifierADAO mis = new PlannifierADAO();
						mis.updatebat(pl);
						dispose();
						PlanifierDepardAriver v = new PlanifierDepardAriver();
						v.setVisible(true);
						
			    	}
			    	else  message.setVisible(true);
			    		
			}
		});
		btnNewButton_1_1.setBackground(new Color(135, 206, 250));
		btnNewButton_1_1.setBounds(609, 314, 93, 22);
		contentPane.add(btnNewButton_1_1);
		
		
		


	}
}
