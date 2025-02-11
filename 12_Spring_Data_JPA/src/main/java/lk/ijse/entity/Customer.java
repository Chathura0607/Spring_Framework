package lk.ijse.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Customer {
    @Id
    private int id;
    private String firstname;
    private String lastname;

    public Customer() {
    }

    public Customer(int id, String firstname, String lastname) {
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
    }
}
