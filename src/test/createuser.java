package test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;

import java.util.Scanner;

public class createuser {
    public static void makeusr() throws SQLException {
        Connection link = null;
        Statement state = null;
        Date datetime = new Date();
        SimpleDateFormat format = new SimpleDateFormat("yyyyMMHHmmss");

        Scanner input=new Scanner(System.in);
        System.out.println("Enter the name ");
        String uname=input.next();
        System.out.println("Enter the password ");
        String password=input.next();
        String user_id = format.format(datetime);

        try {
            Class.forName("org.sqlite.JDBC");
            link = DriverManager.getConnection("jdbc:sqlite:database/dummy.db");
            state = link.createStatement();
            link.setAutoCommit(false);

            String command = "INSERT INTO VAL (name,password,user_id) " +
                             "VALUES ('"+ uname +"','" + password + "',"+user_id+");";
            state.executeUpdate(command);
            System.out.println("User Created successfully ");
            state.close();
            link.commit();
            link.close();
            database.create(user_id);

        } catch (Exception e) {
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
            System.exit(0);
        }
        finally {
            if (link != null) {
                link.close();
            }
            if (state != null){
                state.close();;
            }
        }
    }
}
