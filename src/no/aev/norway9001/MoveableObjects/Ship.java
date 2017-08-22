package no.aev.norway9001.MoveableObjects;

import javafx.collections.ObservableList;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 * Created by Asgeir on 06.06.2017.
 */
public abstract class Ship extends ImageView
{

    protected boolean alive;
    private double speed;
    private int currentHP;
    private int maxHP;
    private Image deathExplosion;

    public Ship(double initialX, double initialY, double speed, int maxHP)
    {
        setX(initialX);
        setY(initialY);
        this.speed = speed;
        this.maxHP = maxHP;
        this.currentHP = maxHP;
        this.alive = true;
    }

    public double getSpeed()
    {
        return speed;
    }

    public void setSpeed(double speed)
    {
        this.speed = speed;
    }

    public int getCurrentHP()
    {
        return currentHP;
    }

    public void setHP(int newHP)
    {
        if (newHP > maxHP)
        {
            currentHP = maxHP;
        }
        else
        {
            currentHP = newHP;
        }
    }

    /**
     * Method called when a ship is hit and takes damage.
     *
     * @param damage The incoming amount of damage.
     * @return The ship's HP after taking damage.
     */
    public int takeDamage(int damage)
    {
        currentHP = currentHP - damage;
        if (currentHP <= 1)
            die();
        return currentHP;
    }

    /**
     * Method called to check if a ship is alive.
     *
     * @return true if the ship is alive, false if not.
     */
    public boolean isAlive()
    {
        return alive;
    }

    /**
     * Method for shooting.
     *
     * @param bulletList The list to add the fired bullet to.
     */
    public abstract void shoot(ObservableList<Bullet> bulletList);

    /**
     * Method called when a ship's HP reaches 0 or less.
     */
    public abstract void die();

    public void setDeathExplosion(Image img)
    {
        deathExplosion = img;
    }

    public Image getDeathExplosion()
    {
        return deathExplosion;
    }
}
