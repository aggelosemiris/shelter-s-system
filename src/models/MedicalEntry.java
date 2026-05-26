package models;

import java.io.Serializable;
import java.util.Date;

public interface MedicalEntry extends Serializable {
    // Κοινές μέθοδοι που πρέπει να έχουν όλες οι ιατρικές πράξεις
    Date getDate();
    String getDescription();
    Vet getVet();
}