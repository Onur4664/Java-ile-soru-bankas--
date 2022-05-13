
import com.mysql.jdbc.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Onur
 */
public class soruekleme extends javax.swing.JFrame {


    public soruekleme() {
        initComponents();
    }
    
     private void temizle()
    {
        jTextField1.setText(null);
        jTextField2.setText(null);
        jTextField3.setText(null);
        jTextField4.setText(null);
        jTextField5.setText(null);
        jTextField6.setText(null);
        jTextField7.setText(null);
     
       
        
    }

      private void VeriGetir() throws Exception {
                         temizle();
			Connection conn=(Connection) DriverManager.getConnection("jdbc:mysql://localhost/sorubankasi?autoReconnect=true&useSSL=false", "root", "12345");
			Object []baslik={"id","soru","cevap1","cevap2","cevap3","cevap4","cevap5","ders","seviye"};
			Object [][]veri;
			String sorgu="SELECT * FROM  sorular";
			java.sql.PreparedStatement st=conn.prepareStatement(sorgu);
			ResultSet rs=st.executeQuery();
			int count=0;
			rs.last();
			count=rs.getRow();
			
			veri=new Object [count][9];
			rs.first();
			for(int i=0;i<count;i++){
				for(int j=0;j<9;j++) {
					//System.out.println(i);
					veri[i][j]=rs.getObject(j+1);
				}
				rs.next();
			}
			jTable1.setModel(new DefaultTableModel(veri,baslik));
			conn.close();	
                      
	}
      
