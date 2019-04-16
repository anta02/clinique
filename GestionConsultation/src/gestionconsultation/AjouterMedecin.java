/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gestionconsultation;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import java.util.Random;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JOptionPane;

/**
 *
 * @author Utilisateur
 */
public class AjouterMedecin extends JFrame implements ActionListener{

    private javax.swing.JLabel applicationName;
    private javax.swing.JButton historique;
    private javax.swing.JButton jButtonEnregistrer;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabelClose;
    private javax.swing.JLabel jLabelMin;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JTextField jEmail;
    private javax.swing.JTextField jTel;
    private javax.swing.JComboBox jfonction;
    private javax.swing.JTextField jgrade;
    private javax.swing.JTextField jnom;
    private javax.swing.JTextField jprenom;
    private javax.swing.JButton ajouter;
    private javax.swing.JButton listMed;
    private javax.swing.JButton retour;
    private static final String[]classes=new String[25];
    private static final String[]classesL={"Médicament","Patient","Médecin"};
    
    public AjouterMedecin(){
        requete();
        this.setSize(1300,700);
        Container contenu=this.getContentPane();
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setUndecorated(true);
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabelMin = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        jLabelClose = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jnom = new javax.swing.JTextField();
        jprenom = new javax.swing.JTextField();
        jgrade = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jEmail = new javax.swing.JTextField();
        jTel = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jButtonEnregistrer = new javax.swing.JButton();
        jfonction = new javax.swing.JComboBox();
        jPanel9 = new javax.swing.JPanel();
        listMed = new javax.swing.JButton();
        ajouter = new javax.swing.JButton();
        historique = new javax.swing.JButton();
        applicationName = new javax.swing.JLabel();
        retour = new javax.swing.JButton();
        
        jPanel2.setBackground(new java.awt.Color(204, 255, 204));
        jPanel2.setForeground(new java.awt.Color(51, 51, 255));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel1.setText("GESTION CONSULTATION ");

        jLabelMin.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabelMin.setText("-");
        jLabelMin.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelMinMouseClicked(evt);
            }

           
        });
        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(79, 79, 79)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 816, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabelMin)
                .addGap(15, 15, 15))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(jLabelMin, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel7.setBackground(new java.awt.Color(204, 0, 0));

        jLabelClose.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabelClose.setForeground(new java.awt.Color(255, 255, 255));
        jLabelClose.setText("Deconnexion ");
        jLabelClose.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelCloseMouseClicked(evt);
            }

           
        });
        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabelClose, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 98, Short.MAX_VALUE)
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelClose, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel4.setBackground(new java.awt.Color(153, 153, 153));

        jnom.setFont(new java.awt.Font("Tahoma", 3, 18)); // NOI18N

        jprenom.setFont(new java.awt.Font("Tahoma", 3, 18)); // NOI18N
       
        jgrade.setFont(new java.awt.Font("Tahoma", 3, 18)); // NOI18N

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(102, 255, 102));
        jLabel2.setText("AJOUTER MEDECIN");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("NOM");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("PRENOM");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("GRADE");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("FONCTION");

        jEmail.setFont(new java.awt.Font("Tahoma", 3, 18)); // NOI18N
        

        jTel.setFont(new java.awt.Font("Tahoma", 3, 18)); // NOI18N

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("EMAIL");

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("TELEPHONE");

        jButtonEnregistrer.setBackground(new java.awt.Color(153, 255, 153));
        jButtonEnregistrer.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButtonEnregistrer.setText("Enregistrer");
        
        jfonction.setFont(new java.awt.Font("Tahoma", 3, 18)); // NOI18N
        jfonction.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Médecin", "Médecin chef","Médecin généraliste" }));

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(167, 167, 167)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 434, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 243, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addGap(66, 66, 66)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jfonction, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jgrade))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jprenom))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jnom, javax.swing.GroupLayout.PREFERRED_SIZE, 302, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jTel))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jEmail)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButtonEnregistrer, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(129, 129, 129))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jnom, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(35, 35, 35)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jprenom, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(46, 46, 46)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jgrade, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(49, 49, 49)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jfonction, javax.swing.GroupLayout.DEFAULT_SIZE, 32, Short.MAX_VALUE))
                .addGap(62, 62, 62)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(44, 44, 44)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTel, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButtonEnregistrer, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel9.setBackground(new java.awt.Color(204, 255, 204));
        jPanel9.setBorder(javax.swing.BorderFactory.createCompoundBorder());

        listMed.setBackground(new java.awt.Color(102, 102, 102));
        listMed.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        listMed.setText("Liste des médecins");
       
        ajouter.setBackground(new java.awt.Color(102, 102, 102));
        ajouter.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        ajouter.setForeground(new java.awt.Color(51, 255, 51));
        ajouter.setText("Ajouter medecin/medicament/patient");
        
        historique.setBackground(new java.awt.Color(102, 102, 102));
        historique.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        historique.setText("Historique des médecins");
        

        applicationName.setFont(new java.awt.Font("Algerian", 2, 42)); // NOI18N
        applicationName.setText("hostipal 2.0");

        retour.setBackground(new java.awt.Color(102, 102, 102));
        retour.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        retour.setForeground(new java.awt.Color(255, 255, 255));
        retour.setText("Retour");
        

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(listMed, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(ajouter, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(historique, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(retour, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(applicationName, javax.swing.GroupLayout.PREFERRED_SIZE, 308, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(applicationName, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(ajouter, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(82, 82, 82)
                .addComponent(listMed, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(77, 77, 77)
                .addComponent(historique, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(49, 49, 49)
                .addComponent(retour, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(48, Short.MAX_VALUE))
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
                .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(6, 6, 6)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(6, 6, 6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        listMed.addActionListener(this);
        ajouter.addActionListener(this);
        retour.addActionListener(this);
        jButtonEnregistrer.addActionListener(this);
        historique.addActionListener(this);
    }
    
    public String requete(){
	    
    	String req=null;
    	Connection con = null;
		 try {
		 Class.forName("com.mysql.jdbc.Driver").newInstance();
		 con = (Connection)DriverManager.getConnection("jdbc:mysql://localhost:3306/hopitaldb", "root","");
		 if (!con.isClosed())
		 System.out.println("Successfully connected to MySQL server...");
		 
		//Création d'un objet Statement
		 Statement state = (Statement) con.createStatement( ) ;
		 //L'objet ResultSet contient le résultat de la requ�te SQL
		 ResultSet result = state. executeQuery("Select * from Medecin");
		    int i=0;
		    
			 while( result. next( ) )
			 {
				 
				 classes[i]=""+result.getString("Matricule")+" "+result.getString("Prenom")+" "+result.getString("Nom");
				 
				 
				i++; 
			 }
			 
		 state. close( );
		 }
		catch(Exception e) {
		 System.err.println("Exception:,,, " + e.getMessage());
		 } finally {
		 try {
		 if (con != null)
		 con.close();
		 } catch(SQLException e) {}
		 }
		 
    	
    	
    	return req;
    }
     public String generate(int length) {
	    String chars = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890"; // Tu supprimes les lettres dont tu ne veux pas
	    String pass = "";
	    for(int x=0;x<length;x++)   {
	       int i = (int)Math.floor(Math.random() * chars.length() -1); // Si tu supprimes des lettres tu diminues ce nb
	       pass += chars.charAt(i);
	    }
	    System.out.println(pass);
	    return pass;
      }
    public static void main(String[] args) {
        // TODO code application logic here
        AjouterMedecin am=new AjouterMedecin();
        am.setVisible(true);
    }
     private void jLabelMinMouseClicked(MouseEvent evt) {
                //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
           this.setState(javax.swing.JFrame.ICONIFIED);
     }
 private void jLabelCloseMouseClicked(MouseEvent evt) {
                //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
       int a= JOptionPane.showConfirmDialog(null,"Vous etes sur de vouloir déconnecter?"," Question",JOptionPane.YES_NO_OPTION);
       if(a==0){
        index ajp=new index();
        ajp.setVisible(true);
        this.dispose();
       }
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==ajouter){
            JFrame fen=new JFrame();
		String niveau;
		niveau=(String) JOptionPane.showInputDialog(fen,"Veuillez choisir une option ","liste des options",JOptionPane.INFORMATION_MESSAGE,null,classesL,"Licence 1");	
		if(niveau=="Médicament"){
			AjouterMedicament ajp=new AjouterMedicament();
                    ajp.setVisible(true);
                    ajp.setLocationRelativeTo(null);
                    ajp.setDefaultCloseOperation(javax.swing.JFrame.EXIT_ON_CLOSE);
                    this.dispose();
		}
		if(niveau=="Médecin"){
			AjouterMedecin ajp=new AjouterMedecin();
                    ajp.setVisible(true);
                    ajp.setLocationRelativeTo(null);
                    ajp.setDefaultCloseOperation(javax.swing.JFrame.EXIT_ON_CLOSE);
                    this.dispose();
		}
		if(niveau=="Patient"){
			AjouterPatient ajp=new AjouterPatient();
                    ajp.setVisible(true);
                    ajp.setLocationRelativeTo(null);
                    ajp.setDefaultCloseOperation(javax.swing.JFrame.EXIT_ON_CLOSE);
                    this.dispose();
		}
        }
        
        //bouton pour enregistrer un médecin
        if(e.getSource()==jButtonEnregistrer){
            Connection con = null;
		 try {
		 Class.forName("com.mysql.jdbc.Driver").newInstance();
		 con = (Connection)DriverManager.getConnection("jdbc:mysql://localhost:3306/hopitaldb", "root","");
		 if (!con.isClosed())
		 System.out.println("Successfully connected to MySQL server...");
		Statement s = con.createStatement ();
		int count=0;
		
		ResultSet result = s. executeQuery( "SELECT nom FROM Medecin ") ;
		
		 while( result. next( ) )
		 {
			 count++;
			 //count=result.getInt("nomMat");
			 System.out.println(count);
			 
		 }
		 Date a= new Date();
		 
		 int idens=0;
		 Random r=new Random();
		 
		 String login=jprenom.getText()+r.nextInt(100);
		 String mdp=generate(8);
		
		count = s.executeUpdate ( "INSERT INTO Medecin (Matricule,Nom,prenom,grade,fonction,email,telephone,motdp,avatar)"
		 + " VALUES"
		 + "('"+count+15000+"','"+jnom.getText()+"','"+jprenom.getText()+"','"+jgrade.getText()+"','"+jfonction.getSelectedItem().toString()+"','"+jEmail.getText()+"','"+jTel.getText()+"','"+mdp+"','"+login+"')");
		JOptionPane.showMessageDialog(null,"Ajout de "+" "+jprenom.getText()+" "+jnom.getText()+" reussit","Information",JOptionPane.INFORMATION_MESSAGE);
		AjouterMedecin ajp=new AjouterMedecin();
                ajp.setVisible(true);
                ajp.setLocationRelativeTo(null);
                ajp.setDefaultCloseOperation(javax.swing.JFrame.EXIT_ON_CLOSE);
                this.dispose();
		 System.out.println (count +" rows were inserted");
		 
		
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

        }
        if(e.getSource()==listMed){
            ListeMedecin ajp=new ListeMedecin();
            ajp.setVisible(true);
            ajp.setLocationRelativeTo(null);
            ajp.setDefaultCloseOperation(javax.swing.JFrame.EXIT_ON_CLOSE);
            this.dispose();
        }
        
        if(e.getSource()==historique){
            JFrame fen=new JFrame();
            String niveau1=(String) JOptionPane.showInputDialog(fen,"Veuillez choisir une option ","liste des Medecin",JOptionPane.INFORMATION_MESSAGE,null,classes,"  ");	
		String[] num=niveau1.split(" ");
		Principal.matriculeother=num[0];
		HistoriqueMedecin ajp=new HistoriqueMedecin();
            ajp.setVisible(true);
            ajp.setLocationRelativeTo(null);
            ajp.setDefaultCloseOperation(javax.swing.JFrame.EXIT_ON_CLOSE);
            this.dispose();
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
