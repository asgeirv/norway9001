package no.aev.norway9001.Game;

import no.aev.norway9001.MoveableObjects.Enemy;
import no.aev.norway9001.MoveableObjects.Powerup;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.util.ArrayList;
import java.util.List;

/**
 * Class representing a level in the Norway 9001 game.
 * A level consists of one or more waves of enemy ships.
 * A level also has a background image and a set of background objects. These are non-interactable.
 * A background object can be a planet, an asteroid, space junk, etc.
 * Created by Asgeir on 09.07.2017.
 */
public class Level
{

    private String desc;
    private int duration = 0; //measured in ticks
    private Image bg;
    private ArrayList<ImageView> bgObjs = new ArrayList<>();
    private ArrayList<Wave> waves = new ArrayList<>();
    private ArrayList<PowerupWave> powerupWaves = new ArrayList<>();

    public Level(String desc, Image bg)
    {
        this.desc = desc;
        this.bg = bg;
    }

    /**
     * Get the level description.
     *
     * @return A String containing the description of the level.
     */
    public String getDesc()
    {
        return desc;
    }

    /**
     * Adds a wave to the level.
     *
     * @param wave The wave to add to the level.
     */
    public void addWave(Wave wave)
    {
        waves.add(wave);
    }

    /**
     * Adds a wave to the level.
     *
     * @param shipType The type of ship to add.
     * @param numShips The number of ships to add.
     * @param delay    Number of ticks which should pass since the previous wave before the current one spawns.
     */
    public void addWave(Class<? extends Enemy> shipType, int numShips, int delay)
    {
        duration = duration + delay;
        Wave wave = new Wave(duration);
        try
        {
            for (int i = 0; i < numShips; i++)
                wave.addShip(shipType.newInstance());
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        waves.add(wave);
    }

    public void addPowerups(Class<? extends Powerup> powerupType, int numPowerups, int time)
    {
        PowerupWave powerupWave = new PowerupWave(time);
        try
        {
            for (int i = 0; i < numPowerups; i++)
                powerupWave.addPowerup(powerupType.newInstance());
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        powerupWaves.add(powerupWave);
    }

    /**
     * Adds several waves to a level.
     *
     * @param wavesToAdd A list of waves to add to the level.
     */
    public void addWaves(List<Wave> wavesToAdd)
    {
        waves.addAll(wavesToAdd);
    }

    /**
     * Get the wave with the specified number.
     *
     * @param waveNum The number of the wave.
     * @return The wave with the specified number.
     */
    public Wave getWave(int waveNum)
    {
        return waves.get(waveNum);
    }

    public PowerupWave getPowerupWave(int waveNum)
    {
        return powerupWaves.get(waveNum);
    }

    /**
     * Get all the waves in the level.
     *
     * @return An ArrayList of all the waves in the level.
     */
    public ArrayList<Wave> getWaves()
    {
        return waves;
    }

    public ArrayList<PowerupWave> getPowerupWaves()
    {
        return powerupWaves;
    }

    /**
     * Get the background image of the level.
     *
     * @return
     */
    public Image getBgImg()
    {
        return bg;
    }

    /**
     * Get the background object images of the level.
     *
     * @return An ArrayList of all the background object images.
     */
    public ArrayList<ImageView> getBgObjs()
    {
        return bgObjs;
    }

    /**
     * Add a background object.
     *
     * @param img An image to add as background object.
     */
    public void addBgObj(ImageView img)
    {
        bgObjs.add(img);
    }

    public int getNumWaves()
    {
        return waves.size();
    }

    public int getNumPowerupWaves()
    {
        return powerupWaves.size();
    }

    public void clear()
    {
        waves.clear();
        powerupWaves.clear();
        duration = 0;
    }
}
