import java.io.*;
import java.util.List;
import java.util.Scanner;
//User Object
//Each User object represents one authorized User of the software. It has four sub-classes, each with
//their own user information and schedule.
public class User {
	private String username;
	private String password;
	private String firstName;
	private String lastName;
	private String[] schedule;
	static List<User> userDB;
	
	int i = 1;
	int command;
	int listIndex;
	User u;
	User currentUser;
	
	public User(String un, String pw, String fN, String lN) {
		username = un;
		password = pw;
		firstName = fN;
		lastName = lN;
	}

	public String getusername(User u) {
		return u.username;
	}
	
	public String getpassword(User u) {
		return u.password;
	}

	public String getFirstName(User u) {
		return firstName;
	}
	
	public String getLastName(User u) {
		return u.lastName;
	}
	
	//method allows an Administrator to change a User's username.
	//Precondition: The new username is passed to the object as a string
	//Postcondition: The object's variable username is changed to reference the new username
	public void changeUsername(String newUsername) {
		u.username = newUsername;
	}
	
	//method allows an Administrator to change a User's password.
	//Precondition: The new password is passed to the object as a string
	//Postcondition: The object's variable password is changed to reference the new password
	public void changePassword(String newPassword) {
		u.password = newPassword;
	}

	//method allows an Administrator to change a User's first name.
	//Precondition: The new first name is passed to the object as a string
	//Postcondition: The object's variable firstName is changed to reference the new first name
	public void changeFirstName(String newFirstName) {
		u.firstName = newFirstName;
	}
	
	//method allows an Administrator to change a User's last name.
	//Precondition: The new last name is passed to the object as a string
	//Postcondition: The object's variable lastName is changed to reference the new last name
	public void changeLastName(String newLastName) {
		u.lastName = newLastName;
	}

	//method allows the modification of the array containing the User's schedule
	//Precondition: The element index and new string are passed to the method. The index
	//number represents Sunday for 0, Monday for 1, and so on up to 6 for Saturday.
	//Postcondition: The array is changed to reflect the User's updated schedule.
	public void changeSchedule(int i, String str) {
		u.schedule[i] = str;
	}
	
	//main method
	public void main(String[] args) {
		while( i > -1){
			System.out.print("Enter an operation number: \n1: Create new User \n2:Select User to Edit \n3:Change username \n4:Change password \n5:Change first name \n6:Change last name \n7:Exit");
			Scanner in = new Scanner(System.in);
			command = in.nextInt();
			switch(command) {
				case 1: System.out.println("Enter first name");
						firstName = in.next();
						System.out.println("Enter last name");
						lastName = in.next();
						System.out.println("Enter username");
						username = in.next();
						System.out.println("Enter password");
						password = in.next();
						User newUser = new User(username, password, firstName, lastName);
						userDB.add(newUser);
						break;
						
				case 2: System.out.println("Enter User's first name");
						firstName = in.next();
						System.out.println("Enter User's last name");
						lastName = in.next();
						listIndex = userDB.size();
						i = 0;
						while(i < listIndex) {
							u = userDB.get(i);
							if(u.firstName.equals(firstName)) {
								if(u.lastName.equals(lastName)) {
									currentUser = u;
									System.out.println("Current User is " + currentUser.firstName + " " + currentUser.lastName);
									break;
								}
							} else {
								i++;
							}	
						}
						System.out.println("Error: User not found");
						break;
						
				case 3:	System.out.println("Enter new username for current User");
						username = in.next();
						currentUser.changeUsername(username);
						System.out.println("Current User's username has been changed");
						break;
						
				case 4:	System.out.println("Enter new password for current User");
						password = in.next();
						currentUser.changePassword(password);
						System.out.println("Current User's password has been changed");
						break;						
						
				case 5:	System.out.println("Enter new first name for current User");
						firstName = in.next();
						currentUser.changeFirstName(firstName);
						System.out.println("Current User's first name has been changed");
						break;	
				
				case 6:	System.out.println("Enter new last name for current User");
						lastName = in.next();
						currentUser.changeLastName(lastName);
						System.out.println("Current User's last name has been changed");
						break;	
						
				case 7: System.exit(1);
						break;
			}
		}
	}
}
