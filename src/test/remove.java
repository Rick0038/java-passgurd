package test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class remove {
    public static void del_once() throws SQLException {
        Scanner input=new Scanner(System.in);
        Connection link = null;
        Statement state ;
        try {
            Class.forName("org.sqlite.JDBC");
            link = DriverManager.getConnection("jdbc:sqlite:database/dummy.db");
            link.setAutoCommit(false);
            System.out.println("Opened database successfully");
            System.out.println("Enter the ID to be removed ");
            String id=input.next();
            state=link.createStatement();
            String command = "DELETE from COMPANY where ID="+id+";";
            System.out.println("Erasing entry no: "+id);
            state.executeUpdate(command);
            link.commit();
            state.close();

        } catch (Exception e) {
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
            System.exit(0);
        }

        finally {
            if (link != null) {
                link.close();
            }
            System.out.println(" Connection Closed");
        }
    }

    public static void del_many() throws SQLException {
        Connection link = null;
        Statement state ;
        try {
            Class.forName("org.sqlite.JDBC");
            link = DriverManager.getConnection("jdbc:sqlite:database/dummy.db");
            link.setAutoCommit(false);
            System.out.println("Opened database successfully");
            state=link.createStatement();
            String command = "DELETE from COMPANY;";
            System.out.println("Erasing all entries ");
            state.executeUpdate(command);
            link.commit();
            state.close();

        } catch (Exception e) {
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
            System.exit(0);
        }

        finally {
            if (link != null) {
                link.close();
            }
            System.out.println(" Connection Closed");
        }
    }
}
