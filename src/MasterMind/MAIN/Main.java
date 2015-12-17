package MasterMind.MAIN;

import javax.swing.*;

/**
 * This class is main class.
 */
public class Main {

    /**
     * This is main method of main class
     *
     * @param args is a input parameter
     */
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                startFrame frame = new startFrame();
                startPanel panel = new startPanel();
                frame.setContentPane(panel);
                frame.create();
            }
        });
    }
}