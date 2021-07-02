import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class MessageDAO {

    public static void createMessageDB(Message msj) {
        DBConnection dbconn = new DBConnection();

        try(Connection conn = dbconn.getConnection())  {
            PreparedStatement ps=null;
            try{
                String query="INSERT INTO messages ( message, author) VALUES (?,?)";
                ps=conn.prepareStatement(query);
                ps.setString(1, msj.getMessage());
                ps.setString(2, msj.getAuthor());
                ps.executeUpdate();
                System.out.println("Message created");

            }catch(SQLException ex){
                System.out.println(ex);
            }
        }catch(SQLException e){
            System.out.println(e);
        }
    }

    public static void readMensajeDB() {

    }

    public static void updateMensajeDB(int idMensaje) {

    }

    public static void deleteMensajeDB(Message msj) {

    }

}
