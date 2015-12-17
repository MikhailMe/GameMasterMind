package MasterMind.MVC;

import MasterMind.LoseAndWin.WinFrame;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * This class is responsible for all graphics applications
 * Also this class extends JPanel
 */
public class graphics extends JPanel{

    /** array for main coordinates square  */
    private int[] rectX = new int[4];

    /** array for coordinates of palette's squares */
    private int[] rectColorX = new int[8];

    /**
     * getter for rectColorX
     *
     * @return int[] rectColorX
     */
    public int[] getRectColorX() {return rectColorX;}

    /** some const size */
    final int DIMENSION = 50;

    /** frame for dialog menu */
    private JFrame chooseColor = new JFrame("Choose color");

    /**
     * getter for chooseColor
     *
     * @return JFrame chooseColor
     */
    public JFrame getChooseColor() {return chooseColor;}

    /** current square */
    private int currentSquare;

    /**
     * getter for square
     *
     * @return int currentSquare
     */
    public int getCurrentSquare() {return currentSquare;}

    /** object of dialog menu */
    private dialogMenu dMenu;

    /** some flag for painting */
    private boolean flag = false;

    /** object of graphicsController */
    public graphicsController gC;

    /**
     * This method is a constructor of graphics
     * It processing of mouse click on main panel
     *
     * @param newGraphicsController is a object of @link graphicsController
     */
    graphics(graphicsController newGraphicsController){
        gC = newGraphicsController;
        dMenu = new dialogMenu(this);
        addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                super.mouseClicked(e);
                int x = e.getX();
                int y = e.getY();
                for (int i = 0; i < rectX.length; ++i)
                    if (x >= rectX[i] &&
                            x <= rectX[i] + DIMENSION &&
                            y >= DIMENSION / 2 + 2 * DIMENSION * gC.getCurrentLine() &&
                            y <= DIMENSION + (DIMENSION / 2 + 2 * DIMENSION * gC.getCurrentLine())) {
                        currentSquare = i;
                        dMenu.showChooseColor();
                    }
            }
        });
    }

    /**
     * This method draws all the information of the application
     *
     * @param g is a object of Graphics
     */
    @Override
    public void paint(Graphics g){
        super.paint(g);
        if (gC.getModel().isWin(gC.getCurrentLine()) && gC.isPress){
            WinFrame win = new WinFrame(gC);
            gC.mainWindow.setVisible(false);
            gC.mainWindow.apply.setVisible(false);
            gC.mainWindow.luck.setVisible(false);
        }
        else{
            int coef = 25;
            for (int i = 0; i <= gC.getCurrentLine(); ++i) {
                for (int j = 0; j < 4; ++j) {
                    g.setColor(gC.getModel().getAllColors()[i][j]);
                    g.fillRect(coef + 3*coef*j,coef+2*DIMENSION*i,DIMENSION,DIMENSION);
                    rectX[j] = coef + 3*coef * j;
                }
                if (flag && i > 0) {
                    g.setColor(Color.BLACK);
                    g.drawLine(0, 2*DIMENSION * i, 510, 2*DIMENSION * i);
                    g.drawString(gC.getModel().getAmountOfColors()[i-1][0] + " matching colors", 310, 40 + 2*DIMENSION * (i - 1));
                    g.drawString(gC.getModel().getAmountOfColors()[i-1][1] + " colors on the right place", 310, 60 + 2*DIMENSION * (i - 1));
                }
                flag = true;
            }
        }
        gC.isPress = false;
    }
}
