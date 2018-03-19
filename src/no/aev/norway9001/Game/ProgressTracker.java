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
public final class ProgressTracker
{

    public static ProgressTracker instance;
    private Debugger debugger = Debugger.getInstance();

    private ProgressTracker()
    {

    }

    public static ProgressTracker getInstance()
    {
        if (instance == null)
        {
            instance = new ProgressTracker();
        }

        return instance;
    }

    /**
     * Get the player's progress from the external file 'norway.9001'
     * or create said file if it doesn't exist.
     *
     * @return A LevelTracker object containing the saved state of the game.
     */
    public LevelTracker getProgress()
    {
        LevelTracker progress = LevelTracker.getInstance();

        try (BufferedReader br = new BufferedReader(
                new InputStreamReader(new FileInputStream("norway.9001"))))
        {
            String line;
            line = br.readLine();
            String input[] = line.split("=");
            debugger.printDebugInfo(this.getClass(), "Reading save file...");
            progress.setCurrentLevel(Integer.parseInt(input[1]));
            debugger.printDebugInfo(this.getClass(), "Setting starting level to: " + progress.getCurrentLevelAsString());
        }
        catch (IOException outerError)
        {
            try
            {
                debugger.printDebugInfo(this.getClass(), "Corrupt or non-existent save file. Creating new one.");
                PrintWriter out = new PrintWriter("norway.9001");
                out.println("CURRENT_LEVEL=1");
            }
            catch (FileNotFoundException innerError)
            {
                debugger.printDebugInfo(this.getClass(), "Unable to read save file. Check file and/or folder permissions.");
            }
        }
        return progress;
    }

    public void setProgress(LevelTracker progress)
    {
        try (FileWriter output = new FileWriter("norway.9001", false))
        {
            debugger.printDebugInfo(this.getClass(), "Writing save file...");
            debugger.printDebugInfo(this.getClass(), "Saving progress at level " + progress.getCurrentLevel());
            output.write("CURRENT_LEVEL=" + progress.getCurrentLevelAsString());
        }
        catch (IOException ioe)
        {
            debugger.printDebugInfo(this.getClass(), "Unable to write save file. Check file and/or folder permissions.");
        }
    }
}
