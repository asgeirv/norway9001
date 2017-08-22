package no.aev.norway9001.MoveableObjects.BulletTypes;

import no.aev.norway9001.MoveableObjects.Bullet;
import javafx.scene.image.Image;

public class Mine extends Bullet
{

    private static final int DAMAGE = 20;
    private static final double SPEED = -0.2;

    public Mine(double initialX, double initialY)
    {
        super(initialX, initialY, SPEED, 0, DAMAGE);
        setImage(new Image("bullets/mine.png", 30, 30, true, true));
    }
}
