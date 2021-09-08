package test;

import java.util.Scanner;

public class UpdateMenu {
    public static void Dashboard(String user_id) throws Exception{
        int n = 1;
        int choice ;
        Scanner input = new Scanner(System.in);

        do {
            System.out.println("Press 1 to update password ");
            System.out.println("Press 2 to user id");
            System.out.println("Press 3 to site name");
            System.out.println("Press 4 to Exit");
            System.out.println("Press 5 to go to previous menu");
            choice = input.nextInt();
            switch (choice){
                case 1 : update.Update_password(user_id);
                    break;
                case 2 : update.Update_user_name(user_id);
                    break;
                case 3 : update.Update_site_name(user_id);
                    break;
                case 4:  n = 0;
                    System.exit(0);
                    break;
                case 5 : dashboard.Dashboard(user_id);
                    break;
                default:System.out.println("Input error ");
            }
        }while (n == 1);
    }
}
