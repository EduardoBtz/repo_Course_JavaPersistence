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
        }catch(IOException e) {
            System.out.println(e);
        }

    }

    public CatService() {

    }
}
