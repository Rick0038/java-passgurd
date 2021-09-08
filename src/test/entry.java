package test;

import java.util.Scanner;

public class entry {
    public static void main(String[] args) throws Exception {
        int n = 1;
        int choice ;
        Scanner input = new Scanner(System.in);

        System.out.println("Hello user welcome to test ");
        System.out.println("Lets go ");
        authtable.create();


        do {
            System.out.println("Press 1 to Log in ");
            System.out.println("Press 2 to Create a new user");
            System.out.println("Press 3 to Exit");
            choice = input.nextInt();
            switch (choice){
                case 1 : verify.Verify();
                         break;
                case 2 : createuser.makeusr();
                         break;
                case 3:  n = 0;
                         System.exit(0);
                         break;
                default:System.out.println("Input error ");
            }

        }while (n == 1);
        

        // BUG : EXCEPTION ERROR IF PUT STRING IN CHOICE INPUT

       
    /*  System.out.println("Create Database");
        database.create();
        System.out.println("Insert data into Database");
        insertdata.insert();
        System.out.println("Print one data from Database");
        printdata.out_once();
        System.out.println("Delete one entry from Database");
        remove.del_once();
        System.out.println("Update name in the Database");
        update.up_name();
        System.out.println("Update age in the Database");
        update.up_age();
        System.out.println("Print all data from Database");
        printdata.out_all();
        System.out.println("Delete everything Database");
        remove.del_many(); */
    }
}