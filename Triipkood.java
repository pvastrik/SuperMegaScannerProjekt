import java.io.Serializable;

class Triipkood implements Serializable, Comparable<Triipkood> {
    private String kood;

    Triipkood(String triipkood) {
//        this.unikaalneKood = triipkood.substring(2);
//        this.esemeKood = triipkood.substring(0,2);
        this.kood = triipkood;
    }

    public String getKood() {
        return kood;
    }

    @Override
    public String toString() {
        return kood;
    }

    @Override
    public int compareTo(Triipkood o) {
        if (Integer.parseInt(this.kood)> Integer.parseInt(o.getKood())) {
            return 1;
        }
        if (Integer.parseInt(this.kood)< Integer.parseInt(o.getKood())) {
            return -1;
        }
        return 0;
    }
}
