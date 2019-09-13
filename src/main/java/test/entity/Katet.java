package test.entity;

import org.springframework.boot.autoconfigure.domain.EntityScan;

import javax.persistence.*;

@Entity
@Table(name="katet")
public class Katet {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id;
    private double koef;
    private int k;
    private String seam;

    public Katet() {
    }

    public Katet(double koef, int k, String seam) {
        this.koef = koef;
        this.k = k;
        this.seam = seam;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getKoef() {
        return koef;
    }

    public void setKoef(double koef) {
        this.koef = koef;
    }

    public int getK() {
        return k;
    }

    public void setK(int k) {
        this.k = k;
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
                ", koef=" + koef +
                ", k=" + k +
                ", seam='" + seam + '\'' +
                '}';
    }
}
