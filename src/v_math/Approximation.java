package v_math;

import java.util.ArrayList;
import java.util.List;

public class Approximation {

    private double[][] matrix;

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

    private double squareSinSum(List<Point> points){
        double squareSum = 0;
        for (Point point : points){
            squareSum += (f(point.getX()) * f(point.getX()));
        }
        return squareSum;
    }

    private double sinSum(List<Point> points){
        double sinSum = 0;
        for (Point point : points){
            sinSum += f(point.getX());
        }
        return sinSum;
    }


    private double xSum(List<Point> points){
        double xSum = 0;
        for (Point point : points){
            xSum += point.getX();
        }
        return xSum;
    }

    private double ySum(List<Point> points){
        double ySum = 0;
        for (Point point : points){
            ySum += point.getY();
        }
        return ySum;
    }
    private double sinYSum(List<Point> points){
        double sinYSum = 0;
        for (Point point : points){
            sinYSum += f(point.getX()) * point.getY();
        }
        return sinYSum;
    }
    private double[][] getMatrix(List<Point> points){
        double[][] matrix = {{squareSinSum(points), xSum(points), sinYSum(points)},
                {sinSum(points), points.size(), ySum(points)}};
        return matrix;
    }

}
