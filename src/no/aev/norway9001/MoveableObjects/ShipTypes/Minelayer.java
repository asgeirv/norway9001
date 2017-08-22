package no.aev.norway9001.MoveableObjects.ShipTypes;

import no.aev.norway9001.MoveableObjects.Bullet;
import no.aev.norway9001.MoveableObjects.BulletTypes.Mine;
import no.aev.norway9001.MoveableObjects.Enemy;
import javafx.collections.ObservableList;
import javafx.scene.image.Image;

public class Minelayer extends Enemy
{

    private static final double SPEED = 0.8;
    private static final int MAX_HP = 40;
    private static final int POINTS = 20;
    private static final int COOLDOWN = 400;
    private static final double SIZE = 50;

    private boolean movingUp = true;
    private int counter = 0;
    private static final int TRAVEL_TIME = 500; // measured in ticks

    public Minelayer()
    {
        super(0, 0, SPEED, MAX_HP, POINTS, COOLDOWN);
        setImage(new Image("ships/minelayer.png", SIZE, SIZE, true, true));
    }

    public Minelayer(double initialX, double initialY)
    {
        super(initialX, initialY, SPEED, MAX_HP, POINTS, COOLDOWN);
        setImage(new Image("ships/minelayer.png", SIZE, SIZE, true, true));
    }

    @Override
    public void shoot(ObservableList<Bullet> bulletList)
    {
        if (getShotCooldown() <= 0)
        {
            Bullet newBullet = new Mine(getX(), getY() + 15);
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
            toggleDirection();
        }
    }

    public void toggleDirection()
    {
        movingUp = !movingUp;
    }
}
