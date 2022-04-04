import java.util.ArrayList;
import java.util.List;

class Laenutaja {
    private String eesnimi;
    private String perenimi;
    private String isikukood;
    private String email;
    private List<Laenutus> laenutused = new ArrayList<>();

    public Laenutaja(String eesnimi, String perenimi, String isikukood, String email) {
        this.eesnimi = eesnimi;
        this.perenimi = perenimi;
        this.isikukood = isikukood;
        this.email = email;
    }

    public void lisaLaenutus(Laenutus laenutus) {
        laenutused.add(laenutus);
    }

    public String getEesnimi() {
        return eesnimi;
    }

    public String getPerenimi() {
        return perenimi;
    }

    public String getIsikukood() {
        return isikukood;
    }

    public String getEmail() {
        return email;
    }

    public List<Laenutus> getLaenutused() {
        return laenutused;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
