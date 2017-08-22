package no.aev.norway9001.Game;

import no.aev.norway9001.MoveableObjects.Powerup;

import java.util.ArrayList;

public class PowerupWave
{

    private ArrayList<Powerup> powerups = new ArrayList<>();
    private int time;

    public PowerupWave(int time)
    {
        this.time = time;
    }

    public void addPowerup(Powerup powerup)
    {
        powerups.add(powerup);
    }

    public ArrayList<Powerup> getPowerups()
    {
        return powerups;
    }

    public int getTime()
    {
        return time;
    }
}
