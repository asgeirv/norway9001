package no.aev.norway9001.MoveableObjects.BulletTypes;

import no.aev.norway9001.MoveableObjects.Bullet;
import javafx.scene.image.Image;

public class LaserBlast extends Bullet
{

    private static final int DAMAGE = 40;
    private static final double SPEED = 20;

    public LaserBlast()
    {
        setDamage(DAMAGE);
        setxSpeed(SPEED);
        setImage(new Image("bullets/laser.png"));
    }

    public LaserBlast(double initialX, double initialY)
    {
        super(initialX, initialY, SPEED, 0, DAMAGE);
        setImage(new Image("bullets/laser.png"));
    }
}
