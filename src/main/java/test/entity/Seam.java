package test.entity;

public class Seam {
    private int id;
    private Katet katet;
    private double lenght;

    public Seam(int id, Katet katet, double lenght) {
        this.id = id;
        this.katet = katet;
        this.lenght = lenght;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Katet getKatet() {
        return katet;
    }

    public void setKatet(Katet katet) {
        this.katet = katet;
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
                "katet=" + katet +
                ", lenght=" + lenght +
                '}';
    }
}
