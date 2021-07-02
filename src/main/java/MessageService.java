import java.util.Scanner;

public class MessageService {

    public static void createMessage() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter your message");
        String message = sc.nextLine();

        System.out.println("Your name");
        String name = sc.nextLine();

        Message register = new Message();
        register.setMessage(message);
        register.setAuthor(name);
        MessageDAO.createMessageDB(register);
    }

    public static void readMessage() {

    }

    public static void updateMessage() {

    }

    public static void deleteMessage() {

    }
}
