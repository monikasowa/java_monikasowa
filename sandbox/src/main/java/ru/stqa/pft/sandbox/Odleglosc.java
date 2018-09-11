package ru.stqa.pft.sandbox;

public class Odleglosc {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Point p1 = new Point(0,3);
        Point p2 = new Point(4,0);


        double odl;
        odl = p1.distance(p2);

        System.out.println("dlugosc"+ " " + odl);
    }

}
