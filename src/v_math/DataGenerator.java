package v_math;

import java.util.ArrayList;
import java.util.List;

public class DataGenerator {

    private double f(double x){
        return Math.sin(x);
    }
    public List<Point> getNPoints(int n){
        double step = 2*Math.PI / n;
        List<Point> points = new ArrayList<>();
        for (double x = 0; x < 2*Math.PI; x+=step){
            points.add(new Point(x, f(x)));
        }
        return  points;
    }

    public List<Point> getWrongPoints(){

        List<Point> points = getNPoints(5);
        points.add(new Point(Math.PI, 2));
        return  points;
    }
}
