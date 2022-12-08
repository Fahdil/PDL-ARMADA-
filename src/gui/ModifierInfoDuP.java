package gui;
import dao.*;
import model.*;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class ModifierInfoDuP extends JFrame {

	private JPanel contentPane;
	private JTextField pays;
	private JTextField nombrepson;
	private JTextField nom_entreprise;
	private JTextField immatriculatio;
	private JTextField activit;
	private JTextField nomfam;
	private JTextField adress;
	private JTextField nombt;
	private JTextField pavil;
	private JTextField nombre_de_place;
	private JTextField taill;
	private JTextField date_de_fabrication;
	private JPanel panelentreprise;
	private JPanel panelcommercant;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ModifierInfoDuP frame = new ModifierInfoDuP();
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
	public ModifierInfoDuP() {
		
		ModifierDAO modifier = new ModifierDAO();
		InscriptionDAO  lesParticipant = new InscriptionDAO();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1032, 690);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(224, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		JComboBox vip = new JComboBox();
		vip.setModel(new DefaultComboBoxModel(new String[] {"non", "oui"}));
		vip.setBounds(735, 99, 67, 22);
		contentPane.add(vip);
		
		JComboBox mesParticipants = new JComboBox();
		mesParticipants.setBounds(59, 99, 245, 22);
		contentPane.add(mesParticipants);
		
	//	
	       ArrayList<Inscription> listpart = lesParticipant.getList();
			
			
			for(int j=0; j<listpart.size(); j++) {
								if(listpart.get(j).getEmail().equals("rm@gmail.com")==true) {
									
								}
								else
									mesParticipants.addItem(listpart.get(j).toString());
								
					
					}
			//
			
		JLabel message = new JLabel("Modifications bien enregistr\u00E9es");
		message.setForeground(new Color(0, 0, 255));
		message.setBounds(88, 189, 366, 26);
		contentPane.add(message);
		message.setVisible(false);
		
		JLabel lblNewLabel = new JLabel("Modifier informations d'un participant");
		lblNewLabel.setForeground(new Color(255, 0, 0));
		lblNewLabel.setBounds(249, 26, 229, 26);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1_2 = new JLabel("Participant");
		lblNewLabel_1_2.setBounds(49, 69, 117, 20);
		contentPane.add(lblNewLabel_1_2);
		
		JPanel paneldeledation = new JPanel();
		paneldeledation.setBackground(new Color(102, 205, 170));
		paneldeledation.setBounds(0, 226, 193, 329);
		contentPane.add(paneldeledation);
		paneldeledation.setLayout(null);
		
		JLabel lblNewLabel_1_3 = new JLabel("Nom");
		lblNewLabel_1_3.setBounds(10, 48, 50, 20);
		paneldeledation.add(lblNewLabel_1_3);
		
		JLabel lblDelegation = new JLabel("DELEGATION");
		lblDelegation.setBounds(61, 11, 110, 26);
		paneldeledation.add(lblDelegation);
		lblDelegation.setForeground(Color.RED);
		
		pays = new JTextField();
		pays.setBounds(31, 85, 151, 20);
		paneldeledation.add(pays);
		pays.setColumns(10);
		
		nombrepson = new JTextField();
		nombrepson.setColumns(10);
		nombrepson.setBounds(31, 163, 151, 20);
		paneldeledation.add(nombrepson);
		
		JLabel lblNewLabel_1_3_1 = new JLabel("Nombre de personne");
		lblNewLabel_1_3_1.setBounds(10, 132, 117, 20);
		paneldeledation.add(lblNewLabel_1_3_1);
		
		JButton valider_delegation = new JButton("Valider");
		valider_delegation.setBackground(new Color(135, 206, 235));
		valider_delegation.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(pays.getText().isEmpty()==false && nombrepson.getText().isEmpty()==false ) {
					Delegation delegation = new Delegation(1,pays.getText(),Integer.valueOf(nombrepson.getText()));
					modifier.updatdel(delegation,listpart.get(mesParticipants.getSelectedIndex()).getEmail());
					message.setVisible(true);
					modifier.vip(listpart.get(mesParticipants.getSelectedIndex()).getEmail(), String.valueOf(vip.getSelectedItem()));
					dispose();
					ModifierInfoDuP  mod=new ModifierInfoDuP(); 
					mod.setVisible(true);
				}
			}
		});
		valider_delegation.setBounds(49, 252, 89, 23);
		paneldeledation.add(valider_delegation);
		
		//JPanel entreprise;
		panelentreprise = new JPanel();
		panelentreprise.setBackground(new Color(32, 178, 170));
		panelentreprise.setLayout(null);
		panelentreprise.setBounds(203, 226, 193, 329);
		contentPane.add(panelentreprise);
		
		JLabel lblNewLabel_1_3_2 = new JLabel("Nom");
		lblNewLabel_1_3_2.setBounds(10, 48, 50, 20);
		panelentreprise.add(lblNewLabel_1_3_2);
		
		JLabel lblEntreprise = new JLabel("ENTREPRISE\r\n");
		lblEntreprise.setForeground(Color.RED);
		lblEntreprise.setBounds(61, 11, 110, 26);
		panelentreprise.add(lblEntreprise);
		
		nom_entreprise = new JTextField();
		nom_entreprise.setColumns(10);
		nom_entreprise.setBounds(36, 85, 146, 20);
		panelentreprise.add(nom_entreprise);
		
		immatriculatio = new JTextField();
		immatriculatio.setColumns(10);
		immatriculatio.setBounds(36, 163, 146, 20);
		panelentreprise.add(immatriculatio);
		
		JLabel lblNewLabel_1_3_1_1 = new JLabel("Immatriculation");
		lblNewLabel_1_3_1_1.setBounds(10, 132, 117, 20);
		panelentreprise.add(lblNewLabel_1_3_1_1);
		
		JButton valider_entreprise = new JButton("Valider");
		valider_entreprise.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if( nom_entreprise.getText().isEmpty()==false && immatriculatio.getText().isEmpty()==false) {
					Entreprise entreprise = new Entreprise(nom_entreprise.getText(),immatriculatio.getText());
					modifier.updateent(entreprise, listpart.get(mesParticipants.getSelectedIndex()).getEmail());
					message.setVisible(true);
					modifier.vip(listpart.get(mesParticipants.getSelectedIndex()).getEmail(), String.valueOf(vip.getSelectedItem()));
					dispose();
					ModifierInfoDuP  mod=new ModifierInfoDuP(); 
					mod.setVisible(true);
				}
			}
		});
		valider_entreprise.setBackground(new Color(135, 206, 235));
		valider_entreprise.setBounds(47, 249, 89, 23);
		panelentreprise.add(valider_entreprise);
		
		//JPanel commercant;
		panelcommercant = new JPanel();
		panelcommercant.setBackground(new Color(95, 158, 160));
		panelcommercant.setLayout(null);
		panelcommercant.setBounds(406, 226, 193, 329);
		contentPane.add(panelcommercant);
		
		JLabel lblCommerant = new JLabel("COMMERCANT");
		lblCommerant.setForeground(Color.RED);
		lblCommerant.setBounds(61, 11, 110, 26);
		panelcommercant.add(lblCommerant);
		
		activit = new JTextField();
		activit.setColumns(10);
		activit.setBounds(21, 139, 150, 20);
		panelcommercant.add(activit);
		
		JLabel lblNewLabel_1_3_1_1_1 = new JLabel("Activite");
		lblNewLabel_1_3_1_1_1.setBounds(47, 84, 117, 20);
		panelcommercant.add(lblNewLabel_1_3_1_1_1);
		
		JButton valider_commercant = new JButton("Valider");
		valider_commercant.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if( activit.getText().isEmpty()==false) {
					Commercant commercant = new Commercant(1, activit.getText(),"Aucun");
					modifier.updatecom(commercant, listpart.get(mesParticipants.getSelectedIndex()).getEmail());
					message.setVisible(true);
					modifier.vip(listpart.get(mesParticipants.getSelectedIndex()).getEmail(), String.valueOf(vip.getSelectedItem()));
					dispose();
					ModifierInfoDuP  mod=new ModifierInfoDuP(); 
					mod.setVisible(true);
			   }
			}
		});
		valider_commercant.setBackground(new Color(135, 206, 235));
		valider_commercant.setBounds(47, 249, 89, 23);
		panelcommercant.add(valider_commercant);
		
		JPanel panelfamille = new JPanel();
		panelfamille.setBackground(new Color(46, 139, 87));
		panelfamille.setLayout(null);
		panelfamille.setBounds(609, 226, 193, 329);
		contentPane.add(panelfamille);
		
		JLabel lblNewLabel_1_3_2_1 = new JLabel("Nom");
		lblNewLabel_1_3_2_1.setBounds(10, 48, 50, 20);
		panelfamille.add(lblNewLabel_1_3_2_1);
		
		JLabel lblFamilleDaccueil = new JLabel("FAMILLE D'ACCUEIL");
		lblFamilleDaccueil.setForeground(Color.RED);
		lblFamilleDaccueil.setBounds(47, 11, 124, 26);
		panelfamille.add(lblFamilleDaccueil);
		
		nomfam = new JTextField();
		nomfam.setColumns(10);
		nomfam.setBounds(34, 63, 148, 20);
		panelfamille.add(nomfam);
		
		adress = new JTextField();
		adress.setColumns(10);
		adress.setBounds(34, 125, 148, 20);
		panelfamille.add(adress);
		
		JLabel lblNewLabel_1_3_1_1_2 = new JLabel("Adresse");
		lblNewLabel_1_3_1_1_2.setBounds(10, 94, 117, 20);
		panelfamille.add(lblNewLabel_1_3_1_1_2);
		
		JButton valider_famille = new JButton("Valider");
		valider_famille.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if( nomfam.getText() .isEmpty()==false && adress.getText() .isEmpty()==false && nombre_de_place.getText().isEmpty()==false ) {
					FamilleAcc familleAcc = new FamilleAcc (1, nomfam.getText() , adress.getText(), Integer.valueOf(nombre_de_place.getText()));
					modifier.updatfam(familleAcc, listpart.get(mesParticipants.getSelectedIndex()).getEmail());
					message.setVisible(true);
					modifier.vip(listpart.get(mesParticipants.getSelectedIndex()).getEmail(), String.valueOf(vip.getSelectedItem()));
					dispose();
					ModifierInfoDuP  mod=new ModifierInfoDuP(); 
					mod.setVisible(true);
				}
			}
		});
		valider_famille.setBackground(new Color(135, 206, 235));
		valider_famille.setBounds(47, 249, 89, 23);
		panelfamille.add(valider_famille);
		
		nombre_de_place = new JTextField();
		nombre_de_place.setColumns(10);
		nombre_de_place.setBounds(34, 186, 148, 20);
		panelfamille.add(nombre_de_place);
		
		JLabel lblNewLabel_1_3_1_1_2_1 = new JLabel("Nombre de place");
		lblNewLabel_1_3_1_1_2_1.setBounds(10, 156, 117, 20);
		panelfamille.add(lblNewLabel_1_3_1_1_2_1);
		
		JPanel panelbateau = new JPanel();
		panelbateau.setBackground(new Color(47, 79, 79));
		panelbateau.setLayout(null);
		panelbateau.setBounds(812, 226, 193, 329);
		contentPane.add(panelbateau);
		
		JLabel lblNewLabel_1_3_2_2 = new JLabel("Nom du bateau");
		lblNewLabel_1_3_2_2.setBounds(10, 48, 117, 20);
		panelbateau.add(lblNewLabel_1_3_2_2);
		
		JLabel lblBateau = new JLabel("BATEAU");
		lblBateau.setForeground(Color.RED);
		lblBateau.setBounds(61, 11, 110, 26);
		panelbateau.add(lblBateau);
		
		nombt = new JTextField();
		nombt.setColumns(10);
		nombt.setBounds(34, 67, 148, 20);
		panelbateau.add(nombt);
		
		pavil = new JTextField();
		pavil.setColumns(10);
		pavil.setBounds(34, 121, 148, 20);
		panelbateau.add(pavil);
		
		JLabel lblNewLabel_1_3_1_1_3 = new JLabel("Pavillon");
		lblNewLabel_1_3_1_1_3.setBounds(10, 98, 117, 20);
		panelbateau.add(lblNewLabel_1_3_1_1_3);
		
		JButton valider_bateau = new JButton("Valider");
		valider_bateau.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if( nombt.getText().isEmpty()==false && pavil.getText().isEmpty()==false && taill.getText().isEmpty()==false && date_de_fabrication.getText().isEmpty()==false ){
					Plaisancier plaisancier = new Plaisancier(1,"Aucun",nombt.getText(), pavil.getText(), "12/12/12", "12/12/12",date_de_fabrication.getText(), Double.valueOf(taill.getText()));
					modifier.updatebat(plaisancier,listpart.get(mesParticipants.getSelectedIndex()).getEmail());
					message.setVisible(true);
					modifier.vip(listpart.get(mesParticipants.getSelectedIndex()).getEmail(), String.valueOf(vip.getSelectedItem()));
					dispose();
					ModifierInfoDuP  mod=new ModifierInfoDuP(); 
					mod.setVisible(true);
				}
			}
		});
		valider_bateau.setBackground(new Color(135, 206, 235));
		valider_bateau.setBounds(47, 249, 89, 23);
		panelbateau.add(valider_bateau);
		
		taill = new JTextField();
		taill.setColumns(10);
		taill.setBounds(34, 168, 148, 20);
		panelbateau.add(taill);
		
		date_de_fabrication = new JTextField();
		date_de_fabrication.setColumns(10);
		date_de_fabrication.setBounds(34, 211, 148, 20);
		panelbateau.add(date_de_fabrication);
		
		JLabel lblNewLabel_1_3_1_1_3_1 = new JLabel("Taille");
		lblNewLabel_1_3_1_1_3_1.setBounds(10, 148, 117, 20);
		panelbateau.add(lblNewLabel_1_3_1_1_3_1);
		
		JLabel lblNewLabel_1_3_1_1_3_2 = new JLabel("Date de fabrication");
		lblNewLabel_1_3_1_1_3_2.setBounds(10, 191, 117, 20);
		panelbateau.add(lblNewLabel_1_3_1_1_3_2);
		
		JButton btnNewButton_1_1_1 = new JButton("Retour\r\n");
		btnNewButton_1_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource()==btnNewButton_1_1_1) {
					AccueilORG AccueilORG=new AccueilORG();
					AccueilORG.setVisible(true);
					dispose();
				}
			}
		});
		btnNewButton_1_1_1.setBackground(new Color(135, 206, 235));
		btnNewButton_1_1_1.setBounds(506, 590, 193, 23);
		contentPane.add(btnNewButton_1_1_1);
	
		JButton btnNewButton_1_4 = new JButton("visualiseer les informations du particip\u00E2nt");
		btnNewButton_1_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
					Commercant commercant = modifier.affichevoirplusco(listpart.get(mesParticipants.getSelectedIndex()).getEmail());
					Personmoral personmoral = modifier.affiche(listpart.get(mesParticipants.getSelectedIndex()).getEmail());
					Entreprise  entreprise = modifier.affichevoirplusen(listpart.get(mesParticipants.getSelectedIndex()).getEmail());
					FamilleAcc familleAcc = modifier.affichevoirplusfa(listpart.get(mesParticipants.getSelectedIndex()).getEmail());
					Delegation delegation = modifier.affichevoirplusde(listpart.get(mesParticipants.getSelectedIndex()).getEmail());
					Plaisancier plaisancier = modifier.affichevoirpluspl(listpart.get(mesParticipants.getSelectedIndex()).getEmail());
					if(personmoral.getProfil().contains("Entreprise")==true) {
						nom_entreprise.setText(entreprise.getNom());
						immatriculatio.setText(entreprise.getImmatriculation());
					}
					else if(personmoral.getProfil().contains("Bateau")==true) {
						nombt.setText(plaisancier.getNombt());
						taill.setText(String.valueOf(plaisancier.getTaille()));
						pavil.setText(plaisancier.getPavillon());
						date_de_fabrication.setText(plaisancier.getDatefabricaion());
					}
					else if(personmoral.getProfil().contains("Delegation")==true) {
						pays.setText(delegation.getPays());
						nombrepson.setText(String.valueOf(delegation.getNbpersonne()));
					}
					else if(personmoral.getProfil().contains("Famille d'acceuil")==true) {
						nomfam.setText(familleAcc.getNomFa());
						adress.setText(familleAcc.getAddresse());	
						nombre_de_place.setText(String.valueOf(familleAcc.getNbplace()));
						
					}
					else if(personmoral.getProfil().contains("Commerçant")==true) {
						activit.setText(commercant.getActivite());
					}
					
					message.setVisible(false);
				}
			
		});
		btnNewButton_1_4.setBackground(new Color(135, 206, 235));
		btnNewButton_1_4.setBounds(267, 155, 372, 23);
		contentPane.add(btnNewButton_1_4);
		
		JLabel lblNewLabel_1_2_1 = new JLabel("VIP");
		lblNewLabel_1_2_1.setBounds(737, 69, 65, 20);
		contentPane.add(lblNewLabel_1_2_1);
		
		
		
		
		
	}
}
