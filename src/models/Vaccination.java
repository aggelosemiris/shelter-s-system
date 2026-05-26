package models;

import java.util.Date;

public class Vaccination implements MedicalEntry {
    private static final long serialVersionUID = 1L;
    
    private Date date;
    private String description;
    private Vet vet; // Ο κτηνίατρος που έκανε το εμβόλιο

    public Vaccination(Date date, String description, Vet vet) {
        this.date = date;
        this.description = description;
        this.vet = vet;
    }

    @Override
    public Date getDate() {
        return date;
    }

    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public Vet getVet() {
        return vet;
    }
}