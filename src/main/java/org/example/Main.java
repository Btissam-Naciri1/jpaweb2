package org.example;
import jakarta.persistence.*;

import org.example.Addresse;
import org.example.Student;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("studententity");
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();

        // Inserting a new student
        Addresse a = new Addresse();
        a.setAddresse("Jnan Aourad");

        Student s = new Student();
        s.setName("Hajar");
        s.setMark(17);
        s.setAddresse(a);

        em.persist(s);

        // Retrieving students
        List<Student> students = getStudents(em);
        for (Student student : students) {
            System.out.println(student.getName());
        }

        em.getTransaction().commit();
        em.close();
        emf.close();
    }

    // Method to retrieve students
    private static List<Student> getStudents(EntityManager em) {
        Query q = em.createQuery("SELECT st FROM students st");
        return q.getResultList();
    }
}