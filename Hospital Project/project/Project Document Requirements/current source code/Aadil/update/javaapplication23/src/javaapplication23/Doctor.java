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
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.JFrame;


public class Doctor extends JFrame {

	private JPanel contentPane;

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
		
		JButton btnNewButton = new JButton("J. Adams 105");
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
		btnNewButton.addActionListener(new ActionListener() {
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
		btnNewButton.addActionListener(new ActionListener() {
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
        
        
}