package ru.stqa.pft.sandbox;

public class Points {
    double x1;
    double y1;
    double x2;
    double y2;

    public Points(double x1, double y1, double x2, double y2) {
        this.x1=x1;
        this.y1=y1;
        this.x2=x2;
        this.y2=y2;
    }
    public double distance() {
        double odl;

        odl = Math.sqrt((this.x1 - this.x2)*(this.x1 - this.x2)+(this.y1 - this.y2)*(this.y1 - this.y2));

        return odl;

    }
}