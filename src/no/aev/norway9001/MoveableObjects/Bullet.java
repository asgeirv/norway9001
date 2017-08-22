package no.aev.norway9001.MoveableObjects;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.util.Duration;

/**
 * Super class for representing bullets in the Norway 9001 game.
 *
 * Created by Asgeir on 09.07.2017.
 */
public abstract class Bullet extends ImageView
{

    private double xSpeed, ySpeed;
    private int damage;

    public Bullet()
    {

    }

    public Bullet(double initialX, double initialY, double xSpeed, double ySpeed, int damage)
    {
        setX(initialX);
        setY(initialY);
        this.xSpeed = xSpeed;
        this.ySpeed = ySpeed;
        this.damage = damage;
    }

    /**
     * Move the bullet.
     */
    public void move()
    {
        setX(getX() + xSpeed);
        setY(getY() + ySpeed);
    }

    /**
     * Sets the speed of the bullet in both X and Y directions.
     * @param newSpeed The new speed.
     */
    public void setSpeed(double newSpeed)
    {
        xSpeed = newSpeed;
        ySpeed = newSpeed;
    }

    public void setxSpeed(double xSpeed)
    {
        this.xSpeed = xSpeed;
    }

    public void setySpeed(double ySpeed)
    {
        this.ySpeed = ySpeed;
    }

    public double getxSpeed()
    {
        return xSpeed;
    }

    public double getySpeed()
    {
        return ySpeed;
    }

    public void setDamage(int newDamage)
    {
        damage = newDamage;
    }

    public void hit()
    {
        setSpeed(0);
        setImage(new Image("effects/asplode.png"));
        setX(getX() - 10);
        setY(getY() - 10);
        setFitWidth(50);
        setFitHeight(50);
        Timeline death = new Timeline(
                new KeyFrame(Duration.millis(500), event -> setImage(null))
        );
        death.setCycleCount(1);
        death.play();
        // TODO: Add code for a cooler death animation
    }

    /**
     * Get the damage that the bullet does.
     * @return The damage of the bullet.
     */
    public int getDamage()
    {
        return damage;
    }
}
