import java.util.Date;

class Laenutus {
    private Laenutaja laenutaja;
    private Date algus;
    private Date lopp;
    private Date lopetatud;
    private String markused;

    public Laenutus(Laenutaja laenutaja, Date algus, Date lopp) {
        this.laenutaja = laenutaja;
        this.algus = algus;
        this.lopp = lopp;
    }

    public Laenutaja getLaenutaja() {
        return laenutaja;
    }

    public Date getAlgus() {
        return algus;
    }

    public Date getLopp() {
        return lopp;
    }

    public Date getLopetatud() {
        return lopetatud;
    }

    public String getMarkused() {
        return markused;
    }

    public void setLopetatud(Date lopetatud) {
        this.lopetatud = lopetatud;
    }

    public void setMarkused(String markused) {
        this.markused = markused;
    }
}
