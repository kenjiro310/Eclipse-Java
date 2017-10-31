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


public class Pharmacy extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Pharmacy frame = new Pharmacy();
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
	public Pharmacy() {
		setTitle("Superior Hospital Systems");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 500);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 153, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton button = new JButton("Sign Out");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});
		button.setBackground(Color.RED);
		button.setBounds(452, 29, 122, 35);
		contentPane.add(button);
		
		JLabel lblPharmacy = new JLabel("Pharmacy");
		lblPharmacy.setHorizontalAlignment(SwingConstants.CENTER);
		lblPharmacy.setFont(new Font("Calibri", Font.PLAIN, 26));
		lblPharmacy.setBounds(191, 16, 155, 56);
		contentPane.add(lblPharmacy);
		
		JButton btnNewButton = new JButton("Fill Prescription");
		btnNewButton.setBounds(139, 103, 122, 35);
		contentPane.add(btnNewButton);
		
		JButton btnEnterNewDrug = new JButton("Enter New Drug");
		btnEnterNewDrug.setBounds(271, 103, 122, 35);
		contentPane.add(btnEnterNewDrug);
	}

}
