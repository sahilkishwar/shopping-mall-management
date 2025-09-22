package Entities;

import org.springframework.aot.generate.Generated;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cglib.beans.BeanCopier.Generator;
import org.springframework.data.annotation.Id;

@EntityScan
public class Customer {

    @Id
    @Generated(strategy = Generator.IDENTITY)
    private Long id;

    private String name;
    private String email;
    private String phoneNumber;

    // Constructors, Getters, and Setters
    public Customer() {}

    public Customer(String name, String email, String phoneNumber) {
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}

