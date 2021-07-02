import com.google.gson.Gson;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;
import java.awt.Image;
import java.io.IOException;
import java.net.URL;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

public class CatService {
    public static void seeCats() throws IOException {
        // Bring data from API
        OkHttpClient client = new OkHttpClient();

        // Requests from the endpoint that produces random image.
        Request request = new Request.Builder().url("https://api.thecatapi.com/v1/images/search").get().build();
        Response response = client.newCall(request).execute();

        String elJson = response.body().string();

        // Removes brackets
        elJson = elJson.substring(1, elJson.length());
        elJson = elJson.substring(0, elJson.length()-1);

        // Creates Gson object
        Gson gson = new Gson();
        Cat cats = gson.fromJson(elJson, Cat.class);

        // Redimention
        Image image = null;

        try {
            URL url = new URL(cats.getUrl());
            image = ImageIO.read(url);

            ImageIcon catBackground = new ImageIcon(image);

            if(catBackground.getIconWidth() < 800 ) {
                // Redimention
                Image fondo = catBackground.getImage();
                Image modificada = fondo.getScaledInstance(800, 600, java.awt.Image.SCALE_SMOOTH);
                catBackground = new ImageIcon(modificada);
            }

            String menu = "Options: \n"
                    + " 1. Look at another image\n"
                    + " 2. Favorite \n"
                    + " 3. Return \n";

            String[] botones = { "ver otra imagen", "favorito", "volver" };
            int idCat = cats.getId();
            String opcion = (String) JOptionPane.showInputDialog(null,menu,id_gato, JOptionPane.INFORMATION_MESSAGE, fondoGato, botones,botones[0]);

            int seleccion = -1;
            //validamos que opcion selecciona el usuario
            for(int i=0;i<botones.length;i++){
                if(opcion.equals(botones[i])){
                    seleccion = i;
                }
            }

            switch (seleccion){
                case 0:
                    seeCats();
                    break;
                case 1:
                    favoriteCat(cats);
                    break;
                default:
                    break;
            }

        }catch(IOException e) {
            System.out.println(e);
        }

    }

    public static void favoriteCat(Cat cat) {

    }
}
