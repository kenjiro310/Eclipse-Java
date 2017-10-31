/* THIS WINDOW OPENS WHEN A DOCTOR IS LOGGED IN AND THEY HAVE VIEWED A PATIENT 
 * AND WANT TO PRESCRIBE A NEW PRESCRIPTION. (309 LINES)
 */
package javaapplication23;

import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;
import java.sql.Statement;
import java.sql.ResultSet;

public class Prescription extends javax.swing.JFrame {
    private Statement stmt;
    private Statement stmt1;
    private ResultSet result;
    //private ResultSet result1;
    /**
     * Creates new form Prescription
     */
    public Prescription(int x) {
        initComponents();
        searchDatabase(x);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jLabel7 = new javax.swing.JLabel();
        jTextField3 = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextArea2 = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Prescribe Prescription");

        jPanel1.setBackground(new java.awt.Color(0, 154, 255));

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Enter New Prescription");

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel1.setText("Patient's Name: ");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel3.setText("Drug Name: ");
        jLabel3.setToolTipText("");

        jButton1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jButton1.setText("Send Prescription");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jButton2.setText("Cancel");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel5.setText("Drug Dosage:  ");

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel6.setText("Comments: ");

        jTextField1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        jTextField2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel7.setText("Doctor's Siginature: ");

        jTextField3.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel8.setText("Current Drugs: ");

        jTextArea2.setColumns(20);
        jTextArea2.setEditable(false);
        jTextArea2.setRows(5);
        jScrollPane2.setViewportView(jTextArea2);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(59, 59, 59)
                        .addComponent(jLabel2))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jButton1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel7)
                                        .addGap(18, 18, 18)
                                        .addComponent(jTextField3))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel1)
                                        .addGap(39, 39, 39)
                                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel6)
                                            .addComponent(jLabel5)
                                            .addComponent(jLabel3)
                                            .addComponent(jLabel8))
                                        .addGap(45, 45, 45)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 182, Short.MAX_VALUE)
                                            .addComponent(jTextField2)
                                            .addComponent(jTextField1)
                                            .addComponent(jScrollPane2))))
                                .addGap(0, 74, Short.MAX_VALUE)))))
                .addContainerGap(39, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addGap(0, 69, Short.MAX_VALUE))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2))
                .addGap(21, 21, 21))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        //Button return to docCurrent view and closes window
        Doctor view = new Doctor();
        view.setVisible(true);
        dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        checkPrescription();
        //sendPrescription();
        Doctor editCurrentPatient = new Doctor();
        editCurrentPatient.setVisible(true);        
        dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new Prescription(1).setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextArea jTextArea2;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    // End of variables declaration//GEN-END:variables

    public void searchDatabase(int i){
        /*THIS METHOD CONNECTS TO THE DATABASE AND PRINT OUT PATIENT INFO IN 
         * THE JLABELS.
         */

        Connection connect = null;
        Statement stmt = null;
        String query = "SELECT * from Patients";
        
        try {
            Class.forName("org.sqlite.JDBC");
            connect = DriverManager.getConnection("jdbc:sqlite:F:/hospital/data (1).db");
            stmt = connect.createStatement();
            System.out.println("inside search database");
            result = stmt.executeQuery(query);
            //This is getting data from database and displaying it on the screen 
                 if (i == 1){
                     result.next();
                     jLabel4.setText(result.getString("fullName"));   
                     jTextArea2.setText(result.getString("currentDrugs"));
                 } 
                 else if (i == 2){
                     result.next();
                     result.next();
                     jLabel4.setText(result.getString("fullName"));
                     jTextArea2.setText(result.getString("currentDrugs"));
                 }
                 else if ( i == 3 ){
                     result.next();
                     result.next();
                     result.next();
                     jLabel4.setText(result.getString("fullName"));
                     jTextArea2.setText(result.getString("currentDrugs"));
                 }
            result.close();
            stmt.close();
            connect.close();
        } catch ( Exception e ) {
            System.err.println( e.getClass().getName() 
                    + ": " + e.getMessage() );
            System.exit(0);
            System.out.println("Opened database successfully");
            
        } 
        System.out.println("leaving search database");
}

   public void sendPrescription(){
        System.out.println("inside send prescription");
        String drug = jTextField1.getText();
        String dosage = jTextField2.getText();
        String comments = jTextArea1.getText();
        String docName = jTextField3.getText();
        String name = jLabel4.getText();
        String currentDrugs = jTextArea2.getText();
        
        Connection newConnection = null;
        Statement newStatement = null;
        
        try{
            Class.forName("org.sqlite.JDBC");
            newConnection = DriverManager.getConnection("jdbc:sqlite:F:/hospital/data (1).db");
            newConnection.setAutoCommit(false);
            System.out.println("Database opened successfully");
            
            newStatement = newConnection.createStatement();
            String insert = "INSERT INTO PHARMACY(NAME, DOCTOR, DOSAGE, PATIENT, COMMENTS)"
                    + "VALUES('" +drug+"','" +docName+"', '"+dosage+"', '"+name+"', '"+comments+"' );";
            newStatement.executeUpdate(insert);
            JOptionPane.showMessageDialog(null, "Perscription Prescribed!");
            System.out.println("Database opened successfully1");
            //newConnection.commit();
            
            newStatement.close();
            newConnection.close();
            
        } catch ( Exception e ) {
            System.err.println( e.getClass().getName() 
                    + ": " + e.getMessage() );
            System.exit(0);
        }
        
        System.out.println("Opened database successfully");
        System.out.println("leaving send prescription");
    }
    
    /*public void checkPrescription(){
        Connection connect = null;
        Statement stmt1 = null;
       
        //the drug the doc is trying to prescribe
        String newDrug = jTextField1.getText();
        //the drugs the patient has already had
        String currentDrugs = jTextArea2.getText();        
        
        //String query = "SELECT currentDrugs from Patients";
        try {
            Class.forName("org.sqlite.JDBC");
            connect = DriverManager.getConnection("jdbc:sqlite:C:/Ketra/"
                    + "javaapplication23/JavaApplication23/data (1).db");
            connect.setAutoCommit(false);
            stmt1 = connect.createStatement();
            ResultSet rs = stmt1.executeQuery("SELECT incompDrugs from Drug where drugname='" +newDrug+"'");
            System.out.println(currentDrugs);
            System.out.println("inside check prescription2");
            System.out.println("inside check prescription3");
            //checking database
            //String incompDrugs = rs.getString("incompdrugs");
            System.out.println("inside check prescription4");
           // System.out.println("incompdrugs " + incompDrugs);
            
            if( currentDrugs.equals(incompDrugs) ){
                System.out.println("Compared drugs");
                int reply = JOptionPane.showConfirmDialog(null, "Drugs are "
                        + "incompatible. Prescribe drug?", "Incompatible Drugs",
                        JOptionPane.YES_NO_OPTION);
                    if (reply == JOptionPane.YES_OPTION){
                       //sendPrescription();
                        dispose();
                    }
                    else {
                        Doctor view = new Doctor();
                        view.setVisible(true);
                        dispose();
                    }
            }
            else{
               //sendPrescription();
            }
                rs.close();
                connect.commit();
                stmt1.close();
                connect.close();
        } catch ( Exception e ) {
                    System.err.println( e.getClass().getName() 
                            + ": " + e.getMessage() );
                    System.exit(0);
                }
        System.out.println("Opened database successfully");
        System.out.println("leaving check prescription");
    }*/
    public void checkPrescription(){
        String newDrug = jTextField1.getText();
        String currentdrugs = jTextArea2.getText();
        Connection con = null;
        Statement statement = null;
        try{
            Class.forName("org.sqlite.JDBC");
            con = DriverManager.getConnection("jdbc:sqlite:F:/hospital/data (1).db");
            con.setAutoCommit(false);
            System.out.println("Opened database successfully");
            statement = con.createStatement();
            ResultSet rs = statement.executeQuery("SELECT INCOMPDRUGS FROM DRUG where drugname='" +newDrug+"'");
            
            while(rs.next()){
                String indrugs = rs.getString("incompdrugs");
                System.out.println("Incompatible drugs are :" + indrugs);
                
                if( currentdrugs.equals(indrugs) ){
                    System.out.println("Compared drugs");
                    int reply = JOptionPane.showConfirmDialog(null, "Drugs are "
                            + "incompatible. Prescribe drug?", "Incompatible Drugs",
                            JOptionPane.YES_NO_OPTION);
                    if (reply == JOptionPane.YES_OPTION){
                        sendPrescription();
                        dispose();
                    }
                    else {
                        //Doctor view = new Doctor();
                        //view.setVisible(true);
                        dispose();
                    }
                }
                else{
                    sendPrescription();
                    //System.out.println("drugs are compatabile");
                }
            }
            rs.close();
            statement.close();
            con.close();
        }catch (Exception e){
            System.err.println(e.getClass().getName()  + ": " + e.getMessage() );
            System.exit(0);
        }
        System.out.println("opened database successfully");
    }
}
