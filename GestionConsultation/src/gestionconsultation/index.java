/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gestionconsultation;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;

/**
 *
 * @author Utilisateur
 */
public class index extends JFrame implements ActionListener{

    /**
     * @param args the command line arguments
     */
    private JButton apropos;
    private JButton jButtoncon;
    private JButton jButton2;
    private JLabel entete;
    private JLabel jLabel2;
    private JLabel jLabelcon;
    private JLabel jLabelmdp;
    private JLabel jLabelid;
    private JLabel jLabel7;
    private JLabel jLabelClose;
    private JLabel jLabelMin;
    private JPanel jPanel1;
    private JPanel jPanel2;
    private JPanel jPanel3;
    private JPanel jPanel4;
    private JPanel jPanel5;
    private JPasswordField motPasse;
    private JTextField id;
    
    protected static String matricule;
    
    public index() {
        this.setSize(900,600);
        Container contenu=this.getContentPane();
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setUndecorated(true);
        setLocationRelativeTo(null);
        
        jPanel1 = new JPanel();
        entete = new JLabel();
        jPanel2 = new JPanel();
        jPanel5 = new JPanel();
        jButton2 = new JButton();
        jLabel7 = new JLabel();
        apropos = new JButton();
        jPanel3 = new JPanel();
        jLabelcon = new JLabel();
        jLabelmdp = new JLabel();
        jLabelid = new JLabel();
        id = new JTextField();
        jButtoncon = new JButton();
        motPasse = new JPasswordField();
        jLabel2 = new JLabel();
        jPanel4 = new JPanel();
        jLabelClose = new JLabel();
        jLabelMin = new JLabel();
        
        jPanel1.setBackground(new Color(44, 62, 80));
        
        entete.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        entete.setForeground(new java.awt.Color(0, 204, 204));
        entete.setText("SYSTEME DE GESTION DES CONSULTATIONS");
        
        GroupLayout jPanel1Layout=new GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(entete,GroupLayout.PREFERRED_SIZE,460,GroupLayout.PREFERRED_SIZE)
                .addGap(217, 217, 217))
                );
         jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(entete, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel2.setBackground(new java.awt.Color(44, 62, 80));

        jPanel5.setBackground(new java.awt.Color(44, 62, 80));

        jButton2.setIcon(new ImageIcon("image/med.jpg"));
        jLabel7.setBackground(new Color(102, 255, 255));
        jLabel7.setFont(new Font("Algerian", 2, 30)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 204, 204));
        jLabel7.setText("HOPITAL FATIM SAMB");

        apropos.setBackground(new java.awt.Color(0, 204, 204));
        apropos.setFont(new Font("Tahoma", 2, 24));
        apropos.setText("A propos de l'application");
        
        GroupLayout jPanel5Layout = new GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addComponent(jLabel7,GroupLayout.DEFAULT_SIZE,GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addComponent(jButton2,GroupLayout.PREFERRED_SIZE,350,GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(65, 65, 65)
                .addComponent(apropos)
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addComponent(jButton2, GroupLayout.PREFERRED_SIZE, 350,GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel7,GroupLayout.DEFAULT_SIZE, 60, Short.MAX_VALUE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(apropos, GroupLayout.PREFERRED_SIZE, 80,GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        GroupLayout jPanel2Layout = new GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addComponent(jPanel5, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel5, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel3.setBackground(new Color(44, 62, 80));

        jLabelcon.setFont(new Font("Tahoma", 3, 48)); // NOI18N
        jLabelcon.setForeground(new Color(0, 204, 204));
        jLabelcon.setText("Connexion");

        jLabelmdp.setFont(new Font("Tahoma", 1, 24)); // NOI18N
        jLabelmdp.setForeground(new Color(255, 255, 255));
        jLabelmdp.setText("Mot de passe");

        jLabelid.setFont(new Font("Tahoma", 1, 24)); // NOI18N
        jLabelid.setForeground(new Color(255, 255, 255));
        jLabelid.setText("Identifiant ");

        id.setBackground(new Color(204, 204, 204));
        id.setFont(new Font("Tahoma", 1, 18)); // NOI18N

        jButtoncon.setBackground(new Color(0, 204, 204));
        jButtoncon.setFont(new Font("Tahoma", 3, 24)); // NOI18N
        jButtoncon.setForeground(new Color(44, 62, 80));
        jButtoncon.setText("Connexion");
        
        motPasse.setBackground(new java.awt.Color(204, 204, 204));
        motPasse.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 28)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 0, 0));
        jLabel2.setText("");
        
        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelid)
                    .addComponent(jLabelmdp))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 67, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(id, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(motPasse, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(90, 90, 90))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(200, 200, 200)
                        .addComponent(jLabelcon, javax.swing.GroupLayout.PREFERRED_SIZE, 287, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addComponent(jLabel2)))
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jButtoncon, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addComponent(jLabelcon)
                .addGap(56, 56, 56)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(id, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelid, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(motPasse, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelmdp, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(55, 55, 55)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButtoncon, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(90, 90, 90))
        );

        jPanel4.setBackground(new java.awt.Color(0, 153, 153));

        jLabelClose.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabelClose.setForeground(new java.awt.Color(255, 0, 0));
        jLabelClose.setText("FERMER");
        jLabelClose.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jLabelClose.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelCloseMouseClicked(evt);
            }

             });
        jLabelMin.setBackground(new java.awt.Color(255, 255, 255));
        jLabelMin.setFont(new java.awt.Font("Tahoma", 1, 48)); // NOI18N
        jLabelMin.setForeground(new java.awt.Color(153, 153, 153));
        jLabelMin.setText("-");
        jLabelMin.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelMinMouseClicked(evt);
            }

           
        });
        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(30, Short.MAX_VALUE)
                .addComponent(jLabelMin, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(jLabelClose)
                .addGap(20, 20, 20))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(20, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelMin, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelClose))
                .addContainerGap())
        );
        
        GroupLayout layout = new GroupLayout(contenu);
        contenu.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3,530, 530, 530))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        
        
        jButtoncon.addActionListener(this);
        

       
    }
    public static void main(String[] args) {
        // TODO code application logic here
        index i=new index();
        i.setVisible(true);
        
    }
 private void jLabelMinMouseClicked(MouseEvent evt) {
               // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                this.setState(javax.swing.JFrame.ICONIFIED);
            }
  private void jLabelCloseMouseClicked(MouseEvent evt) {
                //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                System.exit(0);
               
            }
    @Override
    public void actionPerformed(ActionEvent e) {
        
        if(e.getSource()==jButtoncon)
        {
         
            Connection con = null;
		 try {
                       if(id.getText().equals("") && motPasse.getText().equals("") )
                        { 
                            jLabel2.setFont(new java.awt.Font("Tahoma", 1, 22)); // NOI18N
                            jLabel2.setForeground(new java.awt.Color(254,0,0));
                            jLabel2.setText("Veuillez remplir tous les champs");
                        }
                       else{
		 Class.forName("com.mysql.jdbc.Driver").newInstance();
		 con = (Connection)DriverManager.getConnection("jdbc:mysql://localhost:3306/hopitaldb", "root","");
		 if (!con.isClosed())
		 System.out.println("Successfully connected to MySQL server...");
		 
		 System.out.println(motPasse.getText() );
		//Création d'un objet Statement
		 Statement state = (Statement) con.createStatement( ) ;
		 //L'objet ResultSet contient le résultat de la requéte SQL
		 ResultSet result1 = state. executeQuery( "SELECT * FROM Medecin") ;
		 String log=id.getText();
		 String psw=motPasse.getText();
		 while( result1. next( ) ){
			 
		
			 String  lo=result1.getString("Matricule");
			 String ps=result1.getString("motdp");
			 if(log.equals(lo)&& psw.equals(ps))
			 {
				 if(result1.getString("fonction").equals("Médecin") || result1.getString("fonction").equals("Médecin chef") || result1.getString("fonction").equals("Médecin généraliste"))
				 {
					 Principal.matricule= lo;
					 System.out.println("Identification reussit");
					 Principal ajp=new Principal();
				        ajp.setVisible(true);
				        ajp.setLocationRelativeTo(null);
				        ajp.setDefaultCloseOperation(javax.swing.JFrame.EXIT_ON_CLOSE);
				        this.dispose();
				 }
				 
				 else
					 System.out.println("Erreur dans la base de donn�es");
				 
			 }
			 else
			 {
				jLabel2.setFont(new java.awt.Font("Tahoma", 1, 22)); // NOI18N
                                jLabel2.setForeground(new java.awt.Color(254,0,0));
                                jLabel2.setText("Identifiant ou mot de passe  incorrecte");
			 }
		 }
                       
		 System.out.println(motPasse.getText() );
		 
		 result1. close( ) ;
		 state. close( );
		 }}
		catch(Exception ex) {
		 System.err.println("Exception: " + ex.getMessage());
		 } finally {
		 try {
		 if (con != null)
		 con.close();
		 } catch(SQLException ez) {}
	
		 
	
		 }
    }
            
        }
        
    }

   