       private void veridoldur(int numara) throws Exception {
		
		Connection conn=(Connection) DriverManager.getConnection("jdbc:mysql://localhost/sorubankasi?autoReconnect=true&useSSL=false", "root", "12345");

		String query = "select * from sorular where id = "+numara;

		java.sql.PreparedStatement st=conn.prepareStatement(query);
		ResultSet rs=st.executeQuery();
		if (rs.next()) {
		
			
			jTextField1.setText(rs.getString("id"));
			jTextField2.setText(rs.getString("soru"));
                        jTextField3.setText(rs.getString("cevap1"));
			jTextField4.setText(rs.getString("cevap2"));
                        jTextField5.setText(rs.getString("cevap3"));
                        jTextField6.setText(rs.getString("cevap4"));
                        jTextField7.setText(rs.getString("cevap5"));
                        jComboBox1.setSelectedItem(rs.getString("seviye"));
                        jComboBox2.setSelectedItem(rs.getString("ders"));
		}
     }
          private boolean Ekle() throws Exception {
     		Connection conn=(Connection) DriverManager.getConnection("jdbc:mysql://localhost/sorubankasi?autoReconnect=true&useSSL=false", "root", "12345");

		 String query = " insert into sorular (soru,cevap1,cevap2,cevap3,cevap4 ,cevap5,ders,seviye) values (?,?,?,?,?,?,?,?)";	 

		 java.sql.PreparedStatement preparedStmt = conn.prepareStatement(query);
		 preparedStmt.setString (1, jTextField2.getText());
                 preparedStmt.setString (2, jTextField3.getText());
                 preparedStmt.setString (3, jTextField4.getText());
                 preparedStmt.setString (4, jTextField5.getText());
                 preparedStmt.setString (5, jTextField6.getText());
                 preparedStmt.setString (6, jTextField7.getText());
                 preparedStmt.setString (7, jComboBox2.getSelectedItem().toString());
                 preparedStmt.setString (8, jComboBox1.getSelectedItem().toString());
		 preparedStmt.execute();
		 conn.close();	
                 VeriGetir();
                 
		 return true;
	} 
          private void Sil(int numara) throws Exception {
		try{
		Connection conn=(Connection) DriverManager.getConnection("jdbc:mysql://localhost/sorubankasi?autoReconnect=true&useSSL=false", "root", "12345");
		String query = "delete from sorular where id= ?";
		java.sql.PreparedStatement preparedStmt = conn.prepareStatement(query);
		preparedStmt.setInt(1, numara);
		preparedStmt.execute();
                JOptionPane.showMessageDialog(null, "Kayıt Silinmiştir..");
                VeriGetir();
		
                }catch(Exception e){
                JOptionPane.showMessageDialog(null, "Hata");
                }
	}

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jTextField3 = new javax.swing.JTextField();
        jTextField4 = new javax.swing.JTextField();
        jTextField5 = new javax.swing.JTextField();
        jTextField6 = new javax.swing.JTextField();
        jTextField7 = new javax.swing.JTextField();
        jComboBox1 = new javax.swing.JComboBox<>();
        jComboBox2 = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jButton5 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jButton1.setText("Listele");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("EKLE");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("GÜNCELLE");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setText("SİL");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jTextField1.setEnabled(false);

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "KOLAY", "ORTA", "ZOR" }));

        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "MATEMATİK", "FİZİK", "KİMYA", "BİYOLOJİ" }));

        jLabel1.setText("SORU:");

        jLabel2.setText("A");

        jLabel3.setText("B");

        jLabel4.setText("C");

        jLabel5.setText("D");

        jLabel6.setText("E");

        jButton5.setText("Geri");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 677, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 30, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(266, 266, 266)
                        .addComponent(jButton1)
                        .addGap(48, 48, 48))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(43, 43, 43)
                                .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 273, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(104, 104, 104))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel3))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jTextField7, javax.swing.GroupLayout.DEFAULT_SIZE, 103, Short.MAX_VALUE)
                                    .addComponent(jTextField3)
                                    .addComponent(jTextField4)
                                    .addComponent(jTextField5)
                                    .addComponent(jTextField6))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(26, 26, 26))
                                    .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(105, 105, 105)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, 105, Short.MAX_VALUE)
                            .addComponent(jButton4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(56, 56, 56))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jButton5)
                        .addGap(22, 22, 22))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(250, 250, 250)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 10, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addGap(26, 26, 26))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton1)
                            .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(71, 71, 71)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 21, Short.MAX_VALUE)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(27, 27, 27)
                                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel4))
                                .addGap(18, 18, 18)
                                .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel5)))
                        .addGap(26, 26, 26)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextField7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton5)
                .addGap(19, 19, 19))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
             try {
                VeriGetir();

        } catch (Exception e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
        }        // TODO add your handling code here:
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        // TODO add your handling code here:
         int numara=Integer.parseInt((jTable1.getValueAt(jTable1.getSelectedRow(), 0).toString()));

                try {
                        veridoldur(numara);
                      

                } catch (Exception e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                }
        
    }//GEN-LAST:event_jTable1MouseClicked

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
           
        try {
                boolean sonuc=Ekle();
                if (sonuc){
           
                }
                
        } catch (Exception e) {
                // TODO Auto-generated catch block
                e.printStackTrace();}
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        try {
					Sil(Integer.parseInt(jTextField1.getText()));
							
				} catch (Exception e) {
					e.printStackTrace();
				}	
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
         try {
             Connection conn=(Connection) DriverManager.getConnection("jdbc:mysql://localhost/sorubankasi?autoReconnect=true&useSSL=false", "root", "12345");
             int row = jTable1.getSelectedRow();
               String value = (jTable1.getModel().getValueAt(row, 0).toString());
               String sql = "UPDATE sorular SET soru=?,cevap1=?,cevap2=?,cevap3=?,cevap4=?,cevap5=?,ders=?,seviye=? WHERE id="+value; 
               java.sql.PreparedStatement preparedStmt = conn.prepareStatement(sql);
                // preparedStmt.setString (0, jTextField8.getText()); 
                 preparedStmt.setString (1, jTextField6.getText());
                 preparedStmt.setString (2, jTextField1.getText());
                 preparedStmt.setString (3, jTextField2.getText());
                 preparedStmt.setString (4, jTextField3.getText());
                 preparedStmt.setString (5, jTextField4.getText());
                 preparedStmt.setString (6, jTextField5.getText());
                 preparedStmt.setString (7, jComboBox2.getSelectedItem().toString());
                  preparedStmt.setString (8, jComboBox1.getSelectedItem().toString());
                 
		 preparedStmt.executeUpdate();
                 DefaultTableModel model = (DefaultTableModel)jTable1.getModel();
                 model.setRowCount(0);
                 JOptionPane.showMessageDialog(null,"Başarıyla Güncellendi.");
                 VeriGetir();
                
               
               
        } catch (Exception e) {
                // TODO Auto-generated catch block
                JOptionPane.showMessageDialog(null, e);
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
     
         setVisible(false);
        adminpanel  grs = new adminpanel();
        grs.setVisible(true);
    }//GEN-LAST:event_jButton5ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(soruekleme.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(soruekleme.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(soruekleme.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(soruekleme.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new soruekleme().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jTextField6;
    private javax.swing.JTextField jTextField7;
    // End of variables declaration//GEN-END:variables
}
