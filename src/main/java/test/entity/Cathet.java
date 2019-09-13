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

    public void setId(int id) {
        this.id = id;
    }

    public double getCoefficient() {
        return coefficient;
    }

    public void setCoefficient(double coefficient) {
        this.coefficient = coefficient;
    }

    public int getCathet() {
        return cathet;
    }

    public void setCathet(int cathet) {
        this.cathet = cathet;
    }

    public String getSeam() {
        return seam;
    }

    public void setSeam(String seam) {
        this.seam = seam;
    }

    @Override
    public String toString() {
        return "Katet{" +
                "id=" + id +
                ", koef=" + coefficient +
                ", k=" + cathet +
                ", seam='" + seam + '\'' +
                '}';
    }
}
