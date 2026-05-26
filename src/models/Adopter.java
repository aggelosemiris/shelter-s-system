package models;

import java.io.Serializable;

public class Adopter extends User implements Serializable {
    private static final long serialVersionUID = 1L;

    // Επιπλέον πεδία αποκλειστικά για τον Adopter
    private String address;
    private String profileDescription;
    private int age;

    public Adopter() {
        super(); // Καλεί τον κενό constructor του User
    }

    // Constructor με όλα τα στοιχεία (του User + του Adopter)
    public Adopter(String username, String password, String firstName, String lastName, 
                   String phone, String email, String address, String profileDescription, int age) {
        
        // Η super() στέλνει τα βασικά πεδία στην "μαμά" κλάση User για να τα αποθηκεύσει
        super(username, password, firstName, lastName, phone, email);
        
        // Αποθηκεύουμε τα δικά του πεδία
        this.address = address;
        this.profileDescription = profileDescription;
        this.age = age;
    }

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getProfileDescription() {
		return profileDescription;
	}

	public void setProfileDescription(String profileDescription) {
		this.profileDescription = profileDescription;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

    
}
