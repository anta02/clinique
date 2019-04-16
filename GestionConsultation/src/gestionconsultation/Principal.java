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
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

/**
 *
 * @author Utilisateur
 */
public class Principal extends JFrame implements ActionListener{
   // private javax.swing.JLabel fonction;
    //private javax.swing.JLabel grade;
    private javax.swing.JButton BoutonAjouter;
    private javax.swing.JButton BoutonListeMed;
    private javax.swing.JButton BoutonHistoriqueMed;
    private javax.swing.JButton BoutonHistoriquePat;
    private javax.swing.JButton BoutonConsultPat;
    private javax.swing.JButton jButtonDec;
    private javax.swing.JLabel applicationName;
    private javax.swing.JLabel jLabelEntete;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabelMin;
    private javax.swing.JPanel jPanelEntete;
    private javax.swing.JPanel jPanelGauche;
    private javax.swing.JPanel jPanelCentre;
    private static final String[]classesL={"Médicament","Patient","Médecin"};
    private static final String[]classes=new String[25];
    private String classeP[]= new String[25];
    private String[] historique={"liste des patients","historique des consultations des patients"};
    protected static String matricule;
    protected static String num_ss;
    protected static String matriculeother;
    protected static String Mmatricul;
    
    public Principal(){
        requete();
        requetes();
        donnees(index.matricule);
        Mmatricul=index.matricule;
        this.setSize(1200,700);
        Container contenu=this.getContentPane();
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setUndecorated(true);
        
        jPanelEntete = new javax.swing.JPanel();
        jLabelEntete = new javax.swing.JLabel();
        jLabelMin = new javax.swing.JLabel();
        jPanelGauche = new javax.swing.JPanel();
        jButtonDec = new javax.swing.JButton();
        jPanelCentre = new javax.swing.JPanel();
        BoutonListeMed = new javax.swing.JButton();
        BoutonAjouter = new javax.swing.JButton();
        BoutonHistoriqueMed = new javax.swing.JButton();
        BoutonHistoriquePat = new javax.swing.JButton();
        BoutonConsultPat = new javax.swing.JButton();
        applicationName = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        
        
        jPanelEntete.setBackground(new java.awt.Color(204, 255, 204));
        jPanelEntete.setForeground(new java.awt.Color(51, 51, 255));

        jLabelEntete.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabelEntete.setText("GESTION CONSULTION");
        
        jLabelMin.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabelMin.setText("-");
        jLabelMin.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelMinMouseClicked(evt);
            }

           
        });
        jButtonDec.setBackground(new java.awt.Color(204, 0, 0));
        jButtonDec.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButtonDec.setText("DECONNEXION ");
        
        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanelEntete);
        jPanelEntete.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(79,79,79)
                .addComponent(jLabelEntete,800,800,800)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabelMin)
                .addGap(50,50,50)
                .addComponent(jButtonDec,250,250,250))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(jLabelEntete, 50,50,50)
                .addComponent(jLabelMin, 22, 22,22)
                .addComponent(jButtonDec,67,67,67))
                );
        
        jPanelGauche.setBackground(new java.awt.Color(204, 255, 204));
        jPanelGauche.setBorder(javax.swing.BorderFactory.createCompoundBorder());
        applicationName.setFont(new java.awt.Font("Algerian", 2, 36)); // NOI18N
        applicationName.setIcon(new javax.swing.ImageIcon("image\\nom.png")); // NOI18N
        applicationName.setText("hotipal 2.0");
        
        BoutonListeMed.setBackground(new java.awt.Color(102, 102, 102));
        BoutonListeMed.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        BoutonListeMed.setText("Liste des Médecins");
        
        BoutonAjouter.setBackground(new java.awt.Color(102, 102, 102));
        BoutonAjouter.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        BoutonAjouter.setText("Ajouter medecin/medicament/patient");
        
        BoutonHistoriqueMed.setBackground(new java.awt.Color(102, 102, 102));
        BoutonHistoriqueMed.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        BoutonHistoriqueMed.setText("Historiques des médecins");
        
        BoutonHistoriquePat.setBackground(new java.awt.Color(102, 102, 102));
        BoutonHistoriquePat.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        BoutonHistoriquePat.setText("Historique des patients de l'hopital");
        
        BoutonConsultPat.setBackground(new java.awt.Color(102, 102, 102));
        BoutonConsultPat.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        BoutonConsultPat.setText("Consulter un patient");
         
        
        JLabel icon=new JLabel();
        icon.setIcon(new ImageIcon("image\\consulte.jpg"));
        //jPanelCentre.setBackground(new java.awt.Color(153, 153, 153));
        
        jLabel2.setFont(new java.awt.Font("Algerian	", 1, 45)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(102, 255, 102));
        jLabel2.setText("");
        
        
        jLabel3.setFont(new java.awt.Font("Algerian", 2, 36)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("");

        jLabel4.setFont(new java.awt.Font("Algerian", 2, 36)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("");

        jLabel6.setBackground(new java.awt.Color(102, 255, 51));
        jLabel6.setFont(new java.awt.Font("Algerian", 2, 36)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(102, 255, 0));
        jLabel6.setText("");
        
        
        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanelCentre);
        jPanelCentre.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(icon, javax.swing.GroupLayout.PREFERRED_SIZE, 780, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1))
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(1, 1, 1)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 0, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(128, 128, 128)
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 0, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(75, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(1, 1, 1)
                .addComponent(icon, javax.swing.GroupLayout.PREFERRED_SIZE, 679, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 0, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(147, 147, 147)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 0, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(371, 371, 371))
        );

       javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanelGauche);
       jPanelGauche.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(applicationName, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel9Layout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(BoutonAjouter, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(BoutonHistoriqueMed, javax.swing.GroupLayout.PREFERRED_SIZE, 379, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(BoutonListeMed, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 379, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(BoutonHistoriquePat, javax.swing.GroupLayout.PREFERRED_SIZE, 379, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(BoutonConsultPat, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 379, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 10, Short.MAX_VALUE)
                .addComponent(jPanelCentre,800,800,800))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelCentre,700, 700, 700)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addComponent(applicationName, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(BoutonAjouter, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(BoutonListeMed, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(BoutonConsultPat, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent( BoutonHistoriqueMed, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(BoutonHistoriquePat, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20))
        );

        
        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(contenu);
        contenu.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanelEntete, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(6,6,6)
                .addComponent(jPanelCentre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addComponent(jPanelGauche, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanelEntete, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(2,2,2)
                       .addComponent(jPanelCentre, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanelGauche, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jButtonDec.addActionListener(this);
        BoutonAjouter.addActionListener(this);
        BoutonConsultPat.addActionListener(this);
        BoutonListeMed.addActionListener(this);
        BoutonHistoriqueMed.addActionListener(this);
        BoutonHistoriquePat.addActionListener(this);
   
    }
    
    public static void main(String[] args) {
        Principal p=new Principal();
        p.setVisible(true);
    }
     private void jLabelMinMouseClicked(MouseEvent evt) {
               // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            this.setState(javax.swing.JFrame.ICONIFIED);
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
		 //L'objet ResultSet contient le résultat de la requéte SQL
		 ResultSet result = state. executeQuery("Select * from medecin");
		    int i=0;
		    
			 while( result. next( ) )
			 {
				 
				 classes[i]=""+result.getString("Matricule")+" "+result.getString("Prenom")+" "+result.getString("Nom");
				 
				 
				i++; 
			 }
			 
			 ResultSet result1 = state. executeQuery("Select * from Patient");
			 while( result1. next( ) )
			 {
                              
			 }
		 
                         
		 //result1. close( ) ;
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
public String requetes(){
	    
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
				 
				 classeP[i]=""+result.getString("Num_ss")+" "+result.getString("Prenom")+" "+result.getString("Nom");
				 
				 System.out.println(req);
				 
				i++; 
			 }
			 
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
public void donnees(String matricule){
    	String req=null;
    	Connection con = null;
    	Mmatricul=matricule;
		 try {
		 Class.forName("com.mysql.jdbc.Driver").newInstance();
		 con = (Connection)DriverManager.getConnection("jdbc:mysql://localhost:3306/hopitaldb", "root","");
		 if (!con.isClosed())
		 System.out.println("Successfully connected to MySQL server...");
		
		//Création d'un objet Statement
		 Statement state = (Statement) con.createStatement( ) ;
		 //L'objet ResultSet contient le résultat de la requéte SQL
    	ResultSet result1 = state. executeQuery("Select * from Medecin WHERE Matricule='"+matricule+"'");
		 while( result1. next( ) )
		 {
		
		 }
	 result1. close( ) ;
	 //result1. close( ) ;
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
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        if(e.getSource()==jButtonDec)
        {
          int a=JOptionPane.showConfirmDialog(this,"Vous etes sur de vouloir déconnecter?"," Question",JOptionPane.YES_NO_OPTION);
            if(a==0){
          index i=new index();
            i.setVisible(true);
            this.dispose();
            }
        }
        
        if(e.getSource()==BoutonAjouter){
            JFrame fen=new JFrame();
		String niveau;
		niveau=(String) JOptionPane.showInputDialog(fen,"Veuillez choisir une option ","liste des options",JOptionPane.INFORMATION_MESSAGE,null,classesL,"");	
		
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
        
        if(e.getSource()==BoutonConsultPat){
            requetes();
            JFrame fen=new JFrame();
            String niveau;
            niveau=(String) JOptionPane.showInputDialog(fen,"Veuillez choisir une option ","liste des patients",JOptionPane.INFORMATION_MESSAGE,null,classeP,"  ");	
            String[] num=niveau.split(" ");	
            num_ss=num[0];
            Consulter ajp=new Consulter();
            ajp.setVisible(true);
            ajp.setLocationRelativeTo(null);
            ajp.setDefaultCloseOperation(javax.swing.JFrame.EXIT_ON_CLOSE);
            this.dispose();
        }
        
        if(e.getSource()==BoutonListeMed){
            
        ListeMedecin list=new ListeMedecin();
        list.setVisible(true);
        list.setLocationRelativeTo(null);
        list.setDefaultCloseOperation(javax.swing.JFrame.EXIT_ON_CLOSE);
        this.dispose();
        }
        
        if(e.getSource()==BoutonHistoriqueMed){
           
            JFrame fen=new JFrame();
	

            String niveau1=(String) JOptionPane.showInputDialog(fen,"Veuillez choisir une option ","liste des Médecins",JOptionPane.INFORMATION_MESSAGE,null,classes,"  ");	
		
            String[] num1=niveau1.split(" ");
            matriculeother=num1[0];
            HistoriqueMedecin ajp=new HistoriqueMedecin();
            ajp.setVisible(true);
            ajp.setLocationRelativeTo(null);
            ajp.setDefaultCloseOperation(javax.swing.JFrame.EXIT_ON_CLOSE);
            this.dispose();
        }
        
        if(e.getSource()==BoutonHistoriquePat){
            JFrame fen=new JFrame();
		String niveau=(String) JOptionPane.showInputDialog(fen,"Veuillez choisir une option ","liste des patients",JOptionPane.INFORMATION_MESSAGE,null,historique,"  ");			
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
			
                    String niveau1=(String) JOptionPane.showInputDialog(fen,"Veuillez choisir une option ","liste des patients",JOptionPane.INFORMATION_MESSAGE,null,classeP,"  ");	
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
        
    }
}
