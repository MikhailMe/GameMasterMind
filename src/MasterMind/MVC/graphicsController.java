package MasterMind.MVC;

import MasterMind.LoseAndWin.LoseFrame;
import MasterMind.MAIN.mainFrame;
import MasterMind.MAIN.startFrame;
import javax.swing.*;
import java.awt.*;

/**
 * This class is a controller that interacts with Model and graphics
 */
public class graphicsController {

    /** object of mainFrame */
    public mainFrame mainWindow;

    /** object of graphics */
    private graphics panel;

    /**
     * getter for @param panel
     *
     * @return object of graphics
     */
    public graphics getPanel() { return panel; }

    /** object of @link Model */
    private Model model;

    /**
     *  getter for @param Model
     *
     *  @return object of Model
     */
    public Model getModel() {return model;}

    /** object of @link startFrame */
    private startFrame startWindow;

    /**
     * getter for @param startWindow
     *
     * @return object of startWindow
     */
    public  startFrame getStartWindow() {return startWindow;}

    /**
     * setter for @param startWindow
     *
     * @param newStartWindow is a object of startWindow
     */
    public  void setStartWindow(startFrame newStartWindow) {startWindow = newStartWindow;}

    /** current line */
    private int currentLine = 0;

    /**
     * getter for @param currentLine
     *
     * @return currentLine
     */
    public int getCurrentLine() {return currentLine;}

    /** flag that show is button Apply pressed */
    public boolean isPress = false;

    /**
     * In the constructor initialize the objects of Model, graphics, mainFrame
     */
    public graphicsController(){
        model = new Model();
        panel = new graphics(this);
        mainWindow = new mainFrame();
        mainWindow.jScrollPane = new JScrollPane(panel);
    }

    /**
     * This method show all squares aren't gray or not
     *
     * @return false if all squares aren't gray
     */
    public boolean isNotChoiсe() {
        for (int i = 0; i < 4; ++i)
            if (model.getAllColors()[currentLine][i] == Color.GRAY)
                return true;
        return false;
    }

    /**
     * This method init main parameters for window and panel
     *
     * @param sFrame is object of startFrame
     */
    public void create(startFrame sFrame) {
        setStartWindow(sFrame);
        this.mainWindow.gC = this;
        model.setRandomColors();
        panel.setPreferredSize(new Dimension(500,500));
        panel.setBackground(new Color(202, 218, 150));
        panel.add(mainWindow.apply);
        panel.add(mainWindow.luck);
        mainWindow.setContentPane(mainWindow.jScrollPane);
        mainWindow.jScrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        panel.setLayout(null);
        mainWindow.setVisible(true);
    }

    /**
     * This method check you choose color or not
     */
    public void actionForButton() {
        boolean isWin = model.isWin(getCurrentLine());
        if (model.ATTEMPTS == (currentLine+1) && !isWin){
            new LoseFrame(mainWindow);
        }
        else if (!isWin){
            currentLine++;
            if (currentLine > 4) panel.setPreferredSize(new Dimension(500, 125 * (currentLine + 1) - 25 * currentLine));
            mainWindow.apply.setBounds(325, 25 + 100 * (currentLine), 125, 25);
            mainWindow.luck.setBounds(325, 50 + 100 * (currentLine), 125, 25);
        }
        mainWindow.jScrollPane.updateUI();
    }
}