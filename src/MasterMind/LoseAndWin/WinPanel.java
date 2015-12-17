package MasterMind.LoseAndWin;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

/**
 * This class is a panel for WinFrame
 * Also this class extends JPanel
 */
public class WinPanel extends JPanel{

    /**
     * This method paint a win picture
     */
    @Override
    public void paint(Graphics g){
        super.paint(g);
        Image im = null;
        try {
            im = ImageIO.read(new File("src/victory.jpg"));
        } catch (IOException e) {}
        g.drawImage(im, 0, 0,getWidth(),getHeight(), null);
    }
}
