package models;

import java.io.Serializable;

public class Animal implements Serializable {
    private static final long serialVersionUID = 1L;

    // Τα πεδία του ζώου (αυστηρά private)
    private String id; // Μπορεί να είναι και int, αλλά το String βολεύει για κωδικούς (π.χ. "A001")
    private String name;
    private AnimalType type; // Χρησιμοποιούμε το Enum που μόλις φτιάξαμε!
    private int age;
    private String description;
    
    // Σύνδεση 1-προς-1 με τον ιατρικό φάκελο
    private MedicalRecord medicalRecord;

    public Animal() {
        // Αρχικοποιούμε τον ιατρικό φάκελο ώστε να μην είναι ποτέ null
        this.medicalRecord = new MedicalRecord();
    }

    public Animal(String id, String name, AnimalType type, int age, String description) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.age = age;
        this.description = description;
        this.medicalRecord = new MedicalRecord();
    }

    // Κάνε και εδώ Generate Getters and Setters για ΟΛΑ τα πεδία (εκτός από το serialVersionUID)!
}