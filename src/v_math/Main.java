package v_math;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Main extends JFrame{

    private DrawPlot plot;
    private SwitchPointsSet pointsSet;
    private SwitchFunctionToDisplay functionSwitcher;
    private Controller controller;

    public Main()
    {

        super("Lab3 | Least Squares Method");
        Container c = getContentPane();
        c.setLayout(new BorderLayout()); // установка менеджера размещения
        DataGenerator data = new DataGenerator();
        controller = new Controller();
        plot = new DrawPlot(controller);
        plot.repaint();
        JPanel switchersPanel = new JPanel();
        switchersPanel.setLayout(new BoxLayout(switchersPanel, BoxLayout.Y_AXIS));
        pointsSet = new SwitchPointsSet(plot, controller);
        functionSwitcher = new SwitchFunctionToDisplay(plot, controller); //fix it
        switchersPanel.add(pointsSet.getButtonPanel());
        switchersPanel.add(functionSwitcher.getButtonPanel());
        //c.add(pointsSet.getButtonPanel(),BorderLayout.WEST);
        c.add(switchersPanel,BorderLayout.WEST);
       // plot.setPoints(pointsSet.getPoints());

        //c.add(functionSwitcher.getButtonPanel(),BorderLayout.PAGE_END);
        c.add(plot, BorderLayout.CENTER);

        setSize(980,800); // задание размеров
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
