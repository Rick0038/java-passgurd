package test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class insertdata {
    public static void insert(String user_id) throws SQLException {
        Connection link = null;
        Statement state = null ;

        try {
            Class.forName("org.sqlite.JDBC");
            link = DriverManager.getConnection("jdbc:sqlite:database/dummy.db");
            state = link.createStatement();
            link.setAutoCommit(false);
            Scanner input = new Scanner(System.in);
            System.out.println("Enter The site name ");
            String site_name = input.next();
            System.out.println("Enter The user name ");
            String user_name = input.next();
            System.out.println("Enter The password");
            String password = input.next();


            String command = "INSERT INTO DATA_"+user_id+"(site_name,user_name,password) " +
                             "VALUES ('"+site_name+"','"+user_name+"','"+password+"');";
            state.executeUpdate(command);
            System.out.println("Inserted successfully ");
            link.commit();
            state.close();
            link.close();

        } catch (Exception e) {
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
            System.exit(0);
        }
        finally {
            if (link != null) {
                link.close();
            }
        }
        System.out.println(" Connection Closed");
    }
}
