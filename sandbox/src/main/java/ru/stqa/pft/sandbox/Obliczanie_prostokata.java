package ru.stqa.pft.sandbox;

public class Obliczanie_prostokata {

    public static void main(String[] args) {
        // TODO Auto-generated method stub

        Rectangle r1 = new Rectangle(5, 6);


        double pole;
        pole = r1.powierzchnia();

        System.out.println("powierzchnia" + " " + pole);

        double ob;
        ob = r1.obwod();
        System.out.println("obwod" + " " + ob);

    }
}
