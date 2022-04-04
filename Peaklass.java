import java.io.*;
import java.util.Scanner;

class Peaklass {
    public static void main(String[] args) {

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
        FileInputStream fileStream = null;
        try {
            fileStream = new FileInputStream("file.txt");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        // Creating an object input stream
        ObjectInputStream objStream = null;
        try {
            objStream = new ObjectInputStream(fileStream);
        } catch (IOException e) {
            e.printStackTrace();
        }

        //Using the readInt() method
        Inventar inventar = null;
        try {
            inventar = (Inventar) objStream.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        Scanner triipkoodiLugeja = new Scanner(System.in);
        while (true) {
            System.out.println("Loe kood: ");
            Triipkood kood = new Triipkood(triipkoodiLugeja.nextLine());
            System.out.println(kood);
            System.out.println(inventar.getTehnika(kood));
        }

    }
}
