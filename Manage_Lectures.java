
import java.awt.Color;
import java.awt.Image;
import java.io.File;
import java.util.ArrayList;
import java.util.StringTokenizer;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.table.AbstractTableModel;


public class Manage_Lectures extends javax.swing.JFrame {
    
    JFileChooser jfc;
    
    File ph,lecture;
    
    ArrayList<Lecture> al  = new ArrayList<>();
    
    myTableModel tm;

    public Manage_Lectures() {
        initComponents();
        load_courses();
        
        tm = new myTableModel();
        
        myTable.setModel(tm);
        setSize(800, 600);
        
        setBackground(Color.yellow);
        
    }
    
    void load_courses()
    {
        String ans = myClient.loadCourses();
        
        StringTokenizer st = new StringTokenizer(ans,";;");
        
        while(st.hasMoreTokens())
        {
            String row = st.nextToken();
            
            StringTokenizer st1 = new StringTokenizer(row,"$");
            
            String id = st1.nextToken();
            String name = st1.nextToken();
            
            cb.addItem(id+" "+name);
            cb1.addItem(id+" "+name);
        }
    }
    
    void fetchlectures()
    {
        al.clear();
         String course = (String) cb1.getSelectedItem();
         
         StringTokenizer st = new StringTokenizer(course);
         
         int course_id = Integer.parseInt(st.nextToken());
         
         String ans  = myClient.fetch_Lectures(course_id);
         
         System.out.println("-->"+ans);
         
         StringTokenizer ft = new StringTokenizer(ans,";;");
         
         while(ft.hasMoreTokens())
         {
             String row = ft.nextToken();
             
             StringTokenizer ft1 = new StringTokenizer(row,"$");
             
             int id = Integer.parseInt(ft1.nextToken());
             String name = ft1.nextToken();
             String description = ft1.nextToken();
             String photo = ft1.nextToken();
             
             al.add(new Lecture(id, name, description, photo));
                    
         }
         tm.fireTableDataChanged();
    }
    
 class myTableModel extends AbstractTableModel
         {

        @Override
        public int getRowCount() {
       return al.size();
        }

        @Override
        public int getColumnCount() {
      return 3;
        }

        @Override
        public Object getValueAt(int i, int j) {
            if(j==0)
            {
                return al.get(i).name;
            }
            else if(j==1)
            {
                return al.get(i).description;
            }
            else
            {
                return al.get(i).photo;
            }
}

