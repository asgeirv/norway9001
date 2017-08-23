package no.aev.norway9001.Game;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

/**
 * Provides functionality for saving and loading game states from disk.
 *
 * @author Asgeir Vinkenes
 */
public class ProgressTracker
{

    public ProgressTracker()
    {

    }

    /**
     * Get the player's progress from the external file 'norway.9001'
     * or create said file if it doesn't exist.
     *
     * @return A LevelTracker object containing the saved state of the game.
     */
    public LevelTracker getProgress()
    {
        LevelTracker progress = new LevelTracker();

        try (BufferedReader br = new BufferedReader(
                new InputStreamReader(new FileInputStream("norway.9001"))))
        {
            String line;
            line = br.readLine();
            String input[] = line.split("=");
            System.out.println("Reading file.");
            progress.setCurrentLevel(Integer.parseInt(input[1]));
            System.out.println("Setting starting level to: " + progress.getCurrentLevelAsString());
        }
        catch (IOException outerError)
        {
            try
            {
                PrintWriter out = new PrintWriter("norway.9001");
                out.println("CURRENT_LEVEL=1");
            }
            catch (FileNotFoundException innerError)
            {
                innerError.printStackTrace();
            }
        }
        return progress;
    }

    public void setProgress(LevelTracker progress)
    {
        try (FileWriter output = new FileWriter("norway.9001", false))
        {
            System.out.println("Writing file.");
            System.out.format("Saving progress at level %d.", progress.getCurrentLevel());
            output.write("CURRENT_LEVEL=" + progress.getCurrentLevelAsString());
        }
        catch (IOException ioe)
        {
            ioe.printStackTrace();
        }
    }
}
