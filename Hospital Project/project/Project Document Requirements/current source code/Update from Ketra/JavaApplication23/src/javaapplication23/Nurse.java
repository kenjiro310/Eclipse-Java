/* This window opens the nurses station when the user 
 * logs in and they have nurse permissions
 * This window searches the database and prints out 
 * the patients info in the buttons.
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

	private JPanel contentPane;
        private Statement stmt;
        private ResultSet result;
        JButton btnNewButton_1 = new javax.swing.JButton("");
        JButton button_2 = new javax.swing.JButton("");
        JButton btnJAdams = new JButton("");


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

	/**
	 * Create the frame.
	 */
	public Nurse() {
                super("Nurses Station A");
                searchDatabase();
		setResizable(false);
                setLocationRelativeTo(null);
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
		
		//JButton btnNewButton_1 = new javax.swing.JButton("");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
                            CurrentPatient patientView = new CurrentPatient();
                            patientView.setVisible(true);
                            dispose();
			}
		});
		btnNewButton_1.setBackground(new Color(0, 204, 102));
		btnNewButton_1.setBounds(53, 100, 132, 35);
		contentPane.add(btnNewButton_1);
		
		JButton button = new JButton("Vacant");
                button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
                            EnterNewPatient newPatient = new EnterNewPatient();
                            newPatient.setVisible(true);
                            dispose();                       
			}
		});
		button.setBackground(new Color(0, 204, 102));
		button.setBounds(53, 146, 132, 35);
		contentPane.add(button);
		
		JButton button_1 = new JButton("Vacant");
                button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//System.exit(0);
                            EnterNewPatient newPatient = new EnterNewPatient();
                            newPatient.setVisible(true);
                            dispose();                        
			}
		});
		button_1.setBackground(new Color(0, 204, 102));
		button_1.setBounds(53, 192, 132, 35);
		contentPane.add(button_1);
		
		//JButton button_2 = new JButton("P. Weber 103");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
                            CurrentPatient patientView = new CurrentPatient();
                            patientView.setVisible(true);
                            dispose();
			}
		});
		button_2.setBackground(new Color(0, 204, 102));
		button_2.setBounds(53, 238, 132, 35);
		contentPane.add(button_2);
		
		//JButton btnJAdams = new JButton("J. Adams 105");
                btnJAdams.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent arg0) {
                    CurrentPatient patientView = new CurrentPatient();
                    patientView.setVisible(true);
                    dispose();
                        }
		});
		btnJAdams.setBackground(new Color(0, 204, 102));
		btnJAdams.setBounds(53, 327, 132, 35);
		contentPane.add(btnJAdams);
		
		JButton button_3 = new JButton("Vacant");
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
                            EnterNewPatient newPatient = new EnterNewPatient();
                            newPatient.setVisible(true);
                            dispose();
			}
		});
		button_3.setBackground(new Color(0, 204, 102));
		button_3.setBounds(53, 284, 132, 35);
		contentPane.add(button_3);
	}

        public void searchDatabase(){
        /*THIS METHOD CONNECTS TO THE DATABASE AND PRINT OUT PATIENT INFO IN 
         * THE JLABELS.
         */
        Connection connect = null;
        
        try {
            Class.forName("org.sqlite.JDBC");
            connect = DriverManager.getConnection("jdbc:"
                    + "sqlite:C:/Ketra/JavaApplication23/data.db");
            connect.setAutoCommit(false);
            System.out.println(stmt);
            result = stmt.executeQuery("SELECT fullname, rowid, roomNumber FROM PATIENTS;");
                
                try{
                    if ( result.next() ){
                        String string = result.getString("fullName");
                        Integer roomNumber = result.getInt("roomNumber");
                        btnNewButton_1.setText(string + " " + roomNumber);
                        result.next();
                        String string1 = result.getString("fullName");
                        Integer roomNumber1 = result.getInt("roomNumber");                        
                        button_2.setText(string1 + " " + roomNumber1);
                        result.next();
                        String string2 = result.getString("fullName");
                        Integer roomNumber2 = result.getInt("roomNumber");                        
                        btnJAdams.setText(string2 + " " + roomNumber2);
                    } 
                }catch ( Exception e){
                    btnJAdams.setText("Vacant");
                }
                 result.close();
                 stmt.close();
                 connect.close();
        } catch ( Exception e ) {
            System.err.println( e.getClass().getName()
                    + ": " + e.getMessage() );
            System.exit(0);
        }
        System.out.println("Opened database successfully");
        }

}
