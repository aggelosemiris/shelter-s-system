package models;

import java.io.Serializable;

public class ShelterStaff extends User implements Serializable {
    private static final long serialVersionUID = 1L;

    public ShelterStaff() {
        super();
    }

    public ShelterStaff(String username, String password, String firstName, String lastName, String phone, String email) {
        super(username, password, firstName, lastName, phone, email);
    }
}