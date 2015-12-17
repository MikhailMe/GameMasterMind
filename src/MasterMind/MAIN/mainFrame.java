package MasterMind.MAIN;

import MasterMind.MVC.graphicsController;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;

/**
 * This class is a main window of game
 * Also this class extends JFrame
 */
public class mainFrame extends JFrame {

    /** some const size */
    private final int SIZE_BUTTON = 25;

    /** scrolling for window */
    public JScrollPane jScrollPane;

    /** button Apply */
    public JButton apply = new JButton("Apply");

    /** button Luck */
    public JButton luck = new JButton("I'm Lucky");

    /** the reference on the controller */
    public graphicsController gC;


    /**
     * listener for button Apply
     */
    private ActionListener actionApply = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (!gC.isNotChoiсe()) {
                gC.actionForButton();
                gC.isPress = true;
            }
        }
    };

    /**
     * listener for button Luck
     */
    private ActionListener actionLuck = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            LinkedList<Color> luckColors = new LinkedList<Color>(gC.getModel().gener());
            for (int i = 0; i < 4; ++i)
                gC.getModel().getAllColors()[gC.getCurrentLine()][i] = luckColors.get(i);
            gC.actionForButton();
        }
    };


    /**
     * In the constructor init some properties of object mainFrame
     */
    public mainFrame(){
        apply.addActionListener(actionApply);
        luck.addActionListener(actionLuck);
        setTitle("Master Mind");
        setBounds(16*SIZE_BUTTON, 3*SIZE_BUTTON, 20*SIZE_BUTTON, 20*SIZE_BUTTON);
        setVisible(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        apply.setBounds(13*SIZE_BUTTON, SIZE_BUTTON, 5*SIZE_BUTTON, SIZE_BUTTON);
        luck.setBounds(13*SIZE_BUTTON, 2*SIZE_BUTTON, 5*SIZE_BUTTON, SIZE_BUTTON);
        setResizable(false);
    }
}