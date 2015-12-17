package MasterMind.MAIN;

import MasterMind.MVC.graphicsController;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * This class is start window
 * Also this class extends JFrame
 */
public class startFrame extends JFrame {

    /** object of graphicsController */
    public graphicsController gController;

    /** button for exit */
    final JButton exit = new JButton("Exit");

    /** button for new game */
    private JButton newGame = new JButton("New Game");

    /** listener for button new Game */
    public ActionListener actionNewGame = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            newGame.setVisible(false);
            exit.setVisible(false);
            mode(easyMode);
            easyMode.setBounds(80,10,100,30);
            mode(hardMode);
            hardMode.setBounds(80,50,100,30);
        }
    };

    /** button for easyMode */
    final JButton easyMode = new JButton("easy mode");

    /** listener for button easyMode */
    public ActionListener actionEasy = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            gController = new graphicsController();
            gController.getModel().setMode(false);
            onButtonPress();
        }
    };

    /** button for hardMode */
    final JButton hardMode = new JButton("hard mode");

    /** listener for button hardMode */
    public ActionListener actionHard = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            gController = new graphicsController();
            gController.getModel().setMode(true);
            onButtonPress();
        }
    };

    /**
     * This method is constructor of startFrame
     * This method initializes the listeners
     */
    public startFrame(){

        setTitle("Start game");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(400,70,500,241);
        setVisible(true);
        setResizable(false);
        newGame.addActionListener(actionNewGame);
        easyMode.addActionListener(actionEasy);
        hardMode.addActionListener(actionHard);
    }

    /**
     * This method of action with a @param button
     * @param button added to start frame
     */
    private void mode(JButton button){
        this.add(button);
        button.setBackground(new Color(199,252,236));
        button.setVisible(true);
    }

    /**
     * This method of actions if you push the button
     */
    private void onButtonPress(){
        this.setVisible(false);
        easyMode.setVisible(false);
        hardMode.setVisible(false);
        newGame.setVisible(true);
        exit.setVisible(true);
        gController.create(this);
    }

    /**
     * This method of create window
     */
    public void create(){
        add(exit);
        exit.setBounds(140,30,100,30);
        exit.setBackground(Color.cyan);
        exit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        setLayout(null);
        add(newGame);
        newGame.setBounds(30,30,100,30);
        newGame.setBackground(Color.cyan);
    }
}