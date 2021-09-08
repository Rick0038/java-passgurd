package test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class update {
    public static void Update_password(String user_id) throws Exception{
        Connection link = null;
        Statement state = null;
        Scanner input=new Scanner(System.in);

        try{
            Class.forName("org.sqlite.JDBC");
            link = DriverManager.getConnection("jdbc:sqlite:database/dummy.db");
            link.setAutoCommit(false);
            System.out.println("Enter site name");
            String site_name=input.next();
            System.out.println("Enter the new password name ");
            String new_password=input.next();
            state=link.createStatement();

            String command = " UPDATE DATA_"+user_id+
                             " SET password = '"+new_password+"'"+
                             " WHERE site_name = '"+site_name+"';";
            state.executeUpdate(command);
            link.commit();
            state.close();
            link.close();

        } catch (ClassNotFoundException e) {
            System.out.println("File/Database not found");
        }
        catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        finally {
            if (link != null) {
                link.close();
            }
            if (state!= null) {
                state.close();
            }
        }
    }


    public static void Update_user_name(String user_id) throws Exception{
        Connection link = null;
        Statement state = null;
        Scanner input=new Scanner(System.in);

        try{
            Class.forName("org.sqlite.JDBC");
            link = DriverManager.getConnection("jdbc:sqlite:database/dummy.db");
            link.setAutoCommit(false);
            System.out.println("Enter site name");
            String site_name=input.next();
            System.out.println("Enter the new user name ");
            String new_user_name=input.next();
            state=link.createStatement();

            String command = " UPDATE DATA_"+user_id+
                    " SET user_name = '"+new_user_name+"'"+
                    " WHERE site_name = '"+site_name+"';";
            state.executeUpdate(command);
            link.commit();
            state.close();
            link.close();

        } catch (ClassNotFoundException e) {
            System.out.println("File/Database not found");
        }
        catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        finally {
            if (link != null) {
                link.close();
            }
            if (state!= null) {
                state.close();
            }
        }
    }

    public static void Update_site_name(String user_id) throws Exception{
        Connection link = null;
        Statement state = null;
        Scanner input=new Scanner(System.in);

        try{
            Class.forName("org.sqlite.JDBC");
            link = DriverManager.getConnection("jdbc:sqlite:database/dummy.db");
            link.setAutoCommit(false);
            System.out.println("Enter old site name");
            String site_name=input.next();
            System.out.println("Enter the new site name ");
            String new_site_name=input.next();
            state=link.createStatement();

            String command = " UPDATE DATA_"+user_id+
                    " SET site_name = '"+new_site_name+"'"+
                    " WHERE site_name = '"+site_name+"';";
            state.executeUpdate(command);
            link.commit();
            state.close();
            link.close();

        } catch (ClassNotFoundException e) {
            System.out.println("File/Database not found");
        }
        catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        finally {
            if (link != null) {
                link.close();
            }
            if (state!= null) {
                state.close();
            }
        }
    }
}
