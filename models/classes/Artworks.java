package models.classes;

public class Artworks {

    private int id;
    private String title, desc, image_path;
    private int userId;

    public Artworks(int id, String title, String desc, String image_path, int userId) {
        this.id = id;
        this.title = title;
        this.desc = desc;
        this.image_path = image_path;
        this.userId = userId;
    }
    public Artworks(){}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getImage_path() {
        return image_path;
    }

    public void setImage_path(String image_path) {
        this.image_path = image_path;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

}