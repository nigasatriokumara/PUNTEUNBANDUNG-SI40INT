package apps.sinterklas.punteunbandung;

/**
 * Created by user pc on 4/25/2019.
 */

public class Guider {

    public Guider(){

    }

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
        t

    his.nama = nama;
    }

    public String getDestinasi() {
        return destinasi;
    }

    public void setDestinasi(String destinasi) {
        this.destinasi = destinasi;
    }

    public String getNotelpon() {
        return notelpon;
    }

    public void setNotelpon(String notelpon) {
        this.notelpon = notelpon;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getBahasa() {
        return bahasa;
    }

    public void setBahasa(String bahasa) {
        this.bahasa = bahasa;
    }

    public String getImage_url() {
        return image_url;
    }

    public void setImage_url(String image_url) {
        this.image_url = image_url;
    }

    public Guider(String id, String nama, String destinasi, String notelpon, String email, String bahasa, String image_url) {
        this.id = id;
        this.nama = nama;
        this.destinasi = destinasi;
        this.notelpon = notelpon;
        this.email = email;
        this.bahasa = bahasa;
        this.image_url = image_url;
    }

    String id;
    String nama;
    String destinasi;
    String notelpon;
    String email;
    String bahasa;
    public String image_url;


}