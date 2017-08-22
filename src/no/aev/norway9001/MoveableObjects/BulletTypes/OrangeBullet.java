package no.aev.norway9001.MoveableObjects.BulletTypes;

import no.aev.norway9001.MoveableObjects.Bullet;
import javafx.scene.image.Image;

/**
 * Created by Asgeir on 12.07.2017.
 */
public class OrangeBullet extends Bullet
{

    private static final int DAMAGE = 5;
    private static final double SPEED = -8;

    public OrangeBullet(double initialX, double initialY)
    {
        super(initialX, initialY, SPEED, 0, DAMAGE);
        setImage(new Image("bullets/enemyBullet.png", 20, 20, true, true));
    }
}
