package kz.maker.entity;

import javax.persistence.*;

@Entity
@Table(name="Cathet")
public class Cathet {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id;
    private double coefficient;
    private int cathetValue;
    private String seam;

    public Cathet() {
    }

    public Cathet(double coefficient, int cathetValue, String seam) {
        this.coefficient = coefficient;
        this.cathetValue = cathetValue;
        this.seam = seam;
    }

    public Cathet(String seam, int cathetValue, double coefficient) {
        this.coefficient = coefficient;
        this.cathetValue = cathetValue;
        this.seam = seam;
    }

    public int getId() {
        return id;
    }

    public double getCoefficient() {
        return coefficient;
    }

    public int getCathetValue() {
        return cathetValue;
    }

    public String getSeam() {
        return seam;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setCoefficient(double coefficient) {
        this.coefficient = coefficient;
    }

    public void setCathetValue(int cathetValue) {
        this.cathetValue = cathetValue;
    }

    public void setSeam(String seam) {
        this.seam = seam;
    }
}
