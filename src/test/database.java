package test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class database {
    public static void create(String user_id) throws Exception {
        Connection link = null;
        Statement state = null;

        try {
            Class.forName("org.sqlite.JDBC");
            link = DriverManager.getConnection("jdbc:sqlite:database/dummy.db");
            state = link.createStatement();

             String command = "CREATE TABLE DATA_"+user_id+" " +
                       "(site_name      LONGTEXT, " +
                       " user_name      TINYTEXT, " +
                       " password       TINYTEXT, " +
                       " icon            MEDIUMBLOB);";
            state.executeUpdate(command);
            state.close();
            link.close();
        }
        catch (ClassNotFoundException ex)
        {
           System.err.println(ex.getClass().getName() + " : " + ex.getMessage());
           System.out.println("File / Table does not exists");
           System.exit(0);
        }


        catch (SQLException e)
        {
            System.out.println("Database is locked trying exception");
        }


        finally {
            if (state != null)
            {
                state.close();
            }
            if (link != null) {
                link.close();
            }
            System.out.println(" Connection Closed");
        }
    }
}
