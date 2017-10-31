/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication23;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.*;
import javax.swing.border.EmptyBorder;


public class Nurse extends JFrame {

	private Statement stmt;
	private Statement stmt1;
    private ResultSet result;
    private ResultSet result1;
	private JPanel contentPane;
    JButton btnNewButton_1 = new javax.swing.JButton ();
    JButton button = new javax.swing.JButton ();
        
    
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Nurse frame = new Nurse();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Nurse() {
		
        super("Nurses Station A");
        searchDatabase();
setResizable(false);
setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
setBounds(100, 100, 600, 500);
contentPane = new JPanel();
contentPane.setBackground(new Color(0, 153, 255));
contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
setContentPane(contentPane);
contentPane.setLayout(null);



JLabel lblNurseStationA = new JLabel("Nurse Station A");
lblNurseStationA.setHorizontalAlignment(SwingConstants.CENTER);
lblNurseStationA.setFont(new Font("Calibri", Font.PLAIN, 26));
lblNurseStationA.setBounds(191, 16, 180, 56);
contentPane.add(lblNurseStationA);

JButton btnNewButton = new JButton("Sign Out");
btnNewButton.addActionListener(new ActionListener() {
	public void actionPerformed(ActionEvent arg0) {
		//System.exit(0);
		Test loginGUI = new Test();
                        loginGUI.setVisible(true);
                        dispose();                            
	}
});
btnNewButton.setBackground(new Color(255, 0, 0));
btnNewButton.setBounds(452, 29, 122, 35);
contentPane.add(btnNewButton);

//JButton btnNewButton_1 = new javax.swing.JButton("M. Carts 100");
btnNewButton_1.addActionListener(new ActionListener() {
	public void actionPerformed(ActionEvent arg0) {
                    CurrentPatient patientView = new CurrentPatient();
//                	initComponents();
                    
                    patientView.setVisible(true);
                    dispose();
	}
});
btnNewButton_1.setBackground(new Color(0, 204, 102));
btnNewButton_1.setBounds(53, 100, 122, 35);
contentPane.add(btnNewButton_1);

//JButton button = new JButton("Vacant");
button.setBackground(new Color(0, 204, 102));
button.setBounds(53, 146, 122, 35);
contentPane.add(button);

JButton button_1 = new JButton("Vacant");
button_1.setBackground(new Color(0, 204, 102));
button_1.setBounds(53, 192, 122, 35);
contentPane.add(button_1);

JButton button_2 = new JButton("P. Weber 103");
button_2.addActionListener(new ActionListener() {
	public void actionPerformed(ActionEvent arg0) {
                    CurrentPatient patientView = new CurrentPatient();
                    patientView.setVisible(true);
                    dispose();
	}
});
button_2.setBackground(new Color(0, 204, 102));
button_2.setBounds(53, 238, 122, 35);
contentPane.add(button_2);

JButton btnJAdams = new JButton("J. Adams 105");
        btnJAdams.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent arg0) {
            CurrentPatient patientView = new CurrentPatient();
            patientView.setVisible(true);
            dispose();
                }
});
btnJAdams.setBackground(new Color(0, 204, 102));
btnJAdams.setBounds(53, 327, 122, 35);
contentPane.add(btnJAdams);

JButton button_3 = new JButton("Vacant");
button_3.addActionListener(new ActionListener() {
	public void actionPerformed(ActionEvent arg0) {
	}
});
button_3.setBackground(new Color(0, 204, 102));
button_3.setBounds(53, 284, 122, 35);
contentPane.add(button_3);
}
	/**
	 * Create the frame.
	 */
	public void searchDatabase(){
        /*THIS METHOD CONNECTS TO THE DATABASE AND PRINT OUT PATIENT INFO IN 
         * THE JLABELS AND TEXT FIELDS.
         */
        Connection connect = null;
        
        String query = "select firstLast from Patients where rowid = '1'";
        String query1 = "select firstLast from Patients WHERE rowid = '2'";
        
        try {
            Class.forName("org.sqlite.JDBC");
             connect = DriverManager.getConnection("jdbc:"
                     + "sqlite:C:/sqlite/data.db");
                stmt = connect.createStatement();
                stmt1 = connect.createStatement();
                System.out.println(stmt);
                result = stmt.executeQuery(query);
                result1 = stmt1.executeQuery(query1);
                
          
                 if (result.next()){
                     //System.out.println(result.getString("firstName"));
                     btnNewButton_1.setText(result.getString("firstLast"));
                     
                    // jButton1.setText(result.getString("firstName"));
                 }    
                     
                     
                // if (result1.next()){
                // button.setText(result.getString("firstLast"));
                // }
                 
                 else{
                        //NEED TO FIGURE OUT HOW TO GET THIS TO NOT CLOSE AFTER FIRST TRY
                        JOptionPane.showMessageDialog(null, 
                               "Invalid Username or Password!");
                         //Search();
                                        
                                    }
                                    result.close();
                                    connect.close();
                                    
                                } catch ( Exception e ) {
                                    System.err.println( e.getClass().getName() 
                                            + ": " + e.getMessage() );
                                    System.exit(0);
                                }
                                System.out.println("Opened database successfully");
                        }
    
 

}
