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
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JOptionPane;
import javax.swing.JTable;

/**
 *
 * @author Utilisateur
 */
public class HistoriquePatient extends JFrame implements ActionListener{
private javax.swing.JButton consultPat;
    private javax.swing.JLabel applicationName;
    private javax.swing.JButton retour;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTable3;
    private javax.swing.JButton jimprimer;
    private javax.swing.JButton jvalider;
    private javax.swing.JButton listPatConsult;
    protected static String numero;
    private String classesL[]= new String[25];
    private String[] historque={"liste des patients","historique des consultations des patients"};

    public HistoriquePatient(){
        
        this.setSize(1200,700);
        Container contenu=this.getContentPane();
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setUndecorated(true);
        Consultation(Principal.num_ss);
        historique(Principal.num_ss);
        NomPrenom(Principal.num_ss);
        
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jPanel9 = new javax.swing.JPanel();
        listPatConsult = new javax.swing.JButton();
        consultPat = new javax.swing.JButton();
        retour = new javax.swing.JButton();
        applicationName = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jvalider = new javax.swing.JButton();
        jComboBox1 = new javax.swing.JComboBox();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable3 = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        jimprimer = new javax.swing.JButton();
        
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 300, Short.MAX_VALUE)
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

        listPatConsult.setBackground(new java.awt.Color(102, 102, 102));
        listPatConsult.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        listPatConsult.setText("La liste des patients consultés");
        
        consultPat.setBackground(new java.awt.Color(102, 102, 102));
        consultPat.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        consultPat.setText("Consultation patient");
       
        retour.setBackground(new java.awt.Color(102, 102, 102));
        retour.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        retour.setText("Retour");
       
