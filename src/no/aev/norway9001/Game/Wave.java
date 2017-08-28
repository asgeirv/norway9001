package no.aev.norway9001.Game;

import no.aev.norway9001.MoveableObjects.Enemy;

import java.util.ArrayList;
import java.util.List;

/**
 * Class representing a wave of enemies in the Norway 9001 game.
 * A wave consists of one or more ships.
 * Created by Asgeir on 09.07.2017.
 */
public class Wave
{

    private ArrayList<Enemy> ships = new ArrayList<>();
    private int time; // in milliseconds

    public Wave(int time)
    {
        this.time = time;
    }

    /**
     * Adds a ship to the wave.
     *
     * @param ship The ship to add.
     */
    public void addShip(Enemy ship)
    {
        ships.add(ship);
    }

    /**
     * Adds ships to the wave.
     *
     * @param shipsToAdd Adds ships to the wave.
     */
    public void addShips(List<Enemy> shipsToAdd)
    {
        ships.addAll(shipsToAdd);
    }

    /**
     * Returns all the ships in the wave.
     *
     * @return An ArrayList of all the ships in the wave.
     */
    public ArrayList<Enemy> getShips()
    {
        return ships;
    }

    /**
     * Find a particular ship in the wave, based upon number.
     *
     * @param shipNum The number of the ship in the wave.
     * @return The specified ship.
     */
    public Enemy getEnemy(int shipNum)
    {
        return ships.get(shipNum);
    }

    /**
     * Get the number of enemies in the wave.
     *
     * @return The number of enemies in the wave.
     */
    public int getNumEnemies()
    {
        return ships.size();
    }

    public int getTime()
    {
        return time;
    }

    public void clear()
    {
        ships.clear();
    }
}
