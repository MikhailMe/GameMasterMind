package MasterMind.LoseAndWin;

import MasterMind.MAIN.mainFrame;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * This class is a frame for situation if you lost
 * Also this class extends JFrame
 */
public class LoseFrame extends JFrame {

    /** button for exit */
    private JButton exit = new JButton("Exit");

    /** object of @link ifNotWinPanel */
    private LosePanel panel;

    /** some const size */
    final private int SIZE_BUTTON = 50;

    /**
     * This method init window which show if you lose
     */
    private void create(){
        setTitle("Colors selected by computer");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(6*SIZE_BUTTON,2*SIZE_BUTTON,14*SIZE_BUTTON,10*SIZE_BUTTON);
        setVisible(true);
        setResizable(false);
    }

    /**
     * In the constructor set up some properties for the object of LoseFrame
     *
     * @param mW is a object of mainFrame
     */
    public LoseFrame(final mainFrame mW){
        panel = new LosePanel(mW.gC.getModel().getRandColors());
        this.create();
        this.setContentPane(panel);
        panel.setBackground(new Color(202, 218, 150));
        this.setLayout(null);
        this.add(exit);
        exit.setBounds(5*SIZE_BUTTON,SIZE_BUTTON,3*SIZE_BUTTON,SIZE_BUTTON);
        exit.setBackground(Color.PINK);
        mW.setVisible(false);
        exit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                newGame(mW);
            }
        });
        panel.repaint();
    }

    /**
     * This method for new Game
     *
     * @param mW is a object of mainFrame
     */
    private void newGame(mainFrame mW){
        mW.dispose();
        mW.gC.getStartWindow().setVisible(true);
    }
}