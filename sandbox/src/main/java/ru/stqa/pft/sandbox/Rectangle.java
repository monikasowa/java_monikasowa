package ru.stqa.pft.sandbox;

public class Rectangle {
    double a;
    double b;

    public Rectangle(double a, double b){
        this.a = a;
        this.b = b;
    }
    public double powierzchnia(){
        double pow;
        pow = a*b;
        return pow;
    }
    public double obwod() {
        double obw;
        obw = a+a+b+b;
        return obw;

    }
}
