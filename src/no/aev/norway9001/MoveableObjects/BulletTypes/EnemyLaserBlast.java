package no.aev.norway9001.MoveableObjects.BulletTypes;

import no.aev.norway9001.MoveableObjects.Bullet;
import javafx.scene.image.Image;

public class EnemyLaserBlast extends Bullet
{
    private static final int DAMAGE = 20;
    private static final double SPEED = -20;

    public EnemyLaserBlast()
    {
        setDamage(DAMAGE);
        setxSpeed(SPEED);
        setImage(new Image("bullets/enemylaser.png"));
    }

    public EnemyLaserBlast(double initialX, double initialY)
    {
        super(initialX, initialY, SPEED, 0, DAMAGE);
        setImage(new Image("bullets/enemylaser.png"));
    }
}
