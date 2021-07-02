import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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

    public static void readMessageDB() {
        DBConnection dbconn = new DBConnection();

        PreparedStatement ps = null;
        ResultSet rs = null;

        try(Connection conexion = dbconn.getConnection())  {
            String query="SELECT * FROM messages";
            ps=conexion.prepareStatement(query);
            rs=ps.executeQuery();

            while(rs.next()){
                System.out.println("ID: "+rs.getInt("idMessage"));
                System.out.println("Message: "+rs.getString("message"));
                System.out.println("Author: "+rs.getString("author"));
                System.out.println("Date: "+rs.getString("date"));
                System.out.println("");
            }
        }catch(SQLException e){
            System.out.println("Could not retrieve messages.");
            System.out.println(e);
        }
    }

    public static void updateMessageDB(Message message) {
        DBConnection dbconn = new DBConnection();

        try(Connection conn = dbconn.getConnection())  {
            PreparedStatement ps = null;

            try{
                String query="UPDATE message SET message = ? WHERE idMessage = ?";
                ps = conn.prepareStatement(query);
                ps.setString(1, message.getMessage());
                ps.setInt(2, message.getIdMessage());
                ps.executeUpdate();
                System.out.println("Message was updated correctly.");
            }catch(SQLException ex){
                System.out.println(ex);
                System.out.println("Could not update message.");
            }
        }catch(SQLException e){
            System.out.println(e);
        }
    }

    public static void deleteMessageDB(int idMessage) {
        DBConnection dbconn = new DBConnection();

        try(Connection conn = dbconn.getConnection())  {
            PreparedStatement ps = null;

            try {
                String query="DELETE FROM messages WHERE idMessage = ?";
                ps = conn.prepareStatement(query);
                ps.setInt(1, idMessage);
                ps.executeUpdate();
                System.out.println("Message has been deleted");
            }catch(SQLException e) {
                System.out.println(e);
                System.out.println("Could not delete message.");
            }

        }catch(SQLException e){
            System.out.println(e);
        }
    }

}
