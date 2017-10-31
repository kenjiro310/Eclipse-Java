package drug; 
import java.io.*; 
import java.util.List; 
import java.util.Scanner; 
  
//Each User object represents one authorized User of the software. It has four sub-classes, each with 
//their own user information and schedule. 
public class user { 
    String username; 
    String password; 
    String firstName; 
    String lastName; 
    String permission; 
    String[] schedule; 
    String page;
    user u; 
    user currentUser; 
    //static List<User> userDB; 
      
    int i = 1; 
    int command; 
    int listIndex; 
      
    /*private User(String un, String pw, String fN, String lN, String prmsn) { 
        username = un; 
        password = pw; 
        firstName = fN; 
        lastName = lN; 
        permission = permission; 
    } */
  /*
    public static String getUsername(User u) { 
        return u.username; 
    } 
      
    public static String getpassword(User u) { 
        return u.password; 
    } 
  
    public static String getFirstName(User u) { 
        return u.firstName; 
    } 
      
    public static String getLastName(User u) { 
        return u.lastName; 
    } 
      */
    //Method allows the modification of the array containing the User's schedule. 
    //Precondition: The element index and new string are passed to the Method. The index 
    //number represents Sunday for 0, Monday for 1, and so on up to 6 for Saturday. 
    //Postcondition: The array is changed to reflect the User's updated schedule. 
    public void changeSchedule(int i, String str) { 
        u.schedule[i] = str; 
    } 
      
    //Method checks the database for the User's username and login pair. If found, it 
    //displays the home screen that matches the User's permission. If no matching  
    //username or password is found, it prints "bad username/password" and refreshes 
    //the login screen. 
    //Precondition: The entered username and password pair are passed to the method. 
    //Postcondition: If a matching username and password are found, the User's permission 
    //is returned. Else, an empty string is returned. 
    public void login(String un, String pw) { 
        username = un; 
        password = pw;
        for(int i=0;i<DrugMain.userList.size();i++){
            user check = DrugMain.userList.get(i);
            if(check.username.equals(username)){
                if(password.equals(check.password)){
                    if(check.permission.equals("doctor")){
                        DrugMain.doctorView();
                    }
                    if(check.permission.equals("nurse")){
                        DrugMain.nurseView();
                    }
                    if(check.permission.equals("admin")){
                        DrugMain.adminView();
                    }
                    if(check.permission.equals("pharmacy")){
                        DrugMain.pharmView();
                    }
                }
                else{
                    System.out.println("Invalid Password");
                }
                System.out.println("Invalid Username");
            }
        }
        /*
        if(username.equals("doctor")){
            if(password.equals("123")){
                DrugMain.doctorView();
                return;
            }
            else{
                System.out.println("Incorrect Password");
            }
        }
        if(username.equals("nurse")){
            if(password.equals("123")){
                DrugMain.nurseView();
                return;
            }
            else{
                System.out.println("Incorrect Password");
            }
        }
        if(username.equals("pharmacy")){
            if(password.equals("123")){
                DrugMain.pharmView();
                return;
            }
            else{
                System.out.println("Incorrect Password");
            }
        }
        if(username.equals("admin")){
            if(password.equals("123")){
                DrugMain.adminView();
                return;
            }
            else{
                System.out.println("Incorrect Password");
            }
        }
        if(username.equals("super")){
            if(password.equals("123")){
                DrugMain.superUser();
                return;
            }
            else{
                System.out.println("Incorrect Password");
            }
        }
        */
        /*
        //listIndex = userList.size(); 
        i = 0; 
        while(i < listIndex) { 
            u = userList.get(i); 
            if(u.username.equals(username)) { 
                if(u.password.equals(password)) { 
                    permission = u.permission; 
                    if(permission.equals("doctor")) { 
                        DrugMain.doctorView(); 
                    } else if(permission.equals("nurse")) { 
                        DrugMain.nurseView(); 
                    } else if(permission.equals("administrator")) { 
                        DrugMain.adminView(); 
                    } else if(permission.equals("pharmacist")) { 
                        DrugMain.pharmView(); 
                    } 
                } 
            } 
        }
        */
        System.out.println("Username/Password incorrect, please try again."); 
        //display(LoginGUI); 
    } 
      
    //Method scans the entered first name, last name, username, password and permission 
    //and passes it to the User() method to create a new User object. 
    //Precondition: The method is called and scans the entered first and last names,  
    //username, password, and permission. 
    //Postcondition: The method creates a new User object with those arguments and adds  
    //it to the database, but does not return anything to the method that called it. 
    public static int newUser() { 
        Scanner in = new Scanner(System.in);
        user a = new user();
        System.out.println("Enter Username"); 
        a.username = in.next(); 
        System.out.println("Enter Password"); 
        a.password = in.next(); 
        System.out.println("Enter Last Name"); 
        a.lastName = in.next(); 
        System.out.println("Enter Permision"); 
        a.permission = in.next(); 
        DrugMain.userList.add(a);
        return 0;
    } 
    
