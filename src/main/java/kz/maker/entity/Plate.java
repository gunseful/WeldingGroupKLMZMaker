package kz.maker.entity;

import javax.persistence.*;

@Entity
@Table(name="Plate")
public class Plate {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private double coefficientO2;
    private double coefficientProp;
    private int plateValue;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getCoefficientO2() {
        return coefficientO2;
    }

    public void setCoefficientO2(double coefficientO2) {
        this.coefficientO2 = coefficientO2;
    }

    public double getCoefficientProp() {
        return coefficientProp;
    }

    public void setCoefficientProp(double coefficientProp) {
        this.coefficientProp = coefficientProp;
    }

    public int getPlateValue() {
        return plateValue;
    }

    public void setPlateValue(int plateValue) {
        this.plateValue = plateValue;
    }
}
