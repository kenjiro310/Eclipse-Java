//STEP 1. Import required packages
import java.sql.*;

public class FirstExample {
 
   
   public static void main(String[] args) {
   Connection connect = null;
   Statement stmt = null;
   try{
      Class.forName("org.sqlite.JDBC");
      connect = DriverManager.getConnection("jdbc:"
        + "sqlite:C:/sqlite/data.db");
      stmt = connect.createStatement();
      String sql;
      sql = "SELECT first name, last name, room number FROM Patient";
      ResultSet rs = stmt.executeQuery(sql);

      //STEP 5: Extract data from result set
      while(rs.next()){
         //Retrieve by column name
         int room = rs.getInt("room number");
         String first = rs.getString("first name");
         String last = rs.getString("last name");

         //Display values
         System.out.print(first);
         System.out.print(" " + last);
         System.out.println(", "room);
      }
      //STEP 6: Clean-up environment
      rs.close();
      stmt.close();
      conn.close();
   }catch(SQLException se){
      //Handle errors for JDBC
      se.printStackTrace();
   }catch(Exception e){
      //Handle errors for Class.forName
      e.printStackTrace();
   }finally{
      //finally block used to close resources
      try{
         if(stmt!=null)
            stmt.close();
      }catch(SQLException se2){
      }// nothing we can do
      try{
         if(conn!=null)
            conn.close();
      }catch(SQLException se){
         se.printStackTrace();
      }//end finally try
   }//end try
   System.out.println("Goodbye!");
}//end main
}//end FirstExample