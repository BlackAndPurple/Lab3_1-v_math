package v_math;

import javax.swing.*;
import java.awt.*;

public class SwitchPointsSet {
    ButtonGroup group;
    JPanel buttonPanel;

    SwitchPointsSet(){
        group = new ButtonGroup();
        buttonPanel = new JPanel();
        buttonPanel.setMaximumSize(new Dimension(50, 200));
        JRadioButton radio4Points = new JRadioButton("4 points", true);
        group.add(radio4Points);
        buttonPanel.add(radio4Points);
        JRadioButton radio8Points = new JRadioButton("8 points", false);
        group.add(radio8Points);
        buttonPanel.add(radio8Points);
        JRadioButton radioWringPoints = new JRadioButton("Wrong points", false);
        group.add(radioWringPoints);
        buttonPanel.add(radioWringPoints);
        JRadioButton radioManyPoints = new JRadioButton("Many points", false);
        group.add(radioManyPoints);

        buttonPanel.add(radioManyPoints);
    }

    public JPanel getButtonPanel() {
        return buttonPanel;
    }


}
