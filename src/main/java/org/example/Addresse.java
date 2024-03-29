package org.example;

import jakarta.persistence.*;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.*;

@Entity
@Table(name="Addresses")
@Embeddable

public class Addresse {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)


    @Column(name = "addresse")
    private String addresse;

    private  long ID;


    public void setAddresse(String addresse) {
        this.addresse = addresse;
    }

    public void setID(long ID) {
        this.ID = ID;
    }



    public String getAddresse() {
        return addresse;
    }



    public Long getId() {
        return ID;
    }
}

