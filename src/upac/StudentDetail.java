/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package upac;

import java.awt.Image;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import static upac.CarteDialog.member;
import upac.helper.Agenda;
import upac.helper.DatabaseManager;
import upac.helper.Login;
import upac.helper.UniversalMethod;

/**
 *
 * @author user
 */
public class StudentDetail extends javax.swing.JDialog {

    /**
     * Creates new form MemberDetail
     */
    public static int rowId;
    private DatabaseManager db;
    public static String promotion;
    ArrayList<String[]> student;
    public StudentDetail(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        db = Login.db;
        
        if (promotion.equals("BAC 1")) {
            student = UniversalMethod.studentDataAttenteBAC1;
        }
        else if (promotion.equals("BAC 2")) {
            student = UniversalMethod.studentDataAttenteBAC2;
        }
        else if (promotion.equals("BAC 3")) {
            student = UniversalMethod.studentDataAttenteBAC3;
        }
        if (student != null) {
            
            setDefaultImage(UniversalMethod.convertStringToImageIcon( student.get(rowId)[1]), profile);
            setDefaultImage(UniversalMethod.convertStringToImageIcon( student.get(rowId)[6]), matricule);
            setDefaultImage(UniversalMethod.convertStringToImageIcon( student.get(rowId)[7]), bordereau);

            fullname.setText(student.get(rowId)[0]);
            faculte.setText(student.get(rowId)[2]);
            address.setText(address.getText() +" : "+ student.get(rowId)[5]);
            departement.setText(departement.getText() +" : "+ student.get(rowId)[3]);

            if (!UniversalMethod.apparitora) {
                active.setVisible(false);
            }
            else{
                active.setVisible(true);

            }
            
        }
//       
//        if (db.checkActivation(UniversalMethod.data.get(rowId).getId())) {
//            active.setVisible(false);
//        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        profile = new javax.swing.JLabel();
        fullname = new javax.swing.JLabel();
        faculte = new javax.swing.JLabel();
        matricule = new javax.swing.JLabel();
        departement = new javax.swing.JLabel();
        address = new javax.swing.JLabel();
        active = new javax.swing.JButton();
        bordereau = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(77, 56, 91)));
        jPanel1.setMaximumSize(new java.awt.Dimension(590, 440));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        profile.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(77, 56, 91), 1, true));
        jPanel1.add(profile, new org.netbeans.lib.awtextra.AbsoluteConstraints(22, 22, 106, 106));

        fullname.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        fullname.setText("Billy Paul");
        jPanel1.add(fullname, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 20, 382, 37));

        faculte.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        faculte.setText("Faculté de Science");
        jPanel1.add(faculte, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 70, 286, 24));

        matricule.setText("jLabel3");
        jPanel1.add(matricule, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 40, 120, 100));

        departement.setBackground(new java.awt.Color(77, 56, 91));
        departement.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        departement.setText("Département");
        jPanel1.add(departement, new org.netbeans.lib.awtextra.AbsoluteConstraints(22, 169, 279, 27));

        address.setBackground(new java.awt.Color(77, 56, 91));
        address.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        address.setText("Adresse");
        jPanel1.add(address, new org.netbeans.lib.awtextra.AbsoluteConstraints(22, 207, 279, 27));

        active.setBackground(new java.awt.Color(77, 56, 91));
        active.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        active.setForeground(new java.awt.Color(255, 255, 255));
        active.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Unlock.png"))); // NOI18N
        active.setText("Activer");
        active.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                activeActionPerformed(evt);
            }
        });
        jPanel1.add(active, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 310, 150, 50));

        bordereau.setText("jLabel1");
        jPanel1.add(bordereau, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 170, 210, 130));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 606, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 379, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void activeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_activeActionPerformed
        // TODO add your handling code here:
        active.setIcon(new ImageIcon(getClass().getResource("/images/ajax_loader_gray_32.gif")));
        db.updateStudent(1, Integer.parseInt(student.get(rowId)[4]));
        if ( !db.getCarteStudentById(Integer.parseInt(student.get(rowId)[4]))) {
            this.dispose();
            CarteDialog.rowId = rowId;
            CarteDialog.student = true;
            CarteDialog.member = false;
            
            CarteDialog carte = new CarteDialog(null, true);
            carte.setVisible(true);
        }
        else{ 
            //
            JOptionPane.showMessageDialog(null, "Carte est deja enregister");
            this.dispose();
        }
        
    }//GEN-LAST:event_activeActionPerformed

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
            java.util.logging.Logger.getLogger(StudentDetail.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(StudentDetail.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(StudentDetail.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(StudentDetail.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                StudentDetail dialog = new StudentDetail(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }
    private void setDefaultImage(ImageIcon imageIcon, JLabel label){
       
        Image image = imageIcon.getImage().getScaledInstance(label.getWidth(), label.getHeight(), Image.SCALE_SMOOTH);
            
        ImageIcon iconResized = new ImageIcon(image);
            
        label.setIcon(iconResized);
        
    }
   

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton active;
    private javax.swing.JLabel address;
    private javax.swing.JLabel bordereau;
    private javax.swing.JLabel departement;
    private javax.swing.JLabel faculte;
    private javax.swing.JLabel fullname;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel matricule;
    private javax.swing.JLabel profile;
    // End of variables declaration//GEN-END:variables
}
