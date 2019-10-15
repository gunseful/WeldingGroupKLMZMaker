package kz.maker.entity;

public class Cut {
    private int id;
    private Plate plate;
    private double length;

    public Cut(int id, Plate plate, double length) {
        this.id = id;
        this.plate = plate;
        this.length = length;
    }

    public int getId() {
        return id;
    }

    public Plate getPlate() {
        return plate;
    }

    public double getLength() {
        return length;
    }

}
