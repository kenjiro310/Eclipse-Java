package javaapplication23;

import java.awt.*;
import java.sql.*;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JPasswordField;
import javax.swing.JLabel;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import javax.swing.JTextField;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.*;


public class Test extends JFrame {
	private JTextField textField;
	private JPasswordField passwordField;
        private Statement stmt;
        private ResultSet result;

        /**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Test frame = new Test();
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
	public Test() {
		setFont(new Font("Calibri", Font.PLAIN, 12));
		setResizable(false);
		setTitle("Superior Hospital Systems");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 500);
		getContentPane().setLayout(new GridLayout(1, 0, 0, 0));
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 153, 255));
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Username");
		lblNewLabel.setFont(new Font("Calibri", Font.PLAIN, 18));
		lblNewLabel.setBounds(173, 184, 78, 22);
		panel.add(lblNewLabel);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setFont(new Font("Calibri", Font.PLAIN, 18));
		lblPassword.setBounds(173, 229, 78, 24);
		panel.add(lblPassword);
		
		textField = new JTextField();
		textField.setBounds(265, 186, 109, 20);
		panel.add(textField);
		textField.setColumns(10);
		
		JLabel lblLogIn = new JLabel("Log In");
		lblLogIn.setFont(new Font("Calibri", Font.PLAIN, 44));
		lblLogIn.setBounds(180, 112, 121, 41);
		panel.add(lblLogIn);
		
		JButton btnEnter = new JButton("Enter");
		btnEnter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
                                Search();
                                dispose();
			}
                        
                        private void Search() {
                               String Nurse = null;
                               String Doctor = null;
                               String username = textField.getText();
                               String password = passwordField.getText();
                               Connection connect = null;
                               try {
                                    Class.forName("org.sqlite.JDBC");
                                    connect = DriverManager.getConnection("jdbc:"
                                            + "sqlite:C:/Users/Ketra/Documents/"
                                            + "School Folders/Software "
                                            + "Engineering/TestDB.db");
                                    stmt = connect.createStatement();
                                    System.out.println(stmt);
                                    result = stmt.executeQuery("Select lastName,"
                                            + " username,"
                                            + "password,permission from Users "
                                            + "where username='" + username + 
                                            "' and password='" + password + "'");
                                    if (result.next()){
                                        String x;
                                        x = result.getString("permission");
                                        System.out.println(x);
                                        
                                        /*These if statements setermine which 
                                         * screen needs to open*/
                                       if (x.startsWith("Nur")){
                                              Nurse nurseGUI = new Nurse();
                                              nurseGUI.setVisible(true);
                                              
                                        } else if (x.startsWith("Doc")){
                                            System.out.println("You are a doctor");
                                            Doctor doctorGUI = new Doctor();
                                            doctorGUI.setVisible(true);
                                             
                                        } else if (x.startsWith("Adm")){
                                            System.out.println("You are an admin");
                                            Administrator adminGUI = new Administrator();
                                            adminGUI.setVisible(true);
                                              
                                        } else {
                                            System.out.println("You are a pharmicist");
                                            Pharmacy pharmacyGUI = new Pharmacy();
                                            pharmacyGUI.setVisible(true);
                                        }
                                    }else{
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

           
		});
		btnEnter.setFont(new Font("Calibri", Font.PLAIN, 14));
		btnEnter.setBounds(162, 279, 89, 23);
		panel.add(btnEnter);
		
		JButton btnQuit = new JButton("Quit");
		btnQuit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});
		btnQuit.setFont(new Font("Calibri", Font.PLAIN, 14));
		btnQuit.setBounds(265, 279, 89, 23);
		panel.add(btnQuit);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(265, 232, 109, 20);
		panel.add(passwordField);
	}

    Test(NewJFrame aThis) {
        throw new UnsupportedOperationException("Not yet implemented");
    }
    
    
    
}