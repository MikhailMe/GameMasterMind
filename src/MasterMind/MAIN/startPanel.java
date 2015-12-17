package MasterMind.MAIN;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

/**
 * Class is a panel for start window
 * Also this class extends JPanel
 */
public class startPanel extends JPanel {

    /**
     * This method for paint some picture
     */
    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        Image im = null;
        try {
            im = ImageIO.read(new File("src/mastermind.png"));
        } catch (IOException e) {}
        g.drawImage(im, 0, 0, this);
    }
}