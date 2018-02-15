package v_math;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Main extends JFrame{

    DrawPlot plot;
    SwitchPointsSet pointsSet;

    public Main()
    {

        super("Lab3 | Least Squares Method");
        Container c = getContentPane();
        c.setLayout(new BorderLayout()); // установка менеджера размещения
        DataGenerator data = new DataGenerator();
        plot = new DrawPlot();
        c.add(plot, BorderLayout.CENTER);
        //ArrayList<Point> points = data.getNPoints(8);
        //ArrayList<Point> points = data.getWrongPoints();
        //plot.setPoints(points);
        pointsSet = new SwitchPointsSet();
        //c.add(pointsSet.getButtonPanel(), BorderLayout.LINE_START);

        setSize(1000,800); // задание размеров
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // задание параметров
        // главного окна при закрытии
        setVisible(true);
    }

    public static void main(String[] args) {

        new Main();
        /*DataGenerator data = new DataGenerator();
        //List<Point> points = data.getNPoints(20);
        ArrayList<Point> wrongPoints = data.getWrongPoints();
        List<Point> points = data.getRightPoints(wrongPoints);
        for (Point point : points)
            System.out.println(point);
        Approximation approximation = new Approximation(points);
        System.out.println("A = " + approximation.getA() + " B = " + approximation.getB());
        */

    }
}
