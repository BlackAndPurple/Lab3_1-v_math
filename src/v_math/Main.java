package v_math;

import java.util.List;

public class Main {

    public static void main(String[] args) {

        DataGenerator data = new DataGenerator();
        //List<Point> points = data.getNPoints(8);
        List<Point> points = data.getWrongPoints();
        for (Point point : points)
            System.out.println(point);
        Approximation approximation = new Approximation(points);
        System.out.println("A = " + approximation.getA() + " B = " + approximation.getB());


    }
}
