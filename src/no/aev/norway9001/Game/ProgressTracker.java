package no.aev.norway9001.Game;

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

    public LevelTracker getProgress()
    {
        LevelTracker progress = new LevelTracker();
        return progress;
    }

    public void setProgress(LevelTracker progress)
    {
        // TODO: Save game state
    }
}
