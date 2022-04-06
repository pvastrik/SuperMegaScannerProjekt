import java.io.*;
import java.time.LocalDate;
import java.util.Date;
import java.util.Scanner;

class Peaklass {
    public static void main(String[] args) throws IOException, ClassNotFoundException {


        //KUI UUENDADA KLASSE VÕI INVENTARI FAILI, SIIS PEAB SELLE UUESTI TEGEMA
        //Inventar inventar = loeInventarCSV("inventar.csv");

        Inventar inventar = loeInventarTXT("file.txt");

        Scanner triipkoodiLugeja = new Scanner(System.in);
        while (true) {
            kontrolliTehnikaAjalugu(triipkoodiLugeja, inventar);

            teostaLaenutus(triipkoodiLugeja, inventar);

        }

        /*KUI MÜNDA KLASSI MUUTA SIIS PEAB UUESTI JOOKSUTAMA VÄLJAKOMMENTEERITUD OSA!!!!!!!!!!!!!*/
//        Inventar inventar = new Inventar("inventar.csv");
//        System.out.println(inventar);
////                Scanner triipkoodiLugeja = new Scanner(System.in);
////                while (true) {
////                    System.out.println("Loe kood: ");
////                    Triipkood kood = new Triipkood(triipkoodiLugeja.nextLine());
////
////                }
//        FileOutputStream file = null;
//        try {
//            file = new FileOutputStream("file.txt");
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        }
//
//        // Creates an ObjectOutputStream
//        ObjectOutputStream output = null;
//        try {
//            output = new ObjectOutputStream(file);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//        // writes objects to output stream
//        try {
//            output.writeObject(inventar);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

        /*file.txt-st input */
//        FileInputStream fileStream = null;
//        try {
//            fileStream = new FileInputStream("file.txt");
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        }
//        // Creating an object input stream
//        ObjectInputStream objStream = null;
//        try {
//            objStream = new ObjectInputStream(fileStream);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//        //Using the readInt() method
//        inventar = null;
//        try {
//            inventar = (Inventar) objStream.readObject();
//        } catch (IOException | ClassNotFoundException e) {
//            e.printStackTrace();
//        }
    }

    static Inventar loeInventarCSV(String failinimi) {
        return new Inventar("inventar.csv");
    }

    static Inventar loeInventarTXT(String failinimi) throws IOException, ClassNotFoundException {
        FileInputStream fileStream = null;
        fileStream = new FileInputStream(failinimi);

        // Creating an object input stream
        ObjectInputStream objStream = null;
        objStream = new ObjectInputStream(fileStream);

        //Using the readObject() method
        return (Inventar) objStream.readObject();

    }

    static void salvestaObjektFaili(Object o, String failinimi) throws IOException {
        FileOutputStream file = null;
        file = new FileOutputStream(failinimi);

        // Creates an ObjectOutputStream
        ObjectOutputStream output = null;

        output = new ObjectOutputStream(file);

        // writes objects to output stream

        output.writeObject(o);

    }

    static void teostaLaenutus(Scanner triipkoodiLugeja, Inventar inventar) throws IOException {
        System.out.print("Sisesta eesnimi, perenimi, isikukood: ");
        String input = triipkoodiLugeja.nextLine();
        String[] andmed = input.split(", ");
        Laenutaja laenutaja = otsiLaenutajat(andmed[2], inventar);

        if (laenutaja == null) {
            laenutaja = new Laenutaja(andmed[0], andmed[1], "50207232759");
        }


        System.out.print("Loe kood: ");
        String kood = triipkoodiLugeja.nextLine();

        if (kood.equals("")) {
            salvestaObjektFaili(inventar, "file.txt");
            return;
        }

        Triipkood triipkood = new Triipkood(kood);
        Tehnika tehnika = inventar.getTehnika(triipkood);

        System.out.println("Sisesta lõppkuupäev: ");
        String[] kuupäev = triipkoodiLugeja.nextLine().split("/");

        LocalDate dateLaenutus = LocalDate.of(Integer.parseInt(kuupäev[2]), Integer.parseInt(kuupäev[1]), Integer.parseInt(kuupäev[0]));
        Laenutus uusLaenutus = new Laenutus(laenutaja, tehnika, LocalDate.now(), dateLaenutus);
        laenutaja.lisaLaenutus(uusLaenutus);
        tehnika.lisaLaenutus(uusLaenutus);

    }

    static Laenutaja otsiLaenutajat(String isikukood, Inventar inventar) {
        for (Laenutaja l : inventar.getLaenutajad()) {
            if (l.getIsikukood() == isikukood) {
                return l;
            }
        }
        return null;
    }

    static void kontrolliTehnikaAjalugu(Scanner triipkoodiLugeja, Inventar inventar) {
        System.out.println("Sisesta kood: ");
        Triipkood kood = new Triipkood(triipkoodiLugeja.nextLine());
        Tehnika tehnika = inventar.getTehnika(kood);

        System.out.println(tehnika.getAjalugu());
    }
}
