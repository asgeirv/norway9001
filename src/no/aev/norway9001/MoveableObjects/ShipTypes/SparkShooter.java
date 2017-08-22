package no.aev.norway9001.MoveableObjects.ShipTypes;

import no.aev.norway9001.MoveableObjects.Bullet;
import no.aev.norway9001.MoveableObjects.BulletTypes.Spark;
import no.aev.norway9001.MoveableObjects.Enemy;
import javafx.collections.ObservableList;
import javafx.scene.image.Image;

public class SparkShooter extends Enemy
{

    private static final int SPEED = 1;
    private static final int MAX_HP = 30;
    private static final int POINTS = 15;
    private static final int COOLDOWN = 150;

    private boolean shootingUpwards = false;

    public SparkShooter()
    {
        super(0, 0, SPEED, MAX_HP, POINTS, COOLDOWN);
        setupSparkShooter();
    }

    public SparkShooter(double initialX, double initialY)
    {
        super(initialX, initialY, SPEED, MAX_HP, POINTS, COOLDOWN);
        setupSparkShooter();
    }

    private void setupSparkShooter()
    {
        setImage(new Image("ships/sparkshooter.png", 50, 50, true, true));
    }

    @Override
    public void shoot(ObservableList<Bullet> bulletList)
    {
        if (getShotCooldown() <= 0)
        {
            Bullet newBullet = new Spark(getX(), getY() + 15);
            bulletList.add(newBullet);
            setShotCooldown(COOLDOWN);
            if (shootingUpwards)
                newBullet.setySpeed(-newBullet.getySpeed());
            shootingUpwards = !shootingUpwards;
        }
        else
            setShotCooldown(getShotCooldown() - 1);
    }
}
