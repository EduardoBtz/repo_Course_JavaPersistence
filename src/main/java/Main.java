import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int opcion=0;

        do {
            System.out.println("-----------------");
            System.out.println(" Messages app:");
            System.out.println(" 1. Create");
            System.out.println(" 2. Read");
            System.out.println(" 3. Update");
            System.out.println(" 4. Delete");
            System.out.println(" 5. Exit");
            // User input.
            opcion = sc.nextInt();
            switch (opcion){
                case 1:
                    MessageService.createMessage();
                    break;
                case 2:
                    MessageService.readMessage();
                    break;
                case 3:
                    MessageService.updateMessage();
                    break;
                case 4:
                    MessageService.deleteMessage();
                    break;
                default:
                    break;
            }
        }while(opcion != 5);

    }
}
