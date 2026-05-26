package models;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class DataHandler {
    
    // Το όνομα του αρχείου στο οποίο θα σώζονται όλα τα δεδομένα
    private static final String FILE_NAME = "shelter_data.ser";

    /**
     * Μέθοδος για την αποθήκευση δεδομένων (Save)
     */
    public static void saveData(Object data) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_NAME))) {
            oos.writeObject(data);
            System.out.println("Τα δεδομένα αποθηκεύτηκαν επιτυχώς στο αρχείο " + FILE_NAME);
        } catch (IOException e) {
            System.out.println("Σφάλμα κατά την αποθήκευση: " + e.getMessage());
            e.printStackTrace();
        }
    }

    /**
     * Μέθοδος για την ανάκτηση δεδομένων (Load)
     */
    public static Object loadData() {
        File file = new File(FILE_NAME);
        
        // Αν είναι η πρώτη φορά που τρέχει η εφαρμογή, το αρχείο δεν θα υπάρχει 
        if (!file.exists()) {
            System.out.println("Δεν βρέθηκε αρχείο δεδομένων. Το σύστημα θα ξεκινήσει με τα προεπιλεγμένα δεδομένα.");
            return null;
        }

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
            Object data = ois.readObject();
            System.out.println("Τα δεδομένα φορτώθηκαν επιτυχώς από το αρχείο.");
            return data;
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Σφάλμα κατά τη φόρτωση των δεδομένων: " + e.getMessage());
            e.printStackTrace();
            return null;
        }
    }
}