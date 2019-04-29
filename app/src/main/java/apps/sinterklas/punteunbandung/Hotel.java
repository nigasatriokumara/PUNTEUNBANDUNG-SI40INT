package apps.sinterklas.punteunbandung;

/**
 * Created by user pc on 4/27/2019.
 */

public class Hotel {

    public Hotel(String id, String nama, String lokasi, String image_url) {
        this.id = id;
        this.nama = nama;
        this.lokasi = lokasi;
        this.image_url = image_url;
    }

    public Hotel(){}

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getLokasi() {
        return lokasi;
    }

    public void setLokasi(String lokasi) {
        this.lokasi = lokasi;
    }

    public String getImage_url() {
        return image_url;
    }

    public void setImage_url(String image_url) {
        this.image_url = image_url;
    }

    String id;
    String nama;
    String lokasi;
    public String image_url;
}
