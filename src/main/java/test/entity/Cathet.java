package test.entity;

import javax.persistence.*;

@Entity
@Table(name="Cathet")
public class Cathet {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id;
    private double coefficient;
    private int cathet;
    private String seam;

    public Cathet() {
    }

    public Cathet(double coefficient, int cathet, String seam) {
        this.coefficient = coefficient;
        this.cathet = cathet;
        this.seam = seam;
    }

    public int getId() {
        return id;
    }

    public double getCoefficient() {
        return coefficient;
    }

    public int getCathet() {
        return cathet;
    }

    public String getSeam() {
        return seam;
    }
}
