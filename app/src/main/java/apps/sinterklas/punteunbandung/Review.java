package apps.sinterklas.punteunbandung;

/**
 * Created by user pc on 4/27/2019.
 */

public class Review {

    public Review(String id, String coment) {
        this.id = id;
        this.coment = coment;
    }

    public Review() {
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getComent() {
        return coment;
    }

    public void setComent(String coment) {
        this.coment = coment;
    }

    String id;
    String coment;
}
