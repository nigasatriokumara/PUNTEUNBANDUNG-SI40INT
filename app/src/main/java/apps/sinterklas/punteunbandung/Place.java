package apps.sinterklas.punteunbandung;

/**
 * Created by user pc on 4/23/2019.
 */

public class Place {

    public Place(){

    }

    public Place(String td, String title, String deskripsi, String image_url) {
        this.td = td;
        this.title = title;
        this.deskripsi = deskripsi;
        this.image_url = image_url;
    }

    public String getTd() {
        return td;
    }

    public void setTd(String td) {
        this.td = td;
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

    String td;
    String title;
    String deskripsi;
    public String image_url;




}
