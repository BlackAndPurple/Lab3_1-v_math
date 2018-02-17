package v_math;

import java.util.ArrayList;

import static v_math.FunctionToDisplay.SIMPLE;
import static v_math.PointsSet.FOUR;

public class Controller {
    private DrawPlot plot;
    private SwitchPointsSet pointsSetSwitches;
    private SwitchFunctionToDisplay functionSwitcher;
    private FunctionToDisplay functionToDisplay = SIMPLE;
    private PointsSet pointsSet = FOUR;
   // private ArrayList<Point> points;

    public Controller() {
    }

   /* public Controller(DrawPlot plot, SwitchPointsSet pointsSetSwitches, SwitchFunctionToDisplay functionSwitcher) {
        this.plot = plot;
        this.pointsSetSwitches = pointsSetSwitches;
        this.functionSwitcher = functionSwitcher;
        functionToDisplay = functionSwitcher.getFunctionToDisplay();
    }
*/
    public void setPointsSet(PointsSet pointsSet) {
        this.pointsSet = pointsSet;
    }

    public PointsSet getPointsSet() {
        return pointsSet;
    }

    public FunctionToDisplay getFunctionToDisplay() {
        return functionToDisplay;
    }

    public void setFunctionToDisplay(FunctionToDisplay functionToDisplay) {
        this.functionToDisplay = functionToDisplay;
    }
}
