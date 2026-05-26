package models;

import java.io.Serializable;
import java.util.ArrayList;

public class MedicalRecord implements Serializable {
    private static final long serialVersionUID = 1L;
    
    // Η λίστα που θα κρατάει όλες τις ιατρικές πράξεις
    private ArrayList<MedicalEntry> entries;

    public MedicalRecord() {
        // Αρχικοποιούμε τη λίστα για να μην χτυπήσει NullPointerException
        this.entries = new ArrayList<>();
    }

    // Getter για τη λίστα
    public ArrayList<MedicalEntry> getEntries() {
        return entries;
    }

    // Μέθοδος για να προσθέτουμε μια νέα ιατρική πράξη (π.χ. ένα νέο Vaccination)
    public void addEntry(MedicalEntry entry) {
        this.entries.add(entry);
    }
}