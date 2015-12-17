import MasterMind.MVC.Model;
import org.junit.Assert;
import org.junit.Test;
import java.awt.*;

public class ModelTest {

    private Model model = new Model();
    private int currentLine = 0;

    @Test
    public void calcChoice() {
        model.setMode(false);
        model.setRandomColors();
        for (int i = 0; i < 4; ++i)
            model.getAllColors()[currentLine][i] = Color.black;
        int[] answer = model.calcChoice(currentLine);
        int[] trueAnswer = {0, 0};
        Assert.assertArrayEquals(answer, trueAnswer);
    }

    @Test
    public void isWin() {
        for (int i = 0; i < 4; ++i)
            model.getAllColors()[currentLine][i] = Color.black;
        boolean result = model.isWin(currentLine);
        assert (result == false);
    }
}
