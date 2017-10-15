package no.aev.norway9001.Game;

/**
 * Created by Asgeir on 13.07.2017.
 */
public final class LevelTracker
{

    public static final LevelTracker INSTANCE = new LevelTracker();
    private int currentLevel = 1;

    private LevelTracker()
    {

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
