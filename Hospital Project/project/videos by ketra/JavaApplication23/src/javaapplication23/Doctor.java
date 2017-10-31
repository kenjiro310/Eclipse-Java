/* This is the window for the doctor's station. (110 Lines)
 */
package javaapplication23;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.JFrame;


public class Doctor extends JFrame {
        private Statement stmt;
        private ResultSet result;
	private JPanel contentPane;
        private JButton btnNewButton;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Doctor frame = new Doctor();
					frame.setVisible(true);
					frame.setSize(600,600);
					frame.setResizable(false);
					frame.setBackground(null);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Doctor() {
                super("Doctor's Station");
		setResizable(false);
                searchDatabase();
		//setTitle("Superior Hospital Systems");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 500);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 153, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblDrSmith = new JLabel("Dr. Smith");
		lblDrSmith.setHorizontalAlignment(SwingConstants.CENTER);
		lblDrSmith.setBounds(191, 16, 155, 56);
		lblDrSmith.setFont(new Font("Calibri", Font.PLAIN, 26));
		contentPane.add(lblDrSmith);
		
		JButton btnNewButton = new JButton("J. Adams 105 ");
		btnNewButton.setForeground(new Color(0, 0, 0));
		btnNewButton.setBackground(new Color(0, 204, 102));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
                            DocCurrentPatient currentpatient = new DocCurrentPatient();
                            currentpatient.setVisible(true);
                            dispose();
			}
		});
		btnNewButton.setBounds(53, 100, 122, 35);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton1 = new JButton("M. Carts 100");
		btnNewButton1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
                            DocCurrentPatient currentpatient = new DocCurrentPatient();
                            currentpatient.setVisible(true);
                            dispose();                            
			}
		});                
		btnNewButton1.setBackground(new Color(0, 204, 102));
		btnNewButton1.setBounds(53, 146, 122, 35);
		contentPane.add(btnNewButton1);
		
		JButton btnNewButton2 = new JButton("P. Weber 103");
		btnNewButton2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
                            DocCurrentPatient currentpatient = new DocCurrentPatient();
                            currentpatient.setVisible(true);
                            dispose();                            
			}
		});                
		btnNewButton2.setBackground(new Color(0, 204, 102));
		btnNewButton2.setBounds(53, 192, 122, 35);
		contentPane.add(btnNewButton2);
		
		JButton btnSignOut = new JButton("Sign Out");
		btnSignOut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//System.exit(0);
				Test loginGUI = new Test();
                                loginGUI.setVisible(true);
                                dispose();                                
			}
		});
		btnSignOut.setBackground(new Color(255, 0, 0));
		btnSignOut.setBounds(452, 29, 122, 35);
		contentPane.add(btnSignOut);
	}
        public void searchDatabase(){
        /*THIS METHOD CONNECTS TO THE DATABASE AND PRINT OUT PATIENT INFO IN 
         * THE JLABELS.
         */
        Connection connect = null;
        String query = "SELECT * from Patients";
        
        try {
            Class.forName("org.sqlite.JDBC");
             connect = DriverManager.getConnection("jdbc:"
                + "sqlite:C:/Users/Ketra/Documents/"
                + "School Folders/Software "
                + "Engineering/TestDB.db");
                stmt = connect.createStatement();
                System.out.println(stmt);
                result = stmt.executeQuery(query);

                 if (result.next()){
                     System.out.println(result.getString("fullName"));
                     //btnNewButton.setText(result.getString("fullName"));
                     
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