package v_math;

import java.util.ArrayList;
import java.util.List;

public class Approximation {

    //private double a;
    //private double b;

    public Approximation(List<Point> points) {
        this.points = points;
        this.matrix = getMatrix(points);
    }

    public void setPoints(List<Point> points) {
        this.points = points;
        this.matrix = getMatrix(points);
    }


    private double[][] matrix;
    List<Point> points;


    private double f(double x){
        return Math.sin(x);
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

    public double getA(){
        double[][] matrix_local = this.matrix;
        double b = getB();
        double a = (matrix_local[0][2]-matrix_local[0][1] * b) / matrix_local[0][0];
        return a;
    }
    public double getB() {
        double[][] matrix_local = this.matrix;
        double k = matrix_local[0][0];
        double b = 0;
        for (int i = 0; i < 3; i++){
            matrix_local[0][i] /= k;
        }
        k = matrix_local[1][0];
        for (int i = 0; i < 3; i++){
            matrix_local[1][i] -= matrix_local[0][i] * k;
        }
        b = matrix_local[1][2] / matrix_local[1][1];
        return b;
    }

    /*public ArrayList<Point> getRightPoints(ArrayList<Point> points) {
        ArrayList<Point> rightPoints = (ArrayList)points.clone();
        double max_offset = 0;
        Point point_to_delete = null;
        for (Point point : rightPoints){
            double offset = Math.pow(point.getY() - f(point.getX()), 2);
            if (offset > max_offset){
                max_offset = offset;
                point_to_delete = point;
            }
        }
        if (point_to_delete != null)
            rightPoints.remove(point_to_delete);
        return rightPoints;

    }*/
}