    public static int editUser() {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter Username To Edit: ");
        String un = in.next();
        System.out.println("Enter Password To Edit: ");
        String pw = in.next();
        for(int i=0; i<DrugMain.userList.size();i++){
            user check = DrugMain.userList.get(i);
            if(un.equals(check.username)){
                if(pw.equals(check.password)){
                    System.out.println("You Have Selected "+check.permission+" "+check.lastName);
                    System.out.println("What Information Do You Wish To Edit?");
                    System.out.println("1 For Username");
                    System.out.println("2 For Password");
                    System.out.println("3 For Last Name");
                    System.out.println("4 For Permision");
                    String command = in.next();
                    if(command.equals("1")){
                        System.out.println("Enter New Username: ");
                        check.username = in.next();
                        return 0;
                    }
                    if(command.equals("2")){
                        System.out.println("Enter New Password: ");
                        check.password = in.next();
                        return 0;
                    }
                    if(command.equals("3")){
                        System.out.println("Enter New Last Name: ");
                        check.lastName = in.next();
                        return 0;
                    }
                    if(command.equals("4")){
                        System.out.println("Enter New Permission: ");
                        check.permission = in.next();
                        return 0;
                    }
                }
                else{
                    System.out.println("Invalid Password");
                }
            }
            else{
                System.out.println("Username Not Found");
            }
        }
        
        return 0;
    }
    //Method scans the entered first and last name, then searches the database for the  
    //matching pair, and then sets that User as the current User. 
    //Precondition: The method is called and scans the entered first and last name. 
    //Postcondition: The method sets the User object with matching first and last 
    //names to the current User variable or prints "User not found." 
    /*
    public void setCurrentUser() { 
        Scanner in = new Scanner(System.in); 
        System.out.println("Enter User's first name"); 
        firstName = in.next(); 
        System.out.println("Enter User's last name"); 
        lastName = in.next(); 
        listIndex = userList.size(); 
        i = 0; 
        while(i < listIndex) { 
            u = userList.get(i); 
            if(u.firstName.equals(firstName)) { 
                if(u.lastName.equals(lastName)) { 
                    currentUser = u; 
                    System.out.println("Current User is " + currentUser.firstName + " " + currentUser.lastName); 
                } 
            } else { 
                i++; 
            }    
        } 
        System.out.println("Error: User not found"); 
    } 
      */
    //Method changes the username of the current User. 
    //Precondition: The method is called and scans in the new username. 
    //Postcondition: The current User's username is set to the new username. 
    public void changeUsername() { 
        Scanner in = new Scanner(System.in); 
        System.out.println("Enter new username for current User"); 
        username = in.next(); 
        currentUser.username = username; 
        System.out.println("Current User's username has been changed"); 
    } 
      
    //Method changes the password of the current User. 
    //Precondition: The method is called and scans in the new password. 
    //Postcondition: The current User's password is set to the new password. 
    public void changePassword() { 
        Scanner in = new Scanner(System.in); 
        System.out.println("Enter new password for current User"); 
        password = in.next(); 
        currentUser.password = password; 
        System.out.println("Current User's password has been changed"); 
    } 
      
    //Method changes the first name of the current User. 
    //Precondition: The method is called and scans in the new first name. 
    //Postcondition: The current User's first name is set to the new first name. 
    public void changeFirstName() { 
        Scanner in = new Scanner(System.in); 
        System.out.println("Enter new first name for current User"); 
        firstName = in.next(); 
        currentUser.firstName = firstName; 
        System.out.println("Current User's first name has been changed"); 
    } 
      
    //Method changes the last name of the current User. 
    //Precondition: The method is called and scans in the new last name. 
    //Postcondition: The current User's last name is set to the new last name. 
    public void changeLastName() { 
        Scanner in = new Scanner(System.in); 
        System.out.println("Enter new last name for current User"); 
        lastName = in.next(); 
        currentUser.lastName = lastName; 
        System.out.println("Current User's last name has been changed"); 
    }
    
    public static int sendPage(){
        Scanner in = new Scanner(System.in);
        System.out.println("Enter the username you would like to page: ");
        String find = in.next();
        int i = 0;
        while(i<DrugMain.userList.size()){
            user check = DrugMain.userList.get(i);
            if(find.equals(check.username)){
                System.out.println("Enter Page: ");
                check.page = in.next();
                return 0;
            }
            else{
                System.out.println("User Not Found");
            }
        }
        return 0;
    }

  
    public static int readPage(){
        Scanner in = new Scanner(System.in);
        System.out.println("For Security Please Re-enter your Username");
        String un = in.next();
        for(int i=0;i<DrugMain.userList.size();i++){
            user check = DrugMain.userList.get(i);
            if(un.equals(check.username)){
                System.out.println(check.page);
            }
        }
        return 0;
    } 
} 