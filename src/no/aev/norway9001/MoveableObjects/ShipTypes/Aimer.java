package no.aev.norway9001.MoveableObjects.ShipTypes;

import javafx.collections.ObservableList;
import javafx.scene.image.Image;
import no.aev.norway9001.MoveableObjects.Bullet;
import no.aev.norway9001.MoveableObjects.BulletTypes.OrangeBullet;
import no.aev.norway9001.MoveableObjects.Enemy;

/**
 * Created by Asgeir on 09.07.2017.
 */
public class Aimer extends Enemy
{

    private static final int SPEED = 1;
    private static final int MAX_HP = 40;
    private static final int POINTS = 15;
    private static final int COOLDOWN = 200;
    private int counter = 4;
    private Player player;

    public Aimer()
    {
        super(0, 0, SPEED, MAX_HP, POINTS, COOLDOWN);
        setImage(new Image("ships/aimer.png", 50, 50, true, true));
    }

    public Aimer(double initialX, double initialY)
    {
        super(initialX, initialY, SPEED, MAX_HP, POINTS, COOLDOWN);
        setImage(new Image("ships/aimer.png", 50, 50, true, true));
    }

    @Override
    public void shoot(ObservableList<Bullet> bulletList)
    {
        if (getShotCooldown() <= 0)
        {
            Bullet newBullet = new OrangeBullet(getX(), getY() + 15);
            double bulletSpeed = newBullet.getxSpeed();

            // Calculate distances between ship and player
            double xDist = getX() - player.getX();
            double yDist = getY() - player.getY();
            double dist = Math.sqrt(xDist * xDist + yDist * yDist);

            // Calculate sine and cosine of the angle between ship and player
            double sin = yDist / dist;
            double cos = xDist / dist;

            // Calculate x and y speeds
            newBullet.setxSpeed(bulletSpeed * cos);
            newBullet.setySpeed(bulletSpeed * sin);

            bulletList.add(newBullet);
            if (counter > 0)
            {
                setShotCooldown(20);
                counter--;
            }
            else
            {
                setShotCooldown(COOLDOWN);
                counter = 4;
            }
        }
        else
            setShotCooldown(getShotCooldown() - 1);
    }

    public void setPlayer(Player player)
    {
        this.player = player;
    }
}
