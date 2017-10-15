package no.aev.norway9001.MoveableObjects.BulletTypes;

import javafx.scene.image.Image;
import no.aev.norway9001.MoveableObjects.Bullet;

public class Missile extends Bullet
{
    private static final int DAMAGE = 10;
    private static final double SPEED = -12;

    public Missile(double initialX, double initialY)
    {
        super(initialX, initialY, SPEED, 0, DAMAGE);
        setImage(new Image("ships/triangle.png", 25, 25, true, true));
    }
}
