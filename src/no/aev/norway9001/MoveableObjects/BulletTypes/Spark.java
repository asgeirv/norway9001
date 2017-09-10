package no.aev.norway9001.MoveableObjects.BulletTypes;

import javafx.scene.transform.Rotate;
import no.aev.norway9001.MoveableObjects.Bullet;
import javafx.scene.image.Image;

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
        //getTransforms().add(new Rotate(0));
    }

    @Override
    public void move()
    {
        super.move();

        setRotate(getRotate() - 50);

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
