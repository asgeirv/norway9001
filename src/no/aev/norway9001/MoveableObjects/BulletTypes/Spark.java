package no.aev.norway9001.MoveableObjects.BulletTypes;

import javafx.scene.image.Image;
import no.aev.norway9001.MoveableObjects.Bullet;

public class Spark extends Bullet
{

    private static final int DAMAGE = 10;
    private static final double X_SPEED = -15;
    private static final double Y_SPEED = -8;
    private static final int INTERVAL = 10;

    private int counter = INTERVAL / 2;

    public Spark(double initialX, double initialY)
    {
        super(initialX, initialY, X_SPEED, Y_SPEED, DAMAGE);
        setImage(new Image("bullets/spark.png", 40, 40, true, false));
    }

    @Override
    public void move()
    {
        super.move();

        if (counter <= INTERVAL)
        {
            counter++;
        }
        else
        {
            setySpeed(-getySpeed());
            counter = 0;
        }
    }
}
