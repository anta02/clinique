/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gestionconsultation;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.MessageFormat;
import java.util.Date;
import java.util.Random;
import javax.swing.JDialog;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JOptionPane;
import javax.swing.JTable;

/**
 *
 * @author Utilisateur
 */
public class Consulter extends JFrame implements ActionListener{

     // Variables declaration - do not modify                     
    private javax.swing.JButton ConsultPat;
    private javax.swing.JLabel applicationName;
    private javax.swing.JButton retour;
    private javax.swing.JButton annuler;
    private javax.swing.JButton enregistrer;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JComboBox jComboBox2;
    private javax.swing.JComboBox jComboBox4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JButton ListPatConsute;
    private javax.swing.JButton supprimer;
    private javax.swing.JButton valider;
    private static int ia=0;
    private String nom,prenom;
    private String classesL[]= new String[25];
    private static int numero;
    private int consulation;
    private String[] medi=new String[10];
    private String[] quantite=new String[10];
    private String[] nbrejours=new String[10];
    private  int at=0;
    private String[] historque={"liste des patients","historique des consultations des patients"};
    
    public Consulter(){
        jComboBox1 = new javax.swing.JComboBox();
		 try {
		 Connection con = null;
                 Class.forName("com.mysql.jdbc.Driver").newInstance();
		 con = (Connection)DriverManager.getConnection("jdbc:mysql://localhost:3306/hopitaldb", "root","");
		 if (!con.isClosed())
		 System.out.println("Successfully connected to MySQL server...");
		 
		 
		//Création d'un objet Statement
		 Statement state = (Statement) con.createStatement( ) ;
		 //L'objet ResultSet contient le résultat de la requéte SQL
		 ResultSet result = state. executeQuery( "SELECT * FROM medicament") ;

		 while( result. next( ) )
		 {
			 //System.out.println(result.getString("libelle"));
			 jComboBox1.addItem(result.getString("libelle"));
			 
		 }}
                 catch(Exception ez) {
		 System.err.println("Exception: " + ez.getMessage());
		 } 
       // NomMedicament();
        requete(Principal.num_ss);
        JFrame.setDefaultLookAndFeelDecorated(true);
        JDialog.setDefaultLookAndFeelDecorated(true);
        requete1();
        Consultation();
        this.setSize(1300,700);
        Container contenu=this.getContentPane();
        setLocationRelativeTo(null);
        setUndecorated(true);
        
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jPanel9 = new javax.swing.JPanel();
        ListPatConsute = new javax.swing.JButton();
        ConsultPat = new javax.swing.JButton();
        retour = new javax.swing.JButton();
        applicationName = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        supprimer = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        valider = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        annuler = new javax.swing.JButton();
        enregistrer = new javax.swing.JButton();
        //jComboBox1 = new javax.swing.JComboBox();
        jComboBox2 = new javax.swing.JComboBox();
        jComboBox4 = new javax.swing.JComboBox();
        
        jPanel2.setBackground(new java.awt.Color(204, 255, 204));
        jPanel2.setForeground(new java.awt.Color(51, 51, 255));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel1.setText("GESTION CONSULTATION");

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel8.setText("-");
        jLabel8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel8MouseClicked(evt);
            }

           
        });
         javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(79, 79, 79)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 816, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 291, Short.MAX_VALUE)
                .addComponent(jLabel8)
                .addGap(15, 15, 15))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel7.setBackground(new java.awt.Color(204, 0, 0));

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Deconnexion ");
        jLabel7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel7MouseClicked(evt);
            }

           
        });
        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 98, Short.MAX_VALUE)
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel9.setBackground(new java.awt.Color(204, 255, 204));
        jPanel9.setBorder(javax.swing.BorderFactory.createCompoundBorder());

        ListPatConsute.setBackground(new java.awt.Color(102, 102, 102));
        ListPatConsute.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        ListPatConsute.setText("La liste des patients consultés");
        
        ConsultPat.setBackground(new java.awt.Color(102, 102, 102));
        ConsultPat.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        ConsultPat.setForeground(new java.awt.Color(102, 255, 0));
        ConsultPat.setText("Consulter un patient");
        
        retour.setBackground(new java.awt.Color(102, 102, 102));
        retour.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        retour.setText("Retour");
        
        applicationName.setFont(new java.awt.Font("Algerian", 2, 24)); // NOI18N
        applicationName.setText("hostipal 2.0");
        
        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(applicationName, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel9Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(ListPatConsute, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 333, Short.MAX_VALUE)
                            .addComponent(ConsultPat, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(retour, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addComponent(applicationName, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(39, 39, 39)
                .addComponent(ConsultPat, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(120, 120, 120)
                .addComponent(ListPatConsute, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(120, 120, 120)
                .addComponent(retour, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(120, 120, 120))
        );

        jPanel4.setBackground(new java.awt.Color(44, 62, 80));
        
        supprimer.setBackground(new java.awt.Color(255, 51, 51));
        supprimer.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        supprimer.setText("Supprimer un médicament");
        
          jLabel3.setFont(new java.awt.Font("Tahoma", 3, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(102, 255, 102));
        jLabel3.setText("Ordonnance de "+nom+" "+prenom);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Identiiant", "libelle", "quantite", "nombre de jour"
            }
        ));
        jTable1.setRowHeight(80);
        jScrollPane1.setViewportView(jTable1);

        valider.setBackground(new java.awt.Color(102, 255, 51));
        valider.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        valider.setText("Valider l'ordonnance");
        
         javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(supprimer)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(valider)
                .addContainerGap())
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 488, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(supprimer, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(valider, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 696, Short.MAX_VALUE))
        );

        jPanel1.setBackground(new java.awt.Color(44, 62, 80));
        jPanel1.setForeground(new java.awt.Color(204, 255, 204));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(204, 255, 204));
        jLabel2.setText("Médicament");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(204, 255, 204));
        jLabel4.setText("Quantité");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(204, 255, 204));
        jLabel5.setText("Nombre de jour");

        annuler.setBackground(new java.awt.Color(255, 51, 51));
        annuler.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        annuler.setText("ANNULER");

        enregistrer.setBackground(new java.awt.Color(255, 255, 255));
        enregistrer.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        enregistrer.setText("ENREGISTRER");
        
        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "1", "2", "3", "4", "5","6"}));
        jComboBox4.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "1 jour", "2 jours", "3 jours", "4 jours", "5 jours","6 jours"}));
        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(annuler, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(enregistrer, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jComboBox4, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 134, Short.MAX_VALUE)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(61, 61, 61)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(29, 29, 29)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(85, 85, 85)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(88, 88, 88)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(107, 107, 107)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBox4, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(130, 130, 130)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(annuler, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(enregistrer, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(contenu);
        contenu.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(6, 6, 6)
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        
        ConsultPat.addActionListener(this);
        ListPatConsute.addActionListener(this);
        annuler.addActionListener(this);
        enregistrer.addActionListener(this);
        supprimer.addActionListener(this);
        valider.addActionListener(this);
        retour.addActionListener(this);
    }
    
    public String requete1(){
	    
    	String req=null;
    	Connection con = null;
		 try {
		 Class.forName("com.mysql.jdbc.Driver").newInstance();
		 con = (Connection)DriverManager.getConnection("jdbc:mysql://localhost:3306/hopitaldb", "root","");
		 if (!con.isClosed())
		 System.out.println("Successfully connected to MySQL server...");
		 
		//Création d'un objet Statement
		 Statement state = (Statement) con.createStatement( ) ;
		 //L'objet ResultSet contient le résultat de la requéte SQL
		 ResultSet result = state. executeQuery("Select * from Patient");
		    int i=0;
		    
			 while( result. next( ) )
			 {
				 
				 classesL[i]=""+result.getString("Num_ss")+" "+result.getString("Prenom")+" "+result.getString("Nom");
				 
				
				 
				i++; 
			 }
			 
		 result. close( ) ;
		 //result1. close( ) ;
		 state. close( );
		 }
		catch(Exception e) {
		 System.err.println("Exception:,,, " + e.getMessage());
                JOptionPane.showMessageDialog(null,"insertion echouer","Information",JOptionPane.INFORMATION_MESSAGE);
		 } finally {
		 try {
		 if (con != null)
		 con.close();
		 } catch(SQLException e) {}
		 }
		 
    	
    	
    	return req;
    }
    public String requete(String num_ss){
	    
    	String req=null;
    	Connection con = null;
		 try {
		 Class.forName("com.mysql.jdbc.Driver").newInstance();
		 con = (Connection)DriverManager.getConnection("jdbc:mysql://localhost:3306/hopitaldb", "root","");
		 if (!con.isClosed())
		 System.out.println("Successfully connected to MySQL server...");
		
		//Création d'un objet Statement
		 Statement state = (Statement) con.createStatement( ) ;
		 //L'objet ResultSet contient le résultat de la requéte SQL
		 ResultSet result = state. executeQuery("Select * from Patient where Num_ss='"+num_ss+"'");
		    
				 while( result. next( ) )
				 {
					 nom=result.getString("nom");
					 prenom=result.getString("prenom");
					 System.out.println(req);
					 
					 
				 }
		 
		 result. close( ) ;
		 //result1. close( ) ;
		 state. close( );
		 }
		catch(Exception e) {
		 System.err.println("Exception:,,, " + e.getMessage());
                 JOptionPane.showMessageDialog(null,"insertion echouer","Information",JOptionPane.INFORMATION_MESSAGE);

		 } finally {
		 try {
		 if (con != null)
		 con.close();
		 } catch(SQLException e) {}
		 }
		 
    	
    	
    	return req;
    }
public String requete(String libelle, int ii,int j){
	    
    	String req=null;
    	Connection con = null;
		 try {
		 Class.forName("com.mysql.jdbc.Driver").newInstance();
		 con = (Connection)DriverManager.getConnection("jdbc:mysql://localhost:3306/hopitaldb", "root","");
		 if (!con.isClosed())
		 System.out.println("Successfully connected to MySQL server...");
		 
		//Création d'un objet Statement
		 Statement state = (Statement) con.createStatement( ) ;
		 //L'objet ResultSet contient le résultat de la requéte SQL
		 ResultSet result = state. executeQuery("Select * from Medicament where libelle='"+libelle+"'");
		    
				 while( result. next())
				 {
					 jTable1.setValueAt(result.getString("code"), ii,j++ );
					 jTable1.setValueAt(libelle, ii, j++);
					 jTable1.setValueAt(jComboBox2.getSelectedItem(), ii, j++);
					 jTable1.setValueAt(jComboBox4.getSelectedItem(), ii, j++);
					 
					 ii++;
					 j=0;
					 
					 
					 System.out.println(req);
					 
					 
				 }
		 
		 result. close( ) ;
		 //result1. close( ) ;
		 state. close( );
		 }
		catch(Exception e) {
		 System.err.println("Exception:,,, " + e.getMessage());
                JOptionPane.showMessageDialog(null,"insertion echouer","Information",JOptionPane.INFORMATION_MESSAGE);
		 } finally {
		 try {
		 if (con != null)
		 con.close();
		 } catch(SQLException e) {}
		 }
		 
    	
    	
    	return req;
    }

    public int codeMedicament(String libelle)
    {

    	Connection con = null;
		 try {
		 Class.forName("com.mysql.jdbc.Driver").newInstance();
		 con = (Connection)DriverManager.getConnection("jdbc:mysql://localhost:3306/hopitaldb", "root","");
		 if (!con.isClosed())
		 System.out.println("Successfully connected to MySQL server...");
		Statement s = (Statement) con.createStatement ();
		int count=0;
		
		ResultSet result = s. executeQuery( "SELECT * FROM Medicament ") ;
		int code;
		 while( result. next( ) )
		 {
			 count++;
			 if (result.getString("libelle").equals(libelle))
				 return result.getInt("code");
			 System.out.println(count);
			 
		 }
		
		
  		 //result1. close( ) ;
  		 s. close( );
  		 
		 }
  		catch(Exception ex) {
  		 System.err.println("Exception: nnnn" + ex.getMessage());
  		JOptionPane.showMessageDialog(null,"insertion echouer","Information",JOptionPane.INFORMATION_MESSAGE);
  		 } finally {
  		 try {
  		 if (con != null)
  		 con.close();
  		 } catch(SQLException ex) {}
  		 }
		 return -1;
    }
 public void Consultation()
    {
    	int j=0;
     	
     	Connection con = null;
  		 try {
  		 Class.forName("com.mysql.jdbc.Driver").newInstance();
  		 con = (Connection)DriverManager.getConnection("jdbc:mysql://localhost:3306/hopitaldb", "root","");
  		 if (!con.isClosed())
  		 System.out.println("Successfully connected to MySQL server here...");
  		Statement s = (Statement) con.createStatement ();
  		int count=0;
  		
  		ResultSet result = s. executeQuery( "SELECT * FROM consulte") ;
  		int tmp=0;
  		 while(result.next())
  		 {
  			 count++;
  			 if(result.getString("Patient_Num_ss").equals(Principal.num_ss) && result.getString("Medecin_Matricule").equals(Principal.Mmatricul))
  			 {
  				 tmp=1;
  				 System.out.println("il y'a un enregistrement");
  			 }
  			 System.out.println(result.getString("Patient_Num_ss")+" "+Principal.num_ss);
  			System.out.println(result.getString("Medecin_Matricule")+" "+Principal.Mmatricul);
  		 }
  		 
  		Date a =new Date();
  		 int idens=0;
  		 Random r=new Random();
  		 
  		 /*String login=jprenom.getText()+r.nextInt(100);
  		 String mdp=generate(8);*/
  		
  		if(tmp==0){
  			count = s.executeUpdate ( "INSERT INTO Consulte (Medecin_Matricule,Patient_Num_ss)"
  					 + " VALUES"
  					 + "('"+Principal.Mmatricul+"','"+Principal.num_ss+"')");
  			//JOptionPane.showMessageDialog(null,"Ajout du "+jgrade.getText()+" "+jprenom.getText()+" "+jnom.getText()+" reussit","Information",JOptionPane.INFORMATION_MESSAGE);
  			 System.out.println (count +" rows were inserted");
  		}
  		ResultSet result1 = s. executeQuery( "SELECT * FROM Consultation");
  		int count1=0;
  		while( result1.next( ) )
  		 {
  			 count1++;
  			 //count=result.getInt("nomMat");
  			 System.out.println(count1);
  			 
  		 }
  		 count1++;
  		consulation=count1;
  		count = s.executeUpdate ( "INSERT INTO Consultation (Numero,Date,Consulte_Medecin_Matricule,Consulte_Patient_Num_ss)"
  				 + " VALUES"
  				 + "('"+count1+"','"+a+"','"+Principal.Mmatricul+"','"+Principal.num_ss+"')");
  		//JOptionPane.showMessageDialog(null,"Ajout du "+jgrade.getText()+" "+jprenom.getText()+" "+jnom.getText()+" reussit","Information",JOptionPane.INFORMATION_MESSAGE);
  		 System.out.println (count +" rows were inserted");
  		 
  		
   		 //result1. close( ) ;
   		 s. close( );
   		 
  		 }
   		catch(Exception ex) {
   		 System.err.println("Exception: nnnn" + ex.getMessage());
   		 //JOptionPane.showMessageDialog(null,"insertion echouer","Information",JOptionPane.INFORMATION_MESSAGE);
   		 } finally {
   		 try {
   		 if (con != null)
   		 con.close();
   		 } catch(SQLException ex) {}
   		 }
         

    }
    public String NomPatient()
    {
    	int j=0;
     	
     	Connection con = null;
  		 try {
  		 Class.forName("com.mysql.jdbc.Driver").newInstance();
  		 con = (Connection)DriverManager.getConnection("jdbc:mysql://localhost:3306/hopitaldb", "root","");
  		 if (!con.isClosed())
  		 System.out.println("Successfully connected to MySQL server here...");
  		Statement s = (Statement) con.createStatement ();
  		int count=0;
  		
  		ResultSet result = s. executeQuery( "SELECT * FROM Patient") ;
  		int tmp=0;
  		 while(result.next())
  		 {
  			 count++;
  			 if(result.getString("Num_ss").equals(Principal.num_ss))
  			 {
  				 return ""+result.getString("prenom")+" "+result.getString("nom");
  			 }
  			 
  		 }
  		 
   		 //result1. close( ) ;
   		 s. close( );
   		 
  		 }
   		catch(Exception ex) {
   		 System.err.println("Exception: nnnn" + ex.getMessage());
   		 //JOptionPane.showMessageDialog(null,"insertion echouer","Information",JOptionPane.INFORMATION_MESSAGE);
   		 } finally {
   		 try {
   		 if (con != null)
   		 con.close();
   		 } catch(SQLException ex) {
                      // JOptionPane.showMessageDialog(null,"insertion echouer","Information",JOptionPane.INFORMATION_MESSAGE);

                 }
   		 }
         return "";

  		
      
    }

    public void pdf()
    {
    	MessageFormat header=new MessageFormat("Ordonnance de "+NomPatient());
    	Date a =new Date();
    	Date date1=new Date();
    	MessageFormat footer=new MessageFormat("GESTION CONSULTATION FAIT LE "+date1);
    	
    	
        try {
        	jTable1.print(JTable.PrintMode.FIT_WIDTH,header,footer);
         
        } catch (Exception e) {
          System.err.println(e.getMessage());
        }
    }
    
    public static void main(String[] args) {
        // TODO code application logic here
        
        Consulter con=new Consulter();
        con.setVisible(true);
    }
 private void jLabel8MouseClicked(MouseEvent evt) {
     this.setState(javax.swing.JFrame.ICONIFIED);
     
           }
  private void jLabel7MouseClicked(MouseEvent evt) {
      int a=JOptionPane.showConfirmDialog(null,"Vous etes sur de vouloir déconnecter?"," Question",JOptionPane.YES_NO_OPTION);
	if(a==0)
            {
    	index ajp=new index();
        ajp.setVisible(true);
        ajp.setLocationRelativeTo(null);
        ajp.setDefaultCloseOperation(javax.swing.JFrame.EXIT_ON_CLOSE);
        this.dispose();
		}
           }
    @Override
    public void actionPerformed(ActionEvent e) {
        
        if(e.getSource()==ConsultPat){
            JFrame fen=new JFrame();
		String niveau;
		niveau=(String) JOptionPane.showInputDialog(fen,"Veuillez choisir une option ","liste des patients",JOptionPane.INFORMATION_MESSAGE,null,classesL,"  ");	
		System.out.println("le patient choisit est  "+niveau);
		String[] num=niveau.split(" ");
		
		Principal.num_ss=num[0];
        Consulter ajp=new Consulter();
        ajp.setVisible(true);
        ajp.setLocationRelativeTo(null);
        ajp.setDefaultCloseOperation(javax.swing.JFrame.EXIT_ON_CLOSE);
        this.dispose();
        }
        if(e.getSource()==ListPatConsute){
            JFrame fen=new JFrame();
		String niveau=(String) JOptionPane.showInputDialog(fen,"Veuillez choisir une option ","liste des patients",JOptionPane.INFORMATION_MESSAGE,null,historque,"  ");			
		if(niveau.equals("liste des patients"))
		{
			ListePatient ajp=new ListePatient();
	        ajp.setVisible(true);
	        ajp.setLocationRelativeTo(null);
	        ajp.setDefaultCloseOperation(javax.swing.JFrame.EXIT_ON_CLOSE);
	        this.dispose();
		}
		if(niveau.equals("historique des consultations des patients"))
		{
			String niveau1=(String) JOptionPane.showInputDialog(fen,"Veuillez choisir une option ","liste des patients",JOptionPane.INFORMATION_MESSAGE,null,classesL,"  ");	
			System.out.println("le patient choisit est  "+niveau);
			String[] num=niveau1.split(" ");
			Principal.num_ss=num[0];
			HistoriquePatient ajp=new HistoriquePatient();
	        ajp.setVisible(true);
	        ajp.setLocationRelativeTo(null);
	        ajp.setDefaultCloseOperation(javax.swing.JFrame.EXIT_ON_CLOSE);
	        this.dispose();
		}
        }
        
        if(e.getSource()==enregistrer){
            int tmp=0;
    	for (int i = 0; i < medi.length; i++) {
    		if(jComboBox1.getSelectedItem().toString().equals(medi[i]))
    			tmp=1;
		}
    	if(tmp==0)
    	{
	    	requete(jComboBox1.getSelectedItem().toString(),ia,0);
	    	ia++;
	    	medi[at]=jComboBox1.getSelectedItem().toString();
	    	nbrejours[at]=jComboBox4.getSelectedItem().toString();
	    	quantite[at]=jComboBox2.getSelectedItem().toString();
	    	at++;
    	}
    	else{
    		
			JOptionPane.showMessageDialog(null,"Vous avez deja choisit le médicament","ERREUR !",JOptionPane.ERROR_MESSAGE);
    	}
        }
        
        if(e.getSource()==valider){
            
            Connection con = null;
		 try {
			 Class.forName("com.mysql.jdbc.Driver").newInstance();
			 con = (Connection)DriverManager.getConnection("jdbc:mysql://localhost:3306/hopitaldb", "root","");
			 if (!con.isClosed())
			 System.out.println("Successfully connected to MySQL server...");
			Statement s = (Statement) con.createStatement ();
			 int count=0;
                          ResultSet result1 = s. executeQuery( "SELECT * FROM Consultation");
		  		int count1=0;
		  		Date a = new Date();
		  		while( result1.next( ) )
		  		 {
		  			 count1++;
		  			 //count=result.getInt("nomMat");
		  			 System.out.println(count1);
		  			 
		  		 }
		  		 count1++;
		  		consulation=count1;
		  		count = s.executeUpdate ( "INSERT INTO Consultation (Numero,Date,Consulte_Medecin_Matricule,Consulte_Patient_Num_ss)"
		  				 + " VALUES"
		  				 + "('"+count1+"','"+a+"','"+Principal.Mmatricul+"','"+Principal.num_ss+"')");
		  		 System.out.println (count +" rows were inserted");
		  		 
		  		
		   		 //result1. close( ) ;
		  		 for (int i = 0; i < at; i++) {
		  			count = s.executeUpdate ( "INSERT INTO Prescrit (Nombre_de_jour,Medicament_code,Consultation_Numero)"
			  				 + " VALUES"+ "('"+nbrejours[i]+"','"+codeMedicament(medi[i])+"','"+consulation+"')");
					
				}
		  		
		  			
		   		 s. close( );
		   		System.out.println("Bonjour comment vous allez!");
				JOptionPane.showMessageDialog(null,"Prescription de l'ordonnance reussit","Information",JOptionPane.INFORMATION_MESSAGE);
				int c=JOptionPane.showConfirmDialog(null,"Imprimer l'ordonnance?"," Question",JOptionPane.YES_NO_OPTION);
		    	if(c==0)
		    	{
		    		pdf();
		    	}
				Consulter ajp=new Consulter();
		        ajp.setVisible(true);
		        ajp.pack();
		        ajp.setLocationRelativeTo(null);
		        ajp.setDefaultCloseOperation(javax.swing.JFrame.EXIT_ON_CLOSE);
		        this.dispose();
   }
  		catch(Exception ex) {
     		 System.err.println("Exception: nnnn" + ex.getMessage());
     		 JOptionPane.showMessageDialog(null,"insertion echouer","Information",JOptionPane.INFORMATION_MESSAGE);
     		 } finally {
     			JFrame.setDefaultLookAndFeelDecorated(true);
				JDialog.setDefaultLookAndFeelDecorated(true);
     		 try {
     		 if (con != null)
     		 con.close();
     		 } catch(SQLException ex) {

                 }
     		 }
        }
        if(e.getSource()==supprimer){}
        
        if(e.getSource()==annuler){
            
        }
        
        if(e.getSource()==retour){
                Principal ajp=new Principal();
            ajp.setVisible(true);
            ajp.setLocationRelativeTo(null);
            ajp.setDefaultCloseOperation(javax.swing.JFrame.EXIT_ON_CLOSE);
            this.dispose();
        }
        
    }
}
