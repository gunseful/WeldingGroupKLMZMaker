package test.entity;

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

    public void setId(int id) {
        this.id = id;
    }

    public Cathet getCathet() {
        return cathet;
    }

    public void setCathet(Cathet cathet) {
        this.cathet = cathet;
    }

    public double getLenght() {
        return lenght;
    }

    public void setLenght(double lenght) {
        this.lenght = lenght;
    }

    @Override
    public String toString() {
        return "Seam{" +
                "katet=" + cathet +
                ", lenght=" + lenght +
                '}';
    }
}
