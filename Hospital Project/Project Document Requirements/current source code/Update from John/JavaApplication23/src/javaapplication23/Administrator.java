/* This window opens up when the user logs in and if their premissions, listed 
 * in the database, is administrator. This window allows the administrator to 
 * to delete a user and enter a new user. (97 Lines)
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


public class Administrator extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Administrator frame = new Administrator();
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
	public Administrator() {
                super("Administrative Station");
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
				Test loginGUI = new Test();
                                loginGUI.setVisible(true);
                                dispose();
			}
		});                
		button.setBackground(Color.RED);
		button.setBounds(452, 29, 122, 35);
		contentPane.add(button);
		
		JLabel lblAdministrator = new JLabel("Administrator");
		lblAdministrator.setHorizontalAlignment(SwingConstants.CENTER);
		lblAdministrator.setFont(new Font("Calibri", Font.PLAIN, 26));
		lblAdministrator.setBounds(191, 16, 155, 56);
		contentPane.add(lblAdministrator);
		
                
                /*When this button is pressed it will open up a new window which
                 * will allow the user to create a new user 
                 */
		JButton btnEnterNewUser = new JButton("Create New User");
		btnEnterNewUser .addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				NewUser newUser = new NewUser();
                                newUser.setVisible(true);
                                dispose();
			}
		});                 
		btnEnterNewUser.setBounds(133, 83, 138, 35);
		contentPane.add(btnEnterNewUser);

                /*When this button is pressed it will open up a new window which
                 * will allow the user to delete an existing user 
                 */
		JButton btnDeleteExistingUser = new JButton("Delete Existing User");
		btnDeleteExistingUser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				DeleteUser deleteUser = new DeleteUser();
                                deleteUser.setVisible(true);
                                dispose();
			}
		});                 
		btnDeleteExistingUser.setBounds(288, 83, 138, 35);
		contentPane.add(btnDeleteExistingUser);
	}
}