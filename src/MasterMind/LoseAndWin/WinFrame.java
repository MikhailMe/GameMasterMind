package MasterMind.LoseAndWin;

import MasterMind.MVC.graphicsController;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *  This class is a frame for situation if you win
 *  Also this class extends JFrame
 */
public class WinFrame extends JFrame{

    /** button which return you to start panel */
    private JButton goToStart = new JButton("go to start window");

    /** object of the WinPanel */
    private WinPanel panel = new WinPanel();

    /** some const size */
    private final int SIZE_BUTTON = 25;

    /** the reference on the object of graphicsController */
    private graphicsController gC;


    /**
     * In the constructor init some properties of win frame
     *
     * @param newGC is a object of the graphicsController
     */
    public WinFrame(graphicsController newGC){
        gC = newGC;
        setTitle("YOU WIN");
        setBounds(16*SIZE_BUTTON, 3*SIZE_BUTTON, 20*SIZE_BUTTON, 20*SIZE_BUTTON);
        add(panel);
        panel.setLayout(null);
        panel.add(goToStart);
        goToStart.setBounds(300,50,150,75);
        goToStart.setVisible(true);
        goToStart.addActionListener(actionGoStart);
        setResizable(false);
        setVisible(true);
    }

    /**
     * listener for button GoStart
     */
    private ActionListener actionGoStart = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            dispose();
            gC.getStartWindow().setVisible(true);
        }
    };
}