        @Override
        public String getColumnName(int j) {
          String name[] = {"Name","Description","Photo"};
          return name[j];
        }
        
     
 }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        descriptiontf = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        Nametf = new javax.swing.JTextField();
        durationtf = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        trailertf = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        photolb = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        cb = new javax.swing.JComboBox<>();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        cb1 = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        myTable = new javax.swing.JTable();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 51, 102));
        setResizable(false);
        getContentPane().setLayout(null);

        jLabel1.setFont(new java.awt.Font("Helvetica Neue", 3, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Manage Lectures");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(0, 0, 800, 30);

        jLabel2.setText("View Lectures");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(520, 40, 220, 17);

        jLabel3.setText("Add Lectures");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(20, 40, 220, 17);

        jLabel4.setText("Description");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(20, 180, 200, 17);
        getContentPane().add(descriptiontf);
        descriptiontf.setBounds(20, 210, 300, 23);

        jLabel5.setText("name");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(20, 110, 200, 17);
        getContentPane().add(Nametf);
        Nametf.setBounds(20, 140, 300, 23);
        getContentPane().add(durationtf);
        durationtf.setBounds(20, 280, 300, 23);

        jLabel6.setText("Duration");
        getContentPane().add(jLabel6);
        jLabel6.setBounds(20, 250, 200, 17);

        jLabel7.setText("Duration");
        getContentPane().add(jLabel7);
        jLabel7.setBounds(20, 250, 200, 17);

        jLabel8.setText("Lecture");
        getContentPane().add(jLabel8);
        jLabel8.setBounds(20, 390, 200, 17);
        getContentPane().add(trailertf);
        trailertf.setBounds(20, 350, 300, 23);

        jLabel9.setText("Traier");
        getContentPane().add(jLabel9);
        jLabel9.setBounds(20, 320, 200, 17);

        jButton1.setText("Choose Lecture");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(20, 420, 300, 23);

        jLabel10.setText("Photo");
        getContentPane().add(jLabel10);
        jLabel10.setBounds(20, 460, 120, 17);
        getContentPane().add(photolb);
        photolb.setBounds(20, 490, 140, 90);

        jButton2.setText("Browse");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2);
        jButton2.setBounds(210, 500, 110, 23);

        jButton3.setText("Submit");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton3);
        jButton3.setBounds(210, 540, 110, 23);

        cb.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select" }));
        getContentPane().add(cb);
        cb.setBounds(100, 70, 220, 30);

        jLabel11.setText("Course");
        getContentPane().add(jLabel11);
        jLabel11.setBounds(20, 67, 70, 30);

        jLabel12.setText("Course");
        getContentPane().add(jLabel12);
        jLabel12.setBounds(470, 70, 70, 30);

        cb1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select" }));
        cb1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cb1ActionPerformed(evt);
            }
        });
        getContentPane().add(cb1);
        cb1.setBounds(530, 70, 170, 30);

        myTable.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(myTable);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(470, 120, 320, 280);

        jButton4.setText("Delete");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton4);
        jButton4.setBounds(590, 430, 78, 23);

        jButton5.setText("View");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton5);
        jButton5.setBounds(710, 70, 72, 30);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cb1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cb1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cb1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        jfc = new JFileChooser();
        
        int ans = jfc.showOpenDialog(this);
        
        if(ans == JFileChooser.APPROVE_OPTION)
        {
            ph = jfc.getSelectedFile();
            
            ImageIcon ic = new ImageIcon(ph.getPath());
            
            Image img = ic.getImage().getScaledInstance(photolb.getWidth(), photolb.getHeight(), Image.SCALE_SMOOTH);
            
            ImageIcon ic1 = new ImageIcon(img);
            
            photolb.setIcon(ic1);
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
         jfc = new JFileChooser();
        
        int ans = jfc.showOpenDialog(this);
        
        if(ans == JFileChooser.APPROVE_OPTION)
        {
            lecture = jfc.getSelectedFile();
           
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
       String name = Nametf.getText();
       String description = descriptiontf.getText();
       String duration = durationtf.getText();
       String trailer = trailertf.getText();
       String course = (String) cb.getSelectedItem();  // no
       
        StringTokenizer st = new StringTokenizer(course);
        
        int course_id = Integer.parseInt(st.nextToken()); //yes
        
        System.out.println("--->"+course_id);
        
        if(name.isEmpty()||description.equals("")||duration.isEmpty()||trailer.isEmpty()||course.isEmpty()||ph == null||lecture == null)
        {
            JOptionPane.showMessageDialog(rootPane, "All Fields are Mandatory!");
        }
         else
        {
            String ans = myClient.addLecture(name, description, duration, trailer, course_id, ph, lecture);
            
            if(ans.trim().equals("success"))
            {
                JOptionPane.showMessageDialog(rootPane, "Success");
            }
            else
            {
                JOptionPane.showMessageDialog(rootPane, ans);
            }
        }
       
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
       fetchlectures();
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
       int i = myTable.getSelectedRow();
       
       if(i == -1)
       {
           JOptionPane.showMessageDialog(rootPane, "Please Select Row!");
       }
       else
       {
           int id = al.get(i).id;
           
           System.out.println("***"+id);
           
           String ans = myClient.deletelecture(id);
           
           if(ans.trim().equals("success"))
           {
               JOptionPane.showMessageDialog(rootPane, "Success");
               fetchlectures();
           }
           else
           {
               JOptionPane.showMessageDialog(rootPane, ans);
           }
       }
    }//GEN-LAST:event_jButton4ActionPerformed

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
            java.util.logging.Logger.getLogger(Manage_Lectures.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Manage_Lectures.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Manage_Lectures.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Manage_Lectures.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Manage_Lectures().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField Nametf;
    private javax.swing.JComboBox<String> cb;
    private javax.swing.JComboBox<String> cb1;
    private javax.swing.JTextField descriptiontf;
    private javax.swing.JTextField durationtf;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable myTable;
    private javax.swing.JLabel photolb;
    private javax.swing.JTextField trailertf;
    // End of variables declaration//GEN-END:variables
}
