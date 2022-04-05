import com.opencsv.CSVReader;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.Serializable;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

class Inventar implements Serializable {
    private List<Tehnika> koguVara;

    Inventar(String failinimi) {
        this.koguVara = new ArrayList<>();
        looInventarFailist(failinimi);
    }

    void looInventarFailist(String failinimi) {

        try (CSVReader reader = new CSVReader(new FileReader(failinimi))) {
            String[] nextLine;
            while ((nextLine = reader.readNext()) != null) {
                Triipkood kood = new Triipkood(nextLine[0]);
                Tehnika ese = new Tehnika(kood, nextLine[1]);
                koguVara.add(ese);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    Tehnika getTehnika(Triipkood triipkood) {
        for (Tehnika tehnika : koguVara) {
            if(triipkood.equals(tehnika.getTriipkood())) return tehnika;
        }
        throw new RuntimeException("Sellise koodiga tehnikat ei leitud.");
    }

    @Override
    public String toString() {
        return "Inventar{" +
                "koguVara=" + koguVara +
                '}';
    }
}
