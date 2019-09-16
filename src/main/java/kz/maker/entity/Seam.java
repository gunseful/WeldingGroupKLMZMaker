package kz.maker.entity;

public class Seam {
    private int id;
    private Cathet cathet;
    private double lenght;

    public Seam(int id, Cathet cathet, double lenght) {
        this.id = id;
        this.cathet = cathet;
        this.lenght = lenght;
    }

    public int getId() {
        return id;
    }

    public Cathet getCathet() {
        return cathet;
    }

    public double getLenght() {
        return lenght;
    }

}
