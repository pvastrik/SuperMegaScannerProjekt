import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

class Tehnika implements Serializable {
    private Triipkood triipkood;
    private String kirjeldus;
    private List<Laenutus> ajalugu;

    Tehnika(Triipkood triipkood, String kirjeldus) {
        this.triipkood = triipkood;
        this.kirjeldus = kirjeldus;
        this.ajalugu = new ArrayList<>();
    }

    Triipkood getTriipkood() {
        return triipkood;
    }

    @Override
    public String toString() {
        return "Tehnika{" +
                "triipkood=" + triipkood +
                ", kirjeldus='" + kirjeldus + '\'' +
                "}";
    }
}