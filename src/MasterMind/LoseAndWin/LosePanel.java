package MasterMind.LoseAndWin;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

/**
 * This class is a panel for LoseFrame
 * Also this class extends JPanel
 */
public class LosePanel extends JPanel {

    /** some const size */
    private final int SIZE_RECT = 35;

    /** copy of array of random colors that generate by computer */
    private Color[] answer;

    /**
     * In the constructor init answer
     *
     * @param colors is a array of random colors that generate by computer
     */
    LosePanel(Color[] colors){
        answer = colors;
    }

    /**
     * This method for paint colors that generate by computer
     */
    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        Image im = null;
        try {
            im = ImageIO.read(new File("src/lose.jpg"));
        } catch (IOException e) {}
        g.drawImage(im, 0, 0,getWidth(),getHeight(), null);
        int temp = 175;
        for (int i = 0; i < 4; ++i){
            g.setColor(answer[i]);
            g.fillRect(temp + 2*SIZE_RECT*i, 9*SIZE_RECT, 2*SIZE_RECT, 2*SIZE_RECT);
            temp += SIZE_RECT;
        }
    }
}
