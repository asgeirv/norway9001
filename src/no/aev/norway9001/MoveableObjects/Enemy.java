package no.aev.norway9001.MoveableObjects;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.collections.ObservableList;
import javafx.scene.image.Image;
import javafx.util.Duration;

/**
 * Created by Asgeir on 03.06.2017.
 */
public abstract class Enemy extends Ship
{

    private int points;
    private int shotCooldown;

    public Enemy()
    {
        super(0, 0, 5, 20);
    }

    public Enemy(double initialX, double initialY, double speed, int maxHP, int points, int shotCooldown)
    {
        super(initialX, initialY, speed, maxHP);
        this.points = points;
        this.shotCooldown = shotCooldown;
        setDeathExplosion(new Image("effects/asplode.png"));
    }

    @Override
    public abstract void shoot(ObservableList<Bullet> bulletList);

    @Override
    public void die()
    {
        alive = false;
        setSpeed(0);
        setImage(getDeathExplosion());
        setX(getX() - 20);
        setY(getY() - 20);
        setFitWidth(125);
        setFitHeight(125);
        Timeline death = new Timeline(
                new KeyFrame(Duration.millis(500), event -> setImage(null))
        );
        death.setCycleCount(1);
        death.play();
        // TODO: Add code for a cooler death animation
    }

    /**
     * Get the amount of points the enemy ship is worth.
     *
     * @return The amount of points the enemy ship is worth.
     */
    public int getPoints()
    {
        return points;
    }

    /**
     * Moves the enemy.
     */
    public void move()
    {
        setX(getX() - getSpeed());
    }

    public int getShotCooldown()
    {
        return shotCooldown;
    }

    public void setShotCooldown(int shotCooldown)
    {
        this.shotCooldown = shotCooldown;
    }
}
