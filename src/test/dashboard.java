package test;

import java.util.Scanner;

public class dashboard {
    public static void Dashboard(String user_id) throws Exception{
        int n = 1;
        int choice ;
        Scanner input = new Scanner(System.in);

        do {
            System.out.println("Press 1 to show all entries ");
            System.out.println("Press 2 to show details of a entry");
            System.out.println("Press 3 to create a new entry");
            System.out.println("Press 4 to update an existing entry ");
            System.out.println("Press 5 to Exit");
            choice = input.nextInt();
            switch (choice){
                case 1 :showdata.address_out(user_id);
                        break;
                case 2 :showdata.address_details(user_id);
                        break;
                case 3 : insertdata.insert(user_id);
                    break;
                case 4 : UpdateMenu.Dashboard(user_id);
                    break;
                case 5:  n = 0;
                    System.exit(0);
                    break;
                default:System.out.println("Input error ");
            }
        }while (n == 1);
    }
}
