package kz.maker.entity;

public class Cut {
    private int id;
    private Plate plate;
    private double lenght;

    public Cut(int id, Plate plate, double lenght) {
        this.id = id;
        this.plate = plate;
        this.lenght = lenght;
    }

    public int getId() {
        return id;
    }

    public Plate getPlate() {
        return plate;
    }

    public double getLenght() {
        return lenght;
    }

}
