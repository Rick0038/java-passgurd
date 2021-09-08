package test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class showdata {

    public static void address_out (String user_id) throws  Exception{
        Connection link = null;
        Statement state = null;

        try {
            Class.forName("org.sqlite.JDBC");
            link = DriverManager.getConnection("jdbc:sqlite:database/dummy.db");
            link.setAutoCommit(false);
            System.out.println("Opened database successfully");
            String command = "SELECT * " +
                             "FROM DATA_"+user_id+";";
            state = link.createStatement();
            try (ResultSet rs = state.executeQuery(command)) {

                while (rs.next()) {
                    String address = rs.getString("site_name");
                    System.out.println(address);
                }
            }
            link.commit();
            state.close();
            link.close();
        }
        catch ( Exception e ) {
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
        }
        finally {
            if (link != null) {
                link.close();
            }
        }
    }


    public static void address_details(String user_id) throws  Exception{
        Connection link = null;
        Statement state ;
        Scanner input = new Scanner(System.in);

        System.out.println("Enter the name of the entry ");
        String index = input.next();

        try {
            Class.forName("org.sqlite.JDBC");
            link = DriverManager.getConnection("jdbc:sqlite:database/dummy.db");
            link.setAutoCommit(false);
            String command = "SELECT * " +
                            "FROM DATA_"+user_id+" "+
                            "WHERE site_name LIKE '"+ index +"';";
            state = link.createStatement();
            try (ResultSet rs = state.executeQuery(command)) {

                while (rs.next()) {
                    String site_name = rs.getString("site_name");
                    System.out.println("\nSite name is :"+site_name);
                    String user_name = rs.getString("user_name");
                    System.out.println("user ID is :"+user_name);
                    String password = rs.getString("password");
                    System.out.println("Password is :"+password+"\n");

                    //    String icon = rs.getString("icon");
                    //    System.out.println(icon);

                }
            }
            link.commit();
            state.close();
            link.close();
        }
        catch ( Exception e ) {
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
        }
        finally {
            if (link != null) {
                link.close();
            }
        }

    }
}
