package kz.maker.entity;

public class Seam {
    private int id;
    private Cathet cathet;
    private double length;

    public Seam(int id, Cathet cathet, double length) {
        this.id = id;
        this.cathet = cathet;
        this.length = length;
    }

    public int getId() {
        return id;
    }

    public Cathet getCathet() {
        return cathet;
    }

    public double getLength() {
        return length;
    }

}
