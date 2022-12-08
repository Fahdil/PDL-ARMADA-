package gui;
import model.*;
import dao.*;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import dao.InscriptionDAO;
import model.Entreprise;

import java.awt.Color;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JEditorPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.DefaultComboBoxModel;

public class Delegationins extends JFrame {

	private JPanel contentPane;
	private JTextField nombrepersins;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Delegationins frame = new Delegationins();
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
	public Delegationins() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(224, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JComboBox paysins = new JComboBox();
		paysins.setModel(new DefaultComboBoxModel(new String[] {"Liste des pays", "Afrique du Sud\t", "Afghanistan\t", "Albanie\t", "Alg\u00E9rie", "Allemagne\t", "Andorre\t", "Angola\t", "Antigua-et-Barbuda\t", "Arabie Saoudite\t", "Argentine\t", "Arm\u00E9nie\t", "Australie\t", "Autriche\t", "Azerba\u00EFdjan", "Bahamas\t", "Bahre\u00EFn\t", "Bangladesh", "Barbade\t", "Belgique\t", "Belize\t", "B\u00E9nin", "Bhoutan\t", "Bi\u00E9lorussie\t", "Birmanie\t", "Bolivie\t", "Bosnie-Herz\u00E9govine\t", "Botswana\t", "Br\u00E9sil\t", "Brunei\t", "Bulgarie\t", "Burkina Faso\t", "Burundi\t", "Cambodge", "Cameroun\t", "Canada", "Cap-Vert\t", "Chili\t", "Chine\t", "Chypre\t", "Colombie\t", "Comores\t", "Cor\u00E9e du Nord\t", "Cor\u00E9e du Sud\t", "Costa Rica\t", "C\u00F4te d\u2019Ivoire\t", "Croatie\t", "Cuba\t", "Danemark\t", "Djibouti\t", "Dominique\t", "\u00C9gypte\t", "\u00C9mirats arabes unis\t", "\u00C9quateur\t", "\u00C9rythr\u00E9e\t", "Espagne\t", "Eswatini\t", "Estonie\t", "\u00C9tats-Unis\t", "\u00C9thiopie\t", "Fidji\t", "Finlande\t", "France\t", "Gabon\t", "Gambie\t", "G\u00E9orgie\t", "Ghana\t", "Gr\u00E8ce\t", "Grenade\t", "Guatemala\t", "Guin\u00E9e\t", "Guin\u00E9e \u00E9quatoriale\t", "Guin\u00E9e-Bissau\t", "Guyana\t", "Ha\u00EFti\t", "Honduras\t", "Hongrie\t", "\u00CEles Cook\t", "\u00CEles Marshall\t", "Inde\t", "Indon\u00E9sie\t", "Irak\t", "Iran\t", "Irlande\t", "Islande\t", "Isra\u00EBl\t", "Italie\t", "Jama\u00EFque\t", "Japon\t", "Jordanie\t", "Kazakhstan\t", "Kenya\t", "Kirghizistan\t", "Kiribati\t", "Kowe\u00EFt\t", "Laos\t", "Lesotho\t", "Lettonie\t", "Liban\t", "Liberia\t", "Libye\t", "Liechtenstein\t", "Lituanie\t", "Luxembourg\t", "Mac\u00E9doine\t", "Madagascar\t", "Malaisie\t", "Malawi\t", "Maldives\t", "Mali\t", "Malte\t ", "Maroc\t", "Maurice\t", "Mauritanie\t", "Mexique\t", "Micron\u00E9sie\t", "Moldavie\t", "Monaco\t", "Mongolie\t", "Mont\u00E9n\u00E9gro\t", "Mozambique\t", "Namibie\t", "Nauru\t", "N\u00E9pal\t", "Nicaragua\t", "Niger\t", "Nigeria\t", "Niue\t", "Norv\u00E8ge\t", "Nouvelle-Z\u00E9lande\t", "Oman\t", "Ouganda\t", "Ouzb\u00E9kistan\t", "Pakistan\t", "Palaos\t", "Palestine\t", "Panama\t", "Papouasie-Nouvelle-Guin\u00E9e\t", "Paraguay\t", "Pays-Bas\t", "P\u00E9rou\t", "Philippines\t", "Pologne\t", "Portugal\t", "Qatar\t", "R\u00E9publique centrafricaine\t", "R\u00E9publique d\u00E9mocratique du Congo\t", "R\u00E9publique Dominicaine\t", "R\u00E9publique du Congo\t", "R\u00E9publique tch\u00E8que\t", "Roumanie\t", "Royaume-Uni\t", "Russie\t", "Rwanda\t", "Saint-Kitts-et-Nevis\t", "Saint-Vincent-et-les-Grenadines\t", "Sainte-Lucie\t", "Saint-Marin\t", "Salomon\t", "Salvador\t", "Samoa\t", "S\u00E3o Tom\u00E9-et-Principe\t", "S\u00E9n\u00E9gal\t", "Serbie\t", "Seychelles\t", "Sierra Leone\t", "Singapour\t", "Slovaquie\t", "Slov\u00E9nie\t", "Somalie\t", "Soudan\t", "Soudan du Sud\t", "Sri Lanka\t", "Su\u00E8de", "Suisse\t", "Suriname\t", "Syrie\t", "Tadjikistan\t", "Tanzanie\t", "Tchad\t", "Tha\u00EFlande\t", "Timor oriental", "Togo\t", "Tonga\t", "Trinit\u00E9-et-Tobago\t", "Tunisie\t", "Turkm\u00E9nistan\t", "Turquie\t", "Tuvalu\t", "Ukraine\t", "Uruguay\t", "Vanuatu\t", "Vatican\t", "Venezuela", "Vi\u00EAt Nam", "Y\u00E9men\t", "Zambie\t", "Zimbabwe"}));
		paysins.setMaximumRowCount(1000);
		paysins.setBounds(197, 38, 174, 22);
		contentPane.add(paysins);
		
		JLabel lblNewLabel = new JLabel("Pays");
		lblNewLabel.setBounds(22, 42, 57, 18);
		contentPane.add(lblNewLabel);
		
		JLabel lblNombreDePersonnes = new JLabel("Nombre de personnes");
		lblNombreDePersonnes.setBounds(22, 91, 113, 18);
		contentPane.add(lblNombreDePersonnes);
		
		nombrepersins = new JTextField();
		nombrepersins.setBounds(197, 90, 174, 20);
		contentPane.add(nombrepersins);
		nombrepersins.setColumns(10);
		
		JButton btnNewButton_1 = new JButton("Retour");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource()==btnNewButton_1) {
					Partcipantins Partcipantins=new Partcipantins();
					Partcipantins.setVisible(true);
					dispose();
				}
			}
		});
		btnNewButton_1.setBackground(new Color(135, 206, 250));
		btnNewButton_1.setBounds(67, 178, 93, 22);
		contentPane.add(btnNewButton_1);
		
		JButton valider = new JButton("Valider");
		valider.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if( nombrepersins.getText().isEmpty()==false ){
				InscriptionDAO condao = new InscriptionDAO();
				Delegation delegation = new Delegation(1,String.valueOf(paysins.getSelectedItem()),Integer.valueOf(nombrepersins.getText()));
				condao.updatdel(delegation);
				Felicitation felicitation=new Felicitation();
				felicitation.setVisible(true);
				dispose();
				}
			}
		});
		valider.setBackground(new Color(135, 206, 250));
		valider.setBounds(265, 178, 93, 22);
		contentPane.add(valider);
	}
}
