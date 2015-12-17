package MasterMind.MVC;

import java.awt.*;
import java.util.*;
import java.util.List;

/**
 * This class is a model of Master Mind game
 */
public class Model {

    /** amount of attempts */
    final static int ATTEMPTS = 12;

    /** mode of game ( easy or hard ) */
    private boolean hardMode;

    /**
     *  getter for mode
     *
     *  @param newMode is a new mode of game
     */
    public void setMode(boolean newMode) {hardMode = newMode;}

    /** array of random colors */
    private Color[] randomColors = new Color[4];

    /**
     *  getter for random colors
     *
     *  @return Color[] random colors
     */
    public Color[] getRandColors() {return randomColors;}

    /** matrix for show strings with information of your choice*/
    private int[][] amountOfColors = new int[Model.ATTEMPTS][2];

    /**
     * getter for @param amountOfColors
     *
     * @return amountOfColors
     */
    public int[][] getAmountOfColors() {return amountOfColors;}


    /** matrix of all colors */
    private Color[][] allColors = new Color[ATTEMPTS][4];


    /**
     *  getter for allColors
     *
     *  @return allColors
     */
    public Color[][] getAllColors() {return allColors;}

    /** palette of main colors */
    private LinkedList<Color> array = new LinkedList<Color>(Arrays.asList(Color.RED, Color.ORANGE, Color.PINK, Color.YELLOW,
            Color.GREEN, Color.CYAN, Color.BLUE, Color.MAGENTA));

    /**
     * In the constructor all colors become gray
     */
    public Model(){
        for (int i = 0; i < ATTEMPTS; i++)
            for (int j = 0; j < 4; j++)
                allColors[i][j] = Color.GRAY;
    }

    /**
     * This method set up random colors
     */
    public void setRandomColors(){
        List<Color> rndColors = new LinkedList<Color>(gener());
        for (int i = 0; i < 4; ++i) randomColors[i] = rndColors.get(i);
    }

    /**
     * This method generate colors
     *
     * @return List of generated colors
     */
    public List<Color> gener(){
        LinkedList<Color> temp = new LinkedList<Color>(Arrays.asList(Color.RED, Color.ORANGE, Color.PINK, Color.YELLOW,
                Color.GREEN, Color.CYAN, Color.BLUE, Color.MAGENTA));
        if (!hardMode){
            Collections.shuffle(temp);
            for (int i=0; i < 4; ++i) temp.removeLast();
            return temp;
        }
        else{
            Random rand = new Random();
            temp.clear();
            for (int i = 0; i < 4; ++i) temp.add(array.get(rand.nextInt(7)));
            return temp;
        }
    }

    /**
     * This method asks what colors we guess
     *
     * @param currentLine is a current attempt line
     *
     * @return int[] where first index means how many colors were guessed and second index means how many colors are in place
     */
    public int[] calcChoice(int currentLine) {
        int[] answer = new int[2];
        int penetration;
        for (int i = 0; i < 4; ++i) {
            penetration = 0;
            for (int j = 0; j < 4; ++j) {
                if (randomColors[i] == allColors[currentLine][j] && i == j)
                    answer[1]++;
                if (randomColors[i] == allColors[currentLine][j]) {
                    answer[0]++;
                    penetration++;
                }
            }
            if (penetration > 1) answer[0] -= (penetration - 1);
        }
        return answer;
    }

    /**
     * This method check win or not
     *
     * @param currentLine is a current attempt line
     *
     * @return boolean true if you win
     */
    public boolean isWin(int currentLine){
        int[] answer = calcChoice(currentLine);
        if (answer[0] + answer[1] == 8)
            return true;
        amountOfColors[currentLine][0] = answer[0];
        amountOfColors[currentLine][1] = answer[1];
        return false;
    }
}