package v_math;

import java.util.List;

public class Main {

    public static void main(String[] args) {
	    Approximation approximation = new Approximation();
	    List<Point> points = approximation.getNPoints(5);
	    for (Point point : points)
	        System.out.println(point);
    }
}
