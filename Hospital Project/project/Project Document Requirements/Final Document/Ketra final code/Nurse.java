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

	private JPanel contentPane;
        private Statement stmt;
        private ResultSet result;
        JButton btnNewButton_1 = new javax.swing.JButton("");
        JButton button_2 = new javax.swing.JButton("");
        JButton btnJAdams = new javax.swing.JButton("");
        JButton button_3 = new javax.swing.JButton("");
        JButton button = new javax.swing.JButton("");
        JButton button_1 = new javax.swing.JButton("");
        static int x;


	/**
	 * Create the frame.
	 */
	public Nurse(int x) {
                super("Nurses Station A");
                this.x=x;
                searchDatabase(x);
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
                            CurrentPatient patientView = new CurrentPatient(1);
                            patientView.setVisible(true);
                            dispose();
			}
		});
		btnNewButton_1.setBackground(new Color(0, 204, 102));
		btnNewButton_1.setBounds(53, 100, 132, 35);
		contentPane.add(btnNewButton_1);
		
		//JButton button = new JButton("Vacant");
                if(x==1){
                    button.addActionListener(new ActionListener() {
                            public void actionPerformed(ActionEvent arg0) {
                                EnterNewPatient newPatient = new EnterNewPatient();
                                newPatient.setVisible(true);
                                dispose();                       
                            }
                    });
                } else if (x==2){
                    /*button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
                            CurrentPatient patientView = new CurrentPatient(1);
                            patientView.setVisible(true);
                            dispose();                       
			}
		});*/
                    
                }
                button.setBackground(new Color(0, 204, 102));
                    button.setBounds(53, 146, 132, 35);
                    contentPane.add(button);
		
		//JButton button_1 = new JButton("Vacant");
                if(x==1){   
                button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//System.exit(0);
                            EnterNewPatient newPatient = new EnterNewPatient();
                            newPatient.setVisible(true);
                            dispose();                        
			}
		});
                } else if (x==2){
                    /*button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
                            CurrentPatient patientView = new CurrentPatient(1);
                            patientView.setVisible(true);
                            dispose();                       
			}
		});*/
                }
		button_1.setBackground(new Color(0, 204, 102));
		button_1.setBounds(53, 192, 132, 35);
		contentPane.add(button_1);
		
		//JButton button_2 = new JButton("P. Weber 103");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
                            CurrentPatient patientView = new CurrentPatient(2);
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
                    CurrentPatient patientView = new CurrentPatient(3);
                    patientView.setVisible(true);
                    dispose();
                        }
		});
		btnJAdams.setBackground(new Color(0, 204, 102));
		btnJAdams.setBounds(53, 327, 132, 35);
		contentPane.add(btnJAdams);
		
		//JButton button_3 = new JButton("Vacant");
                if(x==1){
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
                            EnterNewPatient newPatient = new EnterNewPatient();
                            newPatient.setVisible(true);
                            dispose();
			}
		});
                } else if (x==2){
                    /*button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
                            CurrentPatient patientView = new CurrentPatient(1);
                            patientView.setVisible(true);
                            dispose();                       
			}
		});*/
                }
		button_3.setBackground(new Color(0, 204, 102));
		button_3.setBounds(53, 284, 132, 35);
		contentPane.add(button_3);
	}
        public void searchDatabase(int i){
        /*THIS METHOD CONNECTS TO THE DATABASE AND PRINT OUT PATIENT INFO IN 
         * THE JLABELS.
         */
            
        Connection connect = null;
        
        try {
            Class.forName("org.sqlite.JDBC");
            connect = DriverManager.getConnection("jdbc:sqlite:F:/hospital/data (1).db");            
            connect.setAutoCommit(false);
            stmt = connect.createStatement();
            System.out.println(stmt);
            result = stmt.executeQuery("SELECT fullname, patientID, roomNumber"
                    + " FROM PATIENTS;");
                if (i == 1){
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
                            button.setText("Vacant");
                            button_1.setText("Vacant");
                            button_3.setText("Vacant");
                        }
                    }catch ( Exception e){
                        btnJAdams.setText("Vacant");
                    }
                }else if (i==2){
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
                            result.next();
                            String string3 = result.getString("fullName");
                            Integer roomNumber3 = result.getInt("roomNumber");
                            button.setText(string3 + " " + roomNumber3);
                            button_1.setText("Vacant");
                            button_3.setText("Vacant");
                        }
                    }catch ( Exception e){
                        btnJAdams.setText("Vacant");
                        button.setText("Vacant");
                        button_1.setText("Vacant");
                        button_3.setText("Vacant");
                    }
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
        
        	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Nurse frame = new Nurse(x);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

}