        applicationName.setFont(new java.awt.Font("Algerian", 2, 24)); // NOI18N
        applicationName.setIcon(new javax.swing.ImageIcon("image\\nom.png")); // NOI18N
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
                            .addComponent(listPatConsult, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 333, Short.MAX_VALUE)
                            .addComponent(consultPat, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(retour, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addComponent(applicationName, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(39, 39, 39)
                .addComponent(consultPat, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(120, 120, 120)
                .addComponent(listPatConsult, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(120, 120, 120)
                .addComponent(retour, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1.setBackground(new java.awt.Color(44, 62, 80));
        jPanel1.setForeground(new java.awt.Color(204, 255, 204));

        jLabel2.setFont(new java.awt.Font("Tahoma", 3, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(204, 255, 204));
        jLabel2.setText("Liste des consultations du patient");

        jvalider.setBackground(new java.awt.Color(255, 255, 255));
        jvalider.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jvalider.setText("VALIDER");
       
        
        jTable3.setFont(new java.awt.Font("Tahoma", 3, 14)); // NOI18N
        jTable3.setForeground(new java.awt.Color(0,0,0));
        jTable3.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "numero", "Date", "Médecin", "Médicament"
            }
        ));
        jTable3.setToolTipText(",k,kd,kzd,");
        jTable3.setRowHeight(40);
        jScrollPane3.setViewportView(jTable3);

        jLabel3.setFont(new java.awt.Font("Tahoma", 3, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(204, 255, 204));
        jLabel3.setText("Consultation");

        jimprimer.setIcon(new javax.swing.ImageIcon("image\\240_F_35848713_UGFdny2XHL5t7ssyJBx5YJwNGXENCHeW.jpg")); // NOI18N
        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addComponent(jScrollPane3)
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 338, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jimprimer, javax.swing.GroupLayout.PREFERRED_SIZE, 246, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(15,15,15)
                        .addComponent(jvalider, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(155, 155, 155))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(20, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jimprimer))
                .addGap(39, 39, 39)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jvalider, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 525, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE)
                .addGap(6, 6, 6)
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE,120, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 600, Short.MAX_VALUE))
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
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        listPatConsult.addActionListener(this);
        consultPat.addActionListener(this);
        retour.addActionListener(this);
        jvalider.addActionListener(this);

    }
      private void jLabel7MouseClicked(MouseEvent evt) {
            }
        private void jLabel8MouseClicked(MouseEvent evt) {
            }
    public static void main(String[] args) {
        // TODO code application logic here
        HistoriquePatient ajp=new HistoriquePatient();
        ajp.setVisible(true);
    }
     public void Consultation(String num_ss)
    {
    	int j=0;
        // System.out.println(jnom.getText() +" "+jprenom.getText()+" "+jgrade.getText());
     	
     	Connection con = null;
  		 try {
  		 Class.forName("com.mysql.jdbc.Driver").newInstance();
  		 con = (Connection)DriverManager.getConnection("jdbc:mysql://localhost:3306/hopitaldb", "root","");
  		 if (!con.isClosed())
  		 System.out.println("Successfully connected to MySQL server here...");
  		Statement s = (Statement) con.createStatement ();
  		int count=0;
  		ResultSet result = s.executeQuery("Select * from prescrit,consultation  where Consulte_Patient_Num_ss='"+num_ss+"' AND Numero=Consultation_Numero");
  		int tmp=0;
  		 while(result.next())
  		 {
  			 jComboBox1.addItem(result.getString("Numero"));
  		 }
  		 
  		Date a=new Date();
  		 int idens=0;
  		 Random r=new Random();
  		 
  		 /*String login=jprenom.getText()+r.nextInt(100);
  		 String mdp=generate(8);*/
  		
  		
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
    public void historique(String num)
	{
		 
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
		 ResultSet result1=state. executeQuery("Select * from patient where num_ss='"+Principal.num_ss+"'");
		 ResultSet result = state. executeQuery("Select * from prescrit,consultation  where Consulte_Patient_Num_ss='"+num+"' AND Numero=Consultation_Numero");
		    int i=0,j=0;
				 while( result. next( ) )
				 {
					
					 System.out.println(i);
					 jTable3.setValueAt(result.getString("Numero"), i,j++ );
					 jTable3.setValueAt(result.getString("Date"), i, j++);
					 jTable3.setValueAt(result.getInt("Consulte_Medecin_Matricule"), i, j++);
					 jTable3.setValueAt(NomMedicament(result.getInt("Medicament_code")), i, j++);
					 i++; 
					 j=0;
					 
				 }
				 result. close( ) ;
				 while( result1. next( ) )
				 {
					 jLabel2.setText("Consultation de "+result1.getString("prenom")+" "+result1.getString("nom"));
				 }
		result1. close( ) ; 
		 
		 
		 //result1. close( ) ;
		 
		 //result1. close( ) ;
		 state. close( );
		 }
		catch(Exception e) {
		 System.err.println("Exception:,," + e.getMessage());
		 } finally {
		 try {
		 if (con != null)
		 con.close();
		 } catch(SQLException e) {}
		 }
		 
    	
    	
    	
	}
    public void NomPrenom(String num)
	{
		 
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
		 ResultSet result1=state. executeQuery("Select * from patient where num_ss='"+Principal.num_ss+"'");
		 
				 while( result1. next( ) )
				 {
					 jLabel2.setText("Consultation de "+result1.getString("prenom")+" "+result1.getString("nom"));
				 }
		result1. close( ) ; 
		 
		 
		 //result1. close( ) ;
		 
		 //result1. close( ) ;
		 state. close( );
		 }
		catch(Exception e) {
		 System.err.println("Exception:,," + e.getMessage());
		 } finally {
		 try {
		 if (con != null)
		 con.close();
		 } catch(SQLException e) {}
		 }
		 
    	
    	
    	
	}
	
	public String  NomMedicament(int code)
	{
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
		 ResultSet result = state. executeQuery( "SELECT * FROM medicament") ;

		 while( result. next( ) )
		 {
			 if (result.getInt("Code")==code)
				 return result.getString("libelle");
			 
		 }
		 result. close( ) ;
		 //result1. close( ) ;
		 state. close( );
		 }
		catch(Exception e) {
		 System.err.println("Exception: " + e.getMessage());
		 } finally {
		 try {
		 if (con != null)
		 con.close();
		 } catch(SQLException e) {}
		 }
		 return req;
		
	}


public void pdf()
{
	MessageFormat header=new MessageFormat("Liste des patients de l'hopital Abdoul Aziz NDIOUCK");
	Date a =new Date();
	MessageFormat footer=new MessageFormat(" Fait le "+a);
	
	
    try {
    		jTable3.print(JTable.PrintMode.FIT_WIDTH,header,footer);

    } catch (Exception e) {
      System.err.println(e.getMessage());
    }
}


    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==listPatConsult){
            JFrame fen=new JFrame();
		String niveau=(String) JOptionPane.showInputDialog(fen,"Veuillez choisir une option ","liste des patients",JOptionPane.INFORMATION_MESSAGE,null,historque,"  ");			
		if(niveau.equals("liste des patients"))
		{
			ListePatient ajp=new ListePatient();
	        ajp.setVisible(true);
	        ajp.pack();
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
        if(e.getSource()==consultPat){
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
        if(e.getSource()==jvalider){
            numero=jComboBox1.getSelectedItem().toString();
            InformationConsultation ajp=new InformationConsultation(numero);
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
