package v_math;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class DrawPlot extends JPanel {

        private double a = 1;
        private double b = 0;
        private ArrayList<Point> points = null;

    public void setPoints(ArrayList<Point> points) {
        this.points = points;
    }

    public void setCoeff(double a, double b){
            this.a = a;
            this.b = b;
        }

        double f(double x) {
            return a*Math.sin(x) + b;
        }

        /*double gCos(double y) {
            return Math.cos(y);
        }*/

        protected void paintComponent(Graphics g)
        {
            super.paintComponent(g);

            g.drawLine(310, 300, 900, 300);
            g.drawLine(605, 50, 605, 550);

            g.drawLine(310, 50, 310, 550);
            g.drawLine(900, 50, 900, 550);
            g.drawLine(310, 50, 900, 50);
            g.drawLine(310, 550, 900, 550);
            /*g.drawLine(860, 100, 850, 90);
            g.drawLine(860, 100, 850, 110);
            g.drawLine(680, 30, 670, 40);
            g.drawLine(680, 30, 690, 40);

            g.drawString("X", 860, 80);
            g.drawString("Y", 700, 40);*/
            if (points != null)
                for (Point point : points)
                    g.drawOval((int)(50/Math.PI*point.getX() + 604), (int)(300 - point.getY()*50 - 1), 4, 4);


            Polygon p = new Polygon();
            Polygon p2 = new Polygon();

            for (int x = 0; x <= 100; x++) {
                p.addPoint(x + 605, 300 - (int) (50 * f((x / 100.0) * 2
                        * Math.PI)));

            }

           /* for (int x = -170; x <= 170; x++) {
                p2.addPoint(x + 200, 100 - (int) (50 * gCos((x / 100.0) * 2
                        * Math.PI)));

            }*/

            g.setColor(Color.red);
            g.drawPolyline(p.xpoints, p.ypoints, p.npoints);
            //g.drawString("-2\u03c0", 500, 315);
            g.drawString("2\u03c0", 710, 315);
            g.drawString("0", 610, 315);

            g.setColor(Color.blue);
            g.drawPolyline(p2.xpoints, p2.ypoints, p2.npoints);

        }
    }


