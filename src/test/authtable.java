package test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.io.File;
import java.lang.Exception;

public class authtable {
    public static void create() throws Exception{

        Connection link = null;
        Statement state = null;
        try {
            Class.forName("org.sqlite.JDBC");
            link = DriverManager.getConnection("jdbc:sqlite:database/dummy.db");
            System.out.println("Successfully opened");

            make_struct(link,state);

        }

        catch (SQLException e){
            System.out.println("Dir Not exists creating one");
            File file = new File("database");
            boolean done = file.mkdir();
            if(done){
                System.out.println("Done");
            }
            create();
        }
        finally {
            if (state != null)
            {
                state.close();
            }
            if (link != null) {
                link.close();
            }
        }
    }

    public static void make_struct(Connection link, Statement state)throws Exception{
       try{
           state = link.createStatement();
           String command = "CREATE TABLE VAL " +
                   "(name              VARCHAR2," +
                   "password           TINYTEXT,"+
                   "user_id            MEDIUMTEXT NOT NULL);";
           state.executeUpdate(command);
           state.close();
           state.close();
       }
        catch(SQLException e){
            return;
        }
    }
}
