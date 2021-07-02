public class Cat {
    private int id;
    private String url;
    private static String apikey = "74668d02-a299-40ae-bb05-130d2e65c227";
    private String image;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public static String getApikey() {
        return apikey;
    }

    public static void setApikey(String apikey) {
        Cat.apikey = apikey;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
