package apps.sinterklas.punteunbandung;

/**
 * Created by user pc on 4/25/2019.
 */

public class Event {

    public Event(String id, String title, String deskripsi, String image_url) {
        this.id = id;
        this.title = title;
        this.deskripsi = deskripsi;
        this.image_url = image_url;
    }

    public Event() {
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDeskripsi() {
        return deskripsi;
    }

    public void setDeskripsi(String deskripsi) {
        this.deskripsi = deskripsi;
    }

    public String getImage_url() {
        return image_url;
    }

    public void setImage_url(String image_url) {
        this.image_url = image_url;
    }

    String id;
    String title;
    String deskripsi;
    public String image_url;
}
