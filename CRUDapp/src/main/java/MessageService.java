import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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
        MessageDAO.readMessageDB();
    }

    public static void updateMessage() {
        Scanner sc = new Scanner(System.in);
        System.out.println("escribe tu nuevo mensaje");
        String mensaje = sc.nextLine();

        System.out.println("indica el ID del mensaje a editar");
        int idMessage = sc.nextInt();
        Message updating = new Message();
        updating.setIdMessage(idMessage);
        updating.setMessage(mensaje);
        MessageDAO.updateMessageDB(updating);
    }

    public static void deleteMessage() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the ID number of the message to delete.");
        int idMessage= sc.nextInt();
        MessageDAO.deleteMessageDB(idMessage);
    }
}
