package no.aev.norway9001.MoveableObjects.ShipTypes;

import javafx.collections.ObservableList;
import javafx.scene.image.Image;
import no.aev.norway9001.MoveableObjects.Bullet;
import no.aev.norway9001.MoveableObjects.BulletTypes.OrangeBullet;
import no.aev.norway9001.MoveableObjects.Enemy;

import java.util.Random;

/**
 * A flying saucer enemy in the Norway 9001 game.
 * Flying saucers move up and down in a zig-zag pattern.
 *
 * Created by Asgeir on 12.07.2017.
 */
public class FlyingSaucer extends Enemy
{
    private static final int SPEED = 2;
    private static final int MAX_HP = 20;
    private static final int POINTS = 20;
    private static final int COOLDOWN = 200;

    private boolean movingUp = true;
    private int counter = 0;
    private static final int TRAVEL_TIME = 200; // measured in ticks

    public FlyingSaucer()
    {
        super(0, 0, SPEED, MAX_HP, POINTS, COOLDOWN);
        setupFlyingSaucer();
    }

    public FlyingSaucer(double initialX, double initialY)
    {
        super(initialX, initialY, SPEED, MAX_HP, POINTS, COOLDOWN);
        setupFlyingSaucer();
    }

    private void setupFlyingSaucer()
    {
        this.setImage(new Image("ships/flyingSaucer.png", 50, 50, true, true));
        Random rng = new Random();
        counter = rng.nextInt(TRAVEL_TIME);
        setShotCooldown(counter);
    }

    @Override
    public void shoot(ObservableList<Bullet> bulletList)
    {
        if (getShotCooldown() <= 0)
        {
            Bullet newBullet = new OrangeBullet(getX(), getY() + 15);
            bulletList.add(newBullet);
            setShotCooldown(COOLDOWN);
        }
        else
            setShotCooldown(getShotCooldown() - 1);
    }

    @Override
    public void move()
    {
        setX(getX() - getSpeed());

        if (movingUp)
        {
            setY(getY() + getSpeed());
            counter++;
        }
        else
        {
            setY(getY() - getSpeed());
            counter++;
        }

        if (counter > TRAVEL_TIME)
        {
            counter = 0;
            movingUp = !movingUp;
        }
    }
}
