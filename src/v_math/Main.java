package v_math;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        DataGenerator data = new DataGenerator();
        //List<Point> points = data.getNPoints(20);
        ArrayList<Point> wrongPoints = data.getWrongPoints();
        List<Point> points = data.getRightPoints(wrongPoints);
        for (Point point : points)
            System.out.println(point);
        Approximation approximation = new Approximation(points);
        System.out.println("A = " + approximation.getA() + " B = " + approximation.getB());


    }
}
