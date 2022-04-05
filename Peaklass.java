import java.io.*;
import java.util.Scanner;

class Peaklass {
    public static void main(String[] args) throws IOException, ClassNotFoundException {


        //KUI UUENDADA KLASSE VÕI INVENTARI FAILI, SIIS PEAB SELLE UUESTI TEGEMA
        //Inventar inventar = loeInventarCSV("inventar.csv");

        Inventar inventar = loeInventarTXT("file.txt");

        Scanner triipkoodiLugeja = new Scanner(System.in);
        while (true) {
            System.out.println("Loe kood: ");
            String input = triipkoodiLugeja.nextLine();

            if (input.equals("")) {
                salvestaObjektFaili(inventar, "file.txt");
                return;
            }

            Triipkood kood = new Triipkood(input);
            System.out.println(inventar.getTehnika(kood));
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

}
