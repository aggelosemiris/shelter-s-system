package models;

import java.io.Serializable;

public class Vet extends User implements Serializable {
    private static final long serialVersionUID = 1L;

    public Vet() {
        super();
    }

    public Vet(String username, String password, String firstName, String lastName, String phone, String email) {
        super(username, password, firstName, lastName, phone, email);
    }
}