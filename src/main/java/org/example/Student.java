package org.example;
import jakarta.persistence.*;
import org.example.Addresse;

import java.io.Serializable;
@Entity(name="students")
@Embeddable//!!!!!
public class Student implements Serializable {

    private long mark;

    private String name;
    private int id;

    @Embedded//!!!
    private Addresse addresse;

    public Student () {
        id = (int) System.nanoTime();}

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getId () {
        return id;
    }
    public void setId ( int id){
        this.id = id;
    }
    @Column(name = "name")
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    @Column(name = "mark")
    public long getMark() {
        return mark;
    }
    public void setMark(long mark) {
        this.mark = mark;
    }
    @OneToOne(cascade = {CascadeType.PERSIST})
    @JoinColumn(name="idAdress" ,referencedColumnName = "id")
    public Addresse getAddresse() {
        return addresse;
    }

    public void setAddresse(Addresse addresse) {
        this.addresse = addresse;
    }
}