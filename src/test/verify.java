package test;

import java.sql.*;
import java.util.Scanner;

public class verify {
    public static void Verify() throws SQLException {
        Connection link = null;
        Statement state = null;

        String auth_pass = null;
        String auth_user_id = null;
        Scanner input=new Scanner(System.in);
        System.out.println("Enter the name ");
        String uname=input.next();
        System.out.println("Enter the password ");
        String password=input.next();

        try {
            Class.forName("org.sqlite.JDBC");
            link = DriverManager.getConnection("jdbc:sqlite:database/dummy.db");
            state = link.createStatement();
            link.setAutoCommit(false);
            String command = "SELECT *" +
                             "FROM VAL " +
                             "WHERE name LIKE '"+ uname +"' AND password LIKE '" + password + "';";
            ResultSet auth = state.executeQuery(command);

            while (auth.next())
            {
                auth_pass = auth.getString("password");
                auth_user_id = auth.getString("user_id");
            }

            link.commit();
            state.close();
            link.close();
            if (auth_pass != null)
            {
                System.out.println(uname+" authenticated  successfully ");
                System.out.println("Welcome ");
                dashboard.Dashboard(auth_user_id);
            }
            else
            {
                System.out.println("Error wrong ID/Password ");
                System.out.println("Try Again !!");
            }

        } catch (Exception e) {
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
            System.exit(0);
        }
        finally {
            if (link != null) {
                link.close();
            }
        }
    }
}
