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
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JOptionPane;
import javax.swing.JTable;

/**
 *
 * @author Utilisateur
 */
public class ListePatient extends JFrame implements ActionListener{

    private javax.swing.JButton consutPat;
    private javax.swing.JLabel applicationName;
    private javax.swing.JButton retour;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JButton listPat;
    private String classesL[]= new String[25];
    private String[] historque={"liste des patients","historique des consultations des patients"};
    
    public ListePatient(){
        requete();
        requete1();
        this.setSize(1200,700);
        Container contenu=this.getContentPane();
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setUndecorated(true);
        
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jPanel9 = new javax.swing.JPanel();
        listPat = new javax.swing.JButton();
        consutPat = new javax.swing.JButton();
        retour = new javax.swing.JButton();
        applicationName = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jButton4 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        
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
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 900, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 22)); // NOI18N
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

        listPat.setBackground(new java.awt.Color(102, 102, 102));
        listPat.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        listPat.setText("La liste des patients de l'hopital");
        listPat.setForeground(new java.awt.Color(204, 255, 204));
       
        consutPat.setBackground(new java.awt.Color(102, 102, 102));
        consutPat.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        consutPat.setText("Consulter un patient");

        retour.setBackground(new java.awt.Color(102, 102, 102));
        retour.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        retour.setForeground(new java.awt.Color(0, 0, 0));
        retour.setText("Retour");

        applicationName.setFont(new java.awt.Font("Algerian", 2, 36)); // NOI18N
        applicationName.setIcon(new javax.swing.ImageIcon("image\\nom.png")); // NOI18N
        applicationName.setText("hostipal 2.0");

        jPanel4.setBackground(new java.awt.Color(153, 153, 153));

        jButton4.setBackground(new java.awt.Color(153, 255, 153));
        jButton4.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton4.setIcon(new javax.swing.ImageIcon("image\\240_F_35848713_UGFdny2XHL5t7ssyJBx5YJwNGXENCHeW.jpg")); // NOI18N
        
        jTable1.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
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
                "CNI", "Prénom Nom", "Adresse", "Téléphone"
            }
        ));
        jTable1.setGridColor(new java.awt.Color(102, 255, 102));
        jTable1.setMaximumSize(new java.awt.Dimension(2147483647, 96));
        jTable1.setMinimumSize(new java.awt.Dimension(60, 960));
        jTable1.setRowHeight(45);
        jScrollPane1.setViewportView(jTable1);
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
		 ResultSet result = state. executeQuery("Select * from patient");
		    int i=0,j=0;
				 while( result. next( ) )
				 {
					 jTable1.setValueAt(result.getString("Num_ss"), i,j++ );
					 jTable1.setValueAt(result.getString("Nom")+" "+result.getString("prenom"), i, j++);
					 jTable1.setValueAt(result.getString("Adresse"), i, j++);
					 jTable1.setValueAt(result.getInt("telephone"), i, j++);
					 
					 i++;
					 j=0;
					 
					 
					 System.out.println(req);
					 
					 
				 }
		 
		 result. close( ) ;
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
		 

        jLabel3.setFont(new java.awt.Font("Algerian", 3, 36)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(102, 255, 102));
        jLabel3.setText("Liste des patients");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap(114, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addGap(80, 80, 80)
                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE,700, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(65, 65, 65)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(720, Short.MAX_VALUE))
            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                    .addGap(0, 131, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 713, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(applicationName, javax.swing.GroupLayout.PREFERRED_SIZE, 389, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel9Layout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(consutPat, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(listPat, javax.swing.GroupLayout.PREFERRED_SIZE, 379, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(retour, javax.swing.GroupLayout.PREFERRED_SIZE, 379, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 22, Short.MAX_VALUE)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addComponent(applicationName, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(39, 39, 39)
                .addComponent(consutPat, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(120, 120, 120)
                .addComponent(listPat, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(120, 120, 120)
                .addComponent(retour, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(contenu);
        contenu.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE,1200, Short.MAX_VALUE)
                .addGap(6, 6, 6)
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE,1200, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE,1200, javax.swing.GroupLayout.PREFERRED_SIZE)
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
                .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        consutPat.addActionListener(this);
        listPat.addActionListener(this);
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
		 ResultSet result = state. executeQuery("Select * from patient");
		    int i=0;
		    
			 while( result. next( ) )
			 {
				 
				 classesL[i]=""+result.getString("Num_ss")+" "+result.getString("Prenom")+" "+result.getString("Nom");
				 
				 System.out.println(req);
				 
				i++; 
			 }
			 
		 result. close( ) ;
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
		 ResultSet result = state. executeQuery("Select * from patient");
		    int i=0,j=0;
				 while( result. next( ) )
				 {
					 jTable1.setValueAt(result.getString("Num_ss"), i,j++ );
					 jTable1.setValueAt(result.getString("Nom")+" "+result.getString("prenom"), i, j++);
					 jTable1.setValueAt(result.getString("Adresse"), i, j++);
					 jTable1.setValueAt(result.getInt("telephone"), i, j++);
					 
					 i++;
					 j=0;
					 
					 
					 System.out.println(req);
					 
					 
				 }
		 
		 result. close( ) ;
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
public void pdf()
{
	MessageFormat header=new MessageFormat("Liste des patients de l'hopital Fatim Sambe");
	Date a =new Date();
	MessageFormat footer=new MessageFormat(" Fait le "+a);
	
	
    try {
    	jTable1.print(JTable.PrintMode.FIT_WIDTH,header,footer);
     
    } catch (Exception e) {
      System.err.println(e.getMessage());
    }
}
    public static void main(String[] args) {
        // TODO code application logic here
        ListePatient ajp=new ListePatient();
        ajp.setVisible(true);
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
        
        if(e.getSource()==consutPat){
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
        if(e.getSource()==listPat){
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
	        ajp.pack();
	        ajp.setLocationRelativeTo(null);
	        ajp.setDefaultCloseOperation(javax.swing.JFrame.EXIT_ON_CLOSE);
	        this.dispose();
		}
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
