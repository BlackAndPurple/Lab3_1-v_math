package v_math;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import static v_math.FunctionToDisplay.ALL;
import static v_math.FunctionToDisplay.REMOVE_POINT;
import static v_math.FunctionToDisplay.SIMPLE;

public class SwitchFunctionToDisplay {

    //private ArrayList<Point> points;
    private DrawPlot plot;
    private ButtonGroup group;
    private JPanel buttonPanel;
    private JRadioButton radioSimpleAppr;
    private JRadioButton radioRemovePointAppr;
    private JRadioButton radioAllAppr;

   /* public void setPoints(ArrayList<Point> points) {
        this.points = points;
    }
*/
    public SwitchFunctionToDisplay(DrawPlot plot, Controller controller) {
        //this.points = points;
        this.plot = plot;
        group = new ButtonGroup();
        buttonPanel = new JPanel();
        buttonPanel.setBorder(BorderFactory.createEmptyBorder(50,30,50,0));
        buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.PAGE_AXIS));
        radioSimpleAppr = new JRadioButton("Simple approximation", true);
        group.add(radioSimpleAppr);
        buttonPanel.add(radioSimpleAppr);
        radioRemovePointAppr = new JRadioButton("Approximation after removing remote point", true);
        group.add(radioRemovePointAppr);
        buttonPanel.add(radioRemovePointAppr);
        radioAllAppr = new JRadioButton("All", true);
        group.add(radioAllAppr);
        buttonPanel.add(radioAllAppr);

        ActionListener listener = new ActionListener()
        {
            public void actionPerformed(ActionEvent event)
            {   if (radioSimpleAppr.isSelected())
                    controller.setFunctionToDisplay(SIMPLE);
                if (radioRemovePointAppr.isSelected())
                    controller.setFunctionToDisplay(REMOVE_POINT);
                if (radioAllAppr.isSelected())
                    controller.setFunctionToDisplay(ALL);
                plot.repaint();
            }
        };
        radioSimpleAppr.addActionListener(listener);
        radioRemovePointAppr.addActionListener(listener);
        radioAllAppr.addActionListener(listener);
    }

    public JPanel getButtonPanel() {
        return buttonPanel;
    }

}
