package no.aev.norway9001.Game;

/**
 * Created by Asgeir on 13.07.2017.
 */
public final class LevelTracker
{

    private static LevelTracker instance;
    private int currentLevel = 1;

    private LevelTracker()
    {

    }

    public static LevelTracker getInstance()
    {
        if (instance == null)
        {
            instance = new LevelTracker();
        }

        return instance;
    }

    public int getCurrentLevel()
    {
        return currentLevel;
    }

    public String getCurrentLevelAsString()
    {
        return String.valueOf(currentLevel);
    }

    public void setCurrentLevel(int currentLevel)
    {
        this.currentLevel = currentLevel;
    }
}
