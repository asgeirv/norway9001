package no.aev.norway9001.MoveableObjects;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import no.aev.norway9001.MoveableObjects.ShipTypes.Player;

public abstract class Powerup extends ImageView
{

    private double xSpeed;
    private double ySpeed;
    private static final double DEFAULT_X_SPEED = 0;
    private static final double DEFAULT_Y_SPEED = 2;

    public Powerup()
    {
        xSpeed = DEFAULT_X_SPEED;
        ySpeed = DEFAULT_Y_SPEED;
    }

    public Powerup(double initialX, double initialY)
    {
        setX(initialX);
        setY(initialY);
    }

    public Powerup(Image img)
    {
        setImage(img);
        xSpeed = DEFAULT_X_SPEED;
        ySpeed = DEFAULT_Y_SPEED;
    }

    public Powerup(Image img, double speed)
    {
        setImage(img);
        xSpeed = speed;
        ySpeed = speed;
    }

    public Powerup(Image img, double xSpeed, double ySpeed)
    {
        setImage(img);
        this.xSpeed = xSpeed;
        this.ySpeed = ySpeed;
    }

    public void move()
    {
        setX(getX() + xSpeed);
        setY(getY() + ySpeed);
    }

    public abstract void hit(Player player);

    public void setxSpeed(double xSpeed)
    {
        this.xSpeed = xSpeed;
    }

    public void setySpeed(double ySpeed)
    {
        this.ySpeed = ySpeed;
    }
}
