/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Controller.AccountManager;
import Model.ListOfAccountsSingelton;
import javax.swing.JOptionPane;

/**
 *
 * @author mor
 */
public class RegisterWindow extends javax.swing.JFrame {
    private AccountManager accMng = new AccountManager();
    /**
     * Creates new form RegisterWindow
     */
    public RegisterWindow() {
        initComponents();
    }
    
    // https://stackoverflow.com/questions/624581/what-is-the-best-java-email-address-validation-method
    public boolean isValidEmailAddress(String email) { 
           String ePattern = "^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\])|(([a-zA-Z\\-0-9]+\\.)+[a-zA-Z]{2,}))$";
           java.util.regex.Pattern p = java.util.regex.Pattern.compile(ePattern);
           java.util.regex.Matcher m = p.matcher(email);
           return m.matches();
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
        jlbl_Password = new javax.swing.JLabel();
        jtxt_email = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        jlbl_Email = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        jtxt_password = new javax.swing.JPasswordField();
        btn_create_account = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jtxt_name = new javax.swing.JTextField();
        jlbl_Email1 = new javax.swing.JLabel();
        jSeparator4 = new javax.swing.JSeparator();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(25, 84, 186));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jlbl_Password.setForeground(new java.awt.Color(255, 255, 255));
        jlbl_Password.setIcon(new javax.swing.ImageIcon(getClass().getResource("/password.png"))); // NOI18N
        jPanel1.add(jlbl_Password, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 300, -1, -1));

        jtxt_email.setBackground(new java.awt.Color(25, 84, 186));
        jtxt_email.setFont(new java.awt.Font("Kailasa", 0, 14)); // NOI18N
        jtxt_email.setForeground(new java.awt.Color(255, 255, 255));
        jtxt_email.setText("Email");
        jtxt_email.setToolTipText("");
        jtxt_email.setBorder(null);
        jtxt_email.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtxt_emailActionPerformed(evt);
            }
        });
        jPanel1.add(jtxt_email, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 250, 250, 20));

        jSeparator1.setPreferredSize(new java.awt.Dimension(50, 20));
        jPanel1.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 340, 300, 20));

        jlbl_Email.setForeground(new java.awt.Color(255, 255, 255));
        jlbl_Email.setIcon(new javax.swing.ImageIcon(getClass().getResource("/email.png"))); // NOI18N
        jPanel1.add(jlbl_Email, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 220, -1, 70));

        jSeparator2.setPreferredSize(new java.awt.Dimension(50, 20));
        jPanel1.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 270, 300, -1));

        jtxt_password.setBackground(new java.awt.Color(25, 84, 186));
        jtxt_password.setForeground(new java.awt.Color(255, 255, 255));
        jtxt_password.setText("jPasswordField1");
        jtxt_password.setBorder(null);
        jtxt_password.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtxt_passwordActionPerformed(evt);
            }
        });
        jPanel1.add(jtxt_password, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 310, 230, 40));

        btn_create_account.setBackground(new java.awt.Color(71, 175, 255));
        btn_create_account.setFont(new java.awt.Font("PSL Ornanong Pro", 0, 14)); // NOI18N
        btn_create_account.setText("Create Account");
        btn_create_account.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_create_accountActionPerformed(evt);
            }
        });
        jPanel1.add(btn_create_account, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 370, 130, 50));

        jLabel1.setFont(new java.awt.Font("Sana", 0, 48)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Sign Up");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 60, 190, 60));

        jtxt_name.setBackground(new java.awt.Color(25, 84, 186));
        jtxt_name.setFont(new java.awt.Font("Kailasa", 0, 14)); // NOI18N
        jtxt_name.setForeground(new java.awt.Color(255, 255, 255));
        jtxt_name.setText("Full Name");
        jtxt_name.setToolTipText("");
        jtxt_name.setBorder(null);
        jtxt_name.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtxt_nameActionPerformed(evt);
            }
        });
        jPanel1.add(jtxt_name, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 190, 250, 20));

        jlbl_Email1.setForeground(new java.awt.Color(255, 255, 255));
        jlbl_Email1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/user.png"))); // NOI18N
        jPanel1.add(jlbl_Email1, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 150, -1, 70));

        jSeparator4.setPreferredSize(new java.awt.Dimension(50, 20));
        jPanel1.add(jSeparator4, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 210, 300, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 498, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 517, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jtxt_emailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtxt_emailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtxt_emailActionPerformed

    private void jtxt_nameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtxt_nameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtxt_nameActionPerformed

    private void jtxt_passwordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtxt_passwordActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtxt_passwordActionPerformed

    private void btn_create_accountActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_create_accountActionPerformed
        // TODO add your handling code here:
        ListOfAccountsSingelton accList = ListOfAccountsSingelton.getInstance();
        
        String fullName = jtxt_name.getText();
        String email = jtxt_email.getText();
        String password = jtxt_password.getText();
        String firstName;
        String lastName;
        
        
        if(accMng.isAccExist(email)){
            int idx = fullName.lastIndexOf(' ');
            if (idx == -1){
                JOptionPane.showMessageDialog(this,"Please enter full name", "Error", JOptionPane.ERROR_MESSAGE);
                return; 
            }
            else{
                firstName = fullName.substring(0, idx);
                lastName  = fullName.substring(idx + 1);
            }
            if(!isValidEmailAddress(email)){
                JOptionPane.showMessageDialog(this,"Please enter valid email", "Error", JOptionPane.ERROR_MESSAGE);
                return;  
            }
            if(password.length() < 8){
                JOptionPane.showMessageDialog(this,"Password too short, minimum 8 chracthers", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            accMng.createAccount(firstName, lastName, email, password);
            ListOfAccountsSingelton list = ListOfAccountsSingelton.getInstance();
            JOptionPane.showMessageDialog(this,"Account created successfully", "Sign Up", JOptionPane.INFORMATION_MESSAGE);
            accMng.saveData();
            this.dispose();
        }
        else{
            JOptionPane.showMessageDialog(this,"Email already exist", "Error", JOptionPane.ERROR_MESSAGE);
        }
        
    }//GEN-LAST:event_btn_create_accountActionPerformed

  

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_create_account;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JLabel jlbl_Email;
    private javax.swing.JLabel jlbl_Email1;
    private javax.swing.JLabel jlbl_Password;
    private javax.swing.JTextField jtxt_email;
    private javax.swing.JTextField jtxt_name;
    private javax.swing.JPasswordField jtxt_password;
    // End of variables declaration//GEN-END:variables
}
