package no.aev.norway9001.MoveableObjects.BulletTypes;

import no.aev.norway9001.MoveableObjects.Bullet;
import javafx.scene.image.Image;

/**
 * Created by Asgeir on 12.07.2017.
 */
public class GreenBullet extends Bullet
{
    private static final int DAMAGE = 10;
    private static final double SPEED = 8;

    public GreenBullet()
    {
        setDamage(DAMAGE);
        setxSpeed(SPEED);
        setImage(new Image("bullets/playerBullet.png", 20, 20, true, true));
    }

    public GreenBullet(double initialX, double initialY)
    {
        super(initialX, initialY, SPEED, 0, DAMAGE);
        setImage(new Image("bullets/playerBullet.png", 20, 20, true, true));
    }
}
