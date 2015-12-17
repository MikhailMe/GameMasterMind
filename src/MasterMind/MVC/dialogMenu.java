package MasterMind.MVC;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


 /**
 * This class for show dialog menu with palette colors
 */
public  class dialogMenu extends JPanel {

    /**
     * reference on the object of graphics
     * */
    private graphics refGraphics;


    /** Palette of main colors */
    Color[] colorArray = {Color.RED, Color.ORANGE, Color.PINK, Color.YELLOW,
            Color.GREEN, Color.CYAN, Color.BLUE,Color.MAGENTA};

    /**
     * This method is a constructor of dialogMenu
     * It processing of mouse click on dialog menu
     */
    public dialogMenu(graphics rG){
        refGraphics = rG;
        addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                super.mouseClicked(e);
                int x = e.getX();
                for (int i = 1; i <= 8; ++i)
                    if (x > 0 && x < refGraphics.DIMENSION*i){
                        refGraphics.gC.getModel().getAllColors()[refGraphics.gC.getCurrentLine()][refGraphics.getCurrentSquare()] = colorArray[i-1];
                        refGraphics.gC.getPanel().repaint();
                        refGraphics.getChooseColor().setVisible(false);
                        break;
                    }
            }
        });
    }

    /**
     * This method show new dialog menu for choose color
     */
    public void showChooseColor(){
        refGraphics.getChooseColor().setBounds(400,200,406,79);
        refGraphics.getChooseColor().setResizable(false);
        refGraphics.getChooseColor().setVisible(true);
        refGraphics.getChooseColor().add(this);
    }

    /**
     * This method paint palette of main colors
     */
    @Override
    public void paint(Graphics g){
        super.paint(g);
        for (int i = 0; i < 8; ++i){
            g.setColor(colorArray[i]);
            g.fillRect(refGraphics.DIMENSION*i,0,refGraphics.DIMENSION,refGraphics.DIMENSION);
            refGraphics.getRectColorX()[i] = refGraphics.DIMENSION*i;
        }
    }
}