package v_math;

import javax.swing.*;
import java.awt.*;
import java.math.BigDecimal;
import java.util.ArrayList;

public class DrawPlot extends JPanel {

    private double a = 1;
    private double b = 0;
    private ArrayList<Point> points = null;
    private ArrayList<Point> rightPoints = null;
    private Controller controller;
    private DataGenerator data;
    private Approximation approximation;
    private Table table;

    public DrawPlot(Controller controller, Table table) {
        this.controller = controller;
        data = new DataGenerator();
        points = data.getNPoints(4);
        this.table = table;
        table.setTableData(points);
    }

    public void setCoeff(double a, double b){
        this.a = a;
        this.b = b;
    }

        double f(double x) {
            return a*Math.sin(x) + b;
        }


        private void updatePoints(){
            switch (controller.getPointsSet()){
                case FOUR:
                    points = data.getNPoints(4);
                    rightPoints = points;

                    break;
                case EIGHT:
                    points = data.getNPoints(8);
                    rightPoints = points;
                    break;
                case WRONG:
                    points = data.getWrongPoints();
                    rightPoints = data.getRightPoints(points);
                    break;
                case MANY:
                    //points = data.getNPoints(15);
                    points = data.getManyWrongPoints();
                    rightPoints = data.getRightPoints(points);
                    break;
            }
            table.clearTable();
            table.setTableData(points);
        }
        protected void paintComponent(Graphics g)
        {
            super.paintComponent(g);

            //оси координат
            g.drawLine(10, 300, 600, 300);
            g.drawLine(305, 50, 305, 550);

            g.drawLine(10, 50, 10, 550);
            g.drawLine(600, 50, 600, 550);
            g.drawLine(10, 50, 600, 50);
            g.drawLine(10, 550, 600, 550);
            //---------------------------------
            updatePoints();
            if (points != null)
                for (Point point : points)
                    g.drawOval((int)(50/Math.PI*point.getX() + 303), (int)(300 - point.getY()*50 - 1), 4, 4);

            switch (controller.getFunctionToDisplay()){
                case SIMPLE:
                    approximation = new Approximation(points);
                    setCoeff(approximation.getA(), approximation.getB());
                    drawFunction(g, Color.red, false);
                    drawFuncLabel(g, 0);
                    break;
                case REMOVE_POINT:
                    approximation = new Approximation(rightPoints);
                    setCoeff(approximation.getA(), approximation.getB());
                    drawFunction(g, Color.blue, false);
                    drawFuncLabel(g, 0);
                    break;
                case ALL:
                    approximation = new Approximation(rightPoints);
                    setCoeff(approximation.getA(), approximation.getB());
                    drawFunction(g, Color.blue, false);
                    drawFuncLabel(g, 0);
                    approximation = new Approximation(points);
                    setCoeff(approximation.getA(), approximation.getB());
                    drawFunction(g, Color.red, false);
                    drawFuncLabel(g, 15);
                    break;
            }
            g.setColor(Color.black);
            g.drawString("2\u03c0", 410, 315);
            g.drawString("0", 310, 315);

        }

        private void drawFuncLabel(Graphics g, int offset){
            g.setColor(Color.black);
            g.drawString("y = " + BigDecimal.valueOf(a).setScale(3, BigDecimal.ROUND_HALF_UP) + "sin(x) + " + BigDecimal.valueOf(b).setScale(3, BigDecimal.ROUND_HALF_UP), 30, 515 + offset);
        }

        private void drawFunction(Graphics g, Color color, boolean bold){
            Polygon p = new Polygon();
            for (int x = 0; x <= 100; x++) {
                p.addPoint(x + 305, 300 - (int) (50 * f((x / 100.0) * 2
                        * Math.PI)));
            }
            if (bold)
                for (int x = 0; x <= 100; x++) {
                    p.addPoint(x + 306, 300 - (int) (50 * f((x / 100.0) * 2
                            * Math.PI)));
                }
            g.setColor(color);
            g.drawPolyline(p.xpoints, p.ypoints, p.npoints);


        }
    }


