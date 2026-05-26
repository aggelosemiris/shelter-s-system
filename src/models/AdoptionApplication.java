package models;

import java.io.Serializable;
import java.util.Date;

public class AdoptionApplication implements Serializable {
    private static final long serialVersionUID = 1L;

    // Τα πεδία της αίτησης
    private Adopter adopter;
    private Animal animal;
    private Date applicationDate;
    private ApplicationStatus status; // PENDING, APPROVED, REJECTED

    public AdoptionApplication() {
    }

    public AdoptionApplication(Adopter adopter, Animal animal, Date applicationDate, ApplicationStatus status) {
        this.adopter = adopter;
        this.animal = animal;
        this.applicationDate = applicationDate;
        this.status = status;
    }

	public Adopter getAdopter() {
		return adopter;
	}

	public void setAdopter(Adopter adopter) {
		this.adopter = adopter;
	}

	public Animal getAnimal() {
		return animal;
	}

	public void setAnimal(Animal animal) {
		this.animal = animal;
	}

	public Date getApplicationDate() {
		return applicationDate;
	}

	public void setApplicationDate(Date applicationDate) {
		this.applicationDate = applicationDate;
	}

	public ApplicationStatus getStatus() {
		return status;
	}

	public void setStatus(ApplicationStatus status) {
		this.status = status;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}