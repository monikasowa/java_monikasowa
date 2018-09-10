public class Point {
    double x;
    double y;

    public double distance(Point p2) {
        double odl;
        odl = Math.sqrt((this.x - p2.x)*(this.x - p2.x)+(this.y - p2.y)*(this.y - p2.y));

        return odl;
    }
}
