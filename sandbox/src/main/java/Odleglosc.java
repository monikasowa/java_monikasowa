
public class Odleglosc {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Point p1 = new Point();
        Point p2 = new Point();
        p1.x=6;
        p1.y=8;
        p2.x=4;
        p2.y=6;

        double odl;
        odl = p1.distance(p2);

        System.out.println("dlugosc"+ " " + odl);
    }

}
